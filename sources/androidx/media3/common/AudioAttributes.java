package androidx.media3.common;

import android.media.AudioAttributes;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

public final class AudioAttributes implements Bundleable {
    public static final AudioAttributes Z2 = new Builder().a();
    private static final String a3 = Util.d1(0);
    private static final String b3 = Util.d1(1);
    private static final String c3 = Util.d1(2);
    private static final String d3 = Util.d1(3);
    private static final String e3 = Util.d1(4);
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<AudioAttributes> f3 = new C0141d();
    public final int X;
    public final int X2;
    public final int Y;
    @Nullable
    private AudioAttributesV21 Y2;
    public final int Z;
    public final int s;

    @RequiresApi(29)
    private static final class Api29 {
        private Api29() {
        }

        @DoNotInline
        public static void a(AudioAttributes.Builder builder, int i2) {
            AudioAttributes.Builder unused = builder.setAllowedCapturePolicy(i2);
        }
    }

    @RequiresApi(32)
    private static final class Api32 {
        private Api32() {
        }

        @DoNotInline
        public static void a(AudioAttributes.Builder builder, int i2) {
            AudioAttributes.Builder unused = builder.setSpatializationBehavior(i2);
        }
    }

    @RequiresApi(21)
    public static final class AudioAttributesV21 {

        /* renamed from: a  reason: collision with root package name */
        public final android.media.AudioAttributes f9067a;

        private AudioAttributesV21(AudioAttributes audioAttributes) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(audioAttributes.s).setFlags(audioAttributes.X).setUsage(audioAttributes.Y);
            int i2 = Util.f9646a;
            if (i2 >= 29) {
                Api29.a(usage, audioAttributes.Z);
            }
            if (i2 >= 32) {
                Api32.a(usage, audioAttributes.X2);
            }
            this.f9067a = usage.build();
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f9068a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f9069b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f9070c = 1;

        /* renamed from: d  reason: collision with root package name */
        private int f9071d = 1;

        /* renamed from: e  reason: collision with root package name */
        private int f9072e = 0;

        public AudioAttributes a() {
            return new AudioAttributes(this.f9068a, this.f9069b, this.f9070c, this.f9071d, this.f9072e);
        }

        @CanIgnoreReturnValue
        public Builder b(int i2) {
            this.f9071d = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder c(int i2) {
            this.f9068a = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder d(int i2) {
            this.f9069b = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder e(int i2) {
            this.f9072e = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder f(int i2) {
            this.f9070c = i2;
            return this;
        }
    }

    private AudioAttributes(int i2, int i3, int i4, int i5, int i6) {
        this.s = i2;
        this.X = i3;
        this.Y = i4;
        this.Z = i5;
        this.X2 = i6;
    }

    @UnstableApi
    public static AudioAttributes b(Bundle bundle) {
        Builder builder = new Builder();
        String str = a3;
        if (bundle.containsKey(str)) {
            builder.c(bundle.getInt(str));
        }
        String str2 = b3;
        if (bundle.containsKey(str2)) {
            builder.d(bundle.getInt(str2));
        }
        String str3 = c3;
        if (bundle.containsKey(str3)) {
            builder.f(bundle.getInt(str3));
        }
        String str4 = d3;
        if (bundle.containsKey(str4)) {
            builder.b(bundle.getInt(str4));
        }
        String str5 = e3;
        if (bundle.containsKey(str5)) {
            builder.e(bundle.getInt(str5));
        }
        return builder.a();
    }

    @UnstableApi
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(a3, this.s);
        bundle.putInt(b3, this.X);
        bundle.putInt(c3, this.Y);
        bundle.putInt(d3, this.Z);
        bundle.putInt(e3, this.X2);
        return bundle;
    }

    @RequiresApi(21)
    public AudioAttributesV21 c() {
        if (this.Y2 == null) {
            this.Y2 = new AudioAttributesV21();
        }
        return this.Y2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AudioAttributes.class != obj.getClass()) {
            return false;
        }
        AudioAttributes audioAttributes = (AudioAttributes) obj;
        return this.s == audioAttributes.s && this.X == audioAttributes.X && this.Y == audioAttributes.Y && this.Z == audioAttributes.Z && this.X2 == audioAttributes.X2;
    }

    public int hashCode() {
        return ((((((((MetaDo.w + this.s) * 31) + this.X) * 31) + this.Y) * 31) + this.Z) * 31) + this.X2;
    }
}
