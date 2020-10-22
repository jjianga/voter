package org.jjianga.voter.service.impl;

import org.jjianga.voter.connector.AthleteInfoConnector;
import org.jjianga.voter.entity.AthleteInfo;
import org.jjianga.voter.entity.AthleteInfoExample;
import org.jjianga.voter.mapper.AthleteInfoMapper;
import org.jjianga.voter.service.AthleteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthleteInfoServiceImpl implements AthleteInfoService {
    final
    AthleteInfoMapper athleteInfoMapper;

    public AthleteInfoServiceImpl(AthleteInfoMapper athleteInfoMapper) {
        this.athleteInfoMapper = athleteInfoMapper;
    }

    @Override
    public int editAthleteInfoS(List<AthleteInfo> athleteInfoS) {
        for (AthleteInfo  athleteInfo:athleteInfoS) {
            AthleteInfoExample athleteInfoExample = new AthleteInfoExample();
            athleteInfoExample.createCriteria().andRondaEqualTo(athleteInfo.getRonda()).andTeamEqualTo(athleteInfo.getTeam());
            this.athleteInfoMapper.updateByExample(athleteInfo, athleteInfoExample);
        }
        return 1;
    }

    @Override
    public int editAthleteInfo(AthleteInfo athleteInfo) {
        return this.athleteInfoMapper.updateByPrimaryKey(athleteInfo);
    }

    @Override
    public List<AthleteInfo> getAthleteInfo() {
        return this.athleteInfoMapper.selectByExample(null);
    }

    @Override
    public AthleteInfo getAthleteInfoByName(String playerName) {
        AthleteInfoExample athleteInfoExample = new AthleteInfoExample();
        athleteInfoExample.createCriteria().andNameEqualTo(playerName);
        List<AthleteInfo> as = this.athleteInfoMapper.selectByExample(athleteInfoExample);
        if(as.size() == 0)return null;
        return as.get(0);
    }

    @Override
    public int editAthleteValue(int id, int athleteValue) {
        return this.athleteInfoMapper.editAthleteValue(id, athleteValue);
    }

    @Override
    public int editAudienceValue(int id, int audienceValue) {
        return this.athleteInfoMapper.editAudienceValue(id, audienceValue);
    }
}
