package les10;

import java.sql.*;
import java.util.*;
import java.io.*;

public interface DaoFactory {

    // Возвращает подключение к базе данных
    public Connection getConnect() throws SQLException, IOException, FileNotFoundException;

    // Возвращает объект для управления персистентным состоянием объекта Student
    public StudentDao getStudentDao(Connection connection) throws DaoException;

    // Возвращает объект для управления персистентным состоянием объекта Subject
    public SubjectDao getSubjectDao(Connection connection) throws DaoException;
	
	// Возвращает объект для управления персистентным состоянием объекта Mark
	public MarkDao getMarkDao (Connection connection) throws DaoException;
}