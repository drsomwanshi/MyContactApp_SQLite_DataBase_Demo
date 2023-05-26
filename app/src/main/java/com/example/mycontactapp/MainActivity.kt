package com.example.mycontactapp

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var db:SQLiteDatabase?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db=openOrCreateDatabase("mycontact.db",
            MODE_PRIVATE,null)
    }

    fun save(view: View) {
        db?.execSQL("create table if not exists mcontact" +
                "(name varchar(30)," +
                "contact varchar(30))")
        var txt1=findViewById(R.id.txt1) as EditText
        var txt2=findViewById(R.id.txt2) as EditText
        var name=txt1.text.toString()
        var mob=txt2.text.toString();
        db?.execSQL("insert into mcontact values('"+name+"','"+ mob+"')");
        Toast.makeText(this, "Contact Saved", Toast.LENGTH_SHORT).show();

    }
    fun show(view: View) {
        var i=Intent(this,
            ShowContactActivity::class.java)
        startActivity(i)
    }
}