$(document).ready(function() {
	$('#chonlop').change(function() {
		$.ajax({
			url: "studentofclass",
			type: "POST",
			data: {
				classID: $(this).val(),
			},
			async:false,
			success: function(content,status) {
				$('#testing_table > tbody').html(content);
			}
		}); 
	}); 
});