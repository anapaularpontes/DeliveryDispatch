"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let role = button.data('role'); // Extract info from data-* attributes
	let method = button.data('method');
	console.log('[METHOD]', method);
	let inputMethod = `<input name="_method" type="hidden" value="${method}" />`;
	$("#roleForm").append(inputMethod);
	let modal = $(this);
	if(role!=0) {
		$.ajax({
			dataType: "json",
			url: "/roles/"+role
		}).done(function(data) {
			document.getElementById("txtId").value = data.id;
			document.getElementById("txtRole").value = data.name;
			modal.find("#modalTitle").text('Editing role');
		});
	} else {
		document.getElementById("txtId").value = 0;
		document.getElementById("txtRole").value = "";
		modal.find("#modalTitle").text('Adding role');
	}
  })