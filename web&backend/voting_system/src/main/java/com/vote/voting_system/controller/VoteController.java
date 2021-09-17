package com.vote.voting_system.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vote.voting_system.Model.Citizen;
import com.vote.voting_system.Model.PoliticionsHasElection;
import com.vote.voting_system.Model.Vote;
import com.vote.voting_system.service.VoteService;
import com.vote.voting_system.utill.AppDateTimeUtill;

@RequestMapping("vote/api/v1/vote")
@RestController
public class VoteController {
	
	@Autowired
	VoteService voteService_01;
	
//	@RequestMapping(value = "/",method = RequestMethod.POST)
//	public String save(@RequestBody String str) {
//		JSONObject jsonResponse=new JSONObject();
//		JSONObject jsonObject=new JSONObject(str);
//		try {
//			
//			int count_vote=voteService_01.countByCitizen(jsonObject.getInt("citizen_id"));
//			System.err.println(count_vote);
//			if(count_vote == 3 || count_vote > 3) {
//				System.out.println("You can not Vote now , You have used your vote 3 times alredy....");
//				jsonResponse.put("id", 00);
//				jsonResponse.put("status", "2"); //fail
//			}else {
////				System.out.println("SVEDDDD");
//				Vote vote=new Vote();
//				Citizen citizen=new Citizen();
//				citizen.setId(jsonObject.getInt("citizen_id"));
//				vote.setCitizen(citizen);
//				PoliticionsHasElection ss=new PoliticionsHasElection();
//				ss.setId(jsonObject.getInt("p_has_ele_id"));
//				vote.setPoliticionsHasElection(ss);
//				vote.setRegtime(AppDateTimeUtill.getCurrentDateTime());
//				vote.setCitizen(citizen);
//				vote=voteService_01.save(vote);
//				
////				jsonResponse.put("id", vote.getId());
//				jsonResponse.put("status", "1"); //success
//			}
//			
//			
//		} catch (Exception e) {
////			jsonResponse.put("id", 0);
//			jsonResponse.put("status", "0"); //error
//			e.printStackTrace();
//		}
//		System.out.println(jsonResponse.toString());
//		return jsonResponse.toString();
//	}

	@RequestMapping(value = "/",method = RequestMethod.POST)
	public String save(@RequestParam ("citizen_id") int citizen_id,@RequestParam ("p_has_ele_id") int p_has_ele_id) {
		JSONObject jsonResponse=new JSONObject();
//		JSONObject jsonObject=new JSONObject(str);
		System.out.println(citizen_id);
		try {
			
			int count_vote=voteService_01.countByCitizen(citizen_id);
			System.err.println(count_vote);
			if(count_vote == 3 || count_vote > 3) {
				System.out.println("You can not Vote now , You have used your vote 3 times alredy....");
				jsonResponse.put("id", 00);
				jsonResponse.put("status", "2"); //fail
				jsonResponse.put("message", "3 times vote used Sorry......"); //fail
			}else {
				PoliticionsHasElection ss=new PoliticionsHasElection();
				ss.setId(p_has_ele_id);
			
//				Optional<Vote>	voteAll=voteService_01.findByPoliticionsHasElection(ss);
//				voteAll
			
//				System.out.println("SVEDDDD");
				Vote vote=new Vote();
				Citizen citizen=new Citizen();
				citizen.setId(citizen_id);
				vote.setCitizen(citizen);
				
				vote.setPoliticionsHasElection(ss);
				vote.setRegtime(AppDateTimeUtill.getCurrentDateTime());
				vote.setCitizen(citizen);
				vote=voteService_01.save(vote);
				
				jsonResponse.put("id", vote.getId());
				jsonResponse.put("status", "1"); //success
				jsonResponse.put("message", "Your Vote saved and you have "+count_vote+" votes availabe"); //fail
			}
			
			
		} catch (Exception e) {
			jsonResponse.put("id", 0);
			jsonResponse.put("status", "0"); //error
			jsonResponse.put("message", "error"); //fail
			e.printStackTrace();
		}
		System.out.println(jsonResponse.toString());
		return jsonResponse.toString();
	}
	
	
	@RequestMapping(value = "/zx",method = RequestMethod.POST)
	public String find_total_vote() {
		JSONArray jsonResponse=new JSONArray();
		List<Vote> getAll;
		try {
			int count_vote=0;
			
			 getAll=voteService_01.findByAll();
			 if(!getAll.isEmpty()) {
				 for(Vote v:getAll) {
					 JSONObject j_obj=new JSONObject();
					 j_obj.put("id",v.getId());
					 j_obj.put("person_id",v.getPoliticionsHasElection().getPoliticion().getPerson().getId());
					 j_obj.put("person_fname",v.getPoliticionsHasElection().getPoliticion().getPerson().getFname());
					 j_obj.put("election_id",v.getPoliticionsHasElection().getElection().getId());
					 j_obj.put("election_name",v.getPoliticionsHasElection().getElection().getName());
					 j_obj.put("district_id",v.getPoliticionsHasElection().getDistrict().getId());
					 j_obj.put("district_name",v.getPoliticionsHasElection().getDistrict().getName());
					 if(v.getPoliticionsHasElection() == v.getPoliticionsHasElection()) {
						 count_vote=count_vote+1;
					 }
//					 j_obj.put("district_name",v.getPoliticionsHasElection().getDistrict().getId());
//					 j_obj.put("id",v.getId());
//					 j_obj.put("id",v.getId());
					 jsonResponse.put(j_obj);
				 }
				 count_vote++;
			 }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonResponse.toString());
		return jsonResponse.toString();
	}
	
	@RequestMapping(value = "/my_vote",method = RequestMethod.POST)
	public String find_citizen_vote(@RequestParam ("c_id") int c_id) {
		JSONArray jsonResponse=new JSONArray();
		List<Vote> getAll;
		System.out.println(c_id);
		try {
			Citizen citizen=new Citizen();
			citizen.setId(c_id);
			 getAll=voteService_01.findByCitizen(citizen);
			 if(!getAll.isEmpty()) {
				 for(Vote v:getAll) {
					 JSONObject j_obj=new JSONObject();
					 j_obj.put("id",v.getId());
					 j_obj.put("person_id",v.getPoliticionsHasElection().getPoliticion().getPerson().getId());
					 j_obj.put("person_fname",v.getPoliticionsHasElection().getPoliticion().getPerson().getFname());
					 j_obj.put("election_id",v.getPoliticionsHasElection().getElection().getId());
					 j_obj.put("election_name",v.getPoliticionsHasElection().getElection().getName());
					 j_obj.put("district_id",v.getPoliticionsHasElection().getDistrict().getId());
					 j_obj.put("district_name",v.getPoliticionsHasElection().getDistrict().getName());
					 j_obj.put("poli_number",v.getPoliticionsHasElection().getNumberEle());
					 jsonResponse.put(j_obj);
				 }
				
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonResponse.toString());
		return jsonResponse.toString();
	}
	
}
