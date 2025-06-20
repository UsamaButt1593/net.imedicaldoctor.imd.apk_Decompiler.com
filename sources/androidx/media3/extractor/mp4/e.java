package androidx.media3.extractor.mp4;

import android.net.Uri;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.f;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.Map;

public final /* synthetic */ class e implements ExtractorsFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubtitleParser.Factory f13698b;

    public /* synthetic */ e(SubtitleParser.Factory factory) {
        this.f13698b = factory;
    }

    public /* synthetic */ ExtractorsFactory a(SubtitleParser.Factory factory) {
        return f.c(this, factory);
    }

    public final Extractor[] b() {
        return Mp4Extractor.v(this.f13698b);
    }

    public /* synthetic */ ExtractorsFactory c(boolean z) {
        return f.b(this, z);
    }

    public /* synthetic */ Extractor[] d(Uri uri, Map map) {
        return f.a(this, uri, map);
    }
}
