package io.github.jesseYeh0319.ticketing.support;

import java.security.SecureRandom;
import java.util.UUID;

public final class UuidV7Generator {

    private static final SecureRandom RANDOM = new SecureRandom();

    private UuidV7Generator() {}

    /**
     * 產生出來的 UUID 前段隨時間遞增,後段隨機
     * */
    public static UUID generate() {
        long timestamp = System.currentTimeMillis();

        byte[] randomBytes = new byte[10];
        RANDOM.nextBytes(randomBytes);

        long mostSigBits = (timestamp << 16) & 0xFFFFFFFFFFFF0000L;
        mostSigBits |= 0x7000L; // version 7
        mostSigBits |= (randomBytes[0] & 0x0F);

        long leastSigBits = ((long) (randomBytes[1] & 0x3F) << 56) | 0x8000000000000000L; // variant
        for (int i = 2; i < 8; i++) {
            leastSigBits |= ((long) (randomBytes[i] & 0xFF)) << ((7 - i) * 8);
        }

        return new UUID(mostSigBits, leastSigBits);
    }
}