package com.bank.services.Intf;
import com.bank.dto.exception.entity.AccountsDto;

import java.util.List;
public interface AccountsServiceI {
    public List<AccountsDto> findAll();
    public AccountsDto findById(Long CustomerId);
    public AccountsDto persist(AccountsDto dto);
    public Boolean delete(Long customerId);
}
