package com.example.electionactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ElectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_election)

        // Referencias a los elementos del diseño
        val cbRaenira = findViewById<CheckBox>(R.id.cbRaenira)
        val cbAegon = findViewById<CheckBox>(R.id.cbAegon)
        val tvOptionInfo = findViewById<TextView>(R.id.tvOptionInfo)
        val btnHincarRodilla = findViewById<Button>(R.id.btnHincarRodilla)

        cbRaenira.setOnClickListener{
            boton()
        }
        cbAegon.setOnClickListener{
            boton()
        }
        btnHincarRodilla.setOnClickListener{
            val intent = Intent(this@ElectionActivity, ResActivity::class.java)
            when {
                cbRaenira.isChecked && cbAegon.isChecked -> {
                    intent.putExtra("decision", "Ambos")
                }
                cbRaenira.isChecked -> {
                    intent.putExtra("decision", "Raenira Targaryen")
                }
                cbAegon.isChecked -> {
                    intent.putExtra("decision", "Aegon Targaryen")
                }
                else -> {
                    intent.putExtra("decision", "Ninguno")
                }
            }
            //iniciar la nueva actividad
            startActivity(intent)
        }
    }
    fun goToResultado(){

    }


    fun boton(){
        val cbRaenira = findViewById<CheckBox>(R.id.cbRaenira)
        val cbAegon = findViewById<CheckBox>(R.id.cbAegon)
        val tvOptionInfo = findViewById<TextView>(R.id.tvOptionInfo)

        when {
            cbRaenira.isChecked && cbAegon.isChecked -> {
                tvOptionInfo.apply {  text = "Jugar a dos bandas es muy peligroso... Tu cabeza podrá rodar en cualquier momento."}
            }
            cbRaenira.isChecked -> {
                tvOptionInfo.apply {  text = "Has decidido apoyar a una mujer por encima del primogénito varón... Lo pagarás con sangre."}
            }
            cbAegon.isChecked -> {
                tvOptionInfo.apply { text = "Has elegido a Aegon contra la voluntad del difunto rey... Arderás por tu elección... Dracarys!"}
            }
            else -> {
                tvOptionInfo.apply { text = "Si no tomas una decisión no podrás salir de esta encrucijada."}
            }
        }

    }
}