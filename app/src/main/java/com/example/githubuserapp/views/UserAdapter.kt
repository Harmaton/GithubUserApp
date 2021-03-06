package com.example.githubuserapp.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.githubuserapp.data.model.User
import com.example.githubuserapp.databinding.ItemUserBinding

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private val list = ArrayList<User>()
    fun setList(users: ArrayList<User>){
        list.clear()
        list.addAll(users)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(val binding : ItemUserBinding) : RecyclerView.ViewHolder(binding.root){
      fun bind(user: User){
          binding.apply {
              Glide.with(itemView)
                  .load(user.avatarurl)
                  .transition(DrawableTransitionOptions.withCrossFade())
                  .centerCrop()
                  .into(imgUser)

              userName.text=user.login
          }

      }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
     val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context))
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
     holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}