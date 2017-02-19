package les10;

import java.sql.*;
import java.util.*;
import java.io.*;

public interface DaoFactory {

    // Returns connection to the Data Base
    public Connection getConnect() throws SQLException, IOException, FileNotFoundException;

    // Returns an object to manage persistent 'Student' object
    public StudentDao getStudentDao(Connection connection) throws DaoException;

    // Returns an object to manage persistent 'Subject' object
    public SubjectDao getSubjectDao(Connection connection) throws DaoException;
	
	// Returns an object to manage persistent 'Mark' object
	public MarkDao getMarkDao (Connection connection) throws DaoException;
}
