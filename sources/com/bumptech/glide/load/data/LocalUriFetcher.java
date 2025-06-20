package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
    private static final String Z = "LocalUriFetcher";
    private final ContentResolver X;
    private T Y;
    private final Uri s;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this.X = contentResolver;
        this.s = uri;
    }

    public void b() {
        T t = this.Y;
        if (t != null) {
            try {
                c(t);
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void c(T t) throws IOException;

    public void cancel() {
    }

    @NonNull
    public DataSource d() {
        return DataSource.LOCAL;
    }

    public final void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T f2 = f(this.s, this.X);
            this.Y = f2;
            dataCallback.f(f2);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable(Z, 3)) {
                Log.d(Z, "Failed to open Uri", e2);
            }
            dataCallback.c(e2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract T f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;
}
