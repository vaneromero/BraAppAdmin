package com.bp.braappadmin.comunicacion.chat.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bp.braappadmin.R
import com.bp.braappadmin.comunicacion.chat.firebase.FirebaseService
import com.bp.braappadmin.inicio.LoginActivity
import com.bp.braappadmin.inicio.Splash
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.activi
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.tono
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum1
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.codi
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.entrada
import com.bp.braappadmin.menuP.MenuPrinci
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.btnSignUp
import kotlinx.android.synthetic.main.activity_sign_up.etEmail
import kotlinx.android.synthetic.main.activity_sign_up.etPassword
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    var sexo = ""
    var token = ""
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private var mAuth: FirebaseAuth? = null
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val texto1: ImageView = findViewById(R.id.imageView)
        val texto2: CardView = findViewById(R.id.hhhs)
        val texto3: RelativeLayout = findViewById(R.id.relativeLayout2)
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto1.startAnimation(anim1)
        texto2.startAnimation(anim1)
        texto3.startAnimation(anim1)
        auth = FirebaseAuth.getInstance()
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

        btnSignUp.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val userName = udr.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()
            when {
                Masculino.isChecked -> {

                    sexo = "Masculino"
                }
                Femenino.isChecked -> {

                    sexo = "Femenino"
                }
                Nos.isChecked -> {

                    sexo = "no"
                }
            }

            if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(
                    password
                ) && !TextUtils.isEmpty(confirmPassword)
            ) {
                if (!password.equals(confirmPassword)) {
                    toast("Contraseñas no coinciden")
                } else {
                    registerUser(userName, email, password, sexo)
                }

            } else {
                toast("Verifique datos por favor.")
            }

        }

        udr.setOnFocusChangeListener { view, b ->
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
        etEmail.setOnFocusChangeListener { view, b ->
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
        etPassword.setOnFocusChangeListener { view, b ->
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
        etConfirmPassword.setOnFocusChangeListener { view, b ->
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
    }

    @SuppressLint("SimpleDateFormat")
    private fun registerUser(userName: String, email: String, password: String, sexo: String) {
        auth.fetchSignInMethodsForEmail(email).addOnCompleteListener {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    val user: FirebaseUser? = auth.currentUser
                    val userId: String = user!!.uid

                    databaseReference =
                        FirebaseDatabase.getInstance().getReference("Administradores").child(userId)
                    val random = Random()

                    val hallostring =
                        "${((0 until 10).random())}${((0 until 10).random())}${((0 until 10).random())}${((0 until 10).random())}"
                    Log.v("unoo", "${hallostring}")
                    val hashMap: HashMap<String, String> = HashMap()
                    hashMap.put("userId", userId)
                    hashMap.put("userName", userName)
                    hashMap.put("contraseña", password)
                    hashMap.put("sexo", sexo)
                    hashMap.put("email", email)
                    hashMap.put("avanzada", hallostring)
                    databaseReference.setValue(hashMap).addOnCompleteListener(this) {
                        if (it.isSuccessful) {
                            udr.setText("")
                            etEmail.setText("")
                            etPassword.setText("")
                            etConfirmPassword.setText("")
                            disableFCM()
                            FirebaseMessaging.getInstance().token
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        if (task.result != null && !TextUtils.isEmpty(task.result)) {
                                            token = task.result!!
                                            Log.v("Registro", " T " + token)
                                        }
                                    }
                                }

                            if (token == null) {
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
                            prefs2.codi = 1
                             val accion="Se registró un usuario."
                            val codidd="${hallostring}"
                           val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                            val fecha1 = sdf1.format(Date())

                            val lugar="Movil"

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
                                        toast("Log No Guardado")
                                    }

                            startActivity(Intent(this, MenuPrinci::class.java))
                            Bungee.zoom(this)
                            finish()
                        }
                    }
                }
            }
            .addOnFailureListener {
                toast("Correo ya existe")
            }
        }
    }

    fun disableFCM() {
        // Disable auto init
        FirebaseMessaging.getInstance().isAutoInitEnabled = false
        Thread {
            try {
                // Remove InstanceID initiate to unsubscribe all topic
                // TODO: May be a better way to use FirebaseMessaging.getInstance().unsubscribeFromTopic()
                FirebaseMessaging.getInstance().deleteToken()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }.start()
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
        startActivity(Intent(this, LoginActivity::class.java))
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