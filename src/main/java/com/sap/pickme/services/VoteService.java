package com.sap.pickme.services;

import com.sap.pickme.models.Restaurant;
import com.sap.pickme.models.User;
import com.sap.pickme.models.Vote;

import java.util.Date;

public interface VoteService {

    Vote getVoteByDate(Date date);

    int countNumberOfVotes(Restaurant restaurant);

    void vote(Vote vote);

    Restaurant getVotedRestaurant(User user);
}
