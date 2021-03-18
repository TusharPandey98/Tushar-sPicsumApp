package com.example.picsumapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.picsumapp.R
import com.example.picsumapp.model.Post
import com.example.picsumapp.utils.Constants.Companion.BASE_IMAGE_URL
import kotlinx.android.synthetic.main.post_row_layout.view.*

/**
 * This is the custom adapter for recycler view
 *
 */
class PostAdapter :RecyclerView.Adapter<PostAdapter.MyViewHolder>() {
    //An empty list of posts
    private var posts = emptyList<Post>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return  MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.post_row_layout,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.author_imageView.load(BASE_IMAGE_URL+posts[position].id)
        holder.itemView.author_textView.text = posts[position].author

    }

    override fun getItemCount(): Int {
      return posts.size
    }

    fun setData(newPosts:List<Post>){
        posts = newPosts
        notifyDataSetChanged()
    }
}