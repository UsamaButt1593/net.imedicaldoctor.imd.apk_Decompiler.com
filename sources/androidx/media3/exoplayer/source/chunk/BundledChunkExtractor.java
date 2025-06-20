package androidx.media3.exoplayer.source.chunk;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.DummyTrackOutput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.g;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

@UnstableApi
public final class BundledChunkExtractor implements ExtractorOutput, ChunkExtractor {
    public static final Factory c3 = new Factory();
    private static final PositionHolder d3 = new PositionHolder();
    private final int X;
    private boolean X2;
    private final Format Y;
    @Nullable
    private ChunkExtractor.TrackOutputProvider Y2;
    private final SparseArray<BindingTrackOutput> Z = new SparseArray<>();
    private long Z2;
    private SeekMap a3;
    private Format[] b3;
    private final Extractor s;

    private static final class BindingTrackOutput implements TrackOutput {

        /* renamed from: d  reason: collision with root package name */
        private final int f12269d;

        /* renamed from: e  reason: collision with root package name */
        private final int f12270e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private final Format f12271f;

        /* renamed from: g  reason: collision with root package name */
        private final DummyTrackOutput f12272g = new DummyTrackOutput();

        /* renamed from: h  reason: collision with root package name */
        public Format f12273h;

        /* renamed from: i  reason: collision with root package name */
        private TrackOutput f12274i;

        /* renamed from: j  reason: collision with root package name */
        private long f12275j;

        public BindingTrackOutput(int i2, int i3, @Nullable Format format) {
            this.f12269d = i2;
            this.f12270e = i3;
            this.f12271f = format;
        }

        public void a(ParsableByteArray parsableByteArray, int i2, int i3) {
            ((TrackOutput) Util.o(this.f12274i)).d(parsableByteArray, i2);
        }

        public /* synthetic */ int b(DataReader dataReader, int i2, boolean z) {
            return g.a(this, dataReader, i2, z);
        }

        public int c(DataReader dataReader, int i2, boolean z, int i3) throws IOException {
            return ((TrackOutput) Util.o(this.f12274i)).b(dataReader, i2, z);
        }

        public /* synthetic */ void d(ParsableByteArray parsableByteArray, int i2) {
            g.b(this, parsableByteArray, i2);
        }

        public void e(Format format) {
            Format format2 = this.f12271f;
            if (format2 != null) {
                format = format.n(format2);
            }
            this.f12273h = format;
            ((TrackOutput) Util.o(this.f12274i)).e(this.f12273h);
        }

        public void f(long j2, int i2, int i3, int i4, @Nullable TrackOutput.CryptoData cryptoData) {
            long j3 = this.f12275j;
            if (j3 != C.f9084b && j2 >= j3) {
                this.f12274i = this.f12272g;
            }
            ((TrackOutput) Util.o(this.f12274i)).f(j2, i2, i3, i4, cryptoData);
        }

        public void g(@Nullable ChunkExtractor.TrackOutputProvider trackOutputProvider, long j2) {
            if (trackOutputProvider == null) {
                this.f12274i = this.f12272g;
                return;
            }
            this.f12275j = j2;
            TrackOutput d2 = trackOutputProvider.d(this.f12269d, this.f12270e);
            this.f12274i = d2;
            Format format = this.f12273h;
            if (format != null) {
                d2.e(format);
            }
        }
    }

    public static final class Factory implements ChunkExtractor.Factory {

        /* renamed from: a  reason: collision with root package name */
        private SubtitleParser.Factory f12276a = new DefaultSubtitleParserFactory();

        /* renamed from: b  reason: collision with root package name */
        private boolean f12277b;

