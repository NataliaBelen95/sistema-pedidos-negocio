package com.haceTuPedido.pedidosDeAlmacen.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    private String marca;
    private UnidadMedida unidadMedida;
    private double peso;

    @OneToMany(mappedBy = "producto")
    private List<ProductoProveedor> proveedores;

    @OneToMany(mappedBy = "producto")
    private List<ProductoNegocio> negocios;


}
