import React from "react";

function TablaResultados({ resultados }) {
  return (
    <table className="table table-striped mt-4">
      <thead>
        <tr>
          <th>Artista</th>
          <th>Canción</th>
          <th>Letra</th>
        </tr>
      </thead>
      <tbody>
        {resultados.map((resultado, index) => (
          <tr key={index}>
            <td>{resultado.artista}</td>
            <td>{resultado.cancion}</td>
            <td style={{ whiteSpace: "pre-wrap" }}>{resultado.letra}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default TablaResultados;
