package com.home.basics.models

import android.util.Patterns
import com.google.gson.annotations.SerializedName
import io.konform.validation.Validation
import io.konform.validation.ValidationResult
import io.konform.validation.jsonschema.const
import io.konform.validation.jsonschema.pattern
import java.util.regex.Pattern

/**
 * Data class de Credenciais de um usuário
 */
data class Credentials constructor(
    @SerializedName("name")
    override var name: String? = null,
    @SerializedName("birthdate")
    override var birthdate: String? = null,
    @SerializedName("email")
    override var email: String? = null,
    @SerializedName("role")
    override var role: Int? = null,
    @SerializedName("password")
    var password: String? = null,
    @SerializedName("repeat_password")
    var passwordRepeat: String? = null,
    @SerializedName("token_bearer")
    var token: String? = null,
    @SerializedName("token_refresh")
    var refreshToken: String? = null,
    @SerializedName("status")
    var status: String? = null,
    @SerializedName("code")
    var code: String? = null): User {

    private fun getValidateCredentials() = Validation<Credentials> {
        Credentials::email required {
            pattern(pattern = Patterns.EMAIL_ADDRESS.pattern()) hint "Informe um e-mail válido."
        }

        Credentials::password ifPresent {
            pattern(
                pattern = Pattern.compile(
                    "^" +
                            //"(?=.*[a-z])" +         //at least 1 lower case letter
                            //"(?=.*[A-Z])" +         //at least 1 upper case letter
                            "(?=.*[a-z])" +         //at least 1 lower case letter
                            "(?=.*[0-9])" +         //at least 1 number
                            "(?=.*[a-zA-Z])" +      //any letter
                            "(?=.*[@#$!%^&+=])" +    //at least 1 special character
                            "(?=\\S+$)" +           //no white spaces
                            ".{6,}" +               //at least 6 characters
                            "$"
                ).pattern()
            ) hint "A Senha deve conter 6 caracteres, letras maíusculas, " +
                    "minúsculas, números e caracteres especiais."
        }

        Credentials::passwordRepeat ifPresent {
            const(this@Credentials.password.toString()) hint "O campo repete senha está" +
                    "diferente do campo senha."
        }

        Credentials::birthdate ifPresent {
            pattern("""\d{4}""") hint "Digite o ano completo de seu nascimento"
        }

        Credentials::code ifPresent {
            pattern("""\d{6}""") hint "Informe o código de recuperação"
        }
    }

    fun Validate(): ValidationResult<Credentials> {
        return getValidateCredentials()(this)
    }

    data class BuilderLogin(var email: String? = null, var password: String? = null) {
        fun email(email: String) = apply {
            this.email = email
        }
        fun password(password: String) = apply { this.password = password }
        fun build() = Credentials(email = this.email, password = this.password)
    }

    data class BuilderChangePassword(var email: String? = null,  var password: String? = null,
                                     var repeatPassword: String? = null, var code: String? = null) {
        fun email(email: String) = apply {
            this.email = email
        }
        fun password(password: String) = apply { this.password = password }
        fun repeatPassword(repeatPassword: String) = apply { this.repeatPassword = repeatPassword }
        fun code(code: String) = apply { this.code = code }
        fun build() = Credentials(email = this.email, code = this.code,
            password = this.password, passwordRepeat = this.repeatPassword )
    }

    data class BuilderForgot(var email: String? = null) {
        fun email(email: String) = apply {
            this.email = email
        }
        fun build() = Credentials(email = this.email)
    }

    data class BuilderSignUp(
        var name: String? = null,
        var birthdate: String? = null,
        var email: String? = null,
        var role: Int = 1,
        var password: String? = null,
        var passwordRepeat: String? = null
    ) {
        fun name(name: String) = apply { this.name = name }
        fun birthdate(birthdate: String) = apply { this.birthdate = birthdate }
        fun email(email: String) = apply { this.email = email }
        fun role(role: ROLE) = apply { this.role = role.value }
        fun password(password: String) = apply { this.password = password }
        fun passwordRepeat(passwordRepeat: String) = apply { this.passwordRepeat = passwordRepeat }
        fun build() = Credentials(name = this.name, birthdate = this.birthdate,
            email = this.email, role = this.role, password = this.password, passwordRepeat = this.passwordRepeat,
            status = "confirmed" )
    }
}