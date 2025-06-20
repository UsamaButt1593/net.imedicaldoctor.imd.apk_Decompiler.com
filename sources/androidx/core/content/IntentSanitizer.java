package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import com.itextpdf.tool.xml.html.HTML;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class IntentSanitizer {
    private static final String p = "IntentSanitizer";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f5646a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Predicate<String> f5647b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Predicate<Uri> f5648c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Predicate<String> f5649d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Predicate<String> f5650e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Predicate<String> f5651f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Predicate<ComponentName> f5652g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f5653h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Map<String, Predicate<Object>> f5654i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f5655j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Predicate<Uri> f5656k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public Predicate<ClipData> f5657l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f5658m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f5659n;
    /* access modifiers changed from: private */
    public boolean o;

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static String a(Intent intent) {
            return intent.getIdentifier();
        }

        @DoNotInline
        static Intent b(Intent intent, String str) {
            return intent.setIdentifier(str);
        }
    }

    @RequiresApi(31)
    private static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static void a(int i2, ClipData.Item item, Consumer<String> consumer) {
            if (item.getHtmlText() != null || item.getIntent() != null || item.getTextLinks() != null) {
                consumer.accept("ClipData item at position " + i2 + " contains htmlText, textLinks or intent: " + item);
            }
        }
    }

    public static final class Builder {
        private static final int q = 2112614400;
        private static final int r = 2015363072;

        /* renamed from: a  reason: collision with root package name */
        private int f5660a;

        /* renamed from: b  reason: collision with root package name */
        private Predicate<String> f5661b = new n();

        /* renamed from: c  reason: collision with root package name */
        private Predicate<Uri> f5662c = new o();

        /* renamed from: d  reason: collision with root package name */
        private Predicate<String> f5663d = new p();

        /* renamed from: e  reason: collision with root package name */
        private Predicate<String> f5664e = new q();

        /* renamed from: f  reason: collision with root package name */
        private Predicate<String> f5665f = new r();

        /* renamed from: g  reason: collision with root package name */
        private Predicate<ComponentName> f5666g = new s();

        /* renamed from: h  reason: collision with root package name */
        private boolean f5667h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f5668i;

        /* renamed from: j  reason: collision with root package name */
        private Map<String, Predicate<Object>> f5669j = new HashMap();

        /* renamed from: k  reason: collision with root package name */
        private boolean f5670k = false;

        /* renamed from: l  reason: collision with root package name */
        private Predicate<Uri> f5671l = new t();

        /* renamed from: m  reason: collision with root package name */
        private Predicate<ClipData> f5672m = new u();

        /* renamed from: n  reason: collision with root package name */
        private boolean f5673n;
        private boolean o;
        private boolean p;

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean X(ComponentName componentName) {
            return true;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean b0(Object obj) {
            return true;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean c0(Class cls, Predicate predicate, Object obj) {
            return cls.isInstance(obj) && predicate.test(cls.cast(obj));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean d0(Object obj) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean g0(String str) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean h0(Uri uri) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean i0(String str) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean j0(String str) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean k0(String str) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean l0(ComponentName componentName) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean m0(Uri uri) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean n0(ClipData clipData) {
            return false;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder A(@NonNull ComponentName componentName) {
            Preconditions.l(componentName);
            Objects.requireNonNull(componentName);
            return B(new i(componentName));
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder B(@NonNull Predicate<ComponentName> predicate) {
            Preconditions.l(predicate);
            this.f5668i = true;
            this.f5666g = this.f5666g.b(predicate);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder C(@NonNull String str) {
            Preconditions.l(str);
            return B(new f(str));
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder D(@NonNull Predicate<Uri> predicate) {
            Preconditions.l(predicate);
            this.f5662c = this.f5662c.b(predicate);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder E(@NonNull String str) {
            Preconditions.l(str);
            D(new g(str));
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder F(@NonNull String str, @NonNull Predicate<Object> predicate) {
            Preconditions.l(str);
            Preconditions.l(predicate);
            Predicate predicate2 = this.f5669j.get(str);
            if (predicate2 == null) {
                new l
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r0v5 ? I:androidx.core.content.l) =  call: androidx.core.content.l.<init>():void type: CONSTRUCTOR in method: androidx.core.content.IntentSanitizer.Builder.F(java.lang.String, androidx.core.util.Predicate):androidx.core.content.IntentSanitizer$Builder, dex: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v5 ?
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	... 49 more
                    */
                /*
                    this = this;
                    androidx.core.util.Preconditions.l(r2)
                    androidx.core.util.Preconditions.l(r3)
                    java.util.Map<java.lang.String, androidx.core.util.Predicate<java.lang.Object>> r0 = r1.f5669j
                    java.lang.Object r0 = r0.get(r2)
                    androidx.core.util.Predicate r0 = (androidx.core.util.Predicate) r0
                    if (r0 != 0) goto L_0x0015
                    androidx.core.content.l r0 = new androidx.core.content.l
                    r0.<init>()
                L_0x0015:
                    androidx.core.util.Predicate r3 = r0.b(r3)
                    java.util.Map<java.lang.String, androidx.core.util.Predicate<java.lang.Object>> r0 = r1.f5669j
                    r0.put(r2, r3)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.IntentSanitizer.Builder.F(java.lang.String, androidx.core.util.Predicate):androidx.core.content.IntentSanitizer$Builder");
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder G(@NonNull String str, @NonNull Class<?> cls) {
                return H(str, cls, new v());
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public <T> Builder H(@NonNull String str, @NonNull Class<T> cls, @NonNull Predicate<T> predicate) {
                Preconditions.l(str);
                Preconditions.l(cls);
                Preconditions.l(predicate);
                return F(str, new h(cls, predicate));
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder I(@NonNull Predicate<Uri> predicate) {
                H(HTML.Tag.U, Uri.class, predicate);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder J(@NonNull String str) {
                H(HTML.Tag.U, Uri.class, new d(str));
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder K(@NonNull Predicate<Uri> predicate) {
                H("android.intent.extra.STREAM", Uri.class, predicate);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder L(@NonNull String str) {
                Preconditions.l(str);
                H("android.intent.extra.STREAM", Uri.class, new m(str));
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder M(int i2) {
                this.f5660a = i2 | this.f5660a;
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder N() {
                this.f5660a |= q;
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder O() {
                this.f5673n = true;
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder P(@NonNull Predicate<String> predicate) {
                Preconditions.l(predicate);
                this.f5665f = this.f5665f.b(predicate);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder Q(@NonNull String str) {
                Preconditions.l(str);
                Objects.requireNonNull(str);
                return P(new e(str));
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder R() {
                this.f5660a |= r;
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder S() {
                this.o = true;
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder T() {
                this.p = true;
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder U(@NonNull Predicate<String> predicate) {
                Preconditions.l(predicate);
                this.f5663d = this.f5663d.b(predicate);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder V(@NonNull String str) {
                Preconditions.l(str);
                Objects.requireNonNull(str);
                return U(new e(str));
            }

            @NonNull
            public IntentSanitizer W() {
                boolean z = this.f5667h;
                if ((!z || !this.f5668i) && (z || this.f5668i)) {
                    IntentSanitizer intentSanitizer = new IntentSanitizer();
                    int unused = intentSanitizer.f5646a = this.f5660a;
                    Predicate unused2 = intentSanitizer.f5647b = this.f5661b;
                    Predicate unused3 = intentSanitizer.f5648c = this.f5662c;
                    Predicate unused4 = intentSanitizer.f5649d = this.f5663d;
                    Predicate unused5 = intentSanitizer.f5650e = this.f5664e;
                    Predicate unused6 = intentSanitizer.f5651f = this.f5665f;
                    boolean unused7 = intentSanitizer.f5653h = this.f5667h;
                    Predicate unused8 = intentSanitizer.f5652g = this.f5666g;
                    Map unused9 = intentSanitizer.f5654i = this.f5669j;
                    boolean unused10 = intentSanitizer.f5655j = this.f5670k;
                    Predicate unused11 = intentSanitizer.f5656k = this.f5671l;
                    Predicate unused12 = intentSanitizer.f5657l = this.f5672m;
                    boolean unused13 = intentSanitizer.f5658m = this.f5673n;
                    boolean unused14 = intentSanitizer.f5659n = this.o;
                    boolean unused15 = intentSanitizer.o = this.p;
                    return intentSanitizer;
                }
                throw new SecurityException("You must call either allowAnyComponent or one or more of the allowComponent methods; but not both.");
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder r(@NonNull Predicate<String> predicate) {
                Preconditions.l(predicate);
                this.f5661b = this.f5661b.b(predicate);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder s(@NonNull String str) {
                Preconditions.l(str);
                Objects.requireNonNull(str);
                r(new e(str));
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder t() {
                this.f5667h = true;
                this.f5666g = new j();
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder u(@NonNull Predicate<String> predicate) {
                Preconditions.l(predicate);
                this.f5664e = this.f5664e.b(predicate);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder v(@NonNull String str) {
                Preconditions.l(str);
                Objects.requireNonNull(str);
                return u(new e(str));
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder w(@NonNull Predicate<ClipData> predicate) {
                Preconditions.l(predicate);
                this.f5672m = this.f5672m.b(predicate);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder x() {
                this.f5670k = true;
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder y(@NonNull Predicate<Uri> predicate) {
                Preconditions.l(predicate);
                this.f5671l = this.f5671l.b(predicate);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            @NonNull
            public Builder z(@NonNull String str) {
                Preconditions.l(str);
                return y(new k(str));
            }
        }

        private IntentSanitizer() {
        }

        private static void r(int i2, ClipData.Item item, Consumer<String> consumer) {
            if (item.getHtmlText() != null || item.getIntent() != null) {
                consumer.accept("ClipData item at position " + i2 + " contains htmlText, textLinks or intent: " + item);
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void s(String str) {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void t(String str) {
            throw new SecurityException(str);
        }

        private void u(Intent intent, String str, Object obj) {
            if (obj == null) {
                intent.getExtras().putString(str, (String) null);
            } else if (obj instanceof Parcelable) {
                intent.putExtra(str, (Parcelable) obj);
            } else if (obj instanceof Parcelable[]) {
                intent.putExtra(str, (Parcelable[]) obj);
            } else if (obj instanceof Serializable) {
                intent.putExtra(str, (Serializable) obj);
            } else {
                throw new IllegalArgumentException("Unsupported type " + obj.getClass());
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x009c A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00a0  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00af  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static void y(@androidx.annotation.NonNull android.content.Intent r7, android.content.Intent r8, androidx.core.util.Predicate<android.content.ClipData> r9, boolean r10, androidx.core.util.Predicate<android.net.Uri> r11, androidx.core.util.Consumer<java.lang.String> r12) {
            /*
                android.content.ClipData r7 = r7.getClipData()
                if (r7 != 0) goto L_0x0007
                return
            L_0x0007:
                if (r9 == 0) goto L_0x0014
                boolean r9 = r9.test(r7)
                if (r9 == 0) goto L_0x0014
                r8.setClipData(r7)
                goto L_0x00c0
            L_0x0014:
                r9 = 0
                r0 = 0
                r1 = r9
            L_0x0017:
                int r2 = r7.getItemCount()
                if (r0 >= r2) goto L_0x00bb
                android.content.ClipData$Item r2 = r7.getItemAt(r0)
                int r3 = android.os.Build.VERSION.SDK_INT
                r4 = 31
                if (r3 < r4) goto L_0x002b
                androidx.core.content.IntentSanitizer.Api31Impl.a(r0, r2, r12)
                goto L_0x002e
            L_0x002b:
                r(r0, r2, r12)
            L_0x002e:
                java.lang.CharSequence r3 = r2.getText()
                if (r10 == 0) goto L_0x0035
                goto L_0x0058
            L_0x0035:
                if (r3 == 0) goto L_0x0057
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Item text cannot contain value. Item position: "
                r3.append(r4)
                r3.append(r0)
                java.lang.String r4 = ". Text: "
                r3.append(r4)
                java.lang.CharSequence r4 = r2.getText()
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                r12.accept(r3)
            L_0x0057:
                r3 = r9
            L_0x0058:
                java.lang.String r4 = ". URI: "
                java.lang.String r5 = "Item URI is not allowed. Item position: "
                android.net.Uri r6 = r2.getUri()
                if (r11 != 0) goto L_0x0081
                if (r6 == 0) goto L_0x0094
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
            L_0x0069:
                r6.append(r5)
                r6.append(r0)
                r6.append(r4)
                android.net.Uri r2 = r2.getUri()
                r6.append(r2)
                java.lang.String r2 = r6.toString()
                r12.accept(r2)
                goto L_0x0094
            L_0x0081:
                if (r6 == 0) goto L_0x0096
                android.net.Uri r6 = r2.getUri()
                boolean r6 = r11.test(r6)
                if (r6 == 0) goto L_0x008e
                goto L_0x0096
            L_0x008e:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                goto L_0x0069
            L_0x0094:
                r2 = r9
                goto L_0x009a
            L_0x0096:
                android.net.Uri r2 = r2.getUri()
            L_0x009a:
                if (r3 != 0) goto L_0x009e
                if (r2 == 0) goto L_0x00b7
            L_0x009e:
                if (r1 != 0) goto L_0x00af
                android.content.ClipData r1 = new android.content.ClipData
                android.content.ClipDescription r4 = r7.getDescription()
                android.content.ClipData$Item r5 = new android.content.ClipData$Item
                r5.<init>(r3, r9, r2)
                r1.<init>(r4, r5)
                goto L_0x00b7
            L_0x00af:
                android.content.ClipData$Item r4 = new android.content.ClipData$Item
                r4.<init>(r3, r9, r2)
                r1.addItem(r4)
            L_0x00b7:
                int r0 = r0 + 1
                goto L_0x0017
            L_0x00bb:
                if (r1 == 0) goto L_0x00c0
                r8.setClipData(r1)
            L_0x00c0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.IntentSanitizer.y(android.content.Intent, android.content.Intent, androidx.core.util.Predicate, boolean, androidx.core.util.Predicate, androidx.core.util.Consumer):void");
        }

        @NonNull
        public Intent v(@NonNull Intent intent, @NonNull Consumer<String> consumer) {
            String str;
            Intent intent2 = new Intent();
            ComponentName component = intent.getComponent();
            if ((!this.f5653h || component != null) && !this.f5652g.test(component)) {
                consumer.accept("Component is not allowed: " + component);
                component = new ComponentName("android", "java.lang.Void");
            }
            intent2.setComponent(component);
            String str2 = intent.getPackage();
            if (str2 == null || this.f5651f.test(str2)) {
                intent2.setPackage(str2);
            } else {
                consumer.accept("Package is not allowed: " + str2);
            }
            int flags = this.f5646a | intent.getFlags();
            int i2 = this.f5646a;
            if (flags == i2) {
                intent2.setFlags(intent.getFlags());
            } else {
                intent2.setFlags(intent.getFlags() & i2);
                consumer.accept("The intent contains flags that are not allowed: 0x" + Integer.toHexString(intent.getFlags() & (~this.f5646a)));
            }
            String action = intent.getAction();
            if (action == null || this.f5647b.test(action)) {
                intent2.setAction(action);
            } else {
                consumer.accept("Action is not allowed: " + action);
            }
            Uri data = intent.getData();
            if (data == null || this.f5648c.test(data)) {
                intent2.setData(data);
            } else {
                consumer.accept("Data is not allowed: " + data);
            }
            String type = intent.getType();
            if (type == null || this.f5649d.test(type)) {
                intent2.setDataAndType(intent2.getData(), type);
            } else {
                consumer.accept("Type is not allowed: " + type);
            }
            Set<String> categories = intent.getCategories();
            if (categories != null) {
                for (String next : categories) {
                    if (this.f5650e.test(next)) {
                        intent2.addCategory(next);
                    } else {
                        consumer.accept("Category is not allowed: " + next);
                    }
                }
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                for (String next2 : extras.keySet()) {
                    if (next2.equals("android.intent.extra.STREAM") && (this.f5646a & 1) == 0) {
                        str = "Allowing Extra Stream requires also allowing at least  FLAG_GRANT_READ_URI_PERMISSION Flag.";
                    } else if (!next2.equals(HTML.Tag.U) || ((~this.f5646a) & 3) == 0) {
                        Object obj = extras.get(next2);
                        Predicate predicate = this.f5654i.get(next2);
                        if (predicate == null || !predicate.test(obj)) {
                            str = "Extra is not allowed. Key: " + next2 + ". Value: " + obj;
                        } else {
                            u(intent2, next2, obj);
                        }
                    } else {
                        str = "Allowing Extra Output requires also allowing FLAG_GRANT_READ_URI_PERMISSION and FLAG_GRANT_WRITE_URI_PERMISSION Flags.";
                    }
                    consumer.accept(str);
                }
            }
            y(intent, intent2, this.f5657l, this.f5655j, this.f5656k, consumer);
            if (Build.VERSION.SDK_INT >= 29) {
                if (this.f5658m) {
                    Api29Impl.b(intent2, Api29Impl.a(intent));
                } else if (Api29Impl.a(intent) != null) {
                    consumer.accept("Identifier is not allowed: " + Api29Impl.a(intent));
                }
            }
            if (this.f5659n) {
                intent2.setSelector(intent.getSelector());
            } else if (intent.getSelector() != null) {
                consumer.accept("Selector is not allowed: " + intent.getSelector());
            }
            if (this.o) {
                intent2.setSourceBounds(intent.getSourceBounds());
            } else if (intent.getSourceBounds() != null) {
                consumer.accept("SourceBounds is not allowed: " + intent.getSourceBounds());
            }
            return intent2;
        }

        @NonNull
        public Intent w(@NonNull Intent intent) {
            return v(intent, new c());
        }

        @NonNull
        public Intent x(@NonNull Intent intent) {
            return v(intent, new b());
        }
    }
