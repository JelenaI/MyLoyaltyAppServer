package com.jelenai.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Pharmacy(
    val id: String? = null,
    val name: String,
    val branches: List<PharmacyBranch>
)

@Serializable
data class PharmacyBranch(
    val id: String, val name: String, val address: String, val phoneNumber: String,
    val longitude: String, val latitude: String, val workingHours: List<WorkingHours>
)

@Serializable
data class WorkingHours(
    val id: String,
    val dayOfWeek: String,
    val startHours: String,
    val endHours: String
)

val pharmacyStorage = mutableListOf(
    Pharmacy(
        id = "1", name = "Apoteka", listOf(
            PharmacyBranch(
                id = "1",
                name = "Apoteka 1",
                address = "Testa Testerovica 1, 11000 Beograd",
                phoneNumber = "011 111 111",
                longitude = "44.824857",
                latitude = "20.405850",
                listOf(
                    WorkingHours(
                        id = "1",
                        dayOfWeek = "1",
                        startHours = "07:00",
                        endHours = "21:00"
                    ),
                    WorkingHours(
                        id = "2",
                        dayOfWeek = "2",
                        startHours = "07:00",
                        endHours = "21:00"
                    ),
                    WorkingHours(
                        id = "3",
                        dayOfWeek = "3",
                        startHours = "07:00",
                        endHours = "21:00"
                    ),
                    WorkingHours(
                        id = "4",
                        dayOfWeek = "4",
                        startHours = "07:00",
                        endHours = "21:00"
                    ),
                    WorkingHours(
                        id = "5",
                        dayOfWeek = "5",
                        startHours = "07:00",
                        endHours = "21:00"
                    ),
                    WorkingHours(
                        id = "6",
                        dayOfWeek = "6",
                        startHours = "09:00",
                        endHours = "15:00"
                    ),
                    WorkingHours(
                        id = "7",
                        dayOfWeek = "7",
                        startHours = "",
                        endHours = ""
                    )
                )
            ),
        )
    ),
    Pharmacy(
        id = "2", name = "Nova Apoteka", listOf(
            PharmacyBranch(
                id = "2",
                name = "Apoteka 2",
                address = "Testa Testerovica 2, 11000 Beograd",
                phoneNumber = "011 111 112",
                longitude = "44.826470",
                latitude = "20.403629",
                listOf(
                    WorkingHours(
                        id = "8",
                        dayOfWeek = "1",
                        startHours = "07:00",
                        endHours = "21:00"
                    ),
                    WorkingHours(
                        id = "9",
                        dayOfWeek = "2",
                        startHours = "07:00",
                        endHours = "21:00"
                    ),
                    WorkingHours(
                        id = "10",
                        dayOfWeek = "3",
                        startHours = "07:00",
                        endHours = "21:00"
                    ),
                    WorkingHours(
                        id = "11",
                        dayOfWeek = "4",
                        startHours = "07:00",
                        endHours = "21:00"
                    ),
                    WorkingHours(
                        id = "12",
                        dayOfWeek = "5",
                        startHours = "07:00",
                        endHours = "21:00"
                    ),
                    WorkingHours(
                        id = "13",
                        dayOfWeek = "6",
                        startHours = "09:00",
                        endHours = "15:00"
                    ),
                    WorkingHours(
                        id = "14",
                        dayOfWeek = "7",
                        startHours = "",
                        endHours = ""
                    )
                )
            ),
        )
    )
)
