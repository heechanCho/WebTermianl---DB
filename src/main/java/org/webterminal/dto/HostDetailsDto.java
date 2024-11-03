package org.webterminal.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.webterminal.entity.HostDetailsEntity;

@Getter
@NoArgsConstructor
public class HostDetailsDto {

    private String description;

    @NotBlank(message = "Host는 필수 항목입니다.")
    private String host;

    @Min(value = 1, message = "Port는 1 이상의 값이여야 합니다.")
    @Max(value = 65535, message = "Port는 65535 이하의 값이여야 합니다.")
    private Integer port;

    @NotNull(message = "ConnectionType는 필수 항목입니다.")
    private HostDetailsEntity.ConnectionType connectionType;

    private Boolean usePty;

    //    hostname
    @NotBlank(message = "username은 필수 항목입니다.")
    private String username;

    //    hostpassword
    // Password는 민감 정보로, 클라이언트로부터 받아와야 하는 경우만 포함
    //    @Size(min = 8, message = "Password는 최소 8자 이상이어야 합니다.")
    private String password;

    private HostDetailsEntity.AuditLogging auditLogging;

    @PositiveOrZero(message = "Max Idle Time은 0이상이야 합니다.")
    private Integer maxIdleTime;


    //    @Min(value = 10, message = "Font Size는 최소 10이어야 합니다.")
    //    @Max(value = 30, message = "Font Size는 최대 30이어야 합니다.")
    private Integer fontSize;

    private Boolean visibleToAll;

    @Builder
    public HostDetailsDto(String description, String host, Integer port, HostDetailsEntity.ConnectionType connectionType, Boolean usePty, String username, String password, HostDetailsEntity.AuditLogging auditLogging, Integer maxIdleTime, Integer fontSize, Boolean visibleToAll) {
        this.description = description;
        this.host = host;
        this.port = port;
        this.connectionType = connectionType;
        this.usePty = usePty;
        this.username = username;
        this.password = password;
        this.auditLogging = auditLogging;
        this.maxIdleTime = maxIdleTime;
        this.fontSize = fontSize;
        this.visibleToAll = visibleToAll;
    }

    public HostDetailsEntity toEntity() {
        return HostDetailsEntity.builder()
                .description(this.description)
                .host(this.host)
                .port(this.port)
                .connectionType(this.connectionType)
                .usePty(this.usePty)
                .username(this.username)
                .password(this.password)
                .auditLogging(this.auditLogging)
                .maxIdleTime(this.maxIdleTime)
                .fontSize(this.fontSize)
                .visibleToAll(this.visibleToAll)
                .build();

    }


}
