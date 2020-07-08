package com.molivaress.listviewsample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.poll_item.view.*

class PollArrayAdapter(
    context: Context,
    private val resourceId: Int,
    private val pollList: List<Poll>
) : ArrayAdapter<Poll>(context, resourceId) {
    private val inflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = inflater.inflate(resourceId, parent, false)
        view.tvTitle.text = pollList[position].title
        view.tvBody.text = pollList[position].body
        return view
    }

    override fun getCount() = pollList.size

}