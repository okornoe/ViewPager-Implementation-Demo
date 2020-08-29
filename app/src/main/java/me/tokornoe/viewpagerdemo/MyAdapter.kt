package me.tokornoe.viewpagerdemo

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int):
    FragmentPagerAdapter(fm, totalTabs) {
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                HomeFragment()
            }
            1 -> {
                SportFragment()
            }
            2 -> {
                // val movieFragment = MovieFragment()
                MovieFragment()
            }
            //else -> null
            else -> HomeFragment()
        }
    }

}