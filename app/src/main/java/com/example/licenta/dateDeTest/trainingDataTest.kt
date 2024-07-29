package com.example.licenta.dateDeTest

import com.example.licenta.R
import com.example.licenta.dataClasses.training

val Antrenament= listOf(
    training(R.drawable.squats,serii="three series", repetiti = "14 repetitions", titlu = "SQUATS cu bara", video = R.raw.primul_video,
    instructiuni = "Setup: Plasează bara pe partea superioară a spatelui, prinde-o cu mâinile puțin mai largi decât umerii. Stai cu picioarele la lățimea umerilor, degetele ușor orientate în exterior.\n" +
            "Îndepărtare: Ridică bara de pe rack și fă un pas înapoi.\n" +
            "Coborâre: Inspiră, împinge șoldurile înapoi, coboară cu genunchii îndoiti și spatele drept.\n" +
            "Ridicare: Împinge-te în picioare prin călcâie, expiră la ridicare.\n" +
            "Repetiții: Menține forma corectă și repetă mișcarea."
    ),
    training(R.drawable.presadepiciopare,serii="four series", repetiti = "12 repetitions", titlu = "Presa de picioare", video = R.raw.presadepicioare,
        instructiuni = "Setup: Așază-te pe aparat și poziționează picioarele pe platformă la lățimea umerilor.\n" +
                "Îndepărtare: Împinge platforma în sus și eliberează siguranțele.\n" +
                "Coborâre: Inspiră, îndoaie genunchii și coboară platforma până când genunchii formează un unghi de aproximativ 90 de grade.\n" +
                "Ridicare: Împinge platforma în sus până când picioarele sunt aproape drepte (nu bloca genunchii). Expiră în timpul ridicării.\n" +
                "Repetiții: Repetă mișcarea pentru numărul dorit de repetări, menținând forma corectă."),
    training(R.drawable.fandaricuhaltere,serii="four series", repetiti = "12 repetitions", titlu = "Fandări cu haltere", video = R.raw.fandaricuhaltere,
        instructiuni = "Setup: Ține o halteră în fiecare mână, cu brațele întinse pe lângă corp. Stai drept, cu picioarele la lățimea umerilor.\n" +
                "Pas înainte: Fă un pas mare înainte cu un picior, menținând spatele drept.\n" +
                "Coborâre: Îndoaie ambii genunchi până când genunchiul din spate aproape atinge solul și cel din față formează un unghi de 90 de grade. Inspiră în timpul coborârii.\n" +
                "Ridicare: Împinge-te în piciorul din față pentru a reveni la poziția inițială. Expiră în timpul ridicării.\n" +
                "Repetiții: Alternativ, schimbă picioarele și repetă mișcarea pentru numărul dorit de repetări. Menține forma corectă pe tot parcursul exercițiului."),
    training(R.drawable.indreptariromanesti,serii="four series", repetiti = "12 repetitions", titlu = "Indreptari Romanesti", video = R.raw.indreptariromanesti,
        instructiuni = "Setup: Stai drept, cu picioarele la lățimea umerilor și prinde bara cu mâinile la lățimea umerilor, palmele orientate către corp.\n" +
                "Coborâre: Ține spatele drept și genunchii ușor flexați. Împinge șoldurile înapoi și coboară bara pe lângă picioare, menținând-o aproape de corp. Inspiră în timpul coborârii.\n" +
                "Ridicare: Împinge șoldurile înainte și ridică bara revenind la poziția inițială. Expiră în timpul ridicării.\n" +
                "Repetiții: Menține spatele drept și repetă mișcarea pentru numărul dorit de repetări.")
)
val AntrenamentSpate= listOf(
    training(R.drawable.renegade,serii="three series", repetiti = "14 repetitions", titlu = "Renegade Rows", video = R.raw.renegade,
        instructiuni = "Setup: Așază-te în poziție de plank, cu câte o ganteră în fiecare mână, brațele întinse și picioarele depărtate pentru stabilitate.\n" +
                "Ridicare: Ține corpul drept și ridică o ganteră spre trunchi, menținând cotul aproape de corp. Inspiră în timpul ridicării.\n" +
                "Coborâre: Coboară încet gantera înapoi pe sol, controlând mișcarea. Expiră în timpul coborârii.\n" +
                "Alternare: Repetă mișcarea cu cealaltă mână.\n" +
                "Repetiții: Menține corpul stabil și repetă alternând brațele pentru numărul dorit de repetări."),
    training(R.drawable.hiperextensii,serii="four series", repetiti = "12 repetitions", titlu = "Hiperextensii", video = R.raw.primul_video,
        instructiuni = "Setup: Așază-te pe aparatul de hiperextensii, cu coapsele sprijinite pe perna de susținere și gleznele fixate sub pernele pentru picioare. Ține mâinile pe piept sau la ceafă.\n" +
                "Coborâre: Îndoaie trunchiul în față la nivelul taliei, menținând spatele drept. Inspiră în timpul coborârii.\n" +
                "Ridicare: Întinde trunchiul înapoi până când corpul este aliniat drept. Expiră în timpul ridicării.\n" +
                "Repetiții: Menține o formă corectă și repetă mișcarea pentru numărul dorit de repetări."),
    training(R.drawable.fandaricuhaltere,serii="four series", repetiti = "12 repetitions", titlu = "Pull-Aparts cu banda de rezistenta", video = R.raw.primul_video,
        instructiuni = "Setup: Ține banda de rezistență cu ambele mâini, brațele întinse în fața ta, la nivelul umerilor. Picioarele stau la lățimea umerilor.\n" +
                "Întindere: Trage banda lateral, deschizând brațele până când banda atinge pieptul. Menține brațele drepte și omoplații retrași. Inspiră în timpul mișcării.\n" +
                "Revenire: Adu încet brațele înapoi la poziția inițială, controlând mișcarea. Expiră în timpul revenirii.\n" +
                "Repetiții: Menține forma corectă și repetă mișcarea pentru numărul dorit de repetări.")
)
val AntrenamentPiept= listOf(
    training(R.drawable.bench,serii="three series", repetiti = "12 repetitions", titlu="Bench Press", video = R.raw.primul_video,
        instructiuni = "Setup: Întinde-te pe o bancă orizontală cu picioarele ferm pe sol. Apucă bara cu mâinile puțin mai largi decât lățimea umerilor.\n" +
                "Îndepărtare: Ridică bara de pe rack și poziționeaz-o deasupra pieptului, cu brațele întinse.\n" +
                "Coborâre: Coboară bara încet până când atinge ușor pieptul, menținând coatele la un unghi de aproximativ 45 de grade față de corp. Inspiră în timpul coborârii.\n" +
                "Ridicare: Împinge bara în sus până când brațele sunt complet întinse. Expiră în timpul ridicării.\n" +
                "Repetiții: Menține forma corectă și repetă mișcarea pentru numărul dorit de repetări."),
    training(R.drawable.dumbbel,serii="four series",repetiti="14 repetions",titlu="Dumbbell Flyes", video = R.raw.primul_video,
        instructiuni = "Setup: Întinde-te pe o bancă orizontală cu picioarele ferm pe sol. Ține câte o ganteră în fiecare mână, cu brațele întinse deasupra pieptului și palmele orientate una spre cealaltă.\n" +
                "Coborâre: Cu o ușoară flexie în coate, coboară brațele lateral într-un arc larg până când ganterele ajung la nivelul pieptului sau ușor mai jos. Inspiră în timpul coborârii.\n" +
                "Ridicare: Adu ganterele înapoi la poziția inițială, ridicându-le într-un arc larg, până când brațele sunt din nou întinse deasupra pieptului. Expiră în timpul ridicării.\n" +
                "Repetiții: Menține forma corectă și repetă mișcarea pentru numărul dorit de repetări."),
    training(R.drawable.chestdips,serii="four series",repetiti="15 repetitions",titlu="Chest Dips", video = R.raw.primul_video,
        instructiuni = "Setup: Prinde-te de barele paralele și ridică-te până când brațele sunt complet întinse. Înclină trunchiul ușor în față pentru a pune accent pe mușchii pieptului.\n" +
                "Coborâre: Îndoaie coatele și coboară corpul până când umerii sunt sub nivelul coatelor. Inspiră în timpul coborârii.\n" +
                "Ridicare: Împinge-te înapoi până când brațele sunt complet întinse. Expiră în timpul ridicării.\n" +
                "Repetiții: Menține forma corectă și repetă mișcarea pentru numărul dorit de repetări."),
    training(R.drawable.cable_crossover,serii="four series",repetiti="12 repetions", titlu = "Cable Crossover", video = R.raw.primul_video,
        instructiuni = "Setup: Reglează scripetele cablurilor la nivelul umerilor și prinde câte un mâner în fiecare mână. Stai în mijloc, cu un picior ușor în față pentru echilibru.\n" +
                "Coborâre: Întinde brațele în lateral cu coatele ușor flexate, palmele orientate în față.\n" +
                "Execuție: Adu mânerul în față, încercând să le faci să se întâlnească sau să se încrucișeze ușor în fața corpului. Expiră în timpul mișcării.\n" +
                "Revenire: Întinde încet brațele înapoi la poziția inițială, menținând ușoara flexie în coate. Inspiră în timpul revenirii.\n" +
                "Repetiții: Menține forma corectă și repetă mișcarea pentru numărul dorit de repetări.")
)
val AntrenamentBiceps=listOf(
   training(R.drawable.curluri_cu_bara_dreapta,serii="three series", repetiti = "15 repetitions", titlu = "Curl-uri cu bara dreapta", video = R.raw.primul_video,
       instructiuni = "Setup: Stai drept, cu picioarele la lățimea umerilor. Ține bara cu o priză supinație (palmele orientate în sus), mâinile la lățimea umerilor.\n" +
               "Execuție: Ridică bara spre umeri, menținând coatele aproape de corp. Inspiră în timpul ridicării.\n" +
               "Coborâre: Coboară încet bara înapoi la poziția inițială, controlând mișcarea. Expiră în timpul coborârii.\n" +
               "Repetiții: Menține forma corectă și repetă mișcarea pentru numărul dorit de repetări."),
   training(R.drawable.curluri_cu_gantere,serii="four series", repetiti = "12 repetitions", titlu = "Curl-uri cu gantere", video = R.raw.primul_video,
       instructiuni = "Setup: Stai drept, cu picioarele la lățimea umerilor. Ține câte o ganteră în fiecare mână, brațele întinse pe lângă corp și palmele orientate spre interior.\n" +
               "Execuție: Ridică ganterele spre umeri, rotind palmele spre față pe măsură ce ridici. Inspiră în timpul ridicării.\n" +
               "Coborâre: Coboară încet ganterele înapoi la poziția inițială, rotind palmele înapoi spre interior. Expiră în timpul coborârii.\n" +
               "Repetiții: Menține forma corectă și repetă mișcarea pentru numărul dorit de repetări."),
   training(R.drawable.curluri_la_banca_scott, serii = "four series", repetiti = "14 repetitions", titlu = "Curl-uri la banca Scott", video = R.raw.primul_video,
       instructiuni = "Setup: Așază-te pe banca Scott și poziționează brațele pe suportul înclinat al băncii. Ține bara cu o priză supinație (palmele orientate în sus), mâinile la lățimea umerilor.\n" +
               "Execuție: Ridică bara spre umeri, menținând coatele fixe și pe suport. Inspiră în timpul ridicării.\n" +
               "Coborâre: Coboară încet bara înapoi la poziția inițială, controlând mișcarea. Expiră în timpul coborârii.\n" +
               "Repetiții: Menține forma corectă și repetă mișcarea pentru numărul dorit de repetări."),
   training(R.drawable.curluri_cu_hammer,serii="four series", repetiti = "12 repetions",titlu="Curl-uri cu hammer", video = R.raw.primul_video,
       instructiuni = "Setup: Stai drept, cu picioarele la lățimea umerilor. Ține câte o ganteră în fiecare mână, brațele întinse pe lângă corp și palmele orientate una spre cealaltă (grip hammer).\n" +
               "Execuție: Ridică ganterele spre umeri, menținând palmele orientate una spre cealaltă pe toată durata mișcării. Inspiră în timpul ridicării.\n" +
               "Coborâre: Coboară încet ganterele înapoi la poziția inițială, controlând mișcarea. Expiră în timpul coborârii.\n" +
               "Repetiții: Menține forma corectă și repetă mișcarea pentru numărul dorit de repetări."),
    training(R.drawable.curluri_cu_cabluri,serii="four series", repetiti = "12 repetions", titlu="Curl-uri cu cabluri", video = R.raw.primul_video,
        instructiuni = "Setup: Stai în fața unui aparat cu cabluri, cu scripetele setat în poziția inferioară. Apucă bara atașată la cablu cu o priză supinație (palmele orientate în sus), mâinile la lățimea umerilor.\n" +
                "Execuție: Ridică bara spre umeri, menținând coatele aproape de corp și fixe. Inspiră în timpul ridicării.\n" +
                "Coborâre: Coboară încet bara înapoi la poziția inițială, controlând mișcarea. Expiră în timpul coborârii.\n" +
                "Repetiții: Menține forma corectă și repetă mișcarea pentru numărul dorit de repetări.")
)
////
/*val AntrenamentTriceps=listOf(
    training(R.drawable.curluri_cu_bara_dreapta,serii="three series", repetiti = "15 repetitions", titlu = "Curl-uri cu bara dreapta", video = R.raw.primul_video),
    training(R.drawable.curluri_cu_gantere,serii="four series", repetiti = "12 repetitions", titlu = "Curl-uri cu gantere", video = R.raw.primul_video),
    training(R.drawable.curluri_la_banca_scott, serii = "four series", repetiti = "14 repetitions", titlu = "Curl-uri la banca Scott", video = R.raw.primul_video),
    training(R.drawable.curluri_cu_hammer,serii="four series", repetiti = "12 repetions",titlu="Curl-uri cu hammer", video = R.raw.primul_video),
    training(R.drawable.curluri_cu_cabluri,serii="four series", repetiti = "12 repetions", titlu="Curl-uri cu cabluri", video = R.raw.primul_video)
)

val AntrenamentAntebrat=listOf(
    training(R.drawable.curluri_cu_bara_dreapta,serii="three series", repetiti = "15 repetitions", titlu = "Curl-uri cu bara dreapta", video = R.raw.primul_video),
    training(R.drawable.curluri_cu_gantere,serii="four series", repetiti = "12 repetitions", titlu = "Curl-uri cu gantere", video = R.raw.primul_video),
    training(R.drawable.curluri_la_banca_scott, serii = "four series", repetiti = "14 repetitions", titlu = "Curl-uri la banca Scott", video = R.raw.primul_video),
    training(R.drawable.curluri_cu_hammer,serii="four series", repetiti = "12 repetions",titlu="Curl-uri cu hammer", video = R.raw.primul_video),
    training(R.drawable.curluri_cu_cabluri,serii="four series", repetiti = "12 repetions", titlu="Curl-uri cu cabluri", video = R.raw.primul_video)
)*/
