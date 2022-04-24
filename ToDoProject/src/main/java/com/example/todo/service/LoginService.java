package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.todo.entity.CustomUserDetails;
import com.example.todo.entity.User;
import com.example.todo.repo.UserRepository;

@Service
public class LoginService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
	}
	
	public void addUser(User user) {
		userRepo.save(user);
	}
	
	public User getUserByEmail(String username) {
		return userRepo.findByEmail(username);
	}

}
