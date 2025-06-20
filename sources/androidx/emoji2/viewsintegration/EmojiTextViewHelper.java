package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;

public final class EmojiTextViewHelper {

    /* renamed from: a  reason: collision with root package name */
    private final HelperInternal f7799a;

    static class HelperInternal {
        HelperInternal() {
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        public boolean b() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z) {
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z) {
        }

        /* access modifiers changed from: package-private */
        public void e() {
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public TransformationMethod f(@Nullable TransformationMethod transformationMethod) {
            return transformationMethod;
        }
    }

    @RequiresApi(19)
    private static class HelperInternal19 extends HelperInternal {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f7800a;

        /* renamed from: b  reason: collision with root package name */
        private final EmojiInputFilter f7801b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7802c = true;

        HelperInternal19(TextView textView) {
            this.f7800a = textView;
            this.f7801b = new EmojiInputFilter(textView);
        }

        @NonNull
        private InputFilter[] g(@NonNull InputFilter[] inputFilterArr) {
            for (EmojiInputFilter emojiInputFilter : inputFilterArr) {
                if (emojiInputFilter == this.f7801b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, r0);
            inputFilterArr2[r0] = this.f7801b;
            return inputFilterArr2;
        }

        private SparseArray<InputFilter> h(@NonNull InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i2 = 0; i2 < inputFilterArr.length; i2++) {
                InputFilter inputFilter = inputFilterArr[i2];
                if (inputFilter instanceof EmojiInputFilter) {
                    sparseArray.put(i2, inputFilter);
                }
            }
            return sparseArray;
        }

        @NonNull
        private InputFilter[] i(@NonNull InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> h2 = h(inputFilterArr);
            if (h2.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length - h2.size())];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (h2.indexOfKey(i3) < 0) {
                    inputFilterArr2[i2] = inputFilterArr[i3];
                    i2++;
                }
            }
            return inputFilterArr2;
        }

        @Nullable
        private TransformationMethod k(@Nullable TransformationMethod transformationMethod) {
            return transformationMethod instanceof EmojiTransformationMethod ? ((EmojiTransformationMethod) transformationMethod).a() : transformationMethod;
        }

        private void l() {
            this.f7800a.setFilters(a(this.f7800a.getFilters()));
        }

        @NonNull
        private TransformationMethod m(@Nullable TransformationMethod transformationMethod) {
            return (!(transformationMethod instanceof EmojiTransformationMethod) && !(transformationMethod instanceof PasswordTransformationMethod)) ? new EmojiTransformationMethod(transformationMethod) : transformationMethod;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            return !this.f7802c ? i(inputFilterArr) : g(inputFilterArr);
        }

        public boolean b() {
            return this.f7802c;
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z) {
            if (z) {
                e();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z) {
            this.f7802c = z;
            e();
            l();
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f7800a.setTransformationMethod(f(this.f7800a.getTransformationMethod()));
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public TransformationMethod f(@Nullable TransformationMethod transformationMethod) {
            return this.f7802c ? m(transformationMethod) : k(transformationMethod);
        }

        /* access modifiers changed from: package-private */
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void j(boolean z) {
            this.f7802c = z;
        }
    }

    @RequiresApi(19)
    private static class SkippingHelper19 extends HelperInternal {

        /* renamed from: a  reason: collision with root package name */
        private final HelperInternal19 f7803a;

        SkippingHelper19(TextView textView) {
            this.f7803a = new HelperInternal19(textView);
        }

        private boolean g() {
            return !EmojiCompat.q();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            return g() ? inputFilterArr : this.f7803a.a(inputFilterArr);
        }

        public boolean b() {
            return this.f7803a.b();
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z) {
            if (!g()) {
                this.f7803a.c(z);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z) {
            if (g()) {
                this.f7803a.j(z);
            } else {
                this.f7803a.d(z);
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (!g()) {
                this.f7803a.e();
            }
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public TransformationMethod f(@Nullable TransformationMethod transformationMethod) {
            return g() ? transformationMethod : this.f7803a.f(transformationMethod);
        }
    }

    public EmojiTextViewHelper(@NonNull TextView textView) {
        this(textView, true);
    }

    @NonNull
    public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
        return this.f7799a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f7799a.b();
    }

    public void c(boolean z) {
        this.f7799a.c(z);
    }

    public void d(boolean z) {
        this.f7799a.d(z);
    }

    public void e() {
        this.f7799a.e();
    }

    @Nullable
    public TransformationMethod f(@Nullable TransformationMethod transformationMethod) {
        return this.f7799a.f(transformationMethod);
    }

    public EmojiTextViewHelper(@NonNull TextView textView, boolean z) {
        Preconditions.m(textView, "textView cannot be null");
        this.f7799a = !z ? new SkippingHelper19(textView) : new HelperInternal19(textView);
    }
}
