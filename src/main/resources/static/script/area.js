"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let area = button.data('area'); // Extract info from data-* attributes
	let method = button.data('method');
	console.log('[METHOD]', method);
	let inputMethod = `<input name="_method" type="hidden" value="${method}" />`;
	$("#areaForm").append(inputMethod);
	let modal = $(this);
	if(area!=0) {
		$.ajax({
			dataType: "json",
			url: "/areas/"+area
		}).done(function(data) {
			document.getElementById("txtId").value = data.id;
			document.getElementById("txtArea").value = data.name;
			modal.find("#modalTitle").text('Editing area');
		});
	} else {
		document.getElementById("txtId").value = 0;
		document.getElementById("txtArea").value = "";
		modal.find("#modalTitle").text('Adding area');
	}
  })