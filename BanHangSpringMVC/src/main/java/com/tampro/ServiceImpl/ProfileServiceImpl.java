package com.tampro.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.DAO.ProfileDAO;
import com.tampro.Model.Profile;
import com.tampro.Service.ProfileService;

@Service
public class ProfileServiceImpl  implements ProfileService{

	@Autowired
	ProfileDAO dao;
	
	public List<Profile> getProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteProfile(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateProfile(Profile profile) {
		dao.updateProfile(profile);
		
	}

	public void addProfile(Profile profile) {
		dao.addProfile(profile);
		
	}

	public Profile getProfile(int id) {
		// TODO Auto-generated method stub
		return dao.getProfile(id);
	}

	public Profile getProfileByIdUser(int iduser) {
		// TODO Auto-generated method stub
		return dao.getProfileByIdUser(iduser);
	}

}
