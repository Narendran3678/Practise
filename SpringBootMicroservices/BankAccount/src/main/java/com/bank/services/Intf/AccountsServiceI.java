package com.bank.services.Intf;
import com.bank.dto.exception.entity.AccountsDto;

import javax.management.relation.RelationServiceNotRegisteredException;
import java.util.List;
public interface AccountsServiceI {
    public List<AccountsDto> findAll();
    public AccountsDto findById(Long CustomerId) throws RelationServiceNotRegisteredException;
    public AccountsDto persist(AccountsDto dto);
    public Boolean delete(Long customerId);
}
