package com.springai.SpringAIDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springai.SpringAIDemo.service.DocumentGuidedChatService;

@RestController
public class EmbeddecController {
	
	@Autowired
	private DocumentGuidedChatService embedService;
	
	@GetMapping("/guidedResponse")
	public String getGuidedResponse(@RequestParam("query") String userPrompt) {
		return embedService.processUserQuery(userPrompt);
	}

}
