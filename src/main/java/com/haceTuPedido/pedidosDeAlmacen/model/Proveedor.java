package com.haceTuPedido.pedidosDeAlmacen.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Proveedor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
//    @OneToMany(mappedBy = "proveedor")
//    private List<ProductoProveedor> productos = new ArrayList<>();

    private double precio;




}
