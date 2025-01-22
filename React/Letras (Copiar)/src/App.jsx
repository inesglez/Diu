import React, { useState } from "react";
import Letras from "./components/Letras";
import TablaResultados from "./components/TablaResultados";
import "./style/style.css";

function App() {
  const [resultados, setResultados] = useState([]);

  const buscarLetra = async (artista, cancion) => {
    if (!artista || !cancion) {
      alert("Por favor, completa ambos campos antes de buscar.");
      return;
    }

    try {
      const respuesta = await fetch(
        `https://api.lyrics.ovh/v1/${encodeURIComponent(artista)}/${encodeURIComponent(cancion)}`
      );

      if (!respuesta.ok) {
        throw new Error("No se encontraron letras para esta canción. Verifica los datos.");
      }

      const datos = await respuesta.json();
      const nuevaLetra = datos.lyrics || "Letra no disponible";

      setResultados((prev) => [
        ...prev,
        { artista, cancion, letra: nuevaLetra },
      ]);
    } catch (error) {
      alert(`Error: ${error.message}`);
    }
  };

  return (
    <div className="container mt-4">
      <h1 className="text-center mb-4">Buscador de Letras</h1>
      {/* Componente para el formulario de búsqueda */}
      <Letras onBuscar={buscarLetra} />

      {/* Componente para mostrar resultados */}
      {resultados.length > 0 ? (
        <TablaResultados resultados={resultados} />
      ) : (
        <p className="text-center mt-4">No hay resultados aún. Realiza una búsqueda.</p>
      )}
    </div>
  );
}

export default App;
