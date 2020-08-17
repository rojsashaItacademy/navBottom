package com.trinitydigital.bottomnav

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.trinitydigital.bottomnav.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_snow.*

class SnowFragment : BaseFragment(), RvListener {

    override fun resID() = R.layout.fragment_snow

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRV()
    }

    private fun setupRV() {
        val adapter = RvAdapter(this)
        recyclerView.adapter = adapter
        adapter.update(getData())
    }

    private fun getData(): ArrayList<Test> {
        val list = arrayListOf<Test>()

        for (i in 0..100) {
            list.add(Test("asdasdasdsad$i", "asdsadasdasdasdasd$i"))
        }

        return list
    }

    override fun goToDetails(data: Test) {
        val dest = SnowFragmentDirections.actionSnowFragmentToDetailsSnowFragment(data)
        findNavController().navigate(dest)
    }
}