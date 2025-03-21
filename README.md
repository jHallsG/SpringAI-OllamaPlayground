This is a fun project created to practice on RAG (Retrieval Augmented Generation) using Java Springboot and Spring AI. The purpose is for the AI to generate it's answers from a specific PDF file. 
It may be a whole book, an instruction manual, a documentation, etc. The AI does not choose.

Requirements before running this code.
1. Docker
2. Ollama

Docker is required as the app automatically creates two docker images, the PGVector Database and Ollama.
Ollama is required as we need to download two things:
    a) LLM Model
        -- the chat model. If you are using a normal laptop or desktop, I recommend downloading "Llama3.1:8b". Anything higher will require a dedicated GPU and atleast 64GB of RAM.
    b) Embedding Model
        -- the PDF file's contents will be converted to numerical embeddings and saved to PGVector Database. Luckily, the embedding model will do that for us.

3. The application.properties need the following configuration:
  spring.ai.ollama.chat.model                    --> the name of the AI model you've downloaded in Ollama
  spring.ai.ollama.embedding.model               --> the name of the embedding model you'[ve downloaded in Ollama
  spring.ai.vectorstore.pgvector.dimensions      --> each embedding model have their own dimensions. (768 for nomic, 1024 for mxbai...)

4. The PDF file. Copy any pdf file to "src/main/resources/docs". Edit the resource file in the DataLoader.class to point to the correct PDF file name.
