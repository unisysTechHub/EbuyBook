package com.unisytech.ebuybook.pager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.unisytech.ebuybook.R
import com.unisytech.ebuybook.network.response.Book

/**
 * Created by ramesh on 6/1/22.
 */
class BooksListPagingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       var textView : TextView = itemView.findViewById<TextView>(R.id.textView)

}
class BooksListPagingAdapter(private val context : Context, private val diffCallback: DiffUtil.ItemCallback<Book> = Companion.diffCallback) : PagingDataAdapter<Book, BooksListPagingViewHolder>(diffCallback) {
       companion object {
           val diffCallback = object  : DiffUtil.ItemCallback<Book>() {
               override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
                   return  oldItem === newItem
               }

               override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
                   return  oldItem.bookId == newItem.bookId
               }

           }
       }

    override fun onBindViewHolder(holder: BooksListPagingViewHolder, position: Int) {
         holder.textView.text = getItem(position)?.bookId.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksListPagingViewHolder {
         val view =   LayoutInflater.from(this.context).inflate(R.layout.recyclerview_item,parent,false)
        return BooksListPagingViewHolder(view)
    }



}