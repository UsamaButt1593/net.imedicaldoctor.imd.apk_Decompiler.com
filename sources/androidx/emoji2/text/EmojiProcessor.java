package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import java.util.Arrays;
import java.util.Set;

@RequiresApi(19)
@AnyThread
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiProcessor {

    /* renamed from: f  reason: collision with root package name */
    private static final int f7611f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static final int f7612g = 2;

    /* renamed from: h  reason: collision with root package name */
    private static final int f7613h = 3;

    /* renamed from: i  reason: collision with root package name */
    private static final int f7614i = 16;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final EmojiCompat.SpanFactory f7615a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final MetadataRepo f7616b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private EmojiCompat.GlyphChecker f7617c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f7618d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final int[] f7619e;

    @RequiresApi(19)
    private static final class CodepointIndexFinder {

        /* renamed from: a  reason: collision with root package name */
        private static final int f7620a = -1;

        private CodepointIndexFinder() {
        }

        static int a(CharSequence charSequence, int i2, int i3) {
            int length = charSequence.length();
            if (i2 < 0 || length < i2 || i3 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i3 != 0) {
                    i2--;
                    if (i2 < 0) {
                        return z ? -1 : 0;
                    }
                    char charAt = charSequence.charAt(i2);
                    if (z) {
                        if (!Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        i3--;
                    } else if (!Character.isSurrogate(charAt)) {
                        i3--;
                    } else if (Character.isHighSurrogate(charAt)) {
                        return -1;
                    } else {
                        z = true;
                    }
                }
                return i2;
            }
        }

        static int b(CharSequence charSequence, int i2, int i3) {
            int length = charSequence.length();
            if (i2 < 0 || length < i2 || i3 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i3 != 0) {
                    if (r7 < length) {
                        char charAt = charSequence.charAt(r7);
                        if (z) {
                            if (!Character.isLowSurrogate(charAt)) {
                                return -1;
                            }
                            i3--;
                            i2 = r7 + 1;
                        } else if (!Character.isSurrogate(charAt)) {
                            i3--;
                            r7++;
                        } else if (Character.isLowSurrogate(charAt)) {
                            return -1;
                        } else {
                            r7++;
                            z = true;
                        }
                    } else if (z) {
                        return -1;
                    } else {
                        return length;
                    }
                }
                return r7;
            }
        }
    }

    private static class EmojiProcessAddSpanCallback implements EmojiProcessCallback<UnprecomputeTextOnModificationSpannable> {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public UnprecomputeTextOnModificationSpannable f7621a;

        /* renamed from: b  reason: collision with root package name */
        private final EmojiCompat.SpanFactory f7622b;

        EmojiProcessAddSpanCallback(@Nullable UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable, EmojiCompat.SpanFactory spanFactory) {
            this.f7621a = unprecomputeTextOnModificationSpannable;
            this.f7622b = spanFactory;
        }

        public boolean b(@NonNull CharSequence charSequence, int i2, int i3, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            if (typefaceEmojiRasterizer.m()) {
                return true;
            }
            if (this.f7621a == null) {
                this.f7621a = new UnprecomputeTextOnModificationSpannable(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
            }
            this.f7621a.setSpan(this.f7622b.a(typefaceEmojiRasterizer), i2, i3, 33);
            return true;
        }

        /* renamed from: c */
        public UnprecomputeTextOnModificationSpannable a() {
            return this.f7621a;
        }
    }

    private interface EmojiProcessCallback<T> {
        T a();

        boolean b(@NonNull CharSequence charSequence, int i2, int i3, TypefaceEmojiRasterizer typefaceEmojiRasterizer);
    }

    private static class EmojiProcessLookupCallback implements EmojiProcessCallback<EmojiProcessLookupCallback> {

        /* renamed from: a  reason: collision with root package name */
        private final int f7623a;

        /* renamed from: b  reason: collision with root package name */
        public int f7624b = -1;

        /* renamed from: c  reason: collision with root package name */
        public int f7625c = -1;

        EmojiProcessLookupCallback(int i2) {
            this.f7623a = i2;
        }

        public boolean b(@NonNull CharSequence charSequence, int i2, int i3, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            int i4 = this.f7623a;
            if (i2 > i4 || i4 >= i3) {
                return i3 <= i4;
            }
            this.f7624b = i2;
            this.f7625c = i3;
            return false;
        }

        /* renamed from: c */
        public EmojiProcessLookupCallback a() {
            return this;
        }
    }

    private static class MarkExclusionCallback implements EmojiProcessCallback<MarkExclusionCallback> {

        /* renamed from: a  reason: collision with root package name */
        private final String f7626a;

        MarkExclusionCallback(String str) {
            this.f7626a = str;
        }

        public boolean b(@NonNull CharSequence charSequence, int i2, int i3, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            if (!TextUtils.equals(charSequence.subSequence(i2, i3), this.f7626a)) {
                return true;
            }
            typefaceEmojiRasterizer.o(true);
            return false;
        }

        /* renamed from: c */
        public MarkExclusionCallback a() {
            return this;
        }
    }

    static final class ProcessorSm {

        /* renamed from: i  reason: collision with root package name */
        private static final int f7627i = 1;

        /* renamed from: j  reason: collision with root package name */
        private static final int f7628j = 2;

        /* renamed from: a  reason: collision with root package name */
        private int f7629a = 1;

        /* renamed from: b  reason: collision with root package name */
        private final MetadataRepo.Node f7630b;

        /* renamed from: c  reason: collision with root package name */
        private MetadataRepo.Node f7631c;

        /* renamed from: d  reason: collision with root package name */
        private MetadataRepo.Node f7632d;

        /* renamed from: e  reason: collision with root package name */
        private int f7633e;

        /* renamed from: f  reason: collision with root package name */
        private int f7634f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f7635g;

        /* renamed from: h  reason: collision with root package name */
        private final int[] f7636h;

        ProcessorSm(MetadataRepo.Node node, boolean z, int[] iArr) {
            this.f7630b = node;
            this.f7631c = node;
            this.f7635g = z;
            this.f7636h = iArr;
        }

        private static boolean d(int i2) {
            return i2 == 65039;
        }

        private static boolean f(int i2) {
            return i2 == 65038;
        }

        private int g() {
            this.f7629a = 1;
            this.f7631c = this.f7630b;
            this.f7634f = 0;
            return 1;
        }

        private boolean h() {
            if (this.f7631c.b().l() || d(this.f7633e)) {
                return true;
            }
            if (this.f7635g) {
                if (this.f7636h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f7636h, this.f7631c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public int a(int i2) {
            MetadataRepo.Node a2 = this.f7631c.a(i2);
            int i3 = 2;
            if (this.f7629a == 2) {
                if (a2 != null) {
                    this.f7631c = a2;
                    this.f7634f++;
                } else if (!f(i2)) {
                    if (!d(i2)) {
                        if (this.f7631c.b() != null) {
                            i3 = 3;
                            if (this.f7634f != 1 || h()) {
                                this.f7632d = this.f7631c;
                                g();
                            }
                        }
                    }
                }
                this.f7633e = i2;
                return i3;
            } else if (a2 != null) {
                this.f7629a = 2;
                this.f7631c = a2;
                this.f7634f = 1;
                this.f7633e = i2;
                return i3;
            }
            i3 = g();
            this.f7633e = i2;
            return i3;
        }

        /* access modifiers changed from: package-private */
        public TypefaceEmojiRasterizer b() {
            return this.f7631c.b();
        }

        /* access modifiers changed from: package-private */
        public TypefaceEmojiRasterizer c() {
            return this.f7632d.b();
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            return this.f7629a == 2 && this.f7631c.b() != null && (this.f7634f > 1 || h());
        }
    }

    EmojiProcessor(@NonNull MetadataRepo metadataRepo, @NonNull EmojiCompat.SpanFactory spanFactory, @NonNull EmojiCompat.GlyphChecker glyphChecker, boolean z, @Nullable int[] iArr, @NonNull Set<int[]> set) {
        this.f7615a = spanFactory;
        this.f7616b = metadataRepo;
        this.f7617c = glyphChecker;
        this.f7618d = z;
        this.f7619e = iArr;
        k(set);
    }

    private static boolean a(@NonNull Editable editable, @NonNull KeyEvent keyEvent, boolean z) {
        EmojiSpan[] emojiSpanArr;
        if (j(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!i(selectionStart, selectionEnd) && (emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
            int length = emojiSpanArr.length;
            int i2 = 0;
            while (i2 < length) {
                EmojiSpan emojiSpan = emojiSpanArr[i2];
                int spanStart = editable.getSpanStart(emojiSpan);
                int spanEnd = editable.getSpanEnd(emojiSpan);
                if ((!z || spanStart != selectionStart) && ((z || spanEnd != selectionStart) && (selectionStart <= spanStart || selectionStart >= spanEnd))) {
                    i2++;
                } else {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean f(@NonNull InputConnection inputConnection, @NonNull Editable editable, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, boolean z) {
        int i4;
        int i5;
        if (editable != null && inputConnection != null && i2 >= 0 && i3 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (i(selectionStart, selectionEnd)) {
                return false;
            }
            if (z) {
                i5 = CodepointIndexFinder.a(editable, selectionStart, Math.max(i2, 0));
                i4 = CodepointIndexFinder.b(editable, selectionEnd, Math.max(i3, 0));
                if (i5 == -1 || i4 == -1) {
                    return false;
                }
            } else {
                i5 = Math.max(selectionStart - i2, 0);
                i4 = Math.min(selectionEnd + i3, editable.length());
            }
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) editable.getSpans(i5, i4, EmojiSpan.class);
            if (emojiSpanArr != null && emojiSpanArr.length > 0) {
                for (EmojiSpan emojiSpan : emojiSpanArr) {
                    int spanStart = editable.getSpanStart(emojiSpan);
                    int spanEnd = editable.getSpanEnd(emojiSpan);
                    i5 = Math.min(spanStart, i5);
                    i4 = Math.max(spanEnd, i4);
                }
                int max = Math.max(i5, 0);
                int min = Math.min(i4, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max, min);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    static boolean g(@NonNull Editable editable, int i2, @NonNull KeyEvent keyEvent) {
        if (!(i2 != 67 ? i2 != 112 ? false : a(editable, keyEvent, true) : a(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean h(CharSequence charSequence, int i2, int i3, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if (typefaceEmojiRasterizer.e() == 0) {
            typefaceEmojiRasterizer.p(this.f7617c.a(charSequence, i2, i3, typefaceEmojiRasterizer.i()));
        }
        return typefaceEmojiRasterizer.e() == 2;
    }

    private static boolean i(int i2, int i3) {
        return i2 == -1 || i3 == -1 || i2 != i3;
    }

    private static boolean j(@NonNull KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    private void k(@NonNull Set<int[]> set) {
        if (!set.isEmpty()) {
            for (int[] next : set) {
                String str = new String(next, 0, next.length);
                m(str, 0, str.length(), 1, true, new MarkExclusionCallback(str));
            }
        }
    }

    private <T> T m(@NonNull CharSequence charSequence, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4, boolean z, EmojiProcessCallback<T> emojiProcessCallback) {
        int i5;
        ProcessorSm processorSm = new ProcessorSm(this.f7616b.i(), this.f7618d, this.f7619e);
        int codePointAt = Character.codePointAt(charSequence, i2);
        int i6 = 0;
        boolean z2 = true;
        loop0:
        while (true) {
            i5 = i2;
            while (i2 < i3 && i6 < i4 && z2) {
                int a2 = processorSm.a(codePointAt);
                if (a2 == 1) {
                    i5 += Character.charCount(Character.codePointAt(charSequence, i5));
                    if (i5 < i3) {
                        codePointAt = Character.codePointAt(charSequence, i5);
                    }
                    i2 = i5;
                } else if (a2 == 2) {
                    i2 += Character.charCount(codePointAt);
                    if (i2 < i3) {
                        codePointAt = Character.codePointAt(charSequence, i2);
                    }
                } else if (a2 == 3) {
                    if (z || !h(charSequence, i5, i2, processorSm.c())) {
                        z2 = emojiProcessCallback.b(charSequence, i5, i2, processorSm.c());
                        i6++;
                    }
                }
            }
        }
        if (processorSm.e() && i6 < i4 && z2 && (z || !h(charSequence, i5, i2, processorSm.b()))) {
            emojiProcessCallback.b(charSequence, i5, i2, processorSm.b());
        }
        return emojiProcessCallback.a();
    }

    /* access modifiers changed from: package-private */
    public int b(@NonNull CharSequence charSequence, @IntRange(from = 0) int i2) {
        if (i2 < 0 || i2 >= charSequence.length()) {
            return -1;
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) spanned.getSpans(i2, i2 + 1, EmojiSpan.class);
            if (emojiSpanArr.length > 0) {
                return spanned.getSpanEnd(emojiSpanArr[0]);
            }
        }
        return ((EmojiProcessLookupCallback) m(charSequence, Math.max(0, i2 - 16), Math.min(charSequence.length(), i2 + 16), Integer.MAX_VALUE, true, new EmojiProcessLookupCallback(i2))).f7625c;
    }

    /* access modifiers changed from: package-private */
    public int c(@NonNull CharSequence charSequence) {
        return d(charSequence, this.f7616b.h());
    }

    /* access modifiers changed from: package-private */
    public int d(@NonNull CharSequence charSequence, int i2) {
        ProcessorSm processorSm = new ProcessorSm(this.f7616b.i(), this.f7618d, this.f7619e);
        int length = charSequence.length();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length) {
            int codePointAt = Character.codePointAt(charSequence, i3);
            int a2 = processorSm.a(codePointAt);
            TypefaceEmojiRasterizer b2 = processorSm.b();
            if (a2 == 1) {
                i3 += Character.charCount(codePointAt);
                i5 = 0;
            } else if (a2 == 2) {
                i3 += Character.charCount(codePointAt);
            } else if (a2 == 3) {
                b2 = processorSm.c();
                if (b2.d() <= i2) {
                    i4++;
                }
            }
            if (b2 != null && b2.d() <= i2) {
                i5++;
            }
        }
        if (i4 != 0) {
            return 2;
        }
        if (!processorSm.e() || processorSm.b().d() > i2) {
            return i5 == 0 ? 0 : 2;
        }
        return 1;
    }

    /* access modifiers changed from: package-private */
    public int e(@NonNull CharSequence charSequence, @IntRange(from = 0) int i2) {
        if (i2 < 0 || i2 >= charSequence.length()) {
            return -1;
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) spanned.getSpans(i2, i2 + 1, EmojiSpan.class);
            if (emojiSpanArr.length > 0) {
                return spanned.getSpanStart(emojiSpanArr[0]);
            }
        }
        return ((EmojiProcessLookupCallback) m(charSequence, Math.max(0, i2 - 16), Math.min(charSequence.length(), i2 + 16), Integer.MAX_VALUE, true, new EmojiProcessLookupCallback(i2))).f7624b;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0049 A[Catch:{ all -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0066 A[Catch:{ all -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.CharSequence l(@androidx.annotation.NonNull java.lang.CharSequence r11, @androidx.annotation.IntRange(from = 0) int r12, @androidx.annotation.IntRange(from = 0) int r13, @androidx.annotation.IntRange(from = 0) int r14, boolean r15) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof androidx.emoji2.text.SpannableBuilder
            if (r0 == 0) goto L_0x000a
            r1 = r11
            androidx.emoji2.text.SpannableBuilder r1 = (androidx.emoji2.text.SpannableBuilder) r1
            r1.a()
        L_0x000a:
            java.lang.Class<androidx.emoji2.text.EmojiSpan> r1 = androidx.emoji2.text.EmojiSpan.class
            if (r0 != 0) goto L_0x002f
            boolean r2 = r11 instanceof android.text.Spannable     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x0013
            goto L_0x002f
        L_0x0013:
            boolean r2 = r11 instanceof android.text.Spanned     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x002d
            r2 = r11
            android.text.Spanned r2 = (android.text.Spanned) r2     // Catch:{ all -> 0x002a }
            int r3 = r12 + -1
            int r4 = r13 + 1
            int r2 = r2.nextSpanTransition(r3, r4, r1)     // Catch:{ all -> 0x002a }
            if (r2 > r13) goto L_0x002d
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r2 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch:{ all -> 0x002a }
            r2.<init>((java.lang.CharSequence) r11)     // Catch:{ all -> 0x002a }
            goto L_0x0037
        L_0x002a:
            r12 = move-exception
            goto L_0x00b2
        L_0x002d:
            r2 = 0
            goto L_0x0037
        L_0x002f:
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r2 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch:{ all -> 0x002a }
            r3 = r11
            android.text.Spannable r3 = (android.text.Spannable) r3     // Catch:{ all -> 0x002a }
            r2.<init>((android.text.Spannable) r3)     // Catch:{ all -> 0x002a }
        L_0x0037:
            r3 = 0
            if (r2 == 0) goto L_0x0063
            java.lang.Object[] r4 = r2.getSpans(r12, r13, r1)     // Catch:{ all -> 0x002a }
            androidx.emoji2.text.EmojiSpan[] r4 = (androidx.emoji2.text.EmojiSpan[]) r4     // Catch:{ all -> 0x002a }
            if (r4 == 0) goto L_0x0063
            int r5 = r4.length     // Catch:{ all -> 0x002a }
            if (r5 <= 0) goto L_0x0063
            int r5 = r4.length     // Catch:{ all -> 0x002a }
            r6 = 0
        L_0x0047:
            if (r6 >= r5) goto L_0x0063
            r7 = r4[r6]     // Catch:{ all -> 0x002a }
            int r8 = r2.getSpanStart(r7)     // Catch:{ all -> 0x002a }
            int r9 = r2.getSpanEnd(r7)     // Catch:{ all -> 0x002a }
            if (r8 == r13) goto L_0x0058
            r2.removeSpan(r7)     // Catch:{ all -> 0x002a }
        L_0x0058:
            int r12 = java.lang.Math.min(r8, r12)     // Catch:{ all -> 0x002a }
            int r13 = java.lang.Math.max(r9, r13)     // Catch:{ all -> 0x002a }
            int r6 = r6 + 1
            goto L_0x0047
        L_0x0063:
            r4 = r13
            if (r12 == r4) goto L_0x00a9
            int r13 = r11.length()     // Catch:{ all -> 0x002a }
            if (r12 < r13) goto L_0x006d
            goto L_0x00a9
        L_0x006d:
            r13 = 2147483647(0x7fffffff, float:NaN)
            if (r14 == r13) goto L_0x0080
            if (r2 == 0) goto L_0x0080
            int r13 = r2.length()     // Catch:{ all -> 0x002a }
            java.lang.Object[] r13 = r2.getSpans(r3, r13, r1)     // Catch:{ all -> 0x002a }
            androidx.emoji2.text.EmojiSpan[] r13 = (androidx.emoji2.text.EmojiSpan[]) r13     // Catch:{ all -> 0x002a }
            int r13 = r13.length     // Catch:{ all -> 0x002a }
            int r14 = r14 - r13
        L_0x0080:
            r5 = r14
            androidx.emoji2.text.EmojiProcessor$EmojiProcessAddSpanCallback r7 = new androidx.emoji2.text.EmojiProcessor$EmojiProcessAddSpanCallback     // Catch:{ all -> 0x002a }
            androidx.emoji2.text.EmojiCompat$SpanFactory r13 = r10.f7615a     // Catch:{ all -> 0x002a }
            r7.<init>(r2, r13)     // Catch:{ all -> 0x002a }
            r1 = r10
            r2 = r11
            r3 = r12
            r6 = r15
            java.lang.Object r12 = r1.m(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x002a }
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r12 = (androidx.emoji2.text.UnprecomputeTextOnModificationSpannable) r12     // Catch:{ all -> 0x002a }
            if (r12 == 0) goto L_0x00a0
            android.text.Spannable r12 = r12.b()     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x009f
            androidx.emoji2.text.SpannableBuilder r11 = (androidx.emoji2.text.SpannableBuilder) r11
            r11.d()
        L_0x009f:
            return r12
        L_0x00a0:
            if (r0 == 0) goto L_0x00a8
            r12 = r11
            androidx.emoji2.text.SpannableBuilder r12 = (androidx.emoji2.text.SpannableBuilder) r12
            r12.d()
        L_0x00a8:
            return r11
        L_0x00a9:
            if (r0 == 0) goto L_0x00b1
            r12 = r11
            androidx.emoji2.text.SpannableBuilder r12 = (androidx.emoji2.text.SpannableBuilder) r12
            r12.d()
        L_0x00b1:
            return r11
        L_0x00b2:
            if (r0 == 0) goto L_0x00b9
            androidx.emoji2.text.SpannableBuilder r11 = (androidx.emoji2.text.SpannableBuilder) r11
            r11.d()
        L_0x00b9:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.EmojiProcessor.l(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }
}
