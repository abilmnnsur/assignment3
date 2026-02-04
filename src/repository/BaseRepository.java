package repository;

import java.util.List;

public abstract class BaseRepository<T> {

    public abstract T create(T entity);

    public abstract T findById(int id);

    public abstract List<T> findAll();

    public abstract void update(T entity);

    public abstract void delete(int id);
}