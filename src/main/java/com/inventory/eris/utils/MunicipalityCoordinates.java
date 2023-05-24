package com.inventory.eris.utils;


import com.inventory.eris.domain.administratives.municipality.Municipality;
import com.inventory.eris.domain.administratives.province.Province;
import com.inventory.eris.domain.administratives.region.Region;

import java.util.*;

public class MunicipalityCoordinates {

    public Map<String, List<Municipality>> bicol() {


        Map<String, List<Municipality>> bicol = new HashMap<>();

        List<Municipality> albayMunicipalities = new ArrayList<>();

        albayMunicipalities.add(new Municipality("Bacacay", 13.1642, 123.7750));
        albayMunicipalities.add(new Municipality("Camalig", 13.2233, 123.6276));
        albayMunicipalities.add(new Municipality("Daraga", 13.1577, 123.6856));
        albayMunicipalities.add(new Municipality("Guinobatan", 13.2925, 123.4369));
        albayMunicipalities.add(new Municipality("Jovellar", 13.2003, 123.6087));
        albayMunicipalities.add(new Municipality("Legazpi City", 13.1396, 123.7407));
        albayMunicipalities.add(new Municipality("Libon", 13.4100, 123.5262));
        albayMunicipalities.add(new Municipality("Ligao City", 13.2108, 123.5432));
        albayMunicipalities.add(new Municipality("Malilipot", 13.2742, 123.6608));
        albayMunicipalities.add(new Municipality("Malinao", 13.3273, 123.5769));
        albayMunicipalities.add(new Municipality("Manito", 13.1416, 123.6549));
        albayMunicipalities.add(new Municipality("Oas", 13.2861, 123.4060));
        albayMunicipalities.add(new Municipality("Pio Duran", 13.2953, 123.5143));
        albayMunicipalities.add(new Municipality("Polangui", 13.2989, 123.4149));
        albayMunicipalities.add(new Municipality("Rapu-Rapu", 13.2444, 124.0293));
        albayMunicipalities.add(new Municipality("Santo Domingo", 13.2692, 123.6659));
        albayMunicipalities.add(new Municipality("Tabaco City", 13.3638, 123.7107));
        albayMunicipalities.add(new Municipality("Tiwi", 13.4339, 123.6557));
        bicol.put("albay", albayMunicipalities);

        List<Municipality> camarinesNorteMunicipalities = new ArrayList<>();

        camarinesNorteMunicipalities.add(new Municipality("Basud", 14.0025, 122.8247));
        camarinesNorteMunicipalities.add(new Municipality("Capalonga", 14.2306, 122.9107));
        camarinesNorteMunicipalities.add(new Municipality("Daet", 14.1137, 122.9528));
        camarinesNorteMunicipalities.add(new Municipality("Jose Panganiban", 14.1964, 122.6527));
        camarinesNorteMunicipalities.add(new Municipality("Labo", 14.2527, 122.6946));
        camarinesNorteMunicipalities.add(new Municipality("Mercedes", 13.9162, 122.9444));
        camarinesNorteMunicipalities.add(new Municipality("Paracale", 14.2862, 122.8267));
        camarinesNorteMunicipalities.add(new Municipality("San Lorenzo Ruiz", 14.2333, 122.9500));
        camarinesNorteMunicipalities.add(new Municipality("San Vicente", 13.8776, 122.9817));
        camarinesNorteMunicipalities.add(new Municipality("Santa Elena", 14.1622, 122.9614));
        camarinesNorteMunicipalities.add(new Municipality("Talisay", 14.1028, 122.9108));
        camarinesNorteMunicipalities.add(new Municipality("Vinzons", 14.2672, 122.8265));

        bicol.put("camarines norte", camarinesNorteMunicipalities);

        List<Municipality> camarinesSurMunicipalities = new ArrayList<>();

        camarinesSurMunicipalities.add(new Municipality("Baao", 13.4287, 123.4202));
        camarinesSurMunicipalities.add(new Municipality("Balatan", 13.7525, 123.4850));
        camarinesSurMunicipalities.add(new Municipality("Bato", 13.5065, 123.4493));
        camarinesSurMunicipalities.add(new Municipality("Bombon", 13.6971, 123.3051));
        camarinesSurMunicipalities.add(new Municipality("Buhi", 13.3925, 123.5139));
        camarinesSurMunicipalities.add(new Municipality("Bula", 13.3300, 123.4407));
        camarinesSurMunicipalities.add(new Municipality("Caramoan", 13.7842, 123.7709));
        camarinesSurMunicipalities.add(new Municipality("Del Gallego", 13.8827, 122.8681));
        camarinesSurMunicipalities.add(new Municipality("Gainza", 13.4705, 123.2682));
        camarinesSurMunicipalities.add(new Municipality("Garchitorena", 13.7989, 123.4146));
        camarinesSurMunicipalities.add(new Municipality("Goa", 13.6969, 123.3796));
        camarinesSurMunicipalities.add(new Municipality("Lagonoy", 13.7038, 123.4959));
        camarinesSurMunicipalities.add(new Municipality("Libmanan", 13.7099, 123.2412));
        camarinesSurMunicipalities.add(new Municipality("Lupi", 13.7544, 122.9058));
        camarinesSurMunicipalities.add(new Municipality("Magarao", 13.6220, 123.2357));
        camarinesSurMunicipalities.add(new Municipality("Milaor", 13.5078, 123.2414));
        camarinesSurMunicipalities.add(new Municipality("Minalabac", 13.5312, 123.2984));
        camarinesSurMunicipalities.add(new Municipality("Nabua", 13.4275, 123.3497));
        camarinesSurMunicipalities.add(new Municipality("Naga City", 13.6191, 123.1814));
        camarinesSurMunicipalities.add(new Municipality("Ocampo", 13.4676, 123.2876));
        camarinesSurMunicipalities.add(new Municipality("Pamplona", 13.4514, 123.3104));
        camarinesSurMunicipalities.add(new Municipality("Pasacao", 13.5365, 123.1944));
        camarinesSurMunicipalities.add(new Municipality("Pili", 13.6058, 123.3431));
        camarinesSurMunicipalities.add(new Municipality("Presentacion", 13.5693, 123.3426));
        camarinesSurMunicipalities.add(new Municipality("Ragay", 13.7085, 123.4199));
        camarinesSurMunicipalities.add(new Municipality("Sagnay", 13.5457, 123.4689));
        camarinesSurMunicipalities.add(new Municipality("San Fernando", 13.7814, 123.5801));
        camarinesSurMunicipalities.add(new Municipality("San Jose", 13.6381, 123.2664));
        camarinesSurMunicipalities.add(new Municipality("Sipocot", 13.6907, 123.3672));
        camarinesSurMunicipalities.add(new Municipality("Siruma", 13.8109, 123.5052));
        camarinesSurMunicipalities.add(new Municipality("Tigaon", 13.6883, 123.4437));
        camarinesSurMunicipalities.add(new Municipality("Tinambac", 13.8864, 123.5726));

        bicol.put("camarines sur", camarinesSurMunicipalities);

        return bicol;

    }
    public Map<String, List<Municipality>> cagayanValley(){

        Map<String, List<Municipality>> cagayanV = new HashMap<>();

        List<Municipality> cagayanMunicipalities = new ArrayList<>();

        cagayanMunicipalities.add(new Municipality("Tuguegarao", 17.6139, 121.7269));
        cagayanMunicipalities.add(new Municipality("Alcala", 17.8981, 121.6419));
        cagayanMunicipalities.add(new Municipality("Allacapan", 18.2536, 121.5097));
        cagayanMunicipalities.add(new Municipality("Amulung", 18.5040, 121.4707));
        cagayanMunicipalities.add(new Municipality("Aparri", 18.3556, 121.6431));
        cagayanV.put("cagayan", cagayanMunicipalities);

        ArrayList<Municipality> isabelaMunicipalities = new ArrayList<>();
        isabelaMunicipalities.add(new Municipality("Ilagan", 17.1524, 121.8848));
        isabelaMunicipalities.add(new Municipality("Cauayan", 16.9339, 121.7677));
        isabelaMunicipalities.add(new Municipality("Santiago", 16.6880, 121.5486));
        isabelaMunicipalities.add(new Municipality("Roxas", 16.6961, 121.5464));
        isabelaMunicipalities.add(new Municipality("Alicia", 16.9058, 121.5254));
        cagayanV.put("isabela", isabelaMunicipalities);

        ArrayList<Municipality> nuevaVizcayaMunicipalities = new ArrayList<>();

        nuevaVizcayaMunicipalities.add(new Municipality("Bayombong", 16.4817, 121.1490));
        nuevaVizcayaMunicipalities.add(new Municipality("Solano", 16.5187, 121.1876));
        nuevaVizcayaMunicipalities.add(new Municipality("Dupax del Norte", 16.3206, 121.1516));
        nuevaVizcayaMunicipalities.add(new Municipality("Aritao", 16.3759, 121.1161));
        nuevaVizcayaMunicipalities.add(new Municipality("Bambang", 16.5034, 121.1094));
        cagayanV.put("nueva Vizcaya", nuevaVizcayaMunicipalities);

        ArrayList<Municipality> quirinoMunicipalities = new ArrayList<>();

        quirinoMunicipalities.add(new Municipality("Cabarroguis", 16.5112, 121.5212));
        quirinoMunicipalities.add(new Municipality("Diffun", 16.6090, 121.5429));
        quirinoMunicipalities.add(new Municipality("Maddela", 16.6275, 121.6015));
        quirinoMunicipalities.add(new Municipality("Nagtipunan", 16.7062, 121.6862));
        quirinoMunicipalities.add(new Municipality("Saguday", 16.6766, 121.6332));
        cagayanV.put("quirino", quirinoMunicipalities);

        return cagayanV;
    }

