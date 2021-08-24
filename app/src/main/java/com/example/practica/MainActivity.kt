package com.example.practica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.apple

class MainActivity : AppCompatActivity() {
    private lateinit var txvInfo: TextView
    private lateinit var appleList: Array<apple>
    private var indexList: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txvInfo = findViewById(R.id.txvInfo)
        this.appleList = arrayOf<apple>()
    }

    fun createNew(view: View) {
        var randomNumber = (0..150).random()
        var a: apple
        when(randomNumber) {
            in 0..10 -> a = apple("iPhone 12", 20000, "Teléfono Móvil")
            in 11..50 -> a = apple("iPad Pro", 21000, "Tableta Móvil")
            in 51..100 -> a = apple("MacBook Air", 25000, "Computadora Portátil")
            in 101..110 -> a = apple("MacBook Pro", 34500, "Computadora Portátil")
            in 111..120 -> a = apple("iMac", 33500, "Computadora de Escritorio")
            else -> a = apple("Apple Watch", null, "Reloj Inteligente")
        }

        var newArray = arrayOf<apple>(*appleList, a)
        this.appleList = newArray
        if ( indexList == null ) {
            indexList = 0
        } else {
            indexList = indexList!! +1
        }

        showMessage("Ahora jugaras videojuegos en: ${a.nombre}")
        txvInfo.text = "Nombre: ${a.nombre}\n" +
                       "Categoria: ${a.categoria}\n" +
                       "Precio: $${a.precio}"
    }

    fun goBack(view: View){
        if ( indexList == 0 ) {
            if ( appleList.size != 1 ) {
                indexList = appleList.size - 1
            }
        } else {
            indexList = indexList!! - 1
        }

        txvInfo.text = "Nombre: ${appleList[indexList!!].nombre}\n" +
                       "Categoria: ${appleList[indexList!!].categoria}\n" +
                       "Precio: $${appleList[indexList!!].precio}"
    }

    fun goForward(view: View){
        if ( indexList == (appleList.size-1) ) {
            indexList = 0
        } else {
            indexList = indexList!! +1
        }

        txvInfo.text = "Nombre: ${appleList[indexList!!].nombre}\n" +
                       "Categoria: ${appleList[indexList!!].categoria}\n" +
                       "Precio: $${appleList[indexList!!].precio}"
    }

    fun showDevice(view: View){
        var randomNumber = (0..2).random()
        when(randomNumber) {
            0 -> showMessage("Tú ${appleList[indexList!!].nombre} no funciona")
            1 -> showMessage("Tú ${appleList[indexList!!].nombre} no tiene pila")
            2 -> showMessage("Checa insta en tú ${appleList[indexList!!].nombre}")
        }
    }

    fun checkDevice(view: View){
        var randomNumber = (0..2).random()
        when(randomNumber) {
            0 -> showMessage("Estás viendo Facebook en ${appleList[indexList!!].nombre}")
            1 -> showMessage("Desbloquea tú ${appleList[indexList!!].nombre}")
            2 -> showMessage("Tienes muchas fotos en tú ${appleList[indexList!!].nombre}")
        }
    }

    fun review(view: View){
        var randomNumber = (0..2).random()
        when(randomNumber) {
            0 -> showMessage("Mi ${appleList[indexList!!].nombre} ya no sirve")
            1 -> showMessage("El ${appleList[indexList!!].nombre} es una chulada")
            2 -> showMessage("Quiero el dinero que pagué por mi ${appleList[indexList!!].nombre}")
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}