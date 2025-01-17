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
  const [dato, setDato] = useState(""); // Estado para almacenar la expresión
  const [actualizar, setActualizar] = useState(false); // Estado para manejar actualizaciones de resultados

  // Función para calcular el resultado a través de la API
  const calcular = () => {
    if (dato === "" || dato === "Error") return; // Si no hay expresión o el resultado es un error, no hacer nada
    const operacion = encodeURIComponent(dato); // Codifica la expresión para la URL
    fetch(`http://api.mathjs.org/v4/?expr=${operacion}`)
      .then((response) => {
        if (response.ok) {
          return response.text(); // Obtener la respuesta como texto
        } else {
          throw new Error(response.statusText);
        }
      })
      .then((resultado) => {
        setDato(resultado); // Actualizar el estado con el resultado
        setValorPantalla(resultado); // Mostrar el resultado en la pantalla
      })
      .catch(() => {
        setValorPantalla("Error"); // En caso de error con la API
        setDato("Error");
      });
    setActualizar(true);
  };

  // Lógica para manejar clic en botones
  const alClickearBoton = (valor) => {
    if (valor === "AC") {
      setValorPantalla("0"); // Pone el valor de la pantalla en 0 al presionar AC
      setEsResultado(false); // Reinicia el estado de resultado
      setDato(""); // Reinicia el dato
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
      calcular(); // Llama a la función calcular cuando se presiona "="
    } else {
      setValorPantalla((prevValor) => {
        if (esResultado && !isNaN(valor)) {
          // Si el valor actual es un resultado y se presiona un número, comienza una nueva operación
          setEsResultado(false);
          setDato(valor); // Reemplaza el valor al comenzar una nueva operación
          return valor;
        }
        // Si el valor es un operador o número, añade a la expresión
        const nuevoDato = prevValor === "0" && !isNaN(valor) ? valor : prevValor + valor;
        setDato(nuevoDato); // Actualiza la expresión para el cálculo
        return nuevoDato; // Actualiza la pantalla
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
