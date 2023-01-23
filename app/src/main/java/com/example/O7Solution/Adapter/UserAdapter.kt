package com.example.O7Solution.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.O7Solution.R
import com.example.O7Solution.data.User

class UserAdapter:RecyclerView.Adapter<UserAdapter.viewHolder>() {
    private var userList= emptyList<User>()
    class viewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var tvFname: TextView
        var tvLname: TextView
        var tvAge:TextView
        init {
            tvFname = itemView.findViewById<TextView>(R.id.tvFirstName)
            tvLname = itemView.findViewById<TextView>(R.id.tvLastName)
            tvAge = itemView.findViewById<TextView>(R.id.tvAge)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
return viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_list,parent,false))
    }

    override fun onBindViewHolder(holder: UserAdapter.viewHolder, position: Int) {
    val userList= userList[position]
        holder.tvFname.text=userList.firstnameval
    }

    override fun getItemCount(): Int {
return userList.size
    }

}