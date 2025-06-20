package androidx.media3.extractor;

import android.net.Uri;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.Map;

public final /* synthetic */ class e implements ExtractorsFactory {
    public /* synthetic */ ExtractorsFactory a(SubtitleParser.Factory factory) {
        return f.c(this, factory);
    }

    public final Extractor[] b() {
        return f.d();
    }

    public /* synthetic */ ExtractorsFactory c(boolean z) {
        return f.b(this, z);
    }

    public /* synthetic */ Extractor[] d(Uri uri, Map map) {
        return f.a(this, uri, map);
    }
}
