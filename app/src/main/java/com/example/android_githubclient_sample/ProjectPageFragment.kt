package com.example.android_githubclient_sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_githubclient_sample.databinding.FragmentItemListBinding
import com.example.android_githubclient_sample.ui.recyclerview.ProjectRecyclerViewAdapter
import com.example.android_githubclient_sample.viewmodel.project.ProjectPageViewModel

class ProjectPageFragment : Fragment() {

    private lateinit var viewModel: ProjectPageViewModel

    private lateinit var binding: FragmentItemListBinding

    private val projectAdapter = ProjectRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentItemListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ProjectPageViewModel::class.java)


        binding.cardRecyclerView.adapter = projectAdapter
        binding.cardRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)


        viewModel.projects.observe(viewLifecycleOwner, Observer { it ->
            it.let {
                projectAdapter.submitList(it)
            }
        })

        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
       */
    }
}