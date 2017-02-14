package les10;

import java.util.*;
import java.sql.*;

public interface SubjectDao {

    // Создает новую запись и соответствующий ей объект
	public void create(Subject subject) throws DaoException;

    // Возвращает объект соответствующий записи с первичным ключом key или null
	public Subject read(int key) throws DaoException;

    //Сохраняет состояние объекта group в базе данных
	public void update(Subject subject) throws DaoException;

    //Удаляет запись об объекте из базы данных
	public void delete(Subject subject)  throws DaoException;

    //Возвращает список объектов соответствующих всем записям в базе данных
	public List<Subject> getAll() throws DaoException;
	
	//Закрывает соединение и все PreparedStatement's
	public void close() throws DaoException;
}