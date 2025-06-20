package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Half;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nHalf.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Half.kt\nandroidx/core/util/HalfKt\n*L\n1#1,60:1\n43#1:61\n*S KotlinDebug\n*F\n+ 1 Half.kt\nandroidx/core/util/HalfKt\n*L\n51#1:61\n*E\n"})
@SuppressLint({"ClassVerificationFailure"})
@Metadata(d1 = {"\u0000$\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0004H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u0007H\b¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\nH\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"", "Landroid/util/Half;", "d", "(S)Landroid/util/Half;", "", "b", "(F)Landroid/util/Half;", "", "a", "(D)Landroid/util/Half;", "", "c", "(Ljava/lang/String;)Landroid/util/Half;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class HalfKt {
    @RequiresApi(26)
    @NotNull
    public static final Half a(double d2) {
        return Half.valueOf((float) d2);
    }

    @RequiresApi(26)
    @NotNull
    public static final Half b(float f2) {
        return Half.valueOf(f2);
    }

    @RequiresApi(26)
    @NotNull
    public static final Half c(@NotNull String str) {
        return Half.valueOf(str);
    }

    @RequiresApi(26)
    @NotNull
    public static final Half d(short s) {
        return Half.valueOf(s);
    }
}
