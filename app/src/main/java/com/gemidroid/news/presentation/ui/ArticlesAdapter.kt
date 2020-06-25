package com.gemidroid.news.presentation.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.gemidroid.news.R
import com.gemidroid.news.base.dateFormatter
import com.gemidroid.news.data.entities.Articles
import kotlinx.android.synthetic.main.article_item.view.*

class ArticlesAdapter(private val articles: List<Articles>, private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent,false)
        return object: ViewHolder(rootView){}
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        holder.itemView.articleTitle.text = article.title
        holder.itemView.articlePublishDate.text = String.format(context.getString(R.string.date),
            dateFormatter(article.publishDate))
        if(article.author!=null) holder.itemView.articleAuthor.text =
                               String.format(context.getString(R.string.writtenBy), article.author)
        holder.itemView.articleDescription.text = article.description
        holder.itemView.articleLogo.setImageURI(article.imgUrl)
    }
}