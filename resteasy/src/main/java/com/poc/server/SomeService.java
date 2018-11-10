package com.poc.server;

import java.io.File;
import java.io.FileInputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import com.poc.model.SomeBean;

@Path("/some")
public class SomeService {
	
	@POST
	@Path("/pdf")
	@Produces("application/pdf")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public javax.ws.rs.core.Response postJsonToGetPdf(@FormParam("objetJSON") String stringifiedJsonObject) throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		final SomeBean someBean = mapper.readValue(stringifiedJsonObject, SomeBean.class);
		System.out.println(someBean);
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("pdf-test.pdf").getFile());

	    FileInputStream fileInputStream = new FileInputStream(file);
	    javax.ws.rs.core.Response.ResponseBuilder responseBuilder = javax.ws.rs.core.Response.ok((Object) fileInputStream);
	    responseBuilder.type("application/pdf");
	    responseBuilder.header("Content-Disposition", "filename=pdf-test.pdf");
	    return responseBuilder.build();
	}

}
