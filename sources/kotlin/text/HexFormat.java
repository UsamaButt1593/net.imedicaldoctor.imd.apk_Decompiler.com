package kotlin.text;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.9")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lkotlin/text/HexFormat;", "", "", "upperCase", "Lkotlin/text/HexFormat$BytesHexFormat;", "bytes", "Lkotlin/text/HexFormat$NumberHexFormat;", "number", "<init>", "(ZLkotlin/text/HexFormat$BytesHexFormat;Lkotlin/text/HexFormat$NumberHexFormat;)V", "", "toString", "()Ljava/lang/String;", "a", "Z", "e", "()Z", "b", "Lkotlin/text/HexFormat$BytesHexFormat;", "c", "()Lkotlin/text/HexFormat$BytesHexFormat;", "Lkotlin/text/HexFormat$NumberHexFormat;", "d", "()Lkotlin/text/HexFormat$NumberHexFormat;", "Builder", "BytesHexFormat", "Companion", "NumberHexFormat", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@ExperimentalStdlibApi
public final class HexFormat {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f29069d = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final HexFormat f29070e;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final HexFormat f29071f;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f29072a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final BytesHexFormat f29073b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final NumberHexFormat f29074c;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\t\b\u0001¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\t\u001a\u00020\u00062\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ,\u0010\f\u001a\u00020\u00062\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001cR\u0011\u0010 \u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u0002\u0007\n\u0005\b20\u0001¨\u0006!"}, d2 = {"Lkotlin/text/HexFormat$Builder;", "", "<init>", "()V", "Lkotlin/Function1;", "Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "b", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "f", "Lkotlin/text/HexFormat;", "a", "()Lkotlin/text/HexFormat;", "", "Z", "e", "()Z", "g", "(Z)V", "upperCase", "Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "_bytes", "c", "Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "_number", "()Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "bytes", "d", "()Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "number", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f29075a = HexFormat.f29069d.a().e();
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private BytesHexFormat.Builder f29076b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private NumberHexFormat.Builder f29077c;

        @InlineOnly
        private final void b(Function1<? super BytesHexFormat.Builder, Unit> function1) {
            Intrinsics.p(function1, "builderAction");
            function1.f(c());
        }

        @InlineOnly
        private final void f(Function1<? super NumberHexFormat.Builder, Unit> function1) {
            Intrinsics.p(function1, "builderAction");
            function1.f(d());
        }

        @NotNull
        @PublishedApi
        public final HexFormat a() {
            BytesHexFormat bytesHexFormat;
            NumberHexFormat numberHexFormat;
            boolean z = this.f29075a;
            BytesHexFormat.Builder builder = this.f29076b;
            if (builder == null || (bytesHexFormat = builder.a()) == null) {
                bytesHexFormat = BytesHexFormat.f29078g.a();
            }
            NumberHexFormat.Builder builder2 = this.f29077c;
            if (builder2 == null || (numberHexFormat = builder2.a()) == null) {
                numberHexFormat = NumberHexFormat.f29092d.a();
            }
            return new HexFormat(z, bytesHexFormat, numberHexFormat);
        }

        @NotNull
        public final BytesHexFormat.Builder c() {
            if (this.f29076b == null) {
                this.f29076b = new BytesHexFormat.Builder();
            }
            BytesHexFormat.Builder builder = this.f29076b;
            Intrinsics.m(builder);
            return builder;
        }

        @NotNull
        public final NumberHexFormat.Builder d() {
            if (this.f29077c == null) {
                this.f29077c = new NumberHexFormat.Builder();
            }
            NumberHexFormat.Builder builder = this.f29077c;
            Intrinsics.m(builder);
            return builder;
        }

        public final boolean e() {
            return this.f29075a;
        }

