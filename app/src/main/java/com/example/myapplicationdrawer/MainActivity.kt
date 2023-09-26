package com.example.myapplicationdrawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myapplicationdrawer.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var fragmentManager:FragmentManager
    private lateinit var binding: ActivityMainBinding
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)

        val toggle=ActionBarDrawerToggle(this,binding.DrawerLayout,binding.toolbar,R.string.nav_open,R.string.nav_close)
        binding.DrawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationDrawer.setNavigationItemSelectedListener(this)
        binding.bottomNavigation.background=null
        binding.bottomNavigation.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.bottom_home->openFragment(Home())
                R.id.bottom_courses->openFragment(Courses())
                R.id.bottom_Test->openFragment(assesment())


            }
            true
        }

        fragmentManager=supportFragmentManager
        openFragment(Home())
//        binding.fab.setOnClickListener{
//            Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show()
//        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_profile->openFragment(profile())
            R.id.nav_settings->openFragment(settings())
            R.id.logout->logout()

        }
        binding.DrawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (binding.DrawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.DrawerLayout.closeDrawer(GravityCompat.START)
        }else{
        super.getOnBackPressedDispatcher().onBackPressed()
        }
    }
    private fun openFragment(fragment: Fragment){
        val fragmentTransaction:FragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }
    private fun logout(){
        button=findViewById(R.id.logout)
        button.setOnClickListener{
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}