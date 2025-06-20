package androidx.media3.extractor.ts;

import android.net.Uri;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.f;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.Map;

public final /* synthetic */ class e implements ExtractorsFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubtitleParser.Factory f14554b;

    public /* synthetic */ e(SubtitleParser.Factory factory) {
        this.f14554b = factory;
    }

    public /* synthetic */ ExtractorsFactory a(SubtitleParser.Factory factory) {
        return f.c(this, factory);
    }

    public final Extractor[] b() {
        return TsExtractor.z(this.f14554b);
    }

    public /* synthetic */ ExtractorsFactory c(boolean z) {
        return f.b(this, z);
    }

    public /* synthetic */ Extractor[] d(Uri uri, Map map) {
        return f.a(this, uri, map);
    }
}
