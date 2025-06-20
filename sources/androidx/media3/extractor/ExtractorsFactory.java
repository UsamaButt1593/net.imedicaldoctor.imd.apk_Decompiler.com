package androidx.media3.extractor;

import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;
import java.util.Map;

@UnstableApi
public interface ExtractorsFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final ExtractorsFactory f13039a = new e();

    ExtractorsFactory a(SubtitleParser.Factory factory);

    Extractor[] b();

    @CanIgnoreReturnValue
    ExtractorsFactory c(boolean z);

    Extractor[] d(Uri uri, Map<String, List<String>> map);
}