    public Map<String, List<Municipality>> centralLuzon(){

        Map<String, List<Municipality>> central = new HashMap<>();

        // Aurora
        ArrayList<Municipality> auroraMunicipalities = new ArrayList<>();
        auroraMunicipalities.add(new Municipality("Baler", 15.7585, 121.5580));
        auroraMunicipalities.add(new Municipality("Casiguran", 16.3593, 122.5983));
        auroraMunicipalities.add(new Municipality("Dilasag", 16.2919, 122.0296));
        auroraMunicipalities.add(new Municipality("Dinalungan", 15.8777, 121.5394));
        auroraMunicipalities.add(new Municipality("Dingalan", 15.4066, 121.3997));
        central.put("aurora", auroraMunicipalities);

        // Bataan
        ArrayList<Municipality> bataanMunicipalities = new ArrayList<>();
        bataanMunicipalities.add(new Municipality("Balanga", 14.6760, 120.5369));
        bataanMunicipalities.add(new Municipality("Abucay", 14.6829, 120.5453));
        bataanMunicipalities.add(new Municipality("Bagac", 14.6286, 120.4036));
        bataanMunicipalities.add(new Municipality("Dinalupihan", 14.9028, 120.4692));
        bataanMunicipalities.add(new Municipality("Hermosa", 14.9012, 120.5604));
        bataanMunicipalities.add(new Municipality("Limay", 14.5707, 120.6229));
        bataanMunicipalities.add(new Municipality("Mariveles", 14.4376, 120.4870));
        bataanMunicipalities.add(new Municipality("Morong", 14.6856, 120.2778));
        bataanMunicipalities.add(new Municipality("Orani", 14.6963, 120.5427));
        bataanMunicipalities.add(new Municipality("Orion", 14.7152, 120.5960));
        bataanMunicipalities.add(new Municipality("Pilar", 14.7633, 120.5106));
        bataanMunicipalities.add(new Municipality("Samal", 14.6464, 120.8105));
        central.put("bataan", bataanMunicipalities);

        // Bulacan
        ArrayList<Municipality> bulacanMunicipalities = new ArrayList<>();
        bulacanMunicipalities.add(new Municipality("Malolos", 14.8447, 120.8105));
        bulacanMunicipalities.add(new Municipality("Meycauayan", 14.7494, 120.9603));
        bulacanMunicipalities.add(new Municipality("San Jose del Monte", 14.8127, 121.0453));
        bulacanMunicipalities.add(new Municipality("Baliuag", 14.9540, 120.8963));
        bulacanMunicipalities.add(new Municipality("Bocaue", 14.8161, 120.9244));
        bulacanMunicipalities.add(new Municipality("Bulacan", 14.8477, 120.8740));
        bulacanMunicipalities.add(new Municipality("Bustos", 14.9558, 120.9574));
        bulacanMunicipalities.add(new Municipality("Calumpit", 14.8857, 120.7669));
        bulacanMunicipalities.add(new Municipality("Doña Remedios Trinidad", 14.9737, 121.0317));
        bulacanMunicipalities.add(new Municipality("Guiguinto", 14.8544, 120.8846));
        bulacanMunicipalities.add(new Municipality("Hagonoy", 14.8208, 120.7373));
        bulacanMunicipalities.add(new Municipality("Paombong", 14.9134, 120.7885));
        bulacanMunicipalities.add(new Municipality("Plaridel", 14.8822, 120.8702));
        bulacanMunicipalities.add(new Municipality("Pandi", 14.8863, 120.8888));
        bulacanMunicipalities.add(new Municipality("Pulilan", 14.9106, 120.8454));
        central.put("bulacan", bulacanMunicipalities);

// Nueva Ecija
        ArrayList<Municipality> nuevaEcijaMunicipalities = new ArrayList<>();
        nuevaEcijaMunicipalities.add(new Municipality("Cabanatuan", 15.4863, 120.9739));
        nuevaEcijaMunicipalities.add(new Municipality("Gapan", 15.2899, 120.9456));
        nuevaEcijaMunicipalities.add(new Municipality("San Jose", 15.7907, 120.9874));
        nuevaEcijaMunicipalities.add(new Municipality("San Leonardo", 15.3661, 120.9908));
        nuevaEcijaMunicipalities.add(new Municipality("Santa Rosa", 15.0814, 120.8294));
        nuevaEcijaMunicipalities.add(new Municipality("Talavera", 15.5540, 120.9372));
        nuevaEcijaMunicipalities.add(new Municipality("Aliaga", 15.4667, 121.1000));
        nuevaEcijaMunicipalities.add(new Municipality("Bongabon", 15.7024, 121.1246));
        nuevaEcijaMunicipalities.add(new Municipality("Cabanatuan", 15.3296, 120.8279));
        nuevaEcijaMunicipalities.add(new Municipality("Carranglan", 15.8560, 121.0845));
        nuevaEcijaMunicipalities.add(new Municipality("Cuyapo", 15.7161, 120.9506));
        nuevaEcijaMunicipalities.add(new Municipality("Gabaldon", 15.6825, 121.2354));
        nuevaEcijaMunicipalities.add(new Municipality("General Mamerto Natividad", 15.6635, 120.9382));
        nuevaEcijaMunicipalities.add(new Municipality("General Tinio", 15.2874, 121.0960));
        nuevaEcijaMunicipalities.add(new Municipality("Guimba", 15.6167, 120.9534));
        nuevaEcijaMunicipalities.add(new Municipality("Jaen", 15.1319, 120.9528));
        nuevaEcijaMunicipalities.add(new Municipality("Laur", 15.4343, 121.1390));
        nuevaEcijaMunicipalities.add(new Municipality("Licab", 15.7024, 120.7905));
        nuevaEcijaMunicipalities.add(new Municipality("Llanera", 15.6958, 120.9471));
        nuevaEcijaMunicipalities.add(new Municipality("Lupao", 15.6985, 121.1102));
        nuevaEcijaMunicipalities.add(new Municipality("Muñoz", 15.7167, 120.9000));
        nuevaEcijaMunicipalities.add(new Municipality("Nampicuan", 15.7417, 120.9937));
        nuevaEcijaMunicipalities.add(new Municipality("Palayan", 15.5362, 121.0941));
        nuevaEcijaMunicipalities.add(new Municipality("Pantabangan", 15.7000, 121.0333));
        nuevaEcijaMunicipalities.add(new Municipality("Peñaranda", 15.6013, 120.9427));
        nuevaEcijaMunicipalities.add(new Municipality("Quezon", 15.4813, 120.8192));
        nuevaEcijaMunicipalities.add(new Municipality("Rizal", 15.7589, 120.9770));
        nuevaEcijaMunicipalities.add(new Municipality("San Antonio", 15.3943, 120.8983));
        nuevaEcijaMunicipalities.add(new Municipality("San Isidro", 15.4167, 120.9333));
        nuevaEcijaMunicipalities.add(new Municipality("San Leonardo", 15.3686, 120.9828));
        nuevaEcijaMunicipalities.add(new Municipality("Santa Rosa", 15.0591, 120.9750));
        nuevaEcijaMunicipalities.add(new Municipality("Santo Domingo", 15.5587, 121.1302));
        nuevaEcijaMunicipalities.add(new Municipality("Talugtug", 15.6390, 121.0105));
        nuevaEcijaMunicipalities.add(new Municipality("Zaragoza", 15.3741, 120.9868));
        central.put("nueva ecija", nuevaEcijaMunicipalities);

// Pampanga
        ArrayList<Municipality> pampangaMunicipalities = new ArrayList<>();
        pampangaMunicipalities.add(new Municipality("Angeles", 15.1442, 120.5887));
        pampangaMunicipalities.add(new Municipality("San Fernando", 15.0363, 120.6919));
        pampangaMunicipalities.add(new Municipality("Apalit", 14.9556, 120.7672));
        pampangaMunicipalities.add(new Municipality("Arayat", 15.1500, 120.7722));
        pampangaMunicipalities.add(new Municipality("Bacolor", 15.1000, 120.6833));
        pampangaMunicipalities.add(new Municipality("Candaba", 15.0799, 120.8290));
        pampangaMunicipalities.add(new Municipality("Floridablanca", 14.9611, 120.4858));
        pampangaMunicipalities.add(new Municipality("Guagua", 14.9500, 120.6206));
        pampangaMunicipalities.add(new Municipality("Lubao", 14.9008, 120.6306));
        pampangaMunicipalities.add(new Municipality("Macabebe", 14.8980, 120.7427));
        pampangaMunicipalities.add(new Municipality("Magalang", 15.2144, 120.6651));
        pampangaMunicipalities.add(new Municipality("Masantol", 14.9639, 120.7824));
        pampangaMunicipalities.add(new Municipality("Mexico", 15.1142, 120.6950));
        pampangaMunicipalities.add(new Municipality("Minalin", 14.9556, 120.6194));
        pampangaMunicipalities.add(new Municipality("Porac", 15.0842, 120.5367));
        pampangaMunicipalities.add(new Municipality("San Luis", 15.0946, 120.6981));
        pampangaMunicipalities.add(new Municipality("San Simon", 15.1800, 120.8222));
        pampangaMunicipalities.add(new Municipality("Santa Ana", 15.7813, 120.6917));
        pampangaMunicipalities.add(new Municipality("Santa Rita", 15.1322, 120.6165));
        pampangaMunicipalities.add(new Municipality("Santo Tomas", 14.9476, 120.6433));
        pampangaMunicipalities.add(new Municipality("Sasmuan", 14.9792, 120.7163));
        central.put("pampanga", pampangaMunicipalities);
// Tarlac
        ArrayList<Municipality> tarlacMunicipalities = new ArrayList<>();
        tarlacMunicipalities.add(new Municipality("Tarlac City", 15.4926, 120.5976));
        tarlacMunicipalities.add(new Municipality("Concepcion", 15.3972, 120.6845));
        tarlacMunicipalities.add(new Municipality("Capas", 15.3272, 120.5822));
        tarlacMunicipalities.add(new Municipality("Bamban", 15.3667, 120.5500));
        tarlacMunicipalities.add(new Municipality("Camiling", 15.7083, 120.4104));
        tarlacMunicipalities.add(new Municipality("San Clemente", 15.6807, 120.4896));
        tarlacMunicipalities.add(new Municipality("Moncada", 15.7905, 120.5718));
        tarlacMunicipalities.add(new Municipality("Paniqui", 15.6984, 120.5700));
        tarlacMunicipalities.add(new Municipality("Pura", 15.5000, 120.6333));
        tarlacMunicipalities.add(new Municipality("Ramos", 15.6171, 120.7276));
        tarlacMunicipalities.add(new Municipality("San Jose", 15.5192, 120.5870));
        tarlacMunicipalities.add(new Municipality("San Manuel", 15.7281, 120.4092));
        tarlacMunicipalities.add(new Municipality("Santa Ignacia", 15.5822, 120.4982));
        tarlacMunicipalities.add(new Municipality("Victoria", 15.3925, 120.5812));
        central.put("tarlac", tarlacMunicipalities);

        return central;

    }

