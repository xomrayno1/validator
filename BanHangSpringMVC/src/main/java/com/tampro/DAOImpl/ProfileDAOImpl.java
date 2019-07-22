package com.tampro.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tampro.DAO.ProfileDAO;
import com.tampro.Model.Profile;

@Repository
public class ProfileDAOImpl  implements ProfileDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Profile> getProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteProfile(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateProfile(Profile profile) {
		String sql ="update profile  set name = ?,diachi= ?, sdt = ? , iduser = ? where id = ?";
		jdbcTemplate.update(sql,profile.getName(),profile.getDiachi(),profile.getSdt(),profile.getIdUser(),profile.getIdProfile());
		
	}

	public void addProfile(Profile profile) {
		String sql = "insert into profile(name,diachi,sdt,iduser)values(?,?,?,?)";
		jdbcTemplate.update(sql,profile.getName(),profile.getDiachi(),profile.getSdt(),profile.getIdUser());
		
	}

	public Profile getProfile(int id) {
		// TODO Auto-generated method stub
		   String sql = "select * from profile  where id=?";
			
			
			List<Profile> listProfile = jdbcTemplate.query(sql, new Object[] {id},new RowMapper<Profile>() {

				public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Profile  profile = new Profile();
					profile.setDiachi(rs.getString("diachi"));
					profile.setIdProfile(rs.getInt("id"));
					profile.setIdUser(rs.getInt("iduser"));
					profile.setName(rs.getString("name"));
					profile.setSdt(rs.getString("sdt"));
					return profile;
				}
				
			});
			 if(listProfile.isEmpty())
			 {
				 return null;
			 }
			 else
			 {
				 return listProfile.get(0);
			 }
	}
	
	public Profile getProfileByIdUser(int iduser) {
		// TODO Auto-generated method stub
        String sql = "select * from profile  where iduser=?";
		
		
		List<Profile> listProfile = jdbcTemplate.query(sql, new Object[] {iduser},new RowMapper<Profile>() {

			public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Profile  profile = new Profile();
				profile.setDiachi(rs.getString("diachi"));
				profile.setIdProfile(rs.getInt("id"));
				profile.setIdUser(rs.getInt("iduser"));
				profile.setName(rs.getString("name"));
				profile.setSdt(rs.getString("sdt"));
				return profile;
			}
			
		});
	 if(listProfile.isEmpty())
	 {
		 return null;
	 }
	 else
	 {
		 return listProfile.get(0);
	 }
		
	}

}
