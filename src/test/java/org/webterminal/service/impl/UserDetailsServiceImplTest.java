package org.webterminal.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.webterminal.entity.Role;
import org.webterminal.entity.UserEntity;
import org.webterminal.entity.UserRepository;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class UserDetailsServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testLoadUserByUsername_Success() {

        String username = "testUser";
        String password = "testpass";
        Role role = Role.USER;

        UserEntity user = UserEntity.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles(role)
                .build();

        userRepository.save(user);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        assertNotNull(userDetails, "UserDetails 객체가 null이 아닙니다.");
        assertEquals(username, userDetails.getUsername(), "사용자 명이 일치해야합니다.");
        assertTrue(passwordEncoder.matches(password, userDetails.getPassword()), "비밀번호가 일치해야합니다.");
        assertTrue(userDetails.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_USER")), "권한이 ROLE_USER 이어야 합니다.");
    }

    @Test
    public void testLoadUserByUsername_UserNotFound() {

        String username = "nonexistent";

        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername(username);
        }, "UsernameNotFoundException이 발생해야 합니다.");
    }

}