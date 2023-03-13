package com.bp.braappadmin.inicio

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.bp.braappadmin.R
import com.bp.braappadmin.audio.Audio
import com.bp.braappadmin.catalogo.similares.Producto
import com.bp.braappadmin.comunicacion.chat.activity.SignUpActivity
import com.bp.braappadmin.comunicacion.chat.activity.UsersActivity
import com.bp.braappadmin.comunicacion.chat.firebase.FirebaseService
import com.bp.braappadmin.comunicacion.chat.model.User
import com.bp.braappadmin.creditos.Creditoss
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.activi
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.tono
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum1
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.clave
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.codi
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.entrada
import com.bp.braappadmin.menuP.MenuPrinci
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_cambio.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_menu_princi.*
import kotlinx.android.synthetic.main.activity_prodc_detalle.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {
    private var auth: FirebaseAuth? = null
    private lateinit var databaseReference: DatabaseReference
    private var firebaseUser: FirebaseUser? = null
    private var mAuth: FirebaseAuth? = null
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    var token = ""
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val texto2: ConstraintLayout = findViewById(R.id.cont44g)
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto2.startAnimation(anim1)
        auth = FirebaseAuth.getInstance()
        mAuth = FirebaseAuth.getInstance()
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
        if (firebaseUser != null) {
            startActivity(Intent(this, UsersActivity::class.java))
            Bungee.zoom(this)
            finish()
        }
        btnLogin.setOnClickListener {

            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password) || TextUtils.isEmpty(email) || TextUtils.isEmpty(
                    password
                )
            ) {
                toast("Correo y contraseña requerida")

            } else {

                auth!!.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) {

                        if (it.isSuccessful) {

                             databaseReference =
                                FirebaseDatabase.getInstance().getReference("Administradores")
                                    .child(auth!!.getCurrentUser()!!.getUid())
                            Log.v("Datos", "usuario " + databaseReference)
                            databaseReference.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {

                                    databaseReference.child("contraseña").setValue(password)

                                }

                                override fun onCancelled(error: DatabaseError) {
                                    Log.w("TAG", "Failed to read value.", error.toException())
                                }
                            })
                            FirebaseMessaging.getInstance().token
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        if (task.result != null && !TextUtils.isEmpty(task.result)) {
                                            token = task.result!!
                                            Log.v("Registro", " T " + token)
                                        }
                                    }
                                }
                            Log.v("Registro", " T " + token)
                            if (token == null) //this is used to get firebase token until its null so it will save you from null pointer exeption
                            {
                                FirebaseService()
                                FirebaseMessaging.getInstance().isAutoInitEnabled = true
                                FirebaseMessaging.getInstance().token
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            if (task.result != null && !TextUtils.isEmpty(task.result)) {
                                                token = task.result!!
                                                Log.v("Registro", " T " + token)
                                            }
                                        }
                                    }
                                Log.v("Registro", " T " + token)
                            }

                            val Archivo2 = "Chat"
                            val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(this)
                            defaultPrefs2.entrada = 0
                            defaultPrefs2.codi = 0
                            val prefs2 = Splash.PreferenceHelper2.customPreference2(this, Archivo2)
                            prefs2.entrada = 1


                            val database = Firebase.database

                            @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                            val myRef = database.getReference("Administradores").child(
                                auth!!.getCurrentUser()!!.getUid()
                            )
                            myRef.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {

                                    val producto: codis? = dataSnapshot.getValue(codis::class.java)
                                    if (producto != null) {
                                        prefs2.codi = producto.avanzada!!.toInt()

                                        val accion = "Inicio Sesión el usuario."
                                        val codidd = producto.avanzada!!.toInt()
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
                                                etEmail.setText("")
                                                etPassword.setText("")
                                            }
                                            .addOnFailureListener { e ->
                                                toast("Log No Guardado")
                                            }
                                    }
                                }

                                override fun onCancelled(error: DatabaseError) {
                                    Log.w("TAG", "Failed to read value.", error.toException())
                                }
                            })
                                startActivity(Intent(this, MenuPrinci::class.java))
                                Bungee.zoom(this)
                                finish()
                        } else {
                            toast("Correo y contraseña invalida")
                        }
                    }
            }
        }
        btnSignUp.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, SignUpActivity::class.java))
            Bungee.zoom(this)
            finish()
        }
        restablecer.setOnClickListener { v ->
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                   val customDialog = Dialog(v.context)
            customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            customDialog.setContentView(R.layout.activity_cambio)

            customDialog.window?.setLayout(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            customDialog.enviar.setOnClickListener {
                Log.v("pppp", "entro3")
                val accion = "Solicito cambio de contraseña"
                val codidd = "0000"
                val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                val fecha1 = sdf1.format(Date())
                var lugar = "Movil"

                val Log = hashMapOf(
                    "accion" to accion,
                    "codidd" to codidd,
                    "fecha1" to fecha1,
                    "lugar" to lugar,
                    "correo" to customDialog.correo?.text.toString()
                )
                val email = customDialog.correo?.text.toString()
                if (!TextUtils.isEmpty(email)) {
                    mAuth!!
                        .sendPasswordResetEmail(email)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val builder =
                                    AlertDialog.Builder(this@LoginActivity)
                                builder.setTitle("Aceptado")
                                builder.setMessage(
                                    "Correo Enviado..."
                                )
                                builder.setIcon(R.drawable.iconoadmin)
                                builder.setPositiveButton(
                                    "Ok",
                                    DialogInterface.OnClickListener { view, id ->

                                    })

                                customDialog.dismiss()
                                val dialog: AlertDialog = builder.create()
                                dialog.show()
                                db.collection("Logs")
                                    .add(Log)
                                    .addOnSuccessListener {


                                    }
                                    .addOnFailureListener { e ->

                                    }
                            } else {
                                val builder =
                                    AlertDialog.Builder(this@LoginActivity)
                                builder.setTitle("Error")
                                builder.setIcon(R.drawable.iconoadmin)
                                builder.setMessage(
                                    "No se encontró Correo..."
                                )
                                builder.setPositiveButton("Aceptar", null)
                                val dialog: AlertDialog = builder.create()
                                dialog.show()
                            }
                        }
                } else {
                    val builder = AlertDialog.Builder(this@LoginActivity)
                    builder.setTitle("Error")
                    builder.setMessage(
                        "Ingrese un correo"
                    )
                    builder.setPositiveButton("Aceptar", null)
                    val dialog: AlertDialog = builder.create()
                    dialog.show()
                }
            }
            customDialog.show()
        }
        Creditossa.setOnClickListener {

            prefs1.activi = "CreU"
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, Creditoss::class.java))
            Bungee.zoom(this)

        }
        etEmail.setOnFocusChangeListener { view, b ->
            if (b) {
                soundPool!!.play(
                    carga,
                    prefs1.volum1,
                    prefs1.volum1,
                    0,
                    0,
                    1f
                )

            } else {
                view.clearFocus()
            }
        }
        etPassword.setOnFocusChangeListener { view, b ->
            if (b) {
                soundPool!!.play(
                    carga,
                    prefs1.volum1,
                    prefs1.volum1,
                    0,
                    0,
                    1f
                )

            } else {
                view.clearFocus()
            }
        }
        Optiones.setOnClickListener {
            mediaPlayer!!.stop()
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            prefs1.activi = "UsuA"
            startActivity(Intent(this, Audio::class.java))
            Bungee.zoom(this)
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

    override fun onBackPressed() {
        moveTaskToBack(true)
        Bungee.zoom(this)
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