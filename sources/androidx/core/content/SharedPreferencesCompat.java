package androidx.core.content;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;

@Deprecated
public final class SharedPreferencesCompat {

    @Deprecated
    public static final class EditorCompat {

        /* renamed from: b  reason: collision with root package name */
        private static EditorCompat f5681b;

        /* renamed from: a  reason: collision with root package name */
        private final Helper f5682a = new Helper();

        private static class Helper {
            Helper() {
            }

            public void a(@NonNull SharedPreferences.Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError unused) {
                    editor.commit();
                }
            }
        }

        private EditorCompat() {
        }

        @Deprecated
        public static EditorCompat b() {
            if (f5681b == null) {
                f5681b = new EditorCompat();
            }
            return f5681b;
        }

        @Deprecated
        public void a(@NonNull SharedPreferences.Editor editor) {
            this.f5682a.a(editor);
        }
    }

    private SharedPreferencesCompat() {
    }
}
