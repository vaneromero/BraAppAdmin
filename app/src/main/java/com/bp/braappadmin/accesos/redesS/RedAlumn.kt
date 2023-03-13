package com.bp.braappadmin.accesos.redesS

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bp.braappadmin.R
import com.bp.braappadmin.inicio.Splash
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.activi
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.tono
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum1
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.codi
import com.bp.braappadmin.menuP.MenuPrinci
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_confirmacion.*
import kotlinx.android.synthetic.main.activity_galeria1.*
import kotlinx.android.synthetic.main.activity_red_alumn.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.text.SimpleDateFormat
import java.util.*


class RedAlumn : AppCompatActivity() {
    private val database = Firebase.database
    private val db = FirebaseFirestore.getInstance()
    val myRefPropio = database.getReference("/Redes")
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private lateinit var messagesListener: ValueEventListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_red_alumn)
        getWindow().setSoftInputMode(android.view.WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        val texto2: ScrollView = findViewById(R.id.lins)
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

        titulo111.setOnFocusChangeListener { view, b ->
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
        titulo211.setOnFocusChangeListener { view, b ->
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
        titulo311.setOnFocusChangeListener { view, b ->
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
        titulo411.setOnFocusChangeListener { view, b ->
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
        titulo511.setOnFocusChangeListener { view, b ->
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
         titulo611.setOnFocusChangeListener { view, b ->
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
        titulo111.setOnFocusChangeListener { view, b ->
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
        titulo211.setOnFocusChangeListener { view, b ->
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
        titulo311.setOnFocusChangeListener { view, b ->
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
        titulo411.setOnFocusChangeListener { view, b ->
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
        titulo511.setOnFocusChangeListener { view, b ->
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
        titulo611.setOnFocusChangeListener { view, b ->
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


        val bundle: Bundle? = intent.extras
        bundle?.let { bundleLibriDeNull ->
            val area = bundleLibriDeNull.getString("llave", "")
            Log.v("Prueba", "${area}")
            if (area == "Alumno") {
                myRefPropio.child("LinkAlum").addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.exists()) {
                            titulo11.text = dataSnapshot.child("linkMed").getValue<String>()
                            titulo21.text = dataSnapshot.child("linkMega").getValue<String>()
                            titulo31.text = dataSnapshot.child("linkS1").getValue<String>()
                            titulo41.text = dataSnapshot.child("link").getValue<String>()
                            titulo51.text = dataSnapshot.child("play1").getValue<String>()
                            titulo61.text = dataSnapshot.child("qrr").getValue<String>()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException())
                    }
                })
                titulo1111.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    if (titulo111.text.isEmpty()) {
                        toast("No se puede guardar")
                    } else {
                        guardo("LinkAlum", "linkMed", "titulo111")
                    }
                }
                titulo2111.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    if (titulo211.text.isEmpty()) {
                        toast("No se puede guardar")
                    } else {
                        guardo("LinkAlum", "linkMega", "titulo211")
                    }
                }
                titulo3111.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    if (titulo311.text.isEmpty()) {
                        toast("No se puede guardar")
                    } else {
                        guardo("LinkAlum", "linkS1", "titulo311")
                    }
                }
                titulo4111.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    if (titulo411.text.isEmpty()) {
                        toast("No se puede guardar")
                    } else {
                        guardo("LinkAlum", "link", "titulo411")
                    }
                }
                titulo5111.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    if (titulo511.text.isEmpty()) {
                        toast("No se puede guardar")
                    } else {
                        guardo("LinkAlum", "play1", "titulo511")
                    }
                }

                titulo6111.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    if (titulo611.text.isEmpty()) {
                        toast("No se puede guardar")
                    } else {
                        guardo("LinkAlum", "qrr", "titulo611")
                    }
                }

                vaciartodo.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    val customDialog = Dialog(this)
                    customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    customDialog.setContentView(R.layout.activity_confirmacion)
                    customDialog.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn = customDialog.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn = customDialog.findViewById<Button>(R.id.no_opt9) as TextView
                    customDialog.texto.text = "¿Desea realmente eliminar todos los links?"
                    customDialog.setCancelable(false)
                    yesBtn.setOnClickListener {
                        database.getReference("/Redes").child("/LinkAlum/linkMed").removeValue()

                        database.getReference("/Redes").child("/LinkAlum/linkMega").removeValue()
                        database.getReference("/Redes").child("/LinkAlum/linkS1").removeValue()
                        database.getReference("/Redes").child("/LinkAlum/link").removeValue()
                        database.getReference("/Redes").child("/LinkAlum/play1").removeValue()
                        database.getReference("/Redes").child("/LinkAlum/linkMed2p").removeValue()
                        database.getReference("/Redes").child("/LinkAlum/linkMega2p").removeValue()
                        database.getReference("/Redes").child("/LinkAlum/linkS12p").removeValue()
                        database.getReference("/Redes").child("/LinkAlum/link2p").removeValue()
                        database.getReference("/Redes").child("/LinkAlum/play12p").removeValue()
                        database.getReference("/Redes").child("/LinkAlum/qrr").removeValue()
                        database.getReference("/Redes").child("/LinkAlum/qrr2p").removeValue()
                        titulo611.setText("")
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                        val accion = "Se Eliminó todo de link de Alumno."
                        val codidd = prefs2.codi
                        val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                        val fecha1 = sdf1.format(Date())
                        var lugar = "Movil"

                        val Log = hashMapOf(
                            "accion" to accion,
                            "codidd" to codidd,
                            "fecha1" to fecha1,
                            "lugar" to lugar,
                        )
                        db.collection("Logs")
                            .add(Log)
                            .addOnSuccessListener {
                                recargar1()
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
            else {
                myRefPropio.child("LinkTutor").addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.exists()) {
                            titulo11.text = dataSnapshot.child("linkMed").getValue<String>()
                            titulo21.text = dataSnapshot.child("linkMega").getValue<String>()
                            titulo31.text = dataSnapshot.child("linkS1").getValue<String>()
                            titulo41.text = dataSnapshot.child("link").getValue<String>()
                            titulo51.text = dataSnapshot.child("play1").getValue<String>()

                            titulo61.text = dataSnapshot.child("qrr").getValue<String>()

                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException())
                    }
                })
                titulo1111.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    if (titulo111.text.isEmpty()) {
                        toast("No se puede guardar")
                    } else {
                        guardo("LinkTutor", "linkMed", "titulo111")
                    }
                }
                titulo2111.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    if (titulo211.text.isEmpty()) {
                        toast("No se puede guardar")
                    } else {
                        guardo("LinkTutor", "linkMega", "titulo211")
                    }
                }
                titulo3111.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    if (titulo311.text.isEmpty()) {
                        toast("No se puede guardar")
                    } else {
                        guardo("LinkTutor", "linkS1", "titulo311")
                    }
                }
                titulo4111.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    if (titulo411.text.isEmpty()) {
                        toast("No se puede guardar")
                    } else {
                        guardo("LinkTutor", "link", "titulo411")
                    }
                }
                titulo5111.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    if (titulo511.text.isEmpty()) {
                        toast("No se puede guardar")
                    } else {
                        guardo("LinkTutor", "play1", "titulo511")
                    }
                }

                titulo6111.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    if (titulo611.text.isEmpty()) {
                        toast("No se puede guardar")
                    } else {
                        guardo("LinkTutor", "qrr", "titulo611")
                    }
                }

                vaciartodo.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    val customDialog = Dialog(this)
                    customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    customDialog.setContentView(R.layout.activity_confirmacion)
                    customDialog.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn = customDialog.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn = customDialog.findViewById<Button>(R.id.no_opt9) as TextView
                    customDialog.texto.text = "¿Desea realmente eliminar todos los links?"
                    customDialog.setCancelable(false)
                    yesBtn.setOnClickListener {
                        database.getReference("/Redes").child("/LinkTutor/linkMed").removeValue()
                        database.getReference("/Redes").child("/LinkTutor/linkMega").removeValue()
                        database.getReference("/Redes").child("/LinkTutor/linkS1").removeValue()
                        database.getReference("/Redes").child("/LinkTutor/link").removeValue()
                        database.getReference("/Redes").child("/LinkTutor/play1").removeValue()
                        database.getReference("/Redes").child("/LinkTutor/linkMed1p").removeValue()
                        database.getReference("/Redes").child("/LinkTutor/linkMega1p").removeValue()
                        database.getReference("/Redes").child("/LinkTutor/linkS11").removeValue()
                        database.getReference("/Redes").child("/LinkTutor/link1p").removeValue()
                        database.getReference("/Redes").child("/LinkTutor/play12p").removeValue()
                        database.getReference("/Redes").child("/LinkTutor/qrr").removeValue()
                        database.getReference("/Redes").child("/LinkTutor/qrr1p").removeValue()
                        titulo611.setText("")
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                        val accion = "Se Eliminó todo de link de Tutor."
                        val codidd = prefs2.codi
                        val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                        val fecha1 = sdf1.format(Date())
                        var lugar = "Movil"

                        val Log = hashMapOf(
                            "accion" to accion,
                            "codidd" to codidd,
                            "fecha1" to fecha1,
                            "lugar" to lugar,
                        )
                        db.collection("Logs")
                            .add(Log)
                            .addOnSuccessListener {
                                recargar1()
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
        }
    }


    @SuppressLint("ResourceAsColor")
    fun guardo(dato1: String, dato2: String, dato3: String) {
        val myRef = database.getReference("Redes")
        if (dato1 == "LinkAlum") {

            if (dato3 == "titulo111") {
                val mapa: Map<String, String> = mapOf(
                    "$dato2" to "${titulo111.text}"
                )
                myRef.child("LinkAlum").updateChildren(mapa)
                titulo111.setText("")
                toast("Se guardo")
                val Archivo2 = "Chat"
                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                defaultPrefs2.codi = 0

                val prefs2 =
                    Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                val accion = "Se Guardó o modificó link de Alumno."
                val codidd = prefs2.codi
                val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                val fecha1 = sdf1.format(Date())
                var lugar = "Movil"

                val Log = hashMapOf(
                    "accion" to accion,
                    "codidd" to codidd,
                    "fecha1" to fecha1,
                    "lugar" to lugar,
                )
                db.collection("Logs")
                    .add(Log)
                    .addOnSuccessListener {
                    }
                    .addOnFailureListener { e ->

                    }
            }
            else if (dato3 == "titulo211") {
                val mapa: Map<String, String> = mapOf(
                    "$dato2" to "${titulo211.text}"
                )
                myRef.child("LinkAlum").updateChildren(mapa)
                titulo211.setText("")
                val Archivo2 = "Chat"
                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                defaultPrefs2.codi = 0

                val prefs2 =
                    Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                val accion = "Se Guardó o modificó link de Alumno."
                val codidd = prefs2.codi
                val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                val fecha1 = sdf1.format(Date())
                var lugar = "Movil"

                val Log = hashMapOf(
                    "accion" to accion,
                    "codidd" to codidd,
                    "fecha1" to fecha1,
                    "lugar" to lugar,
                )
                db.collection("Logs")
                    .add(Log)
                    .addOnSuccessListener {
                    }
                    .addOnFailureListener { e ->

                    }
                toast("Se guardo")
            }
            else if (dato3 == "titulo311") {
                val mapa: Map<String, String> = mapOf(
                    "$dato2" to "${titulo311.text}"
                )
                myRef.child("LinkAlum").updateChildren(mapa)
                titulo311.setText("")
                val Archivo2 = "Chat"
                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                defaultPrefs2.codi = 0

                val prefs2 =
                    Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                val accion = "Se Guardó o modificó link de Alumno."
                val codidd = prefs2.codi
                val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                val fecha1 = sdf1.format(Date())
                var lugar = "Movil"

                val Log = hashMapOf(
                    "accion" to accion,
                    "codidd" to codidd,
                    "fecha1" to fecha1,
                    "lugar" to lugar,
                )
                db.collection("Logs")
                    .add(Log)
                    .addOnSuccessListener {
                    }
                    .addOnFailureListener { e ->

                    }
                toast("Se guardo")
            }

            else if (dato3 == "titulo411") {
                val mapa: Map<String, String> = mapOf(
                    "$dato2" to "${titulo411.text}"
                )
                myRef.child("LinkAlum").updateChildren(mapa)
                titulo411.setText("")
                val Archivo2 = "Chat"
                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                defaultPrefs2.codi = 0

                val prefs2 =
                    Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                val accion = "Se Guardó o modificó link de Alumno."
                val codidd = prefs2.codi
                val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                val fecha1 = sdf1.format(Date())
                var lugar = "Movil"

                val Log = hashMapOf(
                    "accion" to accion,
                    "codidd" to codidd,
                    "fecha1" to fecha1,
                    "lugar" to lugar,
                )
                db.collection("Logs")
                    .add(Log)
                    .addOnSuccessListener {
                    }
                    .addOnFailureListener { e ->

                    }
                toast("Se guardo")
            }
            else if (dato3 == "titulo511") {
                val mapa: Map<String, String> = mapOf(
                    "$dato2" to "${titulo511.text}"
                )
                myRef.child("LinkAlum").updateChildren(mapa)
                titulo511.setText("")
                val Archivo2 = "Chat"
                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                defaultPrefs2.codi = 0

                val prefs2 =
                    Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                val accion = "Se Guardó o modificó link de Alumno."
                val codidd = prefs2.codi
                val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                val fecha1 = sdf1.format(Date())
                var lugar = "Movil"

                val Log = hashMapOf(
                    "accion" to accion,
                    "codidd" to codidd,
                    "fecha1" to fecha1,
                    "lugar" to lugar,
                )
                db.collection("Logs")
                    .add(Log)
                    .addOnSuccessListener {
                    }
                    .addOnFailureListener { e ->

                    }
                toast("Se guardo")
            }
            else if (dato3 == "titulo611") {
                val mapa: Map<String, String> = mapOf(
                    "$dato2" to "${titulo611.text}"
                )
                myRef.child("LinkAlum").updateChildren(mapa)
                titulo611.setText("")
                val Archivo2 = "Chat"
                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                defaultPrefs2.codi = 0

                val prefs2 =
                    Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                val accion = "Se Guardó o modificó link de Alumno."
                val codidd = prefs2.codi
                val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                val fecha1 = sdf1.format(Date())
                var lugar = "Movil"

                val Log = hashMapOf(
                    "accion" to accion,
                    "codidd" to codidd,
                    "fecha1" to fecha1,
                    "lugar" to lugar,
                )
                db.collection("Logs")
                    .add(Log)
                    .addOnSuccessListener {
                    }
                    .addOnFailureListener { e ->

                    }
                toast("Se guardo")
            }


        } else if (dato1 == "LinkTutor") {
            if (dato3 == "titulo111") {
                val mapa: Map<String, String> = mapOf(
                    "$dato2" to "${titulo111.text}"
                )
                myRef.child("LinkTutor").updateChildren(mapa)
                titulo111.setText("")
                val Archivo2 = "Chat"
                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                defaultPrefs2.codi = 0

                val prefs2 =
                    Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                val accion = "Se Guardó o modificó link de Tutor."
                val codidd = prefs2.codi
                val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                val fecha1 = sdf1.format(Date())
                var lugar = "Movil"

                val Log = hashMapOf(
                    "accion" to accion,
                    "codidd" to codidd,
                    "fecha1" to fecha1,
                    "lugar" to lugar,
                )
                db.collection("Logs")
                    .add(Log)
                    .addOnSuccessListener {
                    }
                    .addOnFailureListener { e ->

                    }
                toast("Se guardo")
            }
            else if (dato3 == "titulo211") {
                val mapa: Map<String, String> = mapOf(
                    "$dato2" to "${titulo211.text}"
                )
                myRef.child("LinkTutor").updateChildren(mapa)
                titulo211.setText("")
                val Archivo2 = "Chat"
                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                defaultPrefs2.codi = 0

                val prefs2 =
                    Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                val accion = "Se Guardó o modificó link de Tutor."
                val codidd = prefs2.codi
                val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                val fecha1 = sdf1.format(Date())
                var lugar = "Movil"

                val Log = hashMapOf(
                    "accion" to accion,
                    "codidd" to codidd,
                    "fecha1" to fecha1,
                    "lugar" to lugar,
                )
                db.collection("Logs")
                    .add(Log)
                    .addOnSuccessListener {
                    }
                    .addOnFailureListener { e ->

                    }
                toast("Se guardo")
            }
            else if (dato3 == "titulo311") {
                val mapa: Map<String, String> = mapOf(
                    "$dato2" to "${titulo311.text}"
                )
                myRef.child("LinkTutor").updateChildren(mapa)
                titulo311.setText("")
                val Archivo2 = "Chat"
                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                defaultPrefs2.codi = 0

                val prefs2 =
                    Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                val accion = "Se Guardo o modifico link de Tutor."
                val codidd = prefs2.codi
                val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                val fecha1 = sdf1.format(Date())
                var lugar = "Movil"

                val Log = hashMapOf(
                    "accion" to accion,
                    "codidd" to codidd,
                    "fecha1" to fecha1,
                    "lugar" to lugar,
                )
                db.collection("Logs")
                    .add(Log)
                    .addOnSuccessListener {
                    }
                    .addOnFailureListener { e ->

                    }
                toast("Se guardo")
            }
            else if (dato3 == "titulo411") {
                val mapa: Map<String, String> = mapOf(
                    "$dato2" to "${titulo411.text}"
                )
                myRef.child("LinkTutor").updateChildren(mapa)
                titulo411.setText("")
                val Archivo2 = "Chat"
                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                defaultPrefs2.codi = 0

                val prefs2 =
                    Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                val accion = "Se Guardó o modificó link de Tutor."
                val codidd = prefs2.codi
                val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                val fecha1 = sdf1.format(Date())
                var lugar = "Movil"

                val Log = hashMapOf(
                    "accion" to accion,
                    "codidd" to codidd,
                    "fecha1" to fecha1,
                    "lugar" to lugar,
                )
                db.collection("Logs")
                    .add(Log)
                    .addOnSuccessListener {
                    }
                    .addOnFailureListener { e ->

                    }
                toast("Se guardo")
            }
            else if (dato3 == "titulo511") {
                val mapa: Map<String, String> = mapOf(
                    "$dato2" to "${titulo511.text}"
                )
                myRef.child("LinkTutor").updateChildren(mapa)
                titulo511.setText("")
                val Archivo2 = "Chat"
                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                defaultPrefs2.codi = 0

                val prefs2 =
                    Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                val accion = "Se Guardó o modificó link de Tutor."
                val codidd = prefs2.codi
                val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                val fecha1 = sdf1.format(Date())
                var lugar = "Movil"

                val Log = hashMapOf(
                    "accion" to accion,
                    "codidd" to codidd,
                    "fecha1" to fecha1,
                    "lugar" to lugar,
                )
                db.collection("Logs")
                    .add(Log)
                    .addOnSuccessListener {
                    }
                    .addOnFailureListener { e ->

                    }
                toast("Se guardo")
            }
            else if (dato3 == "titulo611") {
                val mapa: Map<String, String> = mapOf(
                    "$dato2" to "${titulo611.text}"
                )
                myRef.child("LinkTutor").updateChildren(mapa)
                titulo611.setText("")
                val Archivo2 = "Chat"
                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                defaultPrefs2.codi = 0

                val prefs2 =
                    Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                val accion = "Se Guardó o modificó link de Tutor."
                val codidd = prefs2.codi
                val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                val fecha1 = sdf1.format(Date())
                var lugar = "Movil"

                val Log = hashMapOf(
                    "accion" to accion,
                    "codidd" to codidd,
                    "fecha1" to fecha1,
                    "lugar" to lugar,
                )
                db.collection("Logs")
                    .add(Log)
                    .addOnSuccessListener {
                    }
                    .addOnFailureListener { e ->

                    }
                toast("Se guardo")
            }

        }

    }

    fun recargar1() {
        overridePendingTransition(0, 0);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
        overridePendingTransition(0, 0);
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
    override fun onBackPressed() {
        super.onBackPressed()
        mediaPlayer!!.stop()
        startActivity(Intent(this, Redes::class.java))
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