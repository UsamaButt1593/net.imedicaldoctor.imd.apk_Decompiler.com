package androidx.sqlite.db;

import com.google.android.gms.actions.SearchIntents;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\u0018B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0016¨\u0006\u0019"}, d2 = {"Landroidx/sqlite/db/SimpleSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "", "query", "", "", "bindArgs", "<init>", "(Ljava/lang/String;[Ljava/lang/Object;)V", "(Ljava/lang/String;)V", "Landroidx/sqlite/db/SupportSQLiteProgram;", "statement", "", "c", "(Landroidx/sqlite/db/SupportSQLiteProgram;)V", "a", "Ljava/lang/String;", "b", "[Ljava/lang/Object;", "()Ljava/lang/String;", "sql", "", "()I", "argCount", "Companion", "sqlite_release"}, k = 1, mv = {1, 8, 0})
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f15811c = new Companion((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f15812a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f15813b;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/sqlite/db/SimpleSQLiteQuery$Companion;", "", "<init>", "()V", "Landroidx/sqlite/db/SupportSQLiteProgram;", "statement", "", "index", "arg", "", "a", "(Landroidx/sqlite/db/SupportSQLiteProgram;ILjava/lang/Object;)V", "", "bindArgs", "b", "(Landroidx/sqlite/db/SupportSQLiteProgram;[Ljava/lang/Object;)V", "sqlite_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        private final void a(SupportSQLiteProgram supportSQLiteProgram, int i2, Object obj) {
            long j2;
            int byteValue;
            double doubleValue;
            if (obj == null) {
                supportSQLiteProgram.bindNull(i2);
            } else if (obj instanceof byte[]) {
                supportSQLiteProgram.bindBlob(i2, (byte[]) obj);
            } else {
                if (obj instanceof Float) {
                    doubleValue = (double) ((Number) obj).floatValue();
                } else if (obj instanceof Double) {
                    doubleValue = ((Number) obj).doubleValue();
                } else {
                    if (obj instanceof Long) {
                        j2 = ((Number) obj).longValue();
                    } else {
                        if (obj instanceof Integer) {
                            byteValue = ((Number) obj).intValue();
                        } else if (obj instanceof Short) {
                            byteValue = ((Number) obj).shortValue();
                        } else if (obj instanceof Byte) {
                            byteValue = ((Number) obj).byteValue();
                        } else if (obj instanceof String) {
                            supportSQLiteProgram.bindString(i2, (String) obj);
                            return;
                        } else if (obj instanceof Boolean) {
                            j2 = ((Boolean) obj).booleanValue() ? 1 : 0;
                        } else {
                            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i2 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
                        }
                        j2 = (long) byteValue;
                    }
                    supportSQLiteProgram.bindLong(i2, j2);
                    return;
                }
                supportSQLiteProgram.bindDouble(i2, doubleValue);
            }
        }

        @JvmStatic
        public final void b(@NotNull SupportSQLiteProgram supportSQLiteProgram, @Nullable Object[] objArr) {
            Intrinsics.p(supportSQLiteProgram, "statement");
            if (objArr != null) {
                int length = objArr.length;
                int i2 = 0;
                while (i2 < length) {
                    Object obj = objArr[i2];
                    i2++;
                    a(supportSQLiteProgram, i2, obj);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleSQLiteQuery(@NotNull String str) {
        this(str, (Object[]) null);
        Intrinsics.p(str, SearchIntents.f19720b);
    }

    @JvmStatic
    public static final void d(@NotNull SupportSQLiteProgram supportSQLiteProgram, @Nullable Object[] objArr) {
        f15811c.b(supportSQLiteProgram, objArr);
    }

    public int a() {
        Object[] objArr = this.f15813b;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    @NotNull
    public String b() {
        return this.f15812a;
    }

    public void c(@NotNull SupportSQLiteProgram supportSQLiteProgram) {
        Intrinsics.p(supportSQLiteProgram, "statement");
        f15811c.b(supportSQLiteProgram, this.f15813b);
    }

    public SimpleSQLiteQuery(@NotNull String str, @Nullable Object[] objArr) {
        Intrinsics.p(str, SearchIntents.f19720b);
        this.f15812a = str;
        this.f15813b = objArr;
    }
}
