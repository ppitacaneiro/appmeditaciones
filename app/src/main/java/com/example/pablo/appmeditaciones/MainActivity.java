package com.example.pablo.appmeditaciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.pablo.appmeditaciones.DAO.APPMEDITACIONES;
import com.example.pablo.appmeditaciones.DAO.MandalaDaoSQlite;
import com.example.pablo.appmeditaciones.Modelos.Mandala;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    private APPMEDITACIONES appmeditaciones;
    public final static String MANDALA = "mandala";
    private int [] mandalasGenerados = new int[Config.NUMERO_CARTAS];
    private int posicionArray = 0;

    MandalaDaoSQlite mandalaDaoSQlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        copiarBD();
        this.mandalaDaoSQlite = new MandalaDaoSQlite(this);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImagenAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                generarMandalaAleatorio();
            }
        });
    }

    private void generarMandalaAleatorio() {

        boolean salir = false;
        boolean encontrado;
        int idMandala = 0;

        while(!salir) {

            encontrado = false;
            idMandala = Utiles.generarNumeroAleatorio();
            // Log.d("DEPURACION", "Aleatorio -> " + String.valueOf(idMandala));

            for (int i = 0; i < mandalasGenerados.length; i++) {
                if (idMandala == mandalasGenerados[i]) {
                    encontrado = true;
                }
            }

            if (!encontrado) {
                mandalasGenerados[posicionArray] = idMandala;
                posicionArray++;
                // Log.d("DEPURACION", "posicionArray -> " + posicionArray);
                if (posicionArray == Config.NUMERO_CARTAS) {
                    posicionArray = 0;
                }
                salir = true;

                Mandala mandala = mandalaDaoSQlite.getMandala(idMandala);
                // Log.d("DEPURACION", mandala.toString());

                if (mandala != null) {
                    Intent intent = new Intent(MainActivity.this, MandalaActivity.class);
                    intent.putExtra("mandala", mandala);
                    startActivity(intent);
                } else {
                    Toast.makeText(getBaseContext(), R.string.error_objeto_noexiste, Toast.LENGTH_LONG).show();
                }
            }
        }

        // depuración
        /*
        String valoresArray = "";
        for (int i = 0; i < mandalasGenerados.length; i++) {
            valoresArray += mandalasGenerados[i] + ", ";
        }
        Log.d("DEPURACION" , valoresArray);
        */
    }

    private void copiarBD() {
        String bddestino = "/data/data/" + getPackageName() + "/databases/"
                + APPMEDITACIONES.NOME_BD;
        File file = new File(bddestino);
        Log.d("DEPURACIÓN", "Ruta archivo BD: " + bddestino);
        if (file.exists()) {
            Log.d("DEPURACIÓN", "A BD NON SE VAI COPIAR. XA EXISTE");
            return; // XA EXISTE A BASE DE DATOS
        }


        String pathbd = "/data/data/" + getPackageName()
                + "/databases/";
        File filepathdb = new File(pathbd);
        filepathdb.mkdirs();

        InputStream inputstream;
        try {
            inputstream = getAssets().open(APPMEDITACIONES.NOME_BD);
            OutputStream outputstream = new FileOutputStream(bddestino);

            int tamread;
            byte[] buffer = new byte[2048];

            while ((tamread = inputstream.read(buffer)) > 0) {
                outputstream.write(buffer, 0, tamread);
            }
            inputstream.close();
            outputstream.flush();
            outputstream.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
