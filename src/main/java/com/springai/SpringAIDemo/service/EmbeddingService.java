package com.springai.SpringAIDemo.service;

import java.util.List;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.ollama.api.OllamaOptions;

public class EmbeddingService {
	
	private final EmbeddingModel embeddingModel;
	
	public EmbeddingService(EmbeddingModel embeddingModel) {
		this.embeddingModel = embeddingModel;
	}
	
	
//	public EmbeddingResponse getEmbeddingResponse(String userPrompt) {
//		EmbeddingResponse embeddingResponse = embeddingModel.call(
//			    new EmbeddingRequest(List.of(userPrompt),
//			        OllamaOptions.builder()
//			            .model("Different-Embedding-Model-Deployment-Name"))
//			            .truncates(false)
//			            .build());
//	}

}
