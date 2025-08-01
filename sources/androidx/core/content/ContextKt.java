package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\"\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\u0003\u0010\u0004\u001aU\u0010\u0011\u001a\u00020\u000e*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a?\u0010\u0014\u001a\u00020\u000e*\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\b¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"", "T", "Landroid/content/Context;", "a", "(Landroid/content/Context;)Ljava/lang/Object;", "Landroid/util/AttributeSet;", "set", "", "attrs", "", "defStyleAttr", "defStyleRes", "Lkotlin/Function1;", "Landroid/content/res/TypedArray;", "", "Lkotlin/ExtensionFunctionType;", "block", "c", "(Landroid/content/Context;Landroid/util/AttributeSet;[IIILkotlin/jvm/functions/Function1;)V", "resourceId", "b", "(Landroid/content/Context;I[ILkotlin/jvm/functions/Function1;)V", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class ContextKt {
    public static final void b(@NotNull Context context, @StyleRes int i2, @NotNull int[] iArr, @NotNull Function1<? super TypedArray, Unit> function1) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, iArr);
        function1.f(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void c(@NotNull Context context, @Nullable AttributeSet attributeSet, @NotNull int[] iArr, @AttrRes int i2, @StyleRes int i3, @NotNull Function1<? super TypedArray, Unit> function1) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        function1.f(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void d(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, Function1 function1, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            attributeSet = null;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        function1.f(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
