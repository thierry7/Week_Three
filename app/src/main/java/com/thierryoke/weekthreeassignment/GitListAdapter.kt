package com.thierryoke.weekthreeassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class GitListAdapter(val dataSet: List<Infos>, private val clickInterface: ClickInterface) : RecyclerView.Adapter<GitListAdapter.ViewHolderGit>(){

    class ViewHolderGit(val userItem: View): RecyclerView.ViewHolder(userItem){

        val userName: TextView = userItem.findViewById(R.id.tv_user_name_list)
        val image: ImageView = userItem.findViewById(R.id.user_avatar)

        fun onBind(gitUser: Infos) {
            userName.text = gitUser.login
            Picasso.get().load(gitUser.avatar_url).into(image)


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGit {
        return ViewHolderGit(LayoutInflater.from(parent.context).inflate(R.layout.search_items_list, parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolderGit, position: Int) {

        holder.onBind(dataSet[position])
        holder.userItem.setOnClickListener {
            clickInterface.onCellClickListener(position)
        }

    }

    override fun getItemCount(): Int {
       return dataSet.size
    }


}