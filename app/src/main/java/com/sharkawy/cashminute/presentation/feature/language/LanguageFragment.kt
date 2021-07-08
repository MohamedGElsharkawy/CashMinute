package com.sharkawy.cashminute.presentation.feature.language

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sharkawy.cashminute.R
import com.sharkawy.cashminute.databinding.FragmentLanguageBinding


class LanguageFragment : Fragment() {
    private var _binding: FragmentLanguageBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLanguageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fireClickListeners()
    }

    private fun fireClickListeners() {
        binding.nextImg.setOnClickListener{
            findNavController().navigate(R.id.action_languageFragment_to_creditFragment2)
        }

        binding.langArBtn.setOnClickListener{
            findNavController().navigate(R.id.action_languageFragment_to_creditFragment2)
        }

        binding.langEnBtn.setOnClickListener{
            findNavController().navigate(R.id.action_languageFragment_to_creditFragment2)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}