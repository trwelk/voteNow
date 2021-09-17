package com.vote.voting_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.vote.voting_system.Model.Citizen;
import com.vote.voting_system.Model.PoliticionsHasElection;
import com.vote.voting_system.Model.Vote;

public interface VoteService {
	
	public Vote save(Vote vote);
	int countByCitizen(int id);
	Optional<Vote> findByPoliticionsHasElection(PoliticionsHasElection election);
	public int countByVote(int id);
	public List<Vote> findByAll();
	public List<Vote> findByPoliticionsHasElection(List<PoliticionsHasElection> PoliticionsHasElection_list);
	int countByPoliticionHas(int id);
	public List<Vote> findByCitizen(Citizen citizen);
}
