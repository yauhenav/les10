package les10;

import java.util.*;
import java.sql.*;

public interface StudentDao {

    // ������� ����� ������ � ��������������� �� ������
	public void create(Student student) throws DaoException;

    // ���������� ������ ��������������� ������ � ��������� ������ key ��� null
	public Student read(int key) throws DaoException;

    //��������� ��������� ������� � ���� ������
	public void update(Student student) throws DaoException;

    //������� ������ �� ������� �� ���� ������
	public void delete(Student student) throws DaoException;

    //���������� ������ �������� ��������������� ���� ������� � ���� ������
	public List<Student> getAll() throws DaoException;	
	
	//��������� ���������� � ��� PreparedStatement's
	public void close() throws DaoException;
}