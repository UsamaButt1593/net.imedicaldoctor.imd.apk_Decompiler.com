package androidx.media3.extractor.avi;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.DummyExtractorOutput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

@UnstableApi
public final class AviExtractor implements Extractor {
    public static final int A = 1769369453;
    public static final int B = 829973609;
    public static final int C = 1263424842;
    public static final int D = 1718776947;
    public static final int E = 1852994675;
    public static final int F = 1752331379;
    public static final int G = 1935963489;
    public static final int H = 1937012852;
    public static final int I = 1935960438;
    private static final int J = 0;
    private static final int K = 1;
    private static final int L = 2;
    private static final int M = 3;
    private static final int N = 4;
    private static final int O = 5;
    private static final int P = 6;
    private static final int Q = 16;
    public static final int R = 1;
    private static final long S = 262144;
    private static final String t = "AviExtractor";
    public static final int u = 1179011410;
    public static final int v = 541677121;
    public static final int w = 1414744396;
    public static final int x = 1751742049;
    public static final int y = 1819436136;
    public static final int z = 1819440243;

    /* renamed from: d  reason: collision with root package name */
    private final ParsableByteArray f13191d;

    /* renamed from: e  reason: collision with root package name */
    private final ChunkHeaderHolder f13192e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f13193f;

    /* renamed from: g  reason: collision with root package name */
    private final SubtitleParser.Factory f13194g;

    /* renamed from: h  reason: collision with root package name */
    private int f13195h;

    /* renamed from: i  reason: collision with root package name */
    private ExtractorOutput f13196i;

    /* renamed from: j  reason: collision with root package name */
    private AviMainHeaderChunk f13197j;

    /* renamed from: k  reason: collision with root package name */
    private long f13198k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public ChunkReader[] f13199l;

    /* renamed from: m  reason: collision with root package name */
    private long f13200m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private ChunkReader f13201n;
    private int o;
    private long p;
    private long q;
    private int r;
    private boolean s;

    private class AviSeekMap implements SeekMap {

        /* renamed from: d  reason: collision with root package name */
        private final long f13202d;

        public AviSeekMap(long j2) {
            this.f13202d = j2;
        }

        public boolean g() {
            return true;
        }

        public SeekMap.SeekPoints j(long j2) {
            SeekMap.SeekPoints i2 = AviExtractor.this.f13199l[0].i(j2);
            for (int i3 = 1; i3 < AviExtractor.this.f13199l.length; i3++) {
                SeekMap.SeekPoints i4 = AviExtractor.this.f13199l[i3].i(j2);
                if (i4.f13112a.f13118b < i2.f13112a.f13118b) {
                    i2 = i4;
                }
            }
            return i2;
        }

        public long l() {
            return this.f13202d;
        }
    }

    private static class ChunkHeaderHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f13204a;

        /* renamed from: b  reason: collision with root package name */
        public int f13205b;

        /* renamed from: c  reason: collision with root package name */
        public int f13206c;

        private ChunkHeaderHolder() {
        }

        public void a(ParsableByteArray parsableByteArray) {
            this.f13204a = parsableByteArray.w();
            this.f13205b = parsableByteArray.w();
            this.f13206c = 0;
        }

