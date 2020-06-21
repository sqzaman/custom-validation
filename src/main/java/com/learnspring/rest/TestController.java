package com.learnspring.rest;

import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.learnspring.annotation.ValidateDateRange;
import com.learnspring.model.Movie;
import com.learnspring.model.MovieSearchRequest;
import com.learnspring.service.MovieService;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class TestController {

	@Qualifier("movieService")
	private final MovieService movieService;

	@ValidateDateRange(maxRange = 9)
	@GetMapping("/search/movies")
	public List<Movie> getMovies(
			@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate startDate,
			@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate endDate) {

		return movieService.findMovies(startDate, endDate);
	}

	

	@PostMapping("/search/movies")
	public List<Movie> searchMovies(
			@Valid @RequestBody MovieSearchRequest req) {

		return movieService.findMovies(req.getStartDate(), req.getEndDate());
	}

}
