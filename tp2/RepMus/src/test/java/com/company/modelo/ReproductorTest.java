package com.company.modelo;

import com.company.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReproductorTest {
    @Test
    void AddMeGusta() {
        Cancion ctest = new Cancion("Holis","Musica Espantosa","Karol J", 307);
        Lista listest = new Lista("Canciones RepMus");
        listest.addCanciones(ctest);
        Reproductor rep = new Reproductor();
        rep.addLista(listest);
        rep.getCancionesRepMus().getCanciones().get(0).setDescargado(true);
        assertTrue(rep.getCancionesRepMus().getCanciones().get(0).isDescargado());


    }
}