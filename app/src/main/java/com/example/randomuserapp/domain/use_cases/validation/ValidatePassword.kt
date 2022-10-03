package com.example.randomuserapp.domain.use_cases.validation

import com.example.randomuserapp.domain.use_cases.ValidationResult
import com.example.randomuserapp.util.Constants.PASSWORD_LENGTH

class ValidatePassword {

    fun execute(password: String): ValidationResult {
        if (password.length < PASSWORD_LENGTH) {
            return ValidationResult(
                successful = false,
                errorMessage = "Password must be at least $PASSWORD_LENGTH characters"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}