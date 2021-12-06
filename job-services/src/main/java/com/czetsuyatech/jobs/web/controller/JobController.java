package com.czetsuyatech.jobs.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class JobController {

  private final ApplicantProxy applicantProxy;

  public ResponseEntity listJobsWithApplicantProfiles() {

    applicantProxy.getApplicantsByJob().forEach(System.out::println);
    return null;
  }
}
