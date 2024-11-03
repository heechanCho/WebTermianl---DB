package org.webterminal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.webterminal.entity.HostDetailsEntity;

public interface HostDetailsRepository extends JpaRepository<HostDetailsEntity, Long> {
}
