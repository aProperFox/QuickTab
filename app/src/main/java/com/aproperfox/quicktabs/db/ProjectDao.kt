package com.aproperfox.quicktabs.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aproperfox.quicktabs.models.Project

@Dao
interface ProjectDao {
    @Query("SELECT * from projects")
    fun getProjects(): LiveData<List<Project>>

    @Insert
    fun insertProject(project: Project): Long
}