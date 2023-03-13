package com.bp.braappadmin.comunicacion.chat.`interface`

import com.bp.braappadmin.comunicacion.chat.model.PushNotification
import com.bp.braappadmin.comunicacion.chat.Constants.Constants.Companion.CONTENT_TYPE
import com.bp.braappadmin.comunicacion.chat.Constants.Constants.Companion.SERVER_KEY
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface NotificationApi {

    @Headers("Authorization: key=$SERVER_KEY", "Content-type:$CONTENT_TYPE")
    @POST("fcm/send")
    suspend fun postNotification(
        @Body notification: PushNotification
    ): Response<ResponseBody>
}