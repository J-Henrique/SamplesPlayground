package co.tiagoaguiar.tutorial.myfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.tiagoaguiar.tutorial.myfood.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    setupViews()
  }

  private fun setupViews() {
    val tabLayout = binding.addTab
    val viewPager = binding.addViewPager
    val adapter = TabViewPagerAdapter(this)
    viewPager.adapter = adapter
    viewPager.isUserInputEnabled = false
    TabLayoutMediator(tabLayout, viewPager) { tab, position ->
      tab.text = getString(adapter.tabs[position])
    }.attach()
  }
}