package androidx.core.os;

import android.os.LocaleList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Locale;

@RequiresApi(24)
final class LocaleListPlatformWrapper implements LocaleListInterface {

    /* renamed from: a  reason: collision with root package name */
    private final LocaleList f6067a;

    LocaleListPlatformWrapper(Object obj) {
        this.f6067a = b.a(obj);
    }

    public int a(Locale locale) {
        return this.f6067a.indexOf(locale);
    }

    public String b() {
        return this.f6067a.toLanguageTags();
    }

    public Object c() {
        return this.f6067a;
    }

    @Nullable
    public Locale d(@NonNull String[] strArr) {
        return this.f6067a.getFirstMatch(strArr);
    }

    public boolean equals(Object obj) {
        return this.f6067a.equals(((LocaleListInterface) obj).c());
    }

    public Locale get(int i2) {
        return this.f6067a.get(i2);
    }

    public int hashCode() {
        return this.f6067a.hashCode();
    }

    public boolean isEmpty() {
        return this.f6067a.isEmpty();
    }

    public int size() {
        return this.f6067a.size();
    }

    public String toString() {
        return this.f6067a.toString();
    }
}
