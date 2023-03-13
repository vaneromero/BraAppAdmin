package com.bp.braappadmin.videos

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
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.lottie.LottieAnimationView
import com.bp.braappadmin.R
import com.bp.braappadmin.accesos.redesS.adapterRed
import com.bp.braappadmin.accesos.redesS.video
import com.bp.braappadmin.comunicacion.avisos.Avisos
import com.bp.braappadmin.inicio.Splash
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.activi
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.tono
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum1
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.codi
import com.bp.braappadmin.menuP.MenuPrinci
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_confirmacion.*
import kotlinx.android.synthetic.main.activity_galeria1.*
import kotlinx.android.synthetic.main.activity_video.*
import kotlinx.android.synthetic.main.redesd.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.text.SimpleDateFormat
import java.util.*

class video : AppCompatActivity() {
    private val database = Firebase.database
    private val db = FirebaseFirestore.getInstance()
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
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
        descargaEditTextv.setOnFocusChangeListener { view, b ->
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
        //Asignacioón de las animaciones
        val texto1: TextView = findViewById(R.id.titleAddTextViewv)
        val texto2: CardView = findViewById(R.id.cardView3)
        val texto3: CardView = findViewById(R.id.cardView)
        val texto4: LottieAnimationView = findViewById(R.id.vaciarT6)
        val texto5: CardView = findViewById(R.id.cardView3d)
        val texto6: CardView = findViewById(R.id.cardView3hgd)
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto1.startAnimation(anim1)
        texto2.startAnimation(anim1)
        texto3.startAnimation(anim1)
        texto4.startAnimation(anim1)
        texto5.startAnimation(anim1)
        texto6.startAnimation(anim1)
        val bundle: Bundle? = intent.extras
        bundle?.let { bundleLibriDeNull ->
            val area = bundleLibriDeNull.getString("llave", "")
            when (area) {
                "problema" -> {
                    titleAddTextViewv.text="Problemática"
                    formato.text="dTH9BFV9cI4"
                    formato1.text="https://www.youtube.com/embed/dTH9BFV9cI4"
                    text("Problematica")
                    saveButtonv.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        if (descargaEditTextv.text.isEmpty()){
                            toast("No se puede Subir")
                        }else{
                            saveUserToFirebaseDatabase("Problematica", descargaEditTextv.text.toString())
                        }
                    }
                    vaciarT6.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        alerta3("Problematica","Problematica")
                    }

                }
                "construir" -> {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    titleAddTextViewv.text="Construcción Memorama"
                    formato.text="list=PLMePfPb0PU8JZQ0LddoHX-DdeD_U0pa8_"
                    formato1.text="https://www.youtube.com/embed/videoseries?list=PLMePfPb0PU8JZQ0LddoHX-DdeD_U0pa8_"
                    text("memo")
                    saveButtonv.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        if (descargaEditTextv.text.isEmpty()){
                            toast("No se puede Subir")
                        }else{
                            saveUserToFirebaseDatabase("memo", descargaEditTextv.text.toString())
                        }
                    }
                    vaciarT6.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        alerta3("memo","Construcción Memorama")
                    }
                }
                "construir1" -> {
                    titleAddTextViewv.text="Construcción Rompecabezas"
                    formato.text="list=PLMePfPb0PU8JZQ0LddoHX-DdeD_U0pa8_"
                    formato1.text="https://www.youtube.com/embed/videoseries?list=PLMePfPb0PU8JZQ0LddoHX-DdeD_U0pa8_"
                    text("rompe")
                    saveButtonv.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        if (descargaEditTextv.text.isEmpty()){
                            toast("No se puede Subir")
                        }else{
                            saveUserToFirebaseDatabase("rompe", descargaEditTextv.text.toString())
                        }
                    }
                    vaciarT6.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        alerta3("rompe","Construcción Rompecabezas")
                    }
                }
                "entrevista" -> {
                    titleAddTextViewv.text="Entrevista"
                    formato.text="dTH9BFV9cI4"
                    formato1.text="https://www.youtube.com/embed/dTH9BFV9cI4"
                    text("entre")
                    saveButtonv.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        if (descargaEditTextv.text.isEmpty()){
                            toast("No se puede Subir")
                        }else{
                            saveUserToFirebaseDatabase("entre", descargaEditTextv.text.toString())
                        } }
                    vaciarT6.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        alerta3("entre","Entrevista")
                    }
                }
                "alumno" -> {
                    titleAddTextViewv.text="Alumno"
                    text("Alumno")
                    formato.text="list=PLMePfPb0PU8JZQ0LddoHX-DdeD_U0pa8_"
                    formato1.text="https://www.youtube.com/embed/videoseries?list=PLMePfPb0PU8JZQ0LddoHX-DdeD_U0pa8_"
                    saveButtonv.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        if (descargaEditTextv.text.isEmpty()){
                            toast("No se puede Subir")
                        }else{
                            saveUserToFirebaseDatabase("Alumno", descargaEditTextv.text.toString())
                        } }
                    vaciarT6.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        alerta3("Alumno","Alumno")
                    }
                }
                "tutor" -> {
                    titleAddTextViewv.text="Tutor"
                    text("Tutor")
                    formato.text="list=PLMePfPb0PU8JZQ0LddoHX-DdeD_U0pa8_"
                    formato1.text="https://www.youtube.com/embed/videoseries?list=PLMePfPb0PU8JZQ0LddoHX-DdeD_U0pa8_"
                    saveButtonv.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        if (descargaEditTextv.text.isEmpty()){
                            toast("No se puede Subir")
                        }else{
                            saveUserToFirebaseDatabase("Tutor", descargaEditTextv.text.toString())
                        } }
                    vaciarT6.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        alerta3("Tutor","Tutor")
                    }
                }
                "util" -> {
                    titleAddTextViewv.text = "Utilidades"
                    formato.text="dTH9BFV9cI4"
                    formato1.text="https://www.youtube.com/embed/dTH9BFV9cI4"
                    text("util")
                    saveButtonv.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        if (descargaEditTextv.text.isEmpty()) {
                            toast("No se puede Subir")
                        } else {
                            saveUserToFirebaseDatabase("util", descargaEditTextv.text.toString())
                        }
                    }
                    vaciarT6.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        alerta3("util","Utilidades")
                    }
                }
                "Admin" -> {
                    titleAddTextViewv.text="Administrador"
                    text("Admin")
                    formato.text="list=PLMePfPb0PU8JZQ0LddoHX-DdeD_U0pa8_"
                    formato1.text="https://www.youtube.com/embed/videoseries?list=PLMePfPb0PU8JZQ0LddoHX-DdeD_U0pa8_"
                    saveButtonv.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        if (descargaEditTextv.text.isEmpty()){
                            toast("No se puede Subir")
                        }else{
                            saveUserToFirebaseDatabase("Admin",descargaEditTextv.text.toString())
                        }
                    }

                    vaciarT6.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        alerta3("Admin","Administrador")
                    }
                }
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

    fun text(video:String){
        val database = Firebase.database
        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

        val myRef = database.getReference("/Video/$video")

        with(myRef) {
            addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {

                    val redes: video? = dataSnapshot.getValue(com.bp.braappadmin.accesos.redesS.video::class.java)
                    if (redes != null) {

                        linkya.text = redes.video4.toString()

                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })

        }
    }
     fun saveUserToFirebaseDatabase(bas:String,url: String) {
        val myRef = database.getReference("Video")

        myRef.child("${bas.toString()}").child("video4").setValue(url)
         val Archivo2 = "Chat"
         val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

         defaultPrefs2.codi = 0

         val prefs2 = Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

         val accion = "Se subió o modificó el link de $bas."
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
                 toast("Link Subido")
                 descargaEditTextv.setText("")
             }
             .addOnFailureListener { e ->

             }



    }
    private fun alerta3(red:String,nomb:String) {
        val database = Firebase.database.reference
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.activity_confirmacion)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        val yesBtn = customDialog.findViewById<Button>(R.id.yes_opt9) as TextView
        val noBtn = customDialog.findViewById<Button>(R.id.no_opt9) as TextView
        customDialog.texto.setText("¿Desea realmente eliminar el video de el/la $nomb?")

        yesBtn.setOnClickListener {
            database.child("Video").child("$red").removeValue()

            val Archivo2 = "Chat"
            val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

            defaultPrefs2.codi = 0

            val prefs2 = Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

            val accion = "Eliminó el link de $nomb."
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
                    toast("Todos los Datos Borrados")
                    recargar1()
                    customDialog.dismiss()
                }
                .addOnFailureListener { e ->

                }

        }
        noBtn.setOnClickListener {
            customDialog.dismiss()
        }
        customDialog.show()

    }
    fun recargar1(){
        overridePendingTransition(0, 0);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
    override fun onBackPressed() {
        super.onBackPressed()
        mediaPlayer!!.stop()
        startActivity(Intent(this, MenuPrinci::class.java))
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