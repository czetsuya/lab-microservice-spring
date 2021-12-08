package com.czetsuyatech.applicants.web.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ApplicantController {

  @GetMapping("/applicants-by-job")
  public List<String> getApplicantsByJob() {

    log.debug("get applicants by job");
    return Arrays.asList("Steve", "Bill", "Linus");
  }

  @Retry(name = "default", fallbackMethod = "getTopApplicantsByJoDefault")
  @CircuitBreaker(name = "default", fallbackMethod = "getTopApplicantsByJoDefault")
  @GetMapping("top-applicants-by-job")
  public List<String> getTopApplicantsByJo() {

    log.debug("get top applicants by job");
    return null;
  }

  public List<String> getTopApplicantsByJoDefault() {
    return new ArrayList<>();
  }
}
