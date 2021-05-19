package me.texy.treeviewdemo

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import me.texy.treeviewdemo.databinding.ActivityMainBinding
import me.texy.treeviewdemo.ui.screen.hone.CompetitionFragment

@AndroidEntryPoint
open class MainActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var activityMainBinding: ActivityMainBinding
    var member: Int? = null
    val value by lazy {
        member = 6
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        test(value)
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        findViewById<BottomNavigationView>(R.id.bottom_nav)
//            .setupWithNavController(navController)
        supportFragmentManager.beginTransaction()
            .add(R.id.nav_host_fragment, CompetitionFragment())
            .commit()
        activityMainBinding.bottomNav.setOnNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.competitions -> {
                val competitionFragment = CompetitionFragment()
                show(competitionFragment)
                return true
            }
        }
        return false
    }

    private fun show(fragment: Fragment) {

        val fragmentManager = supportFragmentManager

        fragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }

    fun test(value: Any) {
        Log.d("TAG999", "test:  " + member)
    }
}