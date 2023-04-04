package com.kafka.controller;

import com.kafka.model.Pedido;
import com.kafka.service.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class PedidosController {

    @Autowired
    KafkaSender sender;

    @PostMapping(value="pedido/{nombre}/{unidades}/{precio}")
    public void pedido(@PathVariable("nombre") String nombre, @PathVariable("unidades") int unidades, @PathVariable("precio") double precio){
        Pedido pedido = new Pedido(nombre,unidades,precio);
        sender.sendMessage(pedido);
    }

}
