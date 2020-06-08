package com.example.destiny_app.destiny
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.destiny_app.R
import com.example.destiny_app.databinding.FragmentDestinyBinding

class DestinyFragment: Fragment() {

    private lateinit var binding: FragmentDestinyBinding
    private lateinit var viewModel: DestinyViewModel
    private lateinit var viewModelFactory: DestinyViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_destiny, container, false)
        binding.lifecycleOwner = this

        viewModelFactory = DestinyViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DestinyViewModel::class.java)
        binding.viewModel = viewModel

        return binding.root
    }
}