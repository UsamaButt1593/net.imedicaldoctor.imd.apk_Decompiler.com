package androidx.core.content.pm;

import androidx.annotation.AnyThread;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ShortcutInfoCompatSaver<T> {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class NoopImpl extends ShortcutInfoCompatSaver<Void> {
        /* renamed from: e */
        public Void a(List<ShortcutInfoCompat> list) {
            return null;
        }

        /* renamed from: f */
        public Void c() {
            return null;
        }

        /* renamed from: g */
        public Void d(List<String> list) {
            return null;
        }
    }

    @AnyThread
    public abstract T a(List<ShortcutInfoCompat> list);

    @WorkerThread
    public List<ShortcutInfoCompat> b() throws Exception {
        return new ArrayList();
    }

    @AnyThread
    public abstract T c();

    @AnyThread
    public abstract T d(List<String> list);
}
