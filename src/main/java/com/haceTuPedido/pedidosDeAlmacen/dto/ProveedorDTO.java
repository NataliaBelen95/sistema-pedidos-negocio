package com.haceTuPedido.pedidosDeAlmacen.dto;

import com.haceTuPedido.pedidosDeAlmacen.model.ProductoProveedor;
import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProveedorDTO {
    private Long id;
    private long cuit;
    private String nombre;

    List<ProductoProveedorDTO> productos;


}
