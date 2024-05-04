package com.example.mygenerics.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

// Source : https://stackoverflow.com/a/73517663
abstract class BaseFragment<T : ViewBinding>(
    private val viewBindingInflater: (
        inflater: LayoutInflater,
        parent: ViewGroup?,
        attachToParent: Boolean
    ) -> T
) : Fragment() {


    lateinit var viewBinding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = viewBindingInflater(inflater, container, false)
        return viewBinding.root
    }
}