package com.google.android.gms.common.images;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class Size {

    /* renamed from: a  reason: collision with root package name */
    private final int f20208a;

    /* renamed from: b  reason: collision with root package name */
    private final int f20209b;

    public Size(int i2, int i3) {
        this.f20208a = i2;
        this.f20209b = i3;
    }

    @NonNull
    public static Size c(@NonNull String str) throws NumberFormatException {
        if (str != null) {
            int indexOf = str.indexOf(42);
            if (indexOf < 0) {
                indexOf = str.indexOf(120);
            }
            if (indexOf >= 0) {
                try {
                    return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
                } catch (NumberFormatException unused) {
                    throw d(str);
                }
            } else {
                throw d(str);
            }
        } else {
            throw new IllegalArgumentException("string must not be null");
        }
    }

    private static NumberFormatException d(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 16);
        sb.append("Invalid Size: \"");
        sb.append(str);
        sb.append("\"");
        throw new NumberFormatException(sb.toString());
    }

    public int a() {
        return this.f20209b;
    }

    public int b() {
        return this.f20208a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.f20208a == size.f20208a && this.f20209b == size.f20209b;
        }
    }

    public int hashCode() {
        int i2 = this.f20209b;
        int i3 = this.f20208a;
        return i2 ^ ((i3 >>> 16) | (i3 << 16));
    }

    @NonNull
    public String toString() {
        int i2 = this.f20208a;
        int i3 = this.f20209b;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i2);
        sb.append("x");
        sb.append(i3);
        return sb.toString();
    }
}
