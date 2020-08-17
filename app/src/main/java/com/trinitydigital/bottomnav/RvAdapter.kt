package com.trinitydigital.bottomnav

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.item_rv.view.*

class RvAdapter(private val listener: RvListener) : RecyclerView.Adapter<RVViewHoldwer>() {

    private val list = arrayListOf<Test>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHoldwer {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rv, parent, false)

        return RVViewHoldwer(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RVViewHoldwer, position: Int) {
        holder.bind(list[position], listener)
    }

    fun update(data: ArrayList<Test>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}


class RVViewHoldwer(v: View) : RecyclerView.ViewHolder(v) {
    fun bind(
        data: Test,
        listener: RvListener
    ) {
        itemView.setOnClickListener {
            listener.goToDetails(data)
        }
        itemView.tvTitle.text = data.title
        itemView.tvDesc.text = data.desc
    }
}

@Parcelize
data class Test(
    val title: String,
    val desc: String
) : Parcelable