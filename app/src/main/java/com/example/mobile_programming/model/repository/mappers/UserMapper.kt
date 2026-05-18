package com.example.mobile_programming.model.repository.mappers

import com.example.mobile_programming.model.data.local.entity.UserEntity
import com.example.mobile_programming.presentation.ui.screens.profile.util.User

fun UserEntity.toDomain(): User {
    return User(
        id = this.id.toString(),
        fullName = this.fullName,
        email = this.email,
        password = this.password
    )
}

fun mapRegisterInputToEntity(fullName: String, email: String, password: String): UserEntity {
    return UserEntity(
        fullName = fullName,
        email = email,
        password = password
    )
}