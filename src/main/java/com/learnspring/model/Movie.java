package com.learnspring.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {
	private String name;
	private LocalDate release;
	private String description;
}
