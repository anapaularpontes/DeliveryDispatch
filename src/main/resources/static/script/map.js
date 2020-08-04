"use strict";

var mymap = L.map('mapid').setView([49.235, -122.976], 10);

L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token=pk.eyJ1IjoiYW5hcnBvbnRlcyIsImEiOiJja2RkajUwazQwdnN6MnFxdGJ1ZjBhNmJmIn0.jG3lUwoRDbFra3XzndbL2A', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 13,
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
}).addTo(mymap);



	var marker = L.marker([49.203, -122.914]).addTo(mymap);
	marker.bindPopup("Starting point").openPopup();

