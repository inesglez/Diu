import React, { useState, useEffect } from "react";
import axios from "axios";
import { Container, Card, CardContent, Typography, Grid, CircularProgress } from "@mui/material";
import styled from "styled-components";

const CustomCard = styled(Card)`
  margin-bottom: 20px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  &:hover {
    box-shadow: 0 6px 15px rgba(0, 0, 0, 0.15);
  }
`;

const Agenda = () => {
  const [events, setEvents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get("http://localhost:8099/api/v1/agenda");
        setEvents(response.data);
        setLoading(false);
      } catch (error) {
        setError("Error al cargar los eventos");
        setLoading(false);
      }
    };

    fetchData();
  }, []);

  if (loading) return <CircularProgress />;
  if (error) return <Typography color="error">{error}</Typography>;

  return (
    <Container maxWidth="md">
      <Typography variant="h3" align="center" gutterBottom>
        Agenda de Eventos
      </Typography>
      <Grid container spacing={4}>
        {events.map((event) => (
          <Grid item xs={12} sm={6} md={4} key={event.id}>
            <CustomCard>
              <CardContent>
                <Typography variant="h5" gutterBottom>
                  {event.title}
                </Typography>
                <Typography variant="body2" color="textSecondary" paragraph>
                  {event.description}
                </Typography>
                <Typography variant="subtitle2" color="textSecondary">
                  {new Date(event.date).toLocaleDateString()}
                </Typography>
              </CardContent>
            </CustomCard>
          </Grid>
        ))}
      </Grid>
    </Container>
  );
};

export default Agenda;
