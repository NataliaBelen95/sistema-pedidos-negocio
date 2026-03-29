package com.haceTuPedido.pedidosDeAlmacen.model;

import com.haceTuPedido.pedidosDeAlmacen.enums.EnumUnidadMedida;
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
    private EnumUnidadMedida enumUnidadMedida;
    private double peso;




}
