package com.google.firebase.crashlytics.internal.persistence;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsAppQualitySessionsSubscriber;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class CrashlyticsReportPersistence {

    /* renamed from: e  reason: collision with root package name */
    private static final Charset f24193e = Charset.forName("UTF-8");

    /* renamed from: f  reason: collision with root package name */
    private static final int f24194f = 8;

    /* renamed from: g  reason: collision with root package name */
    private static final String f24195g = "report";

    /* renamed from: h  reason: collision with root package name */
    private static final String f24196h = "start-time";

    /* renamed from: i  reason: collision with root package name */
    private static final String f24197i = "event";

    /* renamed from: j  reason: collision with root package name */
    private static final int f24198j = 10;

    /* renamed from: k  reason: collision with root package name */
    private static final String f24199k = "%010d";

    /* renamed from: l  reason: collision with root package name */
    private static final int f24200l = 15;

    /* renamed from: m  reason: collision with root package name */
    private static final String f24201m = "_";

    /* renamed from: n  reason: collision with root package name */
    private static final String f24202n = "";
    private static final CrashlyticsReportJsonTransform o = new CrashlyticsReportJsonTransform();
    private static final Comparator<? super File> p = new a();
    private static final FilenameFilter q = new b();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f24203a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    private final FileStore f24204b;

    /* renamed from: c  reason: collision with root package name */
    private final SettingsProvider f24205c;

    /* renamed from: d  reason: collision with root package name */
    private final CrashlyticsAppQualitySessionsSubscriber f24206d;

    public CrashlyticsReportPersistence(FileStore fileStore, SettingsProvider settingsProvider, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber) {
        this.f24204b = fileStore;
        this.f24205c = settingsProvider;
        this.f24206d = crashlyticsAppQualitySessionsSubscriber;
    }

    @NonNull
    private static String B(@NonNull File file) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), f24193e);
                    fileInputStream.close();
                    return str;
                }
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        throw th;
    }

    private void C(@NonNull File file, @NonNull CrashlyticsReport.FilesPayload filesPayload, @NonNull String str, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        String d2 = this.f24206d.d(str);
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = o;
            G(this.f24204b.j(str), crashlyticsReportJsonTransform.O(crashlyticsReportJsonTransform.N(B(file)).v(filesPayload).r(applicationExitInfo).q(d2)));
        } catch (IOException e2) {
            Logger f2 = Logger.f();
            f2.n("Could not synthesize final native report file for " + file, e2);
        }
    }

    private void D(String str, long j2) {
        boolean z;
        List<File> s = this.f24204b.s(str, q);
        if (s.isEmpty()) {
            Logger f2 = Logger.f();
            f2.k("Session " + str + " has no events.");
            return;
        }
        Collections.sort(s);
        ArrayList arrayList = new ArrayList();
        Iterator<File> it2 = s.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it2.hasNext()) {
                    break loop0;
                }
                File next = it2.next();
                try {
                    arrayList.add(o.l(B(next)));
                    if (z || s(next.getName())) {
                        z = true;
                    }
                } catch (IOException e2) {
                    Logger f3 = Logger.f();
                    f3.n("Could not add event to report for " + next, e2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            Logger f4 = Logger.f();
            f4.m("Could not parse event files for session " + str);
            return;
        }
        String m2 = UserMetadata.m(str, this.f24204b);
        String d2 = this.f24206d.d(str);
        E(this.f24204b.r(str, f24195g), arrayList, j2, z, m2, d2);
    }

    private void E(@NonNull File file, @NonNull List<CrashlyticsReport.Session.Event> list, long j2, boolean z, @Nullable String str, @Nullable String str2) {
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = o;
            CrashlyticsReport s = crashlyticsReportJsonTransform.N(B(file)).x(j2, z, str).q(str2).s(list);
            CrashlyticsReport.Session n2 = s.n();
            if (n2 != null) {
                Logger f2 = Logger.f();
                f2.b("appQualitySessionId: " + str2);
                G(z ? this.f24204b.m(n2.i()) : this.f24204b.o(n2.i()), crashlyticsReportJsonTransform.O(s));
            }
        } catch (IOException e2) {
            Logger f3 = Logger.f();
            f3.n("Could not synthesize final report file for " + file, e2);
        }
    }

    private int F(String str, int i2) {
        List<File> s = this.f24204b.s(str, new c());
        Collections.sort(s, new d());
        return f(s, i2);
    }

    private static void G(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f24193e);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static void H(File file, String str, long j2) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f24193e);
        try {
            outputStreamWriter.write(str);
            file.setLastModified(h(j2));
            outputStreamWriter.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private SortedSet<String> e(@Nullable String str) {
        this.f24204b.d();
        SortedSet<String> p2 = p();
        if (str != null) {
            p2.remove(str);
        }
        if (p2.size() <= 8) {
            return p2;
        }
        while (p2.size() > 8) {
            String last = p2.last();
            Logger f2 = Logger.f();
            f2.b("Removing session over cap: " + last);
            this.f24204b.f(last);
            p2.remove(last);
        }
        return p2;
    }

    private static int f(List<File> list, int i2) {
        int size = list.size();
        for (File next : list) {
            if (size <= i2) {
                return size;
            }
            FileStore.w(next);
            size--;
        }
        return size;
    }

    private void g() {
        int i2 = this.f24205c.b().f24263a.f24275b;
        List<File> n2 = n();
        int size = n2.size();
        if (size > i2) {
            for (File delete : n2.subList(i2, size)) {
                delete.delete();
            }
        }
    }

    private static long h(long j2) {
        return j2 * 1000;
    }

    private void j(List<File> list) {
        for (File delete : list) {
            delete.delete();
        }
    }

    @NonNull
    private static String m(int i2, boolean z) {
        String format = String.format(Locale.US, f24199k, new Object[]{Integer.valueOf(i2)});
        String str = z ? f24201m : "";
        return "event" + format + str;
    }

    private List<File> n() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f24204b.n());
        arrayList.addAll(this.f24204b.k());
        Comparator<? super File> comparator = p;
        Collections.sort(arrayList, comparator);
        List<File> p2 = this.f24204b.p();
        Collections.sort(p2, comparator);
        arrayList.addAll(p2);
        return arrayList;
    }

    @NonNull
    private static String o(@NonNull String str) {
        return str.substring(0, f24200l);
    }

    private static boolean s(@NonNull String str) {
        return str.startsWith("event") && str.endsWith(f24201m);
    }

    /* access modifiers changed from: private */
    public static boolean t(@NonNull File file, @NonNull String str) {
        return str.startsWith("event") && !str.endsWith(f24201m);
    }

    /* access modifiers changed from: private */
    public static int x(@NonNull File file, @NonNull File file2) {
        return o(file.getName()).compareTo(o(file2.getName()));
    }

    public void A(@NonNull CrashlyticsReport crashlyticsReport) {
        CrashlyticsReport.Session n2 = crashlyticsReport.n();
        if (n2 == null) {
            Logger.f().b("Could not get session for report");
            return;
        }
        String i2 = n2.i();
        try {
            G(this.f24204b.r(i2, f24195g), o.O(crashlyticsReport));
            H(this.f24204b.r(i2, f24196h), "", n2.l());
        } catch (IOException e2) {
            Logger f2 = Logger.f();
            f2.c("Could not persist report for session " + i2, e2);
        }
    }

    public void i() {
        j(this.f24204b.p());
        j(this.f24204b.n());
        j(this.f24204b.k());
    }

    public void k(@Nullable String str, long j2) {
        for (String next : e(str)) {
            Logger f2 = Logger.f();
            f2.k("Finalizing report for session " + next);
            D(next, j2);
            this.f24204b.f(next);
        }
        g();
    }

    public void l(String str, CrashlyticsReport.FilesPayload filesPayload, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        File r = this.f24204b.r(str, f24195g);
        Logger f2 = Logger.f();
        f2.b("Writing native session report for " + str + " to file: " + r);
        C(r, filesPayload, str, applicationExitInfo);
    }

    public SortedSet<String> p() {
        return new TreeSet(this.f24204b.g()).descendingSet();
    }

    public long q(String str) {
        return this.f24204b.r(str, f24196h).lastModified();
    }

    public boolean r() {
        return !this.f24204b.p().isEmpty() || !this.f24204b.n().isEmpty() || !this.f24204b.k().isEmpty();
    }

    @NonNull
    public List<CrashlyticsReportWithSessionId> w() {
        List<File> n2 = n();
        ArrayList arrayList = new ArrayList();
        for (File next : n2) {
            try {
                arrayList.add(CrashlyticsReportWithSessionId.a(o.N(B(next)), next.getName(), next));
            } catch (IOException e2) {
                Logger f2 = Logger.f();
                f2.n("Could not load report file " + next + "; deleting", e2);
                next.delete();
            }
        }
        return arrayList;
    }

    public void y(@NonNull CrashlyticsReport.Session.Event event, @NonNull String str) {
        z(event, str, false);
    }

    public void z(@NonNull CrashlyticsReport.Session.Event event, @NonNull String str, boolean z) {
        int i2 = this.f24205c.b().f24263a.f24274a;
        try {
            G(this.f24204b.r(str, m(this.f24203a.getAndIncrement(), z)), o.m(event));
        } catch (IOException e2) {
            Logger f2 = Logger.f();
            f2.n("Could not persist event for session " + str, e2);
        }
        F(str, i2);
    }
}
