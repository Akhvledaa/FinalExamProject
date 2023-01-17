package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val contactsFragment = ContactsFragment()
        val profileFragment = ProfileFragment()

        setCurrentFragment(homeFragment)

        val BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        BottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.MIhome -> setCurrentFragment(homeFragment)
                R.id.MIcontacts -> setCurrentFragment(contactsFragment)
                R.id.MIProfile -> setCurrentFragment(profileFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.FLfragment, fragment)
            commit()
        }
}