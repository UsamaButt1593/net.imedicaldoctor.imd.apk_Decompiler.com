package androidx.appcompat.app;

import android.os.LocaleList;
import androidx.annotation.RequiresApi;
import androidx.core.os.LocaleListCompat;
import java.util.LinkedHashSet;
import java.util.Locale;

@RequiresApi(24)
final class LocaleOverlayHelper {
    private LocaleOverlayHelper() {
    }

    private static LocaleListCompat a(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i2 = 0;
        while (i2 < localeListCompat.l() + localeListCompat2.l()) {
            Locale d2 = i2 < localeListCompat.l() ? localeListCompat.d(i2) : localeListCompat2.d(i2 - localeListCompat.l());
            if (d2 != null) {
                linkedHashSet.add(d2);
            }
            i2++;
        }
        return LocaleListCompat.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    static LocaleListCompat b(LocaleList localeList, LocaleList localeList2) {
        return (localeList == null || s.a(localeList)) ? LocaleListCompat.g() : a(LocaleListCompat.o(localeList), LocaleListCompat.o(localeList2));
    }

    static LocaleListCompat c(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        return (localeListCompat == null || localeListCompat.j()) ? LocaleListCompat.g() : a(localeListCompat, localeListCompat2);
    }
}
