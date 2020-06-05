package com.aproperfox.quicktabs.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aproperfox.quicktabs.R
import com.aproperfox.quicktabs.models.Project
import java.util.*

class ProjectsAdapter(initialProjects: List<Project> = emptyList()) :
    RecyclerView.Adapter<ProjectsAdapter.ViewHolder>() {
    var projects: List<Project> = initialProjects

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.project_view_holder, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val project = projects[position]
        holder.projectName.text = project.name
        holder.projectDesc.text = project.description
        val cal = Calendar.getInstance()
        cal.timeInMillis = project.updatedAt
        holder.projectTimestamp.text = cal.time.toString()
    }

    override fun getItemCount(): Int = projects.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val projectName: TextView = itemView.findViewById(R.id.project_name)
        val projectDesc: TextView = itemView.findViewById(R.id.project_desc)
        val projectTimestamp: TextView = itemView.findViewById(R.id.last_updated)
    }
}