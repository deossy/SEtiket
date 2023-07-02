package com.adorable.setiket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.adorable.setiket.adapter.OnBoardingViewPagerAdapter
import com.adorable.setiket.model.OnBoardingdata
import com.google.android.material.tabs.TabLayout

class Onboarding : AppCompatActivity() {

    var onBoardingViewPagerAdapter: OnBoardingViewPagerAdapter? = null
    var tabLayout: TabLayout? = null
    var onBoardingViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        tabLayout = findViewById(R.id.tab_indicator)

        //add some data to model class

        val onBoardingdata:MutableList<OnBoardingdata> = ArrayList()
        onBoardingdata.add(OnBoardingdata("Nyari Tiket?", "Aplikasi SE-Tiket adalah jawaban paling pas buat kamu yang lagi cari tiket travel!",R.drawable.satu))
        onBoardingdata.add(OnBoardingdata("Ada Tiket Apa?", "Aplikasi SE-Tiket menyediakan beberapa tiket untuk kamu diantaranya ada tiket kapal,tiket pesawat dan tiket kereta",R.drawable.dua))
        onBoardingdata.add(OnBoardingdata("Affa Iyah?", "Ril dik! Aplikasi SE-Tiket bisa bantuin kamu nyari tiket buat pergi keliling di Indonesia!",R.drawable.tiga))

        setOnBoardingViewPagerAdapter(onBoardingdata)
    }

    private fun setOnBoardingViewPagerAdapter(onBoardingdata: List<OnBoardingdata>){
        onBoardingViewPager = findViewById(R.id.screenPager);
        onBoardingViewPagerAdapter = OnBoardingViewPagerAdapter(this, onBoardingdata)
        onBoardingViewPager!!.adapter = onBoardingViewPagerAdapter
        tabLayout?.setupWithViewPager(onBoardingViewPager)

    }
}