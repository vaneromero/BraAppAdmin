package com.bp.braappadmin.galeria

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.ContentValues
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
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
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bp.braappadmin.R
import com.bp.braappadmin.catalogo.similares.ProducAgregar
import com.bp.braappadmin.catalogo.similares.Producto
import com.bp.braappadmin.help.Ayuda
import com.bp.braappadmin.inicio.Splash
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.activi
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.tono
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum1
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.codi
import com.bp.braappadmin.menuP.MenuPrinci
import com.bumptech.glide.Glide
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.OnProgressListener
import kotlinx.android.synthetic.main.activity_galeria1.*
import kotlinx.android.synthetic.main.producto_content1.view.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import com.google.firebase.storage.UploadTask
import kotlinx.android.synthetic.main.activity_galeria1.nameTextView
import kotlinx.android.synthetic.main.activity_galeria1.selectphoto_button_register9
import kotlinx.android.synthetic.main.activity_galeria1.selectphoto_imageview_register9
import kotlinx.android.synthetic.main.activity_galerias.*
import kotlinx.android.synthetic.main.activity_prodc_detalle.*
import kotlinx.android.synthetic.main.activity_prodc_detalle.sitioTextView
import kotlinx.android.synthetic.main.activity_produc_agregar.*
import kotlinx.android.synthetic.main.detalleescu.*
import kotlinx.android.synthetic.main.detalleescu1.*


class Galeria1 : AppCompatActivity() {
    private val database = Firebase.database
    var selectedPhotoUri: Uri? = null
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null

