package com.google.firebase.logger;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nLogger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Logger.kt\ncom/google/firebase/logger/Logger\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,196:1\n26#2:197\n*S KotlinDebug\n*F\n+ 1 Logger.kt\ncom/google/firebase/logger/Logger\n*L\n78#1:197\n*E\n"})
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b%\b&\u0018\u0000 02\u00020\u0001:\u00041234B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ=\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0012\b\u0002\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00022\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0016\u0010\u0017J;\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00022\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0018\u0010\u0014J#\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0019\u0010\u0017J;\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00022\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u001a\u0010\u0014J#\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u001b\u0010\u0017J;\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00022\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u001c\u0010\u0014J#\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u001d\u0010\u0017J;\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00022\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u001e\u0010\u0014J#\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u001f\u0010\u0017J;\u0010 \u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0010\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b \u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/google/firebase/logger/Logger;", "", "", "tag", "", "enabled", "Lcom/google/firebase/logger/Logger$Level;", "minLevel", "<init>", "(Ljava/lang/String;ZLcom/google/firebase/logger/Logger$Level;)V", "level", "format", "", "args", "", "throwable", "", "y", "(Lcom/google/firebase/logger/Logger$Level;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)I", "G", "(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)I", "msg", "E", "(Ljava/lang/String;Ljava/lang/Throwable;)I", "e", "c", "u", "s", "M", "K", "k", "i", "x", "a", "Ljava/lang/String;", "q", "()Ljava/lang/String;", "b", "Z", "n", "()Z", "A", "(Z)V", "Lcom/google/firebase/logger/Logger$Level;", "p", "()Lcom/google/firebase/logger/Logger$Level;", "B", "(Lcom/google/firebase/logger/Logger$Level;)V", "d", "AndroidLogger", "Companion", "FakeLogger", "Level", "com.google.firebase-firebase-common"}, k = 1, mv = {1, 8, 0})
public abstract class Logger {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f24624d = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final ConcurrentHashMap<String, Logger> f24625e = new ConcurrentHashMap<>();
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f24626a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f24627b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private Level f24628c;

    @SourceDebugExtension({"SMAP\nLogger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Logger.kt\ncom/google/firebase/logger/Logger$AndroidLogger\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,196:1\n1#2:197\n*E\n"})
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ;\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0010\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/google/firebase/logger/Logger$AndroidLogger;", "Lcom/google/firebase/logger/Logger;", "", "tag", "", "enabled", "Lcom/google/firebase/logger/Logger$Level;", "minLevel", "<init>", "(Ljava/lang/String;ZLcom/google/firebase/logger/Logger$Level;)V", "level", "format", "", "", "args", "", "throwable", "", "x", "(Lcom/google/firebase/logger/Logger$Level;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)I", "com.google.firebase-firebase-common"}, k = 1, mv = {1, 8, 0})
    private static final class AndroidLogger extends Logger {

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f24629a;

            /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    com.google.firebase.logger.Logger$Level[] r0 = com.google.firebase.logger.Logger.Level.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.google.firebase.logger.Logger$Level r1 = com.google.firebase.logger.Logger.Level.VERBOSE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.google.firebase.logger.Logger$Level r1 = com.google.firebase.logger.Logger.Level.DEBUG     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    com.google.firebase.logger.Logger$Level r1 = com.google.firebase.logger.Logger.Level.INFO     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    com.google.firebase.logger.Logger$Level r1 = com.google.firebase.logger.Logger.Level.WARN     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    com.google.firebase.logger.Logger$Level r1 = com.google.firebase.logger.Logger.Level.ERROR     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    f24629a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.logger.Logger.AndroidLogger.WhenMappings.<clinit>():void");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AndroidLogger(@NotNull String str, boolean z, @NotNull Level level) {
            super(str, z, level, (DefaultConstructorMarker) null);
            Intrinsics.p(str, "tag");
            Intrinsics.p(level, "minLevel");
        }

