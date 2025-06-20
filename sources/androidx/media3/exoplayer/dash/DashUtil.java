package androidx.media3.exoplayer.dash;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.dash.manifest.DashManifestParser;
import androidx.media3.exoplayer.dash.manifest.Period;
import androidx.media3.exoplayer.dash.manifest.RangedUri;
import androidx.media3.exoplayer.dash.manifest.Representation;
import androidx.media3.exoplayer.source.chunk.BundledChunkExtractor;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.exoplayer.source.chunk.InitializationChunk;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.mkv.MatroskaExtractor;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@UnstableApi
public final class DashUtil {
    private DashUtil() {
    }

    @Deprecated
    public static DataSpec a(Representation representation, RangedUri rangedUri, int i2) {
        return c(representation, representation.f11184d.get(0).f11127a, rangedUri, i2, ImmutableMap.s());
    }

    @Deprecated
    public static DataSpec b(Representation representation, String str, RangedUri rangedUri, int i2) {
        return c(representation, str, rangedUri, i2, ImmutableMap.s());
    }

    public static DataSpec c(Representation representation, String str, RangedUri rangedUri, int i2, Map<String, String> map) {
        return new DataSpec.Builder().j(rangedUri.b(str)).i(rangedUri.f11177a).h(rangedUri.f11178b).g(o(representation, rangedUri)).c(i2).f(map).a();
    }

    @Nullable
    private static Representation d(Period period, int i2) {
        int a2 = period.a(i2);
        if (a2 == -1) {
            return null;
        }
        List<Representation> list = period.f11169c.get(a2).f11120c;
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Nullable
    public static ChunkIndex e(DataSource dataSource, int i2, Representation representation) throws IOException {
        return f(dataSource, i2, representation, 0);
    }

    /* JADX INFO: finally extract failed */
    @Nullable
    public static ChunkIndex f(DataSource dataSource, int i2, Representation representation, int i3) throws IOException {
        if (representation.n() == null) {
            return null;
        }
        ChunkExtractor n2 = n(i2, representation.f11183c);
        try {
            i(n2, dataSource, representation, i3, true);
            n2.a();
            return n2.f();
        } catch (Throwable th) {
            n2.a();
            throw th;
        }
    }

    @Nullable
    public static Format g(DataSource dataSource, Period period) throws IOException {
        int i2 = 2;
        Representation d2 = d(period, 2);
        if (d2 == null) {
            i2 = 1;
            d2 = d(period, 1);
            if (d2 == null) {
                return null;
            }
        }
        Format format = d2.f11183c;
        Format l2 = l(dataSource, i2, d2);
        return l2 == null ? format : l2.n(format);
    }

    private static void h(DataSource dataSource, Representation representation, int i2, ChunkExtractor chunkExtractor, RangedUri rangedUri) throws IOException {
        new InitializationChunk(dataSource, c(representation, representation.f11184d.get(i2).f11127a, rangedUri, 0, ImmutableMap.s()), representation.f11183c, 0, (Object) null, chunkExtractor).a();
    }

    private static void i(ChunkExtractor chunkExtractor, DataSource dataSource, Representation representation, int i2, boolean z) throws IOException {
        RangedUri rangedUri = (RangedUri) Assertions.g(representation.n());
        if (z) {
            RangedUri m2 = representation.m();
            if (m2 != null) {
                RangedUri a2 = rangedUri.a(m2, representation.f11184d.get(i2).f11127a);
                if (a2 == null) {
                    h(dataSource, representation, i2, chunkExtractor, rangedUri);
                    rangedUri = m2;
                } else {
                    rangedUri = a2;
                }
            } else {
                return;
            }
        }
        h(dataSource, representation, i2, chunkExtractor, rangedUri);
    }

    public static void j(ChunkExtractor chunkExtractor, DataSource dataSource, Representation representation, boolean z) throws IOException {
        i(chunkExtractor, dataSource, representation, 0, z);
    }

    public static DashManifest k(DataSource dataSource, Uri uri) throws IOException {
        return (DashManifest) ParsingLoadable.g(dataSource, new DashManifestParser(), uri, 4);
    }

    @Nullable
    public static Format l(DataSource dataSource, int i2, Representation representation) throws IOException {
        return m(dataSource, i2, representation, 0);
    }

    /* JADX INFO: finally extract failed */
    @Nullable
    public static Format m(DataSource dataSource, int i2, Representation representation, int i3) throws IOException {
        if (representation.n() == null) {
            return null;
        }
        ChunkExtractor n2 = n(i2, representation.f11183c);
        try {
            i(n2, dataSource, representation, i3, false);
            n2.a();
            return ((Format[]) Assertions.k(n2.c()))[0];
        } catch (Throwable th) {
            n2.a();
            throw th;
        }
    }

    private static ChunkExtractor n(int i2, Format format) {
        String str = format.e3;
        return new BundledChunkExtractor((str == null || (!str.startsWith(MimeTypes.f9233h) && !str.startsWith(MimeTypes.H))) ? new FragmentedMp4Extractor(SubtitleParser.Factory.f13783a, 32) : new MatroskaExtractor(SubtitleParser.Factory.f13783a, 2), i2, format);
    }

    public static String o(Representation representation, RangedUri rangedUri) {
        String a2 = representation.a();
        return a2 != null ? a2 : rangedUri.b(representation.f11184d.get(0).f11127a).toString();
    }
}
