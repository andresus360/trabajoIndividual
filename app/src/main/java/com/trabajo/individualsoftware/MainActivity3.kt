package com.trabajo.individualsoftware

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {

    /**
     * Variable que selecciona el nombre del Layout
     */
    lateinit var nombreTexto: TextView;

    /**
     * Variable que selecciona el apellido del Layout
     */
    lateinit var apellidoTexto: TextView;

    /**
     * Variable que selecciona el correo del Layout
     */
    lateinit var correoTexto: TextView;

    /**
     * Variable que selecciona el sexo del Layout
     */
    lateinit var sexoTexto: TextView;

    /**
     * Variable que selecciona el perfil del Layout
     */
    lateinit var perfilTexto: TextView;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        nombreTexto = findViewById(R.id.textView4)
        apellidoTexto = findViewById(R.id.textView5)
        correoTexto = findViewById(R.id.textView9)
        sexoTexto = findViewById(R.id.textView6)
        perfilTexto = findViewById(R.id.textView7)
        mostrarInfo()

    }

    /**
     * Metodo que establece el texto de los TextView en el Layout
     */
    fun mostrarInfo(){
        val blunde = intent.extras
        nombreTexto.setText(nombreTexto.text.toString() + blunde?.getString("nombre"))
        apellidoTexto.setText(apellidoTexto.text.toString() + blunde?.getString("apellido"))
        correoTexto.setText(correoTexto.text.toString() + blunde?.getString("correo"))
        sexoTexto.setText(sexoTexto.text.toString() + blunde?.getString("sexo"))
        perfilTexto.setText(perfilTexto.text.toString() + blunde?.getString("perfil"))
    }
}