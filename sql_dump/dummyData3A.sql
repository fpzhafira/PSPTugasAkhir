INSERT INTO UNIV (id_univ, name, initial_univ, telephone_number, address, accreditation)
VALUES ('U0001','Universitas Indonesia','UI', '0217867222', 'Depok, Indonesia', 'A');

INSERT INTO UNIV (id_univ, name, initial_univ, telephone_number, address, accreditation)
VALUES ('U0002','Universitas Gadjah Mada','UGM', '0274588688', 'Yogyakarta, Indonesia', 'A');

INSERT INTO UNIV (id_univ, name, initial_univ, telephone_number, address, accreditation)
VALUES ('U0003','Institut Teknologi Bandung','ITB', '0222500935', 'Bandung, Indonesia', 'A');

INSERT INTO groups (id_group, name, id_univ)
VALUES ('UIG1','Sains dan Teknologi','U0001');

INSERT INTO groups (id_group, name, id_univ)
VALUES ('UIG2','Ilmu Kesehatan','U0001');

INSERT INTO groups (id_group, name, id_univ)
VALUES ('UIG3','Sosial dan Hukum','U0001');

INSERT INTO groups (id_group, name, id_univ)
VALUES ('UGMG1','Sains','U0002');

INSERT INTO groups (id_group, name, id_univ)
VALUES ('UGMG2','Kesehatan','U0002');

INSERT INTO groups (id_group, name, id_univ)
VALUES ('UGMG3','Sosial','U0002');

INSERT INTO groups (id_group, name, id_univ)
VALUES ('ITBG1','Teknologi','U0003');

INSERT INTO groups (id_group, name, id_univ)
VALUES ('ITBG2','Bisnis','U0003');

INSERT INTO FACULTY (id_faculty, name, id_group, telephone_number, accreditation, id_univ)
VALUES ('UIF01', 'Fakultas Ilmu Komputer', 'UIG1', '0217867222', 'A', 'U0001');

INSERT INTO FACULTY (id_faculty, name, id_group, telephone_number, accreditation, id_univ)
VALUES ('UIF02', 'Fakultas Kedokteran', 'UIG2', '0217867222', 'A', 'U0001');

INSERT INTO FACULTY (id_faculty, name, id_group, telephone_number, accreditation, id_univ)
VALUES ('UIF03', 'Fakultas Hukum', 'UIG3', '0217867222', 'A', 'U0001');

INSERT INTO FACULTY (id_faculty, name, id_group, telephone_number, accreditation, id_univ)
VALUES ('UGMF01', 'Fakultas Hukum', 'UGMG3', '0274588688', 'A', 'U0002');

INSERT INTO FACULTY (id_faculty, name, id_group, telephone_number, accreditation, id_univ)
VALUES ('UGMF02', 'Fakultas Kedokteran', 'UGMG2', '0274588688', 'A', 'U0002');

INSERT INTO FACULTY (id_faculty, name, id_group, telephone_number, accreditation, id_univ)
VALUES ('UGMF03', 'Fakultas MIPA', 'UGMG1', '0274588688', 'A', 'U0002');

INSERT INTO FACULTY (id_faculty, name, id_group, telephone_number, accreditation, id_univ)
VALUES ('ITBF01', 'Fakultas Teknik', 'ITBG1', '0222500935', 'A', 'U0003');

INSERT INTO FACULTY (id_faculty, name, id_group, telephone_number, accreditation, id_univ)
VALUES ('ITBF02', 'Sekolah Bisnis dan Manajemen', 'ITBG2', '0222500935', 'A', 'U0003');

INSERT INTO MAJOR (id_major, name, id_faculty)
VALUES ('UIM001', 'Sistem Informasi', 'UIF01');

INSERT INTO MAJOR (id_major, name, id_faculty)
VALUES ('UIM002', 'Ilmu Komputer', 'UIF01');

INSERT INTO MAJOR (id_major, name, id_faculty)
VALUES ('UIM003', 'Kedokteran', 'UIF02');

INSERT INTO MAJOR (id_major, name, id_faculty)
VALUES ('UIM004', 'Ilmu Hukum', 'UIF03');

INSERT INTO MAJOR (id_major, name, id_faculty)
VALUES ('UGMM001', 'Ilmu Hukum', 'UGMF01');

INSERT INTO MAJOR (id_major, name, id_faculty)
VALUES ('UGMM002', 'Kedokteran', 'UGMF02');

INSERT INTO MAJOR (id_major, name, id_faculty)
VALUES ('UGMM003', 'Biologi', 'UGMF03');

INSERT INTO MAJOR (id_major, name, id_faculty)
VALUES ('ITBM001', 'Teknik Mesin', 'ITBF01');

INSERT INTO MAJOR (id_major, name, id_faculty)
VALUES ('ITBM002', 'Arsitektur', 'ITBF01');

INSERT INTO MAJOR (id_major, name, id_faculty)
VALUES ('ITBM003', 'Teknik Elektro', 'ITBF01');

INSERT INTO MAJOR (id_major, name, id_faculty)
VALUES ('ITBM004', 'Bisnis', 'ITBF02');

INSERT INTO MAJOR (id_major, name, id_faculty)
VALUES ('ITBM005', 'Manajemen', 'ITBF02');

