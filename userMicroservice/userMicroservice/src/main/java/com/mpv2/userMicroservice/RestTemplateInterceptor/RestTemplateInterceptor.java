package com.mpv2.userMicroservice.RestTemplateInterceptor;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {
	
	private OAuth2AuthorizedClientManager manager;
	private Logger logger = LoggerFactory.getLogger(RestTemplateInterceptor.class);
	
	
	
	public RestTemplateInterceptor(OAuth2AuthorizedClientManager manager) {
		super();
		this.manager = manager;
	}


    public ClientHttpResponse intercept1(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException{
	String token = manager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client").principal("internal").build()).getAccessToken().getTokenValue();
	logger.info("Rest template interceptor: Token: {}",token);
	request.getHeaders().add("Authorization", "bearer"+token);
	return execution.execute(request, body);
}


	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}


}