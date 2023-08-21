package com.mpv2.userMicroservice.Service;

import java.util.List;

import com.mpv2.userMicroservice.Entity.User;

public interface UserService {
	
	//user operations

    //create
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get single user of given userId

    User getUser(String userId);

   
}
