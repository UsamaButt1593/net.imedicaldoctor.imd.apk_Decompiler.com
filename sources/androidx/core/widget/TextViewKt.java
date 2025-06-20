package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001az\u0010\r\u001a\u00020\f*\u00020\u00002d\b\u0004\u0010\u000b\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0001H\b¢\u0006\u0004\b\r\u0010\u000e\u001az\u0010\u0010\u001a\u00020\f*\u00020\u00002d\b\u0004\u0010\u000b\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\n0\u0001H\b¢\u0006\u0004\b\u0010\u0010\u000e\u001a;\u0010\u0013\u001a\u00020\f*\u00020\u00002%\b\u0004\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\n0\u0011H\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0002\u0010\u0018\u001a\u00020\f*\u00020\u00002d\b\u0006\u0010\u0015\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00012d\b\u0006\u0010\u0016\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\n0\u00012%\b\u0006\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\n0\u0011H\b¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroid/widget/TextView;", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "text", "", "start", "count", "after", "", "action", "Landroid/text/TextWatcher;", "d", "(Landroid/widget/TextView;Lkotlin/jvm/functions/Function4;)Landroid/text/TextWatcher;", "before", "e", "Lkotlin/Function1;", "Landroid/text/Editable;", "c", "(Landroid/widget/TextView;Lkotlin/jvm/functions/Function1;)Landroid/text/TextWatcher;", "beforeTextChanged", "onTextChanged", "afterTextChanged", "a", "(Landroid/widget/TextView;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;)Landroid/text/TextWatcher;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,97:1\n65#1:98\n77#1,4:99\n93#1,3:103\n65#1,16:106\n93#1,3:122\n65#1,16:125\n93#1,3:141\n*S KotlinDebug\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n35#1:98\n35#1:99,4\n35#1:103,3\n49#1:106,16\n49#1:122,3\n58#1:125,16\n58#1:141,3\n*E\n"})
public final class TextViewKt {
    @NotNull
    public static final TextWatcher a(@NotNull TextView textView, @NotNull Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4, @NotNull Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function42, @NotNull Function1<? super Editable, Unit> function1) {
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(function1, function4, function42);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static /* synthetic */ TextWatcher b(TextView textView, Function4 function4, Function4 function42, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function4 = TextViewKt$addTextChangedListener$1.X;
        }
        if ((i2 & 2) != 0) {
            function42 = TextViewKt$addTextChangedListener$2.X;
        }
        if ((i2 & 4) != 0) {
            function1 = TextViewKt$addTextChangedListener$3.X;
        }
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(function1, function4, function42);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    @NotNull
    public static final TextWatcher c(@NotNull TextView textView, @NotNull Function1<? super Editable, Unit> function1) {
        TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1 textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1 = new TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1(function1);
        textView.addTextChangedListener(textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1);
        return textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1;
    }

    @NotNull
    public static final TextWatcher d(@NotNull TextView textView, @NotNull Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1 textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1 = new TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1(function4);
        textView.addTextChangedListener(textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1);
        return textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1;
    }

    @NotNull
    public static final TextWatcher e(@NotNull TextView textView, @NotNull Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1 textViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1 = new TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1(function4);
        textView.addTextChangedListener(textViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1);
        return textViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1;
    }
}
