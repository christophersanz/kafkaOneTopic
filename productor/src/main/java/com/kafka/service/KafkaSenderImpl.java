package com.kafka.service;

import com.kafka.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaSenderImpl implements KafkaSender {

    @Value("${pedido.topic.name}")
    String pedidoTopicName;

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Override
    public void sendMessage(Pedido pedido) {
        ListenableFuture<SendResult<String, Pedido>> future = this.kafkaTemplate.send(pedidoTopicName, pedido);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, Pedido> result) {
                System.out.println("Enviando mensaje: " + pedido + " with offset= " + result.getRecordMetadata().offset());
            }
            @Override
            public void onFailure(final Throwable ex) {
                System.err.println("Problemas para enviar el mensaje: " + pedido + " debido a : " + ex.getMessage());
            }
        });
    }
}
