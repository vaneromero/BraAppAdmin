package com.bp.braappadmin.documentos

import android.annotation.SuppressLint
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bp.braappadmin.R
import com.bp.braappadmin.help.Ayuda
import com.bp.braappadmin.inicio.LoginActivity
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
import kotlinx.android.synthetic.main.activity_doc.*
import kotlinx.android.synthetic.main.activity_galeria1.*
import kotlinx.android.synthetic.main.list_item5.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class doc : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private val database = Firebase.database
    private lateinit var messagesListener: ValueEventListener
    private val listDocumentos: MutableList<Documentos> = ArrayList()
    private val db = FirebaseFirestore.getInstance()
    val myRef = database.getReference("Documentos")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doc)
        //Asignacioón de las animaciones
        val texto1: Button = findViewById(R.id.mover)
        val texto2: ConstraintLayout = findViewById(R.id.contttt)
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto1.startAnimation(anim1)
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
        Ayuda001n.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            mediaPlayer!!.pause()
            startActivity(Intent(this, Ayuda::class.java))
            Bungee.zoom(this)
        }
        swipeRefreshDocumentos.setOnRefreshListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            setupRecyclerView(menuDocumentos)
            swipeRefreshDocumentos.isRefreshing = false
        }
        listDocumentos.clear()
        setupRecyclerView(menuDocumentos)
        mover.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
        startActivity(Intent(this, Documento::class.java))
            Bungee.zoom(this)
            finish()
        }
    }
    private fun setupRecyclerView(recyclerView: RecyclerView) {

        messagesListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listDocumentos.clear()
                dataSnapshot.children.forEach { child ->

                    val producto: Documentos? =
                        Documentos(
                            child.child("fecha").value.toString(),
                            child.child("nombre").value.toString(),
                            child.child("url1").value.toString(),
                            child.child("url2").value.toString(),
                            child.child("url3").value.toString(),
                            child.key
                        )
                    producto?.let { listDocumentos.add(it) }
                }
                recyclerView.adapter = Producto1ViewAdapter(listDocumentos)
            }

            override fun onCancelled(error: DatabaseError) {
                toast("error")
            }
        }
        myRef.addValueEventListener(messagesListener)
        deleteSwipe(recyclerView)
    }
    class Producto1ViewAdapter(private val values: List<Documentos>) :
        RecyclerView.Adapter<Producto1ViewAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            Log.v("Prueba1", "10")
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item5, parent, false)
            return ViewHolder(view)
            Log.v("Prueba1", "11")
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            Log.v("Prueba1", "12")
            val producto1 = values[position]
            holder.fecc!!.visibility=View.VISIBLE
            holder.fecc!!.text=producto1.fecha
            holder.uno.text = producto1.nombre
            holder.mPoster!!.setBackgroundResource(R.drawable.derechos)

        }

        override fun getItemCount() = values.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            val uno: TextView = view.name2
            val mPoster: TextView? = view.imagd
            val fecc:TextView?=view.fee
        }

    }

    private fun deleteSwipe(recyclerView: RecyclerView) {
        val touchHelperCallback: ItemTouchHelper.SimpleCallback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                listDocumentos.get(viewHolder.adapterPosition).key?.let {
                    val database = Firebase.database

                    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                    val myRef2 = database.getReference("Documentos").child(
                        myRef.child(it).key.toString()
                    )
                    myRef2.addValueEventListener(object : ValueEventListener {
                        @SuppressLint("RestrictedApi")
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            val producto: Documentos? =
                                dataSnapshot.getValue(Documentos::class.java)
                            if (producto != null) {
                                myRef.child(it).setValue(null)
                                val Archivo2 = "Chat"
                                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                                defaultPrefs2.codi = 0

                                val prefs2 = Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                                val accion = "Se Eliminó Documento."
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

                        }

                        override fun onCancelled(error: DatabaseError) {
                            toast("error")
                        }
                    })

                }
                listDocumentos.removeAt(viewHolder.adapterPosition)
                recyclerView.adapter?.notifyItemRemoved(viewHolder.adapterPosition)
                recyclerView.adapter?.notifyDataSetChanged()

            }
        }
        val itemTouchHelper = ItemTouchHelper(touchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
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