package ru.tinkoff.edu.popularfilms.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.tinkoff.edu.popularfilms.databinding.ActivityMainBinding
import ru.tinkoff.edu.popularfilms.network.NetworkUtils
import ru.tinkoff.edu.popularfilms.ui.fragments.FilmFragment
import ru.tinkoff.edu.popularfilms.ui.fragments.NoInternetFragment
import ru.tinkoff.edu.popularfilms.ui.fragments.SearchFragment

class MainActivity : AppCompatActivity() {

    private val networkUtil = NetworkUtils(this)

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    fun onSearchButtonClick(item: MenuItem) {
        val searchFragment = SearchFragment.newInstance()
        val noInternetFragment = NoInternetFragment.newInstance()
        checkForInet(searchFragment, noInternetFragment, "search")
    }

    override fun onResume() {
        super.onResume()
        networkUtil.register()
    }

    private fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(binding.mainScreenContainer.id, fragment, tag)
            .commit()
    }

    private fun checkForInet(fragmentInfo: Fragment, noInternetFragment: NoInternetFragment, tag:String) {
         networkUtil.result = { isAvailable, type ->
            runOnUiThread {
                when (isAvailable) {
                    true -> {
                        binding.buttonLayout.visibility = View.VISIBLE
                        replaceFragment(fragmentInfo, tag)
                    }
                    else -> {
                        binding.buttonLayout.visibility = View.INVISIBLE
                        replaceFragment(noInternetFragment, "error")
                    }
                }
            }
        }
    }
    private fun loadData() {
        val filmFragment = FilmFragment.newInstance()
        val noInternetFragment = NoInternetFragment.newInstance()
        checkForInet(filmFragment, noInternetFragment, "films")
    }

    override fun onStop() {
        super.onStop()
        networkUtil.unregister()
    }

    companion object {

        fun createIntent(activity: FilmInfoActivity): Intent
        = Intent(activity, MainActivity::class.java)
    }

}