package com.bp.braappadmin.comunicacion.chat.model

data class PushNotification(
    var data: NotificationData,
    var to: String
)