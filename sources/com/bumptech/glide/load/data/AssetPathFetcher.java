package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;

public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
    private static final String Z = "AssetPathFetcher";
    private final AssetManager X;
    private T Y;
    private final String s;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.X = assetManager;
        this.s = str;
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

    public void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T f2 = f(this.X, this.s);
            this.Y = f2;
            dataCallback.f(f2);
        } catch (IOException e2) {
            if (Log.isLoggable(Z, 3)) {
                Log.d(Z, "Failed to load data from asset manager", e2);
            }
            dataCallback.c(e2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract T f(AssetManager assetManager, String str) throws IOException;
}
