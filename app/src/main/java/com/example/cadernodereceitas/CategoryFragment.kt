package com.example.cadernodereceitas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cadernodereceitas.databinding.FragmentCategoryBinding
import com.example.cadernodereceitas.viewmodel.CategoryViewModel


class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private val viewModel: CategoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(layoutInflater)

        viewModel.getCategories()

        val recycler: RecyclerView = binding.rcvCategories
        val adapter = CategoryAdapter(this)

        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter

        viewModel.listCategories.observe(viewLifecycleOwner, {
            adapter.categoriesList = it.categories
        })
        return binding?.root
    }
}