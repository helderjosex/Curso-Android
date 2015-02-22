package br.com.cd.threads.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cd-101 on 22/02/2015.
 */
public class SQLHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "db_academico";
    public static final int DATABASE_VERSION = 1;
    public static final String ALUNO_TABLE_NAME = "aluno";

    private Context context;
    private String name;

    public SQLHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // CRIAR TABELA
         db.execSQL("CREATE table " + ALUNO_TABLE_NAME + " (" +
                        "id integer primary key autoincrement," +
                        "nome varchar(255) not null," +
                        "email varchar(255)," +
                        "matricula varchar(255) not null," +
                        "foto varchar(255)" +

                   ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ALUNO_TABLE_NAME);
        onCreate(db);
    }
}
