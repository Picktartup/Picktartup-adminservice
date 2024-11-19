package com.picktartup.userservice.service;

import com.picktartup.userservice.dto.CreateRequest;
import com.picktartup.userservice.entity.Wallet;
import com.picktartup.userservice.repository.StartupRepository;
import com.picktartup.userservice.repository.WalletRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import com.picktartup.userservice.entity.Startup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StartupServiceImpl implements StartupService {

  private final StartupRepository startupRepository;
  private final WalletRepository walletRepository;


  public StartupServiceImpl(StartupRepository startupRepository, WalletRepository walletRepository) {
    this.startupRepository = startupRepository;
    this.walletRepository = walletRepository;
  }


  @Override
  @Transactional
  public ResponseEntity<String> createStartup(CreateRequest createRequest) {

    Wallet wallet = walletRepository.findById(createRequest.getWalletId())
        .orElseThrow(() -> new IllegalArgumentException("지갑 ID가 존재하지 않습니다."));

    String progress = String.valueOf(createRequest.getProgress()) + "%";

    try{
    Startup startup = Startup.builder().name(createRequest.getName())
        .category(createRequest.getCategory())
        .contractStartDate(createRequest.getContractStartDate())
        .contractTargetDeadline(createRequest.getContractTargetDeadline())
        .progress(progress)
        .currentCoin(createRequest.getCurrentCoin())
        .goalCoin(createRequest.getGoalCoin())
        .wallet(wallet)
        .build();

    startupRepository.save(startup);

    return ResponseEntity.ok("Startup 저장이 성공했습니다.");
  } catch(
  Exception e)

  {
    // 저장 실패 시 에러 메시지와 상태 코드 반환
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Startup 저장에 실패했습니다: " + e.getMessage());
  }
}

  @Override
  @Transactional
  public boolean deleteStartup(String name) {
    Optional<Startup> startup = startupRepository.findByname(name);

    if (startup.isPresent()) {
      startupRepository.deleteByName(name);
      return true; // 삭제 성공
    } else {
      return false; // 지갑이 존재하지 않음
    }
  }


}
