package exam.francys.appagenda.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Francys on 20/12/2016.
 */

public class Diary extends SQLiteOpenHelper{

    private static  final   int     DATABASE_VERSION    =   3;
    private static  final   String  DATABASE_NAME       =   "Agenda.db";


    public Diary(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String CREATE_TABLE = "CREATE TABLE " + Details_DB.TABLE + "("
                + Details_DB.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Details_DB.KEY_Name + " TEXT, "
                + Details_DB.KEY_App + " TEXT, "
                + Details_DB.Key_Direccion + " TEXT, "
                + Details_DB.Key_Correo + " TEXT, "
                + Details_DB.Key_Telefono +" TEXT ,"
                + Details_DB.Key_Estado + " TEXT ,"
                + Details_DB.Key_Usuario +" TEXT,"
                + Details_DB.Key_Contrase+" TEXT )";

        Log.d("TABLE",CREATE_TABLE);

        db.execSQL(CREATE_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Details_DB.TABLE);

        onCreate(db);
    }
}
