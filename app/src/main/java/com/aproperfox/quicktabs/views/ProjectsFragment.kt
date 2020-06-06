package com.aproperfox.quicktabs.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.aproperfox.quicktabs.QuickTabsApp
import com.aproperfox.quicktabs.R
import com.aproperfox.quicktabs.db.AppDatabase
import com.aproperfox.quicktabs.viewmodels.ProjectsViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ProjectsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    @Inject
    lateinit var viewModel: ProjectsViewModel
    lateinit var recycler: RecyclerView
    lateinit var adapter: ProjectsAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (requireContext().applicationContext as QuickTabsApp).appComponent.inject(this)
        adapter = ProjectsAdapter()
        viewModel.projects.observe(viewLifecycleOwner, Observer {
            adapter.projects = it
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById(R.id.recycler)
        recycler.adapter = adapter
    }
}