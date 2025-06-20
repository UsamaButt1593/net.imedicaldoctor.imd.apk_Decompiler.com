package androidx.media3.exoplayer.source;

import android.annotation.SuppressLint;
import android.media.MediaParser;
import android.net.Uri;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.media3.common.DataReader;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.ProgressiveMediaExtractor;
import androidx.media3.exoplayer.source.mediaparser.InputReaderAdapterV30;
import androidx.media3.exoplayer.source.mediaparser.MediaParserUtil;
import androidx.media3.exoplayer.source.mediaparser.OutputConsumerAdapterV30;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiresApi(30)
@UnstableApi
public final class MediaParserExtractorAdapter implements ProgressiveMediaExtractor {
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public static final ProgressiveMediaExtractor.Factory f12156e = new m();

    /* renamed from: a  reason: collision with root package name */
    private final OutputConsumerAdapterV30 f12157a;

    /* renamed from: b  reason: collision with root package name */
    private final InputReaderAdapterV30 f12158b;

    /* renamed from: c  reason: collision with root package name */
    private final MediaParser f12159c;

    /* renamed from: d  reason: collision with root package name */
    private String f12160d;

    public static final class Factory implements ProgressiveMediaExtractor.Factory {

        /* renamed from: a  reason: collision with root package name */
        private static final Map<String, Object> f12161a = new HashMap();

        /* renamed from: b */
        public MediaParserExtractorAdapter a(PlayerId playerId) {
            return new MediaParserExtractorAdapter(playerId, f12161a);
        }

        public void c(boolean z) {
            if (z) {
                Map<String, Object> map = f12161a;
                Boolean bool = Boolean.TRUE;
                map.put("android.media.mediaparser.adts.enableCbrSeeking", bool);
                map.put("android.media.mediaparser.amr.enableCbrSeeking", bool);
                map.put("android.media.mediaparser.mp3.enableCbrSeeking", bool);
                return;
            }
            Map<String, Object> map2 = f12161a;
            map2.remove("android.media.mediaparser.adts.enableCbrSeeking");
            map2.remove("android.media.mediaparser.amr.enableCbrSeeking");
            map2.remove("android.media.mediaparser.mp3.enableCbrSeeking");
        }
    }

    @Deprecated
    public MediaParserExtractorAdapter(PlayerId playerId) {
        this(playerId, ImmutableMap.s());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ProgressiveMediaExtractor h(PlayerId playerId) {
        return new MediaParserExtractorAdapter(playerId, ImmutableMap.s());
    }

    public void a() {
        this.f12159c.release();
    }

    public void c(long j2, long j3) {
        this.f12158b.b(j2);
        Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> i2 = this.f12157a.i(j3);
        this.f12159c.seek(j.a(k.a(j.a(i2.second)) == j2 ? i2.second : i2.first));
    }

    public long d() {
        return this.f12158b.getPosition();
    }

    public void e() {
        if ("android.media.mediaparser.Mp3Parser".equals(this.f12160d)) {
            this.f12157a.a();
        }
    }

    public int f(PositionHolder positionHolder) throws IOException {
        boolean a2 = this.f12159c.advance(this.f12158b);
        long a3 = this.f12158b.a();
        positionHolder.f13111a = a3;
        if (!a2) {
            return -1;
        }
        return a3 != -1 ? 1 : 0;
    }

    public void g(DataReader dataReader, Uri uri, Map<String, List<String>> map, long j2, long j3, ExtractorOutput extractorOutput) throws IOException {
        this.f12157a.m(extractorOutput);
        this.f12158b.c(dataReader, j3);
        this.f12158b.b(j2);
        String a2 = this.f12159c.getParserName();
        if ("android.media.mediaparser.UNKNOWN".equals(a2)) {
            boolean unused = this.f12159c.advance(this.f12158b);
        } else if (a2.equals(this.f12160d)) {
            return;
        }
        String a3 = this.f12159c.getParserName();
        this.f12160d = a3;
        this.f12157a.p(a3);
    }

    @SuppressLint({"WrongConstant"})
    private MediaParserExtractorAdapter(PlayerId playerId, Map<String, Object> map) {
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = new OutputConsumerAdapterV30();
        this.f12157a = outputConsumerAdapterV30;
        this.f12158b = new InputReaderAdapterV30();
        MediaParser a2 = MediaParser.create(outputConsumerAdapterV30, new String[0]);
        this.f12159c = a2;
        Boolean bool = Boolean.TRUE;
        MediaParser unused = a2.setParameter(MediaParserUtil.f12306c, bool);
        MediaParser unused2 = a2.setParameter(MediaParserUtil.f12304a, bool);
        MediaParser unused3 = a2.setParameter(MediaParserUtil.f12305b, bool);
        for (Map.Entry next : map.entrySet()) {
            MediaParser unused4 = this.f12159c.setParameter((String) next.getKey(), next.getValue());
        }
        this.f12160d = "android.media.mediaparser.UNKNOWN";
        if (Util.f9646a >= 31) {
            MediaParserUtil.a(this.f12159c, playerId);
        }
    }
}
