package com.example.conversor;

import Modelo.ExcepcionMoneda;
import Modelo.MonedaVO;
import Modelo.repository.impl.MonedaRepositoryImpl;

import java.util.Iterator;

public class modelo {
    MonedaRepositoryImpl monedaRepositoryImpl;

    public void setMonedaRepository(MonedaRepositoryImpl monedaRepository) {
        this.monedaRepositoryImpl = monedaRepository;
    }
    public float RecuperarMultiplicador() throws ExcepcionMoneda {
        float multiplicador = 0;
        Iterator<MonedaVO> it = monedaRepositoryImpl.ObtenerListaMonedas().iterator();

        while(it.hasNext()) {
            MonedaVO mon = (MonedaVO) it.next();
            if (mon.getNombre().equalsIgnoreCase("euros")) {
                multiplicador = mon.getMultiplicador();
            }
        }
      return multiplicador;
    }
    public float ConversorMoneda(float multiplicador, float moneda) {
        return multiplicador * moneda;

    }
}

