package com.abelsuviri.abelsuviricv.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abelsuviri.abelsuviricv.R
import com.abelsuviri.abelsuviricv.ui.adapter.ExperienceAdapter
import com.abelsuviri.abelsuviricv.ui.adapter.SkillsAdapter
import com.abelsuviri.abelsuviricv.viewmodel.MainViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * @author Abel Suviri
 */

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        subscribeLiveData()
        mainViewModel.getCv()
    }

    /**
     * Set the RecyclerView properties. The RecyclerView that displays the skills list will have the scroll disabled as this
     * will be handled by the parent ScrollView.
     */
    private fun initViews() {
        skillsList.layoutManager = object : LinearLayoutManager(this, RecyclerView.VERTICAL, false) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }

        experienceList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    /**
     * Start to observe the LiveData values from the ViewModel.
     */
    private fun subscribeLiveData() {
        mainViewModel.cv.observe(this, Observer {
            summaryTextView.text = it.summary
            skillsList.adapter = SkillsAdapter(it.knowledge)
            experienceList.adapter = ExperienceAdapter(it.experience)
        })

        mainViewModel.isLoading.observe(this, Observer { isLoading ->
            loadingLayout.visibility = if (isLoading) View.VISIBLE else View.GONE
        })

        mainViewModel.hasFailed.observe(this, Observer { hasFailed ->
            if (hasFailed){
                Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_LONG).show()
            }
        })
    }
}
