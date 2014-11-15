/**
 * The MIT License (MIT)
 * 
 * Copyright (c) <2014> <rp3599>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.rakesh.rp3599.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rakesh.rp3599.model.Application;
import com.rakesh.rp3599.util.ApplicationUtil;

@Repository
public class ApplicationRepository {
	
	private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	public List<Application> findAll() {
		return jdbcTemplate.query(ApplicationUtil.SELECT_AGENCY, new RowMapper<Application>(){  
		    public Application mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	Application e =new Application();  
		        e.setId(rs.getInt("id"));  
		        e.setCompanyName(rs.getString("company_name"));  
		        return e;  
		    }  
		 });  
	}
	
	public Application findByName(String name) {
		return jdbcTemplate.queryForObject(ApplicationUtil.SELECT_AGENCY_BY_NAME, new Object[] { name }, new RowMapper<Application>() {
			public Application mapRow(ResultSet rs, int rowNum) throws SQLException {
				Application e =new Application();  
		        e.setId(rs.getInt("id"));  
		        e.setCompanyName(rs.getString("company_name"));  
				return e;
			}
		});
	}

}