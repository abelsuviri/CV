package com.abelsuviri.abelsuviricv.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abelsuviri.abelsuviricv.R
import com.abelsuviri.abelsuviricv.ui.adapter.viewholder.SkillsViewHolder

/**
 * @author Abel Suviri
 */

class SkillsAdapter constructor(private val skillList: List<String>) : RecyclerView.Adapter<SkillsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_skill, parent, false)

        return SkillsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SkillsViewHolder, position: Int) {
        val item = skillList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return skillList.size
    }
}