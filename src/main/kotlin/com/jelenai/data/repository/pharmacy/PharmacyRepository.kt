package com.jelenai.data.repository.pharmacy

import com.jelenai.data.models.Pharmacy

interface PharmacyRepository {
    suspend fun createPharmacy(pharmacy: Pharmacy)

    suspend fun getPharmacyById(id: String): Pharmacy?
}