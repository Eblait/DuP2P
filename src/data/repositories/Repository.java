package data.repositories;

public interface Repository <T> {
	
	void insert (T t);
	
	void remove (String t);
	
	boolean hasT (String t);
	
	T search (String t);
	
	void update (T t);
	
	int getIndex(String t);
}
