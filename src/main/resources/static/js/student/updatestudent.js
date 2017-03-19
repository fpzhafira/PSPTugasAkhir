$(document).ready(function() {
	$.ajax({
        url: 'http://localhost:8181/rest/dosen/viewall',
        type: 'GET'        
    })
    .done(function(r) {
        var result = parseJsonObj(r);

        var supervisor_select = $('#pa-select');
        var supervisor_option = '';

        for (var i = 0; i < result.length; i++)
            supervisor_option += '<option value="'+result[i]['nip']+'" '+((result[i]['nip']==supervisorNip)?'selected="selected"':'')+'">'+result[i]['nama']+'</option>'
        
        supervisor_select.html('');
        supervisor_select.append('<option value="" disabled="disabled" selected="selected">Pilih Pembimbing Akademis</option>');
        supervisor_select.append(supervisor_option);
    })
    .fail(function() {
        alert('Mohon maaf, terjadi kesalahan sistem. Halaman akan dimuat ulang.');
        location.reload(true);
    })
    .always(function() {
        console.log("complete");
    });
});