package com.abelsuviri.abelsuviricv.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abelsuviri.abelsuviricv.R
import com.abelsuviri.abelsuviricv.data.model.ExperienceModel
import com.abelsuviri.abelsuviricv.ui.adapter.viewholder.ExperienceViewHolder

/**
 * @author Abel Suviri
 */

class ExperienceAdapter constructor(private val experienceList: List<ExperienceModel>) : RecyclerView.Adapter<ExperienceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_experience, parent, false)
        return ExperienceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        val item = experienceList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return experienceList.size
    }
}