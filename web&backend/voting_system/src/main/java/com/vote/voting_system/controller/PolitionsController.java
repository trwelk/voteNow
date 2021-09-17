package com.vote.voting_system.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vote.voting_system.Model.Politicion;
import com.vote.voting_system.Model.PoliticionsHasElection;
import com.vote.voting_system.Model.Team;
import com.vote.voting_system.repository.PoliticionsHasElectionRepository;
import com.vote.voting_system.service.PoliticionService;

@RequestMapping("/vote/api/v1/politcion")
@RestController
public class PolitionsController {

	@Autowired
	PoliticionService politicionService_01;
	
	@Autowired
	PoliticionsHasElectionRepository politicionsHasElectionRepository;
	
//	@RequestMapping(value = "/getpoliList",method = RequestMethod.POST)
//	public String GetListByTeamId(@RequestParam ("team_id") int team_id) {
//		List<Politicion> getAll;
//		JSONArray array=new JSONArray();
//		System.err.println("Team Id------->> "+team_id);
//		try {
//			Team team=new Team();
//			team.setId(team_id);
//			getAll=politicionService_01.findByTeam(team);
//			if(!getAll.isEmpty()) {
//				for(Politicion p : getAll) {
//					JSONObject obj=new JSONObject();
//					obj.put("id", p.getPerson().getId());
//					obj.put("name", p.getPerson().getFname());
//					obj.put("reff_code", p.getReffCode());
//					obj.put("mobile", p.getPerson().getMobile1());
//					obj.put("team_name", p.getTeam().getName());
////					obj.put("team_name", p.getPoliticionsHasElections());
//				array.put(obj);
//				}
//			}else {
//				System.out.println("Null");
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		System.err.println(array.toString());
//		return array.toString();
//	}
	
	
	@RequestMapping(value = "/getpoliList",method = RequestMethod.POST)
	public String GetListByTeamId(@RequestParam ("team_id") int team_id) {
		List<Politicion> getAll;
		List<PoliticionsHasElection> getAllPolition;
		JSONArray array=new JSONArray();
		System.err.println("Team Id------->> "+team_id);
		try {
			Team team=new Team();
			team.setId(team_id);
			getAll=politicionService_01.findByTeam(team);
			if(!getAll.isEmpty()) {
				
				getAllPolition=politicionsHasElectionRepository.findByPoliticion(getAll);
				if(!getAllPolition.isEmpty()) {
					for(PoliticionsHasElection p: getAllPolition){
						JSONObject obj=new JSONObject();
						obj.put("poli_has_elc_id", p.getId());
						obj.put("poli_id", p.getPoliticion().getId());
						obj.put("person_id", p.getPoliticion().getPerson().getId());
						obj.put("person_name", p.getPoliticion().getPerson().getFname());
						obj.put("person_mobile", p.getPoliticion().getPerson().getMobile1());
						obj.put("poli_number", p.getNumberEle());
						array.put(obj);
					}
				}
				
//				for(Politicion p : getAll) {
//					JSONObject obj=new JSONObject();
//					obj.put("id", p.getPerson().getId());
//					obj.put("name", p.getPerson().getFname());
//					obj.put("reff_code", p.getReffCode());
//					obj.put("mobile", p.getPerson().getMobile1());
//					obj.put("team_name", p.getTeam().getName());
////					obj.put("team_name", p.getPoliticionsHasElections());
//				array.put(obj);
//				}
			}else {
				System.out.println("Null");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.err.println(array.toString());
		return array.toString();
	}
	
//	@RequestMapping(value = "/getpoliList",method = RequestMethod.POST)
//	public String GetListByTeamId(@RequestBody String team_id) {
//		List<Politicion> getAll;
//		JSONObject obj_2=new JSONObject(team_id);
//		JSONArray array=new JSONArray();
//		System.err.println("Team Id------->> "+team_id);
//		try {
//			Team team=new Team();
//			team.setId(obj_2.getInt("team_id"));
//			getAll=politicionService_01.findByTeam(team);
//			if(!getAll.isEmpty()) {
//				for(Politicion p : getAll) {
//					JSONObject obj=new JSONObject();
//					obj.put("id", p.getPerson().getId());
//					obj.put("name", p.getPerson().getFname());
//					obj.put("reff_code", p.getReffCode());
//					obj.put("mobile", p.getPerson().getMobile1());
//					obj.put("team name", p.getTeam().getName());
//				array.put(obj);
//				}
//			}else {
//				System.out.println("Null");
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		System.err.println(array.toString());
//		return array.toString();
//	}
	
}
