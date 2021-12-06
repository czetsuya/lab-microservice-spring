package com.czetsuyatech.applicant.web.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicantController {

  @GetMapping("/applicants-by-job")
  public List<String> getApplicantsByJob() {
    return Arrays.asList("Kira", "Lacus", "Maryu");
  }
}
