package com.jelenai.service

import com.jelenai.data.models.Pharmacy
import com.jelenai.data.repository.pharmacy.PharmacyRepository
import com.jelenai.data.requests.CreatePharmacyRequest
import com.jelenai.data.responses.BranchResponse
import com.jelenai.data.responses.PharmacyResponse

class PharmacyService(private val pharmacyRepository: PharmacyRepository) {
    suspend fun createPharmacy(request: CreatePharmacyRequest) {
        pharmacyRepository.createPharmacy(
            Pharmacy(
                name = request.name,
                loyaltyDescription = request.loyaltyDescription,
                branches = request.branches
            )
        )
    }

    suspend fun getPharmacy(pharmacyId: String): PharmacyResponse? {
        val pharmacy = pharmacyRepository.getPharmacyById(pharmacyId) ?: return null
        return PharmacyResponse(
            id = pharmacy.id,
            name = pharmacy.name,
            loyaltyDescription = pharmacy.loyaltyDescription,
            branches = pharmacy.branches
        )
    }

    suspend fun getAllPharmacies(): List<PharmacyResponse> {
        val pharmacies = pharmacyRepository.getAllPharmacies()
        val result = mutableListOf<PharmacyResponse>()

        pharmacies.forEach { pharmacy ->
            result.add(
                PharmacyResponse(
                    id = pharmacy.id,
                    name = pharmacy.name,
                    loyaltyDescription = pharmacy.loyaltyDescription,
                    branches = pharmacy.branches
                )
            )
        }

        return result
    }

    suspend fun getAllBranches(): List<BranchResponse> {
        val pharmacies = pharmacyRepository.getAllPharmacies()
        val result = mutableListOf<BranchResponse>()

        pharmacies.forEach { pharmacy ->
            pharmacy.branches.forEach { branch ->
                result.add(
                    BranchResponse(
                        name = branch.name,
                        address = branch.address,
                        phoneNumber = branch.phoneNumber,
                        longitude = branch.longitude,
                        latitude = branch.latitude,
                        workingHours = branch.workingHours
                    )
                )
            }
        }

        return result
    }
}