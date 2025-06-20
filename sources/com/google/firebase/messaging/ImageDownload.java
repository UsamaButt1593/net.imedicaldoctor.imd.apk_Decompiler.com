package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ImageDownload implements Closeable {
    private static final int Z = 1048576;
    @Nullable
    private volatile Future<?> X;
    @Nullable
    private Task<Bitmap> Y;
    private final URL s;

    private ImageDownload(URL url) {
        this.s = url;
    }

    private byte[] d() throws IOException {
        URLConnection openConnection = this.s.openConnection();
        if (openConnection.getContentLength() <= 1048576) {
            InputStream inputStream = openConnection.getInputStream();
            try {
                byte[] e2 = ByteStreams.e(ByteStreams.c(inputStream, 1048577));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (Log.isLoggable(Constants.f24670a, 2)) {
                    Log.v(Constants.f24670a, "Downloaded " + e2.length + " bytes from " + this.s);
                }
                if (e2.length <= 1048576) {
                    return e2;
                }
                throw new IOException("Image exceeds max size of 1048576");
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        throw th;
    }

    @Nullable
    public static ImageDownload e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ImageDownload(new URL(str));
        } catch (MalformedURLException unused) {
            Log.w(Constants.f24670a, "Not downloading image, bad URL: " + str);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.c(c());
        } catch (Exception e2) {
            taskCompletionSource.b(e2);
        }
    }

    public Bitmap c() throws IOException {
        if (Log.isLoggable(Constants.f24670a, 4)) {
            Log.i(Constants.f24670a, "Starting download of: " + this.s);
        }
        byte[] d2 = d();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(d2, 0, d2.length);
        if (decodeByteArray != null) {
            if (Log.isLoggable(Constants.f24670a, 3)) {
                Log.d(Constants.f24670a, "Successfully downloaded image: " + this.s);
            }
            return decodeByteArray;
        }
        throw new IOException("Failed to decode image: " + this.s);
    }

    public void close() {
        this.X.cancel(true);
    }

    public Task<Bitmap> f() {
        return (Task) Preconditions.r(this.Y);
    }

    public void i(ExecutorService executorService) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.X = executorService.submit(new A(this, taskCompletionSource));
        this.Y = taskCompletionSource.a();
    }
}
