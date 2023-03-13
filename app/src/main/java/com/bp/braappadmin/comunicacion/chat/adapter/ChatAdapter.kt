package com.bp.braappadmin.comunicacion.chat.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bp.braappadmin.comunicacion.chat.model.Chat
import com.bp.braappadmin.comunicacion.chat.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.item_left.view.*
import kotlinx.android.synthetic.main.item_right.view.*
import com.bp.braappadmin.R
import java.util.*
import kotlin.collections.ArrayList

class ChatAdapter(
    private val context: Context,
    private val chatList: ArrayList<Chat>,
    idUsuario: String
) :
    RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
    private var lastPosition = -1
    private val MESSAGE_TYPE_LEFT = 0
    private val MESSAGE_TYPE_RIGHT = 1
    var firebaseUser: FirebaseUser? = null
    val firebase: FirebaseUser = FirebaseAuth.getInstance().currentUser!!
    var reference: DatabaseReference? = null
    var reference1: DatabaseReference? = null
    var usuario = firebase.uid
    var usuario1 = idUsuario
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        if (viewType == MESSAGE_TYPE_RIGHT) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_right, parent, false)
            Log.v("datos", "entro" + context)
            return ViewHolder(view)
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_left, parent, false)
            return ViewHolder(view)
        }

    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chat = chatList[position]
        setAnimation(holder.itemView, position);
        reference = FirebaseDatabase.getInstance().getReference("Administradores").child(usuario)
        reference1 = FirebaseDatabase.getInstance().getReference("Users").child(usuario1)
        reference!!.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                holder.txtUserName.text = chat.message
                val targetImageView = holder.itemView.userImage1
                val targetImageView1 = holder.itemView.userImage
                val user = snapshot.getValue(User::class.java)

                if (user!!.sexo == "" && targetImageView !== null) {
                    when (user!!.sexo) {
                        "Masculino" -> {
                            targetImageView.setImageResource(R.drawable.businessman)
                        }
                        "Femenino" -> {
                            targetImageView.setImageResource(R.drawable.businesswoman)
                        }
                        "no" -> {
                            targetImageView.setImageResource(R.drawable.interrogation)
                        }
                    }
                } else if (targetImageView1 == null) {
                    when (user!!.sexo) {
                        "Masculino" -> {
                            targetImageView.setImageResource(R.drawable.businessman)

                        }
                        "Femenino" -> {
                            targetImageView.setImageResource(R.drawable.businesswoman)

                        }
                        "no" -> {
                            targetImageView.setImageResource(R.drawable.interrogation)

                        }
                    }
                } else {
                    reference1!!.addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }

                        override fun onDataChange(snapshot: DataSnapshot) {
                            val user1 = snapshot.getValue(User::class.java)
                            if (user1!!.sexo == "" && targetImageView1 !== null) {
                                when (user1!!.sexo) {
                                    "Masculino" -> {
                                        targetImageView1.setImageResource(R.drawable.businessman)

                                    }
                                    "Femenino" -> {
                                        targetImageView1.setImageResource(R.drawable.businesswoman)

                                    }
                                    "no" -> {
                                        targetImageView1.setImageResource(R.drawable.interrogation)

                                    }
                                }
                            } else if (targetImageView == null) {
                                when (user1!!.sexo) {
                                    "Masculino" -> {
                                        targetImageView1.setImageResource(R.drawable.businessman)

                                    }
                                    "Femenino" -> {
                                        targetImageView1.setImageResource(R.drawable.businesswoman)

                                    }
                                    "no" -> {
                                        targetImageView1.setImageResource(R.drawable.interrogation)

                                    }
                                }
                            }
                        }
                    })
                }
            }


        })
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtUserName: TextView = view.findViewById(R.id.tvMessage)

    }

    override fun getItemViewType(position: Int): Int {
        firebaseUser = FirebaseAuth.getInstance().currentUser
        if (chatList[position].senderId == firebaseUser!!.uid) {
            return MESSAGE_TYPE_RIGHT
        } else {
            return MESSAGE_TYPE_LEFT
        }

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
