package com.haceTuPedido.pedidosDeAlmacen.dto;


import com.haceTuPedido.pedidosDeAlmacen.model.Categoria;
import com.haceTuPedido.pedidosDeAlmacen.model.UnidadMedida;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {
    private Long id;
    private String nombre;
//    private int precio;

    private Categoria categoria;
    private String marca;
    private double peso;
    private UnidadMedida unidadMedida;
    private List<ProductoNegocioDTO> productosNegocio;
    private List<ProductoProveedorDTO>productosProveedor;
}