        public int x(@NotNull Level level, @NotNull String str, @NotNull Object[] objArr, @Nullable Throwable th) {
            Intrinsics.p(level, "level");
            Intrinsics.p(str, DublinCoreProperties.f27400f);
            Intrinsics.p(objArr, "args");
            if (objArr.length != 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f28971a;
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                str = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
                Intrinsics.o(str, "format(format, *args)");
            }
            int i2 = WhenMappings.f24629a[level.ordinal()];
            if (i2 == 1) {
                String q = q();
                return th != null ? Log.v(q, str, th) : Log.v(q, str);
            } else if (i2 == 2) {
                String q2 = q();
                return th != null ? Log.d(q2, str, th) : Log.d(q2, str);
            } else if (i2 == 3) {
                String q3 = q();
                return th != null ? Log.i(q3, str, th) : Log.i(q3, str);
            } else if (i2 == 4) {
                String q4 = q();
                return th != null ? Log.w(q4, str, th) : Log.w(q4, str);
            } else if (i2 == 5) {
                String q5 = q();
                return th != null ? Log.e(q5, str, th) : Log.e(q5, str);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @SourceDebugExtension({"SMAP\nLogger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Logger.kt\ncom/google/firebase/logger/Logger$Companion\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,196:1\n73#2,2:197\n1#3:199\n*S KotlinDebug\n*F\n+ 1 Logger.kt\ncom/google/firebase/logger/Logger$Companion\n*L\n180#1:197,2\n180#1:199\n*E\n"})
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/google/firebase/logger/Logger$Companion;", "", "<init>", "()V", "", "tag", "", "enabled", "Lcom/google/firebase/logger/Logger$Level;", "minLevel", "Lcom/google/firebase/logger/Logger;", "a", "(Ljava/lang/String;ZLcom/google/firebase/logger/Logger$Level;)Lcom/google/firebase/logger/Logger;", "Lcom/google/firebase/logger/Logger$FakeLogger;", "c", "(Ljava/lang/String;ZLcom/google/firebase/logger/Logger$Level;)Lcom/google/firebase/logger/Logger$FakeLogger;", "Ljava/util/concurrent/ConcurrentHashMap;", "loggers", "Ljava/util/concurrent/ConcurrentHashMap;", "com.google.firebase-firebase-common"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ Logger b(Companion companion, String str, boolean z, Level level, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            if ((i2 & 4) != 0) {
                level = Level.INFO;
            }
            return companion.a(str, z, level);
        }

