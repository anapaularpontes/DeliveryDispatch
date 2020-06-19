"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let restaurant = button.data('restaurant'); // Extract info from data-* attributes
	let method = button.data('method');
	console.log('[METHOD]', method);
	let inputMethod = `<input name="_method" type="hidden" value="${method}"/>`;
	$("#restaurantForm").append(inputMethod);
	let modal = $(this);
	if(restaurant!=0) {
		$.ajax({
			dataType: "json",
			url: "/restaurants/"+restaurant
		}).done(function(data) {
			document.getElementById("txtId").value = data.id;
			document.getElementById("txtName").value = data.name;
			document.getElementById("txtAddress").value = data.address;
			document.getElementById("txtCity").value = data.city.id;
			document.getElementById("txtArea").value = data.area.id;
			modal.find("#modalTitle").text('Editing restaurant');
		});
	} else {
		document.getElementById("txtId").value = 0;
		document.getElementById("txtName").value = "";
		document.getElementById("txtAddress").value = "";
		document.getElementById("txtCity").value = "";
		document.getElementById("txtArea").value = "";
		modal.find("#modalTitle").text('Adding restaurant');
	}
  })