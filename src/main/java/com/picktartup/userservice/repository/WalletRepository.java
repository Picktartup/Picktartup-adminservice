package com.picktartup.userservice.repository;

import com.picktartup.userservice.entity.Wallet;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

  @Override
  Optional<Wallet> findById(Long walletId);
}
