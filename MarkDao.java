package les10;

import java.util.*;
import java.sql.*;

public interface MarkDao {

    // Creates a new DB entry as per corresponding received object
	public void create(Mark mark) throws DaoException;

    // Returns the object corresponding to the DB entry with received primary 'key'
	public Mark read(int key) throws DaoException;

    // Modifies the DB entry as per corresponding received object
	public void update(Mark mark) throws DaoException;

    // Removes the DB entry as per corresponding received object
	public void delete(int key) throws DaoException;

    // Returns a list of objects corresponding to all DB entries
	public List<Mark> getAll() throws DaoException;
	
	// Returns a list of Marks of one Student as per received primary 'key'
	public List<Mark> getAllMarkOneStud (int key) throws DaoException;
	
	// Terminates the connection and all 'PreparedStatement's
	public void close() throws DaoException;
}