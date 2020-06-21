package com.learnspring.service.impl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import com.learnspring.model.Movie;
import com.learnspring.service.MovieService;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

	@Override
	public List<Movie> findMovies(LocalDate startDate, LocalDate endDate) {
		return Arrays.asList(new Movie("Titanic", LocalDate.parse("1912-01-01"), "A good movie based on real story"));
	}

}
