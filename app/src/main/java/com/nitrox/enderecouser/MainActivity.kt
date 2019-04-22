package com.nitrox.enderecouser

import android.net.Uri
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.jetbrains.annotations.Contract

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        object: AsyncTask<Void, Void, Unit>() {
            override fun doInBackground(vararg params: Void?) {
                val selectionClause = "id" + " = ?"
                val selectionArgs = arrayOf("3")
                val cursor = contentResolver.query(
                    //Uri.parse("content://com.nitrox.enderecoex.provider/endereco"), null, selectionClause, selectionArgs, null
                    Uri.parse("content://com.nitrox.enderecoex.provider/endereco"), null, null, null, null
                )
                //cursor.moveToFirst();
                cursor.move(1)
                Log.v(TAG, "Cursor da consulta: ${cursor.getString(0)}")
            }
        }.execute()
    }
}
