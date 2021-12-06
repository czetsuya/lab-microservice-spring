package com.czetsuyatech.jobs.web.controller;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("applicant-services")
public interface ApplicantProxy {

  @GetMapping("/applicants-by-job")
  public List<String> getApplicantsByJob();
}
