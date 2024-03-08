package com.trabajo.individualsoftware

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    /**
     * Variable que selecciona el buton para retroceder de Layout
     */
    lateinit var atras: ImageButton;
    /**
     * Variable que selecciona el buton para avanzar de Layout
     */
    lateinit var siguiente: ImageButton;

    /**
     * Variable que selecciona el texto de mensajes de validacion
     */
    lateinit var textoValidacion: TextView;

    /**
     * Variable que selecciona el nombre del formulario
     */
    lateinit var nombre: EditText;

    /**
     * Variable que selecciona el apellido del formulario
     */
    lateinit var apellido: EditText;

    /**
     * Variable que selecciona el correo del formulario
     */
    lateinit var correo: EditText;

    /**
     * Variable que selecciona el sexo masculino del formulario
     */
    lateinit var sexoMasculino: RadioButton;

    /**
     * Variable que selecciona el sexo femenino del formulario
     */
    lateinit var sexoFemenino: RadioButton;

    /**
     * Variable que selecciona el perfil del formulario
     */
    lateinit var perfil: Switch;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        atras = findViewById(R.id.imageButton2)
        siguiente = findViewById(R.id.imageButton3)
        textoValidacion = findViewById(R.id.textView8)
        nombre = findViewById(R.id.editTextTextPersonName)
        apellido = findViewById(R.id.editTextTextPersonName2)
        correo = findViewById(R.id.editTextTextEmailAddress)
        sexoMasculino = findViewById(R.id.radioButton)
        sexoFemenino = findViewById(R.id.radioButton2)
        perfil = findViewById(R.id.switch1)

        atras.setOnClickListener {
            val activityUno = Intent(this, MainActivity::class.java)
            startActivity(activityUno)
        }

        siguiente.setOnClickListener {

            if (!validacion()){
                textoValidacion.setText("")
                val activityTres = Intent(this, MainActivity3::class.java)
                activityTres.putExtra("nombre", nombre.text.toString())
                activityTres.putExtra("apellido", apellido.text.toString())
                activityTres.putExtra("correo", correo.text.toString())
                activityTres.putExtra("sexo",seleccionarTextoSexo())
                activityTres.putExtra("perfil", seleccionarPerfilTexto())
                startActivity(activityTres)
            }else{
                textoValidacion.setText("[Error] Inserte todos sus datos basicos para continuar")
            }


        }

    }

    /**
     * Metodo que valida el formulario
     */
    fun validacion(): Boolean {
        var banderaValidacion: Boolean = false;

        if (nombre.text.isEmpty()){
            banderaValidacion = true;
        }else if (apellido.text.isEmpty()){
            banderaValidacion = true;
        }else if(correo.text.isEmpty()){
            banderaValidacion = true;
        }

        return banderaValidacion;
    }

    /**
     * Metodo para convertir a texto el resultado de RadioGrup
     */
    fun seleccionarTextoSexo(): String{
        var seleccionarSexo: String = ""

        if (sexoMasculino.isChecked){
            seleccionarSexo = "Masculino"
        }else{
            seleccionarSexo = "Femenino"
        }

        return  seleccionarSexo
    }

    /**
     * Metodo para convertir a texto el resultado de swich
     */
    fun seleccionarPerfilTexto(): String{
        var seleccionarPerfil: String = ""
        if (perfil.isChecked){
            seleccionarPerfil = "Docente"
        } else{
            seleccionarPerfil = "Estudiante"
        }

        return seleccionarPerfil
    }
}