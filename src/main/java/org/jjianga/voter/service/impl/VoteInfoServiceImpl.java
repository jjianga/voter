package org.jjianga.voter.service.impl;

import org.jjianga.voter.entity.VoteInfo;
import org.jjianga.voter.mapper.VoteInfoMapper;
import org.jjianga.voter.service.VoteInfoService;
import org.springframework.stereotype.Service;

@Service
public class VoteInfoServiceImpl implements VoteInfoService {
    final
    VoteInfoMapper voteInfoMapper;

    public VoteInfoServiceImpl(VoteInfoMapper voteInfoMapper) {
        this.voteInfoMapper = voteInfoMapper;
    }

    @Override
    public int uploadingVoteInfo(VoteInfo voteInfo) {
        return voteInfoMapper.insert(voteInfo);
    }

    @Override
    public int addVoteInfo(VoteInfo voteInfo) {
        return voteInfoMapper.insert(voteInfo);
    }

    @Override
    public int getScore(Integer playerNo) {
        return voteInfoMapper.getScore(playerNo);
    }

    @Override
    public int maskingOldData() {
        return voteInfoMapper.maskingOldData();
    }

    @Override
    public int deleteVoteInfo() {
        return voteInfoMapper.deleteVoteInfo();
    }

    @Override
    public int deleteVoterInfo() {
        return voteInfoMapper.deleteByExample(null);
    }

}
