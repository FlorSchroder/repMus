package com.company.modelo;

import com.company.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReproductorTest {
    Cancion ctest = new Cancion("Holis","Pop","Babasonicos", 307);
    Lista listest = new Lista("Canciones RepMus");


    @Test
    void AddMeGusta() {
        listest.addCanciones(ctest);
        Reproductor rep = Reproductor.getInstance();
        rep.getCancionesRepMus().getCanciones().get(0).setDescargado(true);
        assertTrue(rep.getCancionesRepMus().getCanciones().get(0).isDescargado());

    }

    @Test
    void popMeGusta() {
        listest.addCanciones(ctest);
        Reproductor rep = Reproductor.getInstance();
        rep.getCancionesRepMus().getCanciones().get(0).setDescargado(false);
        assertFalse(rep.getCancionesRepMus().getCanciones().get(0).isDescargado());
    }

    @Test
    void RecomendarArtista(){
        listest.addCanciones(ctest);
        Lista list2;
        Reproductor rep = Reproductor.getInstance();
        rep.play(ctest);
        rep.recomendarArtista(ctest.getArtista());
        list2 = rep.getRecomendaciones();
        Assertions.assertNotEquals(null,list2.getCanciones().get(0).getArtista());
    }
}