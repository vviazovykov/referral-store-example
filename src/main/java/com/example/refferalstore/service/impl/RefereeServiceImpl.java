package com.example.refferalstore.service.impl;

import java.util.Optional;

import com.example.refferalstore.repository.RefereeRepository;
import com.example.refferalstore.service.RefereeService;
import com.example.refferalstore.util.RefereeDataGenerator;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.example.refferalstore.entity.Referee;

@Service
@RequiredArgsConstructor
public class RefereeServiceImpl implements RefereeService {

    private final RefereeRepository repository;

    @Override
    public Referee createRefereeData(String userId) {

        // This referral data generation was made in this form only as part of the hackathon
        // Ideally, it should be generated separately

        return repository.save(
            RefereeDataGenerator.generate(userId)
        );
    }

    @Override
    public Optional<Referee> findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public Optional<Referee> findByReferralCode(String referralCode) {
        return repository.findByReferralCode(referralCode);
    }

    @Override
    public void incrementInviteesAmount(Referee referee) {

        var inviteesAmount = referee.getInviteesAmount() + 1;

        referee.setInviteesAmount(inviteesAmount);

        var tier = referee.getTier();

        if (tier.isUpgradeNeeded(inviteesAmount)) {
            referee.setTier(
                tier.next()
            );
        }

        repository.save(referee);
    }
}