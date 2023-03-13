package com.bp.braappadmin.registross

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bp.braappadmin.R
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import com.bp.braappadmin.ClickListener
import com.bp.braappadmin.comunicacion.avisos.loggg
import java.util.*
import kotlin.collections.ArrayList


class adaptadorL(var context: Context, items: ArrayList<loggg>, var listener: ClickListener) :
    RecyclerView.Adapter<adaptadorL.ViewHolder>() {
    var items: ArrayList<loggg>? = null
    private var lastPosition = -1
    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.loggs, parent, false)
        val viewHolder = ViewHolder(vista, listener)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)

        if (item?.lugar=="Movil"){
            holder.foto?.setImageResource(R.drawable.mov)
        }else if (item?.lugar=="Web"){
            holder.foto?.setImageResource(R.drawable.mon)
        }
        holder.accion?.text = item?.accion
        holder.fecha1s?.text=item?.fecha1
        holder.cods?.text = item?.codidd.toString()
        setAnimation(holder.itemView, position);
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    class ViewHolder(vista: View, listener: ClickListener) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {
        var vista = vista
        var foto: ImageView? = null
        var cods:TextView?=null
        var accion: TextView? = null
        var listener: ClickListener? = null
        var fecha1s: TextView? = null
        init {
            foto = vista.findViewById(R.id.fotoringa)
            cods=vista.findViewById(R.id.cods)
            accion = vista.findViewById(R.id.accion)
            fecha1s = vista.findViewById(R.id.fecha1s)
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