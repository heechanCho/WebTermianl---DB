package org.webterminal.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "host_details")
@Entity
public class HostDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String host;

    @Column(nullable = false)
    private Integer port;

    @Enumerated(EnumType.STRING)
    private ConnectionType connectionType;

    private Boolean usePty;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private AuditLogging auditLogging;

    private Integer maxIdleTime;

    private Integer fontSize;

    private Boolean visibleToAll;

    @CreatedDate
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime lastModifiedTime;

    @Builder
    public HostDetailsEntity(String description, String host, Integer port, ConnectionType connectionType, Boolean usePty, String username, String password, AuditLogging auditLogging, Integer maxIdleTime, Integer fontSize, Boolean visibleToAll) {
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


    //    필요시 추가할 메소드
    public void encodePassword(String encodedPassword) {
        this.password = encodedPassword;
    }

    //    연결 타입 Enum
    public enum ConnectionType {
        SSH, TELNET
    }


    //    감사 로깅 Enum
    public enum AuditLogging {
        ON, OFF
    }

}
