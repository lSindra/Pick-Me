package com.sap.pickme.services.impl;

import com.sap.pickme.daos.VoteDao;
import com.sap.pickme.models.Restaurant;
import com.sap.pickme.models.User;
import com.sap.pickme.models.Vote;
import com.sap.pickme.services.PoolService;
import com.sap.pickme.services.VoteService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

public class DefaultVoteService implements VoteService {

    @Resource
    private VoteDao voteDao;

    @Resource
    private PoolService poolService;

    @Transactional
    @Override
    public Vote getVoteByDate(Date date) {
        return voteDao.getVoteByDate(date);
    }

    @Transactional
    @Override
    public int countNumberOfVotes(Restaurant restaurant) {
        List<Vote> votes = voteDao.getVoteByRestaurantAndPool(restaurant, poolService.getActivePool());
        if(votes == null) return 0;
        return votes.size();
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

    @Transactional
    @Override
    public Restaurant getVotedRestaurant(User user) {
        return voteDao.getRestaurantByUserAndPool(user, poolService.getActivePool());
    }
}
