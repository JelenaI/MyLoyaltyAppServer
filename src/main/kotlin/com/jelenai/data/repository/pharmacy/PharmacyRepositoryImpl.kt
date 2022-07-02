package com.jelenai.data.repository.pharmacy

import com.jelenai.data.models.Pharmacy
import org.litote.kmongo.coroutine.CoroutineDatabase

class PharmacyRepositoryImpl(db: CoroutineDatabase) : PharmacyRepository {
    private val pharmacies = db.getCollection<Pharmacy>()

    override suspend fun createPharmacy(pharmacy: Pharmacy) {
        pharmacies.insertOne(pharmacy)
    }

    override suspend fun getPharmacyById(id: String): Pharmacy? {
        return pharmacies.findOneById(id)
    }
}