package com.bank.mappers;
import com.bank.dto.entity.AccountsDto;
import com.bank.dto.entity.CustomersDto;
import com.bank.entity.Accounts;
import com.bank.entity.Customers;
import java.util.List;
import java.util.Objects;

public class CustomersMapper {
    public static Customers dto_To_Customer_Entity(CustomersDto sourceDto, Customers targetEntity) {
        targetEntity.setCustomerId(sourceDto.getCustomerId());
        targetEntity.setCustomerName(sourceDto.getCustomerName());
        targetEntity.setMobilenumber(sourceDto.getMobilenumber());
        targetEntity.setEmailId(sourceDto.getEmailId());
        return targetEntity;
    }
    public static CustomersDto entity_To_Customer_Dto( Customers sourceEntity,CustomersDto targetDto) {
        targetDto.setCustomerId(sourceEntity.getCustomerId());
        targetDto.setCustomerName(sourceEntity.getCustomerName());
        targetDto.setMobilenumber(sourceEntity.getMobilenumber());
        targetDto.setEmailId(sourceEntity.getEmailId());
        return targetDto;
    }

    public static List<CustomersDto> entityList_To_CustomerList_Dto(List<Customers> sourceEntityList, List<CustomersDto> targetDtoList) {
        for(Customers customers:sourceEntityList) {
            CustomersDto targetDto = new CustomersDto();
            targetDto.setCustomerId(customers.getCustomerId());
            targetDto.setCustomerName(customers.getCustomerName());
            targetDto.setMobilenumber(customers.getMobilenumber());
            targetDto.setEmailId(customers.getEmailId());
            targetDtoList.add(targetDto);
        }
        return targetDtoList;
    }

    public static CustomersDto entity_AccountCustomer_Map_To_CustomerDto( Customers sourceCustomerEntity,Accounts embedAccountEntity,CustomersDto targetDto) {
        targetDto.setCustomerId(sourceCustomerEntity.getCustomerId());
        targetDto.setCustomerName(sourceCustomerEntity.getCustomerName());
        targetDto.setMobilenumber(sourceCustomerEntity.getMobilenumber());
        targetDto.setEmailId(sourceCustomerEntity.getEmailId());
        targetDto.setAccounts(AccountsMapper.entity_To_Account_Dto(embedAccountEntity, new AccountsDto()));
        return targetDto;
    }

    public static List<CustomersDto> list_customers_account_dto_map(List<CustomersDto> customersList,List<AccountsDto> accountsList) {
        for(CustomersDto customers:customersList) {
            Long customerId = customers.getCustomerId();
            for(AccountsDto accounts:accountsList) {
                if(Objects.equals(customers.getCustomerId(), accounts.getCustomerId())) {
                    customers.setAccounts(accounts);
                }
            }
        }
        return customersList;
    }
}
