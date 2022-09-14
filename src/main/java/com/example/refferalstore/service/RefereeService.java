package com.example.refferalstore.service;

import java.util.Optional;

import com.example.refferalstore.entity.Referee;

public interface RefereeService {

    Referee createRefereeData(String userId);

    Optional<Referee> findByUserId(String userId);

    Optional<Referee> findByReferralCode(String referralCode);

    void incrementInviteesAmount(Referee referee);
}