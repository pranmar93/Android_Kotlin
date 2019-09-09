package com.example.firstapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.UserListBinding

class UserAdapter(private val userList: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: UserListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.user_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userListBinding.user = userList[position]
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: UserListBinding) : RecyclerView.ViewHolder(itemView.root) {

        var userListBinding: UserListBinding = itemView
    }
}