package com.home.basics.models

import kotlinx.serialization.Serializable

/**
 * Data class de Usuários
 */
@Serializable
interface User {
    var name: String?
    var birthdate: String?
    var email: String?
    var role: Int?
}

