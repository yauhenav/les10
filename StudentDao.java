package les10;

import java.util.*;
import java.sql.*;

public interface StudentDao {

    // Создает новую запись и соответствующий ей объект
	public void create(Student student) throws DaoException;

    // Возвращает объект соответствующий записи с первичным ключом key или null
	public Student read(int key) throws DaoException;

    //Сохраняет состояние объекта в базе данных
	public void update(Student student) throws DaoException;

    //Удаляет запись об объекте из базы данных
	public void delete(Student student) throws DaoException;

    //Возвращает список объектов соответствующих всем записям в базе данных
	public List<Student> getAll() throws DaoException;	
	
	//Закрывает соединение и все PreparedStatement's
	public void close() throws DaoException;
}