package androidx.core.telephony.mbms;

import android.content.Context;
import android.os.Build;
import android.telephony.mbms.ServiceInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Locale;
import java.util.Set;

public final class MbmsHelper {

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        static CharSequence a(Context context, ServiceInfo serviceInfo) {
            Set<Locale> namedContentLocales = serviceInfo.getNamedContentLocales();
            if (namedContentLocales.isEmpty()) {
                return null;
            }
            String[] strArr = new String[namedContentLocales.size()];
            int i2 = 0;
            for (Locale languageTag : serviceInfo.getNamedContentLocales()) {
                strArr[i2] = languageTag.toLanguageTag();
                i2++;
            }
            Locale firstMatch = context.getResources().getConfiguration().getLocales().getFirstMatch(strArr);
            if (firstMatch == null) {
                return null;
            }
            return serviceInfo.getNameForLocale(firstMatch);
        }
    }

    private MbmsHelper() {
    }

    @Nullable
    public static CharSequence a(@NonNull Context context, @NonNull ServiceInfo serviceInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.a(context, serviceInfo);
        }
        return null;
    }
}
