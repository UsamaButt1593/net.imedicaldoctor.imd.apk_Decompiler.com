package androidx.media3.exoplayer.offline;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface DownloaderFactory {
    Downloader a(DownloadRequest downloadRequest);
}