        public final void g(boolean z) {
            this.f29075a = z;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u00162\u00020\u0001:\u0002\u001e\u001fB9\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0012\u001a\u00060\u000ej\u0002`\u000f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001c\u0010\rR\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u0019\u0010\rR\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u001a\u001a\u0004\b\u001d\u0010\r¨\u0006 "}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat;", "", "", "bytesPerLine", "bytesPerGroup", "", "groupSeparator", "byteSeparator", "bytePrefix", "byteSuffix", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "indent", "b", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "a", "I", "g", "()I", "f", "c", "Ljava/lang/String;", "h", "d", "e", "Builder", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class BytesHexFormat {
        @NotNull

        /* renamed from: g  reason: collision with root package name */
        public static final Companion f29078g = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        @NotNull

        /* renamed from: h  reason: collision with root package name */
        public static final BytesHexFormat f29079h = new BytesHexFormat(Integer.MAX_VALUE, Integer.MAX_VALUE, "  ", "", "", "");

        /* renamed from: a  reason: collision with root package name */
        private final int f29080a;

        /* renamed from: b  reason: collision with root package name */
        private final int f29081b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final String f29082c;
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        private final String f29083d;
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        private final String f29084e;
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        private final String f29085f;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R*\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001d\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017\"\u0004\b\u001c\u0010\u0019R*\u0010\u001f\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u000f\u0010\u0017\"\u0004\b\u001e\u0010\u0019R*\u0010!\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b \u0010\u0019¨\u0006\""}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "", "<init>", "()V", "Lkotlin/text/HexFormat$BytesHexFormat;", "a", "()Lkotlin/text/HexFormat$BytesHexFormat;", "", "value", "I", "f", "()I", "l", "(I)V", "bytesPerLine", "b", "e", "k", "bytesPerGroup", "", "c", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "m", "(Ljava/lang/String;)V", "groupSeparator", "d", "i", "byteSeparator", "h", "bytePrefix", "j", "byteSuffix", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            private int f29086a;

            /* renamed from: b  reason: collision with root package name */
            private int f29087b;
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            private String f29088c;
            @NotNull

            /* renamed from: d  reason: collision with root package name */
            private String f29089d;
            @NotNull

            /* renamed from: e  reason: collision with root package name */
            private String f29090e;
            @NotNull

            /* renamed from: f  reason: collision with root package name */
            private String f29091f;

            public Builder() {
                Companion companion = BytesHexFormat.f29078g;
                this.f29086a = companion.a().g();
                this.f29087b = companion.a().f();
                this.f29088c = companion.a().h();
                this.f29089d = companion.a().d();
                this.f29090e = companion.a().c();
                this.f29091f = companion.a().e();
            }

            @NotNull
            public final BytesHexFormat a() {
                return new BytesHexFormat(this.f29086a, this.f29087b, this.f29088c, this.f29089d, this.f29090e, this.f29091f);
            }

            @NotNull
            public final String b() {
                return this.f29090e;
            }

            @NotNull
            public final String c() {
                return this.f29089d;
            }

            @NotNull
            public final String d() {
                return this.f29091f;
            }

            public final int e() {
                return this.f29087b;
            }

            public final int f() {
                return this.f29086a;
            }

            @NotNull
            public final String g() {
                return this.f29088c;
            }

            public final void h(@NotNull String str) {
                Intrinsics.p(str, "value");
                if (StringsKt.S2(str, 10, false, 2, (Object) null) || StringsKt.S2(str, 13, false, 2, (Object) null)) {
                    throw new IllegalArgumentException("LF and CR characters are prohibited in bytePrefix, but was " + str);
                }
                this.f29090e = str;
            }

            public final void i(@NotNull String str) {
                Intrinsics.p(str, "value");
                if (StringsKt.S2(str, 10, false, 2, (Object) null) || StringsKt.S2(str, 13, false, 2, (Object) null)) {
                    throw new IllegalArgumentException("LF and CR characters are prohibited in byteSeparator, but was " + str);
                }
                this.f29089d = str;
            }

            public final void j(@NotNull String str) {
                Intrinsics.p(str, "value");
                if (StringsKt.S2(str, 10, false, 2, (Object) null) || StringsKt.S2(str, 13, false, 2, (Object) null)) {
                    throw new IllegalArgumentException("LF and CR characters are prohibited in byteSuffix, but was " + str);
                }
                this.f29091f = str;
            }

            public final void k(int i2) {
                if (i2 > 0) {
                    this.f29087b = i2;
                    return;
                }
                throw new IllegalArgumentException("Non-positive values are prohibited for bytesPerGroup, but was " + i2);
            }

            public final void l(int i2) {
                if (i2 > 0) {
                    this.f29086a = i2;
                    return;
                }
                throw new IllegalArgumentException("Non-positive values are prohibited for bytesPerLine, but was " + i2);
            }

            public final void m(@NotNull String str) {
                Intrinsics.p(str, "<set-?>");
                this.f29088c = str;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat$Companion;", "", "<init>", "()V", "Lkotlin/text/HexFormat$BytesHexFormat;", "Default", "Lkotlin/text/HexFormat$BytesHexFormat;", "a", "()Lkotlin/text/HexFormat$BytesHexFormat;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final BytesHexFormat a() {
                return BytesHexFormat.f29079h;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public BytesHexFormat(int i2, int i3, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.p(str, "groupSeparator");
            Intrinsics.p(str2, "byteSeparator");
            Intrinsics.p(str3, "bytePrefix");
            Intrinsics.p(str4, "byteSuffix");
            this.f29080a = i2;
            this.f29081b = i3;
            this.f29082c = str;
            this.f29083d = str2;
            this.f29084e = str3;
            this.f29085f = str4;
        }

        @NotNull
        public final StringBuilder b(@NotNull StringBuilder sb, @NotNull String str) {
            Intrinsics.p(sb, "sb");
            Intrinsics.p(str, "indent");
            sb.append(str);
            sb.append("bytesPerLine = ");
            sb.append(this.f29080a);
            Intrinsics.o(sb, "sb.append(indent).append…= \").append(bytesPerLine)");
            sb.append(",");
            Intrinsics.o(sb, "append(value)");
            sb.append(10);
            Intrinsics.o(sb, "append('\\n')");
            sb.append(str);
            sb.append("bytesPerGroup = ");
            sb.append(this.f29081b);
            Intrinsics.o(sb, "sb.append(indent).append… \").append(bytesPerGroup)");
            sb.append(",");
            Intrinsics.o(sb, "append(value)");
            sb.append(10);
            Intrinsics.o(sb, "append('\\n')");
            sb.append(str);
            sb.append("groupSeparator = \"");
            sb.append(this.f29082c);
            Intrinsics.o(sb, "sb.append(indent).append…\").append(groupSeparator)");
            sb.append("\",");
            Intrinsics.o(sb, "append(value)");
            sb.append(10);
            Intrinsics.o(sb, "append('\\n')");
            sb.append(str);
            sb.append("byteSeparator = \"");
            sb.append(this.f29083d);
            Intrinsics.o(sb, "sb.append(indent).append…\"\").append(byteSeparator)");
            sb.append("\",");
            Intrinsics.o(sb, "append(value)");
            sb.append(10);
            Intrinsics.o(sb, "append('\\n')");
            sb.append(str);
            sb.append("bytePrefix = \"");
            sb.append(this.f29084e);
            Intrinsics.o(sb, "sb.append(indent).append…= \\\"\").append(bytePrefix)");
            sb.append("\",");
            Intrinsics.o(sb, "append(value)");
            sb.append(10);
            Intrinsics.o(sb, "append('\\n')");
            sb.append(str);
            sb.append("byteSuffix = \"");
            sb.append(this.f29085f);
            sb.append("\"");
            return sb;
        }

        @NotNull
        public final String c() {
            return this.f29084e;
        }

        @NotNull
        public final String d() {
            return this.f29083d;
        }

        @NotNull
        public final String e() {
            return this.f29085f;
        }

        public final int f() {
            return this.f29081b;
        }

        public final int g() {
            return this.f29080a;
        }

        @NotNull
        public final String h() {
            return this.f29082c;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BytesHexFormat(");
            Intrinsics.o(sb, "append(\"BytesHexFormat(\")");
            sb.append(10);
            Intrinsics.o(sb, "append('\\n')");
            StringBuilder b2 = b(sb, "    ");
            b2.append(10);
            Intrinsics.o(b2, "append('\\n')");
            sb.append(")");
            String sb2 = sb.toString();
            Intrinsics.o(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lkotlin/text/HexFormat$Companion;", "", "<init>", "()V", "Lkotlin/text/HexFormat;", "Default", "Lkotlin/text/HexFormat;", "a", "()Lkotlin/text/HexFormat;", "UpperCase", "b", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final HexFormat a() {
            return HexFormat.f29070e;
        }

        @NotNull
        public final HexFormat b() {
            return HexFormat.f29071f;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u00162\u00020\u0001:\u0002\u0018\u0019B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\u00060\u000bj\u0002`\f2\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat;", "", "", "prefix", "suffix", "", "removeLeadingZeros", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "indent", "b", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "a", "Ljava/lang/String;", "c", "e", "Z", "d", "()Z", "Builder", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class NumberHexFormat {
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        public static final Companion f29092d = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        public static final NumberHexFormat f29093e = new NumberHexFormat("", "", false);
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final String f29094a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final String f29095b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f29096c;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R*\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\n\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "", "<init>", "()V", "Lkotlin/text/HexFormat$NumberHexFormat;", "a", "()Lkotlin/text/HexFormat$NumberHexFormat;", "", "value", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "prefix", "d", "g", "suffix", "", "c", "Z", "()Z", "f", "(Z)V", "removeLeadingZeros", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
        public static final class Builder {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private String f29097a;
            @NotNull

            /* renamed from: b  reason: collision with root package name */
            private String f29098b;

            /* renamed from: c  reason: collision with root package name */
            private boolean f29099c;

            public Builder() {
                Companion companion = NumberHexFormat.f29092d;
                this.f29097a = companion.a().c();
                this.f29098b = companion.a().e();
                this.f29099c = companion.a().d();
            }

            @NotNull
            public final NumberHexFormat a() {
                return new NumberHexFormat(this.f29097a, this.f29098b, this.f29099c);
            }

            @NotNull
            public final String b() {
                return this.f29097a;
            }

            public final boolean c() {
                return this.f29099c;
            }

            @NotNull
            public final String d() {
                return this.f29098b;
            }

            public final void e(@NotNull String str) {
                Intrinsics.p(str, "value");
                if (StringsKt.S2(str, 10, false, 2, (Object) null) || StringsKt.S2(str, 13, false, 2, (Object) null)) {
                    throw new IllegalArgumentException("LF and CR characters are prohibited in prefix, but was " + str);
                }
                this.f29097a = str;
            }

            public final void f(boolean z) {
                this.f29099c = z;
            }

            public final void g(@NotNull String str) {
                Intrinsics.p(str, "value");
                if (StringsKt.S2(str, 10, false, 2, (Object) null) || StringsKt.S2(str, 13, false, 2, (Object) null)) {
                    throw new IllegalArgumentException("LF and CR characters are prohibited in suffix, but was " + str);
                }
                this.f29098b = str;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat$Companion;", "", "<init>", "()V", "Lkotlin/text/HexFormat$NumberHexFormat;", "Default", "Lkotlin/text/HexFormat$NumberHexFormat;", "a", "()Lkotlin/text/HexFormat$NumberHexFormat;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final NumberHexFormat a() {
                return NumberHexFormat.f29093e;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public NumberHexFormat(@NotNull String str, @NotNull String str2, boolean z) {
            Intrinsics.p(str, "prefix");
            Intrinsics.p(str2, "suffix");
            this.f29094a = str;
            this.f29095b = str2;
            this.f29096c = z;
        }

        @NotNull
        public final StringBuilder b(@NotNull StringBuilder sb, @NotNull String str) {
            Intrinsics.p(sb, "sb");
            Intrinsics.p(str, "indent");
            sb.append(str);
            sb.append("prefix = \"");
            sb.append(this.f29094a);
            Intrinsics.o(sb, "sb.append(indent).append…fix = \\\"\").append(prefix)");
            sb.append("\",");
            Intrinsics.o(sb, "append(value)");
            sb.append(10);
            Intrinsics.o(sb, "append('\\n')");
            sb.append(str);
            sb.append("suffix = \"");
            sb.append(this.f29095b);
            Intrinsics.o(sb, "sb.append(indent).append…fix = \\\"\").append(suffix)");
            sb.append("\",");
            Intrinsics.o(sb, "append(value)");
            sb.append(10);
            Intrinsics.o(sb, "append('\\n')");
            sb.append(str);
            sb.append("removeLeadingZeros = ");
            sb.append(this.f29096c);
            return sb;
        }

        @NotNull
        public final String c() {
            return this.f29094a;
        }

        public final boolean d() {
            return this.f29096c;
        }

        @NotNull
        public final String e() {
            return this.f29095b;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NumberHexFormat(");
            Intrinsics.o(sb, "append(\"NumberHexFormat(\")");
            sb.append(10);
            Intrinsics.o(sb, "append('\\n')");
            StringBuilder b2 = b(sb, "    ");
            b2.append(10);
            Intrinsics.o(b2, "append('\\n')");
            sb.append(")");
            String sb2 = sb.toString();
            Intrinsics.o(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
    }

    static {
        BytesHexFormat.Companion companion = BytesHexFormat.f29078g;
        BytesHexFormat a2 = companion.a();
        NumberHexFormat.Companion companion2 = NumberHexFormat.f29092d;
        f29070e = new HexFormat(false, a2, companion2.a());
        f29071f = new HexFormat(true, companion.a(), companion2.a());
    }

    public HexFormat(boolean z, @NotNull BytesHexFormat bytesHexFormat, @NotNull NumberHexFormat numberHexFormat) {
        Intrinsics.p(bytesHexFormat, "bytes");
        Intrinsics.p(numberHexFormat, "number");
        this.f29072a = z;
        this.f29073b = bytesHexFormat;
        this.f29074c = numberHexFormat;
    }

    @NotNull
    public final BytesHexFormat c() {
        return this.f29073b;
    }

    @NotNull
    public final NumberHexFormat d() {
        return this.f29074c;
    }

    public final boolean e() {
        return this.f29072a;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HexFormat(");
        Intrinsics.o(sb, "append(\"HexFormat(\")");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        sb.append("    upperCase = ");
        sb.append(this.f29072a);
        Intrinsics.o(sb, "append(\"    upperCase = \").append(upperCase)");
        sb.append(",");
        Intrinsics.o(sb, "append(value)");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        sb.append("    bytes = BytesHexFormat(");
        Intrinsics.o(sb, "append(\"    bytes = BytesHexFormat(\")");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        StringBuilder b2 = this.f29073b.b(sb, "        ");
        b2.append(10);
        Intrinsics.o(b2, "append('\\n')");
        sb.append("    ),");
        Intrinsics.o(sb, "append(\"    ),\")");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        sb.append("    number = NumberHexFormat(");
        Intrinsics.o(sb, "append(\"    number = NumberHexFormat(\")");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        StringBuilder b3 = this.f29074c.b(sb, "        ");
        b3.append(10);
        Intrinsics.o(b3, "append('\\n')");
        sb.append("    )");
        Intrinsics.o(sb, "append(\"    )\")");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
