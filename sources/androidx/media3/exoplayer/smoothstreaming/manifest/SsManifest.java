package androidx.media3.exoplayer.smoothstreaming.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.UriUtil;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.offline.FilterableManifest;
import androidx.media3.extractor.mp4.TrackEncryptionBox;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@UnstableApi
public class SsManifest implements FilterableManifest<SsManifest> {

    /* renamed from: i  reason: collision with root package name */
    public static final int f12014i = -1;

    /* renamed from: a  reason: collision with root package name */
    public final int f12015a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12016b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12017c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f12018d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final ProtectionElement f12019e;

    /* renamed from: f  reason: collision with root package name */
    public final StreamElement[] f12020f;

    /* renamed from: g  reason: collision with root package name */
    public final long f12021g;

    /* renamed from: h  reason: collision with root package name */
    public final long f12022h;

    public static class ProtectionElement {

        /* renamed from: a  reason: collision with root package name */
        public final UUID f12023a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f12024b;

        /* renamed from: c  reason: collision with root package name */
        public final TrackEncryptionBox[] f12025c;

        public ProtectionElement(UUID uuid, byte[] bArr, TrackEncryptionBox[] trackEncryptionBoxArr) {
            this.f12023a = uuid;
            this.f12024b = bArr;
            this.f12025c = trackEncryptionBoxArr;
        }
    }

    public static class StreamElement {
        private static final String q = "{start time}";
        private static final String r = "{start_time}";
        private static final String s = "{bitrate}";
        private static final String t = "{Bitrate}";

        /* renamed from: a  reason: collision with root package name */
        public final int f12026a;

        /* renamed from: b  reason: collision with root package name */
        public final String f12027b;

        /* renamed from: c  reason: collision with root package name */
        public final long f12028c;

        /* renamed from: d  reason: collision with root package name */
        public final String f12029d;

        /* renamed from: e  reason: collision with root package name */
        public final int f12030e;

        /* renamed from: f  reason: collision with root package name */
        public final int f12031f;

        /* renamed from: g  reason: collision with root package name */
        public final int f12032g;

        /* renamed from: h  reason: collision with root package name */
        public final int f12033h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        public final String f12034i;

        /* renamed from: j  reason: collision with root package name */
        public final Format[] f12035j;

        /* renamed from: k  reason: collision with root package name */
        public final int f12036k;

        /* renamed from: l  reason: collision with root package name */
        private final String f12037l;

        /* renamed from: m  reason: collision with root package name */
        private final String f12038m;

        /* renamed from: n  reason: collision with root package name */
        private final List<Long> f12039n;
        private final long[] o;
        private final long p;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public StreamElement(String str, String str2, int i2, String str3, long j2, String str4, int i3, int i4, int i5, int i6, @Nullable String str5, Format[] formatArr, List<Long> list, long j3) {
            this(str, str2, i2, str3, j2, str4, i3, i4, i5, i6, str5, formatArr, list, Util.d2(list, 1000000, j2), Util.c2(j3, 1000000, j2));
            String str6 = str;
            String str7 = str2;
            int i7 = i2;
        }

        public Uri a(int i2, int i3) {
            boolean z = false;
            Assertions.i(this.f12035j != null);
            Assertions.i(this.f12039n != null);
            if (i3 < this.f12039n.size()) {
                z = true;
            }
            Assertions.i(z);
            String num = Integer.toString(this.f12035j[i2].b3);
            String l2 = this.f12039n.get(i3).toString();
            return UriUtil.g(this.f12037l, this.f12038m.replace(s, num).replace(t, num).replace(q, l2).replace(r, l2));
        }

        public StreamElement b(Format[] formatArr) {
            String str = this.f12037l;
            return new StreamElement(str, this.f12038m, this.f12026a, this.f12027b, this.f12028c, this.f12029d, this.f12030e, this.f12031f, this.f12032g, this.f12033h, this.f12034i, formatArr, this.f12039n, this.o, this.p);
        }

        public long c(int i2) {
            if (i2 == this.f12036k - 1) {
                return this.p;
            }
            long[] jArr = this.o;
            return jArr[i2 + 1] - jArr[i2];
        }

        public int d(long j2) {
            return Util.n(this.o, j2, true, true);
        }

        public long e(int i2) {
            return this.o[i2];
        }

        private StreamElement(String str, String str2, int i2, String str3, long j2, String str4, int i3, int i4, int i5, int i6, @Nullable String str5, Format[] formatArr, List<Long> list, long[] jArr, long j3) {
            this.f12037l = str;
            this.f12038m = str2;
            this.f12026a = i2;
            this.f12027b = str3;
            this.f12028c = j2;
            this.f12029d = str4;
            this.f12030e = i3;
            this.f12031f = i4;
            this.f12032g = i5;
            this.f12033h = i6;
            this.f12034i = str5;
            this.f12035j = formatArr;
            this.f12039n = list;
            this.o = jArr;
            this.p = j3;
            this.f12036k = list.size();
        }
    }

    private SsManifest(int i2, int i3, long j2, long j3, int i4, boolean z, @Nullable ProtectionElement protectionElement, StreamElement[] streamElementArr) {
        this.f12015a = i2;
        this.f12016b = i3;
        this.f12021g = j2;
        this.f12022h = j3;
        this.f12017c = i4;
        this.f12018d = z;
        this.f12019e = protectionElement;
        this.f12020f = streamElementArr;
    }

    /* renamed from: b */
    public final SsManifest a(List<StreamKey> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        StreamElement streamElement = null;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            StreamKey streamKey = (StreamKey) arrayList.get(i2);
            StreamElement streamElement2 = this.f12020f[streamKey.X];
            if (!(streamElement2 == streamElement || streamElement == null)) {
                arrayList2.add(streamElement.b((Format[]) arrayList3.toArray(new Format[0])));
                arrayList3.clear();
            }
            arrayList3.add(streamElement2.f12035j[streamKey.Y]);
            i2++;
            streamElement = streamElement2;
        }
        if (streamElement != null) {
            arrayList2.add(streamElement.b((Format[]) arrayList3.toArray(new Format[0])));
        }
        return new SsManifest(this.f12015a, this.f12016b, this.f12021g, this.f12022h, this.f12017c, this.f12018d, this.f12019e, (StreamElement[]) arrayList2.toArray(new StreamElement[0]));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SsManifest(int i2, int i3, long j2, long j3, long j4, int i4, boolean z, @Nullable ProtectionElement protectionElement, StreamElement[] streamElementArr) {
        this(i2, i3, j3 == 0 ? -9223372036854775807L : Util.c2(j3, 1000000, j2), j4 != 0 ? Util.c2(j4, 1000000, j2) : C.f9084b, i4, z, protectionElement, streamElementArr);
    }
}
