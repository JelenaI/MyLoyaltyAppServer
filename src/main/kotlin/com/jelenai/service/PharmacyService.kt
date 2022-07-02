package com.jelenai.service

import com.jelenai.data.models.Pharmacy
import com.jelenai.data.repository.pharmacy.PharmacyRepository
import com.jelenai.data.requests.CreatePharmacyRequest
import com.jelenai.data.responses.PharmacyResponse

class PharmacyService(private val pharmacyRepository: PharmacyRepository) {
    suspend fun createPharmacy(request: CreatePharmacyRequest) {
        pharmacyRepository.createPharmacy(
            Pharmacy(
                name = request.name,
                branches = request.branches
            )
        )
    }

    suspend fun getPharmacy(pharmacyId: String): PharmacyResponse? {
        val pharmacy = pharmacyRepository.getPharmacyById(pharmacyId) ?: return null
        return PharmacyResponse(
            id = pharmacy.id,
            name = pharmacy.name,
            branches = pharmacy.branches
        )
    }
}