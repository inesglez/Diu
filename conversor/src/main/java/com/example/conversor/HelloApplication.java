package com.example.conversor;

import Modelo.ExcepcionMoneda;
import Modelo.MonedaVO;
import Modelo.repository.impl.MonedaRepositoryImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Iterator;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Conversor");
        stage.setScene(scene);
        stage.show();
    }


    public HelloApplication() {
    }

    public static void main(String[] args) {
        try {
            MonedaRepositoryImpl monedarepositoryImpl = new MonedaRepositoryImpl();
            MonedaVO monedaPrueba = new MonedaVO("prueba", 1.2F);
            monedarepositoryImpl.addMoneda(monedaPrueba);
            System.out.println(monedarepositoryImpl.ObtenerListaMonedas().size());
            monedarepositoryImpl.deleteMoneda(8);
            System.out.println(monedarepositoryImpl.ObtenerListaMonedas().size());
            monedaPrueba.setNombre("Holassssss");
            monedaPrueba.setMultiplicador(2.0F);
            monedaPrueba.setCodigo(22);
            monedarepositoryImpl.editMoneda(monedaPrueba);
            System.out.println(monedarepositoryImpl.lastId() + " last id");
            Iterator<MonedaVO> it = monedarepositoryImpl.ObtenerListaMonedas().iterator();

            while (it.hasNext()) {
                MonedaVO mon = (MonedaVO) it.next();
                System.out.println(mon.getCodigo() + " " + mon.getNombre() + ' ' + mon.getMultiplicador());
            }
        } catch (ExcepcionMoneda var5) {
            ExcepcionMoneda e = var5;
            System.out.println(e.imprimirMensaje());
        }
        launch();
    }
}

