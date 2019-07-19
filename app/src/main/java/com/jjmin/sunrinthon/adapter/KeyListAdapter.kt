package com.jjmin.sunrinthon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jjmin.sunrinthon.R
import com.jjmin.sunrinthon.data.KeyData
import com.bumptech.glide.Glide




class KeyListAdapter : ListAdapter<KeyData, KeyListAdapter.ViewHolder1>(itemCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {
        return ViewHolder1(LayoutInflater.from(parent.context).inflate(
                R.layout.item_key,
                parent,
                false
        )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder1, position: Int) {
        var item = getItem(position) as KeyData

        holder.index.text = item.index
        Glide.with(holder.itemView.context).load(item.img).into(holder.img)
        holder.title.text = item.title
        holder.content.text = item.content

    }


    class ViewHolder1(view: View) : RecyclerView.ViewHolder(view) {
        var index = view.findViewById(R.id.keyIndex) as TextView
        var img = view.findViewById(R.id.keyImg) as ImageView
        var title = view.findViewById(R.id.keytitle) as TextView
        var content = view.findViewById(R.id.keyContent) as TextView
    }

    companion object {
        val itemCallback = object : DiffUtil.ItemCallback<KeyData>() {
            override fun areItemsTheSame(oldItem: KeyData, newItem: KeyData): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: KeyData, newItem: KeyData): Boolean {
                return oldItem == newItem
            }
        }
    }
}

