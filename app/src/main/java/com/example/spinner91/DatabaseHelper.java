package com.example.spinner91;

    import android.content.ContentValues;
        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.hardware.SensorManager;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="db";
    public static final String TABLE_NAME = "Categoria";
    public static final String COLUMN_NAME_ID = "idCategoria";
    public static final String COLUMN_NAME_NOM = "nom";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE " + DatabaseHelper.TABLE_NAME + " (" + DatabaseHelper.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," + DatabaseHelper.COLUMN_NAME_NOM + " TEXT)";
        db.execSQL("DROP TABLE IF EXISTS Categoria");
        db.execSQL(SQL_CREATE_ENTRIES);

        ContentValues cv=new ContentValues();

        cv.put(COLUMN_NAME_ID, "1");
        cv.put(COLUMN_NAME_NOM, "Restaurantes");
        db.insert("Categoria", COLUMN_NAME_ID, cv);

        cv.put(COLUMN_NAME_ID, "2");
        cv.put(COLUMN_NAME_NOM, "Bares");
        db.insert("Categoria", COLUMN_NAME_ID, cv);

        cv.put(COLUMN_NAME_ID, "3");
        cv.put(COLUMN_NAME_NOM, "Compras");
        db.insert("Categoria", COLUMN_NAME_ID, cv);

        cv.put(COLUMN_NAME_ID, "4");
        cv.put(COLUMN_NAME_NOM, "Dinero");
        db.insert("Categoria", COLUMN_NAME_ID, cv);

        cv.put(COLUMN_NAME_ID, "5");
        cv.put(COLUMN_NAME_NOM, "Indicaciones");
        db.insert("Categoria", COLUMN_NAME_ID, cv);

        cv.put(COLUMN_NAME_ID, "6");
        cv.put(COLUMN_NAME_NOM, "Dias y meses");
        db.insert("Categoria", COLUMN_NAME_ID, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        android.util.Log.w("Constants", "Upgrading database, which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS constants");
        onCreate(db);
    }
}

