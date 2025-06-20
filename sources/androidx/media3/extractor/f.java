package androidx.media3.extractor;

import android.net.Uri;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;

public final /* synthetic */ class f {
    static {
        ExtractorsFactory extractorsFactory = ExtractorsFactory.f13039a;
    }

    public static Extractor[] a(ExtractorsFactory extractorsFactory, Uri uri, Map map) {
        return extractorsFactory.b();
    }

    public static /* synthetic */ Extractor[] d() {
        return new Extractor[0];
    }

    @CanIgnoreReturnValue
    public static ExtractorsFactory b(ExtractorsFactory extractorsFactory, boolean z) {
        return extractorsFactory;
    }

    public static ExtractorsFactory c(ExtractorsFactory extractorsFactory, SubtitleParser.Factory factory) {
        return extractorsFactory;
    }
}
