package com.example.vhh.ui.notification


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.vhh.ui.datastore.Settings
import com.example.vhh.ui.datastore.SettingsConstants
import com.example.vhh.ui.networkModels.NotificationResponse
import com.example.vhh.ui.utill.Endpoints
import com.example.vhh.ui.utill.NetworkCalls
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class NotificationViewModel(private val settings: Settings) : ViewModel(), KoinComponent {
    private val _isNotificationTipShown = MutableStateFlow(false)
    private val _notifications = MutableLiveData<NotificationResponse>()

    val notifications = _notifications

    val isNotificationTipShown = _isNotificationTipShown

    fun setNotificationTipShown() {
        viewModelScope.launch {
            settings.putPreference(SettingsConstants.NOTIFICATION_TIP, true)
        }
    }

    fun getNotifications(page: Int = 0, size: Int = 20) =
        NetworkCalls.get<NotificationResponse>(
            endpoint = Endpoints.GET_NOTIFICATIONS(page, size),
            body = listOf()
        ).addOnSuccessListener {
            _notifications.value = it
        }

    init {
        getNotifications()
        viewModelScope.launch {
            settings.getPreference(SettingsConstants.NOTIFICATION_TIP, false).asLiveData()
                .observeForever {
                    _isNotificationTipShown.value = it
                }
        }
    }

}