    public Map<String, List<Municipality>> ilocos(){

        Map<String, List<Municipality>> ilocos = new HashMap<>();
        // Ilocos Norte
        List<Municipality> ilocosNorteMunicipalities = new ArrayList<>();
        ilocosNorteMunicipalities.add(new Municipality("Adams", 18.4708, 120.8958));
        ilocosNorteMunicipalities.add(new Municipality("Bacarra", 18.2483, 120.6067));
        ilocosNorteMunicipalities.add(new Municipality("Badoc", 17.9139, 120.4342));
        ilocosNorteMunicipalities.add(new Municipality("Bangui", 18.5169, 120.6667));
        ilocosNorteMunicipalities.add(new Municipality("Banna", 18.3039, 120.6939));
        ilocosNorteMunicipalities.add(new Municipality("Batac", 18.0550, 120.5642));
        ilocosNorteMunicipalities.add(new Municipality("Burgos", 18.3408, 120.6181));
        ilocosNorteMunicipalities.add(new Municipality("Carasi", 18.1742, 120.8925));
        ilocosNorteMunicipalities.add(new Municipality("Currimao", 18.1011, 120.4578));
        ilocosNorteMunicipalities.add(new Municipality("Dingras", 18.0817, 120.6317));
        ilocosNorteMunicipalities.add(new Municipality("Dumalneg", 18.0833, 120.9000));
        ilocosNorteMunicipalities.add(new Municipality("Laoag City", 18.1983, 120.5958));
        ilocosNorteMunicipalities.add(new Municipality("Marcos", 17.9803, 120.4953));
        ilocosNorteMunicipalities.add(new Municipality("Nueva Era", 18.0619, 120.9278));
        ilocosNorteMunicipalities.add(new Municipality("Pagudpud", 18.5611, 120.7861));
        ilocosNorteMunicipalities.add(new Municipality("Paoay", 18.0708, 120.5428));
        ilocosNorteMunicipalities.add(new Municipality("Pasuquin", 18.2561, 120.6172));
        ilocosNorteMunicipalities.add(new Municipality("Piddig", 18.2022, 120.6061));
        ilocosNorteMunicipalities.add(new Municipality("Pinili", 18.0478, 120.6217));
        ilocosNorteMunicipalities.add(new Municipality("San Nicolas", 18.1714, 120.6047));
        ilocosNorteMunicipalities.add(new Municipality("Sarrat", 18.1667, 120.6175));
        ilocosNorteMunicipalities.add(new Municipality("Solsona", 18.0911, 120.7911));
        ilocosNorteMunicipalities.add(new Municipality("Vintar", 18.0903, 120.6894));
        ilocos.put("ilocos norte", ilocosNorteMunicipalities);

// Ilocos Sur
        List<Municipality> ilocosSurMunicipalities = new ArrayList<>();
        ilocosSurMunicipalities.add(new Municipality("Alilem", 16.6189, 120.4861));
        ilocosSurMunicipalities.add(new Municipality("Banayoyo", 17.3108, 120.4819));
        ilocosSurMunicipalities.add(new Municipality("Bantay", 17.5525, 120.3881));
        ilocosSurMunicipalities.add(new Municipality("Burgos", 17.4417, 120.4444));
        ilocosSurMunicipalities.add(new Municipality("Cabugao", 17.7833, 120.4575));
        ilocosSurMunicipalities.add(new Municipality("Candon City", 17.1867, 120.4478));
        ilocosSurMunicipalities.add(new Municipality("Caoayan", 17.5239, 120.4347));
        ilocosSurMunicipalities.add(new Municipality("Cervantes", 16.9708, 120.8842));
        ilocosSurMunicipalities.add(new Municipality("Galimuyod", 17.5247, 120.3867));
        ilocosSurMunicipalities.add(new Municipality("Gregorio Del Pilar", 17.1747, 120.7161));
        ilocosSurMunicipalities.add(new Municipality("Lidlidda", 17.3789, 120.6394));
        ilocosSurMunicipalities.add(new Municipality("Magsingal", 17.7847, 120.4525));
        ilocosSurMunicipalities.add(new Municipality("Nagbukel", 17.5236, 120.5456));
        ilocosSurMunicipalities.add(new Municipality("Narvacan", 17.4319, 120.4475));
        ilocosSurMunicipalities.add(new Municipality("Quirino", 17.5578, 120.6525));
        ilocosSurMunicipalities.add(new Municipality("Salcedo", 17.1428, 120.6842));
        ilocosSurMunicipalities.add(new Municipality("San Emilio", 17.5364, 120.6206));
        ilocosSurMunicipalities.add(new Municipality("San Esteban", 17.6292, 120.5303));
        ilocosSurMunicipalities.add(new Municipality("San Ildefonso", 17.8128, 120.4006));
        ilocosSurMunicipalities.add(new Municipality("San Juan", 17.5156, 120.4431));
        ilocosSurMunicipalities.add(new Municipality("San Vicente", 17.2175, 120.3892));
        ilocosSurMunicipalities.add(new Municipality("Santa", 17.4692, 120.4492));
        ilocosSurMunicipalities.add(new Municipality("Santa Catalina", 17.5028, 120.4542));
        ilocosSurMunicipalities.add(new Municipality("Santa Cruz", 17.3836, 120.4181));
        ilocosSurMunicipalities.add(new Municipality("Santa Lucia", 17.2717, 120.5603));
        ilocosSurMunicipalities.add(new Municipality("Santa Maria", 17.5653, 120.3583));
        ilocosSurMunicipalities.add(new Municipality("Santiago", 17.6875, 120.3808));
        ilocosSurMunicipalities.add(new Municipality("Santo Domingo", 17.4822, 120.4339));
        ilocosSurMunicipalities.add(new Municipality("Sigay", 17.2656, 120.5492));
        ilocosSurMunicipalities.add(new Municipality("Sinait", 17.7347, 120.4314));
        ilocosSurMunicipalities.add(new Municipality("Sugpon", 16.8131, 120.8919));
        ilocosSurMunicipalities.add(new Municipality("Suyo", 17.6531, 120.3931));
        ilocosSurMunicipalities.add(new Municipality("Tagudin", 16.9428, 120.4111));
        ilocos.put("ilocos sur", ilocosSurMunicipalities);

        return ilocos;

    }
    public Map<String, List<Municipality>> calabarzon(){
        Map<String, List<Municipality>> calab = new HashMap<>();
        List<Municipality> batangasMunicipalities = new ArrayList<>();

        batangasMunicipalities.add(new Municipality("Batangas City", 13.7567, 121.0584));
        batangasMunicipalities.add(new Municipality("Lipa City", 13.9394, 121.1805));
        batangasMunicipalities.add(new Municipality("Tanauan City", 14.0869, 121.1439));
        batangasMunicipalities.add(new Municipality("Santo Tomas", 14.1072, 121.1369));
        batangasMunicipalities.add(new Municipality("Malvar", 14.0900, 121.0328));
        batangasMunicipalities.add(new Municipality("Bauan", 13.7590, 121.0090));
        batangasMunicipalities.add(new Municipality("San Pascual", 13.8614, 121.0389));
        batangasMunicipalities.add(new Municipality("Calaca", 13.9261, 120.8533));
        batangasMunicipalities.add(new Municipality("Nasugbu", 14.0914, 120.6270));
        batangasMunicipalities.add(new Municipality("Lemery", 13.9392, 120.9352));
        batangasMunicipalities.add(new Municipality("Taal", 13.8804, 120.9268));
        batangasMunicipalities.add(new Municipality("Laurel", 14.0711, 121.0155));
        batangasMunicipalities.add(new Municipality("Rosario", 13.9883, 121.2091));
        batangasMunicipalities.add(new Municipality("San Jose", 13.9363, 121.1458));
        batangasMunicipalities.add(new Municipality("Cuenca", 13.8829, 120.9525));
        batangasMunicipalities.add(new Municipality("Balayan", 13.9224, 120.7762));
        batangasMunicipalities.add(new Municipality("Calatagan", 13.9231, 120.6280));
        batangasMunicipalities.add(new Municipality("Ibaan", 13.8292, 121.1367));
        batangasMunicipalities.add(new Municipality("Padre Garcia", 13.9639, 121.3275));
        batangasMunicipalities.add(new Municipality("Agoncillo", 13.8622, 120.9642));
        batangasMunicipalities.add(new Municipality("Tuy", 13.8775, 120.7821));
        batangasMunicipalities.add(new Municipality("Alitagtag", 13.9275, 121.0417));
        batangasMunicipalities.add(new Municipality("San Nicolas", 13.8844, 121.0253));
        batangasMunicipalities.add(new Municipality("Mataasnakahoy", 13.8814, 121.0272));
        batangasMunicipalities.add(new Municipality("Santa Teresita", 13.8581, 120.9078));
        batangasMunicipalities.add(new Municipality("San Luis", 13.9969, 121.2164));
        batangasMunicipalities.add(new Municipality("Calaca", 13.9261, 120.8533));
        batangasMunicipalities.add(new Municipality("Mabini", 13.9058, 120.9293));
        batangasMunicipalities.add(new Municipality("Lian", 13.9222, 120.6803));
        batangasMunicipalities.add(new Municipality("Tingloy", 13.6483, 120.8550));
        batangasMunicipalities.add(new Municipality("Talisay", 13.9433, 121.0620));
        batangasMunicipalities.add(new Municipality("San Juan", 13.8363, 122.0441));
        calab.put("batangas", batangasMunicipalities);

        List<Municipality> caviteMunicipalities = new ArrayList<>();

        caviteMunicipalities.add(new Municipality("Dasmariñas", 14.3294, 120.9367));
        caviteMunicipalities.add(new Municipality("Bacoor", 14.4177, 120.9364));
        caviteMunicipalities.add(new Municipality("General Trias", 14.3857, 120.8811));
        caviteMunicipalities.add(new Municipality("Imus", 14.4297, 120.9365));
        caviteMunicipalities.add(new Municipality("Tagaytay City", 14.1156, 120.9627));
        caviteMunicipalities.add(new Municipality("Trece Martires City", 14.2836, 120.8617));
        caviteMunicipalities.add(new Municipality("Tanza", 14.4064, 120.9006));
        caviteMunicipalities.add(new Municipality("Silang", 14.2294, 120.9736));
        caviteMunicipalities.add(new Municipality("Noveleta", 14.4503, 120.9562));
        caviteMunicipalities.add(new Municipality("Kawit", 14.4469, 120.9117));
        caviteMunicipalities.add(new Municipality("Rosario", 14.4309, 120.8849));
        caviteMunicipalities.add(new Municipality("Alfonso", 14.1499, 120.8787));
        caviteMunicipalities.add(new Municipality("Naic", 14.3167, 120.7500));
        caviteMunicipalities.add(new Municipality("Magallanes", 14.2936, 120.7544));
        caviteMunicipalities.add(new Municipality("Mendez", 14.1500, 120.9528));
        caviteMunicipalities.add(new Municipality("Indang", 14.1908, 120.8786));
        caviteMunicipalities.add(new Municipality("Carmona", 14.3072, 121.0275));
        caviteMunicipalities.add(new Municipality("General Emilio Aguinaldo", 14.0936, 120.9492));
        caviteMunicipalities.add(new Municipality("Ternate", 14.3000, 120.7000));
        caviteMunicipalities.add(new Municipality("Maragondon", 14.1939, 120.7014));
        calab.put("cavite", caviteMunicipalities);

        List<Municipality> lagunaMunicipalities = new ArrayList<>();

        lagunaMunicipalities.add(new Municipality("San Pablo City", 14.0679, 121.3252));
        lagunaMunicipalities.add(new Municipality("Santa Rosa City", 14.3167, 121.1064));
        lagunaMunicipalities.add(new Municipality("Calamba City", 14.2117, 121.1653));
        lagunaMunicipalities.add(new Municipality("Biñan City", 14.2941, 121.0794));
        lagunaMunicipalities.add(new Municipality("Cabuyao City", 14.2784, 121.1439));
        lagunaMunicipalities.add(new Municipality("Los Baños", 14.1783, 121.2258));
        lagunaMunicipalities.add(new Municipality("San Pedro", 14.3644, 121.0473));
        lagunaMunicipalities.add(new Municipality("Santa Cruz", 14.2800, 121.4156));
        lagunaMunicipalities.add(new Municipality("Calauan", 14.1582, 121.3089));
        lagunaMunicipalities.add(new Municipality("Victoria", 14.1467, 121.2789));
        lagunaMunicipalities.add(new Municipality("Pila", 14.2817, 121.3656));
        lagunaMunicipalities.add(new Municipality("Nagcarlan", 14.1364, 121.4175));
        lagunaMunicipalities.add(new Municipality("Liliw", 14.1425, 121.4481));
        lagunaMunicipalities.add(new Municipality("Sta. Maria", 14.0994, 121.3672));
        lagunaMunicipalities.add(new Municipality("Pangil", 14.3091, 121.4875));
        lagunaMunicipalities.add(new Municipality("Mabitac", 14.3720, 121.4603));
        lagunaMunicipalities.add(new Municipality("Cavinti", 14.2869, 121.5172));
        lagunaMunicipalities.add(new Municipality("Kalayaan", 14.1753, 121.3066));
        lagunaMunicipalities.add(new Municipality("Paete", 14.3689, 121.4856));
        lagunaMunicipalities.add(new Municipality("Pakil", 14.3714, 121.4631));
        lagunaMunicipalities.add(new Municipality("Pagsanjan", 14.2742, 121.4575));
        lagunaMunicipalities.add(new Municipality("Rizal", 14.2783, 121.4747));
        lagunaMunicipalities.add(new Municipality("Siniloan", 14.3967, 121.4683));
        lagunaMunicipalities.add(new Municipality("Famy", 14.3967, 121.4683));
        lagunaMunicipalities.add(new Municipality("Luisiana", 14.1347, 121.4808));
        lagunaMunicipalities.add(new Municipality("Magdalena", 14.1023, 121.4841));
        lagunaMunicipalities.add(new Municipality("Santa Maria", 14.3200, 121.0383));
        lagunaMunicipalities.add(new Municipality("Majayjay", 14.1104, 121.4167));
        lagunaMunicipalities.add(new Municipality("Alaminos", 14.0719, 121.3653));
        calab.put("laguna", lagunaMunicipalities);

        List<Municipality> quezonMunicipalities = new ArrayList<>();

        quezonMunicipalities.add(new Municipality("Lucena City", 13.9314, 121.6174));
        quezonMunicipalities.add(new Municipality("Tayabas City", 13.9379, 121.4180));
        quezonMunicipalities.add(new Municipality("Sariaya", 13.9814, 121.5151));
        quezonMunicipalities.add(new Municipality("Candelaria", 13.9300, 121.4244));
        quezonMunicipalities.add(new Municipality("Gumaca", 13.9008, 122.0969));
        quezonMunicipalities.add(new Municipality("Pagbilao", 13.9572, 121.7122));
        quezonMunicipalities.add(new Municipality("Lucban", 14.1131, 121.5580));
        quezonMunicipalities.add(new Municipality("Mauban", 14.1756, 121.7439));
        quezonMunicipalities.add(new Municipality("Atimonan", 13.9739, 121.9083));
        quezonMunicipalities.add(new Municipality("Dolores", 13.9429, 122.1089));
        quezonMunicipalities.add(new Municipality("Pitogo", 13.8661, 122.5183));
        quezonMunicipalities.add(new Municipality("Mulanay", 13.5733, 122.3869));
        quezonMunicipalities.add(new Municipality("Unisan", 13.8753, 122.1836));
        quezonMunicipalities.add(new Municipality("Tiaong", 13.9461, 121.3275));
        quezonMunicipalities.add(new Municipality("Guinayangan", 13.9346, 122.5353));
        quezonMunicipalities.add(new Municipality("Agdangan", 13.8267, 122.5092));
        quezonMunicipalities.add(new Municipality("Padre Burgos", 13.9494, 122.1917));
        quezonMunicipalities.add(new Municipality("Macalelon", 13.8769, 122.2000));
        quezonMunicipalities.add(new Municipality("San Francisco", 13.8050, 122.1178));
        quezonMunicipalities.add(new Municipality("Catanauan", 13.5986, 122.4722));
        quezonMunicipalities.add(new Municipality("Perez", 14.0453, 121.5261));
        quezonMunicipalities.add(new Municipality("Alabat", 14.1106, 122.0083));
        quezonMunicipalities.add(new Municipality("Tagkawayan", 13.9780, 122.5683));
        quezonMunicipalities.add(new Municipality("Calauag", 13.9478, 122.3631));
        quezonMunicipalities.add(new Municipality("Quezon", 14.0383, 122.1239));
        quezonMunicipalities.add(new Municipality("Lopez", 13.9872, 122.4864));
        quezonMunicipalities.add(new Municipality("General Luna", 13.8361, 122.3081));
        quezonMunicipalities.add(new Municipality("Pitogo", 13.7500, 122.7333));
        quezonMunicipalities.add(new Municipality("Real", 13.7464, 122.4203));
        calab.put("quezon", quezonMunicipalities);

        List<Municipality> rizalMunicipalities = new ArrayList<>();

        rizalMunicipalities.add(new Municipality("Antipolo City", 14.6255, 121.1226));
        rizalMunicipalities.add(new Municipality("Rodriguez", 14.7319, 121.1421));
        rizalMunicipalities.add(new Municipality("Cainta", 14.5833, 121.1167));
        rizalMunicipalities.add(new Municipality("Taytay", 14.5703, 121.1290));
        rizalMunicipalities.add(new Municipality("Binangonan", 14.4653, 121.1939));
        rizalMunicipalities.add(new Municipality("Morong", 14.5278, 121.2444));
        rizalMunicipalities.add(new Municipality("Angono", 14.5181, 121.1481));
        rizalMunicipalities.add(new Municipality("Tanay", 14.5000, 121.3000));
        rizalMunicipalities.add(new Municipality("Jalajala", 14.4050, 121.3290));
        rizalMunicipalities.add(new Municipality("San Mateo", 14.7047, 121.1296));
        rizalMunicipalities.add(new Municipality("Pililla", 14.4217, 121.2897));
        rizalMunicipalities.add(new Municipality("Cardona", 14.4608, 121.2731));
        rizalMunicipalities.add(new Municipality("Baras", 14.6175, 121.2908));
        rizalMunicipalities.add(new Municipality("Teresa", 14.5688, 121.2231));
        rizalMunicipalities.add(new Municipality("Tanay", 14.5253, 121.2875));
        calab.put("rizal",rizalMunicipalities);

        return calab;

    }

