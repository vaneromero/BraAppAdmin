package com.bp.braappadmin.catalogo.producto

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
import com.bp.braappadmin.catalogo.similares.Propio
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
import kotlinx.android.synthetic.main.activity_prod_rec.*
import kotlinx.android.synthetic.main.activity_prodrec_detalle1.*
import kotlinx.android.synthetic.main.activity_prodrec_detalle1.posterImgeView8
import kotlinx.android.synthetic.main.activity_prodrec_detalle2.*
import kotlinx.android.synthetic.main.producto_content1.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ProdRec : AppCompatActivity() {
    private val database = Firebase.database
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private lateinit var messagesListener: ValueEventListener
    private val listPropio: MutableList<Propio> = ArrayList()
    val myRefPropio = database.getReference("Propio")
    private val listRecomendacion: MutableList<Recomendacion> = ArrayList()
    private val db = FirebaseFirestore.getInstance()
    val myRefRecomendaciones = database.getReference("Recomendaciones")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prod_rec)
        val texto2: ConstraintLayout = findViewById(R.id.jvkd5634)
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto2.startAnimation(anim1)
        val firebase: FirebaseUser = FirebaseAuth.getInstance().currentUser!!
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
        Ayuda001p.setOnClickListener {
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
                bu232t.text = currentUser!!.userName
                when (currentUser!!.sexo) {
                    "Masculino" -> {
                        imgProfilesdstg.setBackgroundResource(R.drawable.businessman)
                    }
                    "Femenino" -> {
                        imgProfilesdstg.setBackgroundResource(R.drawable.businesswoman)
                    }
                    "no" -> {
                        imgProfilesdstg.setBackgroundResource(R.drawable.interrogation)
                    }
                }

            }

        })
        val Archivo4 = "Catalogo"
        val defaultPrefs4 = Splash.PreferenceHelper4.defaultPreference4(this)
        defaultPrefs4.dato1 = 0
        defaultPrefs4.dato2 = 0
        defaultPrefs4.dato3 = 0
        val prefs4 = Splash.PreferenceHelper4.customPreference4(this, Archivo4)
        if (prefs4.dato2==0){
            titulito.setText("Productos Braille Package")
            //Propio
            newFloatingActionButtonPropio.visibility= View.VISIBLE
            newFloatingActionButtonRecomendacion.visibility= View.GONE
            productosP.visibility= View.VISIBLE
            productosR.visibility= View.GONE
            swipeRefreshPropio1.setOnRefreshListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                setupRecyclerViewPropio(PropioRecyclerView)
                swipeRefreshPropio1.isRefreshing = false
            }
            listPropio.clear()
            setupRecyclerViewPropio(PropioRecyclerView)
        }
        else if (prefs4.dato2==1){
            titulito.setText("Recomendaciones")
            //recomendación
            newFloatingActionButtonPropio.visibility= View.GONE
            newFloatingActionButtonRecomendacion.visibility= View.VISIBLE
            productosP.visibility= View.GONE
            productosR.visibility= View.VISIBLE
            swipeRefreshRecomendacion1.setOnRefreshListener {
                soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                setupRecyclerViewRecomendacion(RecomendacionRecyclerView)
                swipeRefreshRecomendacion1.isRefreshing = false
            }
            listRecomendacion.clear()
            setupRecyclerViewRecomendacion(RecomendacionRecyclerView)
        }
        newFloatingActionButtonPropio.setOnClickListener { v ->
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            prefs4.dato3=1
            startActivity(Intent(this@ProdRec, ProdRecAgregar::class.java))
            Bungee.zoom(this)
            finish()
        }
        newFloatingActionButtonRecomendacion.setOnClickListener { v ->
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            prefs4.dato3=2
            startActivity(Intent(this@ProdRec, ProdRecAgregar::class.java))
            Bungee.zoom(this)
            finish()
        }


    }
    private fun setupRecyclerViewPropio(recyclerView: RecyclerView) {

        messagesListener = object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listPropio.clear()
                dataSnapshot.children.forEach { child ->
                    val producto: Propio? =
                        Propio(
                            child.child("nombre").getValue<String>(),
                            child.child("descripción").getValue<String>(),
                            child.child("url").getValue<String>(),
                            child.child("nombresito").getValue<String>(),
                            child.key
                        )
                    producto?.let { listPropio.add(it) }
                }
                recyclerView.adapter = Producto1ViewAdapterPropio(listPropio)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("TAG", "messages:onCancelled: ${error.message}")
            }
        }
        myRefPropio.addValueEventListener(messagesListener)
        deleteSwipePropio(recyclerView)
    }

    class Producto1ViewAdapterPropio(private val values: List<Propio>) :
        RecyclerView.Adapter<Producto1ViewAdapterPropio.ViewHolder>() {
        private var lastPosition = -1
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.producto_content1, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val producto1 = values[position]
            holder.uno.text = producto1.nombre
            holder.mPoster?.let {
                Glide.with(holder.itemView.context)
                    .load(producto1.url)
                    .into(it)
            }
            setAnimation(holder.itemView, position);
            holder.itemView.setOnClickListener { v ->

                val customDialog = Dialog(v.context)
                customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                customDialog.setContentView(R.layout.activity_prodrec_detalle2)
                customDialog.window?.setLayout(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                var url = ""
                val database = Firebase.database
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                val myRef9 = database.getReference("Propio").child(
                    producto1.key.toString()
                )
                myRef9.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {

                        val producto: Propio? = dataSnapshot.getValue(Propio::class.java)
                        if (producto!= null) {
                            customDialog.nameTextVie9w.text = producto.nombre.toString()
                            customDialog.descriptio78nTextView.text = producto.descripción.toString()
                            Glide.with(v.context)
                                .load(producto.url.toString())
                                .into(customDialog.posterImgeViejgdw)

                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.w("TAG", "Failed to read value.", error.toException())
                    }
                })

                customDialog.show()
            }
            holder.itemView.setOnLongClickListener{ v ->
                val Archivo4 = "Catalogo"
                val defaultPrefs4 = Splash.PreferenceHelper4.defaultPreference4(v.context)
                defaultPrefs4.dato1 = 0
                defaultPrefs4.dato2 = 0
                defaultPrefs4.dato3 = 0
                val prefs4 = Splash.PreferenceHelper4.customPreference4(v.context, Archivo4)
                prefs4.dato3=3
                val intent = Intent(v.context, ProdRecAgregar::class.java).apply {
                    putExtra("key", producto1.key)
                }
                v.context.startActivity(intent)
                Bungee.zoom(v.context)
                true
            }
        }

        override fun getItemCount() = values.size
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val uno: TextView = view.name1TextViewRecomendacion
            val mPoster: ImageView? = view.logito
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

    private fun deleteSwipePropio(recyclerView: RecyclerView) {
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
                listPropio.get(viewHolder.adapterPosition).key?.let {
                    val database = Firebase.database
                    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                    val myRef2 = database.getReference("Propio").child(
                        myRefPropio.child(it).key.toString()
                    )
                    myRef2.addValueEventListener(object : ValueEventListener {
                        @SuppressLint("RestrictedApi")
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            val producto: Propio? = dataSnapshot.getValue(Propio::class.java)
                            if (producto!= null) {
                                nonm1.text=producto.nombresito
                                val ref = FirebaseStorage.getInstance().reference.child("/Propio/${nonm1.text}")

                                ref.delete().addOnSuccessListener {
                                    val Archivo2 = "Chat"
                                    val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                                    defaultPrefs2.codi = 0

                                    val prefs2 = Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                                    val accion = "Se Eliminó Producto Propio."
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
                                myRefPropio.child(it).setValue(null)
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            Log.w("TAG", "Failed to read value.", error.toException())
                        }
                    })

                }
                listPropio.removeAt(viewHolder.adapterPosition)
                recyclerView.adapter?.notifyItemRemoved(viewHolder.adapterPosition)
                recyclerView.adapter?.notifyDataSetChanged()
            }
        }
        val itemTouchHelper = ItemTouchHelper(touchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun setupRecyclerViewRecomendacion(recyclerView: RecyclerView) {
        Log.v("Prueba1", "1")
        messagesListener = object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listRecomendacion.clear()
                dataSnapshot.children.forEach { child ->
                    Log.v("Prueba1", "2")
                    val producto: Recomendacion? =

                        Recomendacion(
                            child.child("nombre").getValue<String>(),
                            child.child("descripcion").getValue<String>(),
                            child.child("imagen").getValue<String>(),
                            child.child("nombresito").getValue<String>(),
                            child.key

                        )
                    Log.v("Prueba1", "3")
                    producto?.let { listRecomendacion.add(it) }
                    Log.v("Prueba1", "4")
                }
                recyclerView.adapter = Producto1ViewAdapterRecomendacion(listRecomendacion)
                Log.v("Prueba1", "5")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("TAG", "messages:onCancelled: ${error.message}")
                Log.v("Prueba1", "6")
            }
        }
        Log.v("Prueba1", "7")
        myRefRecomendaciones.addValueEventListener(messagesListener)
        Log.v("Prueba1", "8")
        deleteSwipeRecomendacion(recyclerView)
        Log.v("Prueba1", "9")
    }

    class Producto1ViewAdapterRecomendacion(private val values: List<Recomendacion>) :
        RecyclerView.Adapter<Producto1ViewAdapterRecomendacion.ViewHolder>() {
        private var lastPosition = -1
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.producto_content1, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val producto2 = values[position]
            holder.uno.text = producto2.nombre
            holder.mPoster?.let {
                Glide.with(holder.itemView.context)
                    .load(producto2.descripcion)
                    .into(it)
            }
            setAnimation(holder.itemView, position);

            holder.itemView.setOnClickListener { v ->

                val customDialog = Dialog(v.context)
                customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                customDialog.setContentView(R.layout.activity_prodrec_detalle1)
                customDialog.window?.setLayout(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                var url = ""
                val database = Firebase.database
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                val myRef6 = database.getReference("Recomendaciones").child(
                    producto2.key.toString()
                )
                myRef6.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {

                        val producto: Recomendacion? = dataSnapshot.getValue(Recomendacion::class.java)
                        if (producto!= null) {
                            customDialog.nameTextView8.text = producto.nombre.toString()
                            customDialog.descriptionTextView8.text = producto.descripcion.toString()
                            Glide.with(v.context)
                                .load(producto.imagen.toString())
                                .into(customDialog.posterImgeView8)

                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.w("TAG", "Failed to read value.", error.toException())
                    }
                })

                customDialog.show()

            }
            holder.itemView.setOnLongClickListener { v ->
                val Archivo4 = "Catalogo"
                val defaultPrefs4 = Splash.PreferenceHelper4.defaultPreference4(v.context)
                defaultPrefs4.dato1 = 0
                defaultPrefs4.dato2 = 0
                defaultPrefs4.dato3 = 0
                val prefs4 = Splash.PreferenceHelper4.customPreference4(v.context, Archivo4)
                prefs4.dato3=4
                val intent = Intent(v.context, ProdRecAgregar::class.java).apply {
                    putExtra("key1", producto2.key)
                }
                v.context.startActivity(intent)
                Bungee.zoom(v.context)
                true
            }
        }

        override fun getItemCount() = values.size
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val uno: TextView = view.name1TextViewRecomendacion
            val mPoster: ImageView? = view.logito
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

    private fun deleteSwipeRecomendacion(recyclerView: RecyclerView) {
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
                listRecomendacion.get(viewHolder.adapterPosition).key?.let {
                    val database = Firebase.database

                    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                    val myRef21 = database.getReference("Recomendaciones").child(
                        myRefRecomendaciones.child(it).key.toString()
                    )
                    myRef21.addValueEventListener(object : ValueEventListener {
                        @SuppressLint("RestrictedApi")
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            val producto: Recomendacion? =
                                dataSnapshot.getValue(Recomendacion::class.java)
                            if (producto != null) {
                                nonm.text = producto.nombresito


                                Log.v("Prueba", " datos ${nonm.text}")
                                val ref =
                                    FirebaseStorage.getInstance().reference.child("/Recomendaciones/${nonm.text}")

                                ref.delete().addOnSuccessListener {

                                    val Archivo2 = "Chat"
                                    val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                                    defaultPrefs2.codi = 0

                                    val prefs2 = Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                                    val accion = "Se Eliminó Recomendación."
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
                                myRefRecomendaciones.child(it).setValue(null)
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            Log.w("TAG", "Failed to read value.", error.toException())
                        }
                    })

                }
                listRecomendacion.removeAt(viewHolder.adapterPosition)
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
        startActivity(Intent(this@ProdRec, MenuPrinci::class.java))
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