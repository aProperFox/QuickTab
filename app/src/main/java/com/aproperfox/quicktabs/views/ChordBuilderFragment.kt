package com.aproperfox.quicktabs.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aproperfox.quicktabs.R

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ChordBuilderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chord_builder, container, false)
    }

    companion object {
        private const val KEY_PROJECT_ID = "key_project_id"

        @JvmStatic
        fun bundle(projectId: Long): Bundle = Bundle().apply {
            putLong(KEY_PROJECT_ID, projectId)
        }
    }
}