package androidx.media3.exoplayer.source.mediaparser;

import android.annotation.SuppressLint;
import android.media.DrmInitData;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaParser;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.j;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.DummyExtractorOutput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.TrackOutput;
import com.google.common.collect.ImmutableList;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiresApi(30)
@UnstableApi
@SuppressLint({"Override"})
public final class OutputConsumerAdapterV30 implements MediaParser.OutputConsumer {
    private static final String A = "chunk-index-long-us-times";
    private static final Pattern B = Pattern.compile("pattern \\(encrypt: (\\d+), skip: (\\d+)\\)");
    private static final String u = "OConsumerAdapterV30";
    private static final Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> v = Pair.create(MediaParser.SeekPoint.START, MediaParser.SeekPoint.START);
    private static final String w = "track-type-string";
    private static final String x = "chunk-index-int-sizes";
    private static final String y = "chunk-index-long-offsets";
    private static final String z = "chunk-index-long-us-durations";

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<TrackOutput> f12312a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<Format> f12313b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<MediaCodec.CryptoInfo> f12314c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<TrackOutput.CryptoData> f12315d;

    /* renamed from: e  reason: collision with root package name */
    private final DataReaderAdapter f12316e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f12317f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12318g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final Format f12319h;

    /* renamed from: i  reason: collision with root package name */
    private ExtractorOutput f12320i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private MediaParser.SeekMap f12321j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private MediaParser.SeekMap f12322k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private String f12323l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private ChunkIndex f12324m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private TimestampAdjuster f12325n;
    private List<Format> o;
    private int p;
    private long q;
    private boolean r;
    private boolean s;
    private boolean t;

    private static final class DataReaderAdapter implements DataReader {
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public MediaParser.InputReader f12326b;

        private DataReaderAdapter() {
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            return n.a(Util.o(this.f12326b)).read(bArr, i2, i3);
        }
    }

    private static final class SeekMapAdapter implements SeekMap {

        /* renamed from: d  reason: collision with root package name */
        private final MediaParser.SeekMap f12327d;

        public SeekMapAdapter(MediaParser.SeekMap seekMap) {
            this.f12327d = seekMap;
        }

        private static SeekPoint a(MediaParser.SeekPoint seekPoint) {
            return new SeekPoint(seekPoint.timeMicros, seekPoint.position);
        }

        public boolean g() {
            return this.f12327d.isSeekable();
        }

        public SeekMap.SeekPoints j(long j2) {
            Pair a2 = this.f12327d.getSeekPoints(j2);
            Object obj = a2.first;
            return obj == a2.second ? new SeekMap.SeekPoints(a(j.a(obj))) : new SeekMap.SeekPoints(a(j.a(obj)), a(j.a(a2.second)));
        }

        public long l() {
            long a2 = this.f12327d.getDurationMicros();
            return a2 != -2147483648L ? a2 : C.f9084b;
        }
    }

    public OutputConsumerAdapterV30() {
        this((Format) null, -2, false);
    }

    private void b(int i2) {
        for (int size = this.f12312a.size(); size <= i2; size++) {
            this.f12312a.add((Object) null);
            this.f12313b.add((Object) null);
            this.f12314c.add((Object) null);
            this.f12315d.add((Object) null);
        }
    }

    private static int e(MediaFormat mediaFormat, String str, int i2) {
        if (mediaFormat.getInteger(str, 0) != 0) {
            return i2;
        }
        return 0;
    }

