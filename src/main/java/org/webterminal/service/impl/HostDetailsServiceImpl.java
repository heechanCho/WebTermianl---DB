package org.webterminal.service.impl;

import org.springframework.stereotype.Service;
import org.webterminal.dto.HostDetailsDto;
import org.webterminal.entity.HostDetailsEntity;
import org.webterminal.repository.HostDetailsRepository;

@Service
public class HostDetailsServiceImpl {

    private final HostDetailsRepository hostDetailsRepository;


    public HostDetailsServiceImpl(HostDetailsRepository hostDetailsRepository) {
        this.hostDetailsRepository = hostDetailsRepository;
    }

    public HostDetailsEntity saveHostDetails(HostDetailsDto hostDetailsDto) {

        HostDetailsEntity entity = hostDetailsDto.toEntity();

        return hostDetailsRepository.save(entity);
    }
}
