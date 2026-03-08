package com.haceTuPedido.pedidosDeAlmacen.model;

import jakarta.persistence.*;

@Entity
public class ProductoProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Proveedor proveedor;

    private double precio;

}
