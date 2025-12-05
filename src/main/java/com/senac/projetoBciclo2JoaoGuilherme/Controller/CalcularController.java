package com.senac.projetoBciclo2JoaoGuilherme.Controller;

import com.senac.projetoBciclo2JoaoGuilherme.dto.LadoDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CalcularController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/calcular")
    public Double calcularLado(@RequestBody LadoDTO ladoDTO){
        Object resposta = rabbitTemplate.convertSendAndReceive("provaciclo2pw1noite", "provac2JoaoGuilherme", ladoDTO);

        return (Double) resposta;
    }

}