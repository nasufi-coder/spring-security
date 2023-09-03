package com.automotive.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Error response loosely following RFC7807 'Problem Details for HTTP APIs';
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Schema(name = "ErrorResponse", description = "Error response loosely following RFC7807 'Problem Details for HTTP APIs'")
public class ErrorResponse {

    @NotNull
    @JsonProperty("status")
    // @Schema(name = "status", example = "400", description = "HTTP status code")
    private Integer status;

    @JsonProperty("title")
    // @Schema(name = "title", example = "Bad request", description = "A short, human-readable summary of the problem type")
    private String title;

    @JsonProperty("detail")
    //@Schema(name = "detail", example = "Parameter 'foo' is required but missing", description = "A human-readable explanation specific to this occurrence of the problem")
    private String detail;
}

