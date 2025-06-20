package com.google.android.gms.internal.common;

import com.dd.plist.ASCIIPropertyListParser;

final class zzl extends zzk {
    private final char zza;

    zzl(char c2) {
        this.zza = c2;
    }

    public final String toString() {
        char[] cArr = {ASCIIPropertyListParser.p, 'u', 0, 0, 0, 0};
        int i2 = this.zza;
        for (int i3 = 0; i3 < 4; i3++) {
            cArr[5 - i3] = BinTools.f30545a.charAt(i2 & 15);
            i2 >>= 4;
        }
        String copyValueOf = String.copyValueOf(cArr);
        return "CharMatcher.is('" + copyValueOf + "')";
    }

    public final boolean zza(char c2) {
        return c2 == this.zza;
    }
}
