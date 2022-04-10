package dev.practice.order.domain.partner;

import dev.practice.order.common.util.TokenGenerator;
import dev.practice.order.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Slf4j
@Getter
@Entity
@Table(name = "partners")
public class Partner extends AbstractEntity {
    private static final String PREFIX_PARTNER_ENTITY = "ptn_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partnerToken;
    private String partnerName;
    private String businessNo;
    private String email;
    @Enumerated(EnumType.STRING)
    private Status status;


    @Getter
    @RequiredArgsConstructor
    public enum Status{
        ENABLE("활성화"), DISABLE("비활성화");
        private final String description;
    }

    public void enable(){
        this.status = Status.ENABLE;
    }
    public void disable(){
        this.status = Status.DISABLE;
    }

    @Builder
    public Partner(String partnerName, String businessNo, String email) {

        if (StringUtils.isEmpty(partnerName)) throw new RuntimeException("empty businessNo");
        if (StringUtils.isEmpty(businessNo)) throw new RuntimeException("empty partnerName");
        if (StringUtils.isEmpty(email)) throw new RuntimeException("empty email");

        this.partnerToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_PARTNER_ENTITY);
        this.partnerName = partnerName;
        this.businessNo = businessNo;
        this.email = email;
        this.status = Status.ENABLE;
    }
}
