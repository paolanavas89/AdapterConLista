package com.example.adapterconlista

import android.os.Build
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random


class StringAdapter(var mutableList: MutableList<String>) : RecyclerView.Adapter<StringAdapter.StringViewHolder>()  {
    class StringViewHolder(var root: View, var textView: TextView,var check: CheckBox) : RecyclerView.ViewHolder(root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val twTextView = view.findViewById<TextView>(R.id.textView)
        val check= view.findViewById<CheckBox>(R.id.checkbox)
        return StringViewHolder(view, twTextView,check)
    }

    override fun getItemCount(): Int {
        return mutableList.size + 1
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        if (position == itemCount -1) {
            holder.textView.text = "Insertar"
          //  holder.check.visibility = View.GONE
            //te dejo comentado esto xq se supone que tendria que ocultar los check, si que los oculta pero no solo el de Insertar
            //tambien oculta otros.
            holder.root.setOnClickListener {
                val toast = Toast.makeText(it.context, "Insertando...", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                mutableList.add("PC-$position")
                //con esto intentaba que los elementos insertados tambien quedaran marcados, pero no funciona
               /* holder.textView.text = mutableList[position]
                holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.green))
                holder.check.setChecked(true)*/
                notifyDataSetChanged()
            }
            return
        }else  if (position == 0) {
            holder.textView.text="Borrar"
           // holder.check.visibility = View.GONE
            holder.root.setOnClickListener {
                var removeIndex = Random.nextInt(1, itemCount -2)
                val toast = Toast.makeText(it.context, "PC Eliminado...", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                mutableList.removeAt(removeIndex)
                notifyItemRemoved(removeIndex)
            }
            return
        }
        //Aquí intente que me mostrara el número de encendidos pero tampoco lo logré :(
        /*else  if (position == itemCount -2) {
            holder.textView.text="Contar encendidos"
            holder.root.setOnClickListener {
                var num=0
                var contador = 0;
                for(i in 1..holder.check.length() -2 ){
                    if (holder.check.isChecked){
                        num++
                    }
                }
                val toast = Toast.makeText(it.context, "Hay $num encendidos", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
            return
        }*/

        var pos1 = Random.nextInt(1, itemCount -1)
        var pos2 = Random.nextInt(1, itemCount -1)
        var pos3 = Random.nextInt(1, itemCount -1)
        for (i in 1..itemCount) {
            if (position == pos1 || position == pos2 || position == pos3 || position == itemCount) {
                holder.textView.text = mutableList[position]
                holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.green))
                holder.check.setChecked(true)
            } else {
                holder.textView.text = mutableList[position]
                holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.red))
            }
        }
    }

}