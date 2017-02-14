package les10;

import java.sql.*;
import java.util.*;

public class MySqlStudentDao implements StudentDao {
    private Connection connection;
	public final static String SQL_CREATE = "INSERT INTO daotrain.STUDENT (ID, NAME, SURNAME) VALUES (?, ?, ?)";
	public final static String SQL_READ = "SELECT ID, NAME, SURNAME FROM daotrain.STUDENT WHERE ID = ?";
	public final static String SQL_UPDATE = "UPDATE daotrain.STUDENT SET NAME = ?, SURNAME = ? WHERE ID = ?";
	public final static String SQL_DELETE = "DELETE FROM daotrain.STUDENT WHERE ID = ?";
	public final static String SQL_GETALL = "SELECT ID, NAME, SURNAME FROM daotrain.STUDENT";
	
	public PreparedStatement psCreateStud = null;
	public PreparedStatement psReadStud = null;
	public PreparedStatement psUpdStud = null;
	public PreparedStatement psDelStud = null;
	public PreparedStatement psGetAllStud = null;
	public ResultSet rsReadStud = null;
	public ResultSet rsGetAllStud = null;
	
	// Конструктор
	public MySqlStudentDao(Connection connection) throws DaoException {
		try {
		this.connection = connection;
		psCreateStud = connection.prepareStatement(SQL_CREATE);
		psReadStud = connection.prepareStatement(SQL_READ);
		psUpdStud = connection.prepareStatement(SQL_UPDATE);
		psDelStud = connection.prepareStatement(SQL_DELETE);
		psGetAllStud = connection.prepareStatement(SQL_GETALL);
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		}
    }
	
	// Добавить в БД новую запись студента в соответствии с переданным экземляром Student
    @Override 
    public void create(Student student) throws DaoException {
		try {
			psCreateStud.setInt(1, student.getId());
			psCreateStud.setString(2, student.getName());
			psCreateStud.setString(3, student.getSurname());
			psCreateStud.execute();
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		} 
	}
    
    // Получить из БД экземпляр Student по указанному ID
	@Override 
    public Student read(int key) throws DaoException {
		try {
			psReadStud.setInt(1, key);
			rsReadStud = psReadStud.executeQuery();
			rsReadStud.next();
			Student tempStud0 = new Student();
			tempStud0.setId(rsReadStud.getInt("ID"));
			tempStud0.setName(rsReadStud.getString("NAME"));
			tempStud0.setSurname(rsReadStud.getString("SURNAME"));
			return tempStud0;
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		}
		finally {
			try {
				if (rsReadStud != null) {
					rsReadStud.close();
				} else {
					System.err.println ("RS set of table results was not created");
				}
			} catch (SQLException exc) {
				throw new DaoException ("Exception for DAO");
			}
		}
	}	
	
	// Обновить имеющуюся запись в БД в соответствии с переданным экземпляром Student
	@Override 
    public void update(Student student) throws DaoException {
		try {
			psUpdStud.setString(1, student.getName());
			psUpdStud.setString(2, student.getSurname());
			psUpdStud.setInt(3, student.getId());
			psUpdStud.execute();
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		} 
	}

	// Удалить запись из БД по фамилиии из переданного экзмепляра Student
    @Override 
    public void delete(Student student) throws DaoException {
		try {
			psDelStud.setInt (1, student.getId());
			psDelStud.execute();
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		} 
	}

	// Создать коллекцию и заполнить ее всеми имеющимися объектами в БД
    @Override
    public List<Student> getAll() throws DaoException {
		try {
			rsGetAllStud = psGetAllStud.executeQuery();        
			List<Student> list = new ArrayList<Student>();
			while (rsGetAllStud.next()) {
				Student tempStud1 = new Student();
				tempStud1.setId(rsGetAllStud.getInt("ID"));
				tempStud1.setName(rsGetAllStud.getString("NAME"));
				tempStud1.setSurname(rsGetAllStud.getString("SURNAME"));
				list.add(tempStud1);
			}
			return list;
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		}
		finally {
			try {
				if (rsGetAllStud != null) {
					rsGetAllStud.close();
				} else {
					System.err.println ("RS set of table results was not created");
				}
			} catch (SQLException exc) {
					throw new DaoException ("Exception for DAO");
			}
		}
	}
	
	// Закрыть все PreparedStatement и Connection, чтобы освободить ресурсы БД
	public void close() throws DaoException {
		try {
			if (psCreateStud != null) {
				psCreateStud.close();
				} else {
					System.err.println ("PS statement was not created");
				}
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		}
		try {
			if (psReadStud != null) {
				psReadStud.close();
				} else {
					System.err.println ("PS statement was not created");
				}
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		}
		try {
			if (psUpdStud != null) {
				psUpdStud.close();
				} else {
					System.err.println ("PS statement was not created");
				}
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		}
		try {
			if (psDelStud != null) {
				psDelStud.close();
				} else {
					System.err.println ("PS statement was not created");
				}
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		}
		try {
			if (psGetAllStud != null) {
				psGetAllStud.close();
				} else {
					System.err.println ("PS statement was not created");
				}
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		}
		try {
			if (connection != null) {
				connection.close();
				} else {
					System.err.println ("Connection was not established");
				}
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		}
	}
}
