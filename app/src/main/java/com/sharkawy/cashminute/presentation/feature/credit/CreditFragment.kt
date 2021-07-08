package com.sharkawy.cashminute.presentation.feature.credit

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.sharkawy.cashminute.R
import com.sharkawy.cashminute.databinding.FragmentCreditBinding
import com.sharkawy.cashminute.domain.repositories.credit.creditRepository
import com.sharkawy.cashminute.presentation.core.isOnline
import com.sharkawy.cashminute.presentation.core.onSnack


class CreditFragment : Fragment() {
    private var _binding: FragmentCreditBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CreditViewModel by viewModels {
        CreditViewModelFactory(
            (creditRepository)
        )
    }

    private lateinit var progress: ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCreditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fireClickListeners()

        setupObservers()

    }

    private fun setupObservers() {
        viewModel.message.observe(viewLifecycleOwner, Observer {
            if (progress.isShowing) progress.dismiss()
            onSnack(binding.root, it)
        })
    }

    private fun fireClickListeners() {
        binding.sendVg.setOnClickListener {
            if (isOnline(requireContext())) {
                if (validateInputs(
                        binding.cardNumberInput.text.toString(),
                        binding.recipientCardNumberInput.text.toString(),
                        binding.cardDateMonthInput.text.toString(),
                        binding.cardDateYearInput.text.toString(),
                        binding.cardCvvInput.text.toString()
                    )
                ) {
                    showLoading()
                    sendCreditPayload()
                }
            } else {
                onSnack(binding.root, getString(R.string.internet_connection_error))
            }
        }

    }

    private fun validateInputs(
        senderCardNumber: String, recipientCarNumber: String,
        month: String, year: String, cvv: String
    ): Boolean {
        return if (senderCardNumber.isEmpty()
            || recipientCarNumber.isEmpty()
            || month.isEmpty()
            || year.isEmpty()
            || cvv.isEmpty()
        ) {
            onSnack(binding.root, getString(R.string.empty_fields_error))
            false
        } else {
            true
        }
    }

    private fun sendCreditPayload() {
        val body: MutableMap<String, String> = mutableMapOf()
        body["senderCardNo"] = binding.cardNumberInput.text.toString()
        body["recipientCardNo"] = binding.recipientCardNumberInput.text.toString()
        body["senderCardExpireMonth"] = binding.cardDateMonthInput.text.toString()
        body["senderCardExpireYear"] = binding.cardDateYearInput.text.toString()
        body["senderCardCVV"] = binding.cardCvvInput.text.toString()
        body["amount"] = binding.amountTv.text.toString()
        viewModel.sendCreditPayload(body)
    }


    private fun showLoading() {
        progress = ProgressDialog(activity)
        progress.setTitle("Transfer amount")
        progress.setMessage("Waiting...")
        progress.setCancelable(false)
        progress.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}