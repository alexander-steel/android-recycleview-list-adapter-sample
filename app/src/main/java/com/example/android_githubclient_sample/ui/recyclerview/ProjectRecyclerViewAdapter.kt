package com.example.android_githubclient_sample.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android_githubclient_sample.databinding.FragmentItemBinding
import com.example.android_githubclient_sample.entity.Project


private object DiffCallback : DiffUtil.ItemCallback<Project>() {
    override fun areItemsTheSame(oldItem: Project, newItem: Project): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Project, newItem: Project): Boolean {
        return oldItem == newItem
    }

}

class ProjectRecyclerViewAdapter(
) : ListAdapter<Project, ProjectRecyclerViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectRecyclerViewHolder {
        print("onCreateViewHolder")
        return ProjectRecyclerViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProjectRecyclerViewHolder, position: Int) {
        print("onBindViewHolder")
        holder.bind(getItem(position))
    }
}

class ProjectRecyclerViewHolder(private val binding: FragmentItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(project: Project) {
        binding.id.text = project.id.toString()
        binding.fullName.text = project.full_name
        binding.name.text = project.name
        binding.htmlUrl.text = project.html_url
    }
}