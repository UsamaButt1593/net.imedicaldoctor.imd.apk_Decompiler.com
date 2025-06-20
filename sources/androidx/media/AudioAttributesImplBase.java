package androidx.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImpl;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.util.Arrays;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AudioAttributesImplBase implements AudioAttributesImpl {
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: a  reason: collision with root package name */
    public int f8874a;
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: b  reason: collision with root package name */
    public int f8875b;
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: c  reason: collision with root package name */
    public int f8876c;
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: d  reason: collision with root package name */
    public int f8877d;

    static class Builder implements AudioAttributesImpl.Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f8878a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f8879b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f8880c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f8881d = -1;

        Builder() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0021, code lost:
            r3.f8879b = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0024, code lost:
            r3.f8879b = 4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0037, code lost:
            r3.f8878a = androidx.media.AudioAttributesImplBase.a(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x003d, code lost:
            return r3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private androidx.media.AudioAttributesImplBase.Builder g(int r4) {
            /*
                r3 = this;
                r0 = 1
                r1 = 4
                switch(r4) {
                    case 0: goto L_0x0021;
                    case 1: goto L_0x0024;
                    case 2: goto L_0x0024;
                    case 3: goto L_0x0035;
                    case 4: goto L_0x0024;
                    case 5: goto L_0x0024;
                    case 6: goto L_0x002d;
                    case 7: goto L_0x0027;
                    case 8: goto L_0x0024;
                    case 9: goto L_0x0024;
                    case 10: goto L_0x0021;
                    default: goto L_0x0005;
                }
            L_0x0005:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Invalid stream type "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r1 = " for AudioAttributesCompat"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "AudioAttributesCompat"
                android.util.Log.e(r1, r0)
                goto L_0x0037
            L_0x0021:
                r3.f8879b = r0
                goto L_0x0037
            L_0x0024:
                r3.f8879b = r1
                goto L_0x0037
            L_0x0027:
                int r2 = r3.f8880c
                r0 = r0 | r2
                r3.f8880c = r0
                goto L_0x0024
            L_0x002d:
                r3.f8879b = r0
                int r0 = r3.f8880c
                r0 = r0 | r1
                r3.f8880c = r0
                goto L_0x0037
            L_0x0035:
                r0 = 2
                goto L_0x0021
            L_0x0037:
                int r4 = androidx.media.AudioAttributesImplBase.a(r4)
                r3.f8878a = r4
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media.AudioAttributesImplBase.Builder.g(int):androidx.media.AudioAttributesImplBase$Builder");
        }

        @NonNull
        public AudioAttributesImpl build() {
            return new AudioAttributesImplBase(this.f8879b, this.f8880c, this.f8878a, this.f8881d);
        }

        @NonNull
        /* renamed from: e */
        public Builder b(int i2) {
            if (!(i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4)) {
                i2 = 0;
            }
            this.f8879b = i2;
            return this;
        }

        @NonNull
        /* renamed from: f */
        public Builder c(int i2) {
            this.f8880c = (i2 & AnalyticsListener.c0) | this.f8880c;
            return this;
        }

        @NonNull
        /* renamed from: h */
        public Builder a(int i2) {
            if (i2 != 10) {
                this.f8881d = i2;
                return g(i2);
            }
            throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
        }

        @NonNull
        /* renamed from: i */
        public Builder d(int i2) {
            switch (i2) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    break;
                case 16:
                    i2 = 12;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            this.f8878a = i2;
            return this;
        }

        Builder(AudioAttributesCompat audioAttributesCompat) {
            this.f8878a = audioAttributesCompat.g();
            this.f8879b = audioAttributesCompat.getContentType();
            this.f8880c = audioAttributesCompat.j();
            this.f8881d = audioAttributesCompat.f();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AudioAttributesImplBase() {
        this.f8874a = 0;
        this.f8875b = 0;
        this.f8876c = 0;
        this.f8877d = -1;
    }

    static int a(int i2) {
        switch (i2) {
            case 0:
                return 2;
            case 1:
            case 7:
                return 13;
            case 2:
                return 6;
            case 3:
                return 1;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 2;
            case 8:
                return 3;
            case 10:
                return 11;
            default:
                return 0;
        }
    }

    @Nullable
    public Object d() {
        return null;
    }

    public int e() {
        int i2 = this.f8877d;
        return i2 != -1 ? i2 : AudioAttributesCompat.b(false, this.f8876c, this.f8874a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f8875b == audioAttributesImplBase.getContentType() && this.f8876c == audioAttributesImplBase.j() && this.f8874a == audioAttributesImplBase.g() && this.f8877d == audioAttributesImplBase.f8877d;
    }

    public int f() {
        return this.f8877d;
    }

    public int g() {
        return this.f8874a;
    }

    public int getContentType() {
        return this.f8875b;
    }

    public int h() {
        return AudioAttributesCompat.b(true, this.f8876c, this.f8874a);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8875b), Integer.valueOf(this.f8876c), Integer.valueOf(this.f8874a), Integer.valueOf(this.f8877d)});
    }

    public int j() {
        int i2 = this.f8876c;
        int e2 = e();
        if (e2 == 6) {
            i2 |= 4;
        } else if (e2 == 7) {
            i2 |= 1;
        }
        return i2 & TIFFConstants.h0;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f8877d != -1) {
            sb.append(" stream=");
            sb.append(this.f8877d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.i(this.f8874a));
        sb.append(" content=");
        sb.append(this.f8875b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f8876c).toUpperCase());
        return sb.toString();
    }

    AudioAttributesImplBase(int i2, int i3, int i4, int i5) {
        this.f8875b = i2;
        this.f8876c = i3;
        this.f8874a = i4;
        this.f8877d = i5;
    }
}
