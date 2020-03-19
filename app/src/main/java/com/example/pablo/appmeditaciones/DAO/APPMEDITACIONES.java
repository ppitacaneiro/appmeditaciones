package com.example.pablo.appmeditaciones.DAO;

/**
 * Created by Pablo on 01/11/2017.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class APPMEDITACIONES extends SQLiteOpenHelper {
    public final static String NOME_BD = "appmandalas.db";
    public final static int VERSION_BD = 1;

    public APPMEDITACIONES(Context context) {
        super(context, NOME_BD, null, VERSION_BD);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }
}

