package com.phaete.nf411openaiapi.model;

import java.util.List;

public record OpenAiResponse(
    List<OpenAiChoices> choices
) {
    public String getAnswer() {
        return choices().getFirst().message().content();
    }
}
