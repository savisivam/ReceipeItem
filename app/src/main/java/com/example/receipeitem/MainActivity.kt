package com.example.receipeitem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.receipeitem.adapter.ViewPagerAdapter
import com.fxn.BubbleTabBar
import com.fxn.OnBubbleClickListener
import com.fxn.ariana.ArianaBackgroundListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var bubbleTabBar: BubbleTabBar
    lateinit var viewpager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bubbleTabBar=findViewById(R.id.bubbleTabBar)
        viewpager=findViewById(R.id.viewpager)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels
        Log.e("height", "-> " + height)
        Log.e("width", "-> " + width)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        bubbleTabBar.addBubbleListener(object : OnBubbleClickListener {
            override fun onBubbleClick(id: Int) {
                when(id){
                    R.id.navigation_home->viewpager.currentItem=0
                    R.id.navigation_category -> viewpager.currentItem = 1
                    R.id.navigation_cart->viewpager.currentItem=2
                }
            }

        })
        bubbleTabBar.setupBubbleTabBar(viewpager)
        viewpager.adapter = ViewPagerAdapter(supportFragmentManager).apply {
            list = ArrayList<String>().apply {
                add("Home")
                add("Logger")
                add("Contacts")
            }
        }
        viewpager.addOnPageChangeListener(
            ArianaBackgroundListener(
                getColors(),
                iv,
                viewpager
            )
        )

    }

    private fun getColors(): IntArray {
        return intArrayOf(
            ContextCompat.getColor(this, R.color.navigation_view),
            ContextCompat.getColor(this, R.color.navigation_view),
            ContextCompat.getColor(this, R.color.navigation_view)
            )
    }
    }

