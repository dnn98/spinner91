package com.example.spinner91;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper db=null;
    private Cursor cur=null;
    private Spinner desplegable = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        desplegable = (Spinner) this.findViewById(R.id.spinner2);

        db= new DatabaseHelper(this);

        cur = db.getReadableDatabase().rawQuery("SELECT idCategoria AS _id, nom FROM Categoria", null);
        startManagingCursor(cur);

        String[] from = new String[] {"nom"};

        int[] to = new int[] {
                android.R.id.text1
        };

        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cur, from, to);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        desplegable.setAdapter(mAdapter);

    }
}
