package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class ParseRequest {

    /* renamed from: a  reason: collision with root package name */
    final String f22961a;

    /* renamed from: b  reason: collision with root package name */
    final int f22962b;

    private ParseRequest(String str, int i2) {
        this.f22961a = str;
        this.f22962b = i2;
    }

    static ParseRequest a(String str) {
        if (str.length() != 0) {
            char charAt = str.charAt(0);
            int i2 = 16;
            if (str.startsWith("0x") || str.startsWith("0X")) {
                str = str.substring(2);
            } else if (charAt == '#') {
                str = str.substring(1);
            } else if (charAt != '0' || str.length() <= 1) {
                i2 = 10;
            } else {
                str = str.substring(1);
                i2 = 8;
            }
            return new ParseRequest(str, i2);
        }
        throw new NumberFormatException("empty string");
    }
}
