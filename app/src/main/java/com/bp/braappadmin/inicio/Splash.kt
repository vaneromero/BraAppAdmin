package com.bp.braappadmin.inicio

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bp.braappadmin.ClickListener
import com.bp.braappadmin.R
import com.bp.braappadmin.comunicacion.buzon.adaptadorD
import com.bp.braappadmin.comunicacion.buzon.correol
import com.bp.braappadmin.inicio.Splash.PreferenceHelpe6.ayu
import com.bp.braappadmin.inicio.Splash.PreferenceHelpe6.defaultPreference6
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.activi
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.defaultPreference1
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.melodia
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.melodia1
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.panel
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.tono
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.tono1
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum
import com.bp.braappadmin.inicio.Splash.PreferenceHelper1.volum1
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.clave
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.codi
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.defaultPreference2
import com.bp.braappadmin.inicio.Splash.PreferenceHelper2.entrada
import com.bp.braappadmin.inicio.Splash.PreferenceHelper4.dato1
import com.bp.braappadmin.inicio.Splash.PreferenceHelper4.dato2
import com.bp.braappadmin.inicio.Splash.PreferenceHelper4.dato3
import com.bp.braappadmin.inicio.Splash.PreferenceHelper4.defaultPreference4
import com.bp.braappadmin.menuP.MenuPrinci
import com.google.firebase.firestore.FirebaseFirestore
import spencerstudios.com.bungeelib.Bungee

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                )

        version()
        val Archivo4 = "Catalogo"
        val defaultPrefs4 = defaultPreference4(this)
        defaultPrefs4.dato1 = 0
        defaultPrefs4.dato2 = 0
        defaultPrefs4.dato3 = 0
        val prefs4 = PreferenceHelper4.customPreference4(this, Archivo4)
        val Archivo2 = "Chat"
        val defaultPrefs2 = defaultPreference2(this)
        defaultPrefs2.entrada = 0
        defaultPrefs2.clave = 0
        defaultPrefs2.codi = 0
        val prefs2 = PreferenceHelper2.customPreference2(this, Archivo2)
        val Archivo6 = "Ayuda"
        val defaultPrefs6 = defaultPreference6(this)
        defaultPrefs6.ayu = 0
        val prefs6 = PreferenceHelpe6.customPreference6(this, Archivo6)
        val Archivo1 = "Audio"
        val defaultPrefs1 = defaultPreference1(this)
        defaultPrefs1.tono = 1
        defaultPrefs1.melodia = 1
        defaultPrefs1.tono1 = 1
        defaultPrefs1.melodia1 = 1
        defaultPrefs1.activi = ""
        defaultPrefs1.volum = 0.10f
        defaultPrefs1.volum1 = 1.00f
        defaultPrefs1.panel=1
        val prefs1 = PreferenceHelper1.customPreference1(this, Archivo1)
        Thread.sleep(500)
        val texto1: TextView = findViewById(R.id.tema)
        val texto3: TextView = findViewById(R.id.tema3)
        val texto4: ImageView = findViewById(R.id.image1)
        val texto2: ImageView = findViewById(R.id.image2)
        val texto5: ImageView = findViewById(R.id.punto)
        //Asignacioón de las animaciones
        val anim1: Animation = AnimationUtils.loadAnimation(this, R.anim.abajo)
        texto1.startAnimation(anim1)
        texto2.startAnimation(anim1)
        texto3.startAnimation(anim1)
        texto4.startAnimation(anim1)
        texto5.startAnimation(anim1)

        //Tiempo de espera para el cambio de venta
        Handler().postDelayed({

            if (prefs2.entrada == 0) {

                startActivity(Intent(this, LoginActivity::class.java))
                Bungee.zoom(this)
                finish()

            } else if (prefs2.entrada == 1) {


                startActivity(Intent(this, MenuPrinci::class.java))
                Bungee.zoom(this)
                finish()
            }
        }, 4000)
    }

    fun version() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }

    object PreferenceHelper2 {
        val ID_Chat = "ID_Chat"
        val ID_Clave = "ID_Clave"
        val ID_Codi = "ID_Codi"
        fun defaultPreference2(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

        fun customPreference2(context: Context, name: String): SharedPreferences =
            context.getSharedPreferences(name, Context.MODE_PRIVATE)

        inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
            val editMe = edit()
            operation(editMe)
            editMe.apply()
        }

        inline fun SharedPreferences.Editor.put(pair: Pair<String, Any>) {
            val key = pair.first
            val value = pair.second
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is Long -> putLong(key, value)
                is Float -> putFloat(key, value)
                else -> error("Only primitive types can be stored in SharedPreferences")
            }
        }

        var SharedPreferences.entrada
            get() = getInt(ID_Chat, 0)
            set(value) {
                editMe {
                    it.putInt(ID_Chat, value)
                }
            }
        var SharedPreferences.clave
            get() = getInt(ID_Clave, 0)
            set(value) {
                editMe {
                    it.putInt(ID_Clave, value)
                }
            }
        var SharedPreferences.codi
            get() = getInt(ID_Codi, 0)
            set(value) {
                editMe {
                    it.putInt(ID_Codi, value)
                }
            }
        var SharedPreferences.clearValues2
            get() = { }
            set(value) {
                editMe {
                    it.remove(ID_Chat)
                    it.remove(entrada.toString())
                    it.remove(ID_Clave)
                    it.remove(clave.toString())
                    it.remove(ID_Codi)
                    it.remove(codi.toString())
                    it.clear()
                }
            }
    }
    object PreferenceHelper4 {

        val ID_Dato1 = "ID_Dato1"
        val ID_Dato2 = "ID_Dato2"
        val ID_Dato3 = "ID_Dato3"
        fun defaultPreference4(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

        fun customPreference4(context: Context, name: String): SharedPreferences =
            context.getSharedPreferences(name, Context.MODE_PRIVATE)

        inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
            val editMe = edit()
            operation(editMe)
            editMe.apply()
        }

        inline fun SharedPreferences.Editor.put(pair: Pair<String, Any>) {
            val key = pair.first
            val value = pair.second
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is Long -> putLong(key, value)
                is Float -> putFloat(key, value)
                else -> error("Only primitive types can be stored in SharedPreferences")
            }
        }

        var SharedPreferences.dato1
            get() = getInt(ID_Dato1, 0)
            set(value) {
                editMe {
                    it.putInt(ID_Dato1, value)
                }
            }
        var SharedPreferences.dato2
            get() = getInt(ID_Dato2, 0)
            set(value) {
                editMe {
                    it.putInt(ID_Dato2, value)
                }
            }
        var SharedPreferences.dato3
            get() = getInt(ID_Dato3, 0)
            set(value) {
                editMe {
                    it.putInt(ID_Dato3, value)
                }
            }
        var SharedPreferences.clearValues5
            get() = { }
            set(value) {
                editMe {
                    it.remove(ID_Dato1)
                    it.remove(dato1.toString())
                    it.remove(ID_Dato2)
                    it.remove(dato2.toString())
                    it.remove(ID_Dato3)
                    it.remove(dato3.toString())
                    it.clear()
                }
            }
    }

    //Archivo de ayuda
    object PreferenceHelpe6 {

        val ID_ayu = "ID_ayu"
        fun defaultPreference6(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

        fun customPreference6(context: Context, name: String): SharedPreferences =
            context.getSharedPreferences(name, Context.MODE_PRIVATE)

        inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
            val editMe = edit()
            operation(editMe)
            editMe.apply()
        }

        inline fun SharedPreferences.Editor.put(pair: Pair<String, Any>) {
            val key = pair.first
            val value = pair.second
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is Long -> putLong(key, value)
                is Float -> putFloat(key, value)
                else -> error("Only primitive types can be stored in SharedPreferences")
            }
        }

        var SharedPreferences.ayu
            get() = getInt(ID_ayu, 0)
            set(value) {
                editMe {
                    it.putInt(ID_ayu, value)
                }
            }

        var SharedPreferences.clearValues5dg
            get() = { }
            set(value) {
                editMe {
                    it.remove(ID_ayu)
                    it.remove(ayu.toString())
                    it.clear()
                }
            }
    }
    //Archivo de audio
    object PreferenceHelper1 {
        val ID_Tono = "ID_Tono"
        val ID_Panel = "ID_Panel"
        val ID_Melodia = "ID_Melodia"
        val ID_Tono1 = "ID_Tono1"
        val ID_Melodia1 = "ID_Melodia1"
        val ID_Acti = "ID_Acti"
        val ID_Volum = "ID_Volum"
        val ID_Volum1 = "ID_Volum1"
        fun defaultPreference1(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

        fun customPreference1(context: Context, name: String): SharedPreferences =
            context.getSharedPreferences(name, Context.MODE_PRIVATE)

        inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
            val editMe = edit()
            operation(editMe)
            editMe.apply()
        }

        inline fun SharedPreferences.Editor.put(pair: Pair<String, Any>) {
            val key = pair.first
            val value = pair.second
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is Long -> putLong(key, value)
                is Float -> putFloat(key, value)
                else -> error("Only primitive types can be stored in SharedPreferences")
            }
        }

        var SharedPreferences.tono
            get() = getInt(ID_Tono, 1)
            set(value) {
                editMe {
                    it.putInt(ID_Tono, value)
                }
            }
        var SharedPreferences.panel
            get() = getInt(ID_Panel, 1)
            set(value) {
                editMe {
                    it.putInt(ID_Panel, value)
                }
            }
        var SharedPreferences.melodia
            get() = getInt(ID_Melodia, 1)
            set(value) {
                editMe {
                    it.putInt(ID_Melodia, value)
                }
            }
        var SharedPreferences.tono1
            get() = getInt(ID_Tono1, 1)
            set(value) {
                editMe {
                    it.putInt(ID_Tono1, value)
                }
            }
        var SharedPreferences.melodia1
            get() = getInt(ID_Melodia1, 1)
            set(value) {
                editMe {
                    it.putInt(ID_Melodia1, value)
                }
            }
        var SharedPreferences.volum
            get() = getFloat(ID_Volum, 0.10f)
            set(value) {
                editMe {
                    it.putFloat(ID_Volum, value)
                }
            }
        var SharedPreferences.volum1
            get() = getFloat(ID_Volum1, 1.00f)
            set(value) {
                editMe {
                    it.putFloat(ID_Volum1, value)
                }
            }
        var SharedPreferences.activi
            get() = getString(ID_Acti, "")
            set(value) {
                editMe {
                    it.putString(ID_Acti, value)
                }
            }
        var SharedPreferences.clearValues1
            get() = { }
            set(value) {
                editMe {
                    it.remove(ID_Tono)
                    it.remove(ID_Panel)
                    it.remove(ID_Melodia)
                    it.remove(ID_Tono1)
                    it.remove(ID_Melodia1)
                    it.remove(ID_Acti)
                    it.remove(ID_Volum)
                    it.remove(ID_Volum1)
                    it.remove(tono.toString())
                    it.remove(melodia.toString())
                    it.remove(tono1.toString())
                    it.remove(melodia1.toString())
                    it.remove(activi)
                    it.remove(panel.toString())
                    it.remove(volum.toString())
                    it.remove(volum1.toString())
                    it.clear()
                }
            }
    }

}