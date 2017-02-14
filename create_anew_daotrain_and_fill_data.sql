CREATE DATABASE `daotrain` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE daotrain; 

CREATE TABLE `subject` (
  `ID` int(3) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(64) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE TABLE `student` (
  `ID` int(3) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(64) NOT NULL,
  `SURNAME` varchar(64) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

CREATE TABLE `mark` (
  `ID` int(3) NOT NULL AUTO_INCREMENT,
  `VALUE` int(3) NOT NULL,
  `STUDENT_ID` int(10),
  `SUBJECT_ID` int(10),
  PRIMARY KEY (`ID`),
  KEY `SUBJECT_ID` (`SUBJECT_ID`),
  KEY `STUDENT_ID` (`STUDENT_ID`),
  CONSTRAINT `mark_ibfk_1` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `subject` (`ID`) ON DELETE SET NULL,
  CONSTRAINT `mark_ibfk_2` FOREIGN KEY (`STUDENT_ID`) REFERENCES `student` (`ID`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

INSERT INTO `student` (`ID`,`NAME`,`SURNAME`) VALUES (1,'BILL','CLINTON');
INSERT INTO `student` (`ID`,`NAME`,`SURNAME`) VALUES (2,'BARACK','OBAMA');
INSERT INTO `student` (`ID`,`NAME`,`SURNAME`) VALUES (3,'DONALD','TRUMP');
INSERT INTO `student` (`ID`,`NAME`,`SURNAME`) VALUES (4,'GEORGE','BUSH');
INSERT INTO `student` (`ID`,`NAME`,`SURNAME`) VALUES (5,'MICHAEL','JACKSON');
INSERT INTO `student` (`ID`,`NAME`,`SURNAME`) VALUES (6,'HILARY','CLINTON');
INSERT INTO `student` (`ID`,`NAME`,`SURNAME`) VALUES (7,'ANGELA','MERKEL');
INSERT INTO `student` (`ID`,`NAME`,`SURNAME`) VALUES (8,'FRANSOIS','OLLAND');
INSERT INTO `student` (`ID`,`NAME`,`SURNAME`) VALUES (9,'ADAM','SMITH');
INSERT INTO `student` (`ID`,`NAME`,`SURNAME`) VALUES (10,'WINSTON','CHURCHILL');

INSERT INTO `subject` (`ID`,`DESCRIPTION`) VALUES (1,'MATHEMATICS');
INSERT INTO `subject` (`ID`,`DESCRIPTION`) VALUES (2,'LITERATURE');
INSERT INTO `subject` (`ID`,`DESCRIPTION`) VALUES (3,'STATISTICS');
INSERT INTO `subject` (`ID`,`DESCRIPTION`) VALUES (4,'ECONOMICS');
INSERT INTO `subject` (`ID`,`DESCRIPTION`) VALUES (5,'ENGLISH');
INSERT INTO `subject` (`ID`,`DESCRIPTION`) VALUES (6,'INFORMATION TECHNOLOGY');

INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (1,10,1,1);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (2,9,1,2);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (3,8,1,3);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (4,7,1,4);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (5,6,1,5);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (6,5,1,6);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (7,4,2,1);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (8,3,2,2);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (9,2,2,3);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (10,1,2,4);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (11,2,2,5);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (12,3,2,6);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (13,4,3,1);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (14,5,3,2);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (15,6,3,3);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (16,7,3,4);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (17,8,3,5);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (18,9,3,6);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (19,10,4,1);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (20,9,4,2);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (21,8,4,3);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (22,7,4,4);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (23,6,4,5);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (24,5,4,6);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (25,4,5,1);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (26,3,5,2);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (27,2,5,3);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (28,3,5,4);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (29,4,5,5);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (30,5,5,6);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (31,6,6,1);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (32,7,6,2);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (33,8,6,3);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (34,9,6,4);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (35,8,6,5);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (36,7,6,6);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (37,6,7,1);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (38,5,7,2);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (39,4,7,3);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (40,3,7,4);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (41,2,7,5);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (42,1,7,6);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (43,2,8,1);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (44,3,8,2);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (45,4,8,3);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (46,5,8,4);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (47,6,8,5);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (48,7,8,6);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (49,8,9,1);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (50,7,9,2);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (51,8,9,3);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (52,9,9,4);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (53,10,9,5);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (54,5,9,6);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (55,6,10,1);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (56,8,10,2);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (57,7,10,3);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (58,4,10,4);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (59,5,10,5);
INSERT INTO `mark` (`ID`,`VALUE`,`STUDENT_ID`,`SUBJECT_ID`) VALUES (60,6,10,6);