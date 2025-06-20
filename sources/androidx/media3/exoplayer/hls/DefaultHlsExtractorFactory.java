package androidx.media3.exoplayer.hls;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.FileTypes;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.mp3.Mp3Extractor;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.mp4.Track;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.ts.Ac3Extractor;
import androidx.media3.extractor.ts.Ac4Extractor;
import androidx.media3.extractor.ts.AdtsExtractor;
import androidx.media3.extractor.ts.DefaultTsPayloadReaderFactory;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

@UnstableApi
public final class DefaultHlsExtractorFactory implements HlsExtractorFactory {

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f11376f = {8, 13, 11, 2, 0, 1, 7};

    /* renamed from: b  reason: collision with root package name */
    private final int f11377b;

    /* renamed from: c  reason: collision with root package name */
    private SubtitleParser.Factory f11378c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11379d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f11380e;

    public DefaultHlsExtractorFactory() {
        this(0, true);
    }

    private static void e(int i2, List<Integer> list) {
        if (Ints.m(f11376f, i2) != -1 && !list.contains(Integer.valueOf(i2))) {
            list.add(Integer.valueOf(i2));
        }
    }

    @SuppressLint({"SwitchIntDef"})
    @Nullable
    private Extractor g(int i2, Format format, @Nullable List<Format> list, TimestampAdjuster timestampAdjuster) {
        if (i2 == 0) {
            return new Ac3Extractor();
        }
        if (i2 == 1) {
            return new Ac4Extractor();
        }
        if (i2 == 2) {
            return new AdtsExtractor();
        }
        if (i2 == 7) {
            return new Mp3Extractor(0, 0);
        }
        if (i2 == 8) {
            return h(this.f11378c, this.f11379d, timestampAdjuster, format, list);
        }
        if (i2 == 11) {
            return i(this.f11377b, this.f11380e, format, list, timestampAdjuster, this.f11378c, this.f11379d);
        } else if (i2 != 13) {
            return null;
        } else {
            return new WebvttExtractor(format.Z, timestampAdjuster, this.f11378c, this.f11379d);
        }
    }

    private static FragmentedMp4Extractor h(SubtitleParser.Factory factory, boolean z, TimestampAdjuster timestampAdjuster, Format format, @Nullable List<Format> list) {
        int i2 = k(format) ? 4 : 0;
        if (!z) {
            factory = SubtitleParser.Factory.f13783a;
            i2 |= 32;
        }
        SubtitleParser.Factory factory2 = factory;
        int i3 = i2;
        if (list == null) {
            list = ImmutableList.I();
        }
        return new FragmentedMp4Extractor(factory2, i3, timestampAdjuster, (Track) null, list, (TrackOutput) null);
    }

    private static TsExtractor i(int i2, boolean z, Format format, @Nullable List<Format> list, TimestampAdjuster timestampAdjuster, SubtitleParser.Factory factory, boolean z2) {
        SubtitleParser.Factory factory2;
        int i3;
        int i4 = i2 | 16;
        if (list != null) {
            i4 = i2 | 48;
        } else {
            list = z ? Collections.singletonList(new Format.Builder().k0(MimeTypes.w0).I()) : Collections.emptyList();
        }
        String str = format.c3;
        if (!TextUtils.isEmpty(str)) {
            if (!MimeTypes.b(str, MimeTypes.F)) {
                i4 |= 2;
            }
            if (!MimeTypes.b(str, MimeTypes.f9235j)) {
                i4 |= 4;
            }
        }
        if (!z2) {
            factory2 = SubtitleParser.Factory.f13783a;
            i3 = 1;
        } else {
            factory2 = factory;
            i3 = 0;
        }
        return new TsExtractor(2, i3, factory2, timestampAdjuster, new DefaultTsPayloadReaderFactory(i4, list), TsExtractor.E);
    }

    private static boolean k(Format format) {
        Metadata metadata = format.d3;
        if (metadata == null) {
            return false;
        }
        for (int i2 = 0; i2 < metadata.g(); i2++) {
            Metadata.Entry d2 = metadata.d(i2);
            if (d2 instanceof HlsTrackMetadataEntry) {
                return !((HlsTrackMetadataEntry) d2).Y.isEmpty();
            }
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    private static boolean m(Extractor extractor, ExtractorInput extractorInput) throws IOException {
        try {
            boolean h2 = extractor.h(extractorInput);
            extractorInput.n();
            return h2;
        } catch (EOFException unused) {
            extractorInput.n();
            return false;
        } catch (Throwable th) {
            extractorInput.n();
            throw th;
        }
    }

    public Format c(Format format) {
        String str;
        if (!this.f11379d || !this.f11378c.b(format)) {
            return format;
        }
        Format.Builder Q = format.c().k0(MimeTypes.O0).Q(this.f11378c.a(format));
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

    /* renamed from: f */
    public BundledHlsMediaChunkExtractor d(Uri uri, Format format, @Nullable List<Format> list, TimestampAdjuster timestampAdjuster, Map<String, List<String>> map, ExtractorInput extractorInput, PlayerId playerId) throws IOException {
        Format format2 = format;
        int a2 = FileTypes.a(format2.f3);
        int b2 = FileTypes.b(map);
        int c2 = FileTypes.c(uri);
        int[] iArr = f11376f;
        ArrayList arrayList = new ArrayList(iArr.length);
        e(a2, arrayList);
        e(b2, arrayList);
        e(c2, arrayList);
        for (int e2 : iArr) {
            e(e2, arrayList);
        }
        extractorInput.n();
        Extractor extractor = null;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            int intValue = ((Integer) arrayList.get(i2)).intValue();
            Extractor extractor2 = (Extractor) Assertions.g(g(intValue, format2, list, timestampAdjuster));
            if (m(extractor2, extractorInput)) {
                return new BundledHlsMediaChunkExtractor(extractor2, format, timestampAdjuster, this.f11378c, this.f11379d);
            }
            if (extractor == null && (intValue == a2 || intValue == b2 || intValue == c2 || intValue == 11)) {
                extractor = extractor2;
            }
        }
        TimestampAdjuster timestampAdjuster2 = timestampAdjuster;
        return new BundledHlsMediaChunkExtractor((Extractor) Assertions.g(extractor), format, timestampAdjuster, this.f11378c, this.f11379d);
    }

    @CanIgnoreReturnValue
    /* renamed from: j */
    public DefaultHlsExtractorFactory b(boolean z) {
        this.f11379d = z;
        return this;
    }

    @CanIgnoreReturnValue
    /* renamed from: l */
    public DefaultHlsExtractorFactory a(SubtitleParser.Factory factory) {
        this.f11378c = factory;
        return this;
    }

    public DefaultHlsExtractorFactory(int i2, boolean z) {
        this.f11377b = i2;
        this.f11380e = z;
        this.f11378c = new DefaultSubtitleParserFactory();
    }
}
