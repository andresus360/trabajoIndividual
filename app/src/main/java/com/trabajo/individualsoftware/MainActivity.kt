package com.trabajo.individualsoftware

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    /**
     * Variable que selecciona el boton para pasar de Layout
     */
    lateinit var siguiente: ImageButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        siguiente = findViewById(R.id.imageButton1)

        /**
         * Metodo que se ejecuta al dar click en el boton loging
         */
        siguiente.setOnClickListener {
            val activityDos = Intent(this, MainActivity2::class.java)
            startActivity(activityDos)
        }
    }
}