        public void b(ParsableByteArray parsableByteArray) throws ParserException {
            a(parsableByteArray);
            if (this.f13204a == 1414744396) {
                this.f13206c = parsableByteArray.w();
                return;
            }
            throw ParserException.a("LIST expected, found: " + this.f13204a, (Throwable) null);
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Deprecated
    public AviExtractor() {
        this(1, SubtitleParser.Factory.f13783a);
    }

    private static void f(ExtractorInput extractorInput) throws IOException {
        if ((extractorInput.getPosition() & 1) == 1) {
            extractorInput.o(1);
        }
    }

    @Nullable
    private ChunkReader g(int i2) {
        for (ChunkReader chunkReader : this.f13199l) {
            if (chunkReader.j(i2)) {
                return chunkReader;
            }
        }
        return null;
    }

    private void j(ParsableByteArray parsableByteArray) throws IOException {
        ListChunk c2 = ListChunk.c(y, parsableByteArray);
        if (c2.getType() == 1819436136) {
            AviMainHeaderChunk aviMainHeaderChunk = (AviMainHeaderChunk) c2.b(AviMainHeaderChunk.class);
            if (aviMainHeaderChunk != null) {
                this.f13197j = aviMainHeaderChunk;
                this.f13198k = ((long) aviMainHeaderChunk.f13210c) * ((long) aviMainHeaderChunk.f13208a);
                ArrayList arrayList = new ArrayList();
                UnmodifiableIterator<AviChunk> k2 = c2.f13233a.iterator();
                int i2 = 0;
                while (k2.hasNext()) {
                    AviChunk next = k2.next();
                    if (next.getType() == 1819440243) {
                        int i3 = i2 + 1;
                        ChunkReader m2 = m((ListChunk) next, i2);
                        if (m2 != null) {
                            arrayList.add(m2);
                        }
                        i2 = i3;
                    }
                }
                this.f13199l = (ChunkReader[]) arrayList.toArray(new ChunkReader[0]);
                this.f13196i.o();
                return;
            }
            throw ParserException.a("AviHeader not found", (Throwable) null);
        }
        throw ParserException.a("Unexpected header list type " + c2.getType(), (Throwable) null);
    }

    private void k(ParsableByteArray parsableByteArray) {
        long l2 = l(parsableByteArray);
        while (parsableByteArray.a() >= 16) {
            int w2 = parsableByteArray.w();
            int w3 = parsableByteArray.w();
            long w4 = ((long) parsableByteArray.w()) + l2;
            parsableByteArray.w();
            ChunkReader g2 = g(w2);
            if (g2 != null) {
                if ((w3 & 16) == 16) {
                    g2.b(w4);
                }
                g2.k();
            }
        }
        for (ChunkReader c2 : this.f13199l) {
            c2.c();
        }
        this.s = true;
        this.f13196i.j(new AviSeekMap(this.f13198k));
    }

    private long l(ParsableByteArray parsableByteArray) {
        long j2 = 0;
        if (parsableByteArray.a() < 16) {
            return 0;
        }
        int f2 = parsableByteArray.f();
        parsableByteArray.Z(8);
        long j3 = this.p;
        if (((long) parsableByteArray.w()) <= j3) {
            j2 = j3 + 8;
        }
        parsableByteArray.Y(f2);
        return j2;
    }

    @Nullable
    private ChunkReader m(ListChunk listChunk, int i2) {
        String str;
        AviStreamHeaderChunk aviStreamHeaderChunk = (AviStreamHeaderChunk) listChunk.b(AviStreamHeaderChunk.class);
        StreamFormatChunk streamFormatChunk = (StreamFormatChunk) listChunk.b(StreamFormatChunk.class);
        if (aviStreamHeaderChunk == null) {
            str = "Missing Stream Header";
        } else if (streamFormatChunk == null) {
            str = "Missing Stream Format";
        } else {
            long a2 = aviStreamHeaderChunk.a();
            Format format = streamFormatChunk.f13236a;
            Format.Builder c2 = format.c();
            c2.W(i2);
            int i3 = aviStreamHeaderChunk.f13218f;
            if (i3 != 0) {
                c2.c0(i3);
            }
            StreamNameChunk streamNameChunk = (StreamNameChunk) listChunk.b(StreamNameChunk.class);
            if (streamNameChunk != null) {
                c2.Z(streamNameChunk.f13237a);
            }
            int l2 = MimeTypes.l(format.f3);
            if (l2 != 1 && l2 != 2) {
                return null;
            }
            TrackOutput d2 = this.f13196i.d(i2, l2);
            d2.e(c2.I());
            ChunkReader chunkReader = new ChunkReader(i2, l2, a2, aviStreamHeaderChunk.f13217e, d2);
            this.f13198k = a2;
            return chunkReader;
        }
        Log.n(t, str);
        return null;
    }

    private int n(ExtractorInput extractorInput) throws IOException {
        if (extractorInput.getPosition() >= this.q) {
            return -1;
        }
        ChunkReader chunkReader = this.f13201n;
        if (chunkReader == null) {
            f(extractorInput);
            int i2 = 12;
            extractorInput.s(this.f13191d.e(), 0, 12);
            this.f13191d.Y(0);
            int w2 = this.f13191d.w();
            if (w2 == 1414744396) {
                this.f13191d.Y(8);
                if (this.f13191d.w() != 1769369453) {
                    i2 = 8;
                }
                extractorInput.o(i2);
                extractorInput.n();
                return 0;
            }
            int w3 = this.f13191d.w();
            if (w2 == 1263424842) {
                this.f13200m = extractorInput.getPosition() + ((long) w3) + 8;
                return 0;
            }
            extractorInput.o(8);
            extractorInput.n();
            ChunkReader g2 = g(w2);
            if (g2 == null) {
                this.f13200m = extractorInput.getPosition() + ((long) w3);
                return 0;
            }
            g2.p(w3);
            this.f13201n = g2;
        } else if (chunkReader.o(extractorInput)) {
            this.f13201n = null;
        }
        return 0;
    }

    private boolean o(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z2;
        if (this.f13200m != -1) {
            long position = extractorInput.getPosition();
            long j2 = this.f13200m;
            if (j2 < position || j2 > 262144 + position) {
                positionHolder.f13111a = j2;
                z2 = true;
                this.f13200m = -1;
                return z2;
            }
            extractorInput.o((int) (j2 - position));
        }
        z2 = false;
        this.f13200m = -1;
        return z2;
    }

    public void a() {
    }

    public void c(long j2, long j3) {
        this.f13200m = -1;
        this.f13201n = null;
        for (ChunkReader q2 : this.f13199l) {
            q2.q(j2);
        }
        if (j2 != 0) {
            this.f13195h = 6;
        } else if (this.f13199l.length == 0) {
            this.f13195h = 0;
        } else {
            this.f13195h = 3;
        }
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f13195h = 0;
        if (this.f13193f) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f13194g);
        }
        this.f13196i = extractorOutput;
        this.f13200m = -1;
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        extractorInput.s(this.f13191d.e(), 0, 12);
        this.f13191d.Y(0);
        if (this.f13191d.w() != 1179011410) {
            return false;
        }
        this.f13191d.Z(4);
        return this.f13191d.w() == 541677121;
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        if (o(extractorInput, positionHolder)) {
            return 1;
        }
        switch (this.f13195h) {
            case 0:
                if (h(extractorInput)) {
                    extractorInput.o(12);
                    this.f13195h = 1;
                    return 0;
                }
                throw ParserException.a("AVI Header List not found", (Throwable) null);
            case 1:
                extractorInput.readFully(this.f13191d.e(), 0, 12);
                this.f13191d.Y(0);
                this.f13192e.b(this.f13191d);
                ChunkHeaderHolder chunkHeaderHolder = this.f13192e;
                if (chunkHeaderHolder.f13206c == 1819436136) {
                    this.o = chunkHeaderHolder.f13205b;
                    this.f13195h = 2;
                    return 0;
                }
                throw ParserException.a("hdrl expected, found: " + this.f13192e.f13206c, (Throwable) null);
            case 2:
                int i2 = this.o - 4;
                ParsableByteArray parsableByteArray = new ParsableByteArray(i2);
                extractorInput.readFully(parsableByteArray.e(), 0, i2);
                j(parsableByteArray);
                this.f13195h = 3;
                return 0;
            case 3:
                if (this.p != -1) {
                    long position = extractorInput.getPosition();
                    long j2 = this.p;
                    if (position != j2) {
                        this.f13200m = j2;
                        return 0;
                    }
                }
                extractorInput.s(this.f13191d.e(), 0, 12);
                extractorInput.n();
                this.f13191d.Y(0);
                this.f13192e.a(this.f13191d);
                int w2 = this.f13191d.w();
                int i3 = this.f13192e.f13204a;
                if (i3 == 1179011410) {
                    extractorInput.o(12);
                    return 0;
                } else if (i3 == 1414744396 && w2 == 1769369453) {
                    long position2 = extractorInput.getPosition();
                    this.p = position2;
                    this.q = position2 + ((long) this.f13192e.f13205b) + 8;
                    if (!this.s) {
                        if (((AviMainHeaderChunk) Assertions.g(this.f13197j)).a()) {
                            this.f13195h = 4;
                            this.f13200m = this.q;
                            return 0;
                        }
                        this.f13196i.j(new SeekMap.Unseekable(this.f13198k));
                        this.s = true;
                    }
                    this.f13200m = extractorInput.getPosition() + 12;
                    this.f13195h = 6;
                    return 0;
                } else {
                    this.f13200m = extractorInput.getPosition() + ((long) this.f13192e.f13205b) + 8;
                    return 0;
                }
            case 4:
                extractorInput.readFully(this.f13191d.e(), 0, 8);
                this.f13191d.Y(0);
                int w3 = this.f13191d.w();
                int w4 = this.f13191d.w();
                if (w3 == 829973609) {
                    this.f13195h = 5;
                    this.r = w4;
                } else {
                    this.f13200m = extractorInput.getPosition() + ((long) w4);
                }
                return 0;
            case 5:
                ParsableByteArray parsableByteArray2 = new ParsableByteArray(this.r);
                extractorInput.readFully(parsableByteArray2.e(), 0, this.r);
                k(parsableByteArray2);
                this.f13195h = 6;
                this.f13200m = this.p;
                return 0;
            case 6:
                return n(extractorInput);
            default:
                throw new AssertionError();
        }
    }

    public AviExtractor(int i2, SubtitleParser.Factory factory) {
        this.f13194g = factory;
        this.f13193f = (i2 & 1) != 0 ? false : true;
        this.f13191d = new ParsableByteArray(12);
        this.f13192e = new ChunkHeaderHolder();
        this.f13196i = new DummyExtractorOutput();
        this.f13199l = new ChunkReader[0];
        this.p = -1;
        this.q = -1;
        this.o = -1;
        this.f13198k = C.f9084b;
    }
}
