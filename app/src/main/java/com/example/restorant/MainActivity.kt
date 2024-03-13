package com.example.restorant

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var edname:EditText
    private lateinit var edid:EditText
    private lateinit var edamount:EditText
    private lateinit  var edfood:EditText
    private lateinit var adbutton:Button
    private lateinit var delbutton:Button
    private lateinit var list:ListView
    var listresto = mutableListOf<Any>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edname = findViewById(R.id.editTextName)
        edid = findViewById(R.id.editTextID)
        edamount = findViewById(R.id.editTextAmount)
        edfood = findViewById(R.id.editTextFood)
        adbutton = findViewById(R.id.buttonAdd)
        delbutton = findViewById(R.id.buttonDelete)
        list = findViewById(R.id.listView)


        var adapter: ArrayAdapter<Any> = ArrayAdapter(this,android.R.layout.simple_list_item_1,listresto)
        list.adapter = adapter

        adbutton.setOnClickListener{
            add()
            adapter.notifyDataSetChanged()
        }
        delbutton.setOnClickListener {
            delet()
            adapter.notifyDataSetChanged()
        }



    }
    fun add(){
        var name = edname.text.toString()
        var id = edid.text.toString()
        var amount = edamount.text.toString()
        var food = edfood.text.toString()
        listresto.add(resto(name,id,amount,food))

    }
    fun delet(){
        listresto.removeAt(0)

    }
    data class resto(var name:String,var id:String,var amount:String, var food:String)
}