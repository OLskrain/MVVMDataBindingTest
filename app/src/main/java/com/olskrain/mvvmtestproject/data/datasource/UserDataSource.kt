package com.olskrain.mvvmtestproject.data.datasource

import com.olskrain.mvvmtestproject.domain.entity.User
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * Created by Andrey Ievlev on 21,Январь,2020
 */

interface UserDataSource {
    fun getUser(): Single<User>
}

class UserDataSourceImpl: UserDataSource {

    override fun getUser(): Single<User> =
        Single.just(User("Andrey", "Ievlev", 29))
            .subscribeOn(Schedulers.io())
}