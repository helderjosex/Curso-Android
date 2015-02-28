package br.com.cd.threads.providers;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import java.sql.SQLException;

import br.com.cd.threads.database.AlunoDAO;
import br.com.cd.threads.database.SQLHelper;

public class AlunosContentProvider extends ContentProvider {

    private static final String AUTHORITIES = "br.com.cd";
    static final String URL =  "content:// " + AUTHORITIES + "/alunos";
    static final Uri CONTENT_URI = Uri.parse(URL);
    private static final UriMatcher uriMatcher;
    public static final int ALUNOS = 1;
    public static final int ALUNO_ID = 2;
    private AlunoDAO dao;

    // TIPO DE ROUTES
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITIES,"aluno", ALUNOS);
        uriMatcher.addURI(AUTHORITIES,"aluno/#", ALUNO_ID);
    }

    public AlunosContentProvider() {
        dao = new AlunoDAO(getContext());
    }


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
       int count = 0;

        switch (uriMatcher.match(uri))
        {
            case ALUNOS:
                count = dao.remove(selection, selectionArgs);
                break;
            case ALUNO_ID:
                String id = uri.getPathSegments().get(1);
                count = dao.remove("id = ?", new String[]{id});
                break;
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        switch (uriMatcher.match(uri)){
            case ALUNOS:
                return "vnd.android.cursor.dir/vnd.examplo.alunos";
            case ALUNO_ID:
                return "vnd.android.cursor.item/vnd.exemplo.alunos";
            default: throw new IllegalArgumentException("Unsupported URL:" + uri);

        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long id = dao.insertUri(values);

        if (id > 0) {
            Uri newUri = ContentUris.withAppendedId(CONTENT_URI, id);
            getContext().getContentResolver().notifyChange(newUri, null);
            return newUri;
        }

        try {
            throw new SQLException("Não foi possível inserir o aluno");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        switch (uriMatcher.match(uri)) {
            case ALUNOS:
                getContext().getContentResolver().notifyChange(uri, null);
                return dao.findAllUri("SELECT * FROM " + SQLHelper.ALUNO_TABLE_NAME, null);
            case ALUNO_ID:
                String id = uri.getPathSegments().get(1);
                getContext().getContentResolver().notifyChange(uri, null);
                return dao.findAllUri("SELECT * FROM " + SQLHelper.ALUNO_TABLE_NAME + " WHERE id = ?", new String[]{id});
        }

        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
