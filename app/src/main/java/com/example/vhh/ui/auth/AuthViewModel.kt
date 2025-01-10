package com.example.vhh.ui.auth

import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vhh.ui.data.db.models.User
import com.example.vhh.ui.data.respositories.UserRepository
import com.example.vhh.ui.datastore.Settings
import com.example.vhh.ui.datastore.SettingsConstants
import com.example.vhh.ui.networkModels.LoginResponse
import com.example.vhh.ui.utill.Endpoints
import com.example.vhh.ui.utill.NetworkCalls
import com.example.vhh.ui.utill.locationModels.LocationResult
//import com.example.vhh.ui.utill.locationModels.LocationResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthViewModel(private val settings: Settings) : ViewModel(), KoinComponent {
    private val deviceName = Build.MODEL
    private val deviceID = Build.ID
    private val os = "Android"
    private val userRepository: UserRepository by inject()

    fun checkEmail(email: String) =
        NetworkCalls.get<User>(endpoint = Endpoints.CHECK_EMAIL(email), body = listOf())

    fun checkUserName(username: String) =
        NetworkCalls.get<User>(endpoint = Endpoints.CHECK_USERNAME(username), body = listOf())
    //login
    fun login(email: String, password: String) =
        NetworkCalls.post<LoginResponse>(
            endpoint = Endpoints.LOGIN, body = listOf(
                Pair("email", email),
                Pair("password", password),
                Pair("deviceName", deviceName),
                Pair("deviceToken", deviceID),
                Pair("os", os)
            )
        )

    fun saveUser(user: User) =
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.createUser(user)
        }

//    login
    fun signUp(
    email: String,
    password: String,
    firstName: String,
    lastName: String,
//    userName: String,
    address: String,
    location: LocationResult,
//    referralCode: String? = null
    ) =
        NetworkCalls.post<LoginResponse>(
            endpoint = Endpoints.SIGNUP, body = listOf(
                Pair("email", email),
                Pair("password", password),
                Pair("firstName", firstName),
                Pair("lastName", lastName),
//                Pair("userName", userName),
                Pair("address", address),
                Pair("city",
                    location.addressComponents.firstOrNull { it.types.contains("locality") }?.longName
                        ?: ""
                ),
                Pair("state",
                    location.addressComponents.firstOrNull { it.types.contains("administrative_area_level_1") }?.longName
                        ?: ""
                ),
                Pair("latitude", location.geometry?.location?.lat ?: 0.0),
                Pair("longitude", location.geometry?.location?.lng ?: 0.0),
                Pair("country",
                    location.addressComponents.firstOrNull { it.types.contains("country") }?.longName
                        ?: ""
                ),
//                Pair("referralCode", referralCode),
            )
        )

    //verify otp
    fun verifyOtp(email: String, otp: String) =
        NetworkCalls.post<LoginResponse>(
            endpoint = Endpoints.VERIFY_OTP, body = listOf(
                Pair("email", email),
                Pair("otp", otp),
                Pair("deviceName", deviceName),
                Pair("deviceToken", deviceID),
                Pair("os", os)
            )
        ).addOnSuccessListener {
            if (it.user.id.isNotEmpty())
                viewModelScope.launch(Dispatchers.IO) {
                    userRepository.createUser(it.user)
                }
        }

    //save token
    fun saveToken(token: String) =
        viewModelScope.launch(Dispatchers.IO) {
//            Timber.tag("The token is ").d(token)
            settings.putPreference(SettingsConstants.TOKEN, token)
        }

    //resend otp
    fun resendOtp(email: String) =
        NetworkCalls.post<LoginResponse>(
            endpoint = Endpoints.RESEND_OTP(email), body = listOf()
        )

    //forget password
    fun forgetPassword(email: String) =
        NetworkCalls.post<LoginResponse>(
            endpoint = Endpoints.FORGET_PASSWORD,
            body = listOf(
                "email" to email
            )
        )

    //reset password
    fun resetPassword(password: String, passwordConfirmation: String) =
        NetworkCalls.post<LoginResponse>(
            endpoint = Endpoints.RESET_PASSWORD,
            body = listOf(
                Pair("password", password),
                Pair("passwordConfirmation", passwordConfirmation),
                Pair("deviceName", deviceName),
                Pair("deviceToken", deviceID),
                Pair("os", os)
            )
        )

    //remove token
    fun removeToken() =
        viewModelScope.launch(Dispatchers.IO) {
            settings.removePreference(SettingsConstants.TOKEN)
        }
}
