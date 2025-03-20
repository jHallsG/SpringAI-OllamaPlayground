package com.springai.SpringAIDemo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springai.SpringAIDemo.service.ChatService;

@RestController
public class GenerativeAIController {
	
	private final ChatService chatService;
	private final EmbeddingModel embeddingModel;
	
	public GenerativeAIController(ChatService chatService, EmbeddingModel embeddingModel) {
		this.chatService = chatService;
		this.embeddingModel = embeddingModel;
	}

	@GetMapping("/askAI")
	public String getResponse(@RequestParam("query") String userPrompt) {
		
		return chatService.getAIResponse(userPrompt);
	}
	
	@GetMapping("/promptAI")
	public String getResponseWithPrompts(@RequestParam("query") String userPrompt) {
		
		return chatService.getAIResponseWithSystemPrompts(userPrompt);
	}
	
	@GetMapping("/promptAIWithFiles")
	public String getResponseWithSmallFiles(@RequestParam("query") String userPrompt) {
		
		return chatService.getAIResponseUsingSmallFiles(userPrompt);
	}
}
