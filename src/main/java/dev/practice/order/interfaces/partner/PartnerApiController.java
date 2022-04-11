package dev.practice.order.interfaces.partner;

import dev.practice.order.common.response.CommonResponse;
import dev.practice.order.domain.partner.Partner;
import dev.practice.order.domain.partner.PartnerCommand;
import dev.practice.order.domain.partner.PartnerInfo;
import dev.practice.order.partner.PartnerFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
public class PartnerApiController {

    private  final PartnerFacade partnerFacade;

    @PostMapping
    public CommonResponse registerPartner(PartnerDto.ResgisterRequest request){
        //1. 외부에서 전달된 파라미터 (dto) -> Command, Criteria convert
        //2. facade 호출 .. partnerInfo
        //3. PartnerInfo -> CommonResponse convert and return
        PartnerCommand partnerCommand = request.toCommand();

        PartnerInfo partnerInfo = partnerFacade.regeisterPartner(partnerCommand);
        PartnerDto.RegisterResponse response = new PartnerDto.RegisterResponse(partnerInfo);

        return CommonResponse.success(response);

    }
}
