package com.bp.braappadmin.comunicacion.avisos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bp.braappadmin.R
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.ScaleAnimation
import com.bp.braappadmin.ClickListener
import java.util.*
import kotlin.collections.ArrayList


class adaptadorA(var context: Context, items: ArrayList<avisol>, var listener: ClickListener) :
    RecyclerView.Adapter<adaptadorA.ViewHolder>() {
    var items: ArrayList<avisol>? = null
    private var lastPosition = -1
    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.list_item4, parent, false)
        val viewHolder = ViewHolder(vista, listener)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.fecha?.text = item?.fecha
        holder.respuesta?.text = item?.Descrip
        holder.name1?.text = item?.titulo
        setAnimation(holder.itemView, position);
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    class ViewHolder(vista: View, listener: ClickListener) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {
        var vista = vista
        var fecha: TextView? = null
        var respuesta: TextView? = null
        var name1: TextView? = null
        var listener: ClickListener? = null

        init {
            fecha = vista.findViewById(R.id.fecha)
            respuesta = vista.findViewById(R.id.Descrip)
            name1 = vista.findViewById(R.id.titulo)
            this.listener = listener
            vista.setOnClickListener(this)

        }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!, adapterPosition)
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