package com.sap.pickme.services.impl;

import com.sap.pickme.daos.VoteDao;
import com.sap.pickme.models.Vote;
import com.sap.pickme.services.VoteService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

public class DefaultVoteService implements VoteService {

    @Resource
    private VoteDao voteDao;

    @Transactional
    @Override
    public Vote getVoteByDate(Date date) {
        return voteDao.getVoteByDate(date);
    }

    @Transactional
    @Override
    public void vote(Vote vote) {
        if (voteDao.getVote(vote) != null) {
            Vote currentVote = voteDao.getVote(vote);
            currentVote.setRestaurant(vote.getRestaurant());
            voteDao.vote(currentVote);
        } else {
            voteDao.vote(vote);
        }
    }
}
