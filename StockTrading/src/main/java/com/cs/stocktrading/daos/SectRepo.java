package com.cs.stocktrading.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cs.stocktrading.daos.CompRepo.CompanyRowMapper;
import com.cs.stocktrading.domains.Company;
import com.cs.stocktrading.domains.Sector;

@Repository
public class SectRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<Sector> findAll(){
		return jdbcTemplate.query("select * from sector", new SectorRowMapper());
	}
	
	@Transactional(readOnly=true)
	public Sector findSectorById(int sec_id) {
		return jdbcTemplate.queryForObject(
				"select * from sector where sec_id=?", 
				new Object[] {sec_id}, new SectorRowMapper());
	}
	
	public Sector create(final Sector sect) {
		final String sql = "insert into sector(sec_id,name,descr) values(?,?,?)";
		jdbcTemplate.update(sql,sect.getSec_id(),sect.getName(),sect.getDescr());
		return sect;
	}
	
	public List<Sector> update(final int sec_id, final Sector s){
		final String sql = "update sector set name=?,descr=? where sec_id=?";
		jdbcTemplate.update(sql,sec_id,s.getName(),s.getDescr(),s.getName(),s.getDescr());
		return jdbcTemplate.query("select * from sector", new SectorRowMapper());
	}

	public List<Sector> delete(final int sec_id){
		final String sql = "delete from sector where sec_id=?";
		jdbcTemplate.update(sql,sec_id);
		return jdbcTemplate.query("select * from sector", new SectorRowMapper());
	}
	
	class SectorRowMapper implements RowMapper<Sector>{
		
		@Override
		public Sector mapRow(ResultSet rs, int rowNum) throws SQLException{
			Sector sect = new Sector();
			sect.setSec_id(rs.getInt("sec_id"));
			sect.setName(rs.getString("name"));
			sect.setDescr(rs.getString("descr"));
			return sect;
		}
	}

}
