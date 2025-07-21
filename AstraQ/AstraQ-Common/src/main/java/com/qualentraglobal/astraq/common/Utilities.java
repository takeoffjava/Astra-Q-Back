package com.qualentraglobal.astraq.common;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.qualentraglobal.astraq.common.Constant.CONTENT_TYPE;


@Component
public class Utilities {

	
	
	public HttpHeaders setHeaders(CONTENT_TYPE contentType) {

		HttpHeaders header=new HttpHeaders();
		
		switch (contentType) {
	    case JSON -> header.setContentType(MediaType.APPLICATION_JSON);
	    case TEXT -> header.setContentType(MediaType.TEXT_PLAIN);
	    case XML -> header.setContentType(MediaType.APPLICATION_XML);
	    case APPLICATION_OCTET_STREAM -> header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    case MULTIPART_FORM_DATA -> header.setContentType(MediaType.MULTIPART_FORM_DATA);
	    default -> header.setContentType(MediaType.ALL);
	};
	
		return header;
	}
}
