package com.example.randomuserapp.domain.use_cases.validation

import android.util.Patterns
import com.example.randomuserapp.domain.use_cases.ValidationResult

class ValidateEmailUseCase {

    fun execute(email: String): ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Email can't be blank"
            )
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Invalid email format"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}