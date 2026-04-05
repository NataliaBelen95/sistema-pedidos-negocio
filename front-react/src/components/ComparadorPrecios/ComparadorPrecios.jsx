import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../../styles/ComparadorPrecios/ComparadorPrecios.scss';

function ComparadorPrecios({ id, onVolver }) {
  const [proveedorActual, setProveedorActual] = useState(null);

  useEffect(() => {
    // Traemos la data del proveedor elegido para comparar sus productos
    axios.get(`http://localhost:8080/api/proveedores/${id}`)
      .then(res => setProveedorActual(res.data))
      .catch(err => console.error("Error en comparador:", err));
  }, [id]);

  if (!proveedorActual) return <div className="loader-overlay">Analizando precios...</div>;

  return (
    <div className="comparador-screen">
     
      </div>
    
  );
}

export default ComparadorPrecios;