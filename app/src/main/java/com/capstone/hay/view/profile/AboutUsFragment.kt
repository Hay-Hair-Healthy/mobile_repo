package com.capstone.hay.view.profile

import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.capstone.hay.R
import com.capstone.hay.databinding.FragmentAboutUsBinding
import com.google.android.material.appbar.MaterialToolbar

class AboutUsFragment : Fragment() {
    private var _binding: FragmentAboutUsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutUsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = binding.aboutUsText
        val aboutUsText = getString(R.string.about_us_text)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.text = Html.fromHtml(aboutUsText, Html.FROM_HTML_MODE_COMPACT)
        } else {
            @Suppress("DEPRECATION")
            textView.text = Html.fromHtml(aboutUsText)
        }

        setupActionBack()
    }

    private fun setupActionBack() {
        val topAppBar: MaterialToolbar = binding.topAppBar
        (requireActivity() as AppCompatActivity).setSupportActionBar(topAppBar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        topAppBar.setNavigationOnClickListener {
            @Suppress("DEPRECATION")
            requireActivity().onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}