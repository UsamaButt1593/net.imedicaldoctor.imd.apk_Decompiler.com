package com.google.firebase.util;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"\u001a\u0010\t\u001a\u00020\u00038\u0002XT¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\u0006\u0010\b¨\u0006\n"}, d2 = {"Lkotlin/random/Random;", "", "length", "", "b", "(Lkotlin/random/Random;I)Ljava/lang/String;", "a", "Ljava/lang/String;", "()V", "ALPHANUMERIC_ALPHABET", "com.google.firebase-firebase-common"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRandomUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RandomUtil.kt\ncom/google/firebase/util/RandomUtilKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,42:1\n1#2:43\n1549#3:44\n1620#3,3:45\n*S KotlinDebug\n*F\n+ 1 RandomUtil.kt\ncom/google/firebase/util/RandomUtilKt\n*L\n34#1:44\n34#1:45,3\n*E\n"})
public final class RandomUtilKt {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final String f25187a = "23456789abcdefghjkmnpqrstvwxyz";

    private static /* synthetic */ void a() {
    }

    @NotNull
    public static final String b(@NotNull Random random, int i2) {
        Intrinsics.p(random, "<this>");
        if (i2 >= 0) {
            IntRange W1 = RangesKt.W1(0, i2);
            ArrayList arrayList = new ArrayList(CollectionsKt.Y(W1, 10));
            Iterator it2 = W1.iterator();
            while (it2.hasNext()) {
                ((IntIterator) it2).b();
                arrayList.add(Character.valueOf(StringsKt.m8(f25187a, random)));
            }
            return CollectionsKt.j3(arrayList, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        throw new IllegalArgumentException(("invalid length: " + i2).toString());
    }
}
