package com.trinitydigital.bottomnav

import android.os.Bundle
import android.view.View
import com.trinitydigital.bottomnav.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_detail_snow.*

class DetailsSnowFragment : BaseFragment() {

    override fun resID() = R.layout.fragment_detail_snow

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = DetailsSnowFragmentArgs.fromBundle(requireArguments())
        tvTitle.text = bundle.details?.title
        tvDesc.text = bundle.details?.desc

    }
}