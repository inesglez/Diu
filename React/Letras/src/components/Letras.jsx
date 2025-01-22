import React, { useState } from "react";

function Letras({ onBuscar }) {
  const [artista, setArtista] = useState("");
  const [cancion, setCancion] = useState("");
  const [buscando, setBuscando] = useState(false);

  const manejarEnvio = (e) => {
    e.preventDefault();
    if (!artista || !cancion) {
      alert("Por favor, completa ambos campos.");
      return;
    }

    setBuscando(true);
    onBuscar(artista, cancion).finally(() => setBuscando(false));
  };

  return (
    <form className="formulario" onSubmit={manejarEnvio}>
      <div className="mb-3">
        <label htmlFor="artista" className="form-label">
          Artista:
        </label>
        <input
          type="text"
          id="artista"
          className="form-control"
          placeholder="Nombre del artista"
          value={artista}
          onChange={(e) => setArtista(e.target.value)}
        />
      </div>
      <div className="mb-3">
        <label htmlFor="cancion" className="form-label">
          Canción:
        </label>
        <input
          type="text"
          id="cancion"
          className="form-control"
          placeholder="Nombre de la canción"
          value={cancion}
          onChange={(e) => setCancion(e.target.value)}
        />
      </div>
      <button type="submit" className="btn btn-primary" disabled={buscando}>
        {buscando ? "Buscando..." : "Buscar"}
      </button>
    </form>
  );
}

export default Letras;
