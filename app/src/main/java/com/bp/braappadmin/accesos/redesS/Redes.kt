package com.bp.braappadmin.accesos.redesS

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
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bp.braappadmin.ClickListener
import com.bp.braappadmin.R
import com.bp.braappadmin.catalogo.similares.ProducAgregar
import com.bp.braappadmin.comunicacion.chat.model.User
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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_confirmacion.*
import kotlinx.android.synthetic.main.activity_prodc_detalle.*
import kotlinx.android.synthetic.main.activity_redes.*
import kotlinx.android.synthetic.main.detalleuse.*
import kotlinx.android.synthetic.main.redesd.*
import kotlinx.android.synthetic.main.toast.*
import kotlinx.android.synthetic.main.toast.view.*
import spencerstudios.com.bungeelib.Bungee
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener


class Redes : AppCompatActivity() {
    var adaptador: adaptadorC? = null
    var listaJ: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    val database = Firebase.database
    val database1 = Firebase.database
    private val db = FirebaseFirestore.getInstance()
    var mediaPlayer: MediaPlayer? = null
    var soundPool: SoundPool? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redes)

        val texto6: ConstraintLayout = findViewById(R.id.d35ffvdfvrsa)
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
        getWindow().setSoftInputMode(android.view.WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        val firebase: FirebaseUser = FirebaseAuth.getInstance().currentUser!!
        var userid = firebase.uid
        FirebaseMessaging.getInstance().subscribeToTopic("/topics/$userid")
        Ayuda001P1ad.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            mediaPlayer!!.pause()
            startActivity(Intent(this, Ayuda::class.java))
            Bungee.zoom(this)
        }
        val databaseReference: DatabaseReference =
            FirebaseDatabase.getInstance().getReference("Administradores/$userid")
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                val currentUser = snapshot.getValue(User::class.java)
                bud.text = currentUser!!.userName
                when (currentUser!!.sexo) {
                    "Masculino" -> {
                        fotitod.setBackgroundResource(R.drawable.businessman)
                    }
                    "Femenino" -> {
                        fotitod.setBackgroundResource(R.drawable.businesswoman)
                    }
                    "no" -> {
                        fotitod.setBackgroundResource(R.drawable.interrogation)

                    }
                }

            }

        })
        vaciarT2.setOnClickListener {
            soundPool!!.play(carga, prefs1.volum1, prefs1.volum1, 0, 0, 1f)
            alerta3()
        }
        val datos1 = ArrayList<linkI>()
        datos1.add(linkI(R.drawable.mujer, "Conócenos Arely"))
        datos1.add(linkI(R.drawable.mujer, "Facebook Arely"))
        datos1.add(linkI(R.drawable.mujer, "Instagram Arely"))
        datos1.add(linkI(R.drawable.mujer, "Telegram Arely"))
        datos1.add(linkI(R.drawable.mujer, "Twitter Arely"))
        datos1.add(linkI(R.drawable.mujer, "WhatsApp Arely"))
        datos1.add(linkI(R.drawable.hombre, "Conócenos Alejandro"))
        datos1.add(linkI(R.drawable.hombre, "Facebook Alejandro"))
        datos1.add(linkI(R.drawable.hombre, "Instagram Alejandro"))
        datos1.add(linkI(R.drawable.hombre, "Telegram Alejandro"))
        datos1.add(linkI(R.drawable.hombre, "Twitter Alejandro"))
        datos1.add(linkI(R.drawable.hombre, "WhatsApp Alejandro"))
        datos1.add(linkI(R.drawable.pagina2, "Facebook Braille Package"))
        datos1.add(linkI(R.drawable.pagina2, "Instagram Braille Package"))
        datos1.add(linkI(R.drawable.pagina2, "Página Braille Package"))
        datos1.add(linkI(R.drawable.pagina2, "Twitter Braille Package"))
        datos1.add(linkI(R.drawable.pagina2, "YouTube Braille Package"))
        datos1.add(linkI(R.drawable.pagina2, "Telegram Braille Package"))
        datos1.add(linkI(R.drawable.pagina2, "WhatsApp Braille Package"))
        datos1.add(linkI(R.drawable.pagina2, "TikTok Braille Package"))
        datos1.add(linkI(R.drawable.pagina2, "Spotify Braille Package"))
        datos1.add(linkI(R.drawable.descargando, "Aplicación Alumno"))
        datos1.add(linkI(R.drawable.descargando, "Aplicación Tutor"))
        datos1.add(linkI(R.drawable.descargando, "Aplicación Administradores"))
        datos1.add(linkI(R.drawable.estuche, "Material de Apoyo Enlace"))
        datos1.add(linkI(R.drawable.nota, "Historia Enlace"))
        datos1.add(linkI(R.drawable.dinos, "Link de Código QR"))
        datos1.add(linkI(R.drawable.figma, "Figma"))

        listaJ = findViewById(R.id.menuLink)
        listaJ?.setHasFixedSize(true)  //adaptador tamaño de la vista

        layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)

        listaJ?.layoutManager = layoutManager  // donde se dibuje el layout
        adaptador = adaptadorC(this, datos1, object : ClickListener {
            override fun onClick(vista: View, index: Int) {

                if(index==0){
                    val admin = "Arely Vanessa"
                    val red = "nombre"
                    val myRef1 = database.getReference("/Redes/$admin")
                    Log.v("referencia",""+myRef1)
                    with(myRef1) {
                        addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(dataSnapshot: DataSnapshot) {

                                val redes: adapterRed? =
                                    dataSnapshot.getValue(adapterRed::class.java)
                                Log.v("referencia",""+redes)
                                    if (red == "nombre") {
                                        Log.v("referencia",""+redes?.nombre)
                                        if (redes?.nombre == null) {
                                            val intent = Intent(this@Redes, conoceno::class.java).apply {

                                                putExtra("key", admin)
                                            }
                                            this@Redes.startActivity(intent)
                                            Bungee.zoom(this@Redes)
                                        }else {
                                            val customDialog89 = Dialog(this@Redes)
                                            customDialog89.setContentView(R.layout.detalleuse)
                                            customDialog89.setCanceledOnTouchOutside(true)
                                            customDialog89.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                                            customDialog89.window?.setLayout(
                                                ViewGroup.LayoutParams.MATCH_PARENT,
                                                ViewGroup.LayoutParams.MATCH_PARENT
                                            )
                                            Log.v("dbfhsdbk","${redes?.imagen.toString()}")
                                            Glide.with(applicationContext)
                                                .load(redes?.imagen.toString())
                                                .into(customDialog89.gggdx)
                                            customDialog89.jfsnv.setText("Foto de ${admin}")
                                            customDialog89.deleteButtonfgs.setOnClickListener{
                                                val myRef2 = database.getReference("Redes").child("Arely Vanessa")
                                                myRef2.addValueEventListener(object : ValueEventListener {
                                                    @SuppressLint("RestrictedApi")
                                                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                                                        val producto: adapterRed? = dataSnapshot.getValue(adapterRed::class.java)
                                                        Log.v("prueb12",""+producto?.nombre)
                                                        val ref =
                                                            FirebaseStorage.getInstance().reference.child("/Fotos/Arely Vanessa/${redes?.nombre.toString()}")

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

                                                            val accion = "Se Eliminó Foto de Conócenos de Arely Vanessa."
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
                                                                    database.getReference("/Redes/Arely Vanessa/nombre").setValue(null)
                                                                    database.getReference("/Redes/Arely Vanessa/imagen").setValue(null)
                                                                    customDialog89.dismiss()
                                                                }

                                                        }


                                                    }

                                                    override fun onCancelled(error: DatabaseError) {
                                                        Log.w("TAG", "Failed to read value.", error.toException())
                                                    }
                                                })

                                            }
                                            customDialog89.alsh.setOnClickListener {
                                                customDialog89.dismiss()
                                            }
                                            customDialog89.show()
                                        }
                                    }


                            }

                            override fun onCancelled(error: DatabaseError) {
                                TODO("Not yet implemented")
                            }
                        })

                    }
                }
                else if(index==6){
                    val admin = "Alejandro"
                    val red = "nombre"
                    val myRef2 = database.getReference("/Redes/$admin")
                    with(myRef2) {
                        addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(dataSnapshot: DataSnapshot) {

                                val redes: adapterRed? =
                                    dataSnapshot.getValue(adapterRed::class.java)
                                Log.v("referencia",""+redes)
                                if (red == "nombre") {
                                    Log.v("referencia",""+redes?.nombre)
                                    if (redes?.nombre == null) {
                                        val intent = Intent(this@Redes, conoceno::class.java).apply {

                                            putExtra("key", admin)
                                        }
                                        this@Redes.startActivity(intent)
                                        Bungee.zoom(this@Redes)
                                    }else {
                                        val customDialog89 = Dialog(this@Redes)
                                        customDialog89.setContentView(R.layout.detalleuse)
                                        customDialog89.setCanceledOnTouchOutside(true)
                                        customDialog89.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                                        customDialog89.window?.setLayout(
                                            ViewGroup.LayoutParams.MATCH_PARENT,
                                            ViewGroup.LayoutParams.MATCH_PARENT
                                        )
                                        Log.v("dbfhsdbk","${redes?.imagen.toString()}")
                                        Glide.with(applicationContext)
                                            .load(redes?.imagen.toString())
                                            .into(customDialog89.gggdx)
                                        customDialog89.jfsnv.setText("Foto de ${admin}")
                                        customDialog89.deleteButtonfgs.setOnClickListener{
                                            val myRef2 = database.getReference("Redes").child("Alejandro")
                                            myRef2.addValueEventListener(object : ValueEventListener {
                                                @SuppressLint("RestrictedApi")
                                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                                    val producto: adapterRed? = dataSnapshot.getValue(adapterRed::class.java)
                                                    Log.v("prueb12",""+producto?.nombre)
                                                    val ref =
                                                        FirebaseStorage.getInstance().reference.child("/Fotos/Alejandro/${redes?.nombre.toString()}")

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
                                                        val accion = "Se Eliminó Foto de Conócenos de Alejandro"
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
                                                                database.getReference("/Redes/Alejandro/nombre").setValue(null)
                                                                database.getReference("/Redes/Alejandro/imagen").setValue(null)
                                                                customDialog89.dismiss()
                                                            }

                                                    }


                                                }

                                                override fun onCancelled(error: DatabaseError) {
                                                    Log.w("TAG", "Failed to read value.", error.toException())
                                                }
                                            })

                                        }
                                        customDialog89.alsh.setOnClickListener {
                                            customDialog89.dismiss()
                                        }
                                        customDialog89.show()
                                    }
                                }


                            }

                            override fun onCancelled(error: DatabaseError) {
                                TODO("Not yet implemented")
                            }
                        })

                    }
                }
                else if (index == 21) {
                    val bundle = Bundle()
                    bundle.apply {
                        putString("llave", "Alumno")
                    }

                    val intent = Intent(applicationContext, RedAlumn::class.java).apply {
                        putExtras(bundle)
                    }
                    startActivity(intent)


                }
                else if (index == 22) {
                    val bundle = Bundle()
                    bundle.apply {
                        putString("llave", "Tutor")
                    }

                    val intent = Intent(applicationContext, RedAlumn::class.java).apply {
                        putExtras(bundle)
                    }
                    startActivity(intent)
                }
                else {
                    alerta4(index)
                }
            }
        })
        listaJ?.adapter = adaptador
    }


    private fun alerta3() {
        val db = FirebaseFirestore.getInstance()
        val database = Firebase.database.reference
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.activity_confirmacion)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        val yesBtn =
            customDialog.findViewById<Button>(R.id.yes_opt9) as TextView
        val noBtn = customDialog.findViewById<Button>(R.id.no_opt9) as TextView
        customDialog.texto.setText("¿Desea realmente eliminar todas las redes sociales?")

        yesBtn.setOnClickListener {
            val myRef2 = database1.getReference("Redes").child("Arely Vanessa")
            myRef2.addListenerForSingleValueEvent(object : ValueEventListener {
                @SuppressLint("RestrictedApi")
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val producto: adapterRed? = dataSnapshot.getValue(adapterRed::class.java)
                   Log.v("prueb12",""+producto?.nombre)
 FirebaseStorage.getInstance().reference.child("/Fotos/Arely Vanessa/${producto?.nombre.toString()}").delete()
                    database.child("Redes").child("Arely Vanessa").removeValue()
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
                val myRef3 = database1.getReference("Redes").child("Alejandro")
                myRef3.addListenerForSingleValueEvent(object : ValueEventListener {
                    @SuppressLint("RestrictedApi")
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val producto: adapterRed? = dataSnapshot.getValue(adapterRed::class.java)
                     Log.v("prueb12",""+producto?.nombre)
FirebaseStorage.getInstance().reference.child("/Fotos/Alejandro/${producto?.nombre.toString()}").delete()
                        database.child("Redes").child("Alejandro").removeValue()
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }
                })
               database.child("Redes").child("BraApp").removeValue()
            database.child("Redes").child("LinkAlum").removeValue()
            database.child("Redes").child("LinkTutor").removeValue()
            database.child("Redes").child("LinkAdmin").removeValue()
            database.child("Redes").child("LinkMaterial").removeValue()
            database.child("Redes").child("LinkHistoria").removeValue()
            toast("Todos los Datos Borrados")


            val Archivo2 = "Chat"
            val defaultPrefs2 =
                Splash.PreferenceHelper2.defaultPreference2(applicationContext)

            defaultPrefs2.codi = 0

            val prefs2 = Splash.PreferenceHelper2.customPreference2(
                applicationContext,
                Archivo2
            )

            val accion = "Se Vacío todos los registros de accesos."
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
            recargar1()
            customDialog.dismiss()
        }
        noBtn.setOnClickListener {
            customDialog.dismiss()
        }
        customDialog.show()

    }


    private fun alerta4(area: Int) {
        val db = FirebaseFirestore.getInstance()
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.redesd)
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        when (area) {
            1 -> {
                val admin = "Arely Vanessa"
                val red = "Facebook"
                val database = Firebase.database
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Facebook de Arely")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {

                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {
                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Facebook") {
                                    customDialog.url.text =
                                        redes.Facebook.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }

            }
            2 -> {
                val admin = "Arely Vanessa"
                val red = "Instagram"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Instagram de Arely")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Instagram") {
                                    customDialog.url.text =
                                        redes.Instagram.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            3 -> {
                val admin = "Arely Vanessa"
                val red = "Telegram"
                val database = Firebase.database
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Telegram de Arely")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {
                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Telegram") {
                                    customDialog.url.text =
                                        redes.Telegram.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            4 -> {
                val admin = "Arely Vanessa"
                val red = "Twitter"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Twitter de Arely")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Twitter") {
                                    customDialog.url.text =
                                        redes.Twitter.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            5 -> {
                val admin = "Arely Vanessa"
                val red = "Whatsapp"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Whatsapp de Arely")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Whatsapp") {
                                    customDialog.url.text =
                                        redes.Whatsapp.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            7 -> {
                val admin = "Alejandro"
                val red = "Facebook"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Facebook de Alejandro")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Facebook") {
                                    customDialog.url.text =
                                        redes.Facebook.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            8 -> {
                val admin = "Alejandro"
                val red = "Instagram"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Instagram de Alejandro")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Instagram") {
                                    customDialog.url.text =
                                        redes.Instagram.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            9 -> {
                val admin = "Alejandro"
                val red = "Telegram"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Telegram de Alejandro")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Telegram") {
                                    customDialog.url.text =
                                        redes.Telegram.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            10 -> {
                val admin = "Alejandro"
                val red = "Twitter"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Twitter de Alejandro")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Twitter") {
                                    customDialog.url.text =
                                        redes.Twitter.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            11 -> {
                val admin = "Alejandro"
                val red = "Whatsapp"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Whatsapp de Alejandro")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }
                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Whatsapp") {
                                    customDialog.url.text =
                                        redes.Whatsapp.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            12 -> {
                val admin = "BraApp"
                val red = "Facebook"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Facebook de BraApp Package")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Facebook") {
                                    customDialog.url.text =
                                        redes.Facebook.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            13 -> {
                val admin = "BraApp"
                val red = "Instagram"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Instagram de BraApp Package")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Instagram") {
                                    customDialog.url.text =
                                        redes.Instagram.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            14 -> {
                val admin = "BraApp"
                val red = "Pagina"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Pagina de BraApp Package")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Pagina") {
                                    customDialog.url.text =
                                        redes.Pagina.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            15 -> {
                val admin = "BraApp"
                val red = "Twitter"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Twitter de BraApp Package")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Twitter") {
                                    customDialog.url.text =
                                        redes.Twitter.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            16 -> {
                val admin = "BraApp"
                val red = "Youtube"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Youtube de BraApp Package")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Youtube") {
                                    customDialog.url.text =
                                        redes.Youtube.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            17 -> {
                val admin = "BraApp"
                val red = "Telegram"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Telegram de BraApp Package")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Telegram") {
                                    customDialog.url.text =
                                        redes.Telegram.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            18 -> {
                val admin = "BraApp"
                val red = "Whatsapp"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Whatsapp de BraApp Package")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Whatsapp") {
                                    customDialog.url.text =
                                        redes.Whatsapp.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            19 -> {
                val admin = "BraApp"
                val red = "Tiktok"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("TikTok de BraApp Package")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Tiktok") {
                                    customDialog.url.text =
                                        redes.Tiktok.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            20 -> {
                val admin = "BraApp"
                val red = "Spotify"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Spotify de BraApp Package")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }
                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Spotify") {
                                    customDialog.url.text =
                                        redes.Spotify.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            23 -> {
                val admin = "LinkAdmin"
                val red = "link"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Enlace de Descarga BraAppAdmin")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la $red de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin la red de $red."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "link") {
                                    customDialog.url.text =
                                        redes.link.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            24 -> {
                val admin = "LinkMaterial"
                val red = "VerMasM"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Enlace de Material de Apoyo")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar el/la Material de Apoyo de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("$admin").child("$red")
                            .removeValue()
                        database.child("Redes").child("$admin")
                            .child("DescarHis3")
                            .removeValue()
                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion =
                            "Se Eliminó de material de apoyo de $admin."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "VerMasM") {
                                    Log.v(
                                        "VerMasM",
                                        "${redes.VerMasM.toString()}"
                                    )
                                    customDialog.url.text =
                                        redes.VerMasM.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })

                }
            }
            25 -> {
                val admin = "LinkHistoria"
                val red = "VerMas"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Enlace de Historia")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar Historia de $admin ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("LinkHistoria")
                            .child("DescarHis")
                            .removeValue()
                        database.child("Redes").child("LinkHistoria")
                            .child("$red")
                            .removeValue()
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de $admin historia."
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
                        toast("Todos los Datos Borrados")
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "VerMas") {
                                    customDialog.url.text =
                                        redes.VerMas.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })
                }
            }
            26 -> {
                val admin = "LinkAdmin"
                val red = "qrf"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Enlaces directos a Codigos QR")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar Enlaces directos a Codigos QR ?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("LinkAdmin").child("qrf")
                            .removeValue()

                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó de codigo qr."
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "qrf") {
                                    customDialog.url.text = redes.qrf.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })
                }
            }
            27 -> {
                val admin = "LinkAdmin"
                val red = "Figma"
                val database = Firebase.database
                Log.v("Prueba", "$admin")
                Log.v("Prueba", "$red")
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                customDialog.info.setText("Enlace a Figma")
                val myRef = database.getReference("/Redes/$admin")
                Log.v("Prueba", "$myRef")
                customDialog.user24.text = "$admin"
                customDialog.red3.text = "$red"
                customDialog.vaciarT3.setOnClickListener {
                    val database = Firebase.database.reference
                    val customDialog2 = Dialog(this)
                    customDialog2.setContentView(R.layout.activity_confirmacion)
                    customDialog2.window?.setBackgroundDrawable(
                        ColorDrawable(
                            Color.TRANSPARENT
                        )
                    )
                    customDialog2.window?.setLayout(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val yesBtn =
                        customDialog2.findViewById<Button>(R.id.yes_opt9) as TextView
                    val noBtn =
                        customDialog2.findViewById<Button>(R.id.no_opt9) as TextView

                    customDialog2.texto.setText("¿Desea realmente eliminar Enlace a Figma?")

                    yesBtn.setOnClickListener {

                        database.child("Redes").child("LinkAdmin")
                            .child("Figma")
                            .removeValue()

                        toast("Todos los Datos Borrados")
                        val Archivo2 = "Chat"
                        val defaultPrefs2 =
                            Splash.PreferenceHelper2.defaultPreference2(
                                applicationContext
                            )

                        defaultPrefs2.codi = 0

                        val prefs2 =
                            Splash.PreferenceHelper2.customPreference2(
                                applicationContext,
                                Archivo2
                            )

                        val accion = "Se Eliminó enlace a Figma"
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
                        recargar1()
                        customDialog.dismiss()
                        customDialog2.dismiss()
                    }
                    noBtn.setOnClickListener {
                        customDialog2.dismiss()
                    }
                    customDialog2.show()
                }

                with(myRef) {
                    addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val redes: adapterRed? =
                                dataSnapshot.getValue(adapterRed::class.java)
                            if (redes != null) {
                                if (red == "Figma") {
                                    customDialog.url.text =
                                        redes.Figma.toString()
                                    if (customDialog.url.text == "null") {
                                        customDialog.url.text = ""
                                    }
                                }
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })
                }
            }
        }
        customDialog.saveButto443.setOnClickListener {

            if (customDialog.urlN.text.toString()
                    .isEmpty() || customDialog.user24.text.toString()
                    .isEmpty() || customDialog.red3.text.toString().isEmpty()
            ) {
                toast("No se puede actualizar si el campo esta vacio")
            } else if (!customDialog.urlN.text.toString()
                    .isEmpty() && !customDialog.user24.text.toString()
                    .isEmpty() && !customDialog.red3.text.toString().isEmpty()
            ) {

                if (customDialog.user24.text == "LinkMaterial" && customDialog.red3.text == "VerMasM") {
                    val myRef =
                        database.getReference("/Redes/LinkMaterial/${customDialog.red3.text}/")
                    val myRef2 =
                        database.getReference("/Redes/LinkMaterial/DescarHis3/")
                    myRef.setValue("${customDialog.urlN.text}")
                    myRef2.setValue("${customDialog.urlN.text}")
                    customDialog.urlN.setText("")
                    toast("Dato Actualizado")
                    val Archivo2 = "Chat"
                    val defaultPrefs2 =
                        Splash.PreferenceHelper2.defaultPreference2(
                            applicationContext
                        )

                    defaultPrefs2.codi = 0

                    val prefs2 =
                        Splash.PreferenceHelper2.customPreference2(
                            applicationContext,
                            Archivo2
                        )

                    val accion = "Se Guardó en ${customDialog.user24.text} "
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
                    customDialog.dismiss()
                } else if (customDialog.user24.text == "LinkHistoria" && customDialog.red3.text == "VerMas") {
                    val myRef =
                        database.getReference("/Redes/LinkHistoria/${customDialog.red3.text}/")
                    val myRef2 =
                        database.getReference("/Redes/LinkHistoria/DescarHis/")
                    myRef.setValue("${customDialog.urlN.text}")
                    myRef2.setValue("${customDialog.urlN.text}")
                    customDialog.urlN.setText("")
                    toast("Dato Actualizado")
                    val Archivo2 = "Chat"
                    val defaultPrefs2 =
                        Splash.PreferenceHelper2.defaultPreference2(
                            applicationContext
                        )

                    defaultPrefs2.codi = 0

                    val prefs2 =
                        Splash.PreferenceHelper2.customPreference2(
                            applicationContext,
                            Archivo2
                        )

                    val accion = "Se Guardó en ${customDialog.user24.text}"
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
                    customDialog.dismiss()
                } else {
                    val myRef =
                        database.getReference("/Redes/${customDialog.user24.text}/${customDialog.red3.text}/")
                    myRef.setValue("${customDialog.urlN.text}")
                    customDialog.urlN.setText("")
                    toast("Dato Actualizado")
                    val Archivo2 = "Chat"
                    val defaultPrefs2 =
                        Splash.PreferenceHelper2.defaultPreference2(
                            applicationContext
                        )

                    defaultPrefs2.codi = 0

                    val prefs2 =
                        Splash.PreferenceHelper2.customPreference2(
                            applicationContext,
                            Archivo2
                        )

                    val accion =
                        "Se Guardó en ${customDialog.user24.text} en ${customDialog.red3.text}"
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
                    customDialog.dismiss()
                }

            } else {
                toast("Dato  No Actualizado")
                customDialog.dismiss()
            }
        }
        customDialog.show()
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

    fun recargar1() {
        overridePendingTransition(0, 0);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
        overridePendingTransition(0, 0);
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