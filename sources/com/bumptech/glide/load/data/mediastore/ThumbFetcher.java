package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ThumbFetcher implements DataFetcher<InputStream> {
    private static final String Z = "MediaStoreThumbFetcher";
    private final ThumbnailStreamOpener X;
    private InputStream Y;
    private final Uri s;

    static class ImageThumbnailQuery implements ThumbnailQuery {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f17848b = {"_data"};

        /* renamed from: c  reason: collision with root package name */
        private static final String f17849c = "kind = 1 AND image_id = ?";

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f17850a;

        ImageThumbnailQuery(ContentResolver contentResolver) {
            this.f17850a = contentResolver;
        }

        public Cursor a(Uri uri) {
            return this.f17850a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f17848b, f17849c, new String[]{uri.getLastPathSegment()}, (String) null);
        }
    }

    static class VideoThumbnailQuery implements ThumbnailQuery {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f17851b = {"_data"};

        /* renamed from: c  reason: collision with root package name */
        private static final String f17852c = "kind = 1 AND video_id = ?";

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f17853a;

        VideoThumbnailQuery(ContentResolver contentResolver) {
            this.f17853a = contentResolver;
        }

        public Cursor a(Uri uri) {
            return this.f17853a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f17851b, f17852c, new String[]{uri.getLastPathSegment()}, (String) null);
        }
    }

    @VisibleForTesting
    ThumbFetcher(Uri uri, ThumbnailStreamOpener thumbnailStreamOpener) {
        this.s = uri;
        this.X = thumbnailStreamOpener;
    }

    private static ThumbFetcher c(Context context, Uri uri, ThumbnailQuery thumbnailQuery) {
        return new ThumbFetcher(uri, new ThumbnailStreamOpener(Glide.d(context).m().g(), thumbnailQuery, Glide.d(context).f(), context.getContentResolver()));
    }

    public static ThumbFetcher f(Context context, Uri uri) {
        return c(context, uri, new ImageThumbnailQuery(context.getContentResolver()));
    }

    public static ThumbFetcher g(Context context, Uri uri) {
        return c(context, uri, new VideoThumbnailQuery(context.getContentResolver()));
    }

    private InputStream h() throws FileNotFoundException {
        InputStream d2 = this.X.d(this.s);
        int a2 = d2 != null ? this.X.a(this.s) : -1;
        return a2 != -1 ? new ExifOrientationStream(d2, a2) : d2;
    }

    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void b() {
        InputStream inputStream = this.Y;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public void cancel() {
    }

    @NonNull
    public DataSource d() {
        return DataSource.LOCAL;
    }

    public void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        try {
            InputStream h2 = h();
            this.Y = h2;
            dataCallback.f(h2);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable(Z, 3)) {
                Log.d(Z, "Failed to find thumbnail file", e2);
            }
            dataCallback.c(e2);
        }
    }
}
