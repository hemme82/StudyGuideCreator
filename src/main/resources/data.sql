
--CREATE TABLE users(
--    id Long,
--    username varchar(255),
--    password varchar(255)
--);


INSERT INTO topic(topic_Name, topic_Description)
VALUES
('Attendance Overview', 'The document and video below provide an overview of the attendance tool.'),
('Manage Individual Student Attendance', 'Attendance for individual students
can be entered and edited from this location.'),
('Positive Attendance for an Individual Student', 'Positive Attendance records student attendance
 using time present.');

INSERT INTO tab_item(tab_Name, tab_Url, topic)
VALUES
('DOCUMENT', 'https://content.infinitecampus.com/sis/latest/documentation/attendance/', 1),
('WHITEBOARD VIDEO', 'https://content.infinitecampus
.com/sis/latest/video/learn/understand-attendance-tracking/?wrapper=embed', 1),
('DOCUMENT', 'https://content.infinitecampus
.com/sis/latest/documentation/attendance-student/', 2),
('VIDEO', 'https://content.infinitecampus
.com/sis/latest/video/learn/manage-individual-student-attendance/?wrapper=embed', 2),
('DOCUMENT', 'https://content.infinitecampus
.com/sis/latest/documentation/attendance-student/#Attendance(Student)
-Managepositiveattendanceforindividualstudent', 3)

;
