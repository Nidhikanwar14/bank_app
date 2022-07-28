package io.tntra.example.final_bank_app.Model;

import io.tntra.example.final_bank_app.Enum.Account_enum;
import io.tntra.example.final_bank_app.Exception.InsufficientAmount;

import java.math.BigDecimal;

public class Account {


    private String owner;
    private  BigDecimal balance ;
    private BigDecimal Overdraft = BigDecimal.valueOf(0);
    private BigDecimal min_balance = BigDecimal.valueOf(0);
    private Account_enum acc_type;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public  BigDecimal getBalance() {
        return balance;
    }

    public  void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getOverdraft() {
        return Overdraft;
    }

    public void setOverdraft(BigDecimal overdraft) {
        Overdraft = overdraft;
    }
    public BigDecimal getMin_balance() {
        return min_balance;
    }

    public void setMin_balance(BigDecimal min_balance) {
        try {
            if (balance.compareTo(this.min_balance) >= 0) {
                this.balance = balance;
            } else {
                throw new InsufficientAmount("Insufficient balance!");
            }
        }
        catch(InsufficientAmount e){
            e.getMessage();
        }
    }

    public Account_enum getAcc_type() {
        return acc_type;
    }

    public void setAcc_type(String text) {
        this.acc_type = Account_enum.compare(text);
    }

}
