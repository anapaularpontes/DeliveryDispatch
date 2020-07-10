"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let delivery = button.data('delivery'); // Extract info from data-* attributes
	let method = button.data('method');
	console.log('[METHOD]', method);
	let inputMethod = `<input name="_method" type="hidden" value="${method}" />`;
	$("#deliveryForm").append(inputMethod);
	let modal = $(this);
	if(delivery!=0) {
		$.ajax({
			dataType: "json",
			url: "/deliveries/"+delivery
		}).done(function(data) {
			document.getElementById("txtId").value = data.id;
			document.getElementById("txtRest").value = data.restaurant.id;
			document.getElementById("txtDate").value = data.deliveryDate;
			document.getElementById("txtTiming").value = data.timing;
			document.getElementById("txtInstructions").value = data.instructions;
			modal.find("#modalTitle").text('Editing delivery');
		});
	} else {
		document.getElementById("txtId").value = 0;
		document.getElementById("txtRest").value = "";
		document.getElementById("txtDate").value = "YYYY-MM-DD";
		document.getElementById("txtTiming").value = "";
		document.getElementById("txtInstructions").value = "";
		modal.find("#modalTitle").text('Adding delivery');
	}
  })