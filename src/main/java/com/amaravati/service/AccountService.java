package com.amaravati.service;

import com.amaravati.dto.AccountDto;
import com.amaravati.entity.Account;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountByID(Long  id);
    AccountDto deposit (Long id, double amount);
    void deleteAccount (Long id);


}
