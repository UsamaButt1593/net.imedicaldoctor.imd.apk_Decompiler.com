package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public abstract class DataBufferRef {
    @NonNull
    @KeepForSdk

    /* renamed from: a  reason: collision with root package name */
    protected final DataHolder f20190a;
    @KeepForSdk

    /* renamed from: b  reason: collision with root package name */
    protected int f20191b;

    /* renamed from: c  reason: collision with root package name */
    private int f20192c;

    @KeepForSdk
    public DataBufferRef(@NonNull DataHolder dataHolder, int i2) {
        this.f20190a = (DataHolder) Preconditions.r(dataHolder);
        n(i2);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void a(@NonNull String str, @NonNull CharArrayBuffer charArrayBuffer) {
        this.f20190a.c0(str, this.f20191b, this.f20192c, charArrayBuffer);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public boolean b(@NonNull String str) {
        return this.f20190a.I(str, this.f20191b, this.f20192c);
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public byte[] c(@NonNull String str) {
        return this.f20190a.N(str, this.f20191b, this.f20192c);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public int d() {
        return this.f20191b;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public double e(@NonNull String str) {
        return this.f20190a.Z(str, this.f20191b, this.f20192c);
    }

    @KeepForSdk
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            return Objects.b(Integer.valueOf(dataBufferRef.f20191b), Integer.valueOf(this.f20191b)) && Objects.b(Integer.valueOf(dataBufferRef.f20192c), Integer.valueOf(this.f20192c)) && dataBufferRef.f20190a == this.f20190a;
        }
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public float f(@NonNull String str) {
        return this.f20190a.a0(str, this.f20191b, this.f20192c);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public int g(@NonNull String str) {
        return this.f20190a.O(str, this.f20191b, this.f20192c);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public long h(@NonNull String str) {
        return this.f20190a.P(str, this.f20191b, this.f20192c);
    }

    @KeepForSdk
    public int hashCode() {
        return Objects.c(Integer.valueOf(this.f20191b), Integer.valueOf(this.f20192c), this.f20190a);
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public String i(@NonNull String str) {
        return this.f20190a.R(str, this.f20191b, this.f20192c);
    }

    @KeepForSdk
    public boolean j(@NonNull String str) {
        return this.f20190a.T(str);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public boolean k(@NonNull String str) {
        return this.f20190a.W(str, this.f20191b, this.f20192c);
    }

    @KeepForSdk
    public boolean l() {
        return !this.f20190a.isClosed();
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    @Nullable
    public Uri m(@NonNull String str) {
        String R = this.f20190a.R(str, this.f20191b, this.f20192c);
        if (R == null) {
            return null;
        }
        return Uri.parse(R);
    }

    /* access modifiers changed from: protected */
    public final void n(int i2) {
        boolean z = false;
        if (i2 >= 0 && i2 < this.f20190a.getCount()) {
            z = true;
        }
        Preconditions.x(z);
        this.f20191b = i2;
        this.f20192c = this.f20190a.S(i2);
    }
}
