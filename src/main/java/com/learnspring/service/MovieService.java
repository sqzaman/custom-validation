package com.learnspring.service;

import java.time.LocalDate;
import java.util.List;

import com.learnspring.model.Movie;

public interface MovieService {
	List<Movie> findMovies(LocalDate startDate, LocalDate endDate);
}