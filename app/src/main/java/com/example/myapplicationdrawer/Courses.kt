package com.example.myapplicationdrawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Courses : Fragment() {
    private lateinit var recyclerView:RecyclerView
    private lateinit var RecyclerviewadapterCourses:RecyclerviewadapterCourses
    private lateinit var courseArrayList:ArrayList<courseclass>
    lateinit var imageId:Array<Int>
    lateinit var title:Array<String>
    lateinit var course:Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_courses, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preparecourseslistdata()
        val layoutManager=GridLayoutManager(context,2)
        recyclerView=view.findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        RecyclerviewadapterCourses=RecyclerviewadapterCourses(courseArrayList)
        recyclerView.adapter=RecyclerviewadapterCourses
    }




    private fun preparecourseslistdata() {
        courseArrayList= arrayListOf<courseclass>()
        imageId= arrayOf(
            R.drawable.python,
            R.drawable.go2,
            R.drawable.zig,
            R.drawable.swift,
            R.drawable.cplus,R.drawable.html,R.drawable.php,
            R.drawable.dart,R.drawable.ruby,R.drawable.java,
            R.drawable.rust,R.drawable.chash,R.drawable.clanguage1)
        title= arrayOf(
            getString(R.string.python),
            getString(R.string.go),
            getString(R.string.zig),
            getString(R.string.swift),
            getString(R.string.cplus),
            getString(R.string.html),
            getString(R.string.php),
            getString(R.string.dart),
            getString(R.string.ruby),
            getString(R.string.java),
            getString(R.string.rust),
            getString(R.string.csharp),
            getString(R.string.c),
        )
        for (i in imageId.indices){
            val course=courseclass(title[i],imageId[i])
            courseArrayList.add(course)
        }



    }


}