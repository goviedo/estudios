package cl.goviedo.securitybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsRestController {
    @GetMapping("/myCards")
    public String getLoanDetails() {
        return "Detalle de las tarjetas disponibles";
    }
}
