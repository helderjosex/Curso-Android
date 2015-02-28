package br.com.cd.threads.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.cd.threads.model.Aluno;

/**
 * Created by cd-101 on 22/02/2015.
 */
public class AlunoDAO  {

    private SQLiteDatabase db;
    private SQLHelper sqlHelper;

    public AlunoDAO(Context context){
        sqlHelper = new SQLHelper(context);
    }

    public void save(Aluno aluno){
        if(aluno.getId() == 0){
            insert(aluno);
        }else
        {
            update(aluno);
        }
    }

    public List<Aluno> findAll(){

        List<Aluno> alunos = new ArrayList<>();

        db = sqlHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + sqlHelper.ALUNO_TABLE_NAME,null);

        while (cursor.moveToNext()) {
            Aluno aluno = mountAluno(cursor);
            alunos.add(aluno);
        }

        return alunos;

    }

    public Cursor findAllUri(String sql, String [] selectionArgs){

        db = sqlHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, selectionArgs);


        return cursor;

    }

    public void insert (Aluno aluno){
        db = sqlHelper.getWritableDatabase();
        db.insert(sqlHelper.ALUNO_TABLE_NAME,null,getContentValues(aluno));
        db.close();
    }

    public long insertUri(ContentValues values) {
        db = sqlHelper.getWritableDatabase();
        long count = db.insert(sqlHelper.ALUNO_TABLE_NAME, null, values);
        db.close();

        return count;
    }

    public void update (Aluno aluno){
        db = sqlHelper.getWritableDatabase();
        db.update(sqlHelper.ALUNO_TABLE_NAME, getContentValues(aluno), "id = ?", new String[]{String.valueOf(aluno.getId())});
        db.close();
    }

    public void updateUri (String selection, String[] SelectionArgs, ContentValues values){
        db = sqlHelper.getWritableDatabase();
        db.update(SQLHelper.ALUNO_TABLE_NAME, values, selection, SelectionArgs);
        db.close();
    }

    public int delete (Aluno aluno){
        int count = db.delete(sqlHelper.ALUNO_TABLE_NAME,"id = ?", new String[]{String.valueOf(aluno.getId())});
        db.close();

        return count;
    }

    public int remove (String selection, String[] SelectionArgs){
        int count = db.delete(sqlHelper.ALUNO_TABLE_NAME,"id = ?", SelectionArgs);
        db.close();

        return count;
    }

    private ContentValues getContentValues(Aluno aluno) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",aluno.getId());
        contentValues.put("nome",aluno.getNome());
        contentValues.put("email",aluno.getNome());
        contentValues.put("matricula",aluno.getMatricula());
        contentValues.put("foto",aluno.getFoto());

        return contentValues;
    }

    private Aluno mountAluno(Cursor cursor) {
        Aluno aluno = new Aluno();
        aluno.setId(cursor.getInt(cursor.getColumnIndex("id")));
        aluno.setNome(cursor.getString(cursor.getColumnIndex("nome")));
        aluno.setEmail(cursor.getString(cursor.getColumnIndex("email")));
        aluno.setMatricula(cursor.getString(cursor.getColumnIndex("matricula")));
        aluno.setFoto(cursor.getString(cursor.getColumnIndex("foto")));
        return aluno;
    }

}
