package com.example.O7Solution.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.O7Solution.ClickedInterface
import com.example.O7Solution.R
import com.example.O7Solution.data.User

class UserAdapter(var ClickedInterface:ClickedInterface):RecyclerView.Adapter<UserAdapter.viewHolder>() {
    private var userList= emptyList<User>()

    class viewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var tvFname: TextView
        var tvLname: TextView
        var tvAge:TextView
        var tvId:TextView
        var btnDelete:Button
        var btnUpdate:Button
        init {
            tvFname = itemView.findViewById<TextView>(R.id.tvFirstName)
            tvLname = itemView.findViewById<TextView>(R.id.tvLastName)
            tvAge = itemView.findViewById<TextView>(R.id.tvAge)
            tvId=itemView.findViewById(R.id.tvId)
            btnDelete=itemView.findViewById(R.id.btnDelete)
            btnUpdate=itemView.findViewById(R.id.btnUpdate)



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
return viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_list,parent,false))
    }

    override fun onBindViewHolder(holder:viewHolder, position: Int) {
    val newList= userList[position]
        holder.tvId.text= newList.id.toString()
        holder.tvFname.text=newList.firstname
        holder.tvLname.text=newList.lastname
        holder.tvAge.text=newList.age.toString()
        holder.btnDelete.setOnClickListener {

            ClickedInterface.deleteClicked(newList)
        }
        holder.btnUpdate.setOnClickListener {

            ClickedInterface.updateClicked(newList)
        }

    }
    fun setData(user:List<User>){
        this.userList=user
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
return userList.size
    }

}