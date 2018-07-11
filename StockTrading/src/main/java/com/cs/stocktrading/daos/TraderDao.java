package com.cs.stocktrading.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cs.stocktrading.domains.Trader;

@Repository
public class TraderDao {
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Transactional(readOnly=true)
	public Trader getTraderById(int trad_id)
	{
	return jdbctemplate.queryForObject("select * from Trader where trad_id=?",new Object[] {trad_id}
	,new TraderMapper());
	}

	@Transactional(readOnly=true)
	public String deleteTrader(int trad_id)
	{
	Trader t=jdbctemplate.queryForObject("select * from Trader where trad_id=?",new Object[] {trad_id}
	,new TraderMapper());
	if(t.getLive_ords() == 0)
	{
	String sql = "UPDATE Trader SET status=? WHERE trad_id=?";
	  jdbctemplate.update(sql,0,t.getTrad_id());
	 
	 return "Trader Info deleted successfully";
	}

	else
	{
	return "Trader cannot deleted successfully";
	}
	}
	
	@Transactional(readOnly=true)
	public List<Trader> findAll(){
		return jdbctemplate.query("select * from trader", new TraderMapper());
	}
	
	public Trader create(final Trader trader) {
		final String sql ="insert into trader(name,email,address,live_ords,status) values(?,?,?,?,?)";
		jdbctemplate.update(sql,trader.getName(),
				trader.getEmail(),trader.getAddress(),trader.getLive_ords(),trader.getStatus());
		return trader;
	}
}

class TraderMapper implements RowMapper<Trader>{

	@Override
	public Trader mapRow(ResultSet rs, int rowNum) throws SQLException {
		Trader trader = new Trader();
		trader.setTrad_id(rs.getInt("trad_id"));
		trader.setName(rs.getString("name"));
		trader.setEmail(rs.getString("email"));
		trader.setAddress(rs.getString("address"));
		trader.setLive_ords(rs.getInt("live_ords"));
		trader.setStatus(rs.getInt("status"));
		return trader;
		
	}
	
}
	

