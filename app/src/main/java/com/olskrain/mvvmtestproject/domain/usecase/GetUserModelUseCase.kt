package com.olskrain.mvvmtestproject.domain.usecase

import com.olskrain.mvvmtestproject.domain.entity.User
import com.olskrain.mvvmtestproject.domain.repository.UserRepository
import io.reactivex.Single

/**
 * Created by Andrey Ievlev on 21,Январь,2020
 */
interface GetUserModelUseCase {
    operator fun invoke(): Single<User>
}

class GetUserModelUseCaseImpl(private val userRepository: UserRepository): GetUserModelUseCase {
    override fun invoke(): Single<User> =
        userRepository.getUser()
}