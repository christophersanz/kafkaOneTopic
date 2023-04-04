package com.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    private String producto;
    private int unidades;
    private double precio;

    @Override
    public String toString() {
        return "Pedido[producto=" + producto + ", unidades=" + unidades + ", precio=" + precio + ']';
    }
}
