package com.globant.sewingmachines.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

@RestController
public class SNSController {

	
	@Autowired
	private AmazonSNSClient amazonSNSClient;
	
	protected static final String TOPIC_ARN = "arn:aws:sns:us-east-1:126836804918:sns-topic-sales-pod-2";
	
	@GetMapping("/subscribe/{email}")
	public String subcribeToSNSTopic(@PathVariable("email") String email) {
		SubscribeRequest subscribeRequest = new SubscribeRequest(TOPIC_ARN, "email", email);
		
		amazonSNSClient.subscribe(subscribeRequest);
		return "Check your Email";
	}
	
	@GetMapping("/publish/{msg}")
	public String publishToTopic(@PathVariable("msg") String msg) {
		PublishRequest publishRequest = new PublishRequest(TOPIC_ARN,msg,"SNS SpringBoot");
		amazonSNSClient.publish(publishRequest);
		return "Message Published";
	}
	
	public String publish(@RequestBody String msg) {
		PublishRequest publishRequest = new PublishRequest(TOPIC_ARN,msg,"SNS SpringBoot");
		amazonSNSClient.publish(publishRequest);
		return "Message Published";
	}
}
