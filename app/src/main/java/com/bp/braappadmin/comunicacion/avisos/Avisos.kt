package com.bp.braappadmin.comunicacion.avisos

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
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
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
import com.google.firebase.firestore.Query
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_avisos.*
import kotlinx.android.synthetic.main.activity_avisos.vaciarT1
import kotlinx.android.synthetic.main.activity_confirmacion.*
import kotlinx.android.synthetic.main.activity_detalle.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class Avisos : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    var adaptador: adaptadorA? = null
    var lita1: RecyclerView? = null
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    val datos = ArrayList<avisol>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avisos)
        val texto2: ConstraintLayout = findViewById(R.id.sfsgvfbfbs44)
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
                bu33.text = currentUser!!.userName
                when (currentUser!!.sexo) {
                    "Masculino" -> {
                        fotito113.setBackgroundResource(R.drawable.businessman)
                    }
                    "Femenino" -> {
                        fotito113.setBackgroundResource(R.drawable.businesswoman)
                    }
                    "no" -> {
                        fotito113.setBackgroundResource(R.drawable.interrogation)
                    }
                }

            }

        })
        Ayuda001a.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            mediaPlayer!!.pause()
            startActivity(Intent(this, Ayuda::class.java))
            Bungee.zoom(this)
        }
        setupRecyclerView1()
        datos.clear()
        swipeRefreshAvisos.setOnRefreshListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            setupRecyclerView1()
            swipeRefreshAvisos.isRefreshing = false
        }
        agregarA.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val bundle = Bundle()
            bundle.apply {
                putString("llave", "")
                putString("llave1", "")
            }
            val intent = Intent(this@Avisos, AvisosEditar::class.java).apply {
                putExtras(bundle)
            }
            startActivity(intent)
            Bungee.zoom(this@Avisos)
            finish()
        }
        vaciarT1.setOnClickListener { v ->
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val customDialog = Dialog(v.context)
            customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            customDialog.setContentView(R.layout.activity_confirmacion)
            customDialog.window?.setLayout(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            val yesBtn = customDialog.findViewById<Button>(R.id.yes_opt9) as TextView
            val noBtn = customDialog.findViewById<Button>(R.id.no_opt9) as TextView
            customDialog.texto.text = "¿Desea realmente eliminar todos los avisos recibidos?"
            customDialog.setCancelable(false)
            yesBtn.setOnClickListener {
                operacion()
                toast("Todos los Datos Borrados")
                val Archivo2 = "Chat"
                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(this)
                defaultPrefs2.entrada = 0
                defaultPrefs2.clave = 0
                defaultPrefs2.codi = 0

                val prefs2 = Splash.PreferenceHelper2.customPreference2(this, Archivo2)

                val accion="Eliminó todos los avisos."
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
                customDialog.dismiss()
            }
            noBtn.setOnClickListener {
                customDialog.dismiss()
            }
            customDialog.show()
        }
    }
fun operacion(){
    val db = FirebaseFirestore.getInstance()
    db.collection("Avisos")
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {
                db.collection("Avisos").document(document.id).delete()
            }
        }
        .addOnFailureListener { exception ->
            Log.v("Prueba", "Nofunciona")
        }
}

    @SuppressLint("WrongConstant")
    //todo
    fun setupRecyclerView1() {
        datos.clear()
        db.collection("Avisos").orderBy("fecha", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    datos.add(
                        avisol(
                            "${document.get("fecha")}",
                            "${document.get("titulo")}",
                            "${document.get("Descrip")}"
                        )
                    )
                    lita1?.setHasFixedSize(true)  //adaptador tamaño de la vista
                    lita1 = findViewById(R.id.menuAvisos)
                    layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                    lita1?.layoutManager = layoutManager  // donde se dibuje el layout
                    adaptador = adaptadorA(this, datos, object : ClickListener {
                        override fun onClick(vista: View, index: Int) {
                            val customDialog = Dialog(this@Avisos)
                            customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                            customDialog.setContentView(R.layout.activity_detalle)
                            customDialog.window?.setLayout(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                            )
                            db.collection("Avisos").whereEqualTo("fecha", "${datos[index].fecha}")
                                .get()
                                .addOnSuccessListener { result ->
                                    for (document in result) {
                                        customDialog.fecha.text = "${document.get("fecha")}"
                                        customDialog.titulo.text = "${document.get("titulo")}"
                                        customDialog.descr.text = "${document.get("Descrip")}"
                                    }
                                }
                                .addOnFailureListener { exception ->
                                    toast("Error al devolver la información")
                                }
                            customDialog.vacia.setOnClickListener {
                                val bundle = Bundle()
                                bundle.apply {
                                    putString("llave", datos[index].fecha)
                                    putString("llave1", "Todo")
                                }
                                val intent = Intent(this@Avisos, AvisosEditar::class.java).apply {
                                    putExtras(bundle)
                                }
                                startActivity(intent)
                                Bungee.zoom(this@Avisos)
                                finish()
                            }
                            customDialog.show()
                        }
                    })
                    lita1?.adapter = adaptador
                }
            }
            .addOnFailureListener { exception ->
                toast("Error al devolver la información")
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

    fun recargar(){
        finish(); overridePendingTransition(0, 0); startActivity(getIntent()); overridePendingTransition(0, 0);
    }
    override fun onBackPressed() {
        super.onBackPressed()
        mediaPlayer!!.stop()
        startActivity(Intent(this@Avisos, MenuPrinci::class.java))
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