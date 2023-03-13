package com.bp.braappadmin.menuP

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
import android.widget.*
import androidx.cardview.widget.CardView
import com.airbnb.lottie.LottieAnimationView
import com.bp.braappadmin.R
import com.bp.braappadmin.catalogo.producto.ProdRec
import com.bp.braappadmin.catalogo.similares.Produc
import com.bp.braappadmin.comunicacion.avisos.Avisos
import com.bp.braappadmin.comunicacion.buzon.Buzzon1
import com.bp.braappadmin.comunicacion.chat.activity.UsersActivity
import com.bp.braappadmin.comunicacion.chat.model.User
import com.bp.braappadmin.extra.Extras
import com.bp.braappadmin.inicio.LoginActivity
import com.bp.braappadmin.inicio.Splash
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.clave
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.entrada
import com.bp.braappadmin.inicio.Splash.PreferenceHelper4.dato1
import com.bp.braappadmin.inicio.Splash.PreferenceHelper4.dato2
import com.bp.braappadmin.accesos.redesS.Redes
import com.bp.braappadmin.audio.Audio
import com.bp.braappadmin.comunicacion.buzon.ComunidadSinR
import com.bp.braappadmin.comunicacion.buzon.ComunidadT
import com.bp.braappadmin.creditos.Creditoss
import com.bp.braappadmin.documentos.doc
import com.bp.braappadmin.galeria.Galeria1
import com.bp.braappadmin.galeria.Galerias
import com.bp.braappadmin.help.Ayuda
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.activi
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.tono
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum1
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.codi
import com.bp.braappadmin.registross.Logs
import com.bp.braappadmin.videos.video
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_confirmacion.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_menu_princi.*
import kotlinx.android.synthetic.main.activity_menu_princi.bu
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class MenuPrinci : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private var mAuth: FirebaseAuth? = null
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_princi)
        uno1.visibility = View.VISIBLE
        siete7.visibility= View.VISIBLE
        ocho8.visibility = View.VISIBLE
        dos2.visibility = View.GONE
        tres3.visibility = View.GONE
        cuatro4.visibility = View.GONE
        cinco5.visibility = View.GONE
        seis6.visibility = View.GONE
        val texto1: LottieAnimationView = findViewById(R.id.Optiones7)
        val texto2: LottieAnimationView = findViewById(R.id.Creditossga)
        val texto3: LinearLayout = findViewById(R.id.cardViews)
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto1.startAnimation(anim1)
        texto2.startAnimation(anim1)
        texto3.startAnimation(anim1)
        val Archivo2 = "Chat"
        val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(this)
        defaultPrefs2.entrada = 0
        defaultPrefs2.clave = 0
        defaultPrefs2.codi = 0
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
        val prefs2 = Splash.PreferenceHelper2.customPreference2(this, Archivo2)
        eclav.setOnFocusChangeListener { view, b ->
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
        val firebase: FirebaseUser = FirebaseAuth.getInstance().currentUser!!
        Creditossga.setOnClickListener {
            mediaPlayer!!.stop()
            prefs1.activi = "CreM"
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, Creditoss::class.java))
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
                bu.text = currentUser!!.userName
                prefs2.codi= currentUser!!.avanzada.toInt()
                when (currentUser!!.sexo) {
                    "Masculino" -> {
                        fotito.setBackgroundResource(R.drawable.businessman)
                    }
                    "Femenino" -> {
                        fotito.setBackgroundResource(R.drawable.businesswoman)
                    }
                    "no" -> {
                        fotito.setBackgroundResource(R.drawable.interrogation)
                    }
                }
                prefs2.clave = currentUser!!.avanzada.toInt()
            }

        })
        cloo.setOnClickListener{v ->
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            mAuth = FirebaseAuth.getInstance()
            prefs2.entrada = 0
            mAuth!!.signOut()
            disableFCM()
            mediaPlayer!!.stop()
            val accion="Cerro Sesión el usuario."
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

                }
                .addOnFailureListener { e ->

                }
            startActivity(
                Intent(
                    v.context,
                    LoginActivity::class.java
                )
            )
            Bungee.zoom( v.context)
            finish()
        }
        saveButtonjh656.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            var  cantid=eclav.text.toString().length
            if (cantid==4){
                if (prefs2.clave == (eclav.text.toString()).toInt()) {
                    uno1.visibility = View.VISIBLE
                    dos2.visibility = View.VISIBLE
                    tres3.visibility = View.VISIBLE
                    cuatro4.visibility = View.VISIBLE
                    cinco5.visibility = View.VISIBLE
                    seis6.visibility = View.VISIBLE
                    siete7.visibility = View.VISIBLE
                    ocho8.visibility =  View.VISIBLE
                    eclav.setText("")
                } else if (prefs2.clave != (eclav.text.toString()).toInt()) {
                    uno1.visibility = View.VISIBLE
                    dos2.visibility = View.GONE
                    tres3.visibility = View.GONE
                    cuatro4.visibility = View.GONE
                    cinco5.visibility = View.GONE
                    seis6.visibility = View.GONE
                    siete7.visibility =  View.VISIBLE
                    ocho8.visibility =  View.VISIBLE
                    toast("Código incorrecto")
                    eclav.setText("")
                }
            }else{
                uno1.visibility = View.VISIBLE
                dos2.visibility = View.GONE
                tres3.visibility = View.GONE
                cuatro4.visibility = View.GONE
                cinco5.visibility = View.GONE
                seis6.visibility = View.GONE
                siete7.visibility= View.VISIBLE
                ocho8.visibility =  View.VISIBLE
                toast("Código no valido")
                eclav.setText("")
            }
        }
        Optiones7.setOnClickListener {
            mediaPlayer!!.stop()

            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            prefs1.activi = "MenuP"
            startActivity(Intent(this, Audio::class.java))
            Bungee.zoom(this)
        }
        val uno22=findViewById<CardView>(R.id.uno1)
        uno22.setOnClickListener { v->
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val customDialog = Dialog(this)
            customDialog.setContentView(R.layout.comu)
            customDialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            )
            customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val Avaz11 = customDialog.findViewById<LottieAnimationView>(R.id.Avaz1) as LottieAnimationView
            val Avaz21 = customDialog.findViewById<LottieAnimationView>(R.id.Avaz2) as LottieAnimationView
            val Avaz31 = customDialog.findViewById<LottieAnimationView>(R.id.Avaz3) as LottieAnimationView
            Avaz11.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                startActivity(Intent(this, UsersActivity::class.java))
                Bungee.zoom(this)
            }
           Avaz21.setOnClickListener {
               soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
               val customDialog00 = Dialog(this)
               customDialog00.setContentView(R.layout.submenucumu)
               customDialog00.window?.setLayout(
                   ViewGroup.LayoutParams.MATCH_PARENT,
                   ViewGroup.LayoutParams.WRAP_CONTENT,
               )
               customDialog00.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
               val Avaz110 = customDialog00.findViewById<LottieAnimationView>(R.id.Avaz10) as LottieAnimationView
               val Avaz210 = customDialog00.findViewById<LottieAnimationView>(R.id.Avaz20) as LottieAnimationView
               val Avaz310 = customDialog00.findViewById<LottieAnimationView>(R.id.Avaz30) as LottieAnimationView
               Avaz110.setOnClickListener {
                   soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                   startActivity(Intent(this, ComunidadSinR::class.java))
                   Bungee.zoom(this)
               }
               Avaz210.setOnClickListener {
                   soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                   startActivity(Intent(this, Buzzon1::class.java))
                 Bungee.zoom(this)
               }
               Avaz310.setOnClickListener {
                   soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                   startActivity(Intent(this, ComunidadT::class.java))
                   Bungee.zoom(this)
               }
               customDialog00.show()
            }
            Avaz31.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                startActivity(Intent(this, Avisos::class.java))
                Bungee.zoom(this)
            }
            customDialog.show()
        }
        dos2.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val customDialog = Dialog(this)
            customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            customDialog.setContentView(R.layout.submenuga)
            customDialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            )
            val tus = customDialog.findViewById<LottieAnimationView>(R.id.tus) as LottieAnimationView
            val alu = customDialog.findViewById<LottieAnimationView>(R.id.alu) as LottieAnimationView
            val admi= customDialog.findViewById<LottieAnimationView>(R.id.admi) as LottieAnimationView
            val escu = customDialog.findViewById<LottieAnimationView>(R.id.escu) as LottieAnimationView

            tus.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                val bundle = Bundle()
                bundle.apply {
                    putString("llave", "Slider1")
                }

                val intent = Intent(this, Galerias::class.java).apply {
                    putExtras(bundle)
                }
                startActivity(intent)
            }
            alu.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                val bundle = Bundle()
                bundle.apply {
                    putString("llave", "Slider2")
                }

                val intent = Intent(this, Galerias::class.java).apply {
                    putExtras(bundle)
                }
                startActivity(intent)
            }
            admi.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                val bundle = Bundle()
                bundle.apply {
                    putString("llave", "Slider3")
                }

                val intent = Intent(this, Galerias::class.java).apply {
                    putExtras(bundle)
                }
                startActivity(intent)
            }
            escu.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                startActivity(Intent(this, Galeria1::class.java))
                Bungee.zoom(this)
            }
            customDialog.show()
        }
        tres3.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val customDialog = Dialog(this)
            customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            customDialog.setContentView(R.layout.cata)
            customDialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            )
            val Avaz41 = customDialog.findViewById<LottieAnimationView>(R.id.Avaz4) as LottieAnimationView
            val Avaz51 = customDialog.findViewById<LottieAnimationView>(R.id.Avaz5) as LottieAnimationView
            val Avaz61 = customDialog.findViewById<LottieAnimationView>(R.id.Avaz6) as LottieAnimationView
            val Archivo4 = "Catalogo"
            val defaultPrefs4 = Splash.PreferenceHelper4.defaultPreference4(this)
            defaultPrefs4.dato1 = 0
            defaultPrefs4.dato2 = 0
            val prefs4 = Splash.PreferenceHelper4.customPreference4(this, Archivo4)

            Avaz41.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                prefs4.dato2 = 0
                startActivity(Intent(this, ProdRec::class.java))
                Bungee.zoom(this)
            }
            Avaz51.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                prefs4.dato2 = 1
                startActivity(Intent(this, ProdRec::class.java))
                Bungee.zoom(this)
            }
            Avaz61.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                startActivity(Intent(this, Produc::class.java))
                Bungee.zoom(this)
            }
            customDialog.show()
        }
        cuatro4.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val customDialog00 = Dialog(this)
            customDialog00.setContentView(R.layout.submenuvide)
            customDialog00.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            )
            customDialog00.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val  problematicaM = customDialog00.findViewById<LottieAnimationView>(R.id.problematicaM) as LottieAnimationView
            val construirR = customDialog00.findViewById<LottieAnimationView>(R.id.construirR) as LottieAnimationView
            val construirM = customDialog00.findViewById<LottieAnimationView>(R.id.construirM) as LottieAnimationView
            val entrevistaM = customDialog00.findViewById<LottieAnimationView>(R.id.entrevistaM) as LottieAnimationView
            val Alumno = customDialog00.findViewById<LottieAnimationView>(R.id.Alumno) as LottieAnimationView
            val Tutor = customDialog00.findViewById<LottieAnimationView>(R.id.Tutor) as LottieAnimationView
            val util = customDialog00.findViewById<LottieAnimationView>(R.id.util) as LottieAnimationView
            val Admin = customDialog00.findViewById<LottieAnimationView>(R.id.Admin) as LottieAnimationView
            val vaciarT5 = customDialog00.findViewById<LottieAnimationView>(R.id.vaciarT5) as LottieAnimationView
            problematicaM.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                val bundle = Bundle()
                bundle.apply {
                    putString("llave", "problema")
                }

                val intent = Intent(applicationContext, video::class.java).apply {
                    putExtras(bundle)
                }
                startActivity(intent)
            }
            construirR.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                val bundle = Bundle()
                bundle.apply {
                    putString("llave", "construir1")
                }

                val intent = Intent(applicationContext, video::class.java).apply {
                    putExtras(bundle)
                }
                startActivity(intent)
            }
            construirM.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                val bundle = Bundle()
                bundle.apply {
                    putString("llave", "construir")
                }

                val intent = Intent(applicationContext, video::class.java).apply {
                    putExtras(bundle)
                }
                startActivity(intent)
            }
            entrevistaM.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                val bundle = Bundle()
                bundle.apply {
                    putString("llave", "entrevista")
                }

                val intent = Intent(applicationContext, video::class.java).apply {
                    putExtras(bundle)
                }
                startActivity(intent)
            }
            Alumno.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                val bundle = Bundle()
                bundle.apply {
                    putString("llave", "alumno")
                }

                val intent = Intent(applicationContext, video::class.java).apply {
                    putExtras(bundle)
                }
                startActivity(intent)
            }
            Tutor.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                val bundle = Bundle()
                bundle.apply {
                    putString("llave", "tutor")
                }

                val intent = Intent(applicationContext, video::class.java).apply {
                    putExtras(bundle)
                }
                startActivity(intent)
            }
            util.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                val bundle = Bundle()
                bundle.apply {
                    putString("llave", "util")
                }

                val intent = Intent(applicationContext, video::class.java).apply {
                    putExtras(bundle)
                }
                startActivity(intent)
            }
            Admin.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                val bundle = Bundle()
                bundle.apply {
                    putString("llave", "Admin")
                }

                val intent = Intent(applicationContext, video::class.java).apply {
                    putExtras(bundle)
                }
                startActivity(intent)
            }
            vaciarT5.setOnClickListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
               alerVaciTV()
            }
            customDialog00.show()

        }
        cinco5.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, doc::class.java))
            Bungee.zoom(this) }
        seis6.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, Redes::class.java))
            Bungee.zoom(this)
            finish()
        }
        siete7.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, Extras::class.java))
            Bungee.zoom(this)
            finish()
        }
        ocho8.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this,Logs::class.java))
            Bungee.zoom(this)
            finish()
        }
        Ayuda00.setOnClickListener {
            mediaPlayer?.pause()
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            startActivity(Intent(this, Ayuda::class.java))
            Bungee.zoom(this)
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
    private fun  alerVaciTV() {
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
        customDialog.texto.setText("¿Desea realmente eliminar todos los videos?")

        yesBtn.setOnClickListener {
            database.child("Video").child("Alumno").removeValue()
            database.child("Video").child("memo").removeValue()
            database.child("Video").child("rompe").removeValue()
            database.child("Video").child("entre").removeValue()
            database.child("Video").child("Problematica").removeValue()
            database.child("Video").child("Tutor").removeValue()
            database.child("Video").child("Admin").removeValue()
            database.child("Video").child("util").removeValue()
            val Archivo2 = "Chat"
            val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)
            defaultPrefs2.codi = 0
            val prefs2 = Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)
            val accion = "Eliminó todos los videos."
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
    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
    }
    fun recargar1(){
        overridePendingTransition(0, 0);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
        overridePendingTransition(0, 0);
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