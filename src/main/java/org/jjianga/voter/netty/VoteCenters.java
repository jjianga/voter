package org.jjianga.voter.netty;

import org.jjianga.voter.entity.AthleteInfo;
import org.jjianga.voter.service.send.SendStartVote;
import org.jjianga.voter.service.send.SendStopVote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VoteCenters {
    private static final Logger logger = LoggerFactory.getLogger(VoteCenters.class);
    /**
     * 错误代码收集
     */
    public static int errState;
    public static String stateMessage;

    /**
     * 当前投票的选手
     */
    public static AthleteInfo athleteInfo;
    /**
     *  当前投票的状态
     *   0. 默认状态  1.预备投票状态  2.投票设备已经在接收投票信息了  3. 预备结束投票状态  4.投票设备已经收到停止收取投票信息
     */
    public static int state;

    /**
     * 预备投票状态
     */
    public static  final int DEFAULT_START = 0;
    /**
     * 预备投票状态
     */
    public static  final int VOTE_READY_START = 1;
    /**
     * 投票设备已经在接收投票信息了
     */
    public static  final int VOTE_START = 2;

    /**
     * 预备结束投票状态
     */
    public static  final int VOTE_READY_END = 3;
    /**
     * 设备已经结束投票了
     */
    public static  final int VOTE_END = 4;

    public static void startVote(){
        VoteCenters.errState = 0;
        if(VoteCenters.state != VoteCenters.DEFAULT_START){
            VoteCenters.errState = -1;
            logger.error("不是默认状态就开始准备投票了:{}", VoteCenters.state);
        }
        SendStartVote sendMessage = new SendStartVote();
        sendMessage.setPlayerNo(VoteCenters.athleteInfo.getId()+"");
        SocketGroup.sendMessage(sendMessage);
        VoteCenters.state = VoteCenters.VOTE_READY_START;
        VoteCenters.stateMessage = "通知设备发起投票！";
    }

    public static void endVote(){
        VoteCenters.errState = 0;
        if(VoteCenters.state != VoteCenters.VOTE_START){
            VoteCenters.errState = -1;
            logger.error("不是投票状态申请停止投票:{}", VoteCenters.state);
        }
        SendStopVote sendMessage = new SendStopVote();
        sendMessage.setPlayerNo(VoteCenters.athleteInfo.getId()+"");
        SocketGroup.sendMessage(sendMessage);
        VoteCenters.state = VoteCenters.VOTE_READY_END;
        VoteCenters.stateMessage = "通知设备结束投票！";
    }

}
