package com.kafka.service;

import com.kafka.model.Pedido;

import java.util.List;

public interface KafkaConsumer {
    List<Pedido> getPedidos();
}
