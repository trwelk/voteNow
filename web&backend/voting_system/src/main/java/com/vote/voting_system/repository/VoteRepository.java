package com.vote.voting_system.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vote.voting_system.Model.Citizen;
import com.vote.voting_system.Model.Politicion;
import com.vote.voting_system.Model.PoliticionsHasElection;
import com.vote.voting_system.Model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

	public int countByCitizenId(int Citizen_id);
	public Optional<Vote> findByPoliticionsHasElection(PoliticionsHasElection election);
//	@Query("SELECT a FROM Attendance a WHERE a.attendanceSheet IN (:attendanceSheet)")     // 2. Spring JPA In cause using @Quer
//	public List<Attendance> findByAttendanceSheet(@Param("attendanceSheet") List<AttendanceSheet> attendanceSheet);
	@Query("SELECT a FROM Vote a WHERE a.politicionsHasElection IN (:politicionsHasElection_01)")   // 2. Spring JPA In cause using @Quer
	public List<Vote> findByPoliticionsHasElection(@Param("politicionsHasElection_01") List<PoliticionsHasElection> PoliticionsHasElection_list);
	public int countByPoliticionsHasElectionId(int id);
	public List<Vote> findByCitizen(Citizen citizen);
	
}
