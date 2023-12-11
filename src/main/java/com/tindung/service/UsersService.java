package com.tindung.service;

import java.util.List;

import com.tindung.service.*;
import com.tindung.repository.*;
import com.tindung.model.*;

public interface UsersService {
	List<User> findAll();

	List<User> findAllVer2();

	List<User> findLikeName(String name);

	User findById(Integer UserID);

	User create(User u);

	User update(User u);

	void delete(Integer UserID);

}
