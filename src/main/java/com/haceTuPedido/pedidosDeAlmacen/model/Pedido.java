package com.haceTuPedido.pedidosDeAlmacen.model;

import jakarta.persistence.*;
import jdk.jshell.Snippet;
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
public class Pedido {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado = EstadoPedido.NO_ENVIADO;
    @ManyToOne
    @JoinColumn(name= "proveedor_id")
    private Proveedor proveedor;
    @ManyToOne(optional = false)
    @JoinColumn(name = "negocio_id")
    private Negocio negocio;
    @OneToMany(mappedBy = "pedido")
    private List<DetallePedido> detallesPedido = new ArrayList<>();


}
