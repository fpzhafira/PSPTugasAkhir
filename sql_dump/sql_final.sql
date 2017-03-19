SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";
USE siak;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `siak`
--

-- --------------------------------------------------------

--
-- Table structure for table `classes`
--

CREATE TABLE `classes` (
  `class_id` char(5) NOT NULL,
  `major_id` varchar(7) NOT NULL,
  `course_id` varchar(7) NOT NULL,
  `course_name` varchar(100) NOT NULL,
  `class_name` varchar(25) NOT NULL,
  `schedule` varchar(100) NOT NULL,
  `classroom` varchar(10) NOT NULL,
  `lecturer` varchar(100) NOT NULL,
  `id_term` int(11) DEFAULT NULL,
  `class_flag` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classes`
--

INSERT INTO `classes` (`class_id`, `major_id`, `course_id`, `course_name`, `class_name`, `schedule`, `classroom`, `lecturer`, `id_term`, `class_flag`) VALUES
('99298', 'UIM002', 'UIC001', 'Dasar-Dasar Pemrograman 1', 'DDP 1 - B', 'Senin, 10.00-11.40 Rabu, 16.00-17.40', '2303', 'NULL', 6, 1),
('99299', 'UIM002', 'UIC001', 'Dasar-Dasar Pemrograman 1', 'DDP 1 - A', 'Senin, 13.00-14.40 Rabu, 14.00-15.40', '2301', 'NULL', 6, 1),
('99317', 'UIM002', 'UIC002', 'Dasar-Dasar Pemrograman 2', 'DDP 2 - C', 'Senin, 15.00-16.40 Rabu, 16.00-17.40', '2401', 'NULL', 7, 1),
('99318', 'UIM002', 'UIC002', 'Dasar-Dasar Pemrograman 2', 'DDP 2 - B', 'Selasa, 08.00-09.40 Kamis, 09.00-10.40', '2404', 'NULL', 7, 1),
('99319', 'UIM002', 'UIC002', 'Dasar-Dasar Pemrograman 2', 'DDP 2 - A', 'Senin, 13.00-14.40 Rabu, 14.00-15.40', '2602', 'NULL', 6, 1);

-- --------------------------------------------------------

Table structure for table `class_lecturer`
--

CREATE TABLE `class_lecturer` (
  `id` int(11) NOT NULL,
  `class_id` char(5) NOT NULL,
  `nip` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `class_lecturer`
--

INSERT INTO `class_lecturer` (`id`, `class_id`, `nip`) VALUES
(1, '99296', '1100229933'),
(2, '99297', '1100229933');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `class_lecturer`
--
ALTER TABLE `class_lecturer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `class_lecturer_ibfk_1` (`class_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `class_lecturer`
--
ALTER TABLE `class_lecturer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `class_lecturer`
--
ALTER TABLE `class_lecturer`
  ADD CONSTRAINT `class_lecturer_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id_course` varchar(7) NOT NULL,
  `name` varchar(100) NOT NULL,
  `sks` int(11) NOT NULL,
  `sks_required` int(11) NOT NULL,
  `flag_active` BOOLEAN NOT NULL DEFAULT TRUE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

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

-- --------------------------------------------------------

--
-- Table structure for table `course_availability`
--

CREATE TABLE `course_availability` (
  `id_course` varchar(7) NOT NULL,
  `id_term` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_availability`
--

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('6', 'UIC001');

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('7', 'UIC002');

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('6', 'UIC003');

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('7', 'UIC004');

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('7', 'UGMC001');

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('6', 'UGMC002');

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('6', 'UGMC003');

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('6', 'ITBC001');

INSERT INTO COURSE_AVAILABILITY (id_term, id_course)
VALUES ('7', 'ITBC002');

-- --------------------------------------------------------

--
-- Table structure for table `course_class_student`
--

CREATE TABLE `course_class_student` (
  `id` int(11) NOT NULL,
  `student_npm` char(10) NOT NULL,
  `id_class` char(5) NOT NULL,
  `id_course` varchar(7) NOT NULL,
  `grade` int(3) NOT NULL DEFAULT '0',
  `course_status` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `curriculum`
--

CREATE TABLE `curriculum` (
  `id_curriculum` varchar(7) NOT NULL,
  `curriculum_year` int(11) NOT NULL,
  `id_major` varchar(7) NOT NULL,
  `flag_active` BOOLEAN NOT NULL DEFAULT TRUE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `curriculum`
--

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

-- --------------------------------------------------------

--
-- Table structure for table `curriculum_course`
--

CREATE TABLE `curriculum_course` (
  `obligatory_flag` char(4) NOT NULL,
  `id_curriculum` varchar(7) NOT NULL,
  `id_course` varchar(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `curriculum_course`
--

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

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `id_faculty` varchar(6) NOT NULL,
  `name` varchar(100) NOT NULL,
  `telephone_number` varchar(13) NOT NULL,
  `accreditation` char(1) NOT NULL,
  `id_group` varchar(5) NOT NULL,
  `id_univ` CHAR(5) NOT NULL,
  `flag_active` BOOLEAN NOT NULL DEFAULT TRUE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

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

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE `groups` (
  `id_group` varchar(5) NOT NULL,
  `name` varchar(100) NOT NULL,
  `id_univ` char(5) NOT NULL,
  `flag_active` BOOLEAN NOT NULL DEFAULT TRUE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groups`
--

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

-- --------------------------------------------------------

--
-- Table structure for table `lecturer_attendance`
--

CREATE TABLE `lecturer_attendance` (
  `schedule_id` char(5) NOT NULL,
  `nik` char(9) NOT NULL,
  `att_flag_lecturer` tinyint(1) DEFAULT '0',
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lecturer_attendance`
--

INSERT INTO `lecturer_attendance` (`schedule_id`, `nik`, `att_flag_lecturer`, `date`) VALUES
('77171', 'NULL', 0, '0000-00-00'),
('77181', 'NULL', 0, '0000-00-00'),
('77182', 'NULL', 0, '0000-00-00'),
('77991', 'NULL', 0, '0000-00-00'),
('77992', 'NULL', 0, '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `major`
--

CREATE TABLE `major` (
  `id_major` varchar(7) NOT NULL,
  `name` varchar(100) NOT NULL,
  `id_faculty` varchar(6) NOT NULL,
  `flag_active` BOOLEAN NOT NULL DEFAULT TRUE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `major`
--

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

-- --------------------------------------------------------

--
-- Table structure for table `pre_condition`
--

CREATE TABLE `pre_condition` (
  `id_course` varchar(7) NOT NULL,
  `id_course_required` varchar(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Dumping data for table `pre_condition`
--

INSERT INTO pre_condition (id_course, id_course_required)
VALUES ('UIC002', 'UIC001');

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `class_id` char(5) NOT NULL,
  `schedule_id` char(5) NOT NULL,
  `day` varchar(20) NOT NULL,
  `time_start` time NOT NULL,
  `time_end` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`class_id`, `schedule_id`, `day`, `time_start`, `time_end`) VALUES
('99317', '77171', 'Monday', '00:00:15', '00:00:16'),
('99318', '77181', 'Tuesday', '00:00:08', '00:00:09'),
('99318', '77182', 'Thursday', '00:00:09', '00:00:10'),
('99299', '77991', 'Monday', '00:00:13', '00:00:14'),
('99299', '77992', 'Wednesday', '00:00:14', '00:00:15');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `npm` char(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `id_univ` char(5) NOT NULL,
  `id_faculty` varchar(6) NOT NULL,
  `id_major` varchar(7) NOT NULL,
  `id_curriculum` varchar(7) NOT NULL,
  `deleted` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `npm`, `name`, `id_univ`, `id_faculty`, `id_major`, `id_curriculum`, `deleted`) VALUES
(1, '1406557472', 'Fara', 'U0001', 'UIF01', 'UIM002', 'UIK002', 0);

-- --------------------------------------------------------

--
-- Table structure for table `student_attendance`
--

CREATE TABLE `student_attendance` (
  `schedule_id` char(5) NOT NULL,
  `npm` char(10) NOT NULL,
  `att_flag_student` tinyint(1) DEFAULT '0',
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_attendance`
--

INSERT INTO `student_attendance` (`schedule_id`, `npm`, `att_flag_student`, `date`) VALUES
('77171', '1406557472', 0, '2016-05-29'),
('77181', '1406557472', 0, '2016-05-29'),
('77182', '1406557472', 0, '2016-05-29'),
('77991', '1406557472', 0, '2016-05-29'),
('77992', '1406557472', 0, '2016-05-29');

-- --------------------------------------------------------

--
-- Table structure for table `student_supervisor`
--

CREATE TABLE `student_supervisor` (
  `id` int(11) NOT NULL,
  `student_npm` char(10) NOT NULL,
  `supervisor_nip` char(18) NOT NULL,
  `assigned_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `term`
--

CREATE TABLE `term` (
  `term_year` char(9) NOT NULL,
  `term_Held` char(1) NOT NULL,
  `id_term` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `term`
--

INSERT INTO `term` (`term_year`, `term_Held`, `id_term`) VALUES
('2016/2017', '1', 6),
('2016/2017', '2', 7),
('2015/2016', '1', 8);

-- --------------------------------------------------------

--
-- Table structure for table `univ`
--

CREATE TABLE `univ` (
  `id_univ` char(5) NOT NULL,
  `name` varchar(100) NOT NULL,
  `telephone_number` varchar(13) NOT NULL,
  `address` text NOT NULL,
  `initial_univ` varchar(3) NOT NULL,
  `accreditation` char(1) NOT NULL,
  `flag_active` BOOLEAN NOT NULL DEFAULT TRUE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `univ`
--

INSERT INTO `univ` (`id_univ`, `name`, `telephone_number`, `address`, `initial_univ`, `accreditation`) VALUES
('U0001', 'Universitas Indonesia', '0217867222', 'Depok, Indonesia', 'UI', 'A'),
('U0002', 'Universitas Gadjah Mada', '0274588688', 'Yogyakarta, Indonesia', 'UGM', 'A'),
('U0003', 'Institut Teknologi Bandung', '0222500935', 'Bandung, Indonesia', 'ITB', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` int(1) NOT NULL,
  `id_user` varchar(18) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`class_id`),
  ADD KEY `major_id` (`major_id`),
  ADD KEY `course_id` (`course_id`),
  ADD KEY `id_term` (`id_term`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id_course`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `course_availability`
--
ALTER TABLE `course_availability`
  ADD PRIMARY KEY (`id_course`, `id_term`),
  ADD KEY `id_term` (`id_term`);

--
-- Indexes for table `course_class_student`
--
ALTER TABLE `course_class_student`
  ADD PRIMARY KEY (`id`),
  ADD KEY `student_npm` (`student_npm`),
  ADD KEY `id_class` (`id_class`),
  ADD KEY `id_course` (`id_course`);

--
-- Indexes for table `curriculum`
--
ALTER TABLE `curriculum`
  ADD PRIMARY KEY (`id_curriculum`),
  ADD UNIQUE KEY (`curriculum_year`, `id_major`, `id_curriculum`),
  ADD KEY `id_major` (`id_major`);

--
-- Indexes for table `curriculum_course`
--
ALTER TABLE `curriculum_course`
  ADD PRIMARY KEY (`id_curriculum`,`id_course`),
  ADD KEY `id_course` (`id_course`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`id_faculty`),
  ADD UNIQUE KEY (`name`, `id_group`),
  ADD KEY `id_group` (`id_group`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`id_group`),
  ADD UNIQUE KEY (`name`, `id_univ`),
  ADD KEY `id_univ` (`id_univ`);

--
-- Indexes for table `lecturer_attendance`
--
ALTER TABLE `lecturer_attendance`
  ADD PRIMARY KEY (`schedule_id`,`nik`,`date`);

--
-- Indexes for table `major`
--
ALTER TABLE `major`
  ADD PRIMARY KEY (`id_major`),
  ADD UNIQUE KEY (`name`, `id_faculty`),
  ADD KEY `id_faculty` (`id_faculty`);

--
-- Indexes for table `pre_condition`
--
ALTER TABLE `pre_condition`
  ADD PRIMARY KEY (`id_course`,`id_course_required`),
  ADD KEY `id_course_required` (`id_course_required`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`schedule_id`),
  ADD KEY `fk_class_id` (`class_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `npm` (`npm`),
  ADD KEY `id_univ` (`id_univ`),
  ADD KEY `id_faculty` (`id_faculty`),
  ADD KEY `id_major` (`id_major`),
  ADD KEY `id_curriculum` (`id_curriculum`);

--
-- Indexes for table `student_attendance`
--
ALTER TABLE `student_attendance`
  ADD PRIMARY KEY (`schedule_id`,`npm`,`date`),
  ADD KEY `fk_npm` (`npm`);

--
-- Indexes for table `student_supervisor`
--
ALTER TABLE `student_supervisor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `student_npm` (`student_npm`),
  ADD KEY `supervisor_nip` (`supervisor_nip`);

--
-- Indexes for table `term`
--
ALTER TABLE `term`
  ADD PRIMARY KEY (`id_term`);

--
-- Indexes for table `univ`
--
ALTER TABLE `univ`
  ADD PRIMARY KEY (`id_univ`),
  ADD UNIQUE KEY `name` (`name`),
  ADD UNIQUE KEY `initial_univ` (`initial_univ`),
  ADD UNIQUE KEY `telephone_number` (`telephone_number`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `student_supervisor`
--
ALTER TABLE `student_supervisor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `term`
--
ALTER TABLE `term`
  MODIFY `id_term` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `classes`
--
ALTER TABLE `classes`
  ADD CONSTRAINT `classes_ibfk_1` FOREIGN KEY (`major_id`) REFERENCES `major` (`id_major`),
  ADD CONSTRAINT `classes_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id_course`),
  ADD CONSTRAINT `classes_ibfk_3` FOREIGN KEY (`id_term`) REFERENCES `term` (`id_term`);

--
-- Constraints for table `course_availability`
--
ALTER TABLE `course_availability`
  ADD CONSTRAINT `course_availability_ibfk_1` FOREIGN KEY (`id_course`) REFERENCES `course` (`id_course`),
  ADD CONSTRAINT `course_availability_ibfk_2` FOREIGN KEY (`id_term`) REFERENCES `term` (`id_term`);

--
-- Constraints for table `course_class_student`
--
ALTER TABLE `course_class_student`
  ADD CONSTRAINT `id_class` FOREIGN KEY (`id_class`) REFERENCES `classes` (`class_id`),
  ADD CONSTRAINT `id_course` FOREIGN KEY (`id_course`) REFERENCES `course` (`id_course`),
  ADD CONSTRAINT `student_npm` FOREIGN KEY (`student_npm`) REFERENCES `student` (`npm`);

--
-- Constraints for table `curriculum`
--
ALTER TABLE `curriculum`
  ADD CONSTRAINT `curriculum_ibfk_1` FOREIGN KEY (`id_major`) REFERENCES `major` (`id_major`);

--
-- Constraints for table `curriculum_course`
--
ALTER TABLE `curriculum_course`
  ADD CONSTRAINT `curriculum_course_ibfk_1` FOREIGN KEY (`id_curriculum`) REFERENCES `curriculum` (`id_curriculum`),
  ADD CONSTRAINT `curriculum_course_ibfk_2` FOREIGN KEY (`id_course`) REFERENCES `course` (`id_course`);

--
-- Constraints for table `faculty`
--
ALTER TABLE `faculty`
  ADD CONSTRAINT `faculty_ibfk_1` FOREIGN KEY (`id_group`) REFERENCES `groups` (`id_group`),
  ADD CONSTRAINT `faculty_ibfk_2` FOREIGN KEY (`id_univ`) REFERENCES `univ` (`id_univ`);

--
-- Constraints for table `groups`
--
ALTER TABLE `groups`
  ADD CONSTRAINT `groups_ibfk_1` FOREIGN KEY (`id_univ`) REFERENCES `univ` (`id_univ`);

--
-- Constraints for table `lecturer_attendance`
--
ALTER TABLE `lecturer_attendance`
  ADD CONSTRAINT `fk_schedule_idl` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`schedule_id`);

--
-- Constraints for table `major`
--
ALTER TABLE `major`
  ADD CONSTRAINT `major_ibfk_1` FOREIGN KEY (`id_faculty`) REFERENCES `faculty` (`id_faculty`);

--
-- Constraints for table `pre_condition`
--
ALTER TABLE `pre_condition`
  ADD CONSTRAINT `pre_condition_ibfk_1` FOREIGN KEY (`id_course`) REFERENCES `course` (`id_course`),
  ADD CONSTRAINT `pre_condition_ibfk_2` FOREIGN KEY (`id_course_required`) REFERENCES `course` (`id_course`);

--
-- Constraints for table `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `fk_class_id` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `id_curriculum` FOREIGN KEY (`id_curriculum`) REFERENCES `curriculum` (`id_curriculum`),
  ADD CONSTRAINT `id_faculty` FOREIGN KEY (`id_faculty`) REFERENCES `faculty` (`id_faculty`),
  ADD CONSTRAINT `id_major` FOREIGN KEY (`id_major`) REFERENCES `major` (`id_major`),
  ADD CONSTRAINT `id_univ` FOREIGN KEY (`id_univ`) REFERENCES `univ` (`id_univ`);

--
-- Constraints for table `student_attendance`
--
ALTER TABLE `student_attendance`
  ADD CONSTRAINT `fk_npm` FOREIGN KEY (`npm`) REFERENCES `student` (`npm`),
  ADD CONSTRAINT `fk_schedule_ids` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`schedule_id`);

--
-- Constraints for table `student_supervisor`
--
ALTER TABLE `student_supervisor`
  ADD CONSTRAINT `student_npm_supervisor` FOREIGN KEY (`student_npm`) REFERENCES `student` (`npm`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
