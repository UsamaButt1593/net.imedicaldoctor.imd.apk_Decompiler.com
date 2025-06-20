package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;

public class DataTransportCrashlyticsReportSender {

    /* renamed from: c  reason: collision with root package name */
    private static final CrashlyticsReportJsonTransform f24222c = new CrashlyticsReportJsonTransform();

    /* renamed from: d  reason: collision with root package name */
    private static final String f24223d = e("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* renamed from: e  reason: collision with root package name */
    private static final String f24224e = e("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* renamed from: f  reason: collision with root package name */
    private static final String f24225f = "FIREBASE_CRASHLYTICS_REPORT";

    /* renamed from: g  reason: collision with root package name */
    private static final Transformer<CrashlyticsReport, byte[]> f24226g = new a();

    /* renamed from: a  reason: collision with root package name */
    private final ReportQueue f24227a;

    /* renamed from: b  reason: collision with root package name */
    private final Transformer<CrashlyticsReport, byte[]> f24228b;

    DataTransportCrashlyticsReportSender(ReportQueue reportQueue, Transformer<CrashlyticsReport, byte[]> transformer) {
        this.f24227a = reportQueue;
        this.f24228b = transformer;
    }

    public static DataTransportCrashlyticsReportSender b(Context context, SettingsProvider settingsProvider, OnDemandCounter onDemandCounter) {
        TransportRuntime.f(context);
        TransportFactory g2 = TransportRuntime.c().g(new CCTDestination(f24223d, f24224e));
        Encoding b2 = Encoding.b("json");
        Transformer<CrashlyticsReport, byte[]> transformer = f24226g;
        return new DataTransportCrashlyticsReportSender(new ReportQueue(g2.b(f24225f, CrashlyticsReport.class, b2, transformer), settingsProvider.b(), onDemandCounter), transformer);
    }

    private static String e(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            sb.append(str.charAt(i2));
            if (str2.length() > i2) {
                sb.append(str2.charAt(i2));
            }
        }
        return sb.toString();
    }

    @NonNull
    public Task<CrashlyticsReportWithSessionId> c(@NonNull CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, boolean z) {
        return this.f24227a.i(crashlyticsReportWithSessionId, z).a();
    }
}
