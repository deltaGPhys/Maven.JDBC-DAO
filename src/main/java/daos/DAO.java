package daos;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    public T findById(int id) throws SQLException;
    public List<T> findAll() throws SQLException;
    public T update(T object);
    public T create(T object);
    public void delete(int id);
}
