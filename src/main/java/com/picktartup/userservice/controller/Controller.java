package com.picktartup.userservice.controller;


import com.picktartup.userservice.dto.CreateRequest;
import com.picktartup.userservice.service.StartupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/startups")
public class Controller {
  private final StartupService startupService;

  public Controller(StartupService startupService) {
    this.startupService = startupService;
  }

  /**
   * Startup 생성
   *
   * @param createRequest 요청 데이터
   * @return 성공 또는 실패 메시지
   */
  @PostMapping("/create")
  public ResponseEntity<String> createStartup(@RequestBody CreateRequest createRequest) {
    return startupService.createStartup(createRequest);
  }

  /**
   * Startup 삭제
   *
   * @param name 삭제할 Startup의 이름
   * @return 성공 또는 실패 메시지
   */
  @DeleteMapping("/{name}")
  public ResponseEntity<String> deleteStartup(@PathVariable String name) {
    boolean isDeleted = startupService.deleteStartup(name);

    if (isDeleted) {
      return ResponseEntity.ok("Startup '" + name + "' 삭제에 성공했습니다.");
    } else {
      return ResponseEntity.status(404).body("Startup '" + name + "'을(를) 찾을 수 없습니다.");
    }
  }
}
