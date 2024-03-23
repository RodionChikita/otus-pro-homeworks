package ru.otus.java.pro.hw30_https.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Approval(boolean approved) {}
