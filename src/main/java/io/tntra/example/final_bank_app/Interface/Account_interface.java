package io.tntra.example.final_bank_app.Interface;

import io.tntra.example.final_bank_app.Exception.InsufficientAmount;
import io.tntra.example.final_bank_app.Model.Account;

import java.math.BigDecimal;
import java.util.HashMap;

public interface Account_interface {

    void create_account(Account acc);
    HashMap<String, Account> get_account();
    Account get_Owner(Account acc);
    BigDecimal get_Balance(Account account);
    BigDecimal deposit(String owner ,BigDecimal amount);
    BigDecimal withdraw(String owner,BigDecimal amount ) throws InsufficientAmount;

}
