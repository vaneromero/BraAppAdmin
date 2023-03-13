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
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
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
import kotlinx.android.synthetic.main.activity_comunidad_t.*
import kotlinx.android.synthetic.main.activity_confirmacion.*
import kotlinx.android.synthetic.main.buzzond.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ComunidadT : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    var adaptador: adaptadorD? = null
    var lita1: RecyclerView? = null
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    val datos = ArrayList<correol>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comunidad_t)
        val texto1: ConstraintLayout = findViewById(R.id.cont44)
        val texto2: LinearLayout = findViewById(R.id.linearLayout3)
        val texto3: LottieAnimationView = findViewById(R.id.vaciarT1)
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto1.startAnimation(anim1)
        texto2.startAnimation(anim1)
        texto3.startAnimation(anim1)
        val firebase: FirebaseUser = FirebaseAuth.getInstance().currentUser!!
        datos.clear()
          setupRecyclerView2()
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
        swipeRefresh123451.setOnRefreshListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            datos.clear()
            setupRecyclerView2()
            swipeRefresh123451.isRefreshing = false
        }
        vaciarT1.setOnClickListener {
            alerta3()
        }
        Ayuda0011.setOnClickListener {
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
            bgu3d1.text = currentUser!!.userName
            when (currentUser!!.sexo) {
                "Masculino" -> {
                    fotito1g11.setBackgroundResource(R.drawable.businessman)
                }
                "Femenino" -> {
                    fotito1g11.setBackgroundResource(R.drawable.businesswoman)
                }
                "no" -> {
                    fotito1g11.setBackgroundResource(R.drawable.interrogation)

                }
            }

        }

    })

}

@SuppressLint("WrongConstant")
//todo
fun setupRecyclerView2() {
    datos.clear()
    db.collection("Correo").orderBy("fecha", Query.Direction.DESCENDING)
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
                lita1 = findViewById(R.id.menuCorreo51)
                layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                lita1?.layoutManager = layoutManager  // donde se dibuje el layout
                adaptador = adaptadorD(this@ComunidadT, datos, object : ClickListener {

                    override fun onClick(vista: View, index: Int) {
                        alerta4("Todo",datos[index].fecha)
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
    private fun alerta3() {
        val db = FirebaseFirestore.getInstance()
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.activity_confirmacion)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )
        val yesBtn = customDialog.findViewById<Button>(R.id.yes_opt9) as TextView
        val noBtn = customDialog.findViewById<Button>(R.id.no_opt9) as TextView
        customDialog.texto.setText("¿Desea realmente eliminar todos los correos recibidos?")


        yesBtn.setOnClickListener {
            db.collection("Correo")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        db.collection("Correo").document(document.id).delete()
                    }
                }
                .addOnFailureListener { exception ->
                    Log.v("Prueba","Nofunciona")
                }

            toast("Todos los Datos Borrados")
            val Archivo2 = "Chat"
            val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(this)
            defaultPrefs2.entrada = 0
            defaultPrefs2.clave = 0
            defaultPrefs2.codi = 0

            val prefs2 = Splash.PreferenceHelper2.customPreference2(this, Archivo2)

            val accion="Todos los Datos Borrados."
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
            customDialog.dismiss()
        }
        noBtn.setOnClickListener {
            customDialog.dismiss()
        }
        customDialog.show()

    }
    private fun alerta4(tipo:String,fecha:String) {
        val db = FirebaseFirestore.getInstance()
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.buzzond)
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )

        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            customDialog.respuesta.visibility=View.GONE
            customDialog.saveButto443.visibility= View.GONE

            Log.v("prueba", "$tipo")
            db.collection("Correo").whereEqualTo("fecha", "$fecha")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        customDialog.fechaa.text = "${document.get("fecha")}"
                        customDialog.user.text = "${document.get("usuario")}"
                        customDialog.pregunta.text = "${document.get("pregunta")}"
                        customDialog.respuesta1.text = "${document.get("respuesta")}"
           if (document.get("adm")==""||document.get("adm")==null){
               customDialog.use3f.visibility= View.GONE
               customDialog.use3fd.visibility= View.GONE
           }else{
               customDialog.use3f.visibility= View.VISIBLE
               customDialog.use3fd.visibility= View.VISIBLE
               customDialog.respuesta3.text = "${document.get("adm")}"
               customDialog.respuesta45.text = "${document.get("admho")}"
           }
                        customDialog.user24.text = "${document.id}"
                    }

                }
                .addOnFailureListener { exception ->
                    toast("Error al devolver la información")
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

                val accion="Eliminó Aviso."
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
    fun recargar(){
        finish(); overridePendingTransition(0, 0); startActivity(getIntent()); overridePendingTransition(0, 0);
    }
    override fun onBackPressed() {
        super.onBackPressed()
        mediaPlayer!!.stop()
        startActivity(Intent(this@ComunidadT, MenuPrinci::class.java))
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