        public Format c(Format format) {
            String str;
            if (!this.f12277b || !this.f12276a.b(format)) {
                return format;
            }
            Format.Builder Q = format.c().k0(MimeTypes.O0).Q(this.f12276a.a(format));
            StringBuilder sb = new StringBuilder();
            sb.append(format.f3);
            if (format.c3 != null) {
                str = StringUtils.SPACE + format.c3;
            } else {
                str = "";
            }
            sb.append(str);
            return Q.M(sb.toString()).o0(Long.MAX_VALUE).I();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: androidx.media3.extractor.text.SubtitleTranscodingExtractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: androidx.media3.extractor.text.SubtitleTranscodingExtractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: androidx.media3.extractor.jpeg.JpegExtractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: androidx.media3.extractor.mkv.MatroskaExtractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: androidx.media3.extractor.text.SubtitleExtractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v21, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v22, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v23, resolved type: androidx.media3.extractor.mp4.FragmentedMp4Extractor} */
        /* JADX WARNING: type inference failed for: r10v10, types: [androidx.media3.extractor.png.PngExtractor] */
        /* JADX WARNING: Multi-variable type inference failed */
        @androidx.annotation.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.media3.exoplayer.source.chunk.ChunkExtractor d(int r8, androidx.media3.common.Format r9, boolean r10, java.util.List<androidx.media3.common.Format> r11, @androidx.annotation.Nullable androidx.media3.extractor.TrackOutput r12, androidx.media3.exoplayer.analytics.PlayerId r13) {
            /*
                r7 = this;
                java.lang.String r13 = r9.e3
                boolean r0 = androidx.media3.common.MimeTypes.s(r13)
                if (r0 == 0) goto L_0x001a
                boolean r10 = r7.f12277b
                if (r10 != 0) goto L_0x000e
                r8 = 0
                return r8
            L_0x000e:
                androidx.media3.extractor.text.SubtitleExtractor r10 = new androidx.media3.extractor.text.SubtitleExtractor
                androidx.media3.extractor.text.SubtitleParser$Factory r11 = r7.f12276a
                androidx.media3.extractor.text.SubtitleParser r11 = r11.c(r9)
                r10.<init>(r11, r9)
                goto L_0x0062
            L_0x001a:
                boolean r0 = androidx.media3.common.MimeTypes.r(r13)
                r1 = 1
                if (r0 == 0) goto L_0x002e
                boolean r10 = r7.f12277b
                if (r10 != 0) goto L_0x0026
                r1 = 3
            L_0x0026:
                androidx.media3.extractor.mkv.MatroskaExtractor r10 = new androidx.media3.extractor.mkv.MatroskaExtractor
                androidx.media3.extractor.text.SubtitleParser$Factory r11 = r7.f12276a
                r10.<init>(r11, r1)
                goto L_0x0062
            L_0x002e:
                java.lang.String r0 = "image/jpeg"
                boolean r0 = java.util.Objects.equals(r13, r0)
                if (r0 == 0) goto L_0x003c
                androidx.media3.extractor.jpeg.JpegExtractor r10 = new androidx.media3.extractor.jpeg.JpegExtractor
                r10.<init>(r1)
                goto L_0x0062
            L_0x003c:
                java.lang.String r0 = "image/png"
                boolean r0 = java.util.Objects.equals(r13, r0)
                if (r0 == 0) goto L_0x004a
                androidx.media3.extractor.png.PngExtractor r10 = new androidx.media3.extractor.png.PngExtractor
                r10.<init>()
                goto L_0x0062
            L_0x004a:
                if (r10 == 0) goto L_0x004e
                r10 = 4
                goto L_0x004f
            L_0x004e:
                r10 = 0
            L_0x004f:
                boolean r0 = r7.f12277b
                if (r0 != 0) goto L_0x0055
                r10 = r10 | 32
            L_0x0055:
                r2 = r10
                androidx.media3.extractor.mp4.FragmentedMp4Extractor r10 = new androidx.media3.extractor.mp4.FragmentedMp4Extractor
                androidx.media3.extractor.text.SubtitleParser$Factory r1 = r7.f12276a
                r3 = 0
                r4 = 0
                r0 = r10
                r5 = r11
                r6 = r12
                r0.<init>(r1, r2, r3, r4, r5, r6)
            L_0x0062:
                boolean r11 = r7.f12277b
                if (r11 == 0) goto L_0x0084
                boolean r11 = androidx.media3.common.MimeTypes.s(r13)
                if (r11 != 0) goto L_0x0084
                androidx.media3.extractor.Extractor r11 = r10.e()
                boolean r11 = r11 instanceof androidx.media3.extractor.mp4.FragmentedMp4Extractor
                if (r11 != 0) goto L_0x0084
                androidx.media3.extractor.Extractor r11 = r10.e()
                boolean r11 = r11 instanceof androidx.media3.extractor.mkv.MatroskaExtractor
                if (r11 != 0) goto L_0x0084
                androidx.media3.extractor.text.SubtitleTranscodingExtractor r11 = new androidx.media3.extractor.text.SubtitleTranscodingExtractor
                androidx.media3.extractor.text.SubtitleParser$Factory r12 = r7.f12276a
                r11.<init>(r10, r12)
                r10 = r11
            L_0x0084:
                androidx.media3.exoplayer.source.chunk.BundledChunkExtractor r11 = new androidx.media3.exoplayer.source.chunk.BundledChunkExtractor
                r11.<init>(r10, r8, r9)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.chunk.BundledChunkExtractor.Factory.d(int, androidx.media3.common.Format, boolean, java.util.List, androidx.media3.extractor.TrackOutput, androidx.media3.exoplayer.analytics.PlayerId):androidx.media3.exoplayer.source.chunk.ChunkExtractor");
        }

        @CanIgnoreReturnValue
        /* renamed from: e */
        public Factory b(boolean z) {
            this.f12277b = z;
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: f */
        public Factory a(SubtitleParser.Factory factory) {
            this.f12276a = (SubtitleParser.Factory) Assertions.g(factory);
            return this;
        }
    }

    public BundledChunkExtractor(Extractor extractor, int i2, Format format) {
        this.s = extractor;
        this.X = i2;
        this.Y = format;
    }

    public void a() {
        this.s.a();
    }

    public boolean b(ExtractorInput extractorInput) throws IOException {
        int i2 = this.s.i(extractorInput, d3);
        Assertions.i(i2 != 1);
        return i2 == 0;
    }

    @Nullable
    public Format[] c() {
        return this.b3;
    }

    public TrackOutput d(int i2, int i3) {
        BindingTrackOutput bindingTrackOutput = this.Z.get(i2);
        if (bindingTrackOutput == null) {
            Assertions.i(this.b3 == null);
            bindingTrackOutput = new BindingTrackOutput(i2, i3, i3 == this.X ? this.Y : null);
            bindingTrackOutput.g(this.Y2, this.Z2);
            this.Z.put(i2, bindingTrackOutput);
        }
        return bindingTrackOutput;
    }

    public void e(@Nullable ChunkExtractor.TrackOutputProvider trackOutputProvider, long j2, long j3) {
        this.Y2 = trackOutputProvider;
        this.Z2 = j3;
        if (!this.X2) {
            this.s.d(this);
            if (j2 != C.f9084b) {
                this.s.c(0, j2);
            }
            this.X2 = true;
            return;
        }
        Extractor extractor = this.s;
        if (j2 == C.f9084b) {
            j2 = 0;
        }
        extractor.c(0, j2);
        for (int i2 = 0; i2 < this.Z.size(); i2++) {
            this.Z.valueAt(i2).g(trackOutputProvider, j3);
        }
    }

    @Nullable
    public ChunkIndex f() {
        SeekMap seekMap = this.a3;
        if (seekMap instanceof ChunkIndex) {
            return (ChunkIndex) seekMap;
        }
        return null;
    }

    public void j(SeekMap seekMap) {
        this.a3 = seekMap;
    }

    public void o() {
        Format[] formatArr = new Format[this.Z.size()];
        for (int i2 = 0; i2 < this.Z.size(); i2++) {
            formatArr[i2] = (Format) Assertions.k(this.Z.valueAt(i2).f12273h);
        }
        this.b3 = formatArr;
    }
}