        public static /* synthetic */ FakeLogger d(Companion companion, String str, boolean z, Level level, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            if ((i2 & 4) != 0) {
                level = Level.DEBUG;
            }
            return companion.c(str, z, level);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
            r1 = new com.google.firebase.logger.Logger.AndroidLogger(r3, r4, r5);
         */
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.google.firebase.logger.Logger a(@org.jetbrains.annotations.NotNull java.lang.String r3, boolean r4, @org.jetbrains.annotations.NotNull com.google.firebase.logger.Logger.Level r5) {
            /*
                r2 = this;
                java.lang.String r0 = "tag"
                kotlin.jvm.internal.Intrinsics.p(r3, r0)
                java.lang.String r0 = "minLevel"
                kotlin.jvm.internal.Intrinsics.p(r5, r0)
                java.util.concurrent.ConcurrentHashMap r0 = com.google.firebase.logger.Logger.f24625e
                java.lang.Object r1 = r0.get(r3)
                if (r1 != 0) goto L_0x0021
                com.google.firebase.logger.Logger$AndroidLogger r1 = new com.google.firebase.logger.Logger$AndroidLogger
                r1.<init>(r3, r4, r5)
                java.lang.Object r3 = r0.putIfAbsent(r3, r1)
                if (r3 != 0) goto L_0x0020
                goto L_0x0021
            L_0x0020:
                r1 = r3
            L_0x0021:
                java.lang.String r3 = "loggers.getOrPut(tag) { …tag, enabled, minLevel) }"
                kotlin.jvm.internal.Intrinsics.o(r1, r3)
                com.google.firebase.logger.Logger r1 = (com.google.firebase.logger.Logger) r1
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.logger.Logger.Companion.a(java.lang.String, boolean, com.google.firebase.logger.Logger$Level):com.google.firebase.logger.Logger");
        }

        @JvmStatic
        @NotNull
        @VisibleForTesting
        public final FakeLogger c(@NotNull String str, boolean z, @NotNull Level level) {
            Intrinsics.p(str, "tag");
            Intrinsics.p(level, "minLevel");
            FakeLogger fakeLogger = new FakeLogger(str, z, level);
            Logger.f24625e.put(str, fakeLogger);
            return fakeLogger;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @SourceDebugExtension({"SMAP\nLogger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Logger.kt\ncom/google/firebase/logger/Logger$FakeLogger\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,196:1\n1747#2,3:197\n1747#2,3:200\n1#3:203\n*S KotlinDebug\n*F\n+ 1 Logger.kt\ncom/google/firebase/logger/Logger$FakeLogger\n*L\n144#1:197,3\n148#1:200,3\n*E\n"})
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ;\u0010\u0011\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0010\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0010\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001e\u001a\u00020\u00042\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/google/firebase/logger/Logger$FakeLogger;", "Lcom/google/firebase/logger/Logger;", "", "tag", "", "enabled", "Lcom/google/firebase/logger/Logger$Level;", "minLevel", "<init>", "(Ljava/lang/String;ZLcom/google/firebase/logger/Logger$Level;)V", "level", "format", "", "", "args", "", "throwable", "S", "(Lcom/google/firebase/logger/Logger$Level;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)Ljava/lang/String;", "", "x", "(Lcom/google/firebase/logger/Logger$Level;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)I", "", "P", "()V", "message", "Q", "(Ljava/lang/String;)Z", "Lkotlin/Function1;", "predicate", "R", "(Lkotlin/jvm/functions/Function1;)Z", "", "f", "Ljava/util/List;", "record", "com.google.firebase-firebase-common"}, k = 1, mv = {1, 8, 0})
    @VisibleForTesting
    public static final class FakeLogger extends Logger {
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        private final List<String> f24630f = new ArrayList();

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FakeLogger(@NotNull String str, boolean z, @NotNull Level level) {
            super(str, z, level, (DefaultConstructorMarker) null);
            Intrinsics.p(str, "tag");
            Intrinsics.p(level, "minLevel");
        }

        private final String S(Level level, String str, Object[] objArr, Throwable th) {
            if (objArr.length != 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f28971a;
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                str = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
                Intrinsics.o(str, "format(format, *args)");
            }
            if (th != null) {
                String str2 = level + ' ' + str + ' ' + Log.getStackTraceString(th);
                if (str2 != null) {
                    return str2;
                }
            }
            return level + ' ' + str;
        }

        @VisibleForTesting
        public final void P() {
            this.f24630f.clear();
        }

        @VisibleForTesting
        public final boolean Q(@NotNull String str) {
            Intrinsics.p(str, "message");
            List<String> list = this.f24630f;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            for (String T2 : list) {
                if (StringsKt.T2(T2, str, false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        }

        @VisibleForTesting
        public final boolean R(@NotNull Function1<? super String, Boolean> function1) {
            Intrinsics.p(function1, "predicate");
            List<String> list = this.f24630f;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (function1.f(it2.next()).booleanValue()) {
                    return true;
                }
            }
            return false;
        }

        public int x(@NotNull Level level, @NotNull String str, @NotNull Object[] objArr, @Nullable Throwable th) {
            Intrinsics.p(level, "level");
            Intrinsics.p(str, DublinCoreProperties.f27400f);
            Intrinsics.p(objArr, "args");
            String S = S(level, str, objArr, th);
            System.out.println("Log: " + S);
            this.f24630f.add(S);
            return S.length();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/google/firebase/logger/Logger$Level;", "", "", "priority", "<init>", "(Ljava/lang/String;II)V", "s", "I", "b", "()I", "X", "Y", "Z", "X2", "Y2", "com.google.firebase-firebase-common"}, k = 1, mv = {1, 8, 0})
    public enum Level {
        VERBOSE(2),
        DEBUG(3),
        INFO(4),
        WARN(5),
        ERROR(6);
        
        private final int s;

        private Level(int i2) {
            this.s = i2;
        }

        public final int b() {
            return this.s;
        }
    }

    private Logger(String str, boolean z, Level level) {
        this.f24626a = str;
        this.f24627b = z;
        this.f24628c = level;
    }

    @JvmStatic
    @NotNull
    @VisibleForTesting
    public static final FakeLogger C(@NotNull String str, boolean z, @NotNull Level level) {
        return f24624d.c(str, z, level);
    }

    public static /* synthetic */ int H(Logger logger, String str, Throwable th, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                th = null;
            }
            return logger.E(str, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verbose");
    }

    public static /* synthetic */ int I(Logger logger, String str, Object[] objArr, Throwable th, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                th = null;
            }
            return logger.G(str, objArr, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verbose");
    }

    public static /* synthetic */ int N(Logger logger, String str, Throwable th, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                th = null;
            }
            return logger.K(str, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warn");
    }

    public static /* synthetic */ int O(Logger logger, String str, Object[] objArr, Throwable th, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                th = null;
            }
            return logger.M(str, objArr, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warn");
    }

    public static /* synthetic */ int f(Logger logger, String str, Throwable th, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                th = null;
            }
            return logger.c(str, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: debug");
    }

    public static /* synthetic */ int g(Logger logger, String str, Object[] objArr, Throwable th, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                th = null;
            }
            return logger.e(str, objArr, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: debug");
    }

    public static /* synthetic */ int l(Logger logger, String str, Throwable th, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                th = null;
            }
            return logger.i(str, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
    }

    public static /* synthetic */ int m(Logger logger, String str, Object[] objArr, Throwable th, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                th = null;
            }
            return logger.k(str, objArr, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
    }

    @JvmStatic
    @NotNull
    public static final Logger o(@NotNull String str, boolean z, @NotNull Level level) {
        return f24624d.a(str, z, level);
    }

    public static /* synthetic */ int v(Logger logger, String str, Throwable th, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                th = null;
            }
            return logger.s(str, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: info");
    }

    public static /* synthetic */ int w(Logger logger, String str, Object[] objArr, Throwable th, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                th = null;
            }
            return logger.u(str, objArr, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: info");
    }

    private final int y(Level level, String str, Object[] objArr, Throwable th) {
        if (!this.f24627b || (this.f24628c.b() > level.b() && !Log.isLoggable(this.f24626a, level.b()))) {
            return 0;
        }
        return x(level, str, objArr, th);
    }

    static /* synthetic */ int z(Logger logger, Level level, String str, Object[] objArr, Throwable th, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                objArr = new Object[0];
            }
            return logger.y(level, str, objArr, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logIfAble");
    }

    public final void A(boolean z) {
        this.f24627b = z;
    }

    public final void B(@NotNull Level level) {
        Intrinsics.p(level, "<set-?>");
        this.f24628c = level;
    }

    @JvmOverloads
    public final int D(@NotNull String str) {
        Intrinsics.p(str, NotificationCompat.G0);
        return H(this, str, (Throwable) null, 2, (Object) null);
    }

    @JvmOverloads
    public final int E(@NotNull String str, @Nullable Throwable th) {
        Intrinsics.p(str, NotificationCompat.G0);
        return z(this, Level.VERBOSE, str, (Object[]) null, th, 4, (Object) null);
    }

    @JvmOverloads
    public final int F(@NotNull String str, @NotNull Object... objArr) {
        Intrinsics.p(str, DublinCoreProperties.f27400f);
        Intrinsics.p(objArr, "args");
        return I(this, str, objArr, (Throwable) null, 4, (Object) null);
    }

    @JvmOverloads
    public final int G(@NotNull String str, @NotNull Object[] objArr, @Nullable Throwable th) {
        Intrinsics.p(str, DublinCoreProperties.f27400f);
        Intrinsics.p(objArr, "args");
        return y(Level.VERBOSE, str, objArr, th);
    }

    @JvmOverloads
    public final int J(@NotNull String str) {
        Intrinsics.p(str, NotificationCompat.G0);
        return N(this, str, (Throwable) null, 2, (Object) null);
    }

    @JvmOverloads
    public final int K(@NotNull String str, @Nullable Throwable th) {
        Intrinsics.p(str, NotificationCompat.G0);
        return z(this, Level.WARN, str, (Object[]) null, th, 4, (Object) null);
    }

    @JvmOverloads
    public final int L(@NotNull String str, @NotNull Object... objArr) {
        Intrinsics.p(str, DublinCoreProperties.f27400f);
        Intrinsics.p(objArr, "args");
        return O(this, str, objArr, (Throwable) null, 4, (Object) null);
    }

    @JvmOverloads
    public final int M(@NotNull String str, @NotNull Object[] objArr, @Nullable Throwable th) {
        Intrinsics.p(str, DublinCoreProperties.f27400f);
        Intrinsics.p(objArr, "args");
        return y(Level.WARN, str, objArr, th);
    }

    @JvmOverloads
    public final int b(@NotNull String str) {
        Intrinsics.p(str, NotificationCompat.G0);
        return f(this, str, (Throwable) null, 2, (Object) null);
    }

    @JvmOverloads
    public final int c(@NotNull String str, @Nullable Throwable th) {
        Intrinsics.p(str, NotificationCompat.G0);
        return z(this, Level.DEBUG, str, (Object[]) null, th, 4, (Object) null);
    }

    @JvmOverloads
    public final int d(@NotNull String str, @NotNull Object... objArr) {
        Intrinsics.p(str, DublinCoreProperties.f27400f);
        Intrinsics.p(objArr, "args");
        return g(this, str, objArr, (Throwable) null, 4, (Object) null);
    }

    @JvmOverloads
    public final int e(@NotNull String str, @NotNull Object[] objArr, @Nullable Throwable th) {
        Intrinsics.p(str, DublinCoreProperties.f27400f);
        Intrinsics.p(objArr, "args");
        return y(Level.DEBUG, str, objArr, th);
    }

    @JvmOverloads
    public final int h(@NotNull String str) {
        Intrinsics.p(str, NotificationCompat.G0);
        return l(this, str, (Throwable) null, 2, (Object) null);
    }

    @JvmOverloads
    public final int i(@NotNull String str, @Nullable Throwable th) {
        Intrinsics.p(str, NotificationCompat.G0);
        return z(this, Level.ERROR, str, (Object[]) null, th, 4, (Object) null);
    }

    @JvmOverloads
    public final int j(@NotNull String str, @NotNull Object... objArr) {
        Intrinsics.p(str, DublinCoreProperties.f27400f);
        Intrinsics.p(objArr, "args");
        return m(this, str, objArr, (Throwable) null, 4, (Object) null);
    }

    @JvmOverloads
    public final int k(@NotNull String str, @NotNull Object[] objArr, @Nullable Throwable th) {
        Intrinsics.p(str, DublinCoreProperties.f27400f);
        Intrinsics.p(objArr, "args");
        return y(Level.ERROR, str, objArr, th);
    }

    public final boolean n() {
        return this.f24627b;
    }

    @NotNull
    public final Level p() {
        return this.f24628c;
    }

    @NotNull
    public final String q() {
        return this.f24626a;
    }

    @JvmOverloads
    public final int r(@NotNull String str) {
        Intrinsics.p(str, NotificationCompat.G0);
        return v(this, str, (Throwable) null, 2, (Object) null);
    }

    @JvmOverloads
    public final int s(@NotNull String str, @Nullable Throwable th) {
        Intrinsics.p(str, NotificationCompat.G0);
        return z(this, Level.INFO, str, (Object[]) null, th, 4, (Object) null);
    }

    @JvmOverloads
    public final int t(@NotNull String str, @NotNull Object... objArr) {
        Intrinsics.p(str, DublinCoreProperties.f27400f);
        Intrinsics.p(objArr, "args");
        return w(this, str, objArr, (Throwable) null, 4, (Object) null);
    }

    @JvmOverloads
    public final int u(@NotNull String str, @NotNull Object[] objArr, @Nullable Throwable th) {
        Intrinsics.p(str, DublinCoreProperties.f27400f);
        Intrinsics.p(objArr, "args");
        return y(Level.INFO, str, objArr, th);
    }

    public abstract int x(@NotNull Level level, @NotNull String str, @NotNull Object[] objArr, @Nullable Throwable th);

    public /* synthetic */ Logger(String str, boolean z, Level level, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, level);
    }
}
