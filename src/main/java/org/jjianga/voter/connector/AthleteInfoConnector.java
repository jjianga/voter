package org.jjianga.voter.connector;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.jjianga.voter.entity.AthleteInfo;
import org.jjianga.voter.service.AthleteInfoService;
import org.jjianga.voter.service.VoteInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "选手投票信息")
@RestController
@RequestMapping("AthleteInfoConnector")
public class AthleteInfoConnector {
    final
    VoteInfoService voteInfoService;
    final
    AthleteInfoService athleteInfoService;

    public AthleteInfoConnector(VoteInfoService voteInfoService,AthleteInfoService athleteInfoService) {
        this.voteInfoService = voteInfoService;
        this.athleteInfoService = athleteInfoService;
    }

    @PostMapping(value = "editAthleteInfoS")
    @ApiOperation(value="批量修改", notes="批量修改")
    public int editAthleteInfoS(@RequestBody List<AthleteInfo> athleteInfoS){
        //重置投票数据
        voteInfoService.maskingOldData();
        return athleteInfoService.editAthleteInfoS(athleteInfoS);
    }

    @PostMapping(value = "editAthleteInfo")
    @ApiOperation(value="修改单条数据", notes="修改单条数据")
    public int editAthleteInfo(AthleteInfo athleteInfo){
        return athleteInfoService.editAthleteInfo(athleteInfo);
    }

    @PostMapping(value = "getAthleteInfo")
    @ApiOperation(value="获取选手信息", notes="获取选手信息")
    public List<AthleteInfo> getAthleteInfo() {
        return athleteInfoService.getAthleteInfo();
    }

    @PostMapping(value = "editAthleteValue")
    @ApiOperation(value="修改选手自觉估分", notes="修改选手自觉估分")
    public int editAthleteValue(int id, int athleteValue){
        return athleteInfoService.editAthleteValue(id, athleteValue);
    }

    @PostMapping(value = "editAudienceValue")
    @ApiOperation(value="修改选手票数", notes="修改选手票数")
    public int editAudienceValue(int id, int audienceValue){
        return athleteInfoService.editAudienceValue(id, audienceValue);
    }
}
