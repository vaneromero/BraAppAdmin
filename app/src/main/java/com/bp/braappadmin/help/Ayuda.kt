package com.bp.braappadmin.help

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bp.braappadmin.ClickListener
import com.bp.braappadmin.R
import com.bp.braappadmin.comunicacion.chat.model.User
import com.bp.braappadmin.inicio.LoginActivity
import com.bp.braappadmin.inicio.Splash
import com.bp.braappadmin.inicio.Splash.PreferenceHelpe6.ayu
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.activi
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.tono
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum1
import com.bp.braappadmin.menuP.MenuPrinci
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_ayuda.*
import kotlinx.android.synthetic.main.activity_detalles.*
import spencerstudios.com.bungeelib.Bungee

class Ayuda : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda)
        var listaM: RecyclerView? = null
        var adaptador: AdaptadorCustom111? = null
        var layoutManager: RecyclerView.LayoutManager? = null
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

        val texto3: ConstraintLayout = findViewById(R.id.comddv)
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto3.startAnimation(anim1)
        val Archivo6 = "Ayuda"
        val defaultPrefs6 = Splash.PreferenceHelpe6.defaultPreference6(this)
        defaultPrefs6.ayu = 0
        val prefs6 = Splash.PreferenceHelpe6.customPreference6(this, Archivo6)
        if (prefs6.ayu == 0) {
            userImage3.setBackgroundResource(R.drawable.help2)
            userImage4.setBackgroundResource(R.drawable.audio)
            ayudaN.visibility = View.VISIBLE
            Audio.visibility = View.GONE
            titd.text = "Ayuda General"
        }

        else if (prefs6.ayu == 1) {
            userImage3.setBackgroundResource(R.drawable.help)
            userImage4.setBackgroundResource(R.drawable.audio2)
            Audio.visibility = View.VISIBLE
            ayudaN.visibility = View.GONE
            titd.text = "Ajustes de Audio"
        }
        userImage3.setOnClickListener {
            prefs6.ayu = 0
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (prefs6.ayu == 0) {
                userImage3.setBackgroundResource(R.drawable.help2)
                userImage4.setBackgroundResource(R.drawable.audio)
                ayudaN.visibility = View.VISIBLE
                Audio.visibility = View.GONE
                titd.text = "Ayuda General"
            } else if (prefs6.ayu == 1) {
                userImage3.setBackgroundResource(R.drawable.help)
                userImage4.setBackgroundResource(R.drawable.audio2)
                Audio.visibility = View.VISIBLE
                ayudaN.visibility = View.GONE
                titd.text = "Ajustes de Audio"
            }
        }
        userImage4.setOnClickListener {
            prefs6.ayu = 1
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (prefs6.ayu == 0) {
                userImage3.setBackgroundResource(R.drawable.help2)
                userImage4.setBackgroundResource(R.drawable.audio)
                Audio.visibility = View.GONE
                ayudaN.visibility = View.VISIBLE
                titd.text = "Ayuda General"
            } else if (prefs6.ayu == 1) {
                userImage3.setBackgroundResource(R.drawable.help)
                userImage4.setBackgroundResource(R.drawable.audio2)
                Audio.visibility = View.VISIBLE
                ayudaN.visibility = View.GONE
                titd.text = "Ajustes de Audio"
            }
        }
        cardView8.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            alert(1)
        }
        cardView25.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            alert(2)
        }
        cardView.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            alert(3)
        }
        cardView6.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            alert(5)
        }
        cardView13.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            alert(9)
        }
        cardView35.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            alert(10)
        }
        cardView9.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            alert(12)
        }
        ajuste.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            alert(13)
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

                cloavd.text = "Clave: ${currentUser!!.avanzada}"
            }

        })
        val datos = ArrayList<ayudaaa>()
        datos.add(
            ayudaaa(
                "Cerrar Sesión",
                R.drawable.ced
            )
        )
        datos.add(
            ayudaaa(
                "Botón de ajustes de audio",
                R.drawable.ajus2
            )
        )
        datos.add(
            ayudaaa(
                "Links Vacíos",
                R.drawable.carpeta1
            )
        )
        datos.add(
            ayudaaa(
                "Más",
                R.drawable.mas
            )
        )

        listaM = findViewById(R.id.ayudaN)
        listaM?.setHasFixedSize(true)  //adaptador tamaño de la vista

        layoutManager = StaggeredGridLayoutManager(2, RecyclerView.HORIZONTAL)
        listaM?.layoutManager = layoutManager  // donde se dibuje el layout


        adaptador = AdaptadorCustom111(this, datos, object : ClickListener {
            override fun onClick(vista: View, index: Int) {

                alert2(index)

            }
        })
        listaM?.adapter = adaptador
    }

    fun alert(dato: Int) {
        Bungee.zoom(this)
        val customDialog = Dialog(this)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.setContentView(R.layout.activity_detalles)
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        when (dato) {
            1 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.dereflecha)
                customDialog.textView9.text = "Flechas"
                customDialog.aparece1.text = "En los controles de Tonos y Melodías"
                customDialog.funcion1.text =
                    "Permite los movimientos de izquierda a derecha entre los tonos y melodías, así como la asignación del mismo."
            }
            2 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.vol)
                customDialog.textView9.text = "Identificador de Volumen"
                customDialog.aparece1.text = "Aparece donde se controlan el volumen."
                customDialog.funcion1.text =
                    "Guiar la categoría para modificar el volumen del audio."
            }
            3 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.cancion)
                customDialog.textView9.text = "Nota Musical 2"
                customDialog.aparece1.text =
                    "Aparece en el encabezado de la canción ya seleccionada o predeterminada."
                customDialog.funcion1.text = "Mostrar el apartado de la canción."
            }

            5 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.cond)
                customDialog.textView9.text =
                    "Identificador de Tono o Canción y control de cambios."
                customDialog.aparece1.text = "Aparece a lado de cada tono o melodía."
                customDialog.funcion1.text =
                    "Mostrar el tono o Melodía ya establecida, así como el detener y continuar melodía."
            }

            7 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.creditos1)
                customDialog.textView9.text = "Botón de créditos"
                customDialog.aparece1.text = "Aparece en la parte superior."
                customDialog.funcion1.text = "Permite ver la información de los Administradores."
            }

            9 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.restablecer1)
                customDialog.textView9.text = "Botón Restablecer"
                customDialog.aparece1.text = "Aparece en la parte superior."
                customDialog.funcion1.text =
                    "Sirve para restablecer el volumen, tono y melodía predeterminada."
            }
            10 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.nota)
                customDialog.textView9.text = "Nota Musical 1"
                customDialog.aparece1.text =
                    "Aparece en el encabezado de la tono ya seleccionada o predeterminada."
                customDialog.funcion1.text = "Mostrar el apartado del tono."
            }
            12 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.volu1)
                customDialog.textView9.text = "Control de volumen"
                customDialog.aparece1.text = "Aparece al final de cada apartado."
                customDialog.funcion1.text = "Controla la cantidad de volumen del 1-10 como máximo."
            }
            13 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.ajus1)
                customDialog.textView9.text = "Tema Principal"
                customDialog.aparece1.text = "Aparece de encabezado."
                customDialog.funcion1.text = "Sin función."
            }
            14 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.ajus2)
                customDialog.textView9.text = "Botón de ajustes de audio"
                customDialog.aparece1.text = "Aparece de encabezado en el lado derecho."
                customDialog.funcion1.text = "Sirve para entrar a la modificación de audio."
            }


        }
        customDialog.show()
    }

    fun alert2(dato: Int) {
        Bungee.zoom(this)
        val customDialog = Dialog(this)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.setContentView(R.layout.activity_detalles)
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        when (dato) {
            0 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.ced)
                customDialog.textView9.text = "Cerrar Sesión"
                customDialog.aparece1.text = "Aparece en Menú Principal"
                customDialog.funcion1.text =
                    "Sirve para Cerrar los canales de comunicación."
            }
            1 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.ajus2)
                customDialog.textView9.text = "Audio"
                customDialog.aparece1.text =
                    "Aparece en la parte superior de Menú Principal."
                customDialog.funcion1.text = "Permite acceder a las configuraciones de audio."
            }
            2 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.mas)
                customDialog.textView9.text = "Links Vacíos"
                customDialog.aparece1.text =
                    "Tienes que poner un enlace si no hay link. ----extra.html----"
                customDialog.funcion1.text = "Para que detecte la nueva pagina."
            }
            3 -> {
                customDialog.textView10.setBackgroundResource(R.drawable.mas)
                customDialog.textView9.text = "Más"
                customDialog.aparece1.text =
                    "Agregaremos más adelante."
                customDialog.funcion1.text = "Agregaremos más adelante."
            }

        }
        customDialog.show()
    }
    override fun onPause() {
        super.onPause()
        mediaPlayer!!.pause()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer!!.start()
    }
    override fun onBackPressed() {
        val Archivo1 = "Audio"
        val defaultPrefs1 = Splash.PreferenceHelper1.defaultPreference1(this)
        defaultPrefs1.tono = 1
        defaultPrefs1.melodia = 1
        defaultPrefs1.volum = 0.10f
        defaultPrefs1.volum1 = 1.00f
        val prefs1 = Splash.PreferenceHelper1.customPreference1(this, Archivo1)
        mediaPlayer?.stop()
        prefs1.activi = ""
        super.onBackPressed()
        Bungee.zoom(this)
    }
}