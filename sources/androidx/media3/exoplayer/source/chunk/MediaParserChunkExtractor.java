package androidx.media3.exoplayer.source.chunk;

import android.annotation.SuppressLint;
import android.media.MediaParser;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.exoplayer.source.j;
import androidx.media3.exoplayer.source.mediaparser.InputReaderAdapterV30;
import androidx.media3.exoplayer.source.mediaparser.MediaParserUtil;
import androidx.media3.exoplayer.source.mediaparser.OutputConsumerAdapterV30;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.DummyTrackOutput;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(30)
@UnstableApi
public final class MediaParserChunkExtractor implements ChunkExtractor {
    private static final String b3 = "MediaPrsrChunkExtractor";
    public static final ChunkExtractor.Factory c3 = new c();
    private final InputReaderAdapterV30 X = new InputReaderAdapterV30();
    /* access modifiers changed from: private */
    public final DummyTrackOutput X2;
    private final MediaParser Y;
    private long Y2;
    private final TrackOutputProviderAdapter Z;
    /* access modifiers changed from: private */
    @Nullable
    public ChunkExtractor.TrackOutputProvider Z2;
    /* access modifiers changed from: private */
    @Nullable
    public Format[] a3;
    /* access modifiers changed from: private */
    public final OutputConsumerAdapterV30 s;

    private class TrackOutputProviderAdapter implements ExtractorOutput {
        private TrackOutputProviderAdapter() {
        }

        public TrackOutput d(int i2, int i3) {
            return MediaParserChunkExtractor.this.Z2 != null ? MediaParserChunkExtractor.this.Z2.d(i2, i3) : MediaParserChunkExtractor.this.X2;
        }

        public void j(SeekMap seekMap) {
        }

        public void o() {
            MediaParserChunkExtractor mediaParserChunkExtractor = MediaParserChunkExtractor.this;
            Format[] unused = mediaParserChunkExtractor.a3 = mediaParserChunkExtractor.s.h();
        }
    }

    @SuppressLint({"WrongConstant"})
    public MediaParserChunkExtractor(int i2, Format format, List<Format> list, PlayerId playerId) {
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = new OutputConsumerAdapterV30(format, i2, true);
        this.s = outputConsumerAdapterV30;
        String str = MimeTypes.r((String) Assertions.g(format.e3)) ? "android.media.mediaparser.MatroskaParser" : "android.media.mediaparser.FragmentedMp4Parser";
        outputConsumerAdapterV30.p(str);
        MediaParser a2 = MediaParser.createByName(str, outputConsumerAdapterV30);
        this.Y = a2;
        Boolean bool = Boolean.TRUE;
        MediaParser unused = a2.setParameter("android.media.mediaparser.matroska.disableCuesSeeking", bool);
        MediaParser unused2 = a2.setParameter(MediaParserUtil.f12304a, bool);
        MediaParser unused3 = a2.setParameter(MediaParserUtil.f12305b, bool);
        MediaParser unused4 = a2.setParameter(MediaParserUtil.f12306c, bool);
        MediaParser unused5 = a2.setParameter(MediaParserUtil.f12307d, bool);
        MediaParser unused6 = a2.setParameter(MediaParserUtil.f12308e, bool);
        MediaParser unused7 = a2.setParameter(MediaParserUtil.f12309f, bool);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            arrayList.add(MediaParserUtil.b(list.get(i3)));
        }
        MediaParser unused8 = this.Y.setParameter(MediaParserUtil.f12310g, arrayList);
        if (Util.f9646a >= 31) {
            MediaParserUtil.a(this.Y, playerId);
        }
        this.s.n(list);
        this.Z = new TrackOutputProviderAdapter();
        this.X2 = new DummyTrackOutput();
        this.Y2 = C.f9084b;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ChunkExtractor k(int i2, Format format, boolean z, List list, TrackOutput trackOutput, PlayerId playerId) {
        if (!MimeTypes.s(format.e3)) {
            return new MediaParserChunkExtractor(i2, format, list, playerId);
        }
        return null;
    }

    private void l() {
        MediaParser.SeekMap d2 = this.s.d();
        long j2 = this.Y2;
        if (j2 != C.f9084b && d2 != null) {
            this.Y.seek(j.a(d2.getSeekPoints(j2).first));
            this.Y2 = C.f9084b;
        }
    }

    public void a() {
        this.Y.release();
    }

    public boolean b(ExtractorInput extractorInput) throws IOException {
        l();
        this.X.c(extractorInput, extractorInput.getLength());
        return this.Y.advance(this.X);
    }

    @Nullable
    public Format[] c() {
        return this.a3;
    }

    public void e(@Nullable ChunkExtractor.TrackOutputProvider trackOutputProvider, long j2, long j3) {
        this.Z2 = trackOutputProvider;
        this.s.o(j3);
        this.s.m(this.Z);
        this.Y2 = j2;
    }

    @Nullable
    public ChunkIndex f() {
        return this.s.c();
    }
}
