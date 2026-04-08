package com.haceTuPedido.pedidosDeAlmacen.mapper;

import com.haceTuPedido.pedidosDeAlmacen.dto.*;
import com.haceTuPedido.pedidosDeAlmacen.enums.EnumUnidadMedida;
import com.haceTuPedido.pedidosDeAlmacen.model.*;

import java.util.stream.Collectors;

public class Mapper {



//Mapeo Negocio a NegocioDTO

    public static NegocioDTO toDTO(Negocio negocio) {
        if(negocio==null)return null;
        return NegocioDTO.builder()
                .id(negocio.getId())
                .nombre(negocio.getNombre())
                .direccion(negocio.getDireccion())
                .build();
    }


    //Mapeo de Producto a productoDTO
    public static ProductoDTO toDTO(Producto produto){
    if(produto==null)return null;
    return ProductoDTO.builder()
            .id(produto.getId())
            .nombre(produto.getNombre())
            .categoriaId(produto.getCategoria().getId())
            .marca(produto.getMarca())
            .enumUnidadMedida(produto.getEnumUnidadMedida())
            .peso(produto.getPeso())
            .build();
    }

    //Mapedo Proveedor a ProveedorDTO
    public static ProveedorDTO toDTO(Proveedor proveedor){
        if(proveedor==null)return null;
        return ProveedorDTO.builder()
                .id(proveedor.getId())
                .nombre(proveedor.getNombre())
                .cuit(proveedor.getCuit())
                .productos(proveedor.getProductosProveedor() != null ?
                        proveedor.getProductosProveedor().stream().map(Mapper::toDTO).toList() : null)
                .build();
    }


    /*proveddor_prudcto*/
    public static ProductoProveedorDTO toDTO(ProductoProveedor pp) {
        if (pp == null) return null;

        return ProductoProveedorDTO.builder()
                .id(pp.getId())
                .productoId(pp.getProducto().getId())
                .proveedorId(pp.getProveedor().getId())
                .nombreProducto(pp.getProducto().getNombre()) // Muy útil para la tabla
                .nombreProveedor(pp.getProveedor().getNombre()) // Muy útil para comparar
                .precio(pp.getPrecio())
                .marca(pp.getProducto().getMarca())
                .build();
    }

    public static ProductoNegocioDTO toDTO(ProductoNegocio pn) {
        if (pn == null) return null;

        return ProductoNegocioDTO.builder()
                .idProductoNegocio(pn.getId()) // <--- ESTE ES EL QUE FALTABA
                .idProducto(pn.getProducto().getId())
                .idNegocio(pn.getNegocio().getId())
                .nombreNegocio(pn.getNegocio().getNombre())
                .stock(pn.getStock())
                .nombreProducto(pn.getProducto().getNombre())
                .build();
    }

    //Mapeo Pedido a PedidoDTO

    public static PedidoDTO toDTO(Pedido pedido) {
        if (pedido == null) return null;

        var detalle = pedido.getDetallesPedido().stream().map(det ->
                DetallePedidoDTO.builder()
                        .productoId(det.getProducto().getId())
                        .nombreProducto(det.getProducto().getNombre())
                        .precioUnitario(det.getPrecioUnitario())
                        .cantidad(det.getCantidad())
                        .subtotal(det.getPrecioUnitario() * det.getCantidad())
                        .build()
        ).collect(Collectors.toList());

        var total = detalle.stream()
                .map(DetallePedidoDTO::getSubtotal)
                .reduce(0.0, Double::sum);

        return PedidoDTO.builder()
                .id(pedido.getId())
                .fecha(pedido.getFecha())
                .proveedorNombre(pedido.getProveedor().getNombre())
                .negocioNombre(pedido.getNegocio().getNombre())
                .detallesPedido(detalle)
                .total(total)
                .build();


    }

    /*categoria DTO***/
    public static CategoriaDTO toDTO(Categoria categoria) {

        return CategoriaDTO.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())

                .build();
    }




//    //Mapeo DetallesPedido a detalle pedidoDTOw
//    public static DetallePedidoDTO toDTO(DetallePedido detalle) {
//        if (detalle == null) return null;
//
//        return DetallePedidoDTO.builder()
//                .nombreProducto(detalle.getProducto().getNombre())
//                .precioUnitario(detalle.getPrecioUnitario())
//                .cantidad(detalle.getCantidad())
//                .build();
//    }

}
