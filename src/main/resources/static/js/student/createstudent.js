$(document).ready(function() {

    // get dosen list from D
    $.ajax({
        url: 'http://localhost:8181/rest/dosen/viewall',
        type: 'GET'        
    })
    .done(function(r) {
        var result = parseJsonObj(r);

        var supervisor_select = $('#pa-select');
        var supervisor_option = '';

        for (var i = 0; i < result.length; i++)
            supervisor_option += '<option value="'+result[i]['nip']+'">'+result[i]['nama']+'</option>'
        
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
    
    $('#univ-select').change(function(){
        var selected = $('#univ-select').val();
        console.log(selected);

        $.ajax({
            url: '/rest/faculty/viewall/'+selected,
            type: 'GET',
        })
        .done(function(r) {            
            var result = $.map(JSON.parse(JSON.stringify(r)), function(element){ return element; });           
            var faculty_select = $('#fakultas-select');           
            var faculty_option = '';

            for (var i = 0; i < result.length; i++)
                faculty_option += '<option value="'+result[i]['idFaculty']+'">'+result[i]['facultyName']+'</option>';

            faculty_select.html('');
            faculty_select.append('<option value="" disabled="disabled" selected="selected">Pilih Fakultas</option>');
            faculty_select.append(faculty_option);
        })
        .fail(function() {
            alert('Mohon maaf, terjadi kesalahan sistem. Halaman akan dimuat ulang.');
            location.reload(true);
        })
        .always(function() {            
            resetMajorSelect();
        });
    });

    $('#fakultas-select').change(function(){
        var selected = $('#fakultas-select').val();
        console.log(selected);

        $.ajax({
            url: '/rest/major/viewall/'+selected,
            type: 'GET',
        })
        .done(function(r) {            
            var result = $.map(JSON.parse(JSON.stringify(r)), function(element){ return element; });           
            var major_select = $('#prodi-select');
            var major_option = '';

            for (var i = 0; i < result.length; i++)
                major_option += '<option value="'+result[i]['idMajor']+'">'+result[i]['majorName']+'</option>';

            major_select.html('');
            major_select.append('<option value="" disabled="disabled" selected="selected">Pilih Program Studi</option>');
            major_select.append(major_option);
        })
        .fail(function() {
            alert('Mohon maaf, terjadi kesalahan sistem. Halaman akan dimuat ulang.');
            location.reload(true);
        })
        .always(function() {
            console.log("complete");
        });
    });
    
    function resetMajorSelect() 
    {
        $('#prodi-select').html('');
        $('#prodi-select').append('<option value="" disabled="disabled" selected="selected">Pilih Program Studi</option>');
    }
});