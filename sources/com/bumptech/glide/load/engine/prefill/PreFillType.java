package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;
import com.dd.plist.ASCIIPropertyListParser;

public final class PreFillType {
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    static final Bitmap.Config f18107e = Bitmap.Config.RGB_565;

    /* renamed from: a  reason: collision with root package name */
    private final int f18108a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18109b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap.Config f18110c;

    /* renamed from: d  reason: collision with root package name */
    private final int f18111d;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final int f18112a;

        /* renamed from: b  reason: collision with root package name */
        private final int f18113b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f18114c;

        /* renamed from: d  reason: collision with root package name */
        private int f18115d;

        public Builder(int i2) {
            this(i2, i2);
        }

        /* access modifiers changed from: package-private */
        public PreFillType a() {
            return new PreFillType(this.f18112a, this.f18113b, this.f18114c, this.f18115d);
        }

        /* access modifiers changed from: package-private */
        public Bitmap.Config b() {
            return this.f18114c;
        }

        public Builder c(@Nullable Bitmap.Config config) {
            this.f18114c = config;
            return this;
        }

        public Builder d(int i2) {
            if (i2 > 0) {
                this.f18115d = i2;
                return this;
            }
            throw new IllegalArgumentException("Weight must be > 0");
        }

        public Builder(int i2, int i3) {
            this.f18115d = 1;
            if (i2 <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            } else if (i3 > 0) {
                this.f18112a = i2;
                this.f18113b = i3;
            } else {
                throw new IllegalArgumentException("Height must be > 0");
            }
        }
    }

    PreFillType(int i2, int i3, Bitmap.Config config, int i4) {
        this.f18110c = (Bitmap.Config) Preconditions.e(config, "Config must not be null");
        this.f18108a = i2;
        this.f18109b = i3;
        this.f18111d = i4;
    }

    /* access modifiers changed from: package-private */
    public Bitmap.Config a() {
        return this.f18110c;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f18109b;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f18111d;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f18108a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PreFillType)) {
            return false;
        }
        PreFillType preFillType = (PreFillType) obj;
        return this.f18109b == preFillType.f18109b && this.f18108a == preFillType.f18108a && this.f18111d == preFillType.f18111d && this.f18110c == preFillType.f18110c;
    }

    public int hashCode() {
        return (((((this.f18108a * 31) + this.f18109b) * 31) + this.f18110c.hashCode()) * 31) + this.f18111d;
    }

    public String toString() {
        return "PreFillSize{width=" + this.f18108a + ", height=" + this.f18109b + ", config=" + this.f18110c + ", weight=" + this.f18111d + ASCIIPropertyListParser.f18653k;
    }
}
