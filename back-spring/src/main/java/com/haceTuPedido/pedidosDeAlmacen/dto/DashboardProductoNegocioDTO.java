package com.haceTuPedido.pedidosDeAlmacen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardProductoNegocioDTO {

    private Long idProducto;         // ID global producto
    private Long idProductoNegocio;  // ID  stock

    // Información Visual
    private String nombre;
    private String marca;
    private String unidadMedida;

    // El "Junte" de datos
    private double precioCompraProveedor;
    private int stockActual;

    // Lógica de Negocio
    private boolean loTrabajo;
    private boolean alertaStock;         // stockActual < 3
}