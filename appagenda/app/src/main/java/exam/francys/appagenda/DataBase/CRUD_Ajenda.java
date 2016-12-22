package exam.francys.appagenda.DataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.LoginFilter;
import android.util.Log;
import android.widget.Toast;

import exam.francys.appagenda.Models.Usuario;

import static exam.francys.appagenda.R.string.correo;
import static exam.francys.appagenda.R.string.nombre;

/**
 * Created by Francys on 20/12/2016.
 */

public class CRUD_Ajenda {


    public  static long Ingresa(AgendaDB context,Usuario usuario){
        SQLiteDatabase db = context.getWritableDatabase();

        ContentValues registo = new ContentValues();
        registo.put(DataBaseDetalles.KEY_Name       ,usuario.getNombre());
        registo.put(DataBaseDetalles.KEY_App        ,usuario.getApp());
        registo.put(DataBaseDetalles.Key_Direccion  ,usuario.getDireccion());
        registo.put(DataBaseDetalles.Key_Telefono   ,usuario.getTelefono());
        registo.put(DataBaseDetalles.Key_Correo     ,usuario.getCorreo());
        registo.put(DataBaseDetalles.Key_Estado     ,usuario.getEstado());
        registo.put(DataBaseDetalles.Key_Usuario    ,usuario.getUsuario());
        registo.put(DataBaseDetalles.Key_Contrase   ,usuario.getContrase());

        long insert = db.insert(DataBaseDetalles.TABLE, null, registo);
        return insert;
    }


    public static void getall(AgendaDB context) {
        SQLiteDatabase db = context.getReadableDatabase();
        Cursor c = db
                .rawQuery("SELECT *  from " + DataBaseDetalles.TABLE + " ", null);
        try {
            if (c.moveToFirst()) {
                do {
                    int id = c.getInt(0);
                    String name = c.getString(1);
                    Log.d("Usuario ", id +" "+ name);
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    //Para resolver el problema de duplicidad de nombres primero verificar si existe

    public static int buscarNombre(AgendaDB context,String nombre){
        SQLiteDatabase db = context.getReadableDatabase();

        int num = 0;
        try{
            Cursor cursor = db
                    .rawQuery("SELECT * FROM "+DataBaseDetalles.TABLE
                            +" WHERE "+DataBaseDetalles.KEY_Name+" like   '%"+nombre+"%' ",null);
            num = cursor.getCount();
        } catch(Exception e){
            Log.i("El error", e.toString());
        }

        return num;
    }


    public static int buscacorreo(AgendaDB context,String correo){
        SQLiteDatabase db = context.getReadableDatabase();

        int num = 0;
        try{
            Cursor cursor = db
                    .rawQuery("SELECT * FROM "+DataBaseDetalles.TABLE
                            +" WHERE "+DataBaseDetalles.Key_Correo+" like   '%"+correo+"%' ",null);
            num = cursor.getCount();
        } catch(Exception e){
            Log.i("El error", e.toString());
        }

        return num;

    }


    public static int buscaUsuario(AgendaDB context,String usuario){
        SQLiteDatabase db = context.getReadableDatabase();

        int num = 0;
        try{
            Cursor cursor = db
                    .rawQuery("SELECT * FROM "+DataBaseDetalles.TABLE
                            +" WHERE "+DataBaseDetalles.Key_Usuario+" like   '%"+usuario+"%' ",null);
            num = cursor.getCount();
        } catch(Exception e){
            Log.i("El error", e.toString());
        }

        return num;

    }


}


