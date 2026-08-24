package com.example.mobile_programming.model.repository.mappers

import com.example.mobile_programming.model.datasource.local.entity.UserEntity
import com.example.mobile_programming.presentation.ui.screens.profile.util.User

fun UserEntity.toDomain(): User {
    return User(
        id = this.id.toString(),
        fullName = this.fullName,
        email = this.email,
        password = this.password
    )
}

fun User.toEntity(): UserEntity {
    return UserEntity(
        id = this.id.toLongOrNull() ?: 0L,
        fullName = this.fullName,
        email = this.email,
        password = this.password
    )
}