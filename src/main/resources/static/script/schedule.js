"use strict";

$('#modalForm').on('show.bs.modal', function (event) {
	let button = $(event.relatedTarget); // Button that triggered the modal
	let schedule = button.data('schedule'); // Extract info from data-* attributes
	let method = button.data('method');
	console.log('[METHOD]', method);
	let inputMethod = `<input name="_method" type="hidden" value="${method}" />`;
	$("#scheduleForm").append(inputMethod);
	let modal = $(this);
	if(schedule!=0) {
		$.ajax({
			dataType: "json",
			url: "/schedules/"+schedule
		}).done(function(data) {
			document.getElementById("txtId").value = data.id;
			document.getElementById("txtEmployee").value = data.employee.id;
			document.getElementById("txtDate").value = data.date;
			document.getElementById("txtTime").value = data.startingTime;
			modal.find("#modalTitle").text('Editing schedule');
		});
	} else {
		document.getElementById("txtId").value = 0;
		document.getElementById("txtEmployee").value = "";
		document.getElementById("txtDate").value = "";
		document.getElementById("txtTime").value = "";
		modal.find("#modalTitle").text('Adding schedule');
	}
  })