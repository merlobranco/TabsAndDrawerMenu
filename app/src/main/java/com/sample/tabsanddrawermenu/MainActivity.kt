package com.sample.tabsanddrawermenu

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.sample.tabsanddrawermenu.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.content_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var pagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // Data binding
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        // Setting the toolbar
        val toolbar = binding.contentMain.toolbar
        setSupportActionBar(toolbar)

        viewPager = binding.contentMain.view_pager
        tabLayout = binding.contentMain.tab_layout
        configureTabLayout()

        // Drawer Layout
        drawerLayout = binding.drawerLayout
        navigationView = binding.navView
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = true
        toggle.syncState()
    }
    private fun configureTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.first_item_title)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.second_item_title)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.third_item_title)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.fourth_item_title)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.fifth_item_title)))
        // Tab Item Page Manager
        pagerAdapter = PagerAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
            tabLayout.tabCount
        )
        viewPager.adapter = pagerAdapter
        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }
}
