package androidx.media3.extractor.mp4;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public final class Track {

    /* renamed from: l  reason: collision with root package name */
    public static final int f13656l = 0;

    /* renamed from: m  reason: collision with root package name */
    public static final int f13657m = 1;

    /* renamed from: a  reason: collision with root package name */
    public final int f13658a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13659b;

    /* renamed from: c  reason: collision with root package name */
    public final long f13660c;

    /* renamed from: d  reason: collision with root package name */
    public final long f13661d;

    /* renamed from: e  reason: collision with root package name */
    public final long f13662e;

    /* renamed from: f  reason: collision with root package name */
    public final Format f13663f;

    /* renamed from: g  reason: collision with root package name */
    public final int f13664g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final long[] f13665h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final long[] f13666i;

    /* renamed from: j  reason: collision with root package name */
    public final int f13667j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private final TrackEncryptionBox[] f13668k;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Transformation {
    }

    public Track(int i2, int i3, long j2, long j3, long j4, Format format, int i4, @Nullable TrackEncryptionBox[] trackEncryptionBoxArr, int i5, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.f13658a = i2;
        this.f13659b = i3;
        this.f13660c = j2;
        this.f13661d = j3;
        this.f13662e = j4;
        this.f13663f = format;
        this.f13664g = i4;
        this.f13668k = trackEncryptionBoxArr;
        this.f13667j = i5;
        this.f13665h = jArr;
        this.f13666i = jArr2;
    }

    public Track a(Format format) {
        return new Track(this.f13658a, this.f13659b, this.f13660c, this.f13661d, this.f13662e, format, this.f13664g, this.f13668k, this.f13667j, this.f13665h, this.f13666i);
    }

    @Nullable
    public TrackEncryptionBox b(int i2) {
        TrackEncryptionBox[] trackEncryptionBoxArr = this.f13668k;
        if (trackEncryptionBoxArr == null) {
            return null;
        }
        return trackEncryptionBoxArr[i2];
    }
}
