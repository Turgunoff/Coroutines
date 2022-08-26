package com.uz.coroutinesmvc.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uz.coroutinesmvc.model.Post
import com.uz.coroutinesmvc.R


/**
 * Created by Eldor Turgunov on 26.08.2022.
 * Coroutines mvc
 * eldorturgunov777@gmail.com
 */
class PostAdapter(var context: Context, var list: List<Post>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post: Post = list[position]
        if (holder is ViewHolder) {
            holder.title.text = post.title
            holder.body.text = post.body
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    internal class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var body: TextView

        init {
            title = itemView.findViewById(R.id.title)
            body = itemView.findViewById(R.id.body)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setPostData(list: ArrayList<Post>) {
        this.list = list
        notifyDataSetChanged()
    }
}