package androidx.media3.extractor.mkv;

import android.net.Uri;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.f;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.Map;

public final /* synthetic */ class b implements ExtractorsFactory {
    public /* synthetic */ ExtractorsFactory a(SubtitleParser.Factory factory) {
        return f.c(this, factory);
    }

    public final Extractor[] b() {
        return MatroskaExtractor.E();
    }

    public /* synthetic */ ExtractorsFactory c(boolean z) {
        return f.b(this, z);
    }

    public /* synthetic */ Extractor[] d(Uri uri, Map map) {
        return f.a(this, uri, map);
    }
}
