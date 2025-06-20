package androidx.media3.exoplayer.hls;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import androidx.media3.extractor.text.webvtt.WebvttParserUtil;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class WebvttExtractor implements Extractor {

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f11544l = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f11545m = Pattern.compile("MPEGTS:(-?\\d+)");

    /* renamed from: n  reason: collision with root package name */
    private static final int f11546n = 6;
    private static final int o = 9;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f11547d;

    /* renamed from: e  reason: collision with root package name */
    private final TimestampAdjuster f11548e;

    /* renamed from: f  reason: collision with root package name */
    private final ParsableByteArray f11549f;

    /* renamed from: g  reason: collision with root package name */
    private final SubtitleParser.Factory f11550g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f11551h;

    /* renamed from: i  reason: collision with root package name */
    private ExtractorOutput f11552i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f11553j;

    /* renamed from: k  reason: collision with root package name */
    private int f11554k;

    @Deprecated
    public WebvttExtractor(@Nullable String str, TimestampAdjuster timestampAdjuster) {
        this(str, timestampAdjuster, SubtitleParser.Factory.f13783a, false);
    }

    @RequiresNonNull({"output"})
    private TrackOutput b(long j2) {
        TrackOutput d2 = this.f11552i.d(0, 3);
        d2.e(new Format.Builder().k0(MimeTypes.m0).b0(this.f11547d).o0(j2).I());
        this.f11552i.o();
        return d2;
    }

    @RequiresNonNull({"output"})
    private void f() throws ParserException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.f11553j);
        WebvttParserUtil.e(parsableByteArray);
        long j2 = 0;
        long j3 = 0;
        for (String u = parsableByteArray.u(); !TextUtils.isEmpty(u); u = parsableByteArray.u()) {
            if (u.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f11544l.matcher(u);
                if (matcher.find()) {
                    Matcher matcher2 = f11545m.matcher(u);
                    if (matcher2.find()) {
                        j3 = WebvttParserUtil.d((String) Assertions.g(matcher.group(1)));
                        j2 = TimestampAdjuster.h(Long.parseLong((String) Assertions.g(matcher2.group(1))));
                    } else {
                        throw ParserException.a("X-TIMESTAMP-MAP doesn't contain media timestamp: " + u, (Throwable) null);
                    }
                } else {
                    throw ParserException.a("X-TIMESTAMP-MAP doesn't contain local timestamp: " + u, (Throwable) null);
                }
            }
        }
        Matcher a2 = WebvttParserUtil.a(parsableByteArray);
        if (a2 == null) {
            b(0);
            return;
        }
        long d2 = WebvttParserUtil.d((String) Assertions.g(a2.group(1)));
        long b2 = this.f11548e.b(TimestampAdjuster.l((j2 + d2) - j3));
        TrackOutput b3 = b(b2 - d2);
        this.f11549f.W(this.f11553j, this.f11554k);
        b3.d(this.f11549f, this.f11554k);
        b3.f(b2, 1, this.f11554k, 0, (TrackOutput.CryptoData) null);
    }

    public void a() {
    }

    public void c(long j2, long j3) {
        throw new IllegalStateException();
    }

    public void d(ExtractorOutput extractorOutput) {
        this.f11552i = this.f11551h ? new SubtitleTranscodingExtractorOutput(extractorOutput, this.f11550g) : extractorOutput;
        extractorOutput.j(new SeekMap.Unseekable(C.f9084b));
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        extractorInput.h(this.f11553j, 0, 6, false);
        this.f11549f.W(this.f11553j, 6);
        if (WebvttParserUtil.b(this.f11549f)) {
            return true;
        }
        extractorInput.h(this.f11553j, 6, 3, false);
        this.f11549f.W(this.f11553j, 9);
        return WebvttParserUtil.b(this.f11549f);
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.g(this.f11552i);
        int length = (int) extractorInput.getLength();
        int i2 = this.f11554k;
        byte[] bArr = this.f11553j;
        if (i2 == bArr.length) {
            this.f11553j = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.f11553j;
        int i3 = this.f11554k;
        int read = extractorInput.read(bArr2, i3, bArr2.length - i3);
        if (read != -1) {
            int i4 = this.f11554k + read;
            this.f11554k = i4;
            if (length == -1 || i4 != length) {
                return 0;
            }
        }
        f();
        return -1;
    }

    public WebvttExtractor(@Nullable String str, TimestampAdjuster timestampAdjuster, SubtitleParser.Factory factory, boolean z) {
        this.f11547d = str;
        this.f11548e = timestampAdjuster;
        this.f11549f = new ParsableByteArray();
        this.f11553j = new byte[1024];
        this.f11550g = factory;
        this.f11551h = z;
    }
}
