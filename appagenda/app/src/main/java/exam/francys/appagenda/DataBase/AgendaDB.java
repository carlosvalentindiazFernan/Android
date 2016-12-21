package exam.francys.appagenda.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Francys on 20/12/2016.
 */

public class AgendaDB extends SQLiteOpenHelper{


    public AgendaDB(Context context) {
        super(context, DataBaseDetalles.name, null, DataBaseDetalles.version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String CREATE_TABLE = "CREATE TABLE " + DataBaseDetalles.TABLE + "("
                + DataBaseDetalles.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + DataBaseDetalles.KEY_Name + " TEXT, "
                + DataBaseDetalles.KEY_App + " TEXT, "
                + DataBaseDetalles.Key_Direccion + " TEXT, "
                + DataBaseDetalles.Key_Telefono +"TEXT ,"
                + DataBaseDetalles.Key_Correo + " TEXT, "
                + DataBaseDetalles.Key_Estado + " TEXT ,"
                + DataBaseDetalles.Key_Usuario +"TEXT,"
                + DataBaseDetalles.Key_Contrase+"TEXT )";

        db.execSQL(CREATE_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseDetalles.TABLE);
        onCreate(db);
    }
}
