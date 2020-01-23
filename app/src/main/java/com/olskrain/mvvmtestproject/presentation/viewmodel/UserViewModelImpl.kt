package com.olskrain.mvvmtestproject.presentation.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.olskrain.mvvmtestproject.domain.entity.User
import com.olskrain.mvvmtestproject.domain.usecase.GetUserModelUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy

/**
 * Created by Andrey Ievlev on 20,Январь,2020
 */

//Реализация View
class UserViewModelImpl(
    private val getUserModelUseCase: GetUserModelUseCase
): UserViewModel {
    /**
     * В отличие от презентера из MVP, ViewModel не содержит ссылок на View
     * Работа с моделью аналогична MVP
     */
    // обозреваемые поля данных, на которые подпишется View
    private val userObservableField: ObservableField<User> = ObservableField()
    private val errorObservableField: ObservableField<String> = ObservableField()
    private val resultObservableField: ObservableField<String> = ObservableField()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    override fun onStart() {
        getUserModelUseCase.invoke()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { userObservableField.set(it) },
                onError = { errorObservableField.set("Error!") }
            )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    override fun onStop() {
        //Тут делаем отписки и все такое
    }

    override fun onUserAction() =
        resultObservableField.set("Result!")

    override fun getUser(): ObservableField<User> =
        userObservableField

    override fun getError(): ObservableField<String> =
        errorObservableField

    override fun getResult(): ObservableField<String> =
        resultObservableField
}