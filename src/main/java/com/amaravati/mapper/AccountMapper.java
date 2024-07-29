package com.amaravati.mapper;

import com.amaravati.dto.AccountDto;
import com.amaravati.entity.Account;

public class AccountMapper {
    public static Account mapTOAccount(AccountDto accountDto){
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountholdername(),
                accountDto.getBalance()
        );
        return account;
    }
    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto=new AccountDto(
                account.getId(),
                account.getAccountholdername(),
                account.getBalance()

        );
        return accountDto;
    }
}
