package dev.practice.order.domain.partner;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
public class PartnerInfo {
    private Long id;
    private String partnerToken;
    private String partnerName;
    private String businessNo;
    private String email;
    private Partner.Status status;

    @Builder
    public PartnerInfo(Partner partner) {
        this.id = partner.getId();
        this.partnerToken = partner.getPartnerToken();
        this.partnerName = partner.getPartnerName();
        this.businessNo = partner.getBusinessNo();
        this.email = partner.getEmail();
        this.status = partner.getStatus();
    }
}
