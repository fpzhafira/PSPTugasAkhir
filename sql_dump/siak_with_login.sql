-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2016 at 08:19 AM
-- Server version: 10.1.8-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


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

-- Table structure for table `class_lecturer`
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
  `flag_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id_course`, `name`, `sks`, `sks_required`, `flag_active`) VALUES
('ITBC001', 'Fisika Dasar 1', 3, 0, 1),
('ITBC002', 'Administrasi Bisnis', 3, 0, 1),
('UGMC001', 'Hukum Perdata', 3, 48, 1),
('UGMC002', 'Pencernaan Manusia', 4, 0, 1),
('UGMC003', 'Ekosistem Laut', 3, 0, 1),
('UIC001', 'Dasar-Dasar Pemrograman 1', 4, 0, 1),
('UIC002', 'Dasar-Dasar Pemrograman 2', 4, 0, 1),
('UIC003', 'Dasar-Dasar Hukum', 3, 0, 1),
('UIC004', 'Patologi Dasar', 3, 0, 1);

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

INSERT INTO `course_availability` (`id_course`, `id_term`) VALUES
('ITBC001', 6),
('ITBC002', 7),
('UGMC001', 7),
('UGMC002', 6),
('UGMC003', 6),
('UIC001', 6),
('UIC002', 7),
('UIC003', 6),
('UIC004', 7);

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
  `flag_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `curriculum`
--

INSERT INTO `curriculum` (`id_curriculum`, `curriculum_year`, `id_major`, `flag_active`) VALUES
('ITBK001', 2012, 'ITBM001', 1),
('ITBK002', 2012, 'ITBM002', 1),
('ITBK003', 2012, 'ITBM003', 1),
('ITBK004', 2014, 'ITBM004', 1),
('ITBK005', 2016, 'ITBM005', 1),
('UGMK001', 2014, 'UGMM001', 1),
('UGMK002', 2014, 'UGMM002', 1),
('UGMK003', 2014, 'UGMM003', 1),
('UIK001', 2016, 'UIM001', 1),
('UIK002', 2016, 'UIM002', 1),
('UIK003', 2010, 'UIM003', 1),
('UIK004', 2010, 'UIM004', 1);

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

INSERT INTO `curriculum_course` (`obligatory_flag`, `id_curriculum`, `id_course`) VALUES
('0100', 'ITBK001', 'ITBC001'),
('0010', 'UGMK001', 'UGMC001'),
('0010', 'UGMK002', 'UGMC002'),
('0001', 'UGMK003', 'UGMC003'),
('0010', 'UIK001', 'UIC001'),
('0010', 'UIK001', 'UIC002'),
('0010', 'UIK002', 'UIC001'),
('0010', 'UIK002', 'UIC002'),
('0010', 'UIK003', 'UIC003'),
('0100', 'UIK004', 'UIC004');

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
  `id_univ` char(5) NOT NULL,
  `flag_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`id_faculty`, `name`, `telephone_number`, `accreditation`, `id_group`, `id_univ`, `flag_active`) VALUES
