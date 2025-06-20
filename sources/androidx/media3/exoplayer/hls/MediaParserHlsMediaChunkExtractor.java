package androidx.media3.exoplayer.hls;

import android.annotation.SuppressLint;
import android.media.MediaFormat;
import android.media.MediaParser;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.media3.common.FileTypes;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.mediaparser.InputReaderAdapterV30;
import androidx.media3.exoplayer.source.mediaparser.MediaParserUtil;
import androidx.media3.exoplayer.source.mediaparser.OutputConsumerAdapterV30;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequiresApi(30)
@UnstableApi
public final class MediaParserHlsMediaChunkExtractor implements HlsMediaChunkExtractor {

    /* renamed from: i  reason: collision with root package name */
    public static final HlsExtractorFactory f11435i = new m();

    /* renamed from: a  reason: collision with root package name */
    private final OutputConsumerAdapterV30 f11436a;

    /* renamed from: b  reason: collision with root package name */
    private final InputReaderAdapterV30 f11437b = new InputReaderAdapterV30();

    /* renamed from: c  reason: collision with root package name */
    private final MediaParser f11438c;

    /* renamed from: d  reason: collision with root package name */
    private final Format f11439d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f11440e;

    /* renamed from: f  reason: collision with root package name */
    private final ImmutableList<MediaFormat> f11441f;

    /* renamed from: g  reason: collision with root package name */
    private final PlayerId f11442g;

    /* renamed from: h  reason: collision with root package name */
    private int f11443h;

    private static final class PeekingInputReader implements MediaParser.SeekableInputReader {

        /* renamed from: a  reason: collision with root package name */
        private final ExtractorInput f11444a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f11445b;

        private PeekingInputReader(ExtractorInput extractorInput) {
            this.f11444a = extractorInput;
        }

        public long getLength() {
            return this.f11444a.getLength();
        }

        public long getPosition() {
            return this.f11444a.i();
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int m2 = this.f11444a.m(bArr, i2, i3);
            this.f11445b += m2;
            return m2;
        }

        public void seekToPosition(long j2) {
            throw new UnsupportedOperationException();
        }
    }

    public MediaParserHlsMediaChunkExtractor(MediaParser mediaParser, OutputConsumerAdapterV30 outputConsumerAdapterV30, Format format, boolean z, ImmutableList<MediaFormat> immutableList, int i2, PlayerId playerId) {
        this.f11438c = mediaParser;
        this.f11436a = outputConsumerAdapterV30;
        this.f11440e = z;
        this.f11441f = immutableList;
        this.f11439d = format;
        this.f11442g = playerId;
        this.f11443h = i2;
    }

    @SuppressLint({"WrongConstant"})
    private static MediaParser c(MediaParser.OutputConsumer outputConsumer, Format format, boolean z, ImmutableList<MediaFormat> immutableList, PlayerId playerId, String... strArr) {
        MediaParser a2 = strArr.length == 1 ? MediaParser.createByName(strArr[0], outputConsumer) : MediaParser.create(outputConsumer, strArr);
        MediaParser unused = a2.setParameter(MediaParserUtil.f12310g, immutableList);
        MediaParser unused2 = a2.setParameter(MediaParserUtil.f12309f, Boolean.valueOf(z));
        Boolean bool = Boolean.TRUE;
        MediaParser unused3 = a2.setParameter(MediaParserUtil.f12304a, bool);
        MediaParser unused4 = a2.setParameter(MediaParserUtil.f12306c, bool);
        MediaParser unused5 = a2.setParameter(MediaParserUtil.f12311h, bool);
        MediaParser unused6 = a2.setParameter("android.media.mediaparser.ts.ignoreSpliceInfoStream", bool);
        MediaParser unused7 = a2.setParameter("android.media.mediaparser.ts.mode", "hls");
        String str = format.c3;
        if (!TextUtils.isEmpty(str)) {
            if (!MimeTypes.F.equals(MimeTypes.c(str))) {
                MediaParser unused8 = a2.setParameter("android.media.mediaparser.ts.ignoreAacStream", bool);
            }
            if (!MimeTypes.f9235j.equals(MimeTypes.o(str))) {
                MediaParser unused9 = a2.setParameter("android.media.mediaparser.ts.ignoreAvcStream", bool);
            }
        }
        if (Util.f9646a >= 31) {
            MediaParserUtil.a(a2, playerId);
        }
        return a2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ HlsMediaChunkExtractor i(Uri uri, Format format, List list, TimestampAdjuster timestampAdjuster, Map map, ExtractorInput extractorInput, PlayerId playerId) throws IOException {
        if (FileTypes.a(format.f3) == 13) {
            return new BundledHlsMediaChunkExtractor(new WebvttExtractor(format.Z, timestampAdjuster, SubtitleParser.Factory.f13783a, false), format, timestampAdjuster);
        }
        boolean z = list != null;
        ImmutableList.Builder r = ImmutableList.r();
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                r.g(MediaParserUtil.b((Format) list.get(i2)));
            }
        } else {
            r.g(MediaParserUtil.b(new Format.Builder().k0(MimeTypes.w0).I()));
        }
        ImmutableList n2 = r.e();
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = new OutputConsumerAdapterV30();
        if (list == null) {
            list = ImmutableList.I();
        }
        outputConsumerAdapterV30.n(list);
        outputConsumerAdapterV30.q(timestampAdjuster);
        MediaParser c2 = c(outputConsumerAdapterV30, format, z, n2, playerId, "android.media.mediaparser.FragmentedMp4Parser", "android.media.mediaparser.Ac3Parser", "android.media.mediaparser.Ac4Parser", "android.media.mediaparser.AdtsParser", "android.media.mediaparser.Mp3Parser", "android.media.mediaparser.TsParser");
        PeekingInputReader peekingInputReader = new PeekingInputReader(extractorInput);
        boolean unused = c2.advance(peekingInputReader);
        outputConsumerAdapterV30.p(c2.getParserName());
        return new MediaParserHlsMediaChunkExtractor(c2, outputConsumerAdapterV30, format, z, n2, peekingInputReader.f11445b, playerId);
    }

    public boolean b(ExtractorInput extractorInput) throws IOException {
        extractorInput.o(this.f11443h);
        this.f11443h = 0;
        this.f11437b.c(extractorInput, extractorInput.getLength());
        return this.f11438c.advance(this.f11437b);
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f11436a.m(extractorOutput);
    }

    public void e() {
        this.f11438c.seek(MediaParser.SeekPoint.START);
    }

    public boolean f() {
        String a2 = this.f11438c.getParserName();
        return "android.media.mediaparser.Ac3Parser".equals(a2) || "android.media.mediaparser.Ac4Parser".equals(a2) || "android.media.mediaparser.AdtsParser".equals(a2) || "android.media.mediaparser.Mp3Parser".equals(a2);
    }

    public boolean g() {
        String a2 = this.f11438c.getParserName();
        return "android.media.mediaparser.FragmentedMp4Parser".equals(a2) || "android.media.mediaparser.TsParser".equals(a2);
    }

    public HlsMediaChunkExtractor h() {
        Assertions.i(!g());
        return new MediaParserHlsMediaChunkExtractor(c(this.f11436a, this.f11439d, this.f11440e, this.f11441f, this.f11442g, this.f11438c.getParserName()), this.f11436a, this.f11439d, this.f11440e, this.f11441f, 0, this.f11442g);
    }
}
