//package com.example.vhh.ui.components
//
//class ValidatePassword {
//    fun execute(password: String): PasswordValidationState{
//        val validateSpecialCharacter = validateSpecialCharacter(password)
//        val validateCapitalizedLetter = validateCapitalizedLetter(password)
//        val validateMinimunLength = validateMinimunLength(password)
//        val  hasError = listOf(
//            validateMinimunLength,
//            validateCapitalizedLetter,
//            validateSpecialCharacter
//        ).all { !it }
//        return PasswordValidationState(
//            hasMinimumLength = validateMinimunLength,
//           hasCapitalizedLetter = validateCapitalizedLetter,
//         hasSpecialCharacter = validateSpecialCharacter,
//            successful = hasError
//        )
//    }
//    private fun validateSpecialCharacter(password: String): Boolean =
//        password.contains(Regex(pattern = "[!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]"))
//
//    private fun validateCapitalizedLetter(password: String): Boolean =
//        password.matches(Regex( pattern = ".*[A-z].*"))
//
//    private fun validateMinimunLength(password: String): Boolean =
//        password.matches(Regex( pattern = ".{6,}"))
//}