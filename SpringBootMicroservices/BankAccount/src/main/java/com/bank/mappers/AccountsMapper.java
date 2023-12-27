package com.bank.mappers;
import com.bank.dto.entity.AccountsDto;
import com.bank.entity.Accounts;

import java.util.List;

public class AccountsMapper {

    public static Accounts dto_To_Account_Entity(AccountsDto sourceDto, Accounts targetEntity) {
        targetEntity.setAccountnumber(sourceDto.getAccountnumber());
        targetEntity.setAccounttype(sourceDto.getAccounttype());
        targetEntity.setBranchAddress(sourceDto.getBranchAddress());
        targetEntity.setCustomerId(sourceDto.getCustomerId());
        return targetEntity;
    }

    public static AccountsDto entity_To_Account_Dto(Accounts sourceEntity, AccountsDto targetDto) {
        targetDto.setAccountnumber(sourceEntity.getAccountnumber());
        targetDto.setAccounttype(sourceEntity.getAccounttype());
        targetDto.setBranchAddress(sourceEntity.getBranchAddress());
        targetDto.setCustomerId(sourceEntity.getCustomerId());
        return targetDto;
    }

    public static List<AccountsDto> entityList_To_AccountsList_Dto(List<Accounts> sourceEntityList, List<AccountsDto> targetDtoList) {
        for(Accounts accounts:sourceEntityList) {
            AccountsDto targetDto = new AccountsDto();
            targetDto.setAccountnumber(accounts.getAccountnumber());
            targetDto.setAccounttype(accounts.getAccounttype());
            targetDto.setBranchAddress(accounts.getBranchAddress());
            targetDto.setCustomerId(accounts.getCustomerId());
            targetDtoList.add(targetDto);
        }
        return targetDtoList;
    }
}
