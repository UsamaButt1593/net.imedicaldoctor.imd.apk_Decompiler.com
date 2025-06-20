package androidx.media3.extractor.ts;

import android.net.Uri;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.Map;

public final /* synthetic */ class f implements ExtractorsFactory {
    public /* synthetic */ ExtractorsFactory a(SubtitleParser.Factory factory) {
        return androidx.media3.extractor.f.c(this, factory);
    }

    public final Extractor[] b() {
        return TsExtractor.A();
    }

    public /* synthetic */ ExtractorsFactory c(boolean z) {
        return androidx.media3.extractor.f.b(this, z);
    }

    public /* synthetic */ Extractor[] d(Uri uri, Map map) {
        return androidx.media3.extractor.f.a(this, uri, map);
    }
}
