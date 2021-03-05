package org.shdennlin.cms.service;

import org.shdennlin.cms.exception.NotFoundException;
import org.shdennlin.cms.model.Account;
import org.shdennlin.cms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    /**
     * Get Account
     *
     * @param accountId
     * @return
     */
    public Account getAccount(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundException("Can't find account."));
    }


    /**
     * Create Account
     *
     * @param request
     * @return
     */
    public Account createAccount(Account request) {
        Account account = new Account();
        account.setUsername(request.getUsername());
        account.setPassword(request.getPassword());

        return accountRepository.save(account);
    }

    /**
     * Replace Account
     *
     * @param id
     * @param request
     * @return
     */
    public Account replaceAccount(Long id, Account request) {
        Account oldAccount = getAccount(id);

        Account account = new Account();
        account.setId(oldAccount.getId());
        account.setUsername(request.getUsername());
        account.setPassword(request.getPassword());

        return accountRepository.save(account);
    }


    /**
     * Delete Account
     *
     * @param accountId
     */
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }

}