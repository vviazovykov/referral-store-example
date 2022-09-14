package com.example.refferalstore.model;

import java.time.temporal.ValueRange;

import lombok.RequiredArgsConstructor;
import lombok.Getter;

@RequiredArgsConstructor
@Getter
public enum Tier {

    TIER_1(
        ValueRange.of(0, 4), 10
    ),
    TIER_2(
        ValueRange.of(5, 14), 20
    ),
    TIER_3(
        ValueRange.of(15, 24), 25
    );

    private final ValueRange range;
    private final int discount;

    public boolean isUpgradeNeeded(int inviteesAmount) {
        return !range.isValidIntValue(inviteesAmount);
    }

    public Tier next() {
        return ordinal() < values().length - 1 ? values()[ordinal() + 1] : TIER_3;
    }
}