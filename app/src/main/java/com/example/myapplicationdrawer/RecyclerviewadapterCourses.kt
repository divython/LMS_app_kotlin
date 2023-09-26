package com.example.myapplicationdrawer

import android.annotation.SuppressLint
import android.app.Activity
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.google.android.material.internal.ContextUtils.getActivity

class RecyclerviewadapterCourses(private val courseList:ArrayList<courseclass>):
RecyclerView.Adapter<RecyclerviewadapterCourses.MycourseHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerviewadapterCourses.MycourseHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.grid_layout_items,parent,false)
        return MycourseHolder(itemView)
    }

    @SuppressLint("RestrictedApi")
    override fun onBindViewHolder(
        holder: MycourseHolder,
        position: Int
    ) {
        holder.courseTitle.text= courseList[position].title.toString()
        holder.courseImage.setImageResource(courseList[position].image)
        holder.cardView.setOnClickListener{
//            Toast.makeText(MainActivity(),courseList[position].title,Toast.LENGTH_SHORT).show()

        }
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
    class MycourseHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val courseTitle:TextView=itemView.findViewById(R.id.courseTitle)
        val courseImage:ImageView=itemView.findViewById(R.id.courseImage)
        val cardView:CardView=itemView.findViewById(R.id.cardView)

    }

}

private fun ImageView.setImageResource(image: Array<Int>) {
    TODO("Not yet implemented")
}
