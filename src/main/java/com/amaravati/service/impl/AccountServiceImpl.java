package com.amaravati.service.impl;

import com.amaravati.dto.AccountDto;
import com.amaravati.entity.Account;
import com.amaravati.mapper.AccountMapper;
import com.amaravati.repository.AccountRepository;
import com.amaravati.service.AccountService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Secured("ROLE_USER")
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper .mapTOAccount(accountDto);
        Account savedAccount =accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

    }
    @Secured("ROLE_USER")
    @Override
    public AccountDto getAccountByID(Long id) {
       Account account= accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
       return AccountMapper.mapToAccountDto(account);

    }
    @Secured("ROLE_ADMIN")
    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account= accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        double total=account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

    }
    @Secured("ROLE_ADMIN")
    @Override
    public void deleteAccount(Long id) {
        Account account= accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        accountRepository.delete(account);

    }



}
