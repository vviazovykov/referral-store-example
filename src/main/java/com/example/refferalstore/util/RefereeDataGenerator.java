package com.example.refferalstore.util;

import java.util.UUID;
import java.util.function.Supplier;

import lombok.NoArgsConstructor;
import lombok.AccessLevel;

import com.example.refferalstore.entity.Referee;
import com.example.refferalstore.model.Currency;
import com.example.refferalstore.model.Tier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RefereeDataGenerator {

    private static final Supplier<String> referralCodeSupplier = () -> UUID.randomUUID().toString().replace("-", "").toUpperCase();

    public static Referee generate(String userId) {
        return new Referee(
            userId,
            referralCodeSupplier.get(),
            0,
            Tier.TIER_1,
            Currency.USD
        );
    }
}