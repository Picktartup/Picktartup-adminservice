package com.picktartup.userservice.dto;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRequest {
  private String name;
  private String category;
  private LocalDateTime contractStartDate;
  private LocalDateTime contractTargetDeadline;
  private int progress;
  private int currentCoin;
  private int goalCoin;
  private Long walletId;
}
