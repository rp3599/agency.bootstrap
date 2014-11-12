/**
 * The MIT License (MIT)
 * 
 * Copyright (c) <2014> <rp3599>
 * 
 * Check Me Out Here => www.linkedin.com/in/rakeshkumarperumal/
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
package com.rakesh.rp3599.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rakesh.rp3599.exception.AgencyNotFoundException;
import com.rakesh.rp3599.model.Application;
import com.rakesh.rp3599.repository.ApplicationRepository;

@Service
public class ApplicationService {
	
	@Resource private ApplicationRepository repository;
	
	public Application findByName(String name) throws AgencyNotFoundException {
		return repository.findByName(name);
	}
	
	public List<Application> findAll() throws AgencyNotFoundException {
		return repository.findAll();
	}

}