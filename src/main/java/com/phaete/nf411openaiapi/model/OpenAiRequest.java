package com.phaete.nf411openaiapi.model;

import java.util.List;

public record OpenAiRequest(
    String model,
    List<OpenAiMessage> messages,
    double temperature
) {
}
