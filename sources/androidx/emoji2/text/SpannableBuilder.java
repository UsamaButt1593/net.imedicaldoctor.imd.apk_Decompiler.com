package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SpannableBuilder extends SpannableStringBuilder {
    @NonNull
    private final List<WatcherWrapper> X = new ArrayList();
    @NonNull
    private final Class<?> s;

    private static class WatcherWrapper implements TextWatcher, SpanWatcher {
        private final AtomicInteger X = new AtomicInteger(0);
        final Object s;

        WatcherWrapper(Object obj) {
            this.s = obj;
        }

        private boolean b(Object obj) {
            return obj instanceof EmojiSpan;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.X.incrementAndGet();
        }

        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.s).afterTextChanged(editable);
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ((TextWatcher) this.s).beforeTextChanged(charSequence, i2, i3, i4);
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            this.X.decrementAndGet();
        }

        public void onSpanAdded(Spannable spannable, Object obj, int i2, int i3) {
            if (this.X.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.s).onSpanAdded(spannable, obj, i2, i3);
            }
        }

        public void onSpanChanged(Spannable spannable, Object obj, int i2, int i3, int i4, int i5) {
            int i6;
            int i7;
            if (this.X.get() <= 0 || !b(obj)) {
                if (Build.VERSION.SDK_INT < 28) {
                    if (i2 > i3) {
                        i2 = 0;
                    }
                    if (i4 > i5) {
                        i7 = i2;
                        i6 = 0;
                        ((SpanWatcher) this.s).onSpanChanged(spannable, obj, i7, i3, i6, i5);
                    }
                }
                i7 = i2;
                i6 = i4;
                ((SpanWatcher) this.s).onSpanChanged(spannable, obj, i7, i3, i6, i5);
            }
        }

        public void onSpanRemoved(Spannable spannable, Object obj, int i2, int i3) {
            if (this.X.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.s).onSpanRemoved(spannable, obj, i2, i3);
            }
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ((TextWatcher) this.s).onTextChanged(charSequence, i2, i3, i4);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    SpannableBuilder(@NonNull Class<?> cls) {
        Preconditions.m(cls, "watcherClass cannot be null");
        this.s = cls;
    }

    private void b() {
        for (int i2 = 0; i2 < this.X.size(); i2++) {
            this.X.get(i2).a();
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static SpannableBuilder c(@NonNull Class<?> cls, @NonNull CharSequence charSequence) {
        return new SpannableBuilder(cls, charSequence);
    }

    private void e() {
        for (int i2 = 0; i2 < this.X.size(); i2++) {
            this.X.get(i2).onTextChanged(this, 0, length(), length());
        }
    }

    private WatcherWrapper f(Object obj) {
        for (int i2 = 0; i2 < this.X.size(); i2++) {
            WatcherWrapper watcherWrapper = this.X.get(i2);
            if (watcherWrapper.s == obj) {
                return watcherWrapper;
            }
        }
        return null;
    }

    private boolean g(@NonNull Class<?> cls) {
        return this.s == cls;
    }

    private boolean h(@Nullable Object obj) {
        return obj != null && g(obj.getClass());
    }

    private void i() {
        for (int i2 = 0; i2 < this.X.size(); i2++) {
            this.X.get(i2).c();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a() {
        b();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void d() {
        i();
        e();
    }

    public int getSpanEnd(@Nullable Object obj) {
        WatcherWrapper f2;
        if (h(obj) && (f2 = f(obj)) != null) {
            obj = f2;
        }
        return super.getSpanEnd(obj);
    }

    public int getSpanFlags(@Nullable Object obj) {
        WatcherWrapper f2;
        if (h(obj) && (f2 = f(obj)) != null) {
            obj = f2;
        }
        return super.getSpanFlags(obj);
    }

    public int getSpanStart(@Nullable Object obj) {
        WatcherWrapper f2;
        if (h(obj) && (f2 = f(obj)) != null) {
            obj = f2;
        }
        return super.getSpanStart(obj);
    }

    @SuppressLint({"UnknownNullness"})
    public <T> T[] getSpans(int i2, int i3, @NonNull Class<T> cls) {
        if (!g(cls)) {
            return super.getSpans(i2, i3, cls);
        }
        WatcherWrapper[] watcherWrapperArr = (WatcherWrapper[]) super.getSpans(i2, i3, WatcherWrapper.class);
        T[] tArr = (Object[]) Array.newInstance(cls, watcherWrapperArr.length);
        for (int i4 = 0; i4 < watcherWrapperArr.length; i4++) {
            tArr[i4] = watcherWrapperArr[i4].s;
        }
        return tArr;
    }

    public int nextSpanTransition(int i2, int i3, @Nullable Class<WatcherWrapper> cls) {
        if (cls == null || g(cls)) {
            cls = WatcherWrapper.class;
        }
        return super.nextSpanTransition(i2, i3, cls);
    }

    public void removeSpan(@Nullable Object obj) {
        WatcherWrapper watcherWrapper;
        if (h(obj)) {
            watcherWrapper = f(obj);
            if (watcherWrapper != null) {
                obj = watcherWrapper;
            }
        } else {
            watcherWrapper = null;
        }
        super.removeSpan(obj);
        if (watcherWrapper != null) {
            this.X.remove(watcherWrapper);
        }
    }

    public void setSpan(@Nullable Object obj, int i2, int i3, int i4) {
        if (h(obj)) {
            WatcherWrapper watcherWrapper = new WatcherWrapper(obj);
            this.X.add(watcherWrapper);
            obj = watcherWrapper;
        }
        super.setSpan(obj, i2, i3, i4);
    }

    @SuppressLint({"UnknownNullness"})
    public CharSequence subSequence(int i2, int i3) {
        return new SpannableBuilder(this.s, this, i2, i3);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    SpannableBuilder(@NonNull Class<?> cls, @NonNull CharSequence charSequence) {
        super(charSequence);
        Preconditions.m(cls, "watcherClass cannot be null");
        this.s = cls;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder delete(int i2, int i3) {
        super.delete(i2, i3);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    SpannableBuilder(@NonNull Class<?> cls, @NonNull CharSequence charSequence, int i2, int i3) {
        super(charSequence, i2, i3);
        Preconditions.m(cls, "watcherClass cannot be null");
        this.s = cls;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i2, CharSequence charSequence) {
        super.insert(i2, charSequence);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i2, int i3, CharSequence charSequence) {
        b();
        super.replace(i2, i3, charSequence);
        i();
        return this;
    }

    @NonNull
    public SpannableStringBuilder append(char c2) {
        super.append(c2);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i2, CharSequence charSequence, int i3, int i4) {
        super.insert(i2, charSequence, i3, i4);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i2, int i3, CharSequence charSequence, int i4, int i5) {
        b();
        super.replace(i2, i3, charSequence, i4, i5);
        i();
        return this;
    }

    @NonNull
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @NonNull
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i2, int i3) {
        super.append(charSequence, i2, i3);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i2) {
        super.append(charSequence, obj, i2);
        return this;
    }
}
