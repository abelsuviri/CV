package com.abelsuviri.abelsuviricv.ui.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.abelsuviri.abelsuviricv.R
import com.abelsuviri.abelsuviricv.data.model.ExperienceModel
import kotlinx.android.synthetic.main.item_experience.view.*

/**
 * @author Abel Suviri
 */

class ExperienceViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(experience: ExperienceModel) {
        itemView.positionTitleTextView.text = itemView.context.getString(R.string.cv_title, experience.jobPosition, experience.companyName)
        itemView.positionDateTextView.text = itemView.context.getString(R.string.cv_title, experience.fromDate, experience.toDate)
        itemView.positionDetailTextView.text = experience.description
    }
}