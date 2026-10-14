package com.ali.msusers.service;

import com.ali.msusers.dto.LoginResponseDto;
import com.ali.msusers.dto.UserLoginDto;
import com.ali.msusers.dto.UserRegistrationDto;
import com.ali.msusers.entity.User;
import com.ali.msusers.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RedisService redisService;

    public void registerUser( UserRegistrationDto user) {
        User userEntity = new User();
        var hashedPassword = Objects.hash(user.getPassword());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword((String.valueOf(hashedPassword)));
        userEntity.setEmail(user.getEmail());
        userRepository.save(userEntity);
        //1 UserStatus
        //2 Unique user check
        //3
    }

    public LoginResponseDto loginUser(UserLoginDto user) {
        //check user is active
        var userEntity = userRepository.findUserByUsername(user.getUsername());
        var hashedPassword = String.valueOf(Objects.hash(user.getPassword()));
        if (userEntity.getPassword().equals(hashedPassword)) {
            var token = "token-" + hashedPassword;
            redisService.setValue(token, userEntity.getUsername(), 10);
            return new LoginResponseDto(token);
        }
        throw new RuntimeException("Invalid username or password");
    }

    public void addOrder(String token) {
        var result = redisService.getValue(token);
        if (Objects.isNull(result)) {
            throw new RuntimeException("Login required");
        }
        System.out.println("Order accepted");
        // accept order

    }

}
