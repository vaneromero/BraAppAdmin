package com.bp.braappadmin.galeria

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.ContentValues
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bp.braappadmin.R
import com.bp.braappadmin.comunicacion.avisos.Avisos
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
import com.bumptech.glide.Glide
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_galerias.*
import kotlinx.android.synthetic.main.producto_content1.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class Galerias : AppCompatActivity() {
    private val database = Firebase.database
    private val db = FirebaseFirestore.getInstance()
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private lateinit var messagesListener: ValueEventListener
    private val listSlide: MutableList<slides> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galerias)
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
        Ayuda001P1g.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            mediaPlayer!!.pause()
            startActivity(Intent(this, Ayuda::class.java))
            Bungee.zoom(this)
        }
        val texto2: LinearLayout = findViewById(R.id.contenda)
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto2.startAnimation(anim1)
        val bundle: Bundle? = intent.extras
        bundle?.let { bundleLibriDeNull ->
            val area = bundleLibriDeNull.getString("llave", "")
            when (area) {
                "Slider1" -> {
                    Titud.setText("Tutor")
                    swipeRefreshSlide1.setOnRefreshListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        setupRecyclerView(SlideRecyclerView)
                        swipeRefreshSlide1.isRefreshing = false
                    }
                    listSlide.clear()
                    setupRecyclerView(SlideRecyclerView)
                    saveButton9.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        uploadImageToFirebaseStorage()
                    }

                }
                "Slider2" -> {
                    Titud.setText("Alumno")
                    swipeRefreshSlide1.setOnRefreshListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        setupRecyclerView2(SlideRecyclerView)
                        swipeRefreshSlide1.isRefreshing = false
                    }
                    listSlide.clear()
                    setupRecyclerView2(SlideRecyclerView)
                    saveButton9.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        uploadImageToFirebaseStorage2()
                    }
                }
                "Slider3" -> {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    Titud.setText("Administrador")
                    swipeRefreshSlide1.setOnRefreshListener {
                        setupRecyclerView3(SlideRecyclerView)
                        swipeRefreshSlide1.isRefreshing = false
                    }
                    listSlide.clear()
                    setupRecyclerView3(SlideRecyclerView)
                    saveButton9.setOnClickListener {
                        soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                        uploadImageToFirebaseStorage3()
                    }
                }
            }

        }
        selectphoto_button_register9.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            Log.d(ContentValues.TAG, "Try to show photo selector")
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 0)
        }

    }
    private fun setupRecyclerView(recyclerView: RecyclerView) {
        val myRef = database.getReference("Slider1")
        messagesListener = object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listSlide.clear()
                dataSnapshot.children.forEach { child ->

                    val producto:slides? =

                        slides(
                            child.child("nombre").getValue() as String?,
                            child.child("imagen").getValue() as String?,
                            child.key

                        )
                    producto?.let {  listSlide.add(it) }
                }
                recyclerView.adapter = Slide1ViewAdapter(listSlide)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("TAG", "messages:onCancelled: ${error.message}")
            }
        }
        myRef.addValueEventListener(messagesListener)
        deleteSwipe(recyclerView)
    }
    class Slide1ViewAdapter(private val values: List<slides>) :
        RecyclerView.Adapter<Slide1ViewAdapter.ViewHolder>() {
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
                    .load(producto1.imagen)
                    .into(it)
            }

        }

        override fun getItemCount() = values.size
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val uno: TextView = view.name1TextViewRecomendacion
            val mPoster: ImageView? = view.logito
        }


    }
    private fun deleteSwipe(recyclerView: RecyclerView) {
        val myRef = database.getReference("Slider1")
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
                listSlide[viewHolder.adapterPosition].key?.let {
                    val database = Firebase.database
                    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                    val myRef2 = database.getReference("Slider1").child(
                        myRef.child(it).key.toString()
                    )
                    myRef2.addValueEventListener(object : ValueEventListener {
                        @SuppressLint("RestrictedApi")
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            val producto:slides? = dataSnapshot.getValue(slides::class.java)
                            if (producto!= null) {
                                nonm.text = producto.nombre
                                Log.v("Prueba"," datos ${nonm.text}")
                                val ref = FirebaseStorage.getInstance().reference.child("/Slider1/${nonm.text}")

                                ref.delete().addOnSuccessListener {

                                    val Archivo2 = "Chat"
                                    val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)
                                    defaultPrefs2.entrada = 0
                                    defaultPrefs2.clave = 0
                                    defaultPrefs2.codi = 0

                                    val prefs2 = Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                                    val accion="Se Elimino Fotografía de Tutor."
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
                            Log.w("TAG", "Failed to read value.", error.toException())
                        }
                    })

                }
                listSlide.removeAt(viewHolder.adapterPosition)
                recyclerView.adapter?.notifyItemRemoved(viewHolder.adapterPosition)
                recyclerView.adapter?.notifyDataSetChanged()

            }
        }
        val itemTouchHelper = ItemTouchHelper(touchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
    var selectedPhotoUri: Uri? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null) {

            selectedPhotoUri = data.data

            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedPhotoUri)

            selectphoto_imageview_register9.setImageBitmap(bitmap)

            selectphoto_button_register9.alpha = 0f
        }
    }
    private fun uploadImageToFirebaseStorage() {
        if (selectedPhotoUri == null)
            toast("Por favor ingrese una imagen de producto")
        else {
            val customDialog = Dialog(this)
            val filename = UUID.randomUUID().toString()
            customDialog.window?.setBackgroundDrawableResource(R.color.fondito)
            customDialog.setContentView(R.layout.cargando)
            customDialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            customDialog.setCancelable(true)
            customDialog.setCanceledOnTouchOutside(true)
            val ref = FirebaseStorage.getInstance().reference.child("/Slider1/$filename")
            ref.putFile(selectedPhotoUri!!)
                      .addOnProgressListener {

                    val progress = (100.0 * it.bytesTransferred) / it.totalByteCount
                    Log.v("Tuts+", "Upload is $progress% done total ${it.totalByteCount}")
                    if (progress == 100.0) {
                        ref.downloadUrl.addOnSuccessListener {
                            saveUserToFirebaseDatabase(it.toString(), filename)
                            customDialog.dismiss()
                        }
                    }
                    customDialog.show()
                }
                .addOnFailureListener {
                    toast("Error al cargar imagen")
                }
        }
    }
    @SuppressLint("Range")
    private fun saveUserToFirebaseDatabase(url: String, nombre: String) {

        val myRef = database.getReference("Slider1")
        val producto =slides(
            nombre,
            url
        )
        myRef.child(myRef.push().key.toString()).setValue(producto)
        toast("Foto Subida")
        val Archivo2 = "Chat"
        val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(this)
        defaultPrefs2.entrada = 0
        defaultPrefs2.clave = 0
        defaultPrefs2.codi = 0

        val prefs2 = Splash.PreferenceHelper2.customPreference2(this, Archivo2)

        val accion="Se Guardo Fotografía de Tutor."
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
                selectedPhotoUri=null
                selectphoto_button_register9.alpha = 5f
            }
            .addOnFailureListener { e ->

            }
    }
    private fun setupRecyclerView2(recyclerView: RecyclerView) {
        val myRef = database.getReference("Slider2")
        messagesListener = object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listSlide.clear()
                dataSnapshot.children.forEach { child ->

                    val producto:slides? =

                        slides(
                            child.child("nombre").getValue<String>(),
                            child.child("imagen").getValue<String>(),
                            child.key

                        )
                    producto?.let {  listSlide.add(it) }
                }
                recyclerView.adapter = Slide1ViewAdapter(listSlide)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("TAG", "messages:onCancelled: ${error.message}")
            }
        }
        myRef.addValueEventListener(messagesListener)
        deleteSwipe2(recyclerView)
    }
    private fun deleteSwipe2(recyclerView: RecyclerView) {
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
                listSlide.get(viewHolder.adapterPosition).key?.let {
                    val myRef = database.getReference("Slider2")
                    val database = Firebase.database
                    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                    val myRef2 = database.getReference("Slider2").child(
                        myRef.child(it).key.toString()
                    )
                    myRef2.addValueEventListener(object : ValueEventListener {
                        @SuppressLint("RestrictedApi")
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            val producto:slides? = dataSnapshot.getValue(slides::class.java)
                            if (producto!= null) {
                                nonm.text=producto.nombre


                                Log.v("Prueba"," datos ${nonm.text}")
                                val ref = FirebaseStorage.getInstance().reference.child("/Slider2/${nonm.text}")

                                ref.delete().addOnSuccessListener {
                                    val Archivo2 = "Chat"
                                    val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)
                                    defaultPrefs2.entrada = 0
                                    defaultPrefs2.clave = 0
                                    defaultPrefs2.codi = 0

                                    val prefs2 = Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                                    val accion="Se Elimino Fotografía de Alumno."
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
                            Log.w("TAG", "Failed to read value.", error.toException())
                        }
                    })

                }
                listSlide.removeAt(viewHolder.adapterPosition)
                recyclerView.adapter?.notifyItemRemoved(viewHolder.adapterPosition)
                recyclerView.adapter?.notifyDataSetChanged()

            }
        }
        val itemTouchHelper = ItemTouchHelper(touchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
    private fun uploadImageToFirebaseStorage2() {
        if (selectedPhotoUri == null)
            toast("Por favor ingrese una imagen de producto")
        else {
            val customDialog = Dialog(this)
            val filename = UUID.randomUUID().toString()
            customDialog.window?.setBackgroundDrawableResource(R.color.fondito)
            customDialog.setContentView(R.layout.cargando)
            customDialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            customDialog.setCancelable(true)
            customDialog.setCanceledOnTouchOutside(true)
            val ref = FirebaseStorage.getInstance().reference.child("/Slider2/$filename")
            ref.putFile(selectedPhotoUri!!)

                .addOnProgressListener {

                    val progress = (100.0 * it.bytesTransferred) / it.totalByteCount
                    Log.v("Tuts+", "Upload is $progress% done total ${it.totalByteCount}")
                    if (progress == 100.0) {
                        ref.downloadUrl.addOnSuccessListener {
                            saveUserToFirebaseDatabase2(it.toString(), filename)
                            customDialog.dismiss()
                        }
                    }
                    customDialog.show()
                }
                .addOnFailureListener {
                    toast("Error al cargar imagen")
                }
        }
    }
    @SuppressLint("Range")
    private fun saveUserToFirebaseDatabase2(url: String, nombre: String) {
        val myRef = database.getReference("Slider2")
        val producto =slides(
            nombre,
            url
        )
        myRef.child(myRef.push().key.toString()).setValue(producto)
        toast("Foto Subida")
        val Archivo2 = "Chat"
        val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(this)
        defaultPrefs2.entrada = 0
        defaultPrefs2.clave = 0
        defaultPrefs2.codi = 0

        val prefs2 = Splash.PreferenceHelper2.customPreference2(this, Archivo2)

        val accion="Se Guardo Fotografía de Alumno."
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
                selectedPhotoUri=null
                selectphoto_button_register9.alpha = 5f
            }
            .addOnFailureListener { e ->

            }
    }
    private fun setupRecyclerView3(recyclerView: RecyclerView) {
        val myRef = database.getReference("Slider3")
        messagesListener = object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listSlide.clear()
                dataSnapshot.children.forEach { child ->

                    val producto:slides? =

                        slides(
                            child.child("nombre").getValue<String>(),
                            child.child("imagen").getValue<String>(),
                            child.key

                        )
                    producto?.let {  listSlide.add(it) }
                }
                recyclerView.adapter = Slide1ViewAdapter(listSlide)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("TAG", "messages:onCancelled: ${error.message}")
            }
        }
        myRef.addValueEventListener(messagesListener)
        deleteSwipe3(recyclerView)
    }
    private fun deleteSwipe3(recyclerView: RecyclerView) {
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
                listSlide.get(viewHolder.adapterPosition).key?.let {
                    val myRef = database.getReference("Slider3")
                    val database = Firebase.database
                    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                    val myRef2 = database.getReference("Slider3").child(
                        myRef.child(it).key.toString()
                    )
                    myRef2.addValueEventListener(object : ValueEventListener {
                        @SuppressLint("RestrictedApi")
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            val producto:slides? = dataSnapshot.getValue(slides::class.java)
                            if (producto!= null) {
                                nonm.text=producto.nombre


                                Log.v("Prueba"," datos ${nonm.text}")
                                val ref = FirebaseStorage.getInstance().reference.child("/Slider3/${nonm.text}")

                                ref.delete().addOnSuccessListener {
                                    val Archivo2 = "Chat"
                                    val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)
                                    defaultPrefs2.entrada = 0
                                    defaultPrefs2.clave = 0
                                    defaultPrefs2.codi = 0

                                    val prefs2 = Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                                    val accion="Se Elimino Fotografía de Administradores."
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
                            Log.w("TAG", "Failed to read value.", error.toException())
                        }
                    })

                }
                listSlide.removeAt(viewHolder.adapterPosition)
                recyclerView.adapter?.notifyItemRemoved(viewHolder.adapterPosition)
                recyclerView.adapter?.notifyDataSetChanged()

            }
        }
        val itemTouchHelper = ItemTouchHelper(touchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
    private fun uploadImageToFirebaseStorage3() {
        if (selectedPhotoUri == null)
            toast("Por favor ingrese una imagen de producto")
        else {
            val customDialog = Dialog(this)
            val filename = UUID.randomUUID().toString()
            customDialog.window?.setBackgroundDrawableResource(R.color.fondito)
            customDialog.setContentView(R.layout.cargando)
            customDialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            customDialog.setCancelable(true)
            customDialog.setCanceledOnTouchOutside(true)
            val ref = FirebaseStorage.getInstance().reference.child("/Slider3/$filename")
            ref.putFile(selectedPhotoUri!!)
                .addOnProgressListener {

                    val progress = (100.0 * it.bytesTransferred) / it.totalByteCount
                    Log.v("Tuts+", "Upload is $progress% done total ${it.totalByteCount}")
                    if (progress == 100.0) {
                        ref.downloadUrl.addOnSuccessListener {
                            saveUserToFirebaseDatabase3(it.toString(), filename)
                            customDialog.dismiss()
                        }
                    }
                    customDialog.show()
                }
                .addOnFailureListener {
                    toast("Error al cargar imagen")
                }
        }
    }
    @SuppressLint("Range")
    private fun saveUserToFirebaseDatabase3(url: String, nombre: String) {
        val myRef = database.getReference("Slider3")
        val producto =slides(
            nombre,
            url
        )
        myRef.child(myRef.push().key.toString()).setValue(producto)
        toast("Foto Subida")
        val Archivo2 = "Chat"
        val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(this)
        defaultPrefs2.entrada = 0
        defaultPrefs2.clave = 0
        defaultPrefs2.codi = 0

        val prefs2 = Splash.PreferenceHelper2.customPreference2(this, Archivo2)

        val accion="Se Guardo Fotografía de Administrador."
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
selectedPhotoUri=null
                selectphoto_button_register9.alpha = 5f
            }
            .addOnFailureListener { e ->

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
