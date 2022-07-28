package io.tntra.example.final_bank_app.Controller;

import io.tntra.example.final_bank_app.Exception.InsufficientAmount;
import io.tntra.example.final_bank_app.Model.Account;
import io.tntra.example.final_bank_app.Services.HDFC_Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class HDFC_Controller {
    HDFC_Service hdfc_service;

    public HDFC_Controller(HDFC_Service hdfc_service) {
        this.hdfc_service = hdfc_service;
    }

    @PostMapping(value = "/account_hdfc")
    public ResponseEntity<Object> create_account(@RequestBody Account account) {
        hdfc_service.create_account(account);
        return new ResponseEntity<>("Account created succesfully!!!", HttpStatus.CREATED);
    }

    @GetMapping(value = "/account_hdfc")
    public ResponseEntity<Object> get_account() {
        return new ResponseEntity<>(hdfc_service.get_account(), HttpStatus.OK);
    }

    @RequestMapping(value = "/account_hdfc/{owner}")
    public ResponseEntity<Object> getowner(Account account){
        return new ResponseEntity<>(hdfc_service.get_Owner(account), HttpStatus.OK);
    }

    @GetMapping("/account_hdfc/{owner}/balance")
    public ResponseEntity<Object> getbalance(Account account){
        return new ResponseEntity<>(hdfc_service.get_Balance(account), HttpStatus.OK);
    }

    @PatchMapping(value = "/account_hdfc/{owner}/{amount}/deposit")
    public ResponseEntity<Object> deposit(@PathVariable String owner , @PathVariable BigDecimal amount , Account account){
        return new ResponseEntity<>("Deposited "+amount+" to "+owner+" account and total balance is "+hdfc_service.deposit(owner ,amount), HttpStatus.OK);
    }

    @PatchMapping(value = "/account_hdfc/{owner}/{amount}/withdraw")
    public ResponseEntity<Object> withdraw(@PathVariable String owner, @PathVariable BigDecimal amount , Account account) throws InsufficientAmount {
        try{
            return new ResponseEntity<>("Withdraw "+amount+" from "+owner+" account and remaining balance is "+hdfc_service.withdraw(owner ,amount), HttpStatus.OK);}
        catch (InsufficientAmount e){
            return new ResponseEntity<>("Not sufficient amount to transfer", HttpStatus.OK);}

    }
}
