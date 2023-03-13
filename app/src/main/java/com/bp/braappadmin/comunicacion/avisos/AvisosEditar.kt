package com.bp.braappadmin.comunicacion.avisos

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.bp.braappadmin.R
import com.bp.braappadmin.comunicacion.chat.model.User
import com.bp.braappadmin.help.Ayuda
import com.bp.braappadmin.inicio.Splash
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.activi
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.tono
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum1
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.clave
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.codi
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.entrada
import com.bp.braappadmin.menuP.MenuPrinci
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_avisos_editar.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.text.SimpleDateFormat
import java.util.*

class AvisosEditar : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avisos_editar)
        val texto2: ConstraintLayout = findViewById(R.id.jsjfvjnfvt98987)
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto2.startAnimation(anim1)
        val Archivo1 = "Audio"
        val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(this)
        defaultPrefs1.tono = 1
        defaultPrefs1.melodia = 1
        defaultPrefs1.activi = ""
        defaultPrefs1.volum = 0.10f
        defaultPrefs1.volum1 = 1.00f
        val prefs1 = Splash.PreferenceHelper1.customPreference1(this, Archivo1)
        var carga = prefs1.tono
        soundPool = SoundPool(100, AudioManager.STREAM_MUSIC, 0)
        mediaPlayer = MediaPlayer()

        when (prefs1.tono) {
            1 -> {
                carga = soundPool!!.load(this, R.raw.ton1, 1)
            }
            2 -> {
                carga = soundPool!!.load(this, R.raw.ton2, 1)
            }
            3 -> {
                carga = soundPool!!.load(this, R.raw.ton3, 1)
            }
            4 -> {
                carga = soundPool!!.load(this, R.raw.ton4, 1)
            }
            5 -> {
                carga = soundPool!!.load(this, R.raw.ton5, 1)
            }
            6 -> {
                carga = soundPool!!.load(this, R.raw.ton6, 1)
            }
            7 -> {
                carga = soundPool!!.load(this, R.raw.ton7, 1)
            }
            8 -> {
                carga = soundPool!!.load(this, R.raw.ton8, 1)
            }
            9 -> {
                carga = soundPool!!.load(this, R.raw.ton9, 1)
            }
            10 -> {
                carga = soundPool!!.load(this, R.raw.ton10, 1)
            }
        }
        when (prefs1.melodia) {

            1 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo1)
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            2 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo2)
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            3 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo3)
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            4 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo4)
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            5 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo5)
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            6 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo6)
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            7 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo7)
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            8 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo8)
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            9 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo9)
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }
            10 -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.melo10)
                mediaPlayer!!.setVolume(prefs1.volum, prefs1.volum)
                mediaPlayer!!.start()
                mediaPlayer!!.isLooping = true
            }

        }
        titulo.setOnFocusChangeListener { view, b ->
            if (b){
                soundPool!!.play(
                    carga,
                    prefs1.volum1,
                    prefs1.volum1,
                    0,
                    0,
                    1f
                )

            }
            else {
                view.clearFocus()
            }
        }
        nota.setOnFocusChangeListener { view, b ->
            if (b){
                soundPool!!.play(
                    carga,
                    prefs1.volum1,
                    prefs1.volum1,
                    0,
                    0,
                    1f
                )

            }
            else {
                view.clearFocus()
            }
        }
        Ayuda001aa.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            mediaPlayer!!.pause()
                startActivity(Intent(this, Ayuda::class.java))
                Bungee.zoom(this)
            }
        val firebase: FirebaseUser = FirebaseAuth.getInstance().currentUser!!
        var userid = firebase.uid
        FirebaseMessaging.getInstance().subscribeToTopic("/topics/$userid")
        val databaseReference: DatabaseReference =
            FirebaseDatabase.getInstance().getReference("Administradores/$userid")
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val currentUser = snapshot.getValue(User::class.java)
                bu31.text = currentUser!!.userName
                when (currentUser!!.sexo) {
                    "Masculino" -> {
                        fotito111.setBackgroundResource(R.drawable.businessman)
                    }
                    "Femenino" -> {
                        fotito111.setBackgroundResource(R.drawable.businesswoman)
                    }
                    "no" -> {
                        fotito111.setBackgroundResource(R.drawable.interrogation)
                    }
                }
            }
        })
        val bundle: Bundle? = intent.extras
        bundle?.let { bundleLibriDeNull ->
            val area = bundleLibriDeNull.getString("llave", "")
            val area1 = bundleLibriDeNull.getString("llave1", "")
            if (area1 == "Todo") {
                editars.visibility = View.VISIBLE
                dosss.visibility = View.GONE
                db.collection("Avisos").whereEqualTo("fecha", "$area")
                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            fechaa.text = "${document.get("fecha")}"
                            user1.setText("${document.get("titulo")}")
                            respuesta.setText("${document.get("Descrip")}")
                            user24.text = "${document.id}"
                        }
                    }
                    .addOnFailureListener { exception ->
                        toast("Error al devolver la información")
                    }
            }
            else {
                editars.visibility = View.GONE
                dosss.visibility = View.VISIBLE
            }
        }
        saveButto443.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val area = fechaa.text
            if (respuesta.text.isEmpty()) {
                toast("Error al guardar la información")
            } else if (!respuesta.text.isEmpty()) {
                db.collection("Avisos").whereEqualTo("fecha", "$area")
                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            fechaa.text = "${document.get("fecha")}"
                            user1.setText("${document.get("titulo")}")
                            respuesta.setText("${document.get("Descrip")}")
                            user24.text = "${document.id}"
                        }
                    }
                    .addOnFailureListener { exception ->
                        toast("Error al devolver la información")
                    }
                db.collection("Avisos").document(user24.text.toString())
                    .update("Descrip", respuesta.text.toString())
                db.collection("Avisos").document(user24.text.toString())
                    .update("titulo", user1.text.toString())
                toast("Datos Actualizados")
                val Archivo2 = "Chat"
                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(this)
                defaultPrefs2.entrada = 0
                defaultPrefs2.clave = 0
                defaultPrefs2.codi = 0

                val prefs2 = Splash.PreferenceHelper2.customPreference2(this, Archivo2)

                val accion="Se Actualizó Avisos."
                val codidd= prefs2.codi
                val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                val fecha1 = sdf1.format(Date())
                var lugar="Movil"

                val Log = hashMapOf(
                    "accion" to accion,
                    "codidd" to codidd,
                    "fecha1" to fecha1,
                    "lugar" to lugar,
                )
                db.collection("Logs")
                    .add(Log)
                    .addOnSuccessListener {
                        startActivity(Intent(this@AvisosEditar, Avisos::class.java))
                        limpiar()
                        Bungee.zoom(this@AvisosEditar)
                        finish()

                    }
                    .addOnFailureListener { e ->

                    }

            }
        }
        deleteButto443.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val area = fechaa.text
            db.collection("Avisos").whereEqualTo("fecha", "$area")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        fechaa.text = "${document.get("fecha")}"
                        user1.setText("${document.get("titulo")}")
                        respuesta.setText("${document.get("Descrip")}")
                        user24.text = "${document.id}"
                    }
                }
                .addOnFailureListener { exception ->
                    toast("Error al devolver la información")
                }
            db.collection("Avisos").document(user24.text.toString()).delete()
            toast("Datos Eliminados")
            val Archivo2 = "Chat"
            val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(this)
            defaultPrefs2.entrada = 0
            defaultPrefs2.clave = 0
            defaultPrefs2.codi = 0

            val prefs2 = Splash.PreferenceHelper2.customPreference2(this, Archivo2)

            val accion="Se Eliminó Avisos."
            val codidd= prefs2.codi
            val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
            val fecha1 = sdf1.format(Date())
            var lugar="Movil"

            val Log = hashMapOf(
                "accion" to accion,
                "codidd" to codidd,
                "fecha1" to fecha1,
                "lugar" to lugar,
            )
            db.collection("Logs")
                .add(Log)
                .addOnSuccessListener {
                    startActivity(Intent(this@AvisosEditar, Avisos::class.java))
                    limpiar()
                    Bungee.zoom(this@AvisosEditar)
                    finish()

                }
                .addOnFailureListener { e ->

                }

        }
        saveButto4.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val tituloT = titulo.text.toString()
            val notaT = nota.text.toString()
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
            val fecha = sdf.format(Date())
            if (!TextUtils.isEmpty(fecha) && !TextUtils.isEmpty(notaT)) {
                val user = hashMapOf(
                    "fecha" to fecha,
                    "titulo" to tituloT,
                    "Descrip" to notaT,
                )
                db.collection("Avisos")
                    .add(user)
                    .addOnSuccessListener {
                        toast("Aviso Guardado")
                    }
                    .addOnFailureListener { e ->
                        toast("Aviso No Guardado")
                    }
                titulo.setText("")
                nota.setText("")

                val Archivo2 = "Chat"
                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(this)
                defaultPrefs2.entrada = 0
                defaultPrefs2.clave = 0
                defaultPrefs2.codi = 0

                val prefs2 = Splash.PreferenceHelper2.customPreference2(this, Archivo2)

                val accion="Se Guardó Avisos."
                val codidd= prefs2.codi
                val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                val fecha1 = sdf1.format(Date())
                var lugar="Movil"

                val Log = hashMapOf(
                    "accion" to accion,
                    "codidd" to codidd,
                    "fecha1" to fecha1,
                    "lugar" to lugar,
                )
                db.collection("Logs")
                    .add(Log)
                    .addOnSuccessListener {
                        startActivity(Intent(this@AvisosEditar, Avisos::class.java))
                        limpiar()
                        Bungee.zoom(this@AvisosEditar)
                        finish()

                    }
                    .addOnFailureListener { e ->

                    }
            } else {
                toast("Campos vacios")
            }
        }
    }

    private fun toast(s: String) {
        val customLayout = layoutInflater.inflate(R.layout.toast, toast23)
        val toast = Toast(this)
        toast.duration = Toast.LENGTH_SHORT
        toast.setGravity(Gravity.TOP or Gravity.RIGHT, 0, 0)
        toast.view = customLayout
        customLayout.toastT.text = s
        toast.show()
    }

    fun limpiar() {
        respuesta.setText("")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        mediaPlayer!!.stop()
        startActivity(Intent(this@AvisosEditar, Avisos::class.java))
        Bungee.zoom(this)
        finish()
    }
    override fun onPause() {
        super.onPause()
        mediaPlayer!!.pause()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer!!.start()
    }
}