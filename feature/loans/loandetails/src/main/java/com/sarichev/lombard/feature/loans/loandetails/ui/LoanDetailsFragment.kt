package com.sarichev.lombard.feature.loans.loandetails.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.sarichev.lombard.component.loans.commonclasses.ui.BaseFragment
import com.sarichev.lombard.component.loans.resources.R
import com.sarichev.lombard.feature.loans.loandetails.databinding.FragmentLoanDetailsBinding
import com.sarichev.lombard.feature.loans.loandetails.presentation.LoanDetailsViewModel
import com.sarichev.lombard.shared.loans.core.domain.entity.Loan
import com.sarichev.lombard.shared.loans.core.domain.entity.LoanStatus
import com.sarichev.lombard.shared.loans.core.presentation.transportmodel.LoanTransportModel
import com.sarichev.lombard.shared.loans.core.presentation.transportmodel.toEntity
import com.sarichev.lombard.shared.loans.core.presentation.transportmodel.toTransportModel
import com.sarichev.lombard.util.loans.ui.getDateOnly
import java.text.NumberFormat

class LoanDetailsFragment : BaseFragment<FragmentLoanDetailsBinding, LoanDetailsViewModel>(
    R.string.loan_details_title, LoanDetailsViewModel::class.java, FragmentLoanDetailsBinding::inflate
) {

    companion object {
        @JvmStatic
        fun newInstance(loan: Loan) = LoanDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(LOAN, loan.toTransportModel())
            }
        }

        private const val LOAN = "extra_loan"
    }

    private var _loan: Loan? = null
    private val loan get() = _loan ?: throw RuntimeException("Loan is null!")

    private fun parseArguments() {
        val args = requireArguments()
        if (args.containsKey(LOAN)) {
            _loan = (args.getParcelable(LOAN) as? LoanTransportModel)?.toEntity()
        } else {
            throw RuntimeException("Loan argument is absent")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArguments()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPhoneClickListener()
        setUpBackButton()
        fillInfoFields(loan)
    }

    private fun fillInfoFields(loanInfo: Loan) {
        val numberFormat = NumberFormat.getInstance()

        with(binding) {
            textViewAmount.text =
                getString(R.string.amount_template, numberFormat.format(loanInfo.amount))
            textViewId.text = loanInfo.id.toString()
            textViewDate.text = getDateOnly(loanInfo.date)
            textViewName.text =
                getString(R.string.name_lastname_template, loanInfo.firstName, loanInfo.lastName)
            textViewPercent.text = getString(R.string.percent_template, loanInfo.percent)
            textViewPeriod.text = getString(R.string.period_days_only_template, loanInfo.period)
            textViewPhone.text = loanInfo.phoneNumber
            textViewStatus.text = when (loanInfo.status) {
                LoanStatus.REGISTERED -> getString(R.string.registered)
                LoanStatus.APPROVED -> getString(R.string.approved)
                LoanStatus.REJECTED -> getString(R.string.rejected)
            }
        }
    }

    private fun setUpPhoneClickListener() {
        binding.textViewBankPhone.setOnClickListener {
            Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse(getString(R.string.bank_phone_uri))
                startActivity(this)
            }
        }
    }

    private fun setUpBackButton() {
        binding.buttonBack.setOnClickListener {
            viewModel.openLoansListScreen()
        }
    }
}