package com.example.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionFormat {
	private LocalDateTime timestamp;
	private String message;
	private String uri;
}
