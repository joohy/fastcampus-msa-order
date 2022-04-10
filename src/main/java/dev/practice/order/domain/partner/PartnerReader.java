package dev.practice.order.domain.partner;

public interface PartnerReader {
    Partner getPartner(Long partnerId);
    Partner getPartner(String partnerToken);

    Partner enablePartner(String partnerToken);

    Partner disablePartner(String partnerToken);
}
