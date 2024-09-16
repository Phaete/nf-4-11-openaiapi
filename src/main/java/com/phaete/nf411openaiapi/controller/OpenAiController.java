package com.phaete.nf411openaiapi.controller;

import com.phaete.nf411openaiapi.service.OpenAiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/openai")
public class OpenAiController {

    private final OpenAiService openAiService;

    public OpenAiController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @PostMapping
    public String getAnswerFromOpenAi(@RequestBody String prompt) {
        return openAiService.getAnswerFromOpenAi(prompt);
    }
}
