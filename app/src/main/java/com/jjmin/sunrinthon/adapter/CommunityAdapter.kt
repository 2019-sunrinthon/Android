package com.jjmin.sunrinthon.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jjmin.sunrinthon.R
import com.jjmin.sunrinthon.ViewActivity
import com.jjmin.sunrinthon.data.KeyData
import com.jjmin.sunrinthon.data.model.Communy
import org.jetbrains.anko.sdk27.coroutines.onClick

class CommunityAdapter : ListAdapter<Communy,CommunityAdapter.ViewHolder1>(itemCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {
        return ViewHolder1(LayoutInflater.from(parent.context).inflate(
                R.layout.item_commuty,
                parent,
                false
        )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder1, position: Int) {
        var item = getItem(position) as Communy

        holder.name.text = item.name
        holder.title.text = item.title

        holder.itemView.onClick {
            var intent = Intent(holder.itemView.context,ViewActivity::class.java)
            intent.putExtra("name",item.title)
            intent.putExtra("contnet",item.content)
            holder.itemView.context.startActivity(intent)
        }

    }


    class ViewHolder1(view: View) : RecyclerView.ViewHolder(view) {
        var name = view.findViewById(R.id.comunityName) as TextView
        var title = view.findViewById(R.id.comunityTitle) as TextView
    }

    companion object {
        val itemCallback = object : DiffUtil.ItemCallback<Communy>() {
            override fun areItemsTheSame(oldItem: Communy, newItem: Communy): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Communy, newItem: Communy): Boolean {
                return oldItem == newItem
            }
        }
    }
}