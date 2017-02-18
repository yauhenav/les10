package les10;

import java.sql.*;
import java.util.*;

public class Demo {
	public static void main (String args[]) {

			// Создаем объект сеанса работы с базой данных
			Connection con = null;
			DaoFactory interDaoFact = null;
			StudentDao interDaoStud = null;
			SubjectDao interDaoSub = null;
			MarkDao interDaoMar = null;
		try {		
			interDaoFact = new MySqlDaoFactory ();
			con = interDaoFact.getConnect();
		
		//Прочитать всех студентов
			interDaoStud = interDaoFact.getStudentDao(con);
			List showStuds0 = interDaoStud.getAll();
			System.out.println ("Here's a list of all students in the DB");
			Iterator<Student> itrstud0 = showStuds0.iterator();
			while (itrstud0.hasNext()) {
				Student element = itrstud0.next();
				System.out.println (element.toString());
			}
		
		// Получить все предметы

			interDaoSub = interDaoFact.getSubjectDao(con);
			List showSubs0 = interDaoSub.getAll();		
			System.out.println ("Here goes a list of all subjects in the DB");
			Iterator<Subject> itrsub0 = showSubs0.iterator();
			while (itrsub0.hasNext()) {
				Subject element = itrsub0.next();
				System.out.println (element.toString());
			}
		
		// Получить все оценки из БД
			interDaoMar = interDaoFact.getMarkDao(con);
			List showAllMarks = interDaoMar.getAll();
			System.out.println ("Here goes a list of all marks of all students for all subjects");
			Iterator<Mark> itrmar0 = showAllMarks.iterator();
			while (itrmar0.hasNext()) {
				Mark element = itrmar0.next();
				System.out.println (element.toString());
			}
		
		// Получить все предметы одного студента вместе с оценками по ID студента
			List showMarksOneStud = interDaoMar.getAllMarkOneStud(4);
			System.out.println ("Here goes a list of all marks of one student");
			Iterator<Mark> itrmar1 = showMarksOneStud.iterator();
			while (itrmar1.hasNext()) {
				Mark element = itrmar1.next();
				System.out.println (element.toString());
			}
		
		// Прочитать студента по его ключу
			System.out.println ("Here goes one student from selected key");
			Student dummyStud1 = interDaoStud.read(5);
			System.out.println(dummyStud1.toString());
		
		// добавить в БД новую запись на основании переданного экземпляра студента
			System.out.println("Here goes a new student added to DB");
			Student dummyStud4 = new Student();
			dummyStud4.setId(11);
			dummyStud4.setName("Jaques");
			dummyStud4.setSurname("Chiraques");
			interDaoStud.create(dummyStud4);
			List showStuds2 = interDaoStud.getAll();
			System.out.println ("Here's a list of all students in the DB after addition");
			Iterator<Student> itrstud2 = showStuds2.iterator();
			while (itrstud2.hasNext()) {
				Student element = itrstud2.next();
				System.out.println (element.toString());
			}
			
		// обновить студента
			System.out.println("Here goes updated student");
			Student dummyStud2 = new Student();
			dummyStud2.setId(11);
			dummyStud2.setName("Gerhard");
			dummyStud2.setSurname("Shreder");
			interDaoStud.update (dummyStud2);
			System.out.println(interDaoStud.read(11).toString());
		
		// удалить из БД запись на основании переданного экземпляра студента
			System.out.println("This is to demonstrate the deletion of a student by ID");
			Student dummyStud3 = interDaoStud.read(11);
			interDaoStud.delete (dummyStud3);
			List showStuds1 = interDaoStud.getAll();
			System.out.println ("Here's a list of all students in the DB after deletion");
			Iterator<Student> itrstud1 = showStuds1.iterator();
			while (itrstud1.hasNext()) {
				Student element = itrstud1.next();
				System.out.println (element.toString());
			}
		
		// Прочитать предмет по его ключу
			System.out.println("Here goes one subject from specified key");
			Subject dummySubj1 = interDaoSub.read(3);
			System.out.println(dummySubj1.toString());

		// добавить в БД новую запись на основании переданного экземпляра предмета
			System.out.println ("Here goes a demonstration of a subject addition");
			Subject dummySubj3 = new Subject();
			dummySubj3.setId(7);
			dummySubj3.setDescription("SOFTWARE DESIGN");
			interDaoSub.create(dummySubj3);
			List showSubs3 = interDaoSub.getAll();
			System.out.println ("Here goes a list of all subjects in the DB after addition");
			Iterator<Subject> itrsub3 = showSubs3.iterator();
			while (itrsub3.hasNext()) {
				Subject element = itrsub3.next();
				System.out.println (element.toString());
			}
		
		// обновить предмет по указанному ID
			System.out.println("Here goes a demonstration of a subject update");
			Subject dummySubj2 = new Subject();
			dummySubj2.setId(7);
			dummySubj2.setDescription("SOFTWARE ENGINEERING");
			interDaoSub.update(dummySubj2);
			List showSubs2 = interDaoSub.getAll();
			System.out.println ("Here goes a list of all subjects in the DB after update");
			Iterator<Subject> itrsub2 = showSubs2.iterator();
			while (itrsub2.hasNext()) {
				Subject element = itrsub2.next();
				System.out.println (element.toString());
			}
				
		// удалить из БД запись на основании переданного экземпляра предмета
			System.out.println ("This is to demonstrate the deletion of a subject by ID");
			Subject dummySubj4 = new Subject();
			dummySubj4.setId(7);
			interDaoSub.delete(dummySubj4);
			List showSubs4 = interDaoSub.getAll();
			System.out.println ("Here goes a list of all subjects in the DB after deletion");
			Iterator<Subject> itrsub4 = showSubs4.iterator();
			while (itrsub4.hasNext()) {
				Subject element = itrsub4.next();
				System.out.println (element.toString());
			}
		
		// прочитать оценку по переданному ID экзмпляра Mark
			System.out.println("Here goes a mark selected by Mark's ID");
			Mark dummyMar1 = interDaoMar.read(21);
			System.out.println(dummyMar1.toString());

		// добавить в БД новую запись оценки на основании переданного экземпляра студента и предмета
			System.out.println("Here goes demonstration of a Mark addition");
			Mark dummyMar2 = new Mark();
			dummyMar2.setId(61);
			dummyMar2.setValue(6);
			dummyMar2.setStudentId(10);
			dummyMar2.setSubjectId(4);
			interDaoMar.create(dummyMar2);
			List showAllMarks2 = interDaoMar.getAll();
			System.out.println ("Here goes a list of all marks of all students for all subjects after addition");
			Iterator<Mark> itrmar2 = showAllMarks2.iterator();
			while (itrmar2.hasNext()) {
				Mark element = itrmar2.next();
				System.out.println (element.toString());
			}
		
		// обновить оценку
			System.out.println ("Here goes demonstration of a Mark update");
			Mark dummyMar3 = new Mark();
			dummyMar3.setId(61);
			dummyMar3.setValue(8);
			dummyMar3.setStudentId(9);
			dummyMar3.setSubjectId(5);
			interDaoMar.update(dummyMar3);
			List showAllMarks3 = interDaoMar.getAll();
			System.out.println ("Here goes a list of all marks of all students for all subjects after update");
			Iterator<Mark> itrmar3 = showAllMarks3.iterator();
			while (itrmar3.hasNext()) {
				Mark element = itrmar3.next();
				System.out.println (element.toString());
			}
			
		// удалить оценку из БД
			System.out.println("Here goes demonstration of a Mark deletion");
			interDaoMar.delete(61);
			List showAllMarks4 = interDaoMar.getAll();
			System.out.println ("Here goes a list of all marks of all students for all subjects after deletion");
			Iterator<Mark> itrmar4 = showAllMarks4.iterator();
			while (itrmar4.hasNext()) {
				Mark element = itrmar4.next();
				System.out.println (element.toString());
			}
		} catch (DaoException | SQLException exc) {
			exc.printStackTrace();
		}
		
		finally {
			try {
				if (interDaoStud != null) {
					interDaoStud.close();
				} else {
					System.out.println("MySqlStudentDao object was not created");
				}
				if (interDaoSub != null) {
					interDaoSub.close();
				} else {
					System.out.println("MySqlSubjectDao object was not created");
				}
				if (interDaoMar != null) {
					interDaoMar.close();
				} else {
					System.out.println("MySqlMarkDao object was not created");
				}
				if (con != null) {
					con.close();
				} else {
					System.out.println("Connection object was not created");	
				} 
			} catch (DaoException | SQLException exc) {
				exc.printStackTrace();
			}
		}
	}
}
