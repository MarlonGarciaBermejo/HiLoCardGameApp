package com.firstapp.hilocardgameapp
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PlayerRecyclerAdapter(val context: Context, val player: List<Player>) : RecyclerView.Adapter<PlayerRecyclerAdapter.ViewHolder>() {

    var layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.score_list, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount() = player.size

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val playerTextView = itemView.findViewById<TextView>(R.id.playerName)
        val scoreTextView = itemView.findViewById<TextView>(R.id.scoreList)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = player[position]

        holder.playerTextView.text = player.name
        holder.scoreTextView.text = player.score.toString()
    }

    }



