package cl.goviedo.securitybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceRestController {

    @GetMapping("/myBalance")
    public String getBalanceDetails() {
        return "balance de la base de datos";
    }
}
