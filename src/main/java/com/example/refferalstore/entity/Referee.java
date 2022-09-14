package com.example.refferalstore.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.example.refferalstore.model.Currency;
import com.example.refferalstore.model.Tier;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "referee")
@Data
@NoArgsConstructor
public class Referee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;

    @Column(name = "referral_code", unique = true, nullable = false)
    private String referralCode;

    @Column(name = "invitees_amount", unique = true, nullable = false)
    private int inviteesAmount;

    @Column(name = "tier", unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Tier tier = Tier.TIER_1;

    @Column(name = "currency", unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency = Currency.USD;

    public Referee(String userId, String referralCode, int inviteesAmount, Tier tier, Currency currency) {
        this.userId = userId;
        this.referralCode = referralCode;
        this.inviteesAmount = inviteesAmount;
        this.tier = tier;
        this.currency = currency;
    }
}