package com.phaete.nf411openaiapi.service;

import com.phaete.nf411openaiapi.model.OpenAiMessage;
import com.phaete.nf411openaiapi.model.OpenAiRequest;
import com.phaete.nf411openaiapi.model.OpenAiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class OpenAiService {

    private final RestClient restClient;

    public OpenAiService(@Value("${NF_OPENAI_API_KEY}") String apiKey,
                         @Value("${OPENAI_API_URL}") String apiUrl) {

        this.restClient = RestClient.builder()
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .baseUrl(apiUrl)
                .build();
    }

    public String getAnswerFromOpenAi(String prompt) {
        OpenAiRequest request = new OpenAiRequest(
                "gpt-4o-mini",
                List.of(new OpenAiMessage("user", prompt)),
                0.2
                );

        OpenAiResponse response = restClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve().body(OpenAiResponse.class);

        return response.getAnswer();
    }
}
