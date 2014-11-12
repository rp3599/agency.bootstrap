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
package com.rakesh.rp3599.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingContext implements CachingConfigurer {

    @Autowired(required = false)
    private CacheManager ehCacheCacheManager;

	public CacheResolver cacheResolver() {
		return null;
	}

	public CacheErrorHandler errorHandler() {
		return null;
	}

	public CacheManager cacheManager() {
		List<CacheManager> cacheManagers = new ArrayList<CacheManager>();

        if (this.ehCacheCacheManager != null) {
            cacheManagers.add(this.ehCacheCacheManager);
        }

        CompositeCacheManager cacheManager = new CompositeCacheManager();
        cacheManager.setCacheManagers(cacheManagers);
        cacheManager.setFallbackToNoOpCache(false);

        return cacheManager;
	}

	public KeyGenerator keyGenerator() {
		return new SimpleKeyGenerator();
	}
	
}
