package com.tampro.Service;

import java.util.List;

import com.tampro.Model.Profile;
import com.tampro.Model.User;

public interface ProfileService {
	
 public List<Profile> getProfile() ;
	 
	 public void deleteProfile(int id);
	 
	 public void updateProfile(Profile  profile);
	 
	 public void addProfile(Profile profile);
	 
	 public Profile getProfile(int id);
	 
	 public Profile getProfileByIdUser(int iduser);

}
