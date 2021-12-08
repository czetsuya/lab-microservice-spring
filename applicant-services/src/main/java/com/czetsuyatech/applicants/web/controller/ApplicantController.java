package com.czetsuyatech.applicants.web.controller;

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
}
