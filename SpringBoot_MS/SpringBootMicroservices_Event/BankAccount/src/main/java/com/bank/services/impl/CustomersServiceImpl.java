package com.bank.services.impl;
import com.bank.config.message.AccountMsgDto;
import com.bank.constant.BankConstants;
import com.bank.dto.entity.AccountsDto;
import com.bank.dto.entity.CustomersDto;
import com.bank.entity.Accounts;
import com.bank.entity.Customers;
import com.bank.exceptionhandler.ResourceNotFoundException;
import com.bank.mappers.CustomersMapper;
import com.bank.repository.AccountsRepository;
import com.bank.repository.CustomersRepository;
import com.bank.services.Intf.CustomersServiceI;
import com.bank.utils.Utility;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomersServiceImpl implements CustomersServiceI {
    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private AccountsServiceImpl accountsServiceImpl;

    @Autowired
    private StreamBridge streamBridge;

    @Value("${branch_address}")
    String branchAddress;

    @Value("${customer.account.fetchpref}")
    Boolean customerAccountFetchPref;
    @Override
    public List<CustomersDto> findAll() {
        List<Customers> customersList = customersRepository.findAll();
        if(!customersList.isEmpty()) {
            List<CustomersDto> customerDtoList= CustomersMapper.entityList_To_CustomerList_Dto(customersList, new ArrayList<CustomersDto>());
            if(customerAccountFetchPref) {
                List<AccountsDto> accountsAtoList = accountsServiceImpl.findAll();
                return CustomersMapper.list_customers_account_dto_map(customerDtoList,accountsAtoList);
            }
            return customerDtoList;
        }
        else
            return new ArrayList<>();
    }

    @Override
    public CustomersDto findById(Long customerId)   {
        System.out.println("Customer Service findById Called");
        Optional<Customers> customer = customersRepository.findById(customerId);
        if(customer.isPresent())
            return CustomersMapper.entity_To_Customer_Dto(customer.get(), new CustomersDto());
        else {
            throw new ResourceNotFoundException("Customer ["+customerId+"] not found");
        }
    }
    @Transactional
    @Override
    public CustomersDto persist(CustomersDto customersDto) {
        Customers customers = CustomersMapper.dto_To_Customer_Entity(customersDto,new Customers());
        customers.setCreatedBy("ADMIN");
        customers.setModifiedBy("ADMIN");
        customersRepository.save(customers);
        Accounts accounts = new Accounts();
        accounts.setCustomerId(customers.getCustomerId());
        accounts.setAccountType(BankConstants.ACCOUNT_TYPE.SAVINGS);
        accounts.setAccountnumber(Utility.getRandomAccountNumber());
        accounts.setBranchAddress(branchAddress);
        accounts.setCreatedBy("ADMIN");
        accounts.setModifiedBy("ADMIN");
        accountsRepository.save(accounts);
        sendCommunication(accounts,customers);
        return CustomersMapper.entity_AccountCustomer_Map_To_CustomerDto(customers,accounts,new CustomersDto());
    }
    @Transactional
    @Override
    public Boolean delete(Long customerId) {
        Optional<Accounts> accounts = accountsRepository.findById(customerId);
        if (accounts.isPresent()) {
            accountsRepository.delete(accounts.get());
            Optional<Customers> customers = customersRepository.findById(customerId);
            if (customers.isPresent()) {
                customersRepository.delete(customers.get());
            }
        }
        else {
            throw new ResourceNotFoundException("Customers ["+customerId+"] not found");
        }
        return true;
    }

    @Override
    public CustomersDto findByMobileNumber(String mobileNumber) {
        Optional<Customers> customers = customersRepository.findBymobilenumber(mobileNumber);
        if (customers.isPresent()) {
            return CustomersMapper.entity_To_Customer_Dto(customers.get(),new CustomersDto());
        }
        else {
            throw new ResourceNotFoundException("Mobile Number ["+mobileNumber+"] not found");
        }
    }
    @Override
    public void updateCommunication(String mobileNumber) {
        System.out.println("Updating Communication Customer Service {}"+ mobileNumber);
        Optional<Customers> customers = customersRepository.findBymobilenumber(mobileNumber);
        if (customers.isPresent()) {
            customers.get().setCommunicationSwitch(true);
            customersRepository.save(customers.get());
        }
         else {
            throw new ResourceNotFoundException("Mobile Number ["+mobileNumber+"] not found");
        }
    }
    private void sendCommunication(Accounts account, Customers customer) {
        AccountMsgDto accountMsgDto = new AccountMsgDto(Long.valueOf(account.getAccountnumber()),customer.getCustomerName(),customer.getEmailId(),customer.getMobilenumber());
        System.out.println("Sending Communication request for the details: {}"+ accountMsgDto);
        var result = streamBridge.send(BankConstants.EVENT_EXCHANGE.SENDCOMMUNICATION_OUT_0.getExchangeName(),accountMsgDto);
        System.out.println("Is the Communication request successfully triggered ? : {}"+ result);
    }
}