    private static List<byte[]> f(MediaFormat mediaFormat) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            StringBuilder sb = new StringBuilder();
            sb.append("csd-");
            int i3 = i2 + 1;
            sb.append(i2);
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(sb.toString());
            if (byteBuffer == null) {
                return arrayList;
            }
            arrayList.add(MediaFormatUtil.c(byteBuffer));
            i2 = i3;
        }
    }

    private static String g(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2063506020:
                if (str.equals("android.media.mediaparser.Mp4Parser")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1870824006:
                if (str.equals("android.media.mediaparser.OggParser")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1566427438:
                if (str.equals("android.media.mediaparser.TsParser")) {
                    c2 = 2;
                    break;
                }
                break;
            case -900207883:
                if (str.equals("android.media.mediaparser.AdtsParser")) {
                    c2 = 3;
                    break;
                }
                break;
            case -589864617:
                if (str.equals("android.media.mediaparser.WavParser")) {
                    c2 = 4;
                    break;
                }
                break;
            case 52265814:
                if (str.equals("android.media.mediaparser.PsParser")) {
                    c2 = 5;
                    break;
                }
                break;
            case 116768877:
                if (str.equals("android.media.mediaparser.FragmentedMp4Parser")) {
                    c2 = 6;
                    break;
                }
                break;
            case 376876796:
                if (str.equals("android.media.mediaparser.Ac3Parser")) {
                    c2 = 7;
                    break;
                }
                break;
            case 703268017:
                if (str.equals("android.media.mediaparser.AmrParser")) {
                    c2 = 8;
                    break;
                }
                break;
            case 768643067:
                if (str.equals("android.media.mediaparser.FlacParser")) {
                    c2 = 9;
                    break;
                }
                break;
            case 965962719:
                if (str.equals("android.media.mediaparser.MatroskaParser")) {
                    c2 = 10;
                    break;
                }
                break;
            case 1264380477:
                if (str.equals("android.media.mediaparser.Ac4Parser")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1343957595:
                if (str.equals("android.media.mediaparser.Mp3Parser")) {
                    c2 = 12;
                    break;
                }
                break;
            case 2063134683:
                if (str.equals("android.media.mediaparser.FlvParser")) {
                    c2 = 13;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 6:
                return MimeTypes.f9231f;
            case 1:
                return MimeTypes.h0;
            case 2:
                return MimeTypes.o;
            case 3:
                return MimeTypes.F;
            case 4:
                return MimeTypes.N;
            case 5:
                return MimeTypes.r;
            case 7:
                return MimeTypes.Q;
            case 8:
                return MimeTypes.b0;
            case 9:
                return MimeTypes.e0;
            case 10:
                return MimeTypes.f9233h;
            case 11:
                return MimeTypes.T;
            case 12:
                return MimeTypes.I;
            case 13:
                return MimeTypes.v;
            default:
                throw new IllegalArgumentException("Illegal parser name: " + str);
        }
    }

    private static int j(MediaFormat mediaFormat) {
        return e(mediaFormat, "is-forced-subtitle", 2) | e(mediaFormat, "is-autoselect", 4) | e(mediaFormat, "is-default", 1);
    }

    private void k() {
        if (this.r && !this.s) {
            int size = this.f12312a.size();
            int i2 = 0;
            while (i2 < size) {
                if (this.f12312a.get(i2) != null) {
                    i2++;
                } else {
                    return;
                }
            }
            this.f12320i.o();
            this.s = true;
        }
    }

    private boolean l(MediaFormat mediaFormat) {
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer(x);
        if (byteBuffer == null) {
            return false;
        }
        IntBuffer asIntBuffer = byteBuffer.asIntBuffer();
        LongBuffer asLongBuffer = ((ByteBuffer) Assertions.g(mediaFormat.getByteBuffer(y))).asLongBuffer();
        LongBuffer asLongBuffer2 = ((ByteBuffer) Assertions.g(mediaFormat.getByteBuffer(z))).asLongBuffer();
        LongBuffer asLongBuffer3 = ((ByteBuffer) Assertions.g(mediaFormat.getByteBuffer(A))).asLongBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        long[] jArr = new long[asLongBuffer.remaining()];
        long[] jArr2 = new long[asLongBuffer2.remaining()];
        long[] jArr3 = new long[asLongBuffer3.remaining()];
        asIntBuffer.get(iArr);
        asLongBuffer.get(jArr);
        asLongBuffer2.get(jArr2);
        asLongBuffer3.get(jArr3);
        ChunkIndex chunkIndex = new ChunkIndex(iArr, jArr, jArr2, jArr3);
        this.f12324m = chunkIndex;
        this.f12320i.j(chunkIndex);
        return true;
    }

    @Nullable
    private TrackOutput.CryptoData r(int i2, @Nullable MediaCodec.CryptoInfo cryptoInfo) {
        int i3;
        int i4;
        if (cryptoInfo == null) {
            return null;
        }
        if (this.f12314c.get(i2) == cryptoInfo) {
            return (TrackOutput.CryptoData) Assertions.g(this.f12315d.get(i2));
        }
        try {
            Matcher matcher = B.matcher(cryptoInfo.toString());
            matcher.find();
            i3 = Integer.parseInt((String) Util.o(matcher.group(1)));
            i4 = Integer.parseInt((String) Util.o(matcher.group(2)));
        } catch (RuntimeException e2) {
            Log.e(u, "Unexpected error while parsing CryptoInfo: " + cryptoInfo, e2);
            i3 = 0;
            i4 = 0;
        }
        TrackOutput.CryptoData cryptoData = new TrackOutput.CryptoData(cryptoInfo.mode, cryptoInfo.key, i3, i4);
        this.f12314c.set(i2, cryptoInfo);
        this.f12315d.set(i2, cryptoData);
        return cryptoData;
    }

    @Nullable
    private static DrmInitData s(@Nullable String str, @Nullable android.media.DrmInitData drmInitData) {
        if (drmInitData == null) {
            return null;
        }
        int a2 = drmInitData.getSchemeInitDataCount();
        DrmInitData.SchemeData[] schemeDataArr = new DrmInitData.SchemeData[a2];
        for (int i2 = 0; i2 < a2; i2++) {
            DrmInitData.SchemeInitData a3 = drmInitData.getSchemeInitDataAt(i2);
            schemeDataArr[i2] = new DrmInitData.SchemeData(a3.uuid, a3.mimeType, a3.data);
        }
        return new androidx.media3.common.DrmInitData(str, schemeDataArr);
    }

    private Format t(MediaParser.TrackData trackData) {
        MediaFormat a2 = trackData.mediaFormat;
        String string = a2.getString(Annotation.w3);
        int a3 = a2.getInteger("caption-service-number", -1);
        int i2 = 0;
        Format.Builder J = new Format.Builder().R(s(a2.getString("crypto-mode-fourcc"), trackData.drmInitData)).O(this.f12323l).f0(a2.getInteger("bitrate", -1)).L(a2.getInteger("channel-count", -1)).N(MediaFormatUtil.d(a2)).k0(string).M(a2.getString("codecs-string")).U(a2.getFloat("frame-rate", -1.0f)).r0(a2.getInteger("width", -1)).V(a2.getInteger("height", -1)).Y(f(a2)).b0(a2.getString(DublinCoreProperties.f27402h)).c0(a2.getInteger("max-input-size", -1)).e0(a2.getInteger("exo-pcm-encoding", -1)).j0(a2.getInteger("rotation-degrees", 0)).l0(a2.getInteger("sample-rate", -1)).m0(j(a2)).S(a2.getInteger("encoder-delay", 0)).T(a2.getInteger("encoder-padding", 0)).g0(a2.getFloat("pixel-width-height-ratio-float", 1.0f)).o0(a2.getLong("subsample-offset-us-long", Long.MAX_VALUE)).J(a3);
        while (true) {
            if (i2 >= this.o.size()) {
                break;
            }
            Format format = this.o.get(i2);
            if (Util.g(format.f3, string) && format.x3 == a3) {
                J.b0(format.Z).i0(format.Y2).m0(format.X2).Z(format.X).a0(format.Y).d0(format.d3);
                break;
            }
            i2++;
        }
        return J.I();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int u(@androidx.annotation.Nullable java.lang.String r5) {
        /*
            r0 = 3
            r1 = 2
            r2 = 1
            r3 = -1
            if (r5 != 0) goto L_0x0007
            return r3
        L_0x0007:
            int r4 = r5.hashCode()
            switch(r4) {
                case -450004177: goto L_0x003c;
                case -284840886: goto L_0x0031;
                case 3556653: goto L_0x0026;
                case 93166550: goto L_0x001b;
                case 112202875: goto L_0x0010;
                default: goto L_0x000e;
            }
        L_0x000e:
            r4 = -1
            goto L_0x0046
        L_0x0010:
            java.lang.String r4 = "video"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x0019
            goto L_0x000e
        L_0x0019:
            r4 = 4
            goto L_0x0046
        L_0x001b:
            java.lang.String r4 = "audio"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x0024
            goto L_0x000e
        L_0x0024:
            r4 = 3
            goto L_0x0046
        L_0x0026:
            java.lang.String r4 = "text"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x002f
            goto L_0x000e
        L_0x002f:
            r4 = 2
            goto L_0x0046
        L_0x0031:
            java.lang.String r4 = "unknown"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x003a
            goto L_0x000e
        L_0x003a:
            r4 = 1
            goto L_0x0046
        L_0x003c:
            java.lang.String r4 = "metadata"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x0045
            goto L_0x000e
        L_0x0045:
            r4 = 0
        L_0x0046:
            switch(r4) {
                case 0: goto L_0x0052;
                case 1: goto L_0x0051;
                case 2: goto L_0x0050;
                case 3: goto L_0x004f;
                case 4: goto L_0x004e;
                default: goto L_0x0049;
            }
        L_0x0049:
            int r5 = androidx.media3.common.MimeTypes.l(r5)
            return r5
        L_0x004e:
            return r1
        L_0x004f:
            return r2
        L_0x0050:
            return r0
        L_0x0051:
            return r3
        L_0x0052:
            r5 = 5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.mediaparser.OutputConsumerAdapterV30.u(java.lang.String):int");
    }

    public void a() {
        this.t = true;
    }

    @Nullable
    public ChunkIndex c() {
        return this.f12324m;
    }

    @Nullable
    public MediaParser.SeekMap d() {
        return this.f12321j;
    }

    @Nullable
    public Format[] h() {
        if (!this.r) {
            return null;
        }
        Format[] formatArr = new Format[this.f12313b.size()];
        for (int i2 = 0; i2 < this.f12313b.size(); i2++) {
            formatArr[i2] = (Format) Assertions.g(this.f12313b.get(i2));
        }
        return formatArr;
    }

    public Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> i(long j2) {
        MediaParser.SeekMap seekMap = this.f12322k;
        return seekMap != null ? seekMap.getSeekPoints(j2) : v;
    }

    public void m(ExtractorOutput extractorOutput) {
        this.f12320i = extractorOutput;
    }

    public void n(List<Format> list) {
        this.o = list;
    }

    public void o(long j2) {
        this.q = j2;
    }

    public void onSampleCompleted(int i2, long j2, int i3, int i4, int i5, @Nullable MediaCodec.CryptoInfo cryptoInfo) {
        long j3 = this.q;
        if (j3 == C.f9084b || j2 < j3) {
            TimestampAdjuster timestampAdjuster = this.f12325n;
            if (timestampAdjuster != null) {
                j2 = timestampAdjuster.a(j2);
            }
            ((TrackOutput) Assertions.g(this.f12312a.get(i2))).f(j2, i3, i4, i5, r(i2, cryptoInfo));
        }
    }

    public void onSampleDataFound(int i2, MediaParser.InputReader inputReader) throws IOException {
        b(i2);
        this.f12316e.f12326b = inputReader;
        TrackOutput trackOutput = this.f12312a.get(i2);
        if (trackOutput == null) {
            trackOutput = this.f12320i.d(i2, -1);
            this.f12312a.set(i2, trackOutput);
        }
        trackOutput.b(this.f12316e, (int) inputReader.getLength(), true);
    }

    public void onSeekMapFound(MediaParser.SeekMap seekMap) {
        SeekMap seekMap2;
        if (!this.f12317f || this.f12321j != null) {
            this.f12322k = seekMap;
            long a2 = seekMap.getDurationMicros();
            ExtractorOutput extractorOutput = this.f12320i;
            if (this.t) {
                if (a2 == -2147483648L) {
                    a2 = C.f9084b;
                }
                seekMap2 = new SeekMap.Unseekable(a2);
            } else {
                seekMap2 = new SeekMapAdapter(seekMap);
            }
            extractorOutput.j(seekMap2);
            return;
        }
        this.f12321j = seekMap;
    }

    public void onTrackCountFound(int i2) {
        this.r = true;
        k();
    }

    public void onTrackDataFound(int i2, MediaParser.TrackData trackData) {
        if (!l(trackData.mediaFormat)) {
            b(i2);
            TrackOutput trackOutput = this.f12312a.get(i2);
            if (trackOutput == null) {
                String string = trackData.mediaFormat.getString(w);
                int u2 = u(string != null ? string : trackData.mediaFormat.getString(Annotation.w3));
                if (u2 == this.f12318g) {
                    this.p = i2;
                }
                TrackOutput d2 = this.f12320i.d(i2, u2);
                this.f12312a.set(i2, d2);
                if (string == null) {
                    trackOutput = d2;
                } else {
                    return;
                }
            }
            Format t2 = t(trackData);
            Format format = this.f12319h;
            trackOutput.e((format == null || i2 != this.p) ? t2 : t2.n(format));
            this.f12313b.set(i2, t2);
            k();
        }
    }

    public void p(String str) {
        this.f12323l = g(str);
    }

    public void q(TimestampAdjuster timestampAdjuster) {
        this.f12325n = timestampAdjuster;
    }

    public OutputConsumerAdapterV30(@Nullable Format format, int i2, boolean z2) {
        this.f12317f = z2;
        this.f12319h = format;
        this.f12318g = i2;
        this.f12312a = new ArrayList<>();
        this.f12313b = new ArrayList<>();
        this.f12314c = new ArrayList<>();
        this.f12315d = new ArrayList<>();
        this.f12316e = new DataReaderAdapter();
        this.f12320i = new DummyExtractorOutput();
        this.q = C.f9084b;
        this.o = ImmutableList.I();
    }
}
