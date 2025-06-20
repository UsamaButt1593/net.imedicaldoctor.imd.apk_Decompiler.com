package com.google.firebase.installations;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.time.Clock;
import com.google.firebase.installations.time.SystemClock;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class Utils {

    /* renamed from: b  reason: collision with root package name */
    public static final long f24435b = TimeUnit.HOURS.toSeconds(1);

    /* renamed from: c  reason: collision with root package name */
    private static final String f24436c = ":";

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f24437d = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* renamed from: e  reason: collision with root package name */
    private static Utils f24438e;

    /* renamed from: a  reason: collision with root package name */
    private final Clock f24439a;

    private Utils(Clock clock) {
        this.f24439a = clock;
    }

    public static Utils c() {
        return d(SystemClock.b());
    }

    public static Utils d(Clock clock) {
        if (f24438e == null) {
            f24438e = new Utils(clock);
        }
        return f24438e;
    }

    static boolean g(@Nullable String str) {
        return f24437d.matcher(str).matches();
    }

    static boolean h(@Nullable String str) {
        return str.contains(f24436c);
    }

    public long a() {
        return this.f24439a.a();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    public long e() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean f(@NonNull PersistedInstallationEntry persistedInstallationEntry) {
        return TextUtils.isEmpty(persistedInstallationEntry.b()) || persistedInstallationEntry.h() + persistedInstallationEntry.c() < b() + f24435b;
    }
}
