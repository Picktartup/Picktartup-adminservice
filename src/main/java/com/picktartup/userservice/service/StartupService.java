package com.picktartup.userservice.service;

import com.picktartup.userservice.dto.CreateRequest;
import com.picktartup.userservice.entity.Wallet;
import org.springframework.http.ResponseEntity;

public interface StartupService {

  ResponseEntity<String> createStartup(CreateRequest createRequest);
  boolean deleteStartup(String name);

}
