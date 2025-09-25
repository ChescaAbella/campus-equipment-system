package edu.cit.abella.franchesca.campusequipmentloan.Service;

import edu.cit.abella.franchesca.campusequipmentloan.Entity.userEntity;
import edu.cit.abella.franchesca.campusequipmentloan.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userService {

    private final userRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public userService(userRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public userEntity registerUser(String username, String password, String role) {
        if (userRepo.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        userEntity user = new userEntity();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // encrypt password
        user.setRole(role);

        return userRepo.save(user);
    }
}
