package com.senac.projetoBciclo2JoaoGuilherme.Controller;

import com.senac.projetoBciclo2JoaoGuilherme.dto.LadoDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalcularController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/calcular")
    public void calcularLado(LadoDTO ladoDTO){
        rabbitTemplate.convertAndSend("provac2JoaoGuilherme", ladoDTO);
    }

}
