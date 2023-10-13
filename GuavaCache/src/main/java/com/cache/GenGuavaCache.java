package com.cache;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import com.google.gson.*;

public class GenGuavaCache {
	private static Map<String,CacheBucket> cacheBucketMap = new HashMap<>();
	private static Cache<Object,Object> cache = CacheBuilder.newBuilder()
			.expireAfterAccess(60L,TimeUnit.MINUTES)
			.recordStats()
			.build();
	
	private static LoadingCache<Object,Object> loadingCache = CacheBuilder.newBuilder()
			.expireAfterAccess(60L,TimeUnit.MINUTES) 
			.recordStats()
			.build( new CacheLoader<Object,Object>() { 
					@Override
					public Object load(Object key) throws Exception {
						return loadApiData();
					}
				} 
			);
	
	public GenGuavaCache() 
	{
		initCache();
		
		//callPublicApi();
		//loadApiData();
		
	}
	private static void initCache()
	{
		CacheBucket bucket = new CacheBucket("BUCKET",cache);
		CacheBucket loadedBucket = new CacheBucket("API_BUCKET",loadingCache);
		cacheBucketMap.put("BUCKET",bucket);
		cacheBucketMap.put("API_BUCKET",loadedBucket);
	}
	public static Map<Object,Object>  loadApiData() {
		Map<Object,Object> apiCache = new HashMap<Object,Object>();
		File file = new File("E:\\Eclipse_Workspace\\GuavaCache\\src\\main\\resources\\api.json");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			StringBuilder sb= new StringBuilder();
			String str = "";
			while((str=reader.readLine())!=null)
			{
				sb.append(str);
			}
			ApiList apiList = new Gson().fromJson(sb.toString(), ApiList.class);
			if(apiList!=null)
				System.out.println(apiList.getCount());
			
			for(Entry entry: apiList.getEntries())
			{
				apiCache.put(entry.getApi(), entry);
			}
			reader.close(); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return apiCache;
	}
	public void callPublicApi()
	{
		StringBuilder sb= new StringBuilder();
		String apiListUrl="https://api.publicapis.org/entries";
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) new URL(apiListUrl).openConnection();
			int responseCode = connection.getResponseCode();
			System.out.println("ResponseCode...."+responseCode);
			if(responseCode>=200 && responseCode<300)
			{
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String str="";
				while( (str=reader.readLine())!=null )
				{
					sb.append(str);
				}
				reader.close();
				
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				JsonElement element = JsonParser.parseString(sb.toString());
				String apiJson = gson.toJson(element);
				File outputFile = new File("E:\\Eclipse_Workspace\\GuavaCache\\src\\main\\resources\\api.json");
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
				writer.flush();
				writer.write(apiJson);
				writer.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
	public Object get(String bucketKey,String key) {
		
		Cache<Object,Object> cache = null;
		if(getCacheBucket(bucketKey)!=null)
			cache = getCacheBucket(bucketKey).getCache();
		else
			return null;
		
		cache = getCacheBucket(bucketKey).getCache();
		ConcurrentMap<Object, Object> map = cache.asMap();
		return map.get(key);
	}

	public boolean put(String bucketKey ,Object key,Object value) {
		if(cacheBucketMap==null)
			initCache();
		
		if(getCacheBucket(bucketKey)!=null)
			getCacheBucket(bucketKey).getCache().put(key, value);
		else
			return false;
		return true;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<Object,Object> getAll(String bucketKey) throws ExecutionException {
		System.out.println(bucketKey);
		Map<Object,Object> cacheValue = new HashMap<Object,Object>();
		Cache<Object,Object> cache = null;
		ConcurrentMap<Object, Object> map = null;
		if(cacheBucketMap==null)
			initCache();
	
		if(getCacheBucket(bucketKey)!=null)
			cache = getCacheBucket(bucketKey).getCache();
		else
			return cacheValue;
		
		if(bucketKey.equals("API_BUCKET"))
		{
			cacheValue = (Map<Object, Object>) ((LoadingCache)cache).get(bucketKey);
		}
		else
		{
			map = cache.asMap();
			for(Map.Entry<Object, Object> cmap: map.entrySet())
			{
				cacheValue.put(cmap.getKey(), cmap.getValue());
			}
		}
		
		return cacheValue;
	}
	
	public boolean delete(String bucketKey,String key)
	{
		Cache<Object,Object> cache = null;
		if(getCacheBucket(bucketKey)!=null) {
			cache = getCacheBucket(bucketKey).getCache();
			cache.invalidate(key);
			return true;
		}
		else
			return false;	
	}
	
	private CacheBucket getCacheBucket(String bucketKey) {
		CacheBucket bucket = cacheBucketMap.get(bucketKey);
		Optional<CacheBucket> bucketValue = Optional.ofNullable(bucket);
		if(!bucketValue.isEmpty()) {
			return cacheBucketMap.get(bucketKey);
		}
		else {
			System.out.println("CacheBucket ["+bucketKey+"] Not Exist");
			return null;
		}
	}
	
	public CacheStats getCacheStats(String bucketKey)
	{
		return getCacheBucket(bucketKey).getCache().stats();
	}
	public static Cache<Object, Object> getCache() {
		return cache;
	}
	public static LoadingCache<Object, Object> getLoadingCache() {
		return loadingCache;
	}
	
}

