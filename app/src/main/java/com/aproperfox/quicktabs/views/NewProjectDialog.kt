package com.aproperfox.quicktabs.views

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.aproperfox.quicktabs.QuickTabsApp
import com.aproperfox.quicktabs.R
import com.aproperfox.quicktabs.db.ProjectDao
import com.aproperfox.quicktabs.models.Project
import com.google.android.material.textfield.TextInputLayout
import javax.inject.Inject


class NewProjectDialog : DialogFragment() {

    private lateinit var nameLayout: TextInputLayout
    private lateinit var nameInput: EditText
    private lateinit var descInput: EditText

    @Inject
    lateinit var projectDao: ProjectDao

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val b: AlertDialog.Builder = AlertDialog.Builder(activity)
            .setTitle(getString(R.string.new_project_title))
            .setPositiveButton(getString(R.string.new_project_ok)) { _, _ ->
                val projectName = nameInput.text?.toString()
                if (projectName.isNullOrBlank()) {
                    nameLayout.error = getString(R.string.project_name_error)
                } else {
                    val project = Project(
                        name = nameInput.text?.toString()!!,
                        description = descInput.text?.toString()
                    )
                    val newProjectId = projectDao.insertProject(project)
                    findNavController().navigate(
                        R.id.action_FirstFragment_to_SecondFragment,
                        ChordBuilderFragment.bundle(newProjectId)
                    )
                    dismiss()
                }
            }
            .setNegativeButton(
                getString(R.string.new_project_cancel)
            ) { dialog, _ -> dialog.dismiss() }

        val i = requireActivity().layoutInflater

        val v: View = i.inflate(R.layout.dialog_new_project, null)

        nameLayout = v.findViewById(R.id.project_name_layout)
        nameInput = v.findViewById(R.id.project_name_edit_text)
        descInput = v.findViewById(R.id.project_desc_edit_text)
        nameInput.addTextChangedListener {
            nameLayout.error = ""
        }
        b.setView(v)
        return b.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as QuickTabsApp).appComponent.inject(this)
    }
}