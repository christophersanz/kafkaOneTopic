package com.kafka.controller;

import com.kafka.model.Pedido;
import com.kafka.service.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/kafka")
public class PedidoController {

    @Autowired
    KafkaConsumer listener;

    @GetMapping(value="ventas", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pedido> ventas(){
        return listener.getPedidos();
    }

}
