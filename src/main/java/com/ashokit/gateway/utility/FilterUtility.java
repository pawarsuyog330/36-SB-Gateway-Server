package com.ashokit.gateway.utility;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class FilterUtility {
	public static final String TRACING_ID = "myapp-tracing-id";
	
	public String getTracingId(HttpHeaders requestHeaders) {
		if(requestHeaders.get(TRACING_ID) != null) {
			List<String> requestHeaderList = requestHeaders.get(TRACING_ID);
			return requestHeaderList.stream().findFirst().get();
		}
		else {
			return null;
		}
	}

}
