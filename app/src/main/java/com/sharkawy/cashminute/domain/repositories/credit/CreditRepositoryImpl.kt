package com.sharkawy.cashminute.domain.repositories.credit

import com.sharkawy.cashminute.domain.gateways.server.CreditApi
import com.sharkawy.cashminute.domain.gateways.server.creditApi
import com.sharkawy.cashminute.entities.CreditResponse


class CreditRepositoryImpl(private val server: CreditApi = creditApi) : CreditRepository {
    override suspend fun sendCreditPayload(payloadMap: MutableMap<String, String>): CreditResponse =
        server.sendCreditPayload(payloadMap)

}