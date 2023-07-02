package com.adorable.setiket.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.adorable.setiket.R
import com.adorable.setiket.model.OnBoardingdata

class OnBoardingViewPagerAdapter(private var  context: Context, private var onBoardingdataList: List<OnBoardingdata>) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return onBoardingdataList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as View)

    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view:View = LayoutInflater.from(context).inflate(R.layout.onboarding_screen_layout, null);
        val imageView: ImageView
        val titlenya: TextView
        val desc : TextView

        imageView = view.findViewById(R.id.imageView);
        titlenya = view.findViewById(R.id.titlenya);
        desc = view.findViewById(R.id.desc);

        imageView.setImageResource(onBoardingdataList[position].imageUrl)
        titlenya.text = onBoardingdataList[position].titlenya
        desc.text = onBoardingdataList[position].desc

        container.addView(view)
        return view
    }
}