package com.example.cadernodereceitas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cadernodereceitas.databinding.CategoryLayoutBinding
import com.example.cadernodereceitas.entities.CategoryEntity

class CategoryAdapter(private val ctx: CategoryFragment): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    var categoriesList = listOf<CategoryEntity>()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.CategoryViewHolder {
        val viewBinding = CategoryLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.CategoryViewHolder, position: Int) {
       val categoryItem = categoriesList[position]
       holder.bind(categoryItem)
    }

    override fun getItemCount(): Int = categoriesList.size

    inner class CategoryViewHolder(private val viewBinding: CategoryLayoutBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(categoryEntityItem: CategoryEntity) {
            viewBinding.txtCategory.text = categoryEntityItem.strCategory
            Glide.with(ctx)
                .load(categoryEntityItem.strCategoryThumb)
                .into(viewBinding.mgvCategory)

        }
    }
}
