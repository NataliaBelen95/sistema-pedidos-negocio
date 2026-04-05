import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../../styles/DetalleProveedor/DetalleProveedor.scss'; // Acordate de crear este archivo

function DetalleProveedor({ id }) {
  const [proveedor, setProveedor] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    // Cada vez que cambie el ID en el Dashboard, pedimos la nueva data
    if (id) {
      axios.get(`http://localhost:8080/api/proveedores/${id}`)
        .then(res => {
          console.log("Data que llegó al Detalle:", res.data);
          setProveedor(res.data);
          setError(null);
        })
        .catch(err => {
          console.error("Error al traer el detalle:", err);
          setError("No se pudo cargar la información del proveedor.");
        });
    }
  }, [id]);

  // 1. Si hay un error de conexión
  if (error) return <div className="error-msg">{error}</div>;

  // 2. Si todavía no llegó la respuesta de Axios
  if (!proveedor) return <div className="loading-msg">Cargando datos...</div>;

  return (
    <div className="detalle-proveedor-content">
      <div className="header-proveedor">
        <div>
          <h2>{proveedor.nombre}</h2>
          <p className="subtitulo">CUIT: {proveedor.cuit}</p>
        </div>
        
      </div>

      <div className="tabla-container">
        <h3>Lista de Productos y Precios</h3>
        {proveedor.productos && proveedor.productos.length > 0 ? (
          <table className="tabla-pedidos">
            <thead>
              <tr>
                <th>Producto</th>
                <th>Precio Unitario</th>
                <th>Acción</th>
              </tr>
            </thead>
            <tbody>
              {proveedor.productos.map((prod) => (
                <tr key={prod.id}>
                  <td>{prod.nombre}</td>
                  <td>${prod.precio}</td>
                  <td>
                    <button className="btn-check">✅ Seleccionar</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        ) : (
          <div className="empty-productos">
            <p>⚠️ Este proveedor no tiene productos cargados en el sistema.</p>
          </div>
        )}
      </div>

      <div className="footer-acciones">
        <button className="btn-pedido">Generar Pedido</button>
        <button className="btn-historial">Ver Pedidos Anteriores</button>
      </div>
    </div>
  );
}

export default DetalleProveedor;