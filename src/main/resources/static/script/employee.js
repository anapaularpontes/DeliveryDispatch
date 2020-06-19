"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let employee = button.data('employee'); // Extract info from data-* attributes
	let method = button.data('method');
	console.log('[METHOD]', method);
	let inputMethod = `<input name="_method" type="hidden" value="${method}" />`;
	$("#employeeForm").append(inputMethod);
	let modal = $(this);
	if(employee!=0) {
		$.ajax({
			dataType: "json",
			url: "/employees/"+employee
		}).done(function(data) {
			document.getElementById("txtId").value = data.id;
			document.getElementById("txtFirstName").value = data.firstName;
			document.getElementById("txtLastName").value = data.lastName;
			document.getElementById("txtRole").value = data.role.id;
			modal.find("#modalTitle").text('Editing employee');
		});
	} else {
		document.getElementById("txtId").value = 0;
		document.getElementById("txtFirstName").value = "";
		document.getElementById("txtLastName").value = "";
		document.getElementById("txtRole").value = "";
		modal.find("#modalTitle").text('Adding employee');
	}
  })