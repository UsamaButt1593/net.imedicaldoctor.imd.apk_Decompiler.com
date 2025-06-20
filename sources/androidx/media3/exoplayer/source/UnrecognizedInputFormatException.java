package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public class UnrecognizedInputFormatException extends ParserException {
    public final Uri Y;

    public UnrecognizedInputFormatException(String str, Uri uri) {
        super(str, (Throwable) null, false, 1);
        this.Y = uri;
    }
}
