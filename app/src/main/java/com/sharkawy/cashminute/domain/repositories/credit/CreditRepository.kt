package com.sharkawy.cashminute.domain.repositories.credit

import com.sharkawy.cashminute.entities.CreditResponse

val creditRepository: CreditRepository by lazy { CreditRepositoryImpl() }

interface CreditRepository{
    suspend fun sendCreditPayload(payloadMap: MutableMap<String, String>): CreditResponse
}