package com.example.pablo.appmeditaciones;

import android.util.Log;

import java.util.Random;

public class Utiles {

    public static void depuracion(String consulta, String[] param) {
        String texto = "Consulta: " + consulta + " Valores: ";
        for (String p : param) {
            texto += p + " ";
        }
        Log.d("DEPURACIÓN", texto);
    }

    public static int generarNumeroAleatorio() {
        Random aleatorio = new Random(System.currentTimeMillis());
        int intAletorio = aleatorio.nextInt(Config.NUMERO_CARTAS);
        aleatorio.setSeed(System.currentTimeMillis());
        aleatorio.setSeed(aleatorio.nextLong());
        return intAletorio + 1;
    }
}
