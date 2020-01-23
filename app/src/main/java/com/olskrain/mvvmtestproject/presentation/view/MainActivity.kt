package com.olskrain.mvvmtestproject.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.olskrain.mvvmtestproject.R
import com.olskrain.mvvmtestproject.data.datasource.UserDataSourceImpl
import com.olskrain.mvvmtestproject.data.repository.UserRepositoryImpl
import com.olskrain.mvvmtestproject.databinding.UserActivityBinding
import com.olskrain.mvvmtestproject.domain.usecase.GetUserModelUseCaseImpl
import com.olskrain.mvvmtestproject.presentation.viewmodel.UserViewModel
import com.olskrain.mvvmtestproject.presentation.viewmodel.UserViewModelImpl

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //сначала мы создаем ViewModel
        createViewModel()

        // UserActivityBinding -- сгенерированный класс, который выполняет всю работу по связыванию
        // Java-кода и XML разметки
        val binding: UserActivityBinding = DataBindingUtil.setContentView(this, R.layout.user_activity)
        // здесь производится связывание XML разметки и ViewModel
        // почти всё взаимодействие View и ViewModel описано в XML
        binding.viewModel = userViewModel
    }

    private fun createViewModel() {
        val userDataSource = UserDataSourceImpl()
        val userRepository = UserRepositoryImpl(userDataSource)
        val getUserModelUseCase = GetUserModelUseCaseImpl(userRepository)
        userViewModel = UserViewModelImpl(getUserModelUseCase)
    }

    override fun onStart() {
        super.onStart()
        //При старте активити запускаем viewModel в работу
        userViewModel.onStart()
    }

    override fun onStop() {
        super.onStop()
        userViewModel.onStop()
    }
}
