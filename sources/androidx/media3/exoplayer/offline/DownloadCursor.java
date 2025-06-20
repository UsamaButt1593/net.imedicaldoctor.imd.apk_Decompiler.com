package androidx.media3.exoplayer.offline;

import androidx.media3.common.util.UnstableApi;
import java.io.Closeable;

@UnstableApi
public interface DownloadCursor extends Closeable {
    void close();

    int getCount();

    int getPosition();

    Download i2();

    boolean isAfterLast();

    boolean isBeforeFirst();

    boolean isClosed();

    boolean isFirst();

    boolean isLast();

    boolean moveToFirst();

    boolean moveToLast();

    boolean moveToNext();

    boolean moveToPosition(int i2);

    boolean moveToPrevious();
}
