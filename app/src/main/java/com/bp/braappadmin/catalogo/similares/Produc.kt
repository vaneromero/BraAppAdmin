package com.bp.braappadmin.catalogo.similares

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bp.braappadmin.R
import com.bp.braappadmin.catalogo.producto.ProdRec
import com.bp.braappadmin.comunicacion.chat.model.User
import com.bp.braappadmin.help.Ayuda
import com.bp.braappadmin.inicio.Splash
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.activi
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.tono
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum1
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.codi
import com.bp.braappadmin.inicio.Splash.PreferenceHelper4.dato1
import com.bp.braappadmin.inicio.Splash.PreferenceHelper4.dato2
import com.bp.braappadmin.inicio.Splash.PreferenceHelper4.dato3
import com.bp.braappadmin.menuP.MenuPrinci
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_prodc_detalle.*
import kotlinx.android.synthetic.main.activity_produc.*
import kotlinx.android.synthetic.main.producto_content.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class Produc : AppCompatActivity() {
    private val database = Firebase.database
    private lateinit var messagesListener: ValueEventListener
    private val listProductos: MutableList<Producto> = ArrayList()
    private val db = FirebaseFirestore.getInstance()
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    val myRef = database.getReference("Productos Similares")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produc)
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
        val texto2: ConstraintLayout = findViewById(R.id.jk879w)
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto2.startAnimation(anim1)
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
        Ayuda001P1.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            mediaPlayer!!.pause()
            startActivity(Intent(this, Ayuda::class.java))
            Bungee.zoom(this)
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
                bu232.text = currentUser!!.userName
                when (currentUser!!.sexo) {
                    "Masculino" -> {
                        imgProfilesds.setBackgroundResource(R.drawable.businessman)
                    }
                    "Femenino" -> {
                        imgProfilesds.setBackgroundResource(R.drawable.businesswoman)
                    }
                    "no" -> {
                        imgProfilesds.setBackgroundResource(R.drawable.interrogation)
                    }
                }

            }

        })
        newFloatingActionButton.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val bundle = Bundle()
            bundle.apply {
                putString("llave", "uno")
            }
            val intent = Intent(this@Produc, ProducAgregar::class.java).apply {
                putExtras(bundle)
            }
            startActivity(intent)
            Bungee.zoom(this@Produc)
            finish()
        }
        swipeRefresh123.setOnRefreshListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            setupRecyclerView(productoRecyclerView)
            swipeRefresh123.isRefreshing = false
        }
        listProductos.clear()
        setupRecyclerView(productoRecyclerView)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        messagesListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listProductos.clear()
                dataSnapshot.children.forEach { child ->
                    val producto: Producto? =
                        Producto(
                            child.child("nombre").getValue<String>(),
                            child.child("precio").getValue<String>(),
                            child.child("sitio").getValue<String>(),
                            child.child("descripción").getValue<String>(),
                            child.child("url").getValue<String>(),
                            child.child("link").getValue<String>(),
                            child.child("nombresito").getValue<String>(),
                            child.key
                        )
                    producto?.let { listProductos.add(it) }
                }
                recyclerView.adapter = ProductoViewAdapter(listProductos)
            }

            override fun onCancelled(error: DatabaseError) {
                toast("Cancelado")
            }
        }
        myRef.addValueEventListener(messagesListener)
        deleteSwipe(recyclerView)
    }

    class ProductoViewAdapter(private val values: List<Producto>) :
        RecyclerView.Adapter<ProductoViewAdapter.ViewHolder>() {
        private var lastPosition = -1
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.producto_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val producto = values[position]
            holder.uno.text = producto.nombre
            holder.dos.text = producto.precio
            holder.mPosterImgeView?.let {
                Glide.with(holder.itemView.context)
                    .load(producto.url)
                    .into(it)
            }
            holder.itemView.setOnClickListener { v ->
                val customDialog = Dialog(v.context)
                customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                customDialog.setContentView(R.layout.activity_prodc_detalle)
                customDialog.window?.setLayout(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                var url = ""
                val database = Firebase.database
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                val myRef = database.getReference("Productos Similares").child(
                    producto.key.toString()
                )
                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {

                        val producto:Producto? = dataSnapshot.getValue(Producto::class.java)
                        if (producto!= null) {
                            customDialog.nameTextView.text = producto.nombre.toString()
                            customDialog.precioTextView.text=producto.precio.toString()
                            customDialog.sitioTextView.text=producto.sitio.toString()
                            customDialog.descriptionTextView.text = producto.descripción.toString()
                            Glide.with(v.context)
                                .load(producto.url.toString())
                                .into( customDialog.posterImgeView)
                            customDialog.urlTextView.setOnClickListener {
                                url = producto.link.toString()
                                val i = Intent(Intent.ACTION_VIEW)
                                i.data = Uri.parse(url)
                                v.context.startActivity(i)
                                Bungee.zoom(v.context)

                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.w("TAG", "Failed to read value.", error.toException())
                    }
                })

                customDialog.show()

            }
            holder.itemView.setOnLongClickListener { v ->
                val intent = Intent(v.context, ProducAgregar::class.java).apply {
                    putExtra("llave", "dos")
                    putExtra("key", producto.key)
                }
                v.context.startActivity(intent)
                Bungee.zoom(v.context)
                true
            }
            setAnimation(holder.itemView, position);
        }

        override fun getItemCount() = values.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val uno: TextView = view.name1TextView
            val dos: TextView = view.dateTextView
            val mPosterImgeView: ImageView? = view.posterImgeView
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

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                listProductos[viewHolder.adapterPosition].key?.let {
                    val database = Firebase.database

                    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                    val myRef2 = database.getReference("Productos Similares").child(
                        myRef.child(it).key.toString()
                    )
                    myRef2.addValueEventListener(object : ValueEventListener {
                        @SuppressLint("RestrictedApi")
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            val producto: Propio? = dataSnapshot.getValue(Propio::class.java)
                            if (producto != null) {
                                nonm5.text = producto.nombresito
                                Log.v("Prueba", " datos ${nonm5.text}")
                                val ref =
                                    FirebaseStorage.getInstance().reference.child("/Productos/${nonm5.text}")
                                ref.delete().addOnSuccessListener {

                                    val Archivo2 = "Chat"
                                    val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                                    defaultPrefs2.codi = 0

                                    val prefs2 = Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                                    val accion = "Se Eliminó Producto Similar."
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
                                            toast("Datos borrados")
                                        }
                                        .addOnFailureListener { e ->

                                        }
                                }.addOnFailureListener {
                                    toast("Datos no borrados")
                                }
                                myRef.child(it).setValue(null)
                            }
                        }

                        override fun onCancelled(error: DatabaseError) {
                            toast("Error en leer los valores")
                        }
                    })

                }
                listProductos.removeAt(viewHolder.adapterPosition)
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
        val Archivo4 = "Catalogo"
        val defaultPrefs4 = Splash.PreferenceHelper4.defaultPreference4(this)
        defaultPrefs4.dato1 = 0
        defaultPrefs4.dato2 = 0
        defaultPrefs4.dato3 = 0

        mediaPlayer!!.stop()

        val prefs4 = Splash.PreferenceHelper4.customPreference4(this, Archivo4)
        prefs4.dato3=5
        startActivity(Intent(this@Produc, MenuPrinci::class.java))
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