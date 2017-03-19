$(document).ready(function() {
	
	if	(supervisorNip!=null)
	{
		$.ajax({
	        url: 'http://localhost:8181/rest/dosen/view/'+supervisorNip,
	        type: 'GET'        
	    })
	    .done(function(r) {
	        var result = parseJsonObj(r);
	        
	        $('#supervisor-name').html(result['nama']);
	    })
	    .fail(function() {
	        alert('Mohon maaf, terjadi kesalahan sistem. Halaman akan dimuat ulang.');
	        location.reload(true);
	    })
	    .always(function() {
	        console.log("complete");
	    });
	}	
});