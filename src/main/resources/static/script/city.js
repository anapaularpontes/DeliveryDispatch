"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let city = button.data('city'); // Extract info from data-* attributes
	let method = button.data('method');
	console.log('[METHOD]', method);
	let inputMethod = `<input name="_method" type="hidden" value="${method}" />`;
	$("#cityForm").append(inputMethod);
	let modal = $(this);
	if(city!=0) {
		$.ajax({
			dataType: "json",
			url: "/cities/"+city
		}).done(function(data) {
			document.getElementById("txtId").value = data.id;
			document.getElementById("txtCity").value = data.name;
			modal.find("#modalTitle").text('Editing city');
		});
	} else {
		document.getElementById("txtId").value = 0;
		document.getElementById("txtCity").value = "";
		modal.find("#modalTitle").text('Adding city');
	}
  })