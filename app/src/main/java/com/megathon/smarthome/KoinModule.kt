package com.megathon.smarthome

import com.megathon.smarthome.ui.home.viewmodel.AppliancesUpdateRepo
import com.megathon.smarthome.ui.home.viewmodel.HomeViewModel
import com.megathon.smarthome.ui.login.LoginRepo
import com.megathon.smarthome.ui.login.SigninViewmodel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val loginModule = module {

    single { LoginRepo() }

    // MyViewModel ViewModel
    viewModel{SigninViewmodel(get())}
}
val appliancesModule = module {

    single { AppliancesUpdateRepo() }

    // MyViewModel ViewModel
    viewModel{HomeViewModel(get())}
}
