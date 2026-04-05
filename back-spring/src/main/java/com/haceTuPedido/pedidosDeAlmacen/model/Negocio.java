package com.haceTuPedido.pedidosDeAlmacen.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Negocio {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;


    @OneToMany(mappedBy = "negocio")
    private List<Pedido> pedidos = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "negocio_proveedor",
            joinColumns = @JoinColumn(name = "negocio_id"),
            inverseJoinColumns = @JoinColumn(name = "proveedor_id"))
    private List<Proveedor> proveedores;
}
