package io.tntra.example.final_bank_app.Controller;

import io.tntra.example.final_bank_app.Exception.InsufficientAmount;
import io.tntra.example.final_bank_app.Model.Account;
import io.tntra.example.final_bank_app.Services.ICICI_Services;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class ICICI_Controller {
    ICICI_Services icici_services;
    public ICICI_Controller(ICICI_Services icici_services) {
        this.icici_services = icici_services;
    }

    @PostMapping  (value = "/account")
    public ResponseEntity<Object> create_account(@RequestBody Account account){
       icici_services.create_account(account);
        return new ResponseEntity<>("Account created succesfully!!!", HttpStatus.CREATED);
    }

    @GetMapping(value = "/account")
    public ResponseEntity<Object> get_account(){
        return new ResponseEntity<>(icici_services.get_account(),HttpStatus.OK);
    }

    @RequestMapping(value = "/account/{owner}")
    public ResponseEntity<Object> getowner(Account account){
        return new ResponseEntity<>(icici_services.get_Owner(account), HttpStatus.OK);
    }

    @GetMapping("/account/{owner}/balance")
    public ResponseEntity<Object> getbalance(Account account){
        return new ResponseEntity<>(icici_services.get_Balance(account), HttpStatus.OK);
    }

    @PatchMapping(value = "/account/{owner}/{amount}/deposit")
    public ResponseEntity<Object> deposit( @PathVariable String owner , @PathVariable BigDecimal amount , Account account){
        return new ResponseEntity<>("Deposited "+amount+" to "+owner+" account and total balance is "+icici_services.deposit(owner ,amount), HttpStatus.OK);
    }

    @PatchMapping(value = "/account/{owner}/{amount}/withdraw")
    public ResponseEntity<Object> withdraw(@PathVariable String owner, @PathVariable BigDecimal amount , Account account) throws InsufficientAmount {
        try{
        return new ResponseEntity<>("Withdraw "+amount+" from "+owner+" account and remaining balance is "+icici_services.withdraw(owner ,amount), HttpStatus.OK);}
        catch (InsufficientAmount e){
            return new ResponseEntity<>("Not sufficient amount to transfer", HttpStatus.OK);}

    }
    }

