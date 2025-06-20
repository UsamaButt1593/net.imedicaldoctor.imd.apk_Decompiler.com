package com.jakewharton.threetenabp;

import android.app.Application;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import org.threeten.bp.zone.ZoneRulesInitializer;

public final class AndroidThreeTen {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f27843a = new AtomicBoolean();

    private AndroidThreeTen() {
        throw new AssertionError("No instances.");
    }

    public static void a(Application application) {
        b(application);
    }

    public static void b(Context context) {
        if (!f27843a.getAndSet(true)) {
            ZoneRulesInitializer.c(new AssetsZoneRulesInitializer(context));
        }
    }
}
