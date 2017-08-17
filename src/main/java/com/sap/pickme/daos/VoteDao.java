package com.sap.pickme.daos;

import com.sap.pickme.models.Pool;
import com.sap.pickme.models.Restaurant;
import com.sap.pickme.models.User;
import com.sap.pickme.models.Vote;

import java.util.Date;
import java.util.List;

public interface VoteDao {

    Vote getVoteByDate(Date date);

    Restaurant getRestaurantByUserAndPool(User user, Pool pool);

    Vote getVote(Vote vote);

    List<Vote> getVoteByRestaurant(Restaurant restaurant);

    List<Vote> getVoteByRestaurantAndPool(Restaurant restaurant, Pool pool);

    void vote(Vote vote);

    void delete(List<Vote> votes);

    List<Vote> voteHistory();
}
