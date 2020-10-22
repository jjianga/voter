package org.jjianga.voter.mapper.custom;

import org.apache.ibatis.annotations.Update;

public interface BestAthleteInfoMapper {
    /**
     *  修改选手分数
     * @param id  选手ID
     * @param athleteValue 选手自觉估分
     * @return
     */
    @Update("UPDATE athlete_info AS a1 SET athlete_value = #{athleteValue} " +
            ",score = ABS(audience_value - #{athleteValue}) WHERE ID = #{id};")
    int editAthleteValue(int id, int athleteValue);

    /**
     * 修改选手票数
     * @param id    选手ID
     * @param audienceValue 选手票数
     * @return
     */
    @Update("UPDATE athlete_info AS a1 SET audience_value = #{audienceValue} " +
            ",score = ABS(#{audienceValue} - athlete_value) WHERE ID = #{id};")
    int editAudienceValue(int id, int audienceValue);
}
