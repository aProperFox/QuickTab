package com.aproperfox.quicktabs.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aproperfox.quicktabs.db.ProjectDao
import com.aproperfox.quicktabs.models.Project
import javax.inject.Inject

class ProjectsViewModel @Inject constructor(private val projectsDao: ProjectDao) : ViewModel() {
    val projects: LiveData<List<Project>> = projectsDao.getProjects()

    fun newProject(name: String, description: String) {
        projectsDao.insertProject(Project(name, description))
    }
}