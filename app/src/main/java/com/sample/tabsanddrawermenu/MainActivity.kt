package com.sample.tabsanddrawermenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.sample.tabsanddrawermenu.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.content_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var firstItem: TabItem
    private lateinit var secondItem: TabItem
    private lateinit var thirdItem: TabItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Data binding
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        // Setting the toolbar
        var toolbar = binding.contentMain.toolbar
        setSupportActionBar(toolbar)

        // Tab Layout
        viewPager = binding.contentMain.view_pager
        tabLayout = binding.contentMain.tab_layout
        firstItem = binding.contentMain.first_item
        secondItem = binding.contentMain.second_item
        thirdItem = binding.contentMain.third_item

        // Drawer Layout
        drawerLayout = binding.drawerLayout
        navigationView = binding.navView

        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = true
        toggle.syncState()
    }
}
