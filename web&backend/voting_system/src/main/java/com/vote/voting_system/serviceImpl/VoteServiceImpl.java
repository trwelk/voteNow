package com.vote.voting_system.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.voting_system.Model.Citizen;
import com.vote.voting_system.Model.PoliticionsHasElection;
import com.vote.voting_system.Model.Vote;
import com.vote.voting_system.repository.VoteRepository;
import com.vote.voting_system.service.VoteService;

@Service("voteService_01")
public class VoteServiceImpl implements VoteService {

	@Autowired
	VoteRepository voteRepository;
	
	@Override
	public Vote save(Vote vote) {
		// TODO Auto-generated method stub
		return voteRepository.save(vote);
	}

	@Override
	public int countByCitizen(int id) {
		// TODO Auto-generated method stub
		return voteRepository.countByCitizenId(id);
	}

	@Override
	public Optional<Vote> findByPoliticionsHasElection(PoliticionsHasElection election) {
		// TODO Auto-generated method stub
		return voteRepository.findByPoliticionsHasElection(election);
	}

	@Override
	public int countByVote(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Vote> findByAll() {
		// TODO Auto-generated method stub
		return voteRepository.findAll();
	}

	@Override
	public List<Vote> findByPoliticionsHasElection(List<PoliticionsHasElection> PoliticionsHasElection_list) {
		// TODO Auto-generated method stub
		return voteRepository.findByPoliticionsHasElection(PoliticionsHasElection_list);
	}

	@Override
	public int countByPoliticionHas(int id) {
		// TODO Auto-generated method stub
		return voteRepository.countByPoliticionsHasElectionId(id);
	}

	@Override
	public List<Vote> findByCitizen(Citizen citizen) {
		// TODO Auto-generated method stub
		return voteRepository.findByCitizen(citizen);
	}

}
