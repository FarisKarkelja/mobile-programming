package com.example.mobile_programming.model.repository.user

import com.example.mobile_programming.model.data.local.dao.UserDao
import com.example.mobile_programming.model.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {
    override suspend fun insertUser(user: UserEntity): Long {
        return userDao.insertUser(user)
    }

    override suspend fun getUserByEmailAndPassword(
        email: String,
        password: String
    ): UserEntity? {
        return userDao.getUserByEmailAndPassword(email, password)
    }

    override suspend fun getUserByEmail(email: String): UserEntity? {
        return userDao.getUserByEmail(email)
    }

    override suspend fun getUserById(id: Long): UserEntity? {
        return userDao.getUserById(id)
    }

    override fun observeUserById(id: Long): Flow<UserEntity?> {
        return userDao.observeUserById(id)
    }

    override suspend fun updateUser(user: UserEntity) {
        userDao.updateUser(user)
    }

    override suspend fun deleteUser(user: UserEntity) {
        userDao.deleteUser(user)
    }
}