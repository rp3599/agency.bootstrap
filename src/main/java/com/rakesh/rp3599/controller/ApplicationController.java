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
package com.rakesh.rp3599.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rakesh.rp3599.exception.AgencyNotFoundException;
import com.rakesh.rp3599.service.ApplicationService;

@Controller
public class ApplicationController extends ExceptionHandlingController {
	
	 private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

	 @Resource private ApplicationService service;
	 
	 @Autowired public Environment env;
	 
	 @RequestMapping(value="/", method = RequestMethod.GET)
	 public String serveHome(Model model, HttpServletRequest req) throws AgencyNotFoundException {
		 
		 // Logging Test
		 logger.info("RP3599: " + env.getProperty("app.name"));
		 
		 // DB Test (Remember it is calling service not repository directly)
		 model.addAttribute("application", service.findByName("rp3599"));
		 
		 // Set Your Social Links
		 model.addAttribute("twitter", env.getProperty("rp3599.twitter"));
		 model.addAttribute("linkedin", env.getProperty("rp3599.linkedin"));
		 model.addAttribute("github", env.getProperty("rp3599.github"));
		 
		 // Return home page
		 return "index";
	 }

}