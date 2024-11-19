package com.picktartup.userservice.repository;

import com.picktartup.userservice.entity.Startup;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StartupRepository extends JpaRepository<Startup, Long> {

  Optional<Startup> findByname(String name);

  void deleteByName(String name);

}