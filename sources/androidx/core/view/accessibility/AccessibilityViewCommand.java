package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

public interface AccessibilityViewCommand {

    public static abstract class CommandArguments {

        /* renamed from: a  reason: collision with root package name */
        Bundle f6688a;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void a(@Nullable Bundle bundle) {
            this.f6688a = bundle;
        }
    }

    public static final class MoveAtGranularityArguments extends CommandArguments {
        public boolean b() {
            return this.f6688a.getBoolean(AccessibilityNodeInfoCompat.Y);
        }

        public int c() {
            return this.f6688a.getInt(AccessibilityNodeInfoCompat.W);
        }
    }

    public static final class MoveHtmlArguments extends CommandArguments {
        @Nullable
        public String b() {
            return this.f6688a.getString(AccessibilityNodeInfoCompat.X);
        }
    }

    public static final class MoveWindowArguments extends CommandArguments {
        public int b() {
            return this.f6688a.getInt(AccessibilityNodeInfoCompat.f0);
        }

        public int c() {
            return this.f6688a.getInt(AccessibilityNodeInfoCompat.g0);
        }
    }

    public static final class ScrollToPositionArguments extends CommandArguments {
        public int b() {
            return this.f6688a.getInt(AccessibilityNodeInfoCompat.d0);
        }

        public int c() {
            return this.f6688a.getInt(AccessibilityNodeInfoCompat.c0);
        }
    }

    public static final class SetProgressArguments extends CommandArguments {
        public float b() {
            return this.f6688a.getFloat(AccessibilityNodeInfoCompat.e0);
        }
    }

    public static final class SetSelectionArguments extends CommandArguments {
        public int b() {
            return this.f6688a.getInt(AccessibilityNodeInfoCompat.a0);
        }

        public int c() {
            return this.f6688a.getInt(AccessibilityNodeInfoCompat.Z);
        }
    }

    public static final class SetTextArguments extends CommandArguments {
        @Nullable
        public CharSequence b() {
            return this.f6688a.getCharSequence(AccessibilityNodeInfoCompat.b0);
        }
    }

    boolean a(@NonNull View view, @Nullable CommandArguments commandArguments);
}
