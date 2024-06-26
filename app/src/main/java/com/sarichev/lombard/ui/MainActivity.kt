package com.sarichev.lombard.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sarichev.lombard.R
import com.sarichev.lombard.component.loans.commonclasses.presentation.ViewModelFactory
import com.sarichev.lombard.feature.loans.settings.presentation.AppLanguageManager
import com.sarichev.lombard.navigation.LoanAppNavigator
import com.sarichev.lombard.presentation.MainViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val navigator = LoanAppNavigator(this, R.id.fragment_container)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    override fun attachBaseContext(newBase: Context) {
        //to set language, selected by user in settings
        super.attachBaseContext(AppLanguageManager(newBase).getContextForSelectedLanguage())
    }

    override fun onResume() {
        super.onResume()
        viewModel.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        viewModel.removeNavigator()
    }
}