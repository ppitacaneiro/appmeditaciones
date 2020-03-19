package com.example.pablo.appmeditaciones.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.pablo.appmeditaciones.Modelos.Mandala;
import com.example.pablo.appmeditaciones.Utiles;

public class MandalaDaoSQlite implements MandalaDAO {

    private APPMEDITACIONES appmeditaciones;
    private Context context;

    public MandalaDaoSQlite(Context context){
        this.context=context;
        this.appmeditaciones = new APPMEDITACIONES(this.context);
    }

    @Override
    public Mandala getMandala(int id) {
        Mandala resultado = null;
        SQLiteDatabase sqlLiteDB = appmeditaciones.getWritableDatabase();
        String[] param = {String.valueOf(id)};
        String consulta = "SELECT * FROM mandalas WHERE id=?";
        Cursor cursor = sqlLiteDB.rawQuery(consulta, param);
        Utiles.depuracion(consulta, param);
        Log.d("DEPURACIÓN", "Nº filas: " + cursor.getCount());
        if (cursor.moveToFirst()) {
            resultado = new Mandala(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
        }
        return resultado;
    }



}
