package exam.francys.appagenda.DataBase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import exam.francys.appagenda.Models.Usuario;

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


    //Para resolver el problema de duplicidad de nombres primero verificar si existe
    public boolean buscarNombre(AgendaDB context,String nombre){
        Boolean existe = false;
        SQLiteDatabase db = context.getReadableDatabase();
        Cursor c = db
                .rawQuery("SELECT  "+DataBaseDetalles.KEY_Name +"  from " + DataBaseDetalles.TABLE+" where "+ DataBaseDetalles.KEY_Name+" like   '%"+ nombre+"%'" , null);
        try {
            if (c.moveToFirst()) {
                if(c.getString(0).equals(nombre)){
                    existe = true;
                }else {
                    existe = false;
                }

            }
        } catch (Exception e) {}

        return existe;


    }


}


