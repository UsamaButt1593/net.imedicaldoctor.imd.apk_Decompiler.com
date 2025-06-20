package androidx.media3.extractor;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.flac.PictureFrame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
public final class FlacStreamMetadata {

    /* renamed from: m  reason: collision with root package name */
    private static final String f13047m = "FlacStreamMetadata";

    /* renamed from: n  reason: collision with root package name */
    public static final int f13048n = -1;

    /* renamed from: a  reason: collision with root package name */
    public final int f13049a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13050b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13051c;

    /* renamed from: d  reason: collision with root package name */
    public final int f13052d;

    /* renamed from: e  reason: collision with root package name */
    public final int f13053e;

    /* renamed from: f  reason: collision with root package name */
    public final int f13054f;

    /* renamed from: g  reason: collision with root package name */
    public final int f13055g;

    /* renamed from: h  reason: collision with root package name */
    public final int f13056h;

    /* renamed from: i  reason: collision with root package name */
    public final int f13057i;

    /* renamed from: j  reason: collision with root package name */
    public final long f13058j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public final SeekTable f13059k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private final Metadata f13060l;

    public static class SeekTable {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f13061a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f13062b;

        public SeekTable(long[] jArr, long[] jArr2) {
            this.f13061a = jArr;
            this.f13062b = jArr2;
        }
    }

    private FlacStreamMetadata(int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, @Nullable SeekTable seekTable, @Nullable Metadata metadata) {
        this.f13049a = i2;
        this.f13050b = i3;
        this.f13051c = i4;
        this.f13052d = i5;
        this.f13053e = i6;
        this.f13054f = m(i6);
        this.f13055g = i7;
        this.f13056h = i8;
        this.f13057i = f(i8);
        this.f13058j = j2;
        this.f13059k = seekTable;
        this.f13060l = metadata;
    }

    @Nullable
    private static Metadata a(List<String> list, List<PictureFrame> list2) {
        Metadata d2 = VorbisUtil.d(list);
        if (d2 != null || !list2.isEmpty()) {
            return new Metadata((List<? extends Metadata.Entry>) list2).b(d2);
        }
        return null;
    }

    private static int f(int i2) {
        if (i2 == 8) {
            return 1;
        }
        if (i2 == 12) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 != 20) {
            return i2 != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int m(int i2) {
        switch (i2) {
            case 8000:
                return 4;
            case AacUtil.f12877g:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case OpusUtil.f13107a /*48000*/:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case DtsUtil.f13020f:
                return 3;
            default:
                return -1;
        }
    }

    public FlacStreamMetadata b(List<PictureFrame> list) {
        return new FlacStreamMetadata(this.f13049a, this.f13050b, this.f13051c, this.f13052d, this.f13053e, this.f13055g, this.f13056h, this.f13058j, this.f13059k, k(new Metadata((List<? extends Metadata.Entry>) list)));
    }

    public FlacStreamMetadata c(@Nullable SeekTable seekTable) {
        return new FlacStreamMetadata(this.f13049a, this.f13050b, this.f13051c, this.f13052d, this.f13053e, this.f13055g, this.f13056h, this.f13058j, seekTable, this.f13060l);
    }

    public FlacStreamMetadata d(List<String> list) {
        return new FlacStreamMetadata(this.f13049a, this.f13050b, this.f13051c, this.f13052d, this.f13053e, this.f13055g, this.f13056h, this.f13058j, this.f13059k, k(VorbisUtil.d(list)));
    }

    public long e() {
        long j2;
        long j3;
        int i2 = this.f13052d;
        if (i2 > 0) {
            j2 = (((long) i2) + ((long) this.f13051c)) / 2;
            j3 = 1;
        } else {
            int i3 = this.f13049a;
            j2 = ((((i3 != this.f13050b || i3 <= 0) ? PlaybackStateCompat.r3 : (long) i3) * ((long) this.f13055g)) * ((long) this.f13056h)) / 8;
            j3 = 64;
        }
        return j2 + j3;
    }

    public int g() {
        return this.f13056h * this.f13053e * this.f13055g;
    }

    public long h() {
        long j2 = this.f13058j;
        return j2 == 0 ? C.f9084b : (j2 * 1000000) / ((long) this.f13053e);
    }

    public Format i(byte[] bArr, @Nullable Metadata metadata) {
        bArr[4] = Byte.MIN_VALUE;
        int i2 = this.f13052d;
        if (i2 <= 0) {
            i2 = -1;
        }
        return new Format.Builder().k0(MimeTypes.e0).c0(i2).L(this.f13055g).l0(this.f13053e).e0(Util.C0(this.f13056h)).Y(Collections.singletonList(bArr)).d0(k(metadata)).I();
    }

    public int j() {
        return this.f13050b * this.f13055g * (this.f13056h / 8);
    }

    @Nullable
    public Metadata k(@Nullable Metadata metadata) {
        Metadata metadata2 = this.f13060l;
        return metadata2 == null ? metadata : metadata2.b(metadata);
    }

    public long l(long j2) {
        return Util.x((j2 * ((long) this.f13053e)) / 1000000, 0, this.f13058j - 1);
    }

    public FlacStreamMetadata(int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, ArrayList<String> arrayList, ArrayList<PictureFrame> arrayList2) {
        this(i2, i3, i4, i5, i6, i7, i8, j2, (SeekTable) null, a(arrayList, arrayList2));
    }

    public FlacStreamMetadata(byte[] bArr, int i2) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.q(i2 * 8);
        this.f13049a = parsableBitArray.h(16);
        this.f13050b = parsableBitArray.h(16);
        this.f13051c = parsableBitArray.h(24);
        this.f13052d = parsableBitArray.h(24);
        int h2 = parsableBitArray.h(20);
        this.f13053e = h2;
        this.f13054f = m(h2);
        this.f13055g = parsableBitArray.h(3) + 1;
        int h3 = parsableBitArray.h(5) + 1;
        this.f13056h = h3;
        this.f13057i = f(h3);
        this.f13058j = parsableBitArray.j(36);
        this.f13059k = null;
        this.f13060l = null;
    }
}
