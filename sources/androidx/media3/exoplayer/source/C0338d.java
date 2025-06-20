package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.f;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.Map;

/* renamed from: androidx.media3.exoplayer.source.d  reason: case insensitive filesystem */
public final /* synthetic */ class C0338d implements ExtractorsFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultMediaSourceFactory f12298b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Format f12299c;

    public /* synthetic */ C0338d(DefaultMediaSourceFactory defaultMediaSourceFactory, Format format) {
        this.f12298b = defaultMediaSourceFactory;
        this.f12299c = format;
    }

    public /* synthetic */ ExtractorsFactory a(SubtitleParser.Factory factory) {
        return f.c(this, factory);
    }

    public final Extractor[] b() {
        return this.f12298b.m(this.f12299c);
    }

    public /* synthetic */ ExtractorsFactory c(boolean z) {
        return f.b(this, z);
    }

    public /* synthetic */ Extractor[] d(Uri uri, Map map) {
        return f.a(this, uri, map);
    }
}
