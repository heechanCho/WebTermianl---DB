///* part of WebTerminal project
//
//   Copyright (C) 2022  ZP Gu. All rights reserved.
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <https://www.gnu.org/licenses/>.
// */

package org.webterminal.user.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.webterminal.entity.Role;
import org.webterminal.entity.UserEntity;
import org.webterminal.entity.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Slf4j
@Component
public class CreateDefaultUser {


    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CreateDefaultUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

        log.debug("*** 기본 유저 생성 : createDefaultUser ***");
    }

    public void createUserIfNotExists(String username, String password, Role role) {

        if (!userRepository.existsByUsername(username)) {
            log.debug("*** {} 유저 생성 중 ***", username);
            userRepository.save(UserEntity.builder()
                    .username(username)
                    .password(passwordEncoder.encode(password))
                    .roles(role)
                    .build());
        } else {
            log.debug("*** {} 유저는 이미 존재함 ***", username);
        }
    }

    @PostConstruct
    private void createDefaultUser() {
        createUserIfNotExists("admin", "adminpass", Role.ADMIN);
        createUserIfNotExists("user", "userpass", Role.USER);
    }
}
