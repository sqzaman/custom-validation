package com.learnspring.model;

import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.ObjectUtils;
import static java.time.temporal.ChronoUnit.DAYS;
import lombok.Data;

@Data
public class MovieSearchRequest {
	@NotNull(message = "start date can't be null")
	private LocalDate startDate;
	@NotNull(message = "end date can't be null")
	private LocalDate endDate;

	private long daysDifference() {
		return DAYS.between(startDate, endDate);
	}

	@AssertTrue(message = "Date range exceeds")
	public boolean isValidRange() {
		boolean valid = false;

		if (ObjectUtils.isNotEmpty(startDate) && ObjectUtils.isNotEmpty(endDate)) {
			long daysDifference = daysDifference();
			valid = daysDifference >= 0L && daysDifference <= 9L;
		}
		return valid;
	}
}
