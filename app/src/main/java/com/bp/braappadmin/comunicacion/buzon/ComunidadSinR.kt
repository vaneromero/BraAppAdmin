package com.bp.braappadmin.comunicacion.buzon

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bp.braappadmin.ClickListener
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
import kotlinx.android.synthetic.main.activity_buzzon1.*
import kotlinx.android.synthetic.main.activity_comunidad_sin_r.*
import kotlinx.android.synthetic.main.activity_menu_princi.*
import kotlinx.android.synthetic.main.buzzond.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ComunidadSinR : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    var adaptador: adaptadorD? = null
    var lita1: RecyclerView? = null
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    val datos = ArrayList<correol>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comunidad_sin_r)

        val texto1: ConstraintLayout = findViewById(R.id.cont44)
        val texto2: LinearLayout = findViewById(R.id.linearLayout3)
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto1.startAnimation(anim1)
        texto2.startAnimation(anim1)

        val firebase: FirebaseUser = FirebaseAuth.getInstance().currentUser!!
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
        datos.clear()
        setupRecyclerView()
        swipeRefresh1234511.setOnRefreshListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            datos.clear()
            setupRecyclerView()
            swipeRefresh1234511.isRefreshing = false
        }
        Ayuda001.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            mediaPlayer!!.pause()
            startActivity(Intent(this, Ayuda::class.java))
            Bungee.zoom(this)
        }
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
                bgu3d11.text = currentUser!!.userName
                when (currentUser!!.sexo) {
                    "Masculino" -> {
                        fotito1g111.setBackgroundResource(R.drawable.businessman)
                    }
                    "Femenino" -> {
                        fotito1g111.setBackgroundResource(R.drawable.businesswoman)
                    }
                    "no" -> {
                        fotito1g111.setBackgroundResource(R.drawable.interrogation)

                    }
                }

            }

        })

    }
    //para en espera
    @SuppressLint("WrongConstant")
    fun setupRecyclerView() {
        datos.clear()
        db.collection("Correo").whereEqualTo("respuesta", "En espera...")
            .get()
            .addOnSuccessListener { result ->
                datos.clear()
                for (document in result) {
                    datos.add(
                        correol(
                            "${document.get("fecha")}",
                            "${document.get("usuario")}",
                            "${document.get("respuesta")}"
                        )
                    )

                    lita1?.setHasFixedSize(true)  //adaptador tamaño de la vista
                    lita1 = findViewById(R.id.menuCorreo511)
                    layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                    lita1?.layoutManager = layoutManager  // donde se dibuje el layout
                    adaptador = adaptadorD(this@ComunidadSinR, datos, object : ClickListener {

                        override fun onClick(vista: View, index: Int) {
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
                                    alerta4("En espera...",datos[index].fecha,currentUser!!.userName)

                                }

                            })


                        }
                    })

                    lita1?.adapter = adaptador
                }
            }
            .addOnFailureListener { exception ->
                toast("Error al devolver la información")
            }
    }
    fun recargar(){
        finish(); overridePendingTransition(0, 0); startActivity(getIntent()); overridePendingTransition(0, 0);
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
    private fun alerta4(tipo:String,fecha:String,nombr:String) {
        val db = FirebaseFirestore.getInstance()
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.buzzond)
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )

        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            customDialog.respuesta1.visibility=View.GONE
            Log.v("prueba", "$tipo")
            db.collection("Correo").whereEqualTo("fecha", "$fecha")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        customDialog.fechaa.text = "${document.get("fecha")}"
                        customDialog.user.text = "${document.get("usuario")}"
                        customDialog.pregunta.text = "${document.get("pregunta")}"
                        customDialog.user24.text = "${document.id}"
                    }

                }
                .addOnFailureListener { exception ->
                    toast("Error al devolver la información")
                }
            customDialog.saveButto443.setOnClickListener {
                if (customDialog.respuesta.text.isEmpty()) {
                    toast("Error al guardar la información")
                } else if (!customDialog.respuesta.text.isEmpty()) {
                    db.collection("Correo").whereEqualTo("fecha", "$fecha")
                        .get()
                        .addOnSuccessListener { result ->
                            for (document in result) {
                                customDialog.fechaa.text = "${document.get("fecha")}"
                                customDialog.user.text = "${document.get("usuario")}"
                                customDialog.pregunta.text = "${document.get("pregunta")}"
                                customDialog.user24.text = "${document.id}"
                            }

                        }
                        .addOnFailureListener { exception ->
                            toast("Error al devolver la información")
                        }
                    db.collection("Correo").document(customDialog.user24.text.toString())
                        .update("respuesta", customDialog.respuesta.text.toString())


                    toast("Datos Actualizados")
                    val Archivo2 = "Chat"
                    val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(this)
                    defaultPrefs2.entrada = 0
                    defaultPrefs2.clave = 0
                    defaultPrefs2.codi = 0

                    val prefs2 = Splash.PreferenceHelper2.customPreference2(this, Archivo2)

                    val accion="Agregó Respuesta en Comunidad"
                    val codidd= prefs2.codi
                    val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                    val fecha1 = sdf1.format(Date())
                    var lugar="Movil"
                    db.collection("Correo").document("${customDialog.user24.text}/")
                        .update("adm",nombr)
                    db.collection("Correo").document("${customDialog.user24.text}/")
                        .update("admho",fecha1)
                    val Log = hashMapOf(
                        "accion" to accion,
                        "codidd" to codidd,
                        "fecha1" to fecha1,
                        "lugar" to lugar,
                    )
                    db.collection("Logs")
                        .add(Log)
                        .addOnSuccessListener {
                            recargar()
                            customDialog.respuesta.setText("")
                            customDialog.respuesta1.text = ""
                            customDialog.dismiss()
                        }
                        .addOnFailureListener { e ->

                        }


                }
            }
            customDialog.deleteButto443.setOnClickListener {
                db.collection("Correo").whereEqualTo("fecha", "$fecha")
                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            customDialog.fechaa.text = "${document.get("fecha")}"
                            customDialog.user.text = "${document.get("usuario")}"
                            customDialog.pregunta.text = "${document.get("pregunta")}"
                            customDialog.user24.text = "${document.id}"
                        }

                    }
                    .addOnFailureListener { exception ->
                        toast("Error al devolver la información")
                    }
                db.collection("Correo").document(customDialog.user24.text.toString()).delete()
                toast("Datos Eliminados")
                val Archivo2 = "Chat"
                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(this)
                defaultPrefs2.entrada = 0
                defaultPrefs2.clave = 0
                defaultPrefs2.codi = 0

                val prefs2 = Splash.PreferenceHelper2.customPreference2(this, Archivo2)

                val accion="Eliminó Respuesta de Comunidad."
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
                        recargar()
                        customDialog.dismiss()
                    }
                    .addOnFailureListener { e ->

                    }



        }

        customDialog.show()

    }
    override fun onBackPressed() {
        super.onBackPressed()
        mediaPlayer!!.stop()
        startActivity(Intent(this@ComunidadSinR, MenuPrinci::class.java))
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