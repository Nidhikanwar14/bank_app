package io.tntra.example.final_bank_app.Services;

import io.tntra.example.final_bank_app.Enum.Account_enum;
import io.tntra.example.final_bank_app.Exception.InsufficientAmount;
import io.tntra.example.final_bank_app.Interface.Account_interface;
import io.tntra.example.final_bank_app.Model.Account;

import java.math.BigDecimal;
import java.util.HashMap;

public abstract class Accounts_Abstract implements Account_interface {
    private static HashMap<String, Account> map_icici = new HashMap<>();

    public void create_account(Account acc) {
        map_icici.put(acc.getOwner(), acc);
    }

    public HashMap<String, Account> get_account() {
        return map_icici;
    }

    public Account get_Owner(Account account) {
        return map_icici.get(account.getOwner());
    }

    public BigDecimal get_Balance(Account account) {
        return get_Owner(account).getBalance();
    }

    public BigDecimal deposit(String owner, BigDecimal amount) {
        Account acc = map_icici.get(owner);
        BigDecimal total_amount = acc.getBalance().add(amount);
        acc.setBalance(total_amount);
        return total_amount;
    }

    public BigDecimal withdraw(String owner, BigDecimal amount) throws InsufficientAmount {
        Account acc = map_icici.get(owner);
        BigDecimal total_balance = acc.getBalance();
        if (check_value(owner,amount)) {
            total_balance = total_balance.subtract(amount);
            acc.setBalance(total_balance);
            return total_balance;
        } else {
            throw new InsufficientAmount("Not sufficient amount to withdraw!!");
        }
    }

    public boolean check_value(String owner, BigDecimal amount) {
        Account acc = map_icici.get(owner);
        BigDecimal total_balance = acc.getBalance();
        if (acc.getAcc_type() == Account_enum.CURRENT) {
            acc.setOverdraft(BigDecimal.valueOf(0.3));
            BigDecimal overDraft = acc.getOverdraft().multiply(get_Balance(acc));
            total_balance = total_balance.add(overDraft);
            return total_balance.compareTo(amount) >= 0;
        }
        else{
            return total_balance.compareTo(amount)>=0;
        }
    }
}