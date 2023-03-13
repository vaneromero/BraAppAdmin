package com.bp.braappadmin.catalogo.similares

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.Toast
import com.bp.braappadmin.R
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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_avisos_editar.*
import kotlinx.android.synthetic.main.activity_galeria1.*
import kotlinx.android.synthetic.main.activity_produc.*
import kotlinx.android.synthetic.main.activity_produc_agregar.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.text.SimpleDateFormat
import java.util.*

class ProducAgregar : AppCompatActivity() {
    private val database = Firebase.database
    var selectedPhotoUri: Uri? = null
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produc_agregar)

        val texto2: LinearLayout = findViewById(R.id.contttf)
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
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
        nameEditText.setOnFocusChangeListener { view, b ->
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
        sitioEditText.setOnFocusChangeListener { view, b ->
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
        precioEditText.setOnFocusChangeListener { view, b ->
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
        descargaEditText.setOnFocusChangeListener { view, b ->
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
        descriptionEditText.setOnFocusChangeListener { view, b ->
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
        Ayuda001na.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            mediaPlayer!!.pause()
            startActivity(Intent(this, Ayuda::class.java))
            Bungee.zoom(this)
        }
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
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
                bu2t32.text = currentUser!!.userName
                when (currentUser!!.sexo) {
                    "Masculino" -> {
                        imgProfilesd4s.setBackgroundResource(R.drawable.businessman)
                    }
                    "Femenino" -> {
                        imgProfilesd4s.setBackgroundResource(R.drawable.businesswoman)
                    }
                    "no" -> {
                        imgProfilesd4s.setBackgroundResource(R.drawable.interrogation)
                    }
                }
            }
        })
        val bundle: Bundle? = intent.extras
        bundle?.let { bundleLibriDeNull ->
            val area = bundleLibriDeNull.getString("llave", "")
            val area1 = bundleLibriDeNull.getString("key", "")
            if (area == "uno") {
                saveButton.visibility = View.VISIBLE
                saveButton4.visibility = View.GONE
                ddd.visibility = View.VISIBLE
                saveButton.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    if (nameEditText.text.isEmpty() || precioEditText.text.isEmpty() || sitioEditText.text.isEmpty() || descargaEditText.text.isEmpty() || descriptionEditText.text.isEmpty()) {
                        toast("No se puede guardar el producto")
                    } else if (nameEditText.text.isEmpty() && precioEditText.text.isEmpty() && sitioEditText.text.isEmpty() && descargaEditText.text.isEmpty() && descriptionEditText.text.isEmpty()) {
                        toast("No se puede guardar el producto")
                    } else {
                        uploadImageToFirebaseStorage()
                        toast("Se guardo el producto")
                    }
                }
                selectphoto_button_register.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    val intent = Intent(Intent.ACTION_PICK)
                    intent.type = "image/*"
                    startActivityForResult(intent, 0)
                }
            }
            else if (area == "dos") {
                saveButton4.visibility = View.VISIBLE
                saveButton.visibility = View.GONE
                ddd.visibility = View.GONE
                val database = Firebase.database
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS") val myRef =
                    database.getReference("Productos Similares").child(
                        area1.toString()
                    )
                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {

                        val producto: Producto? = dataSnapshot.getValue(Producto::class.java)
                        if (producto != null) {
                            nameEditText.text = Editable.Factory.getInstance().newEditable(producto.nombre)
                            precioEditText.text =
                                Editable.Factory.getInstance().newEditable(producto.precio)
                            sitioEditText.text = Editable.Factory.getInstance().newEditable(producto.sitio)
                            descriptionEditText.text =
                                Editable.Factory.getInstance().newEditable(producto.descripción)
                            descargaEditText.text =
                                Editable.Factory.getInstance().newEditable(producto.link)
                        }

                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.w("TAG", "Failed to read value.", error.toException())
                    }
                })
                saveButton4.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    myRef.child("nombre").setValue(nameEditText.text.toString())
                    myRef.child("precio").setValue(precioEditText.text.toString())
                    myRef.child("sitio").setValue(sitioEditText.text.toString())
                    myRef.child("descripción").setValue(descriptionEditText.text.toString())
                    myRef.child("link").setValue(descargaEditText.text.toString())

                    val Archivo2 = "Chat"
                    val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                    defaultPrefs2.codi = 0

                    val prefs2 = Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                    val accion = "Se Actualizó Producto Similar."
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
                            toast("Se editó el producto")
                            val intent = Intent(this@ProducAgregar, Produc::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(intent)
                            Bungee.zoom(this)
                            finish()
                        }
                        .addOnFailureListener { e ->

                        }

                }
            }
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null) {
            selectedPhotoUri = data.data
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedPhotoUri)
            selectphoto_imageview_register.setImageBitmap(bitmap)
            selectphoto_button_register.alpha = 0f
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
            val ref = FirebaseStorage.getInstance().reference.child("/Productos/$filename")
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
    private fun saveUserToFirebaseDatabase(url: String, nombresito: String) {
        val Nombre = nameEditText.text
        val Precio = precioEditText.text
        val Sitio = sitioEditText.text
        val Descripción = descriptionEditText.text
        val Link = descargaEditText.text
        val myRef = database.getReference("Productos Similares")
        val producto = Producto(
            Nombre.toString(),
            Precio.toString(),
            Sitio.toString(),
            Descripción.toString(),
            url,
            Link.toString(), nombresito
        )
        myRef.child(myRef.push().key.toString()).setValue(producto)
        val Archivo2 = "Chat"
        val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

        defaultPrefs2.codi = 0

        val prefs2 = Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

        val accion = "Se Guardó Producto Similar."
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
                val intent = Intent(this@ProducAgregar, Produc::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                Bungee.zoom(this)
                finish()
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
        val Archivo4 = "Catalogo"
        val defaultPrefs4 = Splash.PreferenceHelper4.defaultPreference4(this)
        defaultPrefs4.dato1 = 0
        defaultPrefs4.dato2 = 0
        defaultPrefs4.dato3 = 0

        mediaPlayer!!.stop()

        val prefs4 = Splash.PreferenceHelper4.customPreference4(this, Archivo4)
        prefs4.dato3=5
        startActivity(Intent(this@ProducAgregar, Produc::class.java))
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