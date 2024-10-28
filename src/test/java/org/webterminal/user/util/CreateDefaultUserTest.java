package org.webterminal.user.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.webterminal.entity.Role;
import org.webterminal.entity.UserEntity;
import org.webterminal.entity.UserRepository;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class CreateDefaultUserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CreateDefaultUser createDefaultUser;

    @Test
    public void setUp() {
        createDefaultUser.createUserIfNotExists("admin", "adminpass", Role.ADMIN);
        createDefaultUser.createUserIfNotExists("user", "userpass", Role.USER);
    }

    @Test
    public void testAdminUserCreation() {

        var adminUser = userRepository.findByUsername("admin").orElse(null);
        assertNotNull(adminUser, "관리자 유저가 존재합니다.");
        assertEquals(Role.ADMIN, adminUser.getRoles(), "관리자의 역활은 ADMIN이여야 합니다.");
        assertTrue(passwordEncoder.matches("adminpass", adminUser.getPassword()), "비밀번호가 올바르게 인코딩 되어야합니다.");
    }

    @Test
    public void testRegularUserCreation() {

        var regularUser = userRepository.findByUsername("user").orElse(null);
        assertNotNull(regularUser, "레귤러 유저가 존재합니다.");
        assertEquals(Role.USER, regularUser.getRoles(), "레귤러 유저의 역활은 USER이여야 합니다.");
        assertTrue(passwordEncoder.matches("userpass", regularUser.getPassword()), "비밀번호가 올바르게 인코딩 되어야합니다.");

    }

    @Test
    public void deleteAll() {
        userRepository.deleteAll();
    }

}