package com.example.roomsql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import com.example.roomsql.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        val bd = MainbD.getBd(this)
        bd.getDao().getAllItem().asLiveData()
            .observe(this) { list -> // Сюда будут приходить данные с бд
                bindingClass.tvList.text = ""
                list.forEach {
                    val text = "Id: ${it.id} Name: ${it.name} Price: ${it.price} \n"
                    bindingClass.tvList.append(text)
                }
            }
        bindingClass.save.setOnClickListener {
            val item = Entity(
                null,
                bindingClass.edName.text.toString(),
                bindingClass.edPrice.text.toString()
            )
            Thread {
                bd.getDao().insertItem(item)
            }.start()
        }
    }
}