package com.example.quotesapp.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.BR
import com.example.quotesapp.R
import com.example.quotesapp.databinding.QuoteItemBinding
import com.example.quotesapp.model.QuotesData

class QuotesAdapter() :
    RecyclerView.Adapter<QuotesAdapter.ViewHolder>() {

    private var quotes = ArrayList<QuotesData>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<QuotesData>?) {
        data?.let {
            this.quotes = data as ArrayList<QuotesData>
            notifyDataSetChanged()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // val view = LayoutInflater.from(parent.context).inflate(R.layout.quote_item, parent, false)
        val view: QuoteItemBinding = DataBindingUtil.inflate<QuoteItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.quote_item,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(quotes[position])
    }

    override fun getItemCount(): Int {
        return quotes.size
    }

    class ViewHolder(private val v: QuoteItemBinding) : RecyclerView.ViewHolder(v.root) {
        //        private val quote = v.findViewById<TextView>(R.id.quote)
//        private val author = v.findViewById<TextView>(R.id.author)
//        private val id = v.findViewById<TextView>(R.id.quote_id)
//        private val series = v.findViewById<TextView>(R.id.series)
        fun bindItem(data: QuotesData) {
            v.setVariable(BR.quoteDetails, data)
        }
    }
}