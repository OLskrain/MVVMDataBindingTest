package com.olskrain.mvvmtestproject.data.repository

import com.olskrain.mvvmtestproject.data.datasource.UserDataSource
import com.olskrain.mvvmtestproject.domain.entity.User
import com.olskrain.mvvmtestproject.domain.repository.UserRepository
import io.reactivex.Single

/**
 * Created by Andrey Ievlev on 21,Январь,2020
 */
class UserRepositoryImpl(private val userDataSource: UserDataSource): UserRepository {
    override fun getUser(): Single<User> =
        userDataSource.getUser()
}