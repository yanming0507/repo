package com.gupao.pattern.delegate;

/**
 * Created by Yan on 2019/3/14.
 * 老板（战争中一方的司令部）下发任务，指定项目经理（第一战场的指挥者）
 */
public class Boss {
    private TeamLeader leader;
    public Boss(TeamLeader teamLeader) {
        this.leader=teamLeader;
    }
    public  void work(String command){
        leader.doSomeThing(command);
    }
}
