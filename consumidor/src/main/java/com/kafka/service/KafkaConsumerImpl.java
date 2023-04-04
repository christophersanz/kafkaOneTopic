package com.kafka.service;

import com.kafka.model.Pedido;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumerImpl implements KafkaConsumer {
    List<Pedido> pedidos = new ArrayList<>();

    @KafkaListener(topics = "${pedido.topic.name}", groupId = "${pedido.topic.group.id}")
    public void listenTopic(Pedido pedido) {
        System.out.println("Mensaje recibido del topic ${pedido.topic.name}: "+pedido);
        pedidos.add(pedido);
    }

    @Override
    public List<Pedido> getPedidos() {
        System.out.println("Total pedidos="+pedidos.size());
        return pedidos;
    }
}
