package com.sap.pickme.services;

import com.sap.pickme.models.Vote;

import java.util.Date;

public interface VoteService {

    Vote getVoteByDate(Date date);

    void vote(Vote vote);

}
