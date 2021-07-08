package com.sharkawy.cashminute.domain.gateways.server

import com.sharkawy.cashminute.entities.CreditResponse
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


val creditApi: CreditApi by lazy {
    retrofitClient.create(CreditApi::class.java)
}

interface CreditApi {
    @FormUrlEncoded
    @POST(PAYLOAD_URL_PATH)
    suspend fun sendCreditPayload(
        @FieldMap payloadMap: MutableMap<String, String>
    ): CreditResponse
}