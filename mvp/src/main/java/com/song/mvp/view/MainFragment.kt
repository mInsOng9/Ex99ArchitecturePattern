package com.song.mvp.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.song.mvp.databinding.FragmentMainBinding
import com.song.mvp.model.Item
import com.song.mvp.presenter.MainContract
import com.song.mvp.presenter.MainPresenter


class MainFragment : Fragment(), MainContract.View {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    //view의 역할
    lateinit var binding: FragmentMainBinding

    //presenter 객체 참조
    lateinit var presenter: MainPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter= MainPresenter()
        presenter.initial(this)
    }

    override fun showData(item: Item) {
        (activity as MainActivity).supportActionBar?.title= item.name
        (activity as MainActivity).supportActionBar?.subtitle= item.email
    }

    override fun getContext(): Context {
        return context
    }
}