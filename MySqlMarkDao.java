package les10;

import java.sql.*;
import java.util.*;

public class MySqlMarkDao implements MarkDao {
    private Connection connection;
	public final static String SQL_CREATE = "INSERT INTO daotrain.MARK (ID, VALUE, STUDENT_ID, SUBJECT_ID) VALUES (?, ?, ?, ?)";
	public final static String SQL_READ = "SELECT ID, VALUE, STUDENT_ID, SUBJECT_ID FROM daotrain.MARK WHERE ID = ?";
	public final static String SQL_UPDATE = "UPDATE daotrain.MARK SET VALUE = ?, STUDENT_ID = ?, SUBJECT_ID = ? WHERE ID = ?";
	public final static String SQL_DELETE = "DELETE FROM daotrain.MARK WHERE ID = ?";
	public final static String SQL_GETALL = "SELECT ID, VALUE, STUDENT_ID, SUBJECT_ID FROM daotrain.MARK";	
	public final static String SQL_GETALL_ONE_STUDENT = "SELECT ID, VALUE, STUDENT_ID, SUBJECT_ID FROM daotrain.MARK WHERE STUDENT_ID = ?";
	
	public PreparedStatement psCreateMark = null;
	public PreparedStatement psReadMark = null;
	public PreparedStatement psUpdMark = null;
	public PreparedStatement psDelMark = null;
	public PreparedStatement psGetAllMark = null;
	public PreparedStatement psGetAllMarkOneStud = null;
	public ResultSet rsReadMark = null;
	public ResultSet rsGetAllMark = null;
	public ResultSet rsGetAllMarkOneStud = null;
	
	// Constructor
	public MySqlMarkDao(Connection connection) throws DaoException {
		try {
			this.connection = connection;
			psCreateMark = connection.prepareStatement(SQL_CREATE);
			psReadMark = connection.prepareStatement(SQL_READ);
			psUpdMark = connection.prepareStatement(SQL_UPDATE);
			psDelMark = connection.prepareStatement(SQL_DELETE);
			psGetAllMark = connection.prepareStatement(SQL_GETALL);
			psGetAllMarkOneStud = connection.prepareStatement(SQL_GETALL_ONE_STUDENT);
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		}
	}
	
    // Creates a new DB entry as per corresponding received object
	@Override
    public void create(Mark mark) throws DaoException {
		try {
			psCreateMark.setInt(1, mark.getId());
			psCreateMark.setInt(2, mark.getValue());
			psCreateMark.setInt(3, mark.getStudentId());
			psCreateMark.setInt(4, mark.getSubjectId());
			psCreateMark.execute();
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		} 
	}
	
    // Returns the object corresponding to the DB entry with received primary 'key'
    @Override
    public Mark read(int key) throws DaoException {
		try {
			psReadMark.setInt(1, key);
			rsReadMark = psReadMark.executeQuery();
			rsReadMark.next();
			Mark tempMark0 = new Mark();
			tempMark0.setId(rsReadMark.getInt("ID"));
			tempMark0.setValue(rsReadMark.getInt("VALUE"));
			tempMark0.setStudentId(rsReadMark.getInt("STUDENT_ID"));
			tempMark0.setSubjectId(rsReadMark.getInt("SUBJECT_ID"));
			return tempMark0;
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		}
		finally {
			try {
				if (rsReadMark != null) {
					rsReadMark.close();
				} else {
					System.err.println ("RS set of table results was not created");
				}
			} catch (SQLException exc) {
				throw new DaoException ("Exception for DAO");
			}
		}
	}	
	
    // Modifies the DB entry as per corresponding received object
    @Override
    public void update(Mark mark) throws DaoException {
		try {
			psUpdMark.setInt(1, mark.getValue());
			psUpdMark.setInt(2, mark.getStudentId());
			psUpdMark.setInt(3, mark.getSubjectId());
			psUpdMark.setInt(4, mark.getId());
			psUpdMark.execute();
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		} 
	}

    // Removes the DB entry as per corresponding received object
    @Override
    public void delete(int key) throws DaoException {
		try {
			psDelMark.setInt(1, key);
			psDelMark.execute();
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		} 
	}

    // Returns a list of objects corresponding to all DB entries
    @Override
    public List<Mark> getAll() throws DaoException {
		try {
			rsGetAllMark = psGetAllMark.executeQuery();
			List<Mark> list0 = new ArrayList<Mark>();
			while (rsGetAllMark.next()) {
				Mark tempMark1 = new Mark();
				tempMark1.setId(rsGetAllMark.getInt("ID"));
				tempMark1.setValue(rsGetAllMark.getInt("VALUE"));
				tempMark1.setStudentId(rsGetAllMark.getInt("STUDENT_ID"));
				tempMark1.setSubjectId(rsGetAllMark.getInt("SUBJECT_ID"));
				list0.add(tempMark1);
			}
			return list0; 
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		}
		finally {
			try {
				if (rsGetAllMark != null) {
					rsGetAllMark.close();
				} else {
					System.err.println ("RS set of table results was not created");
				}
			} catch (SQLException exc) {
					throw new DaoException ("Exception for DAO");
			}
		}
	}
		
	// Returns a list of Marks of one Student as per received primary 'key'
	@Override
	public List<Mark> getAllMarkOneStud (int key) throws DaoException {
		try {
			psGetAllMarkOneStud.setInt(1, key);		
			rsGetAllMarkOneStud = psGetAllMarkOneStud.executeQuery();
			List<Mark> list1 = new ArrayList<Mark>();
			while (rsGetAllMarkOneStud.next()) {
				Mark tempMark2 = new Mark();
				tempMark2.setId(rsGetAllMarkOneStud.getInt("ID"));
				tempMark2.setValue(rsGetAllMarkOneStud.getInt("VALUE"));
				tempMark2.setStudentId(rsGetAllMarkOneStud.getInt("STUDENT_ID"));
				tempMark2.setSubjectId(rsGetAllMarkOneStud.getInt("SUBJECT_ID"));
				list1.add(tempMark2);
			}
			return list1; 
		} catch (SQLException exc) {
			throw new DaoException ("Exception for DAO");
		}
		finally {
			try {
				if (rsGetAllMarkOneStud != null) {
					rsGetAllMarkOneStud.close();
				} else {
					System.err.println ("RS set of table results was not created");
				}
			} catch (SQLException exc) {
					throw new DaoException ("Exception for DAO");
			}
		}
	}
	
	// Terminates the connection and all 'PreparedStatement's
	public void close() throws DaoException {
		try {
			if (psCreateMark != null) {
				psCreateMark.close();
				} else {
					System.err.println ("PS statement was not created");
				}
			if (psReadMark != null) {
				psReadMark.close();
				} else {
					System.err.println ("PS statement was not created");
				}
			if (psUpdMark != null) {
				psUpdMark.close();
				} else {
					System.err.println ("PS statement was not created");
				}
			if (psDelMark != null) {
				psDelMark.close();
				} else {
					System.err.println ("PS statement was not created");
				}
			if (psGetAllMark != null) {
				psGetAllMark.close();
				} else {
					System.err.println ("PS statement was not created");
				}
			if (psGetAllMarkOneStud != null) {
				psGetAllMarkOneStud.close();
				} else {
					System.err.println ("PS statement was not created");
				}
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
