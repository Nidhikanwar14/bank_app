package io.tntra.example.final_bank_app.Services;

import io.tntra.example.final_bank_app.Interface.Account_interface;
import io.tntra.example.final_bank_app.Model.Account;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class HDFC_Service extends Accounts_Abstract implements Account_interface {

    @Override
    public void create_account(Account acc) {
        super.create_account(acc);
    }

    @Override
    public HashMap<String, Account> get_account() {
        return super.get_account();
    }
}
