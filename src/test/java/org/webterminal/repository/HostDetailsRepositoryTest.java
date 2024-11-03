package org.webterminal.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.webterminal.entity.HostDetailsEntity;

import javax.transaction.Transactional;

@Slf4j
@SpringBootTest
public class HostDetailsRepositoryTest {

    @Autowired
    HostDetailsRepository hostDetailsRepository;


    @Test
    public void HostDetailsEntity_저장_확인() {

        HostDetailsEntity hostDetails = HostDetailsEntity.builder()
                .description("Test Description")
                .host("127.0.0.1")
                .port(22)
                .connectionType(HostDetailsEntity.ConnectionType.SSH)
                .usePty(true)
                .username("testuser")
                .password("testpassword")
                .auditLogging(HostDetailsEntity.AuditLogging.OFF)
                .maxIdleTime(30)
                .fontSize(12)
                .visibleToAll(false)
                .build();

        hostDetailsRepository.save(hostDetails);

//        검증 코드 작성



    }

    @Test
    public void cleanUp() {
        hostDetailsRepository.deleteAll();
        log.debug("deleteAll hostDetailsRepository data");
    }

}