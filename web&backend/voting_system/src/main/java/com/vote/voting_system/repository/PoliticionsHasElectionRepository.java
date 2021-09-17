package com.vote.voting_system.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vote.voting_system.Model.District;
import com.vote.voting_system.Model.Politicion;
import com.vote.voting_system.Model.PoliticionsHasElection;

public interface PoliticionsHasElectionRepository extends JpaRepository<PoliticionsHasElection, Integer> {

	public List<PoliticionsHasElection> findByDistrict(District district);
	
//	@Query("SELECT a FROM Attendance a WHERE a.attendanceSheet IN (:attendanceSheet)")     // 2. Spring JPA In cause using @Quer
//	public List<Attendance> findByAttendanceSheet(@Param("attendanceSheet") List<AttendanceSheet> attendanceSheet);
	
	@Query("SELECT a FROM PoliticionsHasElection a WHERE a.politicion IN (:politions)")   // 2. Spring JPA In cause using @Quer
	public List<PoliticionsHasElection> findByPoliticion(@Param("politions") List<Politicion> politions_list);

	Optional<PoliticionsHasElection> findByPoliticionId(int id);
	
}