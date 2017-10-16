package exam.francys.appagenda.DataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import exam.francys.appagenda.Models.Usuario;

/**
 * Created by Francys on 20/12/2016.
 */

public class CRUD_Diary {


    public  static long Ingresa(Diarys context, Usuario usuario){
        SQLiteDatabase db = context.getWritableDatabase();

        ContentValues registo = new ContentValues();
        registo.put(Details_DB.KEY_Name       ,usuario.getNombre());
        registo.put(Details_DB.KEY_App        ,usuario.getApp());
        registo.put(Details_DB.Key_Direccion  ,usuario.getDireccion());
        registo.put(Details_DB.Key_Telefono   ,usuario.getTelefono());
        registo.put(Details_DB.Key_Correo     ,usuario.getCorreo());
        registo.put(Details_DB.Key_Estado     ,usuario.getEstado());
        registo.put(Details_DB.Key_Usuario    ,usuario.getUsuario());
        registo.put(Details_DB.Key_Contrase   ,usuario.getContrase());

        long insert = db.insert(Details_DB.TABLE, null, registo);
        return insert;
    }


    public static List<Usuario> getall(Diarys context) {
        SQLiteDatabase db = context.getReadableDatabase();
        List<Usuario> usuarios = new ArrayList<>();

        Cursor c = db
                .rawQuery("SELECT *  from " + Details_DB.TABLE + " ", null);
        try {
            if (c.moveToFirst()) {
                do {
                    usuarios.add(new
                            Usuario(c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5),
                                    c.getString(6),c.getString(7),c.getString(8)));

                } while (c.moveToNext());
            }
        } catch (Exception e) {
            Log.d("Error ", e.getMessage());
        }

        return usuarios;
    }



    public static int buscarNombre(Diarys context, String nombre){
        SQLiteDatabase db = context.getReadableDatabase();

        int num = 0;
        try{
            Cursor cursor = db
                    .rawQuery("SELECT * FROM "+ Details_DB.TABLE
                            +" WHERE "+ Details_DB.KEY_Name+" like   '%"+nombre+"%' ",null);
            num = cursor.getCount();
        } catch(Exception e){
            Log.i("El error", e.toString());
        }

        return num;
    }


    public static int buscacorreo(Diarys context, String correo){
        SQLiteDatabase db = context.getReadableDatabase();

        int num = 0;
        try{
            Cursor cursor = db
                    .rawQuery("SELECT * FROM "+ Details_DB.TABLE
                            +" WHERE "+ Details_DB.Key_Correo+" like   '%"+correo+"%' ",null);
            num = cursor.getCount();
        } catch(Exception e){
            Log.i("El error", e.toString());
        }

        return num;

    }


    public static int buscaUsuario(Diarys context, String usuario){
        SQLiteDatabase db = context.getReadableDatabase();

        int num = 0;
        try{
            Cursor cursor = db
                    .rawQuery("SELECT * FROM "+ Details_DB.TABLE
                            +" WHERE "+ Details_DB.Key_Usuario+" like   '%"+usuario+"%' ",null);
            num = cursor.getCount();
        } catch(Exception e){
            Log.i("El error", e.toString());
        }

        return num;

    }


}


