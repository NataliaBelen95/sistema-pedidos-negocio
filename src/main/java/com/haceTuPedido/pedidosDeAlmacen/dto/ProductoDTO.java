package com.haceTuPedido.pedidosDeAlmacen.dto;


import com.haceTuPedido.pedidosDeAlmacen.model.Categoria;
import com.haceTuPedido.pedidosDeAlmacen.enums.UnidadMedida;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {
    private Long id;
    private String nombre;
//    private int precio;

    private Long categoriaId;
    private String marca;
    private double peso;
    private UnidadMedida unidadMedida;

}
