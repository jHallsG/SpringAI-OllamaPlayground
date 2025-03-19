package com.springai.SpringAIDemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

// this class will read from the pdf file, and feed the vector values to the vector database
//@Component
public class IngestionService implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(IngestionService.class);

	private final VectorStore vectorStore;

	@Value("classpath:/docs/PH_Handbook.pdf")
	private Resource resource;

	public IngestionService(VectorStore vectorStore) {
		this.vectorStore = vectorStore;
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Uploading PDF contents to Vector Store");

		// get contents of PDF file
		// var pdfReader = new ParagraphPdfDocumentReader(resource);
		var pdfReader = new PagePdfDocumentReader(resource);

		// split contents into separate texts
		TextSplitter splitter = new TokenTextSplitter();

		// split texts into chunks
		var chunks = splitter.apply(pdfReader.get());

		vectorStore.accept(chunks);

		logger.info("Vector Store loading finished.");

	}
}
