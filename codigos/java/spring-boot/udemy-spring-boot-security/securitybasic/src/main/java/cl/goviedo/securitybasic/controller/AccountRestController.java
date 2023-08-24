package cl.goviedo.securitybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {

    @GetMapping("/myAccount")
    public String getAccountDetails() {
        return "El detalle de las cuentas se encuentran en la base de datos";
    }
}
