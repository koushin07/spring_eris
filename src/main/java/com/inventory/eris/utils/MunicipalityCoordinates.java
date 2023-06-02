package com.inventory.eris.utils;



import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class MunicipalityCoordinates {


    public  Map<String, Map<String, double[]>> coordinates(){
        Map<String, Map<String, double[]>> provinces = new HashMap<>();

        Map<String, double[]> camiguin = new HashMap<>();
        camiguin.put("Catarman", new double[]{9.12435874658949, 124.675557898537});
        camiguin.put("Guinsiliban", new double[]{9.09642903993579, 124.785061108336});
        camiguin.put("Mahinog", new double[]{9.156395473, 124.7874664});
        camiguin.put("Mambajao", new double[]{9.245050362, 124.726646});
        camiguin.put("Sagay", new double[]{9.105221229, 124.7247818});
        provinces.put("camiguin", camiguin);

        Map<String, double[]> bukidnon = new HashMap<>();
        bukidnon.put("Baungon", new double[]{8.313060281, 124.6873351});
        bukidnon.put("Cabanglasan", new double[]{8.077034541, 125.2990361});
        bukidnon.put("Damulog", new double[]{7.485338155, 124.9412481});
        bukidnon.put("Dangcagan", new double[]{7.611604446, 125.0022349});
        bukidnon.put("Don Carlos", new double[]{7.681023813379106, 124.99512384270803});
        bukidnon.put("Impasug-Ong", new double[]{8.30239834, 125.0008535});
        bukidnon.put("Kadingilan", new double[]{7.599834052, 124.9095002});
        bukidnon.put("Kibawe", new double[]{7.569320416, 124.9854067});
        bukidnon.put("Kitaokitao", new double[]{7.640230999, 125.0084294});
        bukidnon.put("Lantapan", new double[]{8.00003329, 125.0207382});
        bukidnon.put("Libona", new double[]{8.367511329, 124.6864745});
        bukidnon.put("Malaybalay", new double[]{8.126548416, 125.1274213});
        bukidnon.put("Malitbog", new double[]{8.533904915, 124.8838126});
        bukidnon.put("Manolo Fortich", new double[]{8.37185597, 124.8565021});
        bukidnon.put("Maramag", new double[]{7.780496768, 125.0116252});
        bukidnon.put("Pangantucan", new double[]{7.829324859, 124.8289291});
        bukidnon.put("Quezon", new double[]{7.714606524, 125.1722154});
        bukidnon.put("San Fernando", new double[]{7.917050152, 125.3287636});
        bukidnon.put("Sumilao", new double[]{8.326088809, 124.977639});
        bukidnon.put("Talakag", new double[]{8.232552207, 124.6037043});
        bukidnon.put("Valencia", new double[]{7.903034752, 125.0894051});
        provinces.put("Bukidnon", bukidnon);

        Map<String, double[]> lanaoDelNorte = new HashMap<>();
        lanaoDelNorte.put("Bacolod", new double[]{8.189167422, 124.0242467});
        lanaoDelNorte.put("Baloi", new double[]{8.109256055, 124.2294037});
        lanaoDelNorte.put("Baroy", new double[]{8.02626285, 123.7785441});
        lanaoDelNorte.put("Kapatagan", new double[]{7.899474681, 123.7683798});
        lanaoDelNorte.put("Kauswagan", new double[]{8.189596374, 124.0867084});
        lanaoDelNorte.put("Kolambugan", new double[]{8.085601104, 123.8980437});
        lanaoDelNorte.put("Lala", new double[]{7.964311852, 123.7754513});
        lanaoDelNorte.put("Linamon", new double[]{8.183561758, 124.1635725});
        lanaoDelNorte.put("Magsaysay", new double[]{8.046572021, 123.9434551});
        lanaoDelNorte.put("Maigo", new double[]{8.159895258, 123.9604676});
        lanaoDelNorte.put("Matungao", new double[]{8.134429887, 124.1676327});
        lanaoDelNorte.put("Munai", new double[]{8.07862116, 124.0528027});
        lanaoDelNorte.put("Nunungan", new double[]{7.788378402, 123.9089295});
        lanaoDelNorte.put("Pantao Ragat", new double[]{8.078323657, 124.132846});
        lanaoDelNorte.put("Pantar", new double[]{8.058261944, 124.2649987});
        lanaoDelNorte.put("Poona Piagapo", new double[]{8.136356384, 124.1200824});
        lanaoDelNorte.put("Salvador", new double[]{7.906326739, 123.841626});
        lanaoDelNorte.put("Sapad", new double[]{7.870909223, 123.8129313});
        lanaoDelNorte.put("Sultan Naga Dimaporo", new double[]{7.793241445, 123.764687});
        lanaoDelNorte.put("Tagoloan", new double[]{8.175498791, 124.2698243});
        lanaoDelNorte.put("Tangcal", new double[]{7.996913509, 123.9968754});
        lanaoDelNorte.put("Tubod", new double[]{8.044721354, 123.7897});
        provinces.put("Lanao Del Norte", lanaoDelNorte);

        Map<String, double[]> misamisOccidental = new HashMap<>();
        misamisOccidental.put("Aloran", new double[]{8.416144119654293, 123.82097266785125});
        misamisOccidental.put("Baliangao", new double[]{8.66029439147963, 123.60293303716983});
        misamisOccidental.put("Bonifacio", new double[]{8.052701339925473, 123.61382578134362});
        misamisOccidental.put("Calamba", new double[]{8.56078950963135, 123.64400780576152});
        misamisOccidental.put("Clarin", new double[]{8.200152623838322, 123.86211469668577});
        misamisOccidental.put("Concepcion", new double[]{8.421332481543317, 123.60475078326022});
        misamisOccidental.put("Don Victoriano Chiongbian", new double[]{8.247318151716952, 123.56861744086278});
        misamisOccidental.put("Jimenez", new double[]{8.33538217308207, 123.84018126785095});
        misamisOccidental.put("Lopez_Jaena", new double[]{8.526282591550816, 123.75060798134567});
        misamisOccidental.put("Oroquieta", new double[]{8.48567386723216, 123.80813953901638});
        misamisOccidental.put("Ozamiz", new double[]{8.151137500890195, 123.85020198319152});
        misamisOccidental.put("Panaon", new double[]{8.36550576113419, 123.83822045066216});
        misamisOccidental.put("Plaridel", new double[]{8.621735367444177, 123.70984192367548});
        misamisOccidental.put("Sapang Dalaga", new double[]{8.542611009682343, 123.56757826785186});
        misamisOccidental.put("Sinacaban", new double[]{8.285601433349727, 123.84261783901543});
        misamisOccidental.put("Tangub", new double[]{8.061306241959048, 123.75147742552053});
        misamisOccidental.put("Tudela", new double[]{8.241466148188001, 123.84749825435657});
        provinces.put("Misamis Occidental", misamisOccidental);

        Map<String, double[]> misamisOriental = new HashMap<>();
        misamisOriental.put("Alubijid", new double[]{8.570881411117911, 124.47318091387639});
        misamisOriental.put("Balingasag", new double[]{8.742594269003574, 124.77435680648715});
        misamisOriental.put("Balingoan", new double[]{9.004110322753089, 124.85040532552486});
        misamisOriental.put("Binuangan", new double[]{8.922148738663214, 124.7857456745521});
        misamisOriental.put("Claveria", new double[]{8.620957599589877, 124.90629989853512});
        misamisOriental.put("El Salvador", new double[]{8.558668543645254, 124.52686485251054});
        misamisOriental.put("Gingoog", new double[]{8.816461426804523, 125.10360363901789});
        misamisOriental.put("Gitagum", new double[]{8.697892652993132, 124.66668844086436});
        misamisOriental.put("Initao", new double[]{8.577120491646413, 124.43923802028535});
        misamisOriental.put("Jasaan", new double[]{8.735130773334014, 124.71643089401675});
        misamisOriental.put("Kinoguitan", new double[]{8.828524080402943, 124.76225578576792});
        misamisOriental.put("Lagonglong", new double[]{8.807328828231798, 124.64193915707602});
        misamisOriental.put("Laguindingan", new double[]{8.612605416276417, 124.45750179505602});
        misamisOriental.put("Libertad", new double[]{8.510287710695628, 124.46193698319645});
        misamisOriental.put("Lugait", new double[]{8.61850555016948, 124.45251174766853});
        misamisOriental.put("Magsaysay", new double[]{8.618935036857455, 124.7116984159545});
        misamisOriental.put("Manticao", new double[]{8.489920699002397, 124.32339675972482});
        misamisOriental.put("Medina", new double[]{8.923000037751537, 124.363605126595});
        misamisOriental.put("Naawan", new double[]{8.531625545382274, 124.33435102827968});
        misamisOriental.put("Opol", new double[]{8.527845751504054, 124.55110316528247});
        misamisOriental.put("Salay", new double[]{8.942440025871156, 124.72228375833373});
        misamisOriental.put("Sugbongcogon", new double[]{8.623440058091492, 124.84369795032023});
        misamisOriental.put("Tagoloan", new double[]{8.563733249577753, 124.80526411595864});
        misamisOriental.put("Talisayan", new double[]{8.68211332217836, 124.6271346650515});
        misamisOriental.put("Villanueva", new double[]{8.582570161, 124.7899732});
        provinces.put("Misamis Oriental", misamisOriental);


        return provinces;
    }


}
