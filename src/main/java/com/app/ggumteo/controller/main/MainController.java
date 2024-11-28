package com.app.ggumteo.controller.main;

import com.app.ggumteo.domain.audition.AuditionDTO;
import com.app.ggumteo.domain.funding.FundingDTO;
import com.app.ggumteo.domain.work.WorkDTO;
import com.app.ggumteo.service.audition.AuditionService;
import com.app.ggumteo.service.funding.FundingService;
import com.app.ggumteo.service.work.WorkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final WorkService workService;
    private final AuditionService auditionService;
    private final FundingService fundingService;

    @GetMapping("/text/main")
    public String goToTextMainPage(Model model) {
        WorkDTO mostReadTextWork = workService.getMostReadTextWorkForMainPage();
        model.addAttribute("mostReadTextWork", mostReadTextWork);

        List<AuditionDTO> latestTextAuditions = auditionService.getLatestTextAuditionsForMainPage();
        model.addAttribute("latestTextAuditions", latestTextAuditions);

        List<FundingDTO> topTextFunding = fundingService.getTopTextFundingForMainPage();
        model.addAttribute("topTextFunding", topTextFunding);

        return "text/main";
    }

    @GetMapping("/video/main")
    public String goToVideoMainPage(Model model) {

        // 조회수가 가장 높은 비디오 작품 가져오기
        WorkDTO mostReadVideoWork = workService.getMostReadVideoWorkForMainPage();
        model.addAttribute("mostReadVideoWork", mostReadVideoWork);

        // 최신 비디오 오디션 3개 가져오기
        List<AuditionDTO> latestVideoAuditions = auditionService.getLatestVideoAuditionsForMainPage();
        model.addAttribute("latestVideoAuditions", latestVideoAuditions);

        // 컨버지 가격이 높은 비디오 펀딩 3개 가져오기
        List<FundingDTO> topVideoFunding = fundingService.getTopVideoFundingForMainPage();
        model.addAttribute("topVideoFunding", topVideoFunding);

        return "video/main"; // 메인 페이지 뷰 이름
    }


    @GetMapping("/display")
    @ResponseBody
    public byte[] display(@RequestParam("fileName") String fileName) throws IOException {
        File file = new File("/home/ubuntu/upload", fileName);

        if (!file.exists()) {
            throw new FileNotFoundException("파일을 찾을 수 없습니다: " + fileName);
        }

        return FileCopyUtils.copyToByteArray(file);
    }

}
