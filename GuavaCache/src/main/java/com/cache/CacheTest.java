package com.cache;

import java.util.*;
import java.util.concurrent.ExecutionException;
public class CacheTest {
	public static void main(String args[]) throws ExecutionException
	{	
		GenGuavaCache genCache = new GenGuavaCache();
		
		genCache.put("BUCKET", "Name", "Naren");
		genCache.put("BUCKET", "Localhost", "Localhost");
		
		Map<Object,Object> value = genCache.getAll("BUCKET");
		System.out.println("Bucket Value....");
		value.forEach( (k,v) -> { System.out.println(k+"="+v); } ) ;
		/*
		genCache.delete("BUCKET","Name");
		value = genCache.getAll("BUCKET");
		System.out.println("Bucket Value After Delete....");
		value.forEach( (k,v) -> { System.out.println(k+"="+v); } ) ;
		System.out.println( genCache.get("BUCKET", "Localhost1") );
		System.out.println( genCache.getCacheStats("BUCKET") );
		*/
		
		
		Map<Object,Object> apiMap = genCache.getAll("API_BUCKET");
		apiMap.forEach( (k,v) -> { System.out.println(((Entry)v).getLink()	) ; } ) ;
		
	}
}
