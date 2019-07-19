 package com.jjmin.sunrinthon.adapter

    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.CheckBox
    import android.widget.ProgressBar
    import android.widget.TextView
    import androidx.recyclerview.widget.DiffUtil
    import androidx.recyclerview.widget.ListAdapter
    import androidx.recyclerview.widget.RecyclerView
    import com.jjmin.sunrinthon.R
    import com.jjmin.sunrinthon.adapter.KeyListAdapter.Companion.itemCallback
    import com.jjmin.sunrinthon.data.MainSettingData




    class MainListAdapter() : ListAdapter<MainSettingData, MainListAdapter.ViewHolder>(itemCallback) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.item_main_reslut,
                    parent,
                    false
            )
            )
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            var item = getItem(position)

            holder.text.text = item.title
            holder.content1.text = item.title1
            holder.content2.text = item.title2
            holder.content3.text = item.title3
            holder.content4.text = item.title4
            holder.content5.text = item.title5

            holder.checkbox1.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    item.status+= 20
                } else {
                    item.status-= 20
                }

                holder.progress.progress = item.status
            }

            holder.checkbox2.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    item.status+= 20
                } else {
                    item.status-= 20
                }

                holder.progress.progress = item.status
            }

            holder.checkbox3.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    item.status+= 20
                } else {
                    item.status-= 20
                }

                holder.progress.progress = item.status
            }

            holder.checkbox4.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    item.status+= 20
                } else {
                    item.status-= 20
                }

                holder.progress.progress = item.status
            }

            holder.checkbox5.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    item.status+= 20
                } else {
                    item.status-= 20
                }

                holder.progress.progress = item.status
            }
        }


        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            var text = view.findViewById(R.id.resultname) as TextView

            var checkbox1 = view.findViewById(R.id.itemCheckBox1) as CheckBox
            var checkbox2 = view.findViewById(R.id.itemCheckBox2) as CheckBox
            var checkbox3 = view.findViewById(R.id.itemCheckBox3) as CheckBox
            var checkbox4 = view.findViewById(R.id.itemCheckBox4) as CheckBox
            var checkbox5 = view.findViewById(R.id.itemCheckBox5) as CheckBox


            var content1 = view.findViewById(R.id.itemText1) as TextView
            var content2 = view.findViewById(R.id.itemText2) as TextView
            var content3 = view.findViewById(R.id.itemText3) as TextView
            var content4 = view.findViewById(R.id.itemText4) as TextView
            var content5 = view.findViewById(R.id.itemText5) as TextView

            var progress = view.findViewById(R.id.progress_bar) as ProgressBar


        }

        companion object {
            val itemCallback = object : DiffUtil.ItemCallback<MainSettingData>() {
                override fun areItemsTheSame(oldItem: MainSettingData, newItem: MainSettingData): Boolean {
                    return oldItem == newItem
                }

                override fun areContentsTheSame(oldItem: MainSettingData, newItem: MainSettingData): Boolean {
                    return oldItem == newItem
                }
            }
        }
    }



