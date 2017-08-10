package com.sap.pickme.daos;

import com.sap.pickme.models.Vote;

import java.util.Date;

public interface VoteDao {

    Vote getVoteByDate(Date date);

    Vote getVote(Vote vote);

    void vote(Vote vote);
}
