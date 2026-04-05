import React, { useState, useEffect } from 'react';
import axios from 'axios';
import DetalleProveedor from '../../components/DetalleProveedor/DetalleProveedor';
import ComparadorPrecios from '../../components/ComparadorPrecios/ComparadorPrecios';
import '../../styles/dashboard/Dashboard.scss'; 

function Dashboard() {
  // 1. Estados
  const [proveedores, setProveedores] = useState([]);
  const [idSeleccionado, setIdSeleccionado] = useState(null);
  const [vista, setVista] = useState('detalle'); // Puede ser 'detalle' o 'comparador'
  const [cargando, setCargando] = useState(true);

  // 2. Carga de datos reales desde el Backend
  useEffect(() => {
    axios.get('http://localhost:8080/api/proveedores')
      .then(res => {
        setProveedores(res.data);
        setCargando(false);
      })
      .catch(err => {
        console.error("Error al conectar con Spring Boot:", err);
        setCargando(false);
      });
  }, []);

  // 3. Funciones de navegación
  const seleccionarProveedor = (id) => {
    setIdSeleccionado(id);
    setVista('detalle'); // Siempre volvemos al detalle al cambiar de proveedor
  };

  return (
    <div className="dashboard-layout">
      {/* --- SIDEBAR IZQUIERDO --- */}
      <aside className="sidebar">
        <div className="user-profile">
          <span>👤 Usuario: Admin</span>
        </div>

        <nav className="lista-proveedores">
          <h3>Mis Proveedores</h3>
          
          {cargando ? (
            <p className="loading-text">Conectando al servidor...</p>
          ) : (
            proveedores.map(p => (
              <div 
                key={p.id} 
                className={`item-proveedor ${idSeleccionado === p.id ? 'active' : ''}`}
                onClick={() => seleccionarProveedor(p.id)}
              >
                {p.nombre}
              </div>
            ))
          )}

          {/* Si la lista está vacía en la DB */}
          {!cargando && proveedores.length === 0 && (
            <p className="empty-msg">No hay proveedores en la base de datos.</p>
          )}
        </nav>
      </aside>

      {/* --- CONTENIDO PRINCIPAL --- */}
      <main className="content-area">
        {!idSeleccionado ? (
          // Estado inicial: Nada seleccionado
          <div className="vacio-state">
            <h2>Gestión de Pedidos Inteligente</h2>
            <p>Seleccioná un proveedor de la izquierda para ver su catálogo y comparar precios.</p>
          </div>
        ) : (
          // Renderizado condicional según la vista
          <div className="view-container">
            {vista === 'detalle' ? (
              <DetalleProveedor 
                id={idSeleccionado} 
                onIrAComparar={() => setVista('comparador')} 
              />
            ) : (
              <ComparadorPrecios 
                id={idSeleccionado} 
                onVolver={() => setVista('detalle')} 
              />
            )}
          </div>
        )}
      </main>
    </div>
  );
}

export default Dashboard;