    public Map<String, List<Municipality>> westerVisayan(){
        Map<String, List<Municipality>> western = new HashMap<>();

        List<Municipality> aklanMunicipalities = new ArrayList<>();

        aklanMunicipalities.add(new Municipality("Altavas", 11.6156, 122.4283));
        aklanMunicipalities.add(new Municipality("Balete", 11.7016, 122.3737));
        aklanMunicipalities.add(new Municipality("Banga", 11.6131, 122.3652));
        aklanMunicipalities.add(new Municipality("Batan", 11.6431, 122.4023));
        aklanMunicipalities.add(new Municipality("Buruanga", 11.8299, 122.1168));
        aklanMunicipalities.add(new Municipality("Ibajay", 11.7812, 122.2387));
        aklanMunicipalities.add(new Municipality("Kalibo", 11.7086, 122.3660));
        aklanMunicipalities.add(new Municipality("Lezo", 11.7314, 122.3156));
        aklanMunicipalities.add(new Municipality("Libacao", 11.5615, 122.3127));
        aklanMunicipalities.add(new Municipality("Madalag", 11.6807, 122.2693));
        aklanMunicipalities.add(new Municipality("Makato", 11.6940, 122.3601));
        aklanMunicipalities.add(new Municipality("Malay", 11.9679, 121.9243));
        aklanMunicipalities.add(new Municipality("Malinao", 11.6465, 122.2964));
        aklanMunicipalities.add(new Municipality("Nabas", 11.9281, 122.0931));
        aklanMunicipalities.add(new Municipality("New Washington", 11.6167, 122.4167));
        aklanMunicipalities.add(new Municipality("Numancia", 11.6242, 122.3884));
        aklanMunicipalities.add(new Municipality("Tangalan", 11.6448, 122.4153));
        western.put("aklan", aklanMunicipalities);

        List<Municipality> antiqueMunicipalities = new ArrayList<>();

        antiqueMunicipalities.add(new Municipality("Anini-y", 10.4864, 121.9832));
        antiqueMunicipalities.add(new Municipality("Barbaza", 10.9356, 122.1796));
        antiqueMunicipalities.add(new Municipality("Belison", 10.9016, 122.0515));
        antiqueMunicipalities.add(new Municipality("Bugasong", 10.9439, 122.0643));
        antiqueMunicipalities.add(new Municipality("Caluya", 11.1372, 121.8667));
        antiqueMunicipalities.add(new Municipality("Culasi", 11.2484, 122.0096));
        antiqueMunicipalities.add(new Municipality("Hamtic", 10.9350, 121.9575));
        antiqueMunicipalities.add(new Municipality("Laua-an", 10.8647, 121.9873));
        antiqueMunicipalities.add(new Municipality("Libertad", 10.8486, 121.9872));
        antiqueMunicipalities.add(new Municipality("Pandan", 11.7234, 122.0904));
        antiqueMunicipalities.add(new Municipality("Patnongon", 10.8623, 122.0939));
        antiqueMunicipalities.add(new Municipality("San Jose", 10.7410, 121.9713));
        antiqueMunicipalities.add(new Municipality("San Remigio", 11.3428, 122.1229));
        antiqueMunicipalities.add(new Municipality("Sebaste", 11.2672, 122.0919));
        antiqueMunicipalities.add(new Municipality("Sibalom", 10.9329, 122.0142));
        antiqueMunicipalities.add(new Municipality("Tibiao", 11.2656, 122.0597));
        antiqueMunicipalities.add(new Municipality("Tobias Fornier", 10.9425, 121.9414));
        antiqueMunicipalities.add(new Municipality("Valderrama", 10.7630, 122.1695));
        western.put("antique", antiqueMunicipalities);

        List<Municipality> capizMunicipalities = new ArrayList<>();

        capizMunicipalities.add(new Municipality("Cuartero", 11.2991, 122.6510));
        capizMunicipalities.add(new Municipality("Dao", 11.4813, 122.6660));
        capizMunicipalities.add(new Municipality("Dumalag", 11.3240, 122.6924));
        capizMunicipalities.add(new Municipality("Dumarao", 11.2810, 122.5725));
        capizMunicipalities.add(new Municipality("Ivisan", 11.5150, 122.6344));
        capizMunicipalities.add(new Municipality("Jamindan", 11.3613, 122.5987));
        capizMunicipalities.add(new Municipality("Maayon", 11.2874, 122.6515));
        capizMunicipalities.add(new Municipality("Mambusao", 11.4756, 122.6247));
        capizMunicipalities.add(new Municipality("Panay", 11.4377, 122.7092));
        capizMunicipalities.add(new Municipality("Panitan", 11.3703, 122.7140));
        capizMunicipalities.add(new Municipality("Pilar", 11.3284, 122.7852));
        capizMunicipalities.add(new Municipality("Pontevedra", 11.3073, 122.6426));
        capizMunicipalities.add(new Municipality("President Roxas", 11.2431, 122.6233));
        capizMunicipalities.add(new Municipality("Roxas City", 11.5863, 122.7513));
        capizMunicipalities.add(new Municipality("Sapi-an", 11.2976, 122.6101));
        capizMunicipalities.add(new Municipality("Sigma", 11.2316, 122.6859));
        capizMunicipalities.add(new Municipality("Tapaz", 11.1932, 122.6901));
        western.put("capiz", capizMunicipalities);

        List<Municipality> guimarasMunicipalities = new ArrayList<>();

        guimarasMunicipalities.add(new Municipality("Buenavista", 10.5722, 122.6177));
        guimarasMunicipalities.add(new Municipality("Jordan", 10.5843, 122.6036));
        guimarasMunicipalities.add(new Municipality("Nueva Valencia", 10.5861, 122.5259));
        guimarasMunicipalities.add(new Municipality("San Lorenzo", 10.5665, 122.5114));
        guimarasMunicipalities.add(new Municipality("Sibunag", 10.6001, 122.5433));
        western.put("guimaras", guimarasMunicipalities);

        List<Municipality> iloiloMunicipalities = new ArrayList<>();
        iloiloMunicipalities.add(new Municipality("Ajuy", 11.3396, 123.0624));
        iloiloMunicipalities.add(new Municipality("Alimodian", 10.8564, 122.4286));
        iloiloMunicipalities.add(new Municipality("Anilao", 11.1239, 122.6540));
        iloiloMunicipalities.add(new Municipality("Badiangan", 10.8259, 122.5719));
        iloiloMunicipalities.add(new Municipality("Balasan", 11.3453, 123.0677));
        iloiloMunicipalities.add(new Municipality("Banate", 11.1894, 122.7779));
        iloiloMunicipalities.add(new Municipality("Barotac Nuevo", 11.0602, 122.7346));
        iloiloMunicipalities.add(new Municipality("Barotac Viejo", 10.9245, 122.7203));
        iloiloMunicipalities.add(new Municipality("Batad", 11.1193, 122.7645));
        iloiloMunicipalities.add(new Municipality("Bingawan", 11.0695, 122.4016));
        iloiloMunicipalities.add(new Municipality("Cabatuan", 10.8697, 122.4894));
        iloiloMunicipalities.add(new Municipality("Calinog", 11.0922, 122.4962));
        iloiloMunicipalities.add(new Municipality("Carles", 11.4234, 123.1696));
        iloiloMunicipalities.add(new Municipality("Concepcion", 11.0529, 123.0892));
        iloiloMunicipalities.add(new Municipality("Dingle", 11.0225, 122.6431));
        iloiloMunicipalities.add(new Municipality("Dueñas", 10.9989, 122.5652));
        iloiloMunicipalities.add(new Municipality("Dumangas", 10.8316, 122.6987));
        iloiloMunicipalities.add(new Municipality("Estancia", 11.4340, 123.1549));
        iloiloMunicipalities.add(new Municipality("Guimbal", 10.6942, 122.3701));
        iloiloMunicipalities.add(new Municipality("Igbaras", 10.8115, 122.3695));
        iloiloMunicipalities.add(new Municipality("Iloilo City", 10.7202, 122.5621));
        iloiloMunicipalities.add(new Municipality("Janiuay", 10.9030, 122.5630));
        iloiloMunicipalities.add(new Municipality("Lambunao", 11.0434, 122.5033));
        iloiloMunicipalities.add(new Municipality("Leganes", 10.7986, 122.5558));
        iloiloMunicipalities.add(new Municipality("Lemery", 10.8940, 122.5115));
        iloiloMunicipalities.add(new Municipality("Leon", 10.8689, 122.4057));
        iloiloMunicipalities.add(new Municipality("Maasin", 10.9359, 122.5225));
        iloiloMunicipalities.add(new Municipality("Miagao", 10.6132, 122.2730));
        iloiloMunicipalities.add(new Municipality("Mina", 10.9465, 122.5254));
        iloiloMunicipalities.add(new Municipality("New Lucena", 10.8132, 122.4203));
        iloiloMunicipalities.add(new Municipality("Oton", 10.7089, 122.5426));
        iloiloMunicipalities.add(new Municipality("Pavia", 10.7650, 122.5630));
        iloiloMunicipalities.add(new Municipality("Passi City", 11.1005, 122.6412));
        iloiloMunicipalities.add(new Municipality("Pototan", 10.9438, 122.5616));
        iloiloMunicipalities.add(new Municipality("San Dionisio", 11.2469, 123.0852));
        iloiloMunicipalities.add(new Municipality("San Enrique", 10.7761, 122.5614));
        iloiloMunicipalities.add(new Municipality("San Joaquin", 10.6177, 122.4094));
        iloiloMunicipalities.add(new Municipality("San Miguel", 11.3256, 123.0463));
        iloiloMunicipalities.add(new Municipality("San Rafael", 11.0582, 122.5066));
        iloiloMunicipalities.add(new Municipality("Santa Barbara", 10.7996, 122.5364));
        iloiloMunicipalities.add(new Municipality("Sara", 11.1897, 122.7495));
        iloiloMunicipalities.add(new Municipality("Tigbauan", 10.8257, 122.5190));
        iloiloMunicipalities.add(new Municipality("Tubungan", 10.7408, 122.4093));
        iloiloMunicipalities.add(new Municipality("Zarraga", 10.8922, 122.6046));
        western.put("ilo-ilo", iloiloMunicipalities);

        List<Municipality> negrosOccidentalMunicipalities = new ArrayList<>();
        negrosOccidentalMunicipalities.add(new Municipality("Bacolod City", 10.6407, 122.9688));
        negrosOccidentalMunicipalities.add(new Municipality("Bago City", 10.5323, 122.8353));
        negrosOccidentalMunicipalities.add(new Municipality("Binalbagan", 10.2082, 122.8763));
        negrosOccidentalMunicipalities.add(new Municipality("Cadiz City", 10.9536, 123.3092));
        negrosOccidentalMunicipalities.add(new Municipality("Calatrava", 10.8949, 123.2669));
        negrosOccidentalMunicipalities.add(new Municipality("Candoni", 9.9450, 122.7513));
        negrosOccidentalMunicipalities.add(new Municipality("Cauayan", 10.9100, 122.7607));
        negrosOccidentalMunicipalities.add(new Municipality("Enrique B. Magalona", 10.9450, 122.7517));
        negrosOccidentalMunicipalities.add(new Municipality("Escalante City", 10.8336, 123.4973));
        negrosOccidentalMunicipalities.add(new Municipality("Himamaylan City", 10.0899, 122.8703));
        negrosOccidentalMunicipalities.add(new Municipality("Hinigaran", 10.2795, 122.8774));
        negrosOccidentalMunicipalities.add(new Municipality("Hinoba-an", 9.9622, 122.4040));
        negrosOccidentalMunicipalities.add(new Municipality("Ilog", 10.3614, 123.0089));
        negrosOccidentalMunicipalities.add(new Municipality("Isabela", 10.2366, 122.8539));
        negrosOccidentalMunicipalities.add(new Municipality("Kabankalan City", 9.9884, 122.8130));
        negrosOccidentalMunicipalities.add(new Municipality("La Carlota City", 10.4107, 122.9395));
        negrosOccidentalMunicipalities.add(new Municipality("La Castellana", 10.3283, 122.9459));
        negrosOccidentalMunicipalities.add(new Municipality("Manapla", 10.9531, 123.1267));
        negrosOccidentalMunicipalities.add(new Municipality("Moises Padilla", 10.0212, 122.8061));
        negrosOccidentalMunicipalities.add(new Municipality("Murcia", 10.3490, 123.0375));
        negrosOccidentalMunicipalities.add(new Municipality("Pontevedra", 10.3287, 122.9219));
        negrosOccidentalMunicipalities.add(new Municipality("Pulupandan", 10.3970, 122.8363));
        negrosOccidentalMunicipalities.add(new Municipality("Sagay City", 10.9440, 123.4238));
        negrosOccidentalMunicipalities.add(new Municipality("Salvador Benedicto", 10.5552, 123.2548));
        negrosOccidentalMunicipalities.add(new Municipality("San Carlos City", 10.4863, 123.3723));
        negrosOccidentalMunicipalities.add(new Municipality("San Enrique", 10.7761, 122.5614));
        negrosOccidentalMunicipalities.add(new Municipality("Silay City", 10.8039, 122.9787));
        negrosOccidentalMunicipalities.add(new Municipality("Sipalay City", 9.7533, 122.4101));
        negrosOccidentalMunicipalities.add(new Municipality("Talisay City", 10.7802, 122.9863));
        negrosOccidentalMunicipalities.add(new Municipality("Toboso", 10.7424, 123.2386));
        negrosOccidentalMunicipalities.add(new Municipality("Valladolid", 10.3892, 122.8459));
        negrosOccidentalMunicipalities.add(new Municipality("Victorias City", 10.9135, 123.0760));
        western.put("negros occidental", negrosOccidentalMunicipalities);


//        List<Municipality> negrosOrientalMunicipalities = new ArrayList<>();
//        negrosOrientalMunicipalities.add(new Municipality("Amlan", 9.5081, 123.1867));
//        negrosOrientalMunicipalities.add(new Municipality("Ayungon", 9.7459, 123.2923));
//        negrosOrientalMunicipalities.add(new Municipality("Bacong", 9.2453, 123.2755));
//        negrosOrientalMunicipalities.add(new Municipality("Bais City", 9.5904, 123.1225));
//        negrosOrientalMunicipalities.add(new Municipality("Basay", 9.4120, 122.7657));
//        negrosOrientalMunicipalities.add(new Municipality("Bindoy", 9.6827, 123.2042));
//        negrosOrientalMunicipalities.add(new Municipality("Canlaon City", 10.4010, 123.1969));
//        negrosOrientalMunicipalities.add(new Municipality("Dauin", 9.1779, 123.2532));
//        negrosOrientalMunicipalities.add(new Municipality("Dumaguete City", 9.3074, 123.3022));
//        negrosOrientalMunicipalities.add(new Municipality("Guihulngan City", 10.1382, 123.2398));
//        negrosOrientalMunicipalities.add(new Municipality("Jimalalud", 9.8327, 123.2303));
//        negrosOrientalMunicipalities.add(new Municipality("La Libertad", 9.4085, 123.1732));
//        negrosOrientalMunicipalities.add(new Municipality("Mabinay", 9.5499, 123.2334));
//        negrosOrientalMunicipalities.add(new Municipality("Manjuyod", 9.5312, 123.1669));
//        negrosOrientalMunicipalities.add(new Municipality("Pamplona", 9.5913, 122.8715));
//        negrosOrientalMunicipalities.add(new Municipality("San Jose", 9.4081, 122.9089));
//        negrosOrientalMunicipalities.add(new Municipality("Santa Catalina", 9.5111, 122.9451));
//        negrosOrientalMunicipalities.add(new Municipality("Siaton", 9.0993, 123.1976));
//        negrosOrientalMunicipalities.add(new Municipality("Sibulan", 9.3185, 123.3072));
//        negrosOrientalMunicipalities.add(new Municipality("Tanjay City", 9.5156, 123.1574));
//        negrosOrientalMunicipalities.add(new Municipality("Tayasan", 9.5602, 123.1987));
//        negrosOrientalMunicipalities.add(new Municipality("Valencia", 9.2535, 123.1431));
//        western.put("negrs Oriental", negrosOrientalMunicipalities);



        return western;
    }

