package io.tntra.example.final_bank_app.Services;

import io.tntra.example.final_bank_app.Interface.Account_interface;
import io.tntra.example.final_bank_app.Model.Account;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;

@Service
public class ICICI_Services extends Accounts_Abstract implements Account_interface {

    @Override
    public void create_account(Account acc) {
        super.create_account(acc);
    }

    @Override
    public HashMap<String, Account> get_account() {
         return super.get_account();
//        return null;
//        return null;
    }

    @Override
    public Account get_Owner(Account acc){
       return super.get_Owner(acc);
    }
    @Override
    public BigDecimal get_Balance(Account account) {
        return super.get_Balance(account);
    }

    @Override
    public BigDecimal deposit(String owner , BigDecimal amount){
        return super.deposit(owner ,amount);
    }


}
