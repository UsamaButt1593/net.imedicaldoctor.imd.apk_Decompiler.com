package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a=\u0010\u0006\u001a\u00020\u00052.\u0010\u0004\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000\"\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "Lkotlin/Pair;", "", "", "pairs", "Landroid/os/Bundle;", "b", "([Lkotlin/Pair;)Landroid/os/Bundle;", "a", "()Landroid/os/Bundle;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class BundleKt {
    @NotNull
    public static final Bundle a() {
        return new Bundle(0);
    }

    @NotNull
    public static final Bundle b(@NotNull Pair<String, ? extends Object>... pairArr) {
        Bundle bundle = new Bundle(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            String a2 = pair.a();
            Object b2 = pair.b();
            if (b2 == null) {
                bundle.putString(a2, (String) null);
            } else if (b2 instanceof Boolean) {
                bundle.putBoolean(a2, ((Boolean) b2).booleanValue());
            } else if (b2 instanceof Byte) {
                bundle.putByte(a2, ((Number) b2).byteValue());
            } else if (b2 instanceof Character) {
                bundle.putChar(a2, ((Character) b2).charValue());
            } else if (b2 instanceof Double) {
                bundle.putDouble(a2, ((Number) b2).doubleValue());
            } else if (b2 instanceof Float) {
                bundle.putFloat(a2, ((Number) b2).floatValue());
            } else if (b2 instanceof Integer) {
                bundle.putInt(a2, ((Number) b2).intValue());
            } else if (b2 instanceof Long) {
                bundle.putLong(a2, ((Number) b2).longValue());
            } else if (b2 instanceof Short) {
                bundle.putShort(a2, ((Number) b2).shortValue());
            } else if (b2 instanceof Bundle) {
                bundle.putBundle(a2, (Bundle) b2);
            } else if (b2 instanceof CharSequence) {
                bundle.putCharSequence(a2, (CharSequence) b2);
            } else if (b2 instanceof Parcelable) {
                bundle.putParcelable(a2, (Parcelable) b2);
            } else if (b2 instanceof boolean[]) {
                bundle.putBooleanArray(a2, (boolean[]) b2);
            } else if (b2 instanceof byte[]) {
                bundle.putByteArray(a2, (byte[]) b2);
            } else if (b2 instanceof char[]) {
                bundle.putCharArray(a2, (char[]) b2);
            } else if (b2 instanceof double[]) {
                bundle.putDoubleArray(a2, (double[]) b2);
            } else if (b2 instanceof float[]) {
                bundle.putFloatArray(a2, (float[]) b2);
            } else if (b2 instanceof int[]) {
                bundle.putIntArray(a2, (int[]) b2);
            } else if (b2 instanceof long[]) {
                bundle.putLongArray(a2, (long[]) b2);
            } else if (b2 instanceof short[]) {
                bundle.putShortArray(a2, (short[]) b2);
            } else {
                if (b2 instanceof Object[]) {
                    Class<?> componentType = b2.getClass().getComponentType();
                    Intrinsics.m(componentType);
                    if (Parcelable.class.isAssignableFrom(componentType)) {
                        Intrinsics.n(b2, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                        bundle.putParcelableArray(a2, (Parcelable[]) b2);
                    } else if (String.class.isAssignableFrom(componentType)) {
                        Intrinsics.n(b2, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                        bundle.putStringArray(a2, (String[]) b2);
                    } else if (CharSequence.class.isAssignableFrom(componentType)) {
                        Intrinsics.n(b2, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                        bundle.putCharSequenceArray(a2, (CharSequence[]) b2);
                    } else if (!Serializable.class.isAssignableFrom(componentType)) {
                        throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + a2 + '\"');
                    }
                } else if (!(b2 instanceof Serializable)) {
                    if (b2 instanceof IBinder) {
                        bundle.putBinder(a2, (IBinder) b2);
                    } else if (b2 instanceof Size) {
                        BundleApi21ImplKt.a(bundle, a2, (Size) b2);
                    } else if (b2 instanceof SizeF) {
                        BundleApi21ImplKt.b(bundle, a2, (SizeF) b2);
                    } else {
                        throw new IllegalArgumentException("Illegal value type " + b2.getClass().getCanonicalName() + " for key \"" + a2 + '\"');
                    }
                }
                bundle.putSerializable(a2, (Serializable) b2);
            }
        }
        return bundle;
    }
}
