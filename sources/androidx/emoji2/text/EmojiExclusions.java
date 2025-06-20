package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Collections;
import java.util.Set;

class EmojiExclusions {

    @RequiresApi(34)
    private static class EmojiExclusions_Api34 {
        private EmojiExclusions_Api34() {
        }

        @DoNotInline
        @NonNull
        static Set<int[]> a() {
            return EmojiExclusions_Reflections.a();
        }
    }

    private static class EmojiExclusions_Reflections {
        private EmojiExclusions_Reflections() {
        }

        @SuppressLint({"BanUncheckedReflection"})
        @NonNull
        static Set<int[]> a() {
            try {
                Object invoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", (Class[]) null).invoke((Object) null, (Object[]) null);
                if (invoke == null) {
                    return Collections.emptySet();
                }
                Set<int[]> set = (Set) invoke;
                for (int[] iArr : set) {
                    if (!(iArr instanceof int[])) {
                        return Collections.emptySet();
                    }
                }
                return set;
            } catch (Throwable unused) {
                return Collections.emptySet();
            }
        }
    }

    private EmojiExclusions() {
    }

    @NonNull
    static Set<int[]> a() {
        return Build.VERSION.SDK_INT >= 34 ? EmojiExclusions_Api34.a() : EmojiExclusions_Reflections.a();
    }
}
