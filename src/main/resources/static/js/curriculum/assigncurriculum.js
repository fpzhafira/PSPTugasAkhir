$(document).ready(function() {
    $('#univ-select').change(function(){
        var selected = $('#univ-select').val();
        univ_id = selected;

        $.ajax({
            url: '/rest/faculty/viewall/'+selected,
            type: 'GET',
        })
        .done(function(r) {            
            var result = parseJsonObj(r);           
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
            resetCurriculumSelect();
            resetBatchSelect();            
        });        
    });

    $('#fakultas-select').change(function(){
        var selected = $('#fakultas-select').val();

        $.ajax({
            url: '/rest/major/viewall/'+selected,
            type: 'GET',
        })
        .done(function(r) {            
            var result = parseJsonObj(r);           
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
            resetCurriculumSelect();
            resetBatchSelect();
        });
    });    
    
    $('#prodi-select').change(function(){                
        var selected = $('#prodi-select').val();

        $.ajax({
            url: '/rest/curriculum/viewall/'+selected,
            type: 'GET',
        })
        .done(function(r) {            
            var result = parseJsonObj(r);           
            var curriculum_select = $('#kurikulum-select');         
            var curriculum_option = '';

            for (var i = 0; i < result.length; i++)
            	curriculum_option += '<option value="'+result[i]['idCurriculum']+'">'+result[i]['year']+'-'+result[i]['idCurriculum']+'</option>';

            curriculum_select.html('');
            curriculum_select.append('<option value="" disabled="disabled" selected="selected">Pilih Kurikulum</option>');
            curriculum_select.append(curriculum_option);
        })
        .fail(function() {
            alert('Mohon maaf, terjadi kesalahan sistem. Halaman akan dimuat ulang.');
            location.reload(true);
        })
        .always(function() {
            console.log("complete");
        }); 
        
        $.when(function(){
                               
        })
        .then(function(){
            $.ajax({
                url: '/rest/sekre/get/batchesOfAllStudent/'+$('#univ-select').val()+'/'+$('#fakultas-select').val()+'/'+$('#prodi-select').val(),
                type: 'GET',                               
            })
            .done(function(r) {            
                var result = parseJsonObj(r);
                var batch_select = $('#angkatan-select');         
                var batch_option = '';

                for (var i = 0; i < result.length; i++)
                    batch_option += '<option value="20'+result[i]+'">20'+result[i]+'</option>';

                batch_select.html('');
                batch_select.append('<option value="" disabled="disabled" selected="selected">Pilih angkatan yang ingin diassign</option>');
                batch_select.append(batch_option);
            })
            .fail(function() {
                alert('Mohon maaf, terjadi kesalahan sistem. Halaman akan dimuat ulang.');
                location.reload(true);
            })
            .always(function() {
                console.log("complete");
            });                      
        });
    });    

    function resetMajorSelect() 
    {
        $('#prodi-select').html('');
        $('#prodi-select').append('<option value="" disabled="disabled" selected="selected">Pilih Program Studi</option>');
    }

    function resetCurriculumSelect() 
    {
        $('#kurikulum-select').html('');
        $('#kurikulum-select').append('<option value="" disabled="disabled" selected="selected">Pilih Kurikulum</option>');
    }

    function resetBatchSelect() 
    {
        $('#angkatan-select').html('');
        $('#angkatan-select').append('<option value="" disabled="disabled" selected="selected">Pilih angkatan yang ingin diassign</option>');
    }
});