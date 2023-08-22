package cl.goviedo.securitybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansRestController {

    @GetMapping("/myLoans")
    public String getLoanDetails() {
        return "prestamo de la base de datos";
    }
}
