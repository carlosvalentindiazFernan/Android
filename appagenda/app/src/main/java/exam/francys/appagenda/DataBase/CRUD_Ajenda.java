package exam.francys.appagenda.DataBase;

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


    public static void Insertar(AgendaDB context, Usuario usuario){
        SQLiteDatabase db = context.getWritableDatabase();
        String cade = "INSERT INTO " +
                DataBaseDetalles.TABLE          + " (" +
                DataBaseDetalles.KEY_Name       + "," +
                DataBaseDetalles.KEY_App        + "," +
                DataBaseDetalles.Key_Direccion  + "," +
                DataBaseDetalles.Key_Telefono   + "," +
                DataBaseDetalles.Key_Correo     +","+
                DataBaseDetalles.Key_Estado     +","+
                DataBaseDetalles.Key_Usuario    +","+
                DataBaseDetalles.Key_Contrase   +
                ") VALUES ( " + " ' " + usuario.getNombre() + "'  ,"
                + " ' " + usuario.getApp() + "' ," + " ' " + usuario.getDireccion() + " ' ,"
                + " ' " + usuario.getTelefono() + "' ," + " ' " + usuario.getCorreo() + " ',"
                + " ' "+ usuario.getEstado() +" ' ,"+" ' "+usuario.getUsuario()+"' ,"
                +" ' "+ usuario.getContrase() +"' )";

        db.execSQL(cade);


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


