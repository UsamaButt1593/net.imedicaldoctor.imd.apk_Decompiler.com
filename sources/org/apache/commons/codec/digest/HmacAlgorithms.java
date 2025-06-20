package org.apache.commons.codec.digest;

import net.lingala.zip4j.util.InternalZipConstants;

public enum HmacAlgorithms {
    HMAC_MD5("HmacMD5"),
    HMAC_SHA_1(InternalZipConstants.f30712f),
    HMAC_SHA_224("HmacSHA224"),
    HMAC_SHA_256("HmacSHA256"),
    HMAC_SHA_384("HmacSHA384"),
    HMAC_SHA_512("HmacSHA512");
    
    private final String name;

    private HmacAlgorithms(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}
