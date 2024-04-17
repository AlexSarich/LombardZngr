package com.sarichev.lombard.feature.loans.settings.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import com.sarichev.lombard.component.loans.commonclasses.ui.BaseFragment
import com.sarichev.lombard.component.loans.resources.R
import com.sarichev.lombard.feature.loans.settings.databinding.FragmentSettingsBinding
import com.sarichev.lombard.feature.loans.settings.presentation.AppLanguageManager
import com.sarichev.lombard.feature.loans.settings.presentation.SettingsViewModel


class SettingsFragment : BaseFragment<FragmentSettingsBinding, SettingsViewModel>(
    R.string.settings_title, SettingsViewModel::class.java, FragmentSettingsBinding::inflate
) {

    private lateinit var languageManager: AppLanguageManager


    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        languageManager = AppLanguageManager(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpButtons()
    }

    private fun setUpButtons() {
        with(binding) {
            buttonBack.setOnClickListener {
                viewModel.openLoansListScreen()
            }
            buttonLogOut.setOnClickListener {
                viewModel.logOut()
            }
            buttonEnglishLanguage.setOnClickListener {
                changeLanguage(AppLanguageManager.LANGUAGE_ENGLISH)
            }
            buttonRussianLanguage.setOnClickListener {
                changeLanguage(AppLanguageManager.LANGUAGE_RUSSIAN)
            }
            when(languageManager.getCurrentLanguage()) {
                AppLanguageManager.LANGUAGE_ENGLISH -> buttonEnglishLanguage.isEnabled = false
                AppLanguageManager.LANGUAGE_RUSSIAN -> buttonRussianLanguage.isEnabled = false
            }
        }
    }

    private fun changeLanguage(language: String) {
        languageManager.setCurrentLanguage(language)
        activity?.recreate()
    }
}