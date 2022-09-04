# MyLoyaltyAppServer
MyLoyaltyAppServer je back-end aplikacija napravljena u sklopu master rada na temu "Primena programskog jezika Kotlin u razvoju višeplatformskih mobilnih aplikacija".

Za back-end je koristi aplikacija MyLoyaltyApp čiji kod je dostupan na: https://github.com/JelenaI/MyLoyaltyApp

Ova aplikacija vodi računa o bazi MongoDb u kojoj se čuvaju podaci o apotekama i korisnicima. Primer jednog elementa kolekcije korisnika je: 
```json
{
    "_id" : "62c028ec23a16a7d01ad2b12",
    "firstName" : "Jelena",
    "lastName" : "Ivković",
    "phoneNumber" : "0630630630",
    "email" : "jelena.jelena@jelena.com",
    "username" : "JelenaI",
    "password" : "********",
    "points" : [
        {
            "pharmacy" : "Apoteka Zumbul",
            "numberOfPoints" : "1790.00"
        },
        {
            "pharmacy" : "Apoteka Sunce",
            "numberOfPoints" : "254.00"
        },
        {
            "pharmacy" : "Apoteka Hygia",
            "numberOfPoints" : "1576.00"
        },
        {
            "pharmacy" : "Apoteka Zdravlje",
            "numberOfPoints" : "940.00"
        },
        {
            "pharmacy" : "Apoteka Family",
            "numberOfPoints" : "427.00"
        },
        {
            "pharmacy" : "Apoteka Nana",
            "numberOfPoints" : "100.00"
        }
    ]
}
```
Primer jednog elementa kolekcije apoteka je:
```json
{
    "_id" : "62c1bd54b1ad0b59fba46cdf",
    "name" : "Apoteka Zumbul",
    "loyaltyDescription" : "Prilikom svake kupovine ostvarujete 10% popusta na ceo račun.",
    "branches" : [
        {
            "name" : "Apoteka Zumbul 1",
            "address" : "Antifašističke borbe 36",
            "phoneNumber" : "011 111 111",
            "latitude" : "44.815150",
            "longitude" : "20.425608",
            "workingHours" : [
                {
                    "dayOfWeek" : "Ponedeljak",
                    "startHours" : "07:00",
                    "endHours" : "21:00"
                },
                {
                    "dayOfWeek" : "Utorak",
                    "startHours" : "07:00",
                    "endHours" : "21:00"
                },
                {
                    "dayOfWeek" : "Sreda",
                    "startHours" : "07:00",
                    "endHours" : "21:00"
                },
                {
                    "dayOfWeek" : "Četvrtak",
                    "startHours" : "07:00",
                    "endHours" : "21:00"
                },
                {
                    "dayOfWeek" : "Petak",
                    "startHours" : "07:00",
                    "endHours" : "21:00"
                },
                {
                    "dayOfWeek" : "Subota",
                    "startHours" : "09:00",
                    "endHours" : "15:00"
                },
                {
                    "dayOfWeek" : "Nedelja",
                    "startHours" : "09:00",
                    "endHours" : "15:00"
                }
            ]
        },
        {
            "name" : "Apoteka Zumbul 2",
            "address" : "Zemunski put 5",
            "phoneNumber" : "011 111 112",
            "latitude" : "44.811775",
            "longitude" : "20.440779",
            "workingHours" : [
                {
                    "dayOfWeek" : "Ponedeljak",
                    "startHours" : "07:00",
                    "endHours" : "21:00"
                },
                {
                    "dayOfWeek" : "Utorak",
                    "startHours" : "07:00",
                    "endHours" : "21:00"
                },
                {
                    "dayOfWeek" : "Sreda",
                    "startHours" : "07:00",
                    "endHours" : "21:00"
                },
                {
                    "dayOfWeek" : "Cetvrtak",
                    "startHours" : "07:00",
                    "endHours" : "21:00"
                },
                {
                    "dayOfWeek" : "Petak",
                    "startHours" : "07:00",
                    "endHours" : "21:00"
                },
                {
                    "dayOfWeek" : "Subota",
                    "startHours" : "09:00",
                    "endHours" : "15:00"
                },
                {
                    "dayOfWeek" : "Nedelja",
                    "startHours" : "09:00",
                    "endHours" : "15:00"
                }
            ]
        },
        {
            "name" : "Apoteka Zumbul 3",
            "address" : "Jurija Gagarina 7",
            "phoneNumber" : "011 111 113",
            "latitude" : "44.804145",
            "longitude" : "20.418129",
            "workingHours" : [
                {
                    "dayOfWeek" : "Ponedeljak",
                    "startHours" : "07:00",
                    "endHours" : "21:00"
                },
                {
                    "dayOfWeek" : "Utorak",
                    "startHours" : "07:00",
                    "endHours" : "21:00"
                },
                {
                    "dayOfWeek" : "Sreda",
                    "startHours" : "07:00",
                    "endHours" : "21:00"
                },
                {
                    "dayOfWeek" : "Cetvrtak",
                    "startHours" : "07:00",
                    "endHours" : "21:00"
                },
                {
                    "dayOfWeek" : "Petak",
                    "startHours" : "07:00",
                    "endHours" : "21:00"
                },
                {
                    "dayOfWeek" : "Subota",
                    "startHours" : "09:00",
                    "endHours" : "15:00"
                },
                {
                    "dayOfWeek" : "Nedelja",
                    "startHours" : "09:00",
                    "endHours" : "15:00"
                }
            ]
        }
    ]
}
```
