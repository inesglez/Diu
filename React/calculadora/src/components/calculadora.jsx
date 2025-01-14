import React, { useState } from "react";
import "./Calculadora.css";

// Componente Botón
const Boton = ({ valor, alClickear, claseCSS }) => {
  return (
    <button
      className={`boton ${claseCSS}`}
      onClick={() => alClickear(valor)}
    >
      {valor}
    </button>
  );
};

// Componente Panel de Botones
const PanelDeBotones = ({ alClickearBoton }) => {
  const botones = [
    "AC",
    "+/-",
    "%",
    "/",
    "7",
    "8",
    "9",
    "*",
    "4",
    "5",
    "6",
    "-",
    "1",
    "2",
    "3",
    "+",
    "0",
    ".",
    "=",
  ];

  const botonesEspeciales = ["/", "*", "-", "+", "="]; // Define los botones especiales

  return (
    <div className="panel-de-botones">
      {botones.map((btn, indice) => (
        <Boton
          key={indice}
          valor={btn}
          alClickear={alClickearBoton}
          claseCSS={`boton ${
            btn === "0"
              ? "boton--cero" // Clase especial para el botón "0"
              : botonesEspeciales.includes(btn)
              ? "boton--especial"
              : ""
          }`}
        />
      ))}
    </div>
  );
};

// Componente Pantalla
const Pantalla = ({ valor }) => {
  return <div className="pantalla">{valor}</div>;
};

// Componente Principal
const Calculadora = () => {
  const [valorPantalla, setValorPantalla] = useState("0"); // Inicializa la pantalla con "0"
  const [esResultado, setEsResultado] = useState(false); // Indica si el valor actual es un resultado

  // Lógica para manejar clic en botones
  const alClickearBoton = (valor) => {
    if (valor === "AC") {
      setValorPantalla("0"); // Pone el valor de la pantalla en 0 al presionar AC
      setEsResultado(false); // Reinicia el estado de resultado
    } else if (valor === "%") {
      try {
        setValorPantalla((prevValor) => (parseFloat(prevValor) / 100).toString()); // Divide el número entre 100
        setEsResultado(true); // Marca como resultado
      } catch (e) {
        setValorPantalla("Error"); // Si hay un error, muestra "Error"
        setEsResultado(true);
      }
    } else if (valor === "+/-") {
      setValorPantalla((prevValor) => {
        if (prevValor === "0" || prevValor === "Error") {
          return prevValor; // No cambia el signo si es 0 o Error
        }
        return (parseFloat(prevValor) * -1).toString(); // Cambia el signo del número
      });
    } else if (valor === "=") {
      try {
        setValorPantalla(eval(valorPantalla).toString()); // Evalúa la expresión matemática
        setEsResultado(true); // Marca como resultado
      } catch (e) {
        setValorPantalla("Error"); // Si hay un error, muestra "Error"
        setEsResultado(true);
      }
    } else {
      setValorPantalla((prevValor) => {
        if (esResultado && !isNaN(valor)) {
          // Si el valor actual es un resultado y se presiona un número, comienza una nueva operación
          setEsResultado(false);
          return valor;
        }
        return prevValor === "0" && !isNaN(valor) ? valor : prevValor + valor; // Manejo general
      });
    }
  };

  return (
    <div className="calculadora">
      <Pantalla valor={valorPantalla} />
      <PanelDeBotones alClickearBoton={alClickearBoton} />
    </div>
  );
};

export default Calculadora;
