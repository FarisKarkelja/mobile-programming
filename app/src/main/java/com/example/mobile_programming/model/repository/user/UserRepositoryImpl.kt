package com.example.mobile_programming.model.repository.user

import com.example.mobile_programming.model.datasource.local.dao.UserDao
import com.example.mobile_programming.model.repository.mappers.toDomain
import com.example.mobile_programming.model.repository.mappers.toEntity
import com.example.mobile_programming.presentation.ui.screens.profile.util.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {

    override suspend fun insertUser(user: User): Long {
        return userDao.insertUser(user.toEntity())
    }

    override suspend fun getUserByEmailAndPassword(
        email: String,
        password: String
    ): User? {
        return userDao.getUserByEmailAndPassword(email, password)?.toDomain()
    }

    override suspend fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email)?.toDomain()
    }

    override suspend fun getUserById(id: Long): User? {
        return userDao.getUserById(id)?.toDomain()
    }

    override fun observeUserById(id: Long): Flow<User?> {
        return userDao.observeUserById(id).map { userEntity ->
            userEntity?.toDomain()
        }
    }

    override suspend fun updateUser(user: User) {
        userDao.updateUser(user.toEntity())
    }

    override suspend fun deleteUser(user: User) {
        userDao.deleteUser(user.toEntity())
    }
}