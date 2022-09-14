package com.example.refferalstore.controller;

import com.example.refferalstore.service.RefereeService;
import com.example.refferalstore.entity.Referee;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class RefereeController {

    private final RefereeService service;

    @GetMapping
    public ResponseEntity<Referee> createReferralData(
        @RequestParam("userId") String userId
    ) {
        return service.findByUserId(userId)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.ok(
                service.createRefereeData(userId)
            ));
    }

    @GetMapping
    @RequestMapping("/validate")
    public ResponseEntity<Referee> validateReferralCode(
        @RequestParam("referralCode") String referralCode
    ) {
        return service.findByReferralCode(referralCode)
            .map(ResponseEntity::ok)
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping
    public ResponseEntity<String> incrementInviteesAmount(
        @RequestParam("referralCode") String referralCode
    ) {
        var referral = service.findByReferralCode(referralCode);

        if (referral.isPresent()) {

            service.incrementInviteesAmount(
                referral.get()
            );

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}