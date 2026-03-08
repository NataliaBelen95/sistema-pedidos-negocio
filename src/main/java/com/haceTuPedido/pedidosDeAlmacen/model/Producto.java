package com.haceTuPedido.pedidosDeAlmacen.model;

import com.haceTuPedido.pedidosDeAlmacen.enums.UnidadMedida;
import jakarta.persistence.*;
import lombok.*;

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
    @ManyToOne
    private Categoria categoria;
    private String marca;
    @Enumerated(EnumType.STRING)
    private UnidadMedida unidadMedida;
    private double peso;




}
