package com.olskrain.mvvmtestproject.domain.repository

import com.olskrain.mvvmtestproject.domain.entity.User
import io.reactivex.Single

/**
 * Created by Andrey Ievlev on 21,Январь,2020
 */
interface UserRepository {
    fun getUser(): Single<User>
}