INSERT INTO CURRICULUM (id_curriculum, id_major, curriculum_year)
VALUES ('UIK001', 'UIM001', '2016');

INSERT INTO CURRICULUM (id_curriculum, id_major, curriculum_year)
VALUES ('UIK002', 'UIM002', '2016');

INSERT INTO CURRICULUM (id_curriculum, id_major, curriculum_year)
VALUES ('UIK003', 'UIM003', '2010');

INSERT INTO CURRICULUM (id_curriculum, id_major, curriculum_year)
VALUES ('UIK004', 'UIM004', '2010');

INSERT INTO CURRICULUM (id_curriculum, id_major, curriculum_year)
VALUES ('UGMK001', 'UGMM001', '2014');

INSERT INTO CURRICULUM (id_curriculum, id_major, curriculum_year)
VALUES ('UGMK002', 'UGMM002', '2014');

INSERT INTO CURRICULUM (id_curriculum, id_major, curriculum_year)
VALUES ('UGMK003', 'UGMM003', '2014');

INSERT INTO CURRICULUM (id_curriculum, id_major, curriculum_year)
VALUES ('ITBK001', 'ITBM001', '2012');

INSERT INTO CURRICULUM (id_curriculum, id_major, curriculum_year)
VALUES ('ITBK002', 'ITBM002', '2012');

INSERT INTO CURRICULUM (id_curriculum, id_major, curriculum_year)
VALUES ('ITBK003', 'ITBM003', '2012');

INSERT INTO CURRICULUM (id_curriculum, id_major, curriculum_year)
VALUES ('ITBK004', 'ITBM004', '2014');

INSERT INTO CURRICULUM (id_curriculum, id_major, curriculum_year)
VALUES ('ITBK005', 'ITBM005', '2016');

INSERT INTO COURSE (id_course, name, sks, sks_required)
VALUES ('UIC001', 'Dasar-Dasar Pemrograman 1', '4', '0');

INSERT INTO COURSE (id_course, name, sks, sks_required)
VALUES ('UIC002', 'Dasar-Dasar Pemrograman 2', '4', '0');

INSERT INTO COURSE (id_course, name, sks, sks_required)
VALUES ('UIC003', 'Dasar-Dasar Hukum', '3', '0');

INSERT INTO COURSE (id_course, name, sks, sks_required)
VALUES ('UIC004', 'Patologi Dasar', '3', '0');

INSERT INTO COURSE (id_course, name, sks, sks_required)
VALUES ('UGMC001', 'Hukum Perdata', '3', '48');

INSERT INTO COURSE (id_course, name, sks, sks_required)
VALUES ('UGMC002', 'Pencernaan Manusia', '4', '0');

INSERT INTO COURSE (id_course, name, sks, sks_required)
VALUES ('UGMC003', 'Ekosistem Laut', '3', '0');

INSERT INTO COURSE (id_course, name, sks, sks_required)
VALUES ('ITBC001', 'Fisika Dasar 1', '3', '0');

INSERT INTO COURSE (id_course, name, sks, sks_required)
VALUES ('ITBC002', 'Administrasi Bisnis', '3', '0');

INSERT INTO pre_condition (id_course, id_course_required)
VALUES ('UIC002', 'UIC001');

INSERT INTO TERM (id_term, term_year, term_held)
VALUES ('1', '2016/2017', '1');

INSERT INTO TERM (id_term, term_year, term_held)
VALUES ('2', '2016/2017', '2');

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('1', 'UIC001');

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('2', 'UIC002');

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('1', 'UIC003');

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('2', 'UIC004');

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('2', 'UGMC001');

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('1', 'UGMC002');

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('1', 'UGMC003');

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('1', 'ITBC001');

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('2', 'ITBC002');

	INSERT INTO CURRICULUM_COURSE (id_curriculum, id_course, obligatory_flag)
	VALUES ('UIK001', 'UIC001', '0010');

	INSERT INTO CURRICULUM_COURSE (id_curriculum, id_course, obligatory_flag)
	VALUES ('UIK001', 'UIC002', '0010');

	INSERT INTO CURRICULUM_COURSE (id_curriculum, id_course, obligatory_flag)
	VALUES ('UIK002', 'UIC001', '0010');

	INSERT INTO CURRICULUM_COURSE (id_curriculum, id_course, obligatory_flag)
	VALUES ('UIK002', 'UIC002', '0010');

	INSERT INTO CURRICULUM_COURSE (id_curriculum, id_course, obligatory_flag)
	VALUES ('UIK003', 'UIC003', '0010');

	INSERT INTO CURRICULUM_COURSE (id_curriculum, id_course, obligatory_flag)
	VALUES ('UIK004', 'UIC004', '0100');

	INSERT INTO CURRICULUM_COURSE (id_curriculum, id_course, obligatory_flag)
	VALUES ('UGMK001', 'UGMC001', '0010');

	INSERT INTO CURRICULUM_COURSE (id_curriculum, id_course, obligatory_flag)
	VALUES ('UGMK002', 'UGMC002', '0010');

	INSERT INTO CURRICULUM_COURSE (id_curriculum, id_course, obligatory_flag)
	VALUES ('UGMK003', 'UGMC003', '0001');

	INSERT INTO CURRICULUM_COURSE (id_curriculum, id_course, obligatory_flag)
	VALUES ('ITBK001', 'ITBC001', '0100');

	

