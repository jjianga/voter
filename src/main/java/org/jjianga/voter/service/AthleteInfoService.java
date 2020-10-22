package org.jjianga.voter.service;

import org.jjianga.voter.connector.AthleteInfoConnector;
import org.jjianga.voter.entity.AthleteInfo;

import java.util.List;

public interface AthleteInfoService {

    int editAthleteInfoS(List<AthleteInfo> athleteInfoS);

    int editAthleteInfo(AthleteInfo athleteInfo);

    List<AthleteInfo> getAthleteInfo();

    AthleteInfo getAthleteInfoByName(String playerName);

    int editAthleteValue(int id, int athleteValue);

    int editAudienceValue(int id, int audienceValue);
}
