package com.example.myapplicationdrawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.myapplicationdrawer.databinding.FragmentHomeBinding

class Home : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var imageList: List<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val rootView = binding.root

        // Initialize view pager and image list
        viewPager = rootView.findViewById(R.id.idViewPager)
        imageList = mutableListOf(
            R.drawable.chash,
            R.drawable.cplus,
            R.drawable.java,
            R.drawable.go2,
            R.drawable.python
        )

        // Initialize view pager adapter and set it to the view pager
        context?.let {
            viewPagerAdapter = ViewPagerAdapter(it, imageList)
            viewPager.adapter = viewPagerAdapter
        }

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
