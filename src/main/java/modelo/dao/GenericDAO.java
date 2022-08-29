package modelo.dao;

public interface GenericDAO<T, ID> {
	public void create(T instancia);
	public T getById(ID id);
	public void update(T instancia);
	public void delete (T instancia);
	public void deleteById(ID id);
}
