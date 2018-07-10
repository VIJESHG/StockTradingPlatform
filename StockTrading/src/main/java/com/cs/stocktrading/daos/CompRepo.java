package com.cs.stocktrading.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cs.stocktrading.domains.Company;

@Repository
public class CompRepo {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<Company> findAll(){
		return jdbcTemplate.query("select * from company", new CompanyRowMapper());
	}
	
	@Transactional(readOnly=true)
	public Company findCompanyByTicker(String ticker) {
		return jdbcTemplate.queryForObject(
				"select * from company where ticker=?", 
				new Object[] {ticker}, new CompanyRowMapper());
	}
	
	public Company create(final Company cmp) {
		final String sql = "insert into company(ticker,name,sec_id) values(?,?,?)";
		jdbcTemplate.update(sql,cmp.getTicker(),cmp.getName(),cmp.getSec_id());
		return cmp;
	}
	
	public List<Company> delete(final String ticker){
		final String sql = "delete from company where ticker=?";
		jdbcTemplate.update(sql,ticker);
		return jdbcTemplate.query("select * from company", new CompanyRowMapper());
	}
	
	class CompanyRowMapper implements RowMapper<Company>{
		
		@Override
		public Company mapRow(ResultSet rs, int rowNum) throws SQLException{
			Company cmp = new Company();
			cmp.setSec_id(rs.getInt("sec_id"));
			cmp.setName(rs.getString("name"));
			cmp.setTicker(rs.getString("ticker"));
			return cmp;
		}
	}
	
	
}
