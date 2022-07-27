package io.tntra.example.final_bank_app.Controller;

import io.tntra.example.final_bank_app.Model.Account;
import io.tntra.example.final_bank_app.Services.HDFC_Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
