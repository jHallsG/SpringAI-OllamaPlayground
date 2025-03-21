# RAG Project with Spring Boot & Spring AI  

This is a fun project designed to practice **Retrieval-Augmented Generation (RAG)** using **Java Spring Boot** and **Spring AI**. The goal is for the AI to generate answers based on a specific **PDF file**, such as a book, instruction manual, or documentation. The AI does **not** choose the source—it strictly retrieves information from the provided document.  

## 🚀 Requirements  

Before running this project, ensure you have the following installed:  

### 1. **Docker**  
Docker is required because the app **automatically creates two Docker containers**:  
- **PGVector Database** (for storing embeddings)  
- **Ollama** (for running the AI models)  

### 2. **Ollama**  
Ollama is needed to download two essential models:  

- **LLM Model** (for chat responses)  
  - If you're using a regular laptop or desktop, **Llama3.1:8b** is recommended.  
  - Models larger than 8b require a **dedicated GPU** and at least **64GB RAM**.  

- **Embedding Model** (for processing the PDF contents)  
  - Converts the PDF text into numerical embeddings, which are stored in the PGVector database.  

## ⚙️ Configuration  

Before running the application, update `application.properties` with the following settings:  

```properties
spring.ai.ollama.chat.model= # Name of the AI model downloaded in Ollama  
spring.ai.ollama.embedding.model= # Name of the embedding model downloaded in Ollama  
spring.ai.vectorstore.pgvector.dimensions= # Embedding model dimension (e.g., 768 for nomic, 1024 for mxbai)
```
## 📄 Adding a PDF File
1. Copy your PDF file to : src/main/resources/docs
2. Edit the DataLoader.class, Resource property to point to the correct PDF file name
