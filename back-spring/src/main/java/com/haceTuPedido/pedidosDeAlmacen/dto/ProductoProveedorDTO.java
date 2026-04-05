package com.haceTuPedido.pedidosDeAlmacen.dto;

import com.haceTuPedido.pedidosDeAlmacen.model.Producto;
import com.haceTuPedido.pedidosDeAlmacen.model.Proveedor;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoProveedorDTO {

    private Long id;
    private Long productoId;   // Solo el ID para cargar
    private Long proveedorId;  // Solo el ID para cargar

    private String nombreProducto; // Para mostrar en el Dashboard
    private String nombreProveedor; // Para mostrar en el Dashboard
    private String marca;
    private double precio;


}
