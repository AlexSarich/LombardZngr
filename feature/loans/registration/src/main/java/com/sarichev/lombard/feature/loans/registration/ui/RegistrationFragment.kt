package com.sarichev.lombard.feature.loans.registration.ui

import android.animation.AnimatorSet
import android.os.Bundle
import android.view.View
import com.sarichev.lombard.component.loans.commonclasses.presentation.state.ErrorEvent
import com.sarichev.lombard.component.loans.commonclasses.presentation.state.ScreenState
import com.sarichev.lombard.component.loans.commonclasses.ui.BaseFragment
import com.sarichev.lombard.component.loans.resources.R
import com.sarichev.lombard.feature.loans.registration.databinding.FragmentRegistrationBinding
import com.sarichev.lombard.feature.loans.registration.presentation.RegistrationViewModel
import com.sarichev.lombard.util.loans.ui.enableTogglePasswordVisibility
import com.sarichev.lombard.util.loans.ui.shakeAnimator
import com.sarichev.lombard.util.loans.ui.showSnackbar

class RegistrationFragment : BaseFragment<FragmentRegistrationBinding, RegistrationViewModel>(
    R.string.loans_title, RegistrationViewModel::class.java, FragmentRegistrationBinding::inflate
) {

    companion object {
        @JvmStatic
        fun newInstance() = RegistrationFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareButtons()
        prepareTogglePasswordVisibility()
        observeState()
        observeErrorEvents()
    }

    private fun prepareButtons() {
        with(binding) {
            binding.buttonRegister.setOnClickListener {
                viewModel.register(
                    editTextName.text.toString(),
                    editTextPassword.text.toString()
                )
            }
            binding.buttonAlreadyRegistered.setOnClickListener {
                viewModel.openLogInScreen()
            }
        }
    }

    private fun prepareTogglePasswordVisibility() {
        enableTogglePasswordVisibility(
            binding.editTextPassword,
            binding.buttonTogglePasswordVisibility,
            R.drawable.ic_eye_off,
            R.drawable.ic_eye_on
        )
    }

    private fun observeState() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ScreenState.Initial -> {}

                is ScreenState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.constraintLayoutContent.visibility = View.GONE
                }

                is ScreenState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.constraintLayoutContent.visibility = View.VISIBLE
                }

                is ScreenState.Content -> {
                    binding.progressBar.visibility = View.GONE
                    binding.constraintLayoutContent.visibility = View.VISIBLE
                }

                is ScreenState.Success -> {
                    view?.showSnackbar(getString((R.string.registered_successfully)))
                    viewModel.openLogInScreen()
                }
            }
        }
    }

    private fun observeErrorEvents() {
        viewModel.errorEvent.observe(viewLifecycleOwner) { event ->
            val message = when (event) {
                is ErrorEvent.NetworkError -> getString(R.string.network_error_occurred)
                is ErrorEvent.ServerError -> getString(R.string.server_error_occurred)
                is ErrorEvent.UserAlreadyExists -> getString(R.string.username_occupied)
                is ErrorEvent.EmptyFields -> {
                    shakeInputFields()
                    getString(R.string.fill_all_fields)
                }

                else -> throw RuntimeException("Unexpected event: $event")
            }
            view?.showSnackbar(message)
        }
    }

    private fun shakeInputFields() {
        AnimatorSet().apply {
            val nameFieldAnimator = shakeAnimator(binding.editTextName)
            val passwordFieldAnimator = shakeAnimator(binding.editTextPassword)
            val toggleButtonAnimator = shakeAnimator(binding.buttonTogglePasswordVisibility)
            playTogether(nameFieldAnimator, passwordFieldAnimator, toggleButtonAnimator)
            start()
        }
    }
}