package com.jakewharton.threetenabp;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import org.threeten.bp.zone.TzdbZoneRulesProvider;
import org.threeten.bp.zone.ZoneRulesInitializer;
import org.threeten.bp.zone.ZoneRulesProvider;

final class AssetsZoneRulesInitializer extends ZoneRulesInitializer {

    /* renamed from: d  reason: collision with root package name */
    private final Context f27844d;

    AssetsZoneRulesInitializer(Context context) {
        this.f27844d = context;
    }

    /* access modifiers changed from: protected */
    public void b() {
        InputStream inputStream = null;
        try {
            inputStream = this.f27844d.getAssets().open("org/threeten/bp/TZDB.dat");
            TzdbZoneRulesProvider tzdbZoneRulesProvider = new TzdbZoneRulesProvider(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            ZoneRulesProvider.j(tzdbZoneRulesProvider);
        } catch (IOException e2) {
            throw new IllegalStateException("TZDB.dat missing from assets.", e2);
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }
}
