package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\u001a\u001d\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a%\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\u0003\u001a\u001b\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u000b\u0010\u0003\u001a\u0013\u0010\r\u001a\u00020\f*\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u000f2\u0006\u0010\n\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001aL\u0010\u0016\u001a\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00000\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u000f2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000fH\b¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"", "marginPrefix", "q", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "newIndent", "n", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "p", "(Ljava/lang/String;)Ljava/lang/String;", "l", "indent", "i", "", "h", "(Ljava/lang/String;)I", "Lkotlin/Function1;", "g", "(Ljava/lang/String;)Lkotlin/jvm/functions/Function1;", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "k", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/text/StringsKt")
@SourceDebugExtension({"SMAP\nIndent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,123:1\n113#1,2:125\n115#1,4:140\n120#1,2:153\n113#1,2:162\n115#1,4:177\n120#1,2:184\n1#2:124\n1#2:150\n1#2:181\n1#2:205\n1569#3,11:127\n1864#3,2:138\n1866#3:151\n1580#3:152\n766#3:155\n857#3,2:156\n1549#3:158\n1620#3,3:159\n1569#3,11:164\n1864#3,2:175\n1866#3:182\n1580#3:183\n1569#3,11:192\n1864#3,2:203\n1866#3:206\n1580#3:207\n151#4,6:144\n151#4,6:186\n*S KotlinDebug\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n*L\n38#1:125,2\n38#1:140,4\n38#1:153,2\n78#1:162,2\n78#1:177,4\n78#1:184,2\n38#1:150\n78#1:181\n114#1:205\n38#1:127,11\n38#1:138,2\n38#1:151\n38#1:152\n74#1:155\n74#1:156,2\n75#1:158\n75#1:159,3\n78#1:164,11\n78#1:175,2\n78#1:182\n78#1:183\n114#1:192,11\n114#1:203,2\n114#1:206\n114#1:207\n39#1:144,6\n101#1:186,6\n*E\n"})
class StringsKt__IndentKt extends StringsKt__AppendableKt {
    private static final Function1<String, String> g(String str) {
        return str.length() == 0 ? StringsKt__IndentKt$getIndentFunction$1.X : new StringsKt__IndentKt$getIndentFunction$2(str);
    }

    private static final int h(String str) {
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (!CharsKt__CharJVMKt.r(str.charAt(i2))) {
                break;
            } else {
                i2++;
            }
        }
        return i2 == -1 ? str.length() : i2;
    }

    @NotNull
    public static final String i(@NotNull String str, @NotNull String str2) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "indent");
        return SequencesKt.e1(SequencesKt.k1(StringsKt__StringsKt.I3(str), new StringsKt__IndentKt$prependIndent$1(str2)), StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public static /* synthetic */ String j(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "    ";
        }
        return i(str, str2);
    }

    private static final String k(List<String> list, int i2, Function1<? super String, String> function1, Function1<? super String, String> function12) {
        String f2;
        int G = CollectionsKt.G(list);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (T next : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.W();
            }
            String str = (String) next;
            if ((i3 == 0 || i3 == G) && StringsKt__StringsJVMKt.S1(str)) {
                str = null;
            } else {
                String f3 = function12.f(str);
                if (!(f3 == null || (f2 = function1.f(f3)) == null)) {
                    str = f2;
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
            i3 = i4;
        }
        String sb = ((StringBuilder) CollectionsKt.h3(arrayList, new StringBuilder(i2), StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
        Intrinsics.o(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    @NotNull
    public static final String l(@NotNull String str, @NotNull String str2) {
        String f2;
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "newIndent");
        List<String> J3 = StringsKt__StringsKt.J3(str);
        ArrayList<String> arrayList = new ArrayList<>();
        for (T next : J3) {
            if (!StringsKt__StringsJVMKt.S1((String) next)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.Y(arrayList, 10));
        for (String h2 : arrayList) {
            arrayList2.add(Integer.valueOf(h(h2)));
        }
        Integer num = (Integer) CollectionsKt.e4(arrayList2);
        int i2 = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * J3.size());
        Function1<String, String> g2 = g(str2);
        int G = CollectionsKt.G(J3);
        ArrayList arrayList3 = new ArrayList();
        for (T next2 : J3) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.W();
            }
            String str3 = (String) next2;
            if ((i2 == 0 || i2 == G) && StringsKt__StringsJVMKt.S1(str3)) {
                str3 = null;
            } else {
                String y6 = StringsKt.y6(str3, intValue);
                if (!(y6 == null || (f2 = g2.f(y6)) == null)) {
                    str3 = f2;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i2 = i3;
        }
        String sb = ((StringBuilder) CollectionsKt.h3(arrayList3, new StringBuilder(length), StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
        Intrinsics.o(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static /* synthetic */ String m(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "";
        }
        return l(str, str2);
    }

    @NotNull
    public static final String n(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        int i2;
        String f2;
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "newIndent");
        Intrinsics.p(str3, "marginPrefix");
        if (!StringsKt__StringsJVMKt.S1(str3)) {
            List<String> J3 = StringsKt__StringsKt.J3(str);
            int length = str.length() + (str2.length() * J3.size());
            Function1<String, String> g2 = g(str2);
            int G = CollectionsKt.G(J3);
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (T next : J3) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.W();
                }
                String str4 = (String) next;
                String str5 = null;
                if ((i3 == 0 || i3 == G) && StringsKt__StringsJVMKt.S1(str4)) {
                    str4 = null;
                } else {
                    int length2 = str4.length();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length2) {
                            i2 = -1;
                            break;
                        } else if (!CharsKt__CharJVMKt.r(str4.charAt(i5))) {
                            i2 = i5;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    if (i2 != -1) {
                        int i6 = i2;
                        if (StringsKt__StringsJVMKt.r2(str4, str3, i2, false, 4, (Object) null)) {
                            Intrinsics.n(str4, "null cannot be cast to non-null type java.lang.String");
                            str5 = str4.substring(i6 + str3.length());
                            Intrinsics.o(str5, "this as java.lang.String).substring(startIndex)");
                        }
                    }
                    if (!(str5 == null || (f2 = g2.f(str5)) == null)) {
                        str4 = f2;
                    }
                }
                if (str4 != null) {
                    arrayList.add(str4);
                }
                i3 = i4;
            }
            String sb = ((StringBuilder) CollectionsKt.h3(arrayList, new StringBuilder(length), StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
            Intrinsics.o(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static /* synthetic */ String o(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "";
        }
        if ((i2 & 2) != 0) {
            str3 = "|";
        }
        return n(str, str2, str3);
    }

    @NotNull
    @IntrinsicConstEvaluation
    public static String p(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        return l(str, "");
    }

    @NotNull
    @IntrinsicConstEvaluation
    public static final String q(@NotNull String str, @NotNull String str2) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "marginPrefix");
        return n(str, "", str2);
    }

    public static /* synthetic */ String r(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "|";
        }
        return q(str, str2);
    }
}