    public Map<String, List<Municipality>> centralVisayas(){
        Map<String, List<Municipality>> central = new HashMap<>();

        List<Municipality> cebuMunicipalities = new ArrayList<>();

        cebuMunicipalities.add(new Municipality("Alcantara", 10.0600, 123.4733));
        cebuMunicipalities.add(new Municipality("Alcoy", 9.7500, 123.5467));
        cebuMunicipalities.add(new Municipality("Alegria", 9.9961, 123.3847));
        cebuMunicipalities.add(new Municipality("Aloguinsan", 10.2139, 123.6239));
        cebuMunicipalities.add(new Municipality("Argao", 9.8675, 123.6033));
        cebuMunicipalities.add(new Municipality("Asturias", 10.5947, 123.7736));
        cebuMunicipalities.add(new Municipality("Badian", 9.9497, 123.3847));
        cebuMunicipalities.add(new Municipality("Balamban", 10.5267, 123.7186));
        cebuMunicipalities.add(new Municipality("Bantayan", 11.1673, 123.7208));
        cebuMunicipalities.add(new Municipality("Barili", 10.1336, 123.5192));
        cebuMunicipalities.add(new Municipality("Boljoon", 9.6356, 123.4942));
        cebuMunicipalities.add(new Municipality("Borbon", 10.6700, 124.0197));
        cebuMunicipalities.add(new Municipality("Carcar", 10.1042, 123.6419));
        cebuMunicipalities.add(new Municipality("Carmen", 10.4600, 123.9492));
        cebuMunicipalities.add(new Municipality("Catmon", 11.2464, 123.9492));
        cebuMunicipalities.add(new Municipality("Compostela", 10.4628, 124.0025));
        cebuMunicipalities.add(new Municipality("Consolacion", 10.3650, 123.9572));
        cebuMunicipalities.add(new Municipality("Cordova", 10.2622, 123.9583));
        cebuMunicipalities.add(new Municipality("Daanbantayan", 11.2167, 124.0144));
        cebuMunicipalities.add(new Municipality("Dalaguete", 9.7647, 123.5347));
        cebuMunicipalities.add(new Municipality("Danao", 10.5158, 124.0003));
        cebuMunicipalities.add(new Municipality("Dumanjug", 10.1481, 123.5153));
        cebuMunicipalities.add(new Municipality("Ginatilan", 9.6350, 123.2875));
        cebuMunicipalities.add(new Municipality("Liloan", 10.3964, 123.9983));
        cebuMunicipalities.add(new Municipality("Madridejos", 11.2411, 123.7561));
        cebuMunicipalities.add(new Municipality("Malabuyoc", 9.7872, 123.4072));
        cebuMunicipalities.add(new Municipality("Medellin", 11.1150, 123.9467));
        cebuMunicipalities.add(new Municipality("Minglanilla", 10.2536, 123.7967));
        cebuMunicipalities.add(new Municipality("Moalboal", 9.9550, 123.3800));
        cebuMunicipalities.add(new Municipality("Naga", 10.2317, 123.7625));
        cebuMunicipalities.add(new Municipality("Oslob", 9.5117, 123.3992));
        cebuMunicipalities.add(new Municipality("Pilar", 10.2558, 124.0011));
        cebuMunicipalities.add(new Municipality("Pinamungajan", 10.1775, 123.6486));
        cebuMunicipalities.add(new Municipality("Poro", 10.6522, 124.0056));
        cebuMunicipalities.add(new Municipality("Ronda", 10.0081, 123.4847));
        cebuMunicipalities.add(new Municipality("Samboan", 9.5300, 123.3400));
        cebuMunicipalities.add(new Municipality("San Fernando", 10.1139, 123.5419));
        cebuMunicipalities.add(new Municipality("San Francisco", 10.4617, 124.0106));
        cebuMunicipalities.add(new Municipality("San Remigio", 11.0447, 123.9414));
        cebuMunicipalities.add(new Municipality("Santa Fe", 11.1706, 123.7722));
        cebuMunicipalities.add(new Municipality("Santander", 9.4911, 123.3589));
        cebuMunicipalities.add(new Municipality("Sibonga", 10.1381, 123.5481));
        cebuMunicipalities.add(new Municipality("Sogod", 10.3836, 124.0125));
        cebuMunicipalities.add(new Municipality("Tabogon", 10.8575, 124.0072));
        cebuMunicipalities.add(new Municipality("Tabuelan", 11.0344, 123.9611));
        cebuMunicipalities.add(new Municipality("Talisay", 10.2478, 123.8497));
        cebuMunicipalities.add(new Municipality("Toledo", 10.3797, 123.6403));
        cebuMunicipalities.add(new Municipality("Tuburan", 10.6919, 123.9356));
        cebuMunicipalities.add(new Municipality("Tudela", 11.3361, 123.7908));
        central.put("cebu", cebuMunicipalities);

        List<Municipality> boholMunicipalities = new ArrayList<>();

        boholMunicipalities.add(new Municipality("Albuquerque", 9.6794, 123.9792));
        boholMunicipalities.add(new Municipality("Alicia", 9.9986, 124.3042));
        boholMunicipalities.add(new Municipality("Anda", 9.7789, 124.5131));
        boholMunicipalities.add(new Municipality("Antequera", 9.7789, 123.8978));
        boholMunicipalities.add(new Municipality("Baclayon", 9.6122, 123.9533));
        boholMunicipalities.add(new Municipality("Balilihan", 9.6892, 123.9714));
        boholMunicipalities.add(new Municipality("Batuan", 9.6608, 124.3069));
        boholMunicipalities.add(new Municipality("Bien Unido", 10.1286, 124.3786));
        boholMunicipalities.add(new Municipality("Bilar", 9.7747, 124.2550));
        boholMunicipalities.add(new Municipality("Buenavista", 10.0867, 124.4989));
        boholMunicipalities.add(new Municipality("Calape", 9.9044, 123.8922));
        boholMunicipalities.add(new Municipality("Candijay", 9.8042, 124.4828));
        boholMunicipalities.add(new Municipality("Carmen", 9.8642, 124.1892));
        boholMunicipalities.add(new Municipality("Catigbian", 9.7153, 124.1331));
        boholMunicipalities.add(new Municipality("Clarin", 10.0706, 124.3633));
        boholMunicipalities.add(new Municipality("Corella", 9.6383, 123.8733));
        boholMunicipalities.add(new Municipality("Cortes", 9.7831, 123.9183));
        boholMunicipalities.add(new Municipality("Dagohoy", 9.9089, 124.3158));
        boholMunicipalities.add(new Municipality("Danao", 9.8667, 124.3097));
        boholMunicipalities.add(new Municipality("Dauis", 9.6367, 123.8761));
        boholMunicipalities.add(new Municipality("Dimiao", 9.7306, 123.9872));
        boholMunicipalities.add(new Municipality("Duero", 9.8589, 124.4822));
        boholMunicipalities.add(new Municipality("Garcia Hernandez", 9.9622, 124.2906));
        boholMunicipalities.add(new Municipality("Getafe", 10.1139, 123.9828));
        boholMunicipalities.add(new Municipality("Guindulman", 9.7167, 124.4856));
        boholMunicipalities.add(new Municipality("Inabanga", 9.9694, 124.0950));
        boholMunicipalities.add(new Municipality("Jagna", 9.6500, 124.4019));
        boholMunicipalities.add(new Municipality("Lila", 9.6169, 123.9281));
        boholMunicipalities.add(new Municipality("Loay", 9.6375, 123.9486));
        boholMunicipalities.add(new Municipality("Loboc", 9.6644, 124.2208));
        boholMunicipalities.add(new Municipality("Loon", 9.6936, 123.8725));
        boholMunicipalities.add(new Municipality("Mabini", 9.8417, 124.3981));
        boholMunicipalities.add(new Municipality("Maribojoc", 9.6167, 123.9167));
        boholMunicipalities.add(new Municipality("Panglao", 9.5706, 123.7436));
        boholMunicipalities.add(new Municipality("Pilar", 9.9983, 124.2239));
        boholMunicipalities.add(new Municipality("Pres. Carlos P. Garcia", 10.2531, 123.8608));
        boholMunicipalities.add(new Municipality("Sagbayan", 9.8061, 124.3581));
        boholMunicipalities.add(new Municipality("San Isidro", 9.8867, 124.3078));
        boholMunicipalities.add(new Municipality("San Miguel", 9.8872, 124.2494));
        boholMunicipalities.add(new Municipality("Sevilla", 9.6889, 123.9389));
        boholMunicipalities.add(new Municipality("Sierra Bullones", 9.7747, 124.3250));
        boholMunicipalities.add(new Municipality("Sikatuna", 9.6517, 123.9431));
        boholMunicipalities.add(new Municipality("Tagbilaran", 9.6500, 123.8667));
        boholMunicipalities.add(new Municipality("Talibon", 10.1472, 124.0000));
        boholMunicipalities.add(new Municipality("Trinidad", 9.8061, 124.2597));
        boholMunicipalities.add(new Municipality("Tubigon", 9.9122, 123.8600));
        boholMunicipalities.add(new Municipality("Ubay", 10.1686, 124.5358));
        boholMunicipalities.add(new Municipality("Valencia", 9.5686, 123.7942));
        central.put("bohol", boholMunicipalities);

        List<Municipality> negrosOrientalMunicipalities = new ArrayList<>();

        negrosOrientalMunicipalities.add(new Municipality("Amlan", 9.3617, 123.2592));
        negrosOrientalMunicipalities.add(new Municipality("Ayungon", 9.9808, 123.2592));
        negrosOrientalMunicipalities.add(new Municipality("Bacong", 9.4792, 123.2383));
        negrosOrientalMunicipalities.add(new Municipality("Bais", 9.5967, 123.1239));
        negrosOrientalMunicipalities.add(new Municipality("Basay", 9.4033, 122.6850));
        negrosOrientalMunicipalities.add(new Municipality("Bayawan", 9.3633, 122.8033));
        negrosOrientalMunicipalities.add(new Municipality("Bindoy", 9.6456, 123.1153));
        negrosOrientalMunicipalities.add(new Municipality("Canlaon", 10.4139, 123.1947));
        negrosOrientalMunicipalities.add(new Municipality("Dauin", 9.1872, 123.2222));
        negrosOrientalMunicipalities.add(new Municipality("Dumaguete", 9.3072, 123.3022));
        negrosOrientalMunicipalities.add(new Municipality("Guihulngan", 10.1311, 123.2889));
        negrosOrientalMunicipalities.add(new Municipality("Jimalalud", 9.8794, 123.2258));
        negrosOrientalMunicipalities.add(new Municipality("La Libertad", 9.6239, 123.0917));
        negrosOrientalMunicipalities.add(new Municipality("Mabinay", 9.6894, 122.8525));
        negrosOrientalMunicipalities.add(new Municipality("Manjuyod", 9.5861, 123.0336));
        negrosOrientalMunicipalities.add(new Municipality("Pamplona", 9.7828, 123.2833));
        negrosOrientalMunicipalities.add(new Municipality("San Jose", 9.5369, 122.8494));
        negrosOrientalMunicipalities.add(new Municipality("Santa Catalina", 9.7386, 123.1383));
        negrosOrientalMunicipalities.add(new Municipality("Siaton", 9.0500, 123.1428));
        negrosOrientalMunicipalities.add(new Municipality("Sibulan", 9.2833, 123.3025));
        negrosOrientalMunicipalities.add(new Municipality("Tanjay", 9.5175, 123.1528));
        negrosOrientalMunicipalities.add(new Municipality("Tayasan", 9.7344, 123.1703));
        negrosOrientalMunicipalities.add(new Municipality("Valencia", 9.2753, 123.2133));
        central.put("negros Oriental", negrosOrientalMunicipalities);


        return central;
    }

    public Map<String, List<Municipality>> mimaropa(){
        Map<String, List<Municipality>> MIMAROPA  = new HashMap<>();

        return MIMAROPA;
    }



}
