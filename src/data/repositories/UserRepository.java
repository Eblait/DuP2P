package data.repositories;

import java.util.ArrayList;

import data.entity.User;

public class UserRepository implements Repository<User> {
	
	private ArrayList<User> users;
	
	public UserRepository () {
		this.users = new ArrayList<User>();
	}
	
	@Override
	public void insert(User user) {
		this.users.add(user);
	}

	@Override
	public void remove(String nickname) {
		int index = getIndex(nickname);
		this.users.remove(index);
	}

	@Override
	public boolean hasT(String nickname) {
		String aux;
		
		for (int i = 0; i < users.size(); i++) {
			aux = users.get(i).getNickname();
			if (aux.equals(nickname)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public User search(String nickname) {
		int index = getIndex(nickname);
		return this.users.get(index);
	}

	@Override
	public void update(User user) {
		int index = getIndex(user.getNickname());
		this.users.set(index, user);
	}

	@Override
	public int getIndex(String nickname) {
		String aux;
		int index = 0;
		
		for (int i = 0; i < users.size(); i++) {
			aux = users.get(i).getNickname();
			if (aux.equals(nickname)) {
				index = i;
				break;
			}
		}
		
		return index;
	}

}
