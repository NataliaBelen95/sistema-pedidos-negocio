package com.haceTuPedido.pedidosDeAlmacen.dto;


import com.haceTuPedido.pedidosDeAlmacen.enums.EnumCategoria;
import com.haceTuPedido.pedidosDeAlmacen.model.Categoria;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaDTO {

    private Long id;
    private EnumCategoria nombre;

}
