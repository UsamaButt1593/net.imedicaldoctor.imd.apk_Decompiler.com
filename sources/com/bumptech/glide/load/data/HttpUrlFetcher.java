package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class HttpUrlFetcher implements DataFetcher<InputStream> {
    private static final String Z2 = "HttpUrlFetcher";
    private static final int a3 = 5;
    @VisibleForTesting
    static final HttpUrlConnectionFactory b3 = new DefaultHttpUrlConnectionFactory();
    private static final int c3 = -1;
    private final int X;
    private InputStream X2;
    private final HttpUrlConnectionFactory Y;
    private volatile boolean Y2;
    private HttpURLConnection Z;
    private final GlideUrl s;

    private static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        DefaultHttpUrlConnectionFactory() {
        }

        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    interface HttpUrlConnectionFactory {
        HttpURLConnection a(URL url) throws IOException;
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i2) {
        this(glideUrl, i2, b3);
    }

    private InputStream c(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream;
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            inputStream = ContentLengthInputStream.c(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable(Z2, 3)) {
                Log.d(Z2, "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            inputStream = httpURLConnection.getInputStream();
        }
        this.X2 = inputStream;
        return this.X2;
    }

    private static boolean f(int i2) {
        return i2 / 100 == 2;
    }

    private static boolean g(int i2) {
        return i2 / 100 == 3;
    }

    private InputStream h(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.Z = this.Y.a(url);
            for (Map.Entry next : map.entrySet()) {
                this.Z.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            this.Z.setConnectTimeout(this.X);
            this.Z.setReadTimeout(this.X);
            this.Z.setUseCaches(false);
            this.Z.setDoInput(true);
            this.Z.setInstanceFollowRedirects(false);
            this.Z.connect();
            this.X2 = this.Z.getInputStream();
            if (this.Y2) {
                return null;
            }
            int responseCode = this.Z.getResponseCode();
            if (f(responseCode)) {
                return c(this.Z);
            }
            if (g(responseCode)) {
                String headerField = this.Z.getHeaderField(HttpHeaders.t0);
                if (!TextUtils.isEmpty(headerField)) {
                    URL url3 = new URL(url, headerField);
                    b();
                    return h(url3, i2 + 1, url, map);
                }
                throw new HttpException("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new HttpException(responseCode);
            } else {
                throw new HttpException(this.Z.getResponseMessage(), responseCode);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!");
        }
    }

    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void b() {
        InputStream inputStream = this.X2;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.Z;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.Z = null;
    }

    public void cancel() {
        this.Y2 = true;
    }

    @NonNull
    public DataSource d() {
        return DataSource.REMOTE;
    }

    public void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        StringBuilder sb;
        long b2 = LogTime.b();
        try {
            dataCallback.f(h(this.s.i(), 0, (URL) null, this.s.e()));
            if (Log.isLoggable(Z2, 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(LogTime.a(b2));
                Log.v(Z2, sb.toString());
            }
        } catch (IOException e2) {
            if (Log.isLoggable(Z2, 3)) {
                Log.d(Z2, "Failed to load data for url", e2);
            }
            dataCallback.c(e2);
            if (Log.isLoggable(Z2, 2)) {
                sb = new StringBuilder();
            }
        } catch (Throwable th) {
            if (Log.isLoggable(Z2, 2)) {
                Log.v(Z2, "Finished http url fetcher fetch in " + LogTime.a(b2));
            }
            throw th;
        }
    }

    @VisibleForTesting
    HttpUrlFetcher(GlideUrl glideUrl, int i2, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.s = glideUrl;
        this.X = i2;
        this.Y = httpUrlConnectionFactory;
    }
}
