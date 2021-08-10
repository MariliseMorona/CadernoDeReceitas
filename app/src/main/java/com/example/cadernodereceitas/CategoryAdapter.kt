package com.example.cadernodereceitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cadernodereceitas.entities.CategoryEntity

class CategoryAdapter(private val ctx: CategoryFragment): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    var categoriesList = listOf<CategoryEntity>()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewBinding = layoutInflater.inflate(R.layout.category_layout, parent, false)
        return CategoryViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
       val categoryItem = categoriesList[position]
       holder.bind(categoryItem)
    }

    override fun getItemCount(): Int = categoriesList.size

    inner class CategoryViewHolder(viewBinding: View) : RecyclerView.ViewHolder(viewBinding) {

        private val categoryTitle: TextView = itemView.findViewById(R.id.txt_category)
        private val categoryImage: ImageView = itemView.findViewById(R.id.mgv_category)

        fun bind(categoryEntityItem: CategoryEntity) {
            categoryTitle.text = categoryEntityItem.strCategory
            Glide.with(ctx)
                .load(categoryEntityItem.strCategoryThumb)
                .into(categoryImage)

        }
    }
}
