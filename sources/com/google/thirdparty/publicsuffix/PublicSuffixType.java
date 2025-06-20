package com.google.thirdparty.publicsuffix;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@Beta
public enum PublicSuffixType {
    PRIVATE(ASCIIPropertyListParser.A, ASCIIPropertyListParser.f18651i),
    REGISTRY('!', '?');
    
    private final char X;
    private final char s;

    private PublicSuffixType(char c2, char c3) {
        this.s = c2;
        this.X = c3;
    }

    static PublicSuffixType b(char c2) {
        for (PublicSuffixType publicSuffixType : values()) {
            if (publicSuffixType.c() == c2 || publicSuffixType.e() == c2) {
                return publicSuffixType;
            }
        }
        throw new IllegalArgumentException("No enum corresponding to given code: " + c2);
    }

    /* access modifiers changed from: package-private */
    public char c() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public char e() {
        return this.X;
    }
}
