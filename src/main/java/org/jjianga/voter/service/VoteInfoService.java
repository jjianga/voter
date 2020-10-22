package org.jjianga.voter.service;

import org.jjianga.voter.entity.VoteInfo;

public interface VoteInfoService {
    /**
     *  上传得分信息
     * @param voteInfo
     * @return
     */
    int uploadingVoteInfo(VoteInfo voteInfo);

    int addVoteInfo(VoteInfo voteInfo);

    // 获取特定选手得分
    int getScore(Integer playerNo);
    // 屏蔽旧数据
    int maskingOldData();
    // 逻辑删除错误数据
    int deleteVoteInfo();
}
