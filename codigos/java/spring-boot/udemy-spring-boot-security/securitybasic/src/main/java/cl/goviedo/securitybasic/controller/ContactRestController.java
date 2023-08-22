package cl.goviedo.securitybasic.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactRestController {

    @PostMapping("/contact")
    public String saveContact() {
        return "Guarda los detalles del contact";
    }
}
