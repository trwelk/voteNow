package com.vote.voting_system.service;

import java.util.List;
import java.util.Optional;

import com.vote.voting_system.Model.Politicion;
import com.vote.voting_system.Model.Team;

public interface PoliticionService {
	
	public Politicion save(Politicion politicion);
	public Politicion delete(Politicion politicion);
	public List<Politicion> findAll();
	public List<Politicion> findByTeam(Team team);
	public Optional<Politicion> findById(int person_id);
}