('ITBF01', 'Fakultas Teknik', '0222500935', 'A', 'ITBG1', 'U0003', 1),
('ITBF02', 'Sekolah Bisnis dan Manajemen', '0222500935', 'A', 'ITBG2', 'U0003', 1),
('UGMF01', 'Fakultas Hukum', '0274588688', 'A', 'UGMG3', 'U0002', 1),
('UGMF02', 'Fakultas Kedokteran', '0274588688', 'A', 'UGMG2', 'U0002', 1),
('UGMF03', 'Fakultas MIPA', '0274588688', 'A', 'UGMG1', 'U0002', 1),
('UIF01', 'Fakultas Ilmu Komputer', '0217867222', 'A', 'UIG1', 'U0001', 1),
('UIF02', 'Fakultas Kedokteran', '0217867222', 'A', 'UIG2', 'U0001', 1),
('UIF03', 'Fakultas Hukum', '0217867222', 'A', 'UIG3', 'U0001', 1);

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE `groups` (
  `id_group` varchar(5) NOT NULL,
  `name` varchar(100) NOT NULL,
  `id_univ` char(5) NOT NULL,
  `flag_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`id_group`, `name`, `id_univ`, `flag_active`) VALUES
('ITBG1', 'Teknologi', 'U0003', 1),
('ITBG2', 'Bisnis', 'U0003', 1),
('UGMG1', 'Sains', 'U0002', 1),
('UGMG2', 'Kesehatan', 'U0002', 1),
('UGMG3', 'Sosial', 'U0002', 1),
('UIG1', 'Sains dan Teknologi', 'U0001', 1),
('UIG2', 'Ilmu Kesehatan', 'U0001', 1),
('UIG3', 'Sosial dan Hukum', 'U0001', 1);

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
  `flag_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `major`
--

INSERT INTO `major` (`id_major`, `name`, `id_faculty`, `flag_active`) VALUES
('ITBM001', 'Teknik Mesin', 'ITBF01', 1),
('ITBM002', 'Arsitektur', 'ITBF01', 1),
('ITBM003', 'Teknik Elektro', 'ITBF01', 1),
('ITBM004', 'Bisnis', 'ITBF02', 1),
('ITBM005', 'Manajemen', 'ITBF02', 1),
('UGMM001', 'Ilmu Hukum', 'UGMF01', 1),
('UGMM002', 'Kedokteran', 'UGMF02', 1),
('UGMM003', 'Biologi', 'UGMF03', 1),
('UIM001', 'Sistem Informasi', 'UIF01', 1),
('UIM002', 'Ilmu Komputer', 'UIF01', 1),
('UIM003', 'Kedokteran', 'UIF02', 1),
('UIM004', 'Ilmu Hukum', 'UIF03', 1);

-- --------------------------------------------------------

--
-- Table structure for table `pre_condition`
--

CREATE TABLE `pre_condition` (
  `id_course` varchar(7) NOT NULL,
  `id_course_required` varchar(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pre_condition`
--

INSERT INTO `pre_condition` (`id_course`, `id_course_required`) VALUES
('UIC002', 'UIC001');

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
  `deleted` int(1) NOT NULL DEFAULT '0',
  `username` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `npm`, `name`, `id_univ`, `id_faculty`, `id_major`, `id_curriculum`, `deleted`, `username`) VALUES
(1, '1406557472', 'Fara Nadira', 'U0001', 'UIF01', 'UIM002', 'UIK002', 0, 'fara.nadira');

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
  `flag_active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `univ`
--

INSERT INTO `univ` (`id_univ`, `name`, `telephone_number`, `address`, `initial_univ`, `accreditation`, `flag_active`) VALUES
('U0001', 'Universitas Indonesia', '0217867222', 'Depok, Indonesia', 'UI', 'A', 1),
('U0002', 'Universitas Gadjah Mada', '0274588688', 'Yogyakarta, Indonesia', 'UGM', 'A', 1),
('U0003', 'Institut Teknologi Bandung', '0222500935', 'Bandung, Indonesia', 'ITB', 'A', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('fara.nadira', 'fara.nadira', 1),
('jundi.sekre', 'jundi.sekre', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_role_id`, `username`, `role`) VALUES
(2, 'jundi.sekre', 'sekre'),
(1, 'fara.nadira', 'student');

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
  ADD PRIMARY KEY (`id_course`);

--
-- Indexes for table `course_availability`
--
ALTER TABLE `course_availability`
  ADD PRIMARY KEY (`id_course`,`id_term`),
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
  ADD UNIQUE KEY `curriculum_year` (`curriculum_year`,`id_major`,`id_curriculum`),
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
  ADD UNIQUE KEY `name` (`name`,`id_group`),
  ADD KEY `id_group` (`id_group`),
  ADD KEY `faculty_ibfk_2` (`id_univ`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`id_group`),
  ADD UNIQUE KEY `name` (`name`,`id_univ`),
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
  ADD UNIQUE KEY `name` (`name`,`id_faculty`),
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
  ADD KEY `id_curriculum` (`id_curriculum`),
  ADD KEY `username` (`username`);

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
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_role_id`),
  ADD UNIQUE KEY `uni_username_role` (`role`,`username`),
  ADD KEY `fk_username_idx` (`username`);

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
-- AUTO_INCREMENT for table `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `user_role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
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
  ADD CONSTRAINT `id_univ` FOREIGN KEY (`id_univ`) REFERENCES `univ` (`id_univ`),
  ADD CONSTRAINT `user_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

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

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
