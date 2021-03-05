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
     * @param requestAccount
     * @return
     */
    public Account createAccount(Account requestAccount) {
        Account account = new Account();
        account.setUsername(requestAccount.getUsername());
        account.setPassword(requestAccount.getPassword());

        return accountRepository.save(account);
    }


    /**
     * Update Account Info
     *
     * @param accountId
     * @param username
     * @param password
     * @return
     */
/*
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, readOnly = false)
    public boolean updateAccount(Long accountId, String username, String password) {
        if (accountId == null || StringUtils.isEmpty(username)) {
            return false;
        }

        Account account = accountRepository.findById(accountId);
        if (account == null) {
            return false;
        }

        account.setUsername(username);
        account.setPassword(password);
        return accountRepository.save(account) != null;
    }
*/

/**
 * Delete Account
 *
 * @param accountId
 * @return
 */
/*
    public boolean deleteAccount(Long accountId) {
        if (accountId == null) {
            return false;
        }

        Account account = accountRepository.findById(accountId);
        if (account == null) {
            return false;
        }
        accountRepository.delete(account);
        return true;
    }
*/

}