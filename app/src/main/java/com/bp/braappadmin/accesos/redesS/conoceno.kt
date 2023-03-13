package com.bp.braappadmin.accesos.redesS

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
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.bp.braappadmin.R
import com.bp.braappadmin.catalogo.similares.Produc
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
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_conoceno.*
import kotlinx.android.synthetic.main.activity_produc_agregar.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.text.SimpleDateFormat
import java.util.*

class conoceno : AppCompatActivity() {
    var selectedPhotoUri: Uri? = null
    private val database = Firebase.database
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conoceno)

        val texto6: LinearLayout = findViewById(R.id.contenda)
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
        Ayuda001P1fsa.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            mediaPlayer!!.pause()
            startActivity(Intent(this, Ayuda::class.java))
            Bungee.zoom(this)
        }
        val bundle: Bundle? = intent.extras
        bundle?.let { bundleLibriDeNull ->
            val area1 = bundleLibriDeNull.getString("key", "")
            if(area1=="Arely Vanessa"){
                Titud.setText("Foto de Arely Vanessa.")
                saveBufgtton9.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    uploadImageToFirebaseStorage1()
                    toast("Se guardo la Foto de Arely Vanessa.")
                }
            }
            else  if(area1=="Alejandro"){
                Titud.setText("Foto de Alejandro.")
                saveBufgtton9.setOnClickListener {
                    soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
                    uploadImageToFirebaseStorage2()
                    toast("Se guardo la Foto de Alejandro.")
                }

            }
        }
        selectphoto_gfbutton_register9.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 0)
        }

    }
    private fun uploadImageToFirebaseStorage1() {
        if (selectedPhotoUri == null)
            toast("Por favor ingrese una imagen.")
        else {
            val customDialog = Dialog(this)
            customDialog.window?.setBackgroundDrawableResource(R.color.fondito)
            customDialog.setContentView(R.layout.cargando)
            customDialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            customDialog.setCancelable(true)
            customDialog.setCanceledOnTouchOutside(true)
            val filename = UUID.randomUUID().toString()
            val ref = FirebaseStorage.getInstance().reference.child("/Fotos/Arely Vanessa/$filename")
            ref.putFile(selectedPhotoUri!!)
                .addOnProgressListener {

                    val progress = (100.0 * it.bytesTransferred) / it.totalByteCount
                     if (progress == 100.0) {
                        ref.downloadUrl.addOnSuccessListener {
                            database.getReference("/Redes/Arely Vanessa/nombre").setValue(filename)
                            database.getReference("/Redes/Arely Vanessa/imagen").setValue(it.toString())

                            val Archivo2 = "Chat"
                            val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                            defaultPrefs2.codi = 0

                            val prefs2 = Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                            val accion = "Se Guardó Fotografía de Arely Vanessa."
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
                                    customDialog.dismiss()
                                    val intent = Intent(this@conoceno, Redes::class.java)
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                    startActivity(intent)
                                    Bungee.zoom(this@conoceno)
                                    finish()
                                }
                                .addOnFailureListener { e ->

                                }

                        }
                        customDialog.show()
                    }

                }

                .addOnFailureListener {
                    toast("Error al cargar imagen")
                }
        }
    }
    private fun uploadImageToFirebaseStorage2() {
        if (selectedPhotoUri == null)
            toast("Por favor ingrese una imagen.")
        else {
            val customDialog = Dialog(this)
            customDialog.window?.setBackgroundDrawableResource(R.color.fondito)
            customDialog.setContentView(R.layout.cargando)
            customDialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            customDialog.setCancelable(true)
            customDialog.setCanceledOnTouchOutside(true)
            val filename = UUID.randomUUID().toString()
            val ref = FirebaseStorage.getInstance().reference.child("/Fotos/Alejandro/$filename")
            ref.putFile(selectedPhotoUri!!)
                .addOnProgressListener {

                    val progress = (100.0 * it.bytesTransferred) / it.totalByteCount
                    Log.v("Tuts+", "Upload is $progress% done total ${it.totalByteCount}")
                    if (progress == 100.0) {
                        ref.downloadUrl.addOnSuccessListener {
                            val myRef = database.getReference("/Redes/Alejandro/nombre").setValue(filename)
                            val myRef1 = database.getReference("/Redes/Alejandro/imagen").setValue(it.toString())


                            val Archivo2 = "Chat"
                            val defaultPrefs2 = Splash.PreferenceHelper2.defaultPreference2(applicationContext)

                            defaultPrefs2.codi = 0

                            val prefs2 = Splash.PreferenceHelper2.customPreference2(applicationContext, Archivo2)

                            val accion = "Se Guardó Fotografía de Alejandro."
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
                                    customDialog.dismiss()
                                    val intent = Intent(this@conoceno, Redes::class.java)
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                    startActivity(intent)
                                    Bungee.zoom(this@conoceno)
                                    finish()

                                }
                                .addOnFailureListener { e ->

                                }

                        }
                        customDialog.show()
                    }

                }

                .addOnFailureListener {
                    toast("Error al cargar imagen")
                }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null) {
            selectedPhotoUri = data.data
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedPhotoUri)
            selectphoto_imageview_regifgster9.setImageBitmap(bitmap)
            selectphoto_gfbutton_register9.alpha = 0f
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
        startActivity(Intent(this@conoceno, Redes::class.java))
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