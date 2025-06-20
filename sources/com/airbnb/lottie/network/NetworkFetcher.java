package com.airbnb.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;
import org.apache.commons.lang3.StringUtils;

public class NetworkFetcher {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17273a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17274b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final NetworkCache f17275c;

    private NetworkFetcher(Context context, String str, @Nullable String str2) {
        Context applicationContext = context.getApplicationContext();
        this.f17273a = applicationContext;
        this.f17274b = str;
        if (str2 == null) {
            this.f17275c = null;
        } else {
            this.f17275c = new NetworkCache(applicationContext);
        }
    }

    @WorkerThread
    @Nullable
    private LottieComposition a() {
        Pair<FileExtension, InputStream> b2;
        NetworkCache networkCache = this.f17275c;
        if (networkCache == null || (b2 = networkCache.b(this.f17274b)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) b2.f6296a;
        InputStream inputStream = (InputStream) b2.f6297b;
        LottieResult<LottieComposition> B = fileExtension == FileExtension.ZIP ? LottieCompositionFactory.B(new ZipInputStream(inputStream), this.f17274b) : LottieCompositionFactory.k(inputStream, this.f17274b);
        if (B.b() != null) {
            return B.b();
        }
        return null;
    }

    @WorkerThread
    private LottieResult<LottieComposition> b() {
        try {
            return c();
        } catch (IOException e2) {
            return new LottieResult<>((Throwable) e2);
        }
    }

    @WorkerThread
    private LottieResult<LottieComposition> c() throws IOException {
        Logger.a("Fetching " + this.f17274b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f17274b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null) {
                if (httpURLConnection.getResponseCode() == 200) {
                    LottieResult<LottieComposition> g2 = g(httpURLConnection);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Completed fetch from network. Success: ");
                    sb.append(g2.b() != null);
                    Logger.a(sb.toString());
                    httpURLConnection.disconnect();
                    return g2;
                }
            }
            String f2 = f(httpURLConnection);
            return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to fetch " + this.f17274b + ". Failed with " + httpURLConnection.getResponseCode() + StringUtils.LF + f2));
        } catch (Exception e2) {
            return new LottieResult<>((Throwable) e2);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static LottieResult<LottieComposition> e(Context context, String str, @Nullable String str2) {
        return new NetworkFetcher(context, str, str2).d();
    }

    private String f(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append(10);
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e2) {
                throw e2;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    @Nullable
    private LottieResult<LottieComposition> g(HttpURLConnection httpURLConnection) throws IOException {
        LottieResult<LottieComposition> lottieResult;
        FileExtension fileExtension;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = "application/json";
        }
        if (contentType.contains("application/zip")) {
            Logger.a("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            NetworkCache networkCache = this.f17275c;
            lottieResult = networkCache == null ? LottieCompositionFactory.B(new ZipInputStream(httpURLConnection.getInputStream()), (String) null) : LottieCompositionFactory.B(new ZipInputStream(new FileInputStream(networkCache.g(this.f17274b, httpURLConnection.getInputStream(), fileExtension))), this.f17274b);
        } else {
            Logger.a("Received json response.");
            fileExtension = FileExtension.JSON;
            NetworkCache networkCache2 = this.f17275c;
            lottieResult = networkCache2 == null ? LottieCompositionFactory.k(httpURLConnection.getInputStream(), (String) null) : LottieCompositionFactory.k(new FileInputStream(new File(networkCache2.g(this.f17274b, httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.f17274b);
        }
        if (!(this.f17275c == null || lottieResult.b() == null)) {
            this.f17275c.f(this.f17274b, fileExtension);
        }
        return lottieResult;
    }

    @WorkerThread
    public LottieResult<LottieComposition> d() {
        LottieComposition a2 = a();
        if (a2 != null) {
            return new LottieResult<>(a2);
        }
        Logger.a("Animation for " + this.f17274b + " not found in cache. Fetching from network.");
        return b();
    }
}
