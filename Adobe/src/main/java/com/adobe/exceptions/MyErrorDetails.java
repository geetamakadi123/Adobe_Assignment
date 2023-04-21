package com.adobe.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorDetails {

	private LocalDateTime timestamp;
	private String message;
	private String details;
	
}
