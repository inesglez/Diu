import React, { useEffect, useState } from "react";
import TutorialDataService from "../services/tutorial.service";
import { useHistory, useParams } from "react-router-dom";

const Tutorial = () => {

  const { id } = useParams(); // Obtener el id de la URL

  const [currentTutorial, setCurrentTutorial] = useState({
    id: null,
    title: "",
    description: "",
    published: false,
  });

  const [tutorial, setTutorial] = useState({
    title: "",
    description: "",
    published: false,
  });

  const history = useHistory();

  // Usar useEffect para obtener los datos del tutorial y que se renderice cada vez que cambie el id
  useEffect(() => {
    // Usar id para obtener los datos del tutorial desde la API
    TutorialDataService.get(id)
      .then((response) => {
        setCurrentTutorial(response.data);
        setTutorial({
          title: response.data.title, // Establecer los valores del tutorial en el estado
          description: response.data.description,
          published: response.data.published,
        });
      })
      .catch((e) => {
        console.log(e);
      });
  }, [id]); // El useEffect se ejecutará cada vez que cambie el id

  const editTutorials = () => {
    const updatedTutorial = {
      id: currentTutorial.id,
      title: tutorial.title,
      description: tutorial.description,
      published: tutorial.published,
    };

    TutorialDataService.update(id, updatedTutorial)
      .then(() => {
        history.push("/tutorials");
      })
      .catch((e) => {
        console.log(e);
      });
  };

  // Manejar los cambios de entrada en los campos del formulario
  const handleInputChange = (e) => {
    const { id, value } = e.target;
    setTutorial({
      ...tutorial,
      [id]: value,
    });
  };

  // Comprobamos el estado del published
  const handlePublishedChange = (e) => {
    const { id } = e.target;
    setTutorial({
      ...tutorial,
      published: id === "radioButtonYes",
    });
  };

  return (
    <div className="container">
      <form>
        <div className="form-group">
          <label htmlFor="title">Title</label>
          <input
            type="text"
            className="form-control"
            id="title"
            required
            value={tutorial.title}
            onChange={handleInputChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="description">Description</label>
          <input
            type="text"
            className="form-control"
            id="description"
            required
            value={tutorial.description}
            onChange={handleInputChange}
          />
        </div>
        <div className="form-group">
          <label>Published: </label>
          <div className="d-flex gap-5">
            <div className="form-check">
              <input
                className="form-check-input"
                type="radio"
                name="flexRadioDefault"
                id="radioButtonYes"
                checked={tutorial.published === true}
                onChange={handlePublishedChange}
              />
              <label className="form-check-label" htmlFor="radioButtonYes">
                Yes
              </label>
            </div>
          </div>
          <div className="d-flex gap-5">
            <div className="form-check">
              <input
                className="form-check-input"
                type="radio"
                name="flexRadioDefault"
                id="radioButtonNo"
                checked={tutorial.published === false}
                onChange={handlePublishedChange}
              />
              <label className="form-check-label" htmlFor="radioButtonNo">
                No
              </label>
            </div>
          </div>
        </div>
        <button
          type="button"
          onClick={editTutorials}
          className="btn btn-success"
        >
          Submit
        </button>
      </form>
    </div>
  );
};

export default Tutorial;
