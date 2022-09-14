package com.example.refferalstore.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.example.refferalstore.entity.Referee;

@Repository
public interface RefereeRepository extends CrudRepository<Referee, Long> {

    Optional<Referee> findByUserId(String userId);

    Optional<Referee> findByReferralCode(String referralCode);
}