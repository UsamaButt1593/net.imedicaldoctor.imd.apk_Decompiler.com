package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

public interface GifDecoder {

    /* renamed from: a  reason: collision with root package name */
    public static final int f17763a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f17764b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f17765c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f17766d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f17767e = 0;

    public interface BitmapProvider {
        @NonNull
        Bitmap a(int i2, int i3, @NonNull Bitmap.Config config);

        @NonNull
        int[] b(int i2);

        void c(@NonNull Bitmap bitmap);

        void d(@NonNull byte[] bArr);

        @NonNull
        byte[] e(int i2);

        void f(@NonNull int[] iArr);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GifDecodeStatus {
    }

    void clear();

    int d();

    int e(@Nullable InputStream inputStream, int i2);

    @Nullable
    Bitmap f();

    void g();

    @NonNull
    ByteBuffer getData();

    int getHeight();

    int getWidth();

    void h(@NonNull GifHeader gifHeader, @NonNull byte[] bArr);

    int i();

    int j();

    void k(@NonNull Bitmap.Config config);

    int l(int i2);

    void m();

    void n(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer);

    int o();

    void p(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i2);

    int q();

    int r();

    int read(@Nullable byte[] bArr);

    int s();

    @Deprecated
    int t();
}
