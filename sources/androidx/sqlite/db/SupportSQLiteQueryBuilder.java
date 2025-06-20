package androidx.sqlite.db;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nSupportSQLiteQueryBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SupportSQLiteQueryBuilder.kt\nandroidx/sqlite/db/SupportSQLiteQueryBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n1#2:188\n*E\n"})
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001,B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u000b\u001a\u00020\n*\u00060\u0006j\u0002`\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\n*\u00060\u0006j\u0002`\u00072\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00002\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\r¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0017\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0016\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001f\u0010\u001bJ\u0015\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0002¢\u0006\u0004\b!\u0010\u001bJ\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010%R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010'R \u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010%R\"\u0010\u0016\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010+R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010%R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010%R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010%R\u0018\u0010 \u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010%¨\u0006-"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "", "", "table", "<init>", "(Ljava/lang/String;)V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "name", "clause", "", "a", "(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V", "", "columns", "b", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)V", "f", "()Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "d", "([Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "selection", "bindArgs", "k", "(Ljava/lang/String;[Ljava/lang/Object;)Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "groupBy", "g", "(Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "having", "h", "orderBy", "j", "limit", "i", "Landroidx/sqlite/db/SupportSQLiteQuery;", "e", "()Landroidx/sqlite/db/SupportSQLiteQuery;", "Ljava/lang/String;", "", "Z", "distinct", "c", "[Ljava/lang/String;", "[Ljava/lang/Object;", "Companion", "sqlite_release"}, k = 1, mv = {1, 8, 0})
public final class SupportSQLiteQueryBuilder {
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    public static final Companion f15833j = new Companion((DefaultConstructorMarker) null);

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f15834k = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f15835a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f15836b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String[] f15837c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f15838d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Object[] f15839e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private String f15840f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private String f15841g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private String f15842h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private String f15843i;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteQueryBuilder$Companion;", "", "<init>", "()V", "", "tableName", "Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "a", "(Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "limitPattern", "Ljava/util/regex/Pattern;", "sqlite_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final SupportSQLiteQueryBuilder a(@NotNull String str) {
            Intrinsics.p(str, "tableName");
            return new SupportSQLiteQueryBuilder(str, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private SupportSQLiteQueryBuilder(String str) {
        this.f15835a = str;
    }

    private final void a(StringBuilder sb, String str, String str2) {
        if (str2 != null && str2.length() != 0) {
            sb.append(str);
            sb.append(str2);
        }
    }

    private final void b(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(' ');
    }

    @JvmStatic
    @NotNull
    public static final SupportSQLiteQueryBuilder c(@NotNull String str) {
        return f15833j.a(str);
    }

    @NotNull
    public final SupportSQLiteQueryBuilder d(@Nullable String[] strArr) {
        this.f15837c = strArr;
        return this;
    }

    @NotNull
    public final SupportSQLiteQuery e() {
        String str;
        String str2 = this.f15840f;
        if ((str2 != null && str2.length() != 0) || (str = this.f15841g) == null || str.length() == 0) {
            StringBuilder sb = new StringBuilder(120);
            sb.append("SELECT ");
            if (this.f15836b) {
                sb.append("DISTINCT ");
            }
            String[] strArr = this.f15837c;
            if (strArr == null || strArr.length == 0) {
                sb.append("* ");
            } else {
                Intrinsics.m(strArr);
                b(sb, strArr);
            }
            sb.append("FROM ");
            sb.append(this.f15835a);
            a(sb, " WHERE ", this.f15838d);
            a(sb, " GROUP BY ", this.f15840f);
            a(sb, " HAVING ", this.f15841g);
            a(sb, " ORDER BY ", this.f15842h);
            a(sb, " LIMIT ", this.f15843i);
            String sb2 = sb.toString();
            Intrinsics.o(sb2, "StringBuilder(capacity).…builderAction).toString()");
            return new SimpleSQLiteQuery(sb2, this.f15839e);
        }
        throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause".toString());
    }

    @NotNull
    public final SupportSQLiteQueryBuilder f() {
        this.f15836b = true;
        return this;
    }

    @NotNull
    public final SupportSQLiteQueryBuilder g(@Nullable String str) {
        this.f15840f = str;
        return this;
    }

    @NotNull
    public final SupportSQLiteQueryBuilder h(@Nullable String str) {
        this.f15841g = str;
        return this;
    }

    @NotNull
    public final SupportSQLiteQueryBuilder i(@NotNull String str) {
        Intrinsics.p(str, "limit");
        boolean matches = f15834k.matcher(str).matches();
        if (str.length() != 0 && !matches) {
            throw new IllegalArgumentException(("invalid LIMIT clauses:" + str).toString());
        }
        this.f15843i = str;
        return this;
    }

    @NotNull
    public final SupportSQLiteQueryBuilder j(@Nullable String str) {
        this.f15842h = str;
        return this;
    }

    @NotNull
    public final SupportSQLiteQueryBuilder k(@Nullable String str, @Nullable Object[] objArr) {
        this.f15838d = str;
        this.f15839e = objArr;
        return this;
    }

    public /* synthetic */ SupportSQLiteQueryBuilder(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
