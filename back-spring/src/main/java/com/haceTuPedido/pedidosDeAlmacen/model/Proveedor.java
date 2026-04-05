package com.haceTuPedido.pedidosDeAlmacen.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Proveedor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private long cuit;
    private String nombre;
    @OneToMany(mappedBy = "proveedor")
    private List<ProductoProveedor> productosProveedor;

    private double precio;




}
