package com.olskrain.mvvmtestproject.presentation.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LifecycleObserver
import com.olskrain.mvvmtestproject.domain.entity.User

/**
 * Интерфейс ViewModel обеспечивает двусторонную связь с View через ObservableField
 */
interface UserViewModel: LifecycleObserver {
    //Методы, которые вызывает View аналогичны методам презентера из MVP

    fun onStart()
    fun onStop()
    fun onUserAction()

    //поля данных, на которые подписывается View чтобы потом отобразить
    //ObservableField не имеет отношение к RxJava

    fun getUser(): ObservableField<User>
    fun getError(): ObservableField<String>
    fun getResult(): ObservableField<String>
}