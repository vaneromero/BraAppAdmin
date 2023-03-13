package com.bp.braappadmin.registross

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.ScaleAnimation
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bp.braappadmin.ClickListener
import com.bp.braappadmin.R
import com.bp.braappadmin.comunicacion.avisos.loggg
import com.bp.braappadmin.comunicacion.chat.model.User
import com.bp.braappadmin.inicio.Splash
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.activi
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.tono
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum1
import com.bp.braappadmin.menuP.MenuPrinci
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_confirmacion.*
import kotlinx.android.synthetic.main.activity_logs.*
import kotlinx.android.synthetic.main.activity_menu_princi.*
import kotlinx.android.synthetic.main.activity_prodc_detalle.*
import kotlinx.android.synthetic.main.log_detalle.*
import kotlinx.android.synthetic.main.loggs1.view.*
import kotlinx.android.synthetic.main.producto_content.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.util.*

class Logs : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    var adaptador: adaptadorL? = null
    var lita1: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    val datos = ArrayList<loggg>()
    private val datos1: MutableList<User> = ArrayList()
    private val database = Firebase.database
    val myRef = database.getReference("Administradores")
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private lateinit var messagesListener: ValueEventListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logs)

        val texto6: LinearLayout = findViewById(R.id.contendgfa)
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto6.startAnimation(anim1)
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
        vaciarT5S.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val customDialog = Dialog(this)
            customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            customDialog.setContentView(R.layout.activity_confirmacion)
            customDialog.window?.setLayout(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            customDialog.jkdsf.visibility = View.GONE

            customDialog.tituloAviso.setText("Aviso")
            customDialog.texto.setText("Vaya a la BraWeb para eliminar los logs.")
            customDialog.show()
        }
        codigo.setOnFocusChangeListener { view, b ->
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
        setupRecyclerView2("")
        datos.clear()
        swipeRefreshSgf.setOnRefreshListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            setupRecyclerView2("")
            swipeRefreshSgf.isRefreshing = false
        }
        setupRecyclerView21(SlidsdeRecyclerViewgfhfg)
        datos1.clear()
        swipeRefreshgffdSgf.setOnRefreshListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            setupRecyclerView21(SlidsdeRecyclerViewgfhfg)
            swipeRefreshgffdSgf.isRefreshing = false
        }
        saveButton656.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (codigo.text.isEmpty()) {
                toast("No se puede hacer la busqueda")
                setupRecyclerView2("")
                datos.clear()
                swipeRefreshSgf.setOnRefreshListener {
                    datos.clear()
                    setupRecyclerView2("")
                    swipeRefreshSgf.isRefreshing = false
                }
            } else {
                datos.clear()
                setupRecyclerView2(codigo.text.toString())
                swipeRefreshSgf.setOnRefreshListener {
                    datos.clear()
                    setupRecyclerView2(codigo.text.toString())
                    swipeRefreshSgf.isRefreshing = false
                }

            }
        }
    }

    @SuppressLint("WrongConstant")
    //todo
    fun setupRecyclerView2(datss: String) {
        datos.clear()
        if (datss == "") {
            db.collection("Logs").orderBy("fecha1", Query.Direction.DESCENDING)
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        datos.add(
                            loggg(
                                "${document.get("accion")}",
                                "${document.get("codidd")}",
                                "${document.get("fecha1")}",
                                "${document.get("lugar")}"
                            )
                        )
                        lita1?.setHasFixedSize(true)  //adaptador tamaño de la vista
                        lita1 = findViewById(R.id.SlideRecyclerViewfg)
                        layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                        lita1?.layoutManager = layoutManager  // donde se dibuje el layout
                        adaptador = adaptadorL(this, datos, object : ClickListener {
                            override fun onClick(vista: View, index: Int) {
                                val customDialog = Dialog(this@Logs)
                                customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                                customDialog.setContentView(R.layout.log_detalle)
                                customDialog.window?.setLayout(
                                    ViewGroup.LayoutParams.WRAP_CONTENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT
                                )
                                Log.v("jkdkjnvcjd", "${datos[index].fecha1}")
                                db.collection("Logs").whereEqualTo("fecha1", datos[index].fecha1)
                                    .get()
                                    .addOnSuccessListener { result ->
                                        for (document in result) {
                                            if (document.get("lugar") == "Movil") {
                                                customDialog.fotos.setBackgroundResource(R.drawable.mov)
                                            } else if (document.get("lugar") == "Web") {
                                                customDialog.fotos.setBackgroundResource(R.drawable.mon)
                                            }
                                            customDialog.codigo1.text = "${document.get("codidd")}"
                                            customDialog.fecha1.text = "${document.get("fecha1")}"
                                            customDialog.accion1.text = "${document.get("accion")}"
                                        }

                                    }
                                    .addOnFailureListener { exception ->
                                        toast("Error al devolver la información")
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
        } else if (datss != "") {

            db.collection("Logs").whereEqualTo("codidd", datss.toInt())
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        datos.add(
                            loggg(
                                "${document.get("accion")}",
                                "${document.get("codidd")}",
                                "${document.get("fecha1")}",
                                "${document.get("lugar")}"
                            )
                        )
                        lita1?.setHasFixedSize(true)  //adaptador tamaño de la vista
                        lita1 = findViewById(R.id.SlideRecyclerViewfg)
                        layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                        lita1?.layoutManager = layoutManager  // donde se dibuje el layout
                        adaptador = adaptadorL(this, datos, object : ClickListener {
                            override fun onClick(vista: View, index: Int) {
                                val customDialog = Dialog(this@Logs)
                                customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                                customDialog.setContentView(R.layout.log_detalle)
                                customDialog.window?.setLayout(
                                    ViewGroup.LayoutParams.WRAP_CONTENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT
                                )
                                Log.v("jkdkjnvcjd", "${datos[index].fecha1}")
                                db.collection("Logs").whereEqualTo("fecha1", datos[index].fecha1)
                                    .get()
                                    .addOnSuccessListener { result ->
                                        for (document in result) {
                                            if (document.get("lugar") == "Movil") {
                                                customDialog.fotos.setBackgroundResource(R.drawable.mov)
                                            } else if (document.get("lugar") == "Web") {
                                                customDialog.fotos.setBackgroundResource(R.drawable.mon)
                                            }
                                            customDialog.codigo1.text = "${document.get("codidd")}"
                                            customDialog.fecha1.text = "${document.get("fecha1")}"
                                            customDialog.accion1.text = "${document.get("accion")}"

                                        }
                                    }
                                    .addOnFailureListener { exception ->
                                        toast("Error al devolver la información")
                                    }

                                customDialog.show()
                            }
                        })
                        lita1?.adapter = adaptador
                    }
                }
                .addOnFailureListener { exception ->
                    toast("No se encontró código")
                    setupRecyclerView2("")
                    datos.clear()
                    swipeRefreshSgf.setOnRefreshListener {
                        datos.clear()
                        setupRecyclerView2("")
                        swipeRefreshSgf.isRefreshing = false
                    }
                }
        }
    }

    @SuppressLint("WrongConstant")
    //todo
    fun setupRecyclerView21(recyclerView: RecyclerView) {
        datos1.clear()
        messagesListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                datos1.clear()
                dataSnapshot.children.forEach { child ->
                    datos1.add(
                        User(
                            "${child.child("userId").getValue<String>()}",
                            "${child.child("userName").getValue<String>()}",
                            "${child.child("sexo").getValue<String>()}",
                            "${child.child("contraseña").getValue<String>()}",
                            "${child.child("avanzada").getValue<String>()}",
                            "${child.child("email").getValue<String>()}"
                        )
                    )

                }
                recyclerView.adapter = ProductoViewAdapter2(datos1)
            }

            override fun onCancelled(error: DatabaseError) {
                toast("Cancelado")
            }
        }
        myRef.addValueEventListener(messagesListener)

    }

    class ProductoViewAdapter2(private val values: List<User>) :
        RecyclerView.Adapter<ProductoViewAdapter2.ViewHolder>() {
        private var lastPosition = -1
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.loggs1, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val producto = values[position]
            holder.cods.text = producto.avanzada
            holder.fecha1s.text = producto.email
            holder.usuws.text = producto.userName
            setAnimation(holder.itemView, position);
        }

        override fun getItemCount() = values.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val cods: TextView = view.cods
            val fecha1s: TextView = view.fecha1s
            val usuws: TextView = view.usuws
        }

        fun setAnimation(viewToAnimate: View, position: Int) {
            // If the bound view wasn't previously displayed on screen, it's animated
            if (position > lastPosition) {
                val anim = ScaleAnimation(
                    0.0f,
                    1.0f,
                    0.0f,
                    1.0f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f
                )
                anim.duration =
                    Random().nextInt(501).toLong() //to make duration random number between [0,501)

                viewToAnimate.startAnimation(anim)
                lastPosition = position
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