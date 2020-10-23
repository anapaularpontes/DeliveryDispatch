"use strict";

var mymap = L.map('mapid').setView([49.2757, -123.0141], 11);

L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token=YOUR_KEY', {
	attribution: `Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors,
		<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>`,
	maxZoom: 13,
	id: 'mapbox/streets-v11',
	tileSize: 512,
	zoomOffset: -1,
}).addTo(mymap);

var marker;
marker = L.marker([49.203, -122.914]).addTo(mymap);
marker.bindPopup("Starting point").openPopup();
var polyline = [[49.203, -122.914]];

$(document).ready(function () {
	$.get("http://localhost:8080/api/sequence/" + sequence_id, function (deliveriesArray) {

		for (var i = 0; i < deliveriesArray.length; i++) {
			marker = L.marker([deliveriesArray[i].restaurant.latitude, deliveriesArray[i].restaurant.longitude])
				.addTo(mymap);
			polyline.push([deliveriesArray[i].restaurant.latitude, deliveriesArray[i].restaurant.longitude]);
			marker.bindPopup("Restaurant " + (i + 1)).openPopup();
		}
		L.polyline(polyline).addTo(mymap);

	});
});

