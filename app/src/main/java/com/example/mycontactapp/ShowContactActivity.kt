package com.example.mycontactapp

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ShowContactActivity : AppCompatActivity() {

    var db: SQLiteDatabase?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_contact)

        db=openOrCreateDatabase("mycontact.db",
            MODE_PRIVATE,null)
        var cur=db?.rawQuery("select * from mcontact",null)
        var i=0;
        var data= arrayOf("")
        if (cur != null) {
            while(cur.moveToNext())
            {
                data=data.plus(cur.getString(0) + "\n" +
                        cur.getString(1))
                i=i+1;
            }
        }
        var adp=ArrayAdapter(this,
            android.R.layout.simple_list_item_1,data);
        var lst1=findViewById(R.id.lst1) as ListView
        lst1.adapter=adp;
    }
}