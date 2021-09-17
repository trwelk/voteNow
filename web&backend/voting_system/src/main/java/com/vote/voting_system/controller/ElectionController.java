package com.vote.voting_system.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vote.voting_system.Model.Election;
import com.vote.voting_system.repository.CitizenRepository;
import com.vote.voting_system.repository.ElectionRepository;
import com.vote.voting_system.repository.LoginRepository;
import com.vote.voting_system.repository.PoliticionRepository;
import com.vote.voting_system.service.ElectionService;
import com.vote.voting_system.utill.AppDateTimeUtill;

@Controller
public class ElectionController {

	@Autowired
	ElectionService electionService_01;
	
	@Autowired
	ElectionRepository electionRepository;
	
	@ResponseBody
	@PostMapping(value = "/saveelection")
	public String save(@RequestParam ("name") String name) {
		JSONObject resp_obj=new JSONObject();
		try {
			Election election=new Election();
			election.setName(name);
			election.setStatus(1);
			election.setRegtime(AppDateTimeUtill.getCurrentDateTime());
			election.setMaxCount("");
			election=electionService_01.save(election);
			resp_obj.put("p_id", election.getId());
			resp_obj.put("p_name", election.getName());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return resp_obj.toString();
	}
	
	@ResponseBody
	@PostMapping(value = "/updateelection")
	public String update(@RequestParam ("name") String name,@RequestParam ("id") int id) {
		JSONObject resp_obj=new JSONObject();
		try {
			Election election=new Election();
			election.setId(id);
			election.setName(name);
			election.setStatus(1);
			election.setRegtime(AppDateTimeUtill.getCurrentDateTime());
			election.setMaxCount("");
			election=electionService_01.save(election);
			resp_obj.put("p_id", election.getId());
			resp_obj.put("p_name", election.getName());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return resp_obj.toString();
	}
	
	@ResponseBody
	@GetMapping(value = "/electionList")
	public String getAll()
	{JSONArray array=new JSONArray();
		List<Election> getAll;
		try {
			getAll=electionService_01.findAll();
			if(!getAll.isEmpty()) {
				for(Election c: getAll) {
					
					if(c.getStatus() == 1) {
					JSONObject object=new JSONObject();
					object.put("id", c.getId());
					object.put("name", c.getName());
					object.put("regtime", c.getRegtime());
					array.put(object);
					}
					
				}
			}else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array.toString();
	}
	
	@DeleteMapping(value = "/deleteelection")
	public String delete(@RequestParam ("id") int id) {
		JSONObject resp_obj=new JSONObject();
		try {
			Election election=new Election();
			election.setId(id);
			electionRepository.delete(election);
			resp_obj.put("p_id", election.getId());
			resp_obj.put("p_name", election.getName());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return resp_obj.toString();
	}
	
	@Autowired
	CitizenRepository citizenRepository;
	
	@Autowired
	PoliticionRepository politicionRepository;
	
	@Autowired
	LoginRepository loginRepository;
	
	@ResponseBody
	@GetMapping(value = "/total_count")
	public String total_count() {
		JSONObject resp_obj=new JSONObject();
		try {
			int citizen_count=(int) citizenRepository.count();
			int poli_count=(int) politicionRepository.count();
			int active_login=(int) loginRepository.countByStatus(1);
			int deactive_login=(int) loginRepository.countByStatus(2);
			int web_admin_login=(int) loginRepository.countByRoleBeanId(1);
			int mobile_login=(int) loginRepository.countByRoleBeanId(2);
			
			int active_vote_status=(int) citizenRepository.countByStatus(1);
			int vote_s=0;
			if(active_vote_status > 0) {
				vote_s=1;
			}else {
				vote_s=2;
			}
			
			resp_obj.put("citizen_count", citizen_count);
			resp_obj.put("poli_count", poli_count);
			resp_obj.put("active_login", active_login);
			resp_obj.put("deactive_login", deactive_login);
			resp_obj.put("web_admin_login", web_admin_login);
			resp_obj.put("mobile_login", mobile_login);
			resp_obj.put("vote_s", vote_s);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(resp_obj.toString());
		return resp_obj.toString();
	}
	
}
