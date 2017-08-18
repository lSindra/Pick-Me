package com.sap.pickme.services;

import com.sap.pickme.models.Restaurant;
import com.sap.pickme.models.User;
import com.sap.pickme.models.Vote;

import java.util.Date;
import java.util.List;

public interface VoteService {

    Vote getVoteByDate(Date date);

    int countNumberOfVotes(Restaurant restaurant);

    List<User> getUserListByRestaurantVote(int restaurantId);

    void vote(Vote vote);

    Restaurant getVotedRestaurant(User user);

    List<Vote> voteHistory();
}
