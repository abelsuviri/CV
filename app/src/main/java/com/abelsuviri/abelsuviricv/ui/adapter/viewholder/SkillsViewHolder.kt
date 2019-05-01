package com.abelsuviri.abelsuviricv.ui.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_skill.view.*

/**
 * @author Abel Suviri
 */

class SkillsViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(skill: String) {
        itemView.skillTextView.text = skill
    }
}