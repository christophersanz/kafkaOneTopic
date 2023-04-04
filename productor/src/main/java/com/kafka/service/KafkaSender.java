package com.kafka.service;

import com.kafka.model.Pedido;

public interface KafkaSender {
    void sendMessage(Pedido pedido);
}