    private lateinit var messagesListener: ValueEventListener
    private val db = FirebaseFirestore.getInstance()
    private val listSlide: MutableList<slides3> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeria1)
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
        Ayuda001P14.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            mediaPlayer!!.pause()
            startActivity(Intent(this, Ayuda::class.java))
            Bungee.zoom(this)
        }
        name.setOnFocusChangeListener { view, b ->
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
        link.setOnFocusChangeListener { view, b ->
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

        val texto2: LinearLayout = findViewById(R.id.conf4)
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto2.startAnimation(anim1)
        Titud1.setText("Escuelas")
        swipeRefreshSlide2.setOnRefreshListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            setupRecyclerView4(SlideRecycler2View)
            swipeRefreshSlide2.isRefreshing = false
        }
        listSlide.clear()
        setupRecyclerView4(SlideRecycler2View)
        saveButtons.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            if (selectedPhotoUri == null || name.text.toString().isEmpty() || link.text.toString()
                    .isEmpty()
            ) {
                toast("No se puede guardar Registro.")
            } else if (selectedPhotoUri == null && name.text.toString()
                    .isEmpty() && link.text.toString().isEmpty()
            ) {
                toast("No se puede guardar Registro.")
            } else {


                if (selectedPhotoUri == null)
                    toast("Por favor ingrese una imagen")
                else {
                    uploadImageToFirebaseStorage()

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
        val ref = FirebaseStorage.getInstance().reference.child("/GaleriaE/$filename")
        ref.putFile(selectedPhotoUri!!)
            .addOnProgressListener {

                val progress = (100.0 * it.bytesTransferred) / it.totalByteCount
                Log.v("Tuts+", "Upload is $progress% done total ${it.totalByteCount}")
                if (progress == 100.0) {
                    ref.downloadUrl.addOnSuccessListener {
                        saveUserToFirebaseDatabase4(it.toString(), filename)
                        customDialog.dismiss()
                    }
                }
                customDialog.show()
            }

            .addOnFailureListener {
                toast("Error al cargar imagen")
            }

    }

    private fun setupRecyclerView4(recyclerView: RecyclerView) {
        val myRef = database.getReference("GaleriaE")
        messagesListener = object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listSlide.clear()
                dataSnapshot.children.forEach { child ->

                    val producto: slides3? =

                        slides3(
                            child.child("nombre").getValue() as String?,
                            child.child("foto").getValue() as String?,

                            child.child("titulo").getValue() as String?,
                            child.child("descr").getValue() as String?, child.key
                        )
                    producto?.let { listSlide.add(it) }
                }
                recyclerView.adapter = Slide1ViewAdapter(listSlide)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("TAG", "messages:onCancelled: ${error.message}")
            }
        }
        myRef.addValueEventListener(messagesListener)
        deleteSwipe4(recyclerView)
    }

    class Slide1ViewAdapter(private val values: List<slides3>) :
        RecyclerView.Adapter<Slide1ViewAdapter.ViewHolder>() {
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
                    .load(producto1.foto)
                    .into(it)
            }
            holder.itemView.setOnClickListener {
                val customDialog = Dialog(it.context)
                customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                customDialog.setContentView(R.layout.detalleescu)
                customDialog.window?.setLayout(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                var url = ""
                val database = Firebase.database
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                val myRef = database.getReference("GaleriaE").child(
                    producto1.key.toString()
                )
                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {

                        val producto1: slides3? = dataSnapshot.getValue(slides3::class.java)
                        if (producto1!= null) {

                            customDialog.nameTextViewd.text=producto1.titulo.toString()
                            customDialog.sitioTextViewd.text=producto1.descr.toString()
                            Glide.with(it.context)
                                .load(producto1.foto.toString())
                                .into( customDialog.posterImgeViewa)

                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.w("TAG", "Failed to read value.", error.toException())
                    }
                })

                customDialog.show()
            }
            holder.itemView.setOnLongClickListener {
                val customDialog4 = Dialog(it.context)
                customDialog4.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                customDialog4.setContentView(R.layout.detalleescu1)
                customDialog4.window?.setLayout(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )


                val database = Firebase.database

                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                val myRef1 = database.getReference("GaleriaE").child(
                    producto1.key.toString()
                )
                myRef1.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {

                        val producto1: slides3? = dataSnapshot.getValue(slides3::class.java)
                        if (producto1 != null) {
                            customDialog4.nonm223ds.text = producto1.key.toString()
                            customDialog4.namsde.setText(producto1.titulo.toString())
                            customDialog4.linkfg.setText(producto1.descr.toString())
                            Glide.with(it.context)
                                .load(producto1.foto.toString())
                                .into(customDialog4.posterImgeVirtew)

                            customDialog4.saveButtonfgs.setOnClickListener {
                                myRef1.child("titulo").setValue(customDialog4.namsde.text.toString())
                                myRef1.child("descr").setValue(customDialog4.linkfg.text.toString())
                                val Archivo2 = "Chat"
                                val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(it.context)

                                defaultPrefs2.codi = 0

                                val prefs2 = Splash.PreferenceHelper2.customPreference2(it.context, Archivo2)

                                val accion = "Se Editó Información de Escuelas."
                                val codidd = prefs2.codi
                                val sdf1 = SimpleDateFormat("dd/M/yyyy hh:mm:ss a")
                                val fecha1 = sdf1.format(Date())
                                var lugar = "Movil"
                           val db = FirebaseFirestore.getInstance()
                                val Log = hashMapOf(
                                    "accion" to accion,
                                    "codidd" to codidd,
                                    "fecha1" to fecha1,
                                    "lugar" to lugar,
                                )
                                db.collection("Logs")
                                    .add(Log)
                                    .addOnSuccessListener {
                                        customDialog4.dismiss()
                                    }
                                    .addOnFailureListener { e ->

                                    }
                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.w("TAG", "Failed to read value.", error.toException())
                    }

                })
                customDialog4.show()
                true

            }

                setAnimation(holder.itemView, position);

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
        override fun getItemCount() = values.size
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val uno: TextView = view.name1TextViewRecomendacion
            val mPoster: ImageView? = view.logito
        }
    }

    private fun deleteSwipe4(recyclerView: RecyclerView) {
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
                    val myRef = database.getReference("GaleriaE")
                    val database = Firebase.database

                    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                    val myRef2 = database.getReference("GaleriaE").child(
                        myRef.child(it).key.toString()
                    )
                    myRef2.addValueEventListener(object : ValueEventListener {
                        @SuppressLint("RestrictedApi")
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            val producto: slides3? = dataSnapshot.getValue(slides3::class.java)
                            if (producto != null) {
                                nonm223.text = producto.nombre


                                Log.v("Prueba", " datos ${nonm223.text}")
                                val ref =
                                    FirebaseStorage.getInstance().reference.child("/GaleriaE/${nonm223.text}")

                                ref.delete().addOnSuccessListener {
                                    val Archivo2 = "Chat"
                                    val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(
                                        applicationContext
                                    )
                                    defaultPrefs2.codi = 0

                                    val prefs2 = Splash.PreferenceHelper2.customPreference2(
                                        applicationContext,
                                        Archivo2
                                    )

                                    val accion = "Se Eliminó Información de Escuelas."
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

    @SuppressLint("Range")
    private fun saveUserToFirebaseDatabase4(url: String, nombre: String) {
        val myRef = database.getReference("GaleriaE")
        val producto = slides3(
            nombre,
            url, name.text.toString(), link.text.toString()
        )
        myRef.child(myRef.push().key.toString()).setValue(producto)
        toast("Foto Subida")
        val Archivo2 = "Chat"
        val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

        defaultPrefs2.codi = 0

        val prefs2 = Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

        val accion = "Se Guardó Información de Escuelas."
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
                name.setText("")
                link.setText("")
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