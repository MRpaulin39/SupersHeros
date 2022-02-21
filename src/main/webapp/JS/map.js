var typingTimer;
var doneTypingInternal = 500;
var $cityInput = $('#CityHero')

//Fonction déclenché avec le retour de l'API depuis la ville
var callBackGetSuccessCity = function(data){
    // console.log("Data API = ", data)

    if (data.length !== 0){
        var newlat = data[0]["lat"];
        var newlng = data[0]["lon"];

        //Todo : Mettre à jour les coordonnées dans les input cachés
        onCoordonateUpdate(newlat,newlng);
    }

}

//Fonction permettant de récupérer les coordonnées d'une ville marqué dans le input
//VILLE FRANCAISE UNIQUEMENT !!
function getAPIWithCity(){
    clearTimeout(typingTimer);

    var newCity = document.getElementById("CityHero").value

    if (newCity !== ""){
        newCity = newCity.replace(" ", "%20");

        var url = "https://nominatim.openstreetmap.org/search?q="+ newCity +"%20france&format=json"

        $.get(url, callBackGetSuccessCity).done(function (){

        })
            .fail(function (){
                alert("Une erreur est survenue lors de la récupération des coordonnées de la ville");
            })

    }

}

//Fonction déclenché avec le retour de l'API depuis les coordonnées
var callBackGetSuccessCoordinates = function(data){

    if(data["address"]["village"] !== undefined){
        document.getElementById("CityHero").value = data["address"]["village"];
    } else if (data["address"]["municipality"] !== undefined){
        document.getElementById("CityHero").value = data["address"]["municipality"];
    } else if (data["address"]["city"] !== undefined){
        document.getElementById("CityHero").value = data["address"]["city"];
    } else {
        document.getElementById("CityHero").value = "";
    }

}

//Fonction permettant de récupérer les nom de la ville en fonction des coordonnées
function getAPIWithCoordinates(lat,lng){

    var url = "https://nominatim.openstreetmap.org/reverse?lat=" + lat + "&lon=" + lng + "&format=json"
    console.log(url);

    $.get(url, callBackGetSuccessCoordinates).done(function (){

    })
        .fail(function (){
            alert("Une erreur est survenue lors de la récupération du nom de la ville en fonction des coordonnées");
        })



}

//-------------- Mise en place de la carte au centre de la France

//Todo : Ajouter la vérification de coordonnéees déjà présente dans le formulaire

var map = L.map('map').setView([46.02, 2.0], 4);

L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'pk.eyJ1IjoibXJwYXVsaW4zOSIsImEiOiJja3pya2V4a2cwaTdsMnVwa2cwODYzdWNsIn0._4upl2NteMwEL7MblKNY2w'
}).addTo(map);

var marker = L.marker([46.02, 2.0]);


//Fonction permettant l'ajout d'un marqueur sur la carte
function onMapClick(e) {
    //Ajout du marqueur
    if (marker !== undefined){
        marker.remove();
    }

    marker = L.marker([e.latlng.lat, e.latlng.lng]).addTo(map);

    //Met a jour les inputs lat et lng
    document.getElementById("CityHeroLat").value = e.latlng.lat.toString()
    document.getElementById("CityHeroLong").value = e.latlng.lng.toString()

    getAPIWithCoordinates(e.latlng.lat.toString(), e.latlng.lng.toString());

}

//Fonction permettant la mise à jour de la carte
function onCoordonateUpdate(lat,lng){
    if (map !== undefined){
        map.remove();
    }

    map = L.map('map').setView([lat, lng], 13);

    L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        maxZoom: 18,
        id: 'mapbox/streets-v11',
        tileSize: 512,
        zoomOffset: -1,
        accessToken: 'pk.eyJ1IjoibXJwYXVsaW4zOSIsImEiOiJja3pya2V4a2cwaTdsMnVwa2cwODYzdWNsIn0._4upl2NteMwEL7MblKNY2w'
    }).addTo(map);

    //Met a jour les inputs lat et lng
    document.getElementById("CityHeroLat").value = lat;
    document.getElementById("CityHeroLong").value = lng;

    //Permet de réactiver la fonction de click lors de l'actualisation de la map
    map.on('click', onMapClick);
}

//Lors d'un clique sur la map, on lance la fonction onMapClick
map.on('click', onMapClick);

//---------- Permet de réactualiser la carte quand l'utilsateur ne tape pas dans la case au bout de 1,5 secs

//Lorsque l'on remonte la touche, on lance le timer
$cityInput.on('keyup', function (){
    clearTimeout(typingTimer);
    typingTimer = setInterval(getAPIWithCity, doneTypingInternal);
})

//Lorsque l'on enfonce la touche, le timer s'arrête
$cityInput.on('keydown', function(){
    clearTimeout(typingTimer);
})