package org.jjianga.voter.mapper.custom;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BestVoteInfoMapper {
    /**
     *
     * @param playerNo
     * @return
     */
    @Select(" SELECT count(distinct(device_no)) FROM vote_info WHERE ISNULL(data_status) AND player_no = #{playerNo} ")
    int getScore(@Param("playerNo") Integer playerNo);

    @Update("UPDATE vote_info SET data_status = 1")
    int maskingOldData();

    @Update("UPDATE vote_info SET data_status = 2")
    int deleteVoteInfo();
}
