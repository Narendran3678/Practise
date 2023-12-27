package com.bank.mappers;
import com.bank.dto.entity.AccountsDto;
import com.bank.dto.entity.CustomersDto;
import com.bank.entity.Accounts;
import com.bank.entity.Customers;
import java.util.List;

public class CustomersMapper {
    public static Customers dto_To_Customer_Entity(CustomersDto sourceDto, Customers targetEntity) {
        targetEntity.setCustomerName(sourceDto.getCustomerName());
        targetEntity.setMobilenumber(sourceDto.getMobilenumber());
        targetEntity.setEmailId(sourceDto.getEmailId());
        return targetEntity;
    }
    public static CustomersDto entity_To_Customer_Dto( Customers sourceEntity,CustomersDto targetDto) {
        targetDto.setCustomerName(sourceEntity.getCustomerName());
        targetDto.setMobilenumber(sourceEntity.getMobilenumber());
        targetDto.setEmailId(sourceEntity.getEmailId());
        return targetDto;
    }

    public static List<CustomersDto> entityList_To_CustomerList_Dto(List<Customers> sourceEntityList, List<CustomersDto> targetDtoList) {
        for(Customers customers:sourceEntityList) {
            CustomersDto targetDto = new CustomersDto();
            targetDto.setCustomerName(customers.getCustomerName());
            targetDto.setMobilenumber(customers.getMobilenumber());
            targetDto.setEmailId(customers.getEmailId());
            targetDtoList.add(targetDto);
        }
        return targetDtoList;
    }

    public static CustomersDto entity_AccountCustomer_Map_To_CustomerDto( Customers sourceCustomerEntity,Accounts embedAccountEntity,CustomersDto targetDto) {
        targetDto.setCustomerName(sourceCustomerEntity.getCustomerName());
        targetDto.setMobilenumber(sourceCustomerEntity.getMobilenumber());
        targetDto.setEmailId(sourceCustomerEntity.getEmailId());
        targetDto.setAccountsDto(AccountsMapper.entity_To_Account_Dto(embedAccountEntity, new AccountsDto()));
        return targetDto;
    }
}
