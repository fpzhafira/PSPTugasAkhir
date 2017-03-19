$(document).ready(function(){
	// initialize DataTable
	var allStudentTable = $('#view-all-student').dataTable({
		paging: true,
		searching: true,
		ordering: true,
		pageLength: 25,
		autoWidth: true,
		bLengthChange: true,
		columnDefs: [{ targets: 'no-sort', orderable: false }],
		columns: [
		          {data: 'npm', render: function(d,t,r){
		        	  return '<a href="/sekre/student/view/'+d+'">'+d+'</a>';
		          }},
		          {data: 'name'}
		]
	}).api();
	
	$('#tampilkan-btn').click(function(e){
		e.preventDefault();
		
		var univSelect = $('#univ-select :selected');
		var facultySelect = $('#fakultas-select :selected');
		var majorSelect = $('#prodi-select :selected');				
		
		$.ajax({
            url: '/rest/sekre/get/allStudentByUnivFacultyMajor/'+univSelect.val()+'/'+facultySelect.val()+'/'+majorSelect.val(),
            type: 'GET',
        })
        .done(function(r) {            
            allStudentTable.clear();
            allStudentTable.rows.add(r);
            allStudentTable.draw();
        })
        .fail(function() {
            alert('Mohon maaf, terjadi kesalahan sistem. Halaman akan dimuat ulang.');
            location.reload(true);
        })
        .always(function() {            
            $('#selected-univ-text').html(univSelect.text());
            $('#selected-faculty-text').html(facultySelect.text());
            $('#selected-major-text').html(majorSelect.text());
        });
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