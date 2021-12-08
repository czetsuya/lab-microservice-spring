package com.czetsuyatech.applicants.web.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class ApplicantController {

  @GetMapping("/applicants-by-job")
  public List<String> getApplicantsByJob() {

    log.debug("get applicants by job");
    return Arrays.asList("Steve", "Bill", "Linus");
  }

  //  @Retry(name = "default", fallbackMethod = "getTopApplicantsByJobDefault")
  @CircuitBreaker(name = "default", fallbackMethod = "getTopApplicantsByJobDefault")
  @GetMapping("/top-applicants-by-job")
  public List<String> getTopApplicantsByJob() {

    log.debug("get top applicants by job");

    ResponseEntity<String> result = new RestTemplate().getForEntity("http://localhost:8000/circuit-breaker",
        String.class);
    result.getBody();

    return null;
  }

  public List<String> getTopApplicantsByJobDefault(Exception e) {

    log.debug("default top applicant");
    return Arrays.asList("Ed from circruit breaker");
  }
}
