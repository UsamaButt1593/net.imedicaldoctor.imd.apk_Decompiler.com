package kotlin.text;

import com.itextpdf.text.Annotation;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0019\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a$\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\b\u0010\t\u001a$\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\n\u0010\u0006\u001a$\u0010\u000b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u000b\u0010\t\u001a'\u0010\u000f\u001a\u00020\r*\u0004\u0018\u00010\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014\u001a+\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018\u001a+\u0010\u0019\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u0014\u001a+\u0010\u001a\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001a\u0010\u0018\u001a\u0014\u0010\u001b\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0014\u0010\u001d\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u001d\u0010\u001c\u001a\u0014\u0010\u001e\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u001e\u0010\u001c\u001a\u0014\u0010\u001f\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u001f\u0010\u001c\u001a\u0013\u0010!\u001a\u00020\u0000*\u00020 H\u0007¢\u0006\u0004\b!\u0010\"\u001a'\u0010%\u001a\u00020\u0000*\u00020 2\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u0003H\u0007¢\u0006\u0004\b%\u0010&\u001a'\u0010'\u001a\u00020 *\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u0003H\u0007¢\u0006\u0004\b'\u0010(\u001a\u0013\u0010*\u001a\u00020\u0000*\u00020)H\u0007¢\u0006\u0004\b*\u0010+\u001a1\u0010-\u001a\u00020\u0000*\u00020)2\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\rH\u0007¢\u0006\u0004\b-\u0010.\u001a\u0013\u0010/\u001a\u00020)*\u00020\u0000H\u0007¢\u0006\u0004\b/\u00100\u001a1\u00101\u001a\u00020)*\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\rH\u0007¢\u0006\u0004\b1\u00102\u001a\u0014\u00103\u001a\u00020 *\u00020\u0000H\b¢\u0006\u0004\b3\u00104\u001a:\u00107\u001a\u00020 *\u00020\u00002\u0006\u00105\u001a\u00020 2\b\b\u0002\u00106\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u0003H\b¢\u0006\u0004\b7\u00108\u001a,\u0010<\u001a\u00020\u0000*\u00020\u00002\u0016\u0010;\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010:09\"\u0004\u0018\u00010:H\b¢\u0006\u0004\b<\u0010=\u001a4\u0010@\u001a\u00020\u0000*\u00020>2\u0006\u0010?\u001a\u00020\u00002\u0016\u0010;\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010:09\"\u0004\u0018\u00010:H\b¢\u0006\u0004\b@\u0010A\u001a6\u0010D\u001a\u00020\u0000*\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010B2\u0016\u0010;\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010:09\"\u0004\u0018\u00010:H\b¢\u0006\u0004\bD\u0010E\u001a>\u0010F\u001a\u00020\u0000*\u00020>2\b\u0010C\u001a\u0004\u0018\u00010B2\u0006\u0010?\u001a\u00020\u00002\u0016\u0010;\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010:09\"\u0004\u0018\u00010:H\b¢\u0006\u0004\bF\u0010G\u001a)\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00000L*\u00020H2\u0006\u0010J\u001a\u00020I2\b\b\u0002\u0010K\u001a\u00020\u0003¢\u0006\u0004\bM\u0010N\u001a\u001c\u0010O\u001a\u00020\u0000*\u00020\u00002\u0006\u0010#\u001a\u00020\u0003H\b¢\u0006\u0004\bO\u0010P\u001a$\u0010Q\u001a\u00020\u0000*\u00020\u00002\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\b¢\u0006\u0004\bQ\u0010R\u001a#\u0010T\u001a\u00020\r*\u00020\u00002\u0006\u0010S\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bT\u0010\u0010\u001a+\u0010U\u001a\u00020\r*\u00020\u00002\u0006\u0010S\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bU\u0010V\u001a#\u0010X\u001a\u00020\r*\u00020\u00002\u0006\u0010W\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bX\u0010\u0010\u001a0\u0010^\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020)2\u0006\u0010Z\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\\H\b¢\u0006\u0004\b^\u0010_\u001a \u0010`\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020)2\u0006\u0010]\u001a\u00020\\H\b¢\u0006\u0004\b`\u0010a\u001a(\u0010b\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020)2\u0006\u0010Z\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\u0003H\b¢\u0006\u0004\bb\u0010c\u001a\u0018\u0010d\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020)H\b¢\u0006\u0004\bd\u0010+\u001a\u0018\u0010f\u001a\u00020\u00002\u0006\u0010e\u001a\u00020 H\b¢\u0006\u0004\bf\u0010\"\u001a(\u0010g\u001a\u00020\u00002\u0006\u0010e\u001a\u00020 2\u0006\u0010Z\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\u0003H\b¢\u0006\u0004\bg\u0010&\u001a(\u0010j\u001a\u00020\u00002\u0006\u0010i\u001a\u00020h2\u0006\u0010Z\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\u0003H\b¢\u0006\u0004\bj\u0010k\u001a\u0018\u0010n\u001a\u00020\u00002\u0006\u0010m\u001a\u00020lH\b¢\u0006\u0004\bn\u0010o\u001a\u0018\u0010r\u001a\u00020\u00002\u0006\u0010q\u001a\u00020pH\b¢\u0006\u0004\br\u0010s\u001a\u001c\u0010u\u001a\u00020\u0003*\u00020\u00002\u0006\u0010t\u001a\u00020\u0003H\b¢\u0006\u0004\bu\u0010v\u001a\u001c\u0010w\u001a\u00020\u0003*\u00020\u00002\u0006\u0010t\u001a\u00020\u0003H\b¢\u0006\u0004\bw\u0010v\u001a$\u0010y\u001a\u00020\u0003*\u00020\u00002\u0006\u0010x\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\b¢\u0006\u0004\by\u0010z\u001a#\u0010{\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b{\u0010|\u001a\u001c\u0010~\u001a\u00020\r*\u00020\u00002\u0006\u0010}\u001a\u00020HH\b¢\u0006\u0004\b~\u0010\u001a\u001f\u0010\u0001\u001a\u00020\r*\u00020\u00002\u0006\u0010q\u001a\u00020lH\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a#\u0010\u0001\u001a\u00020\r*\u0004\u0018\u00010H2\b\u0010\f\u001a\u0004\u0018\u00010HH\u0004¢\u0006\u0006\b\u0001\u0010\u0001\u001a*\u0010\u0001\u001a\u00020\r*\u0004\u0018\u00010H2\b\u0010\f\u001a\u0004\u0018\u00010H2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u0016\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0005\b\u0001\u0010\u001c\u001a\u0014\u0010\u0001\u001a\u00020\r*\u00020H¢\u0006\u0006\b\u0001\u0010\u0001\u001a'\u0010\u0001\u001a\u00020\u0003*\u00020\u00002\u0006\u0010t\u001a\u00020\u00032\u0007\u0010\u0001\u001a\u00020\u0003H\b¢\u0006\u0005\b\u0001\u0010z\u001a@\u0010\u0001\u001a\u00020\r*\u00020H2\u0007\u0010\u0001\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020H2\u0007\u0010\u0001\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0006\b\u0001\u0010\u0001\u001a@\u0010\u0001\u001a\u00020\r*\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u001f\u0010\u0001\u001a\u00020\u0000*\u00020\u00002\u0006\u0010C\u001a\u00020BH\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u001f\u0010\u0001\u001a\u00020\u0000*\u00020\u00002\u0006\u0010C\u001a\u00020BH\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u001f\u0010\u0001\u001a\u00020\u0000*\u00020\u00002\u0006\u0010C\u001a\u00020BH\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u001f\u0010\u0001\u001a\u00020\u0000*\u00020\u00002\u0006\u0010C\u001a\u00020BH\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a!\u0010\u0001\u001a\u00020)*\u00020\u00002\b\b\u0002\u0010]\u001a\u00020\\H\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a\"\u0010\u0001\u001a\u00020I*\u00020\u00002\t\b\u0002\u0010\u0001\u001a\u00020\u0003H\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u0015\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0005\b\u0001\u0010\u001c\u001a\u001e\u0010\u0001\u001a\u00020\u0000*\u00020\u00002\u0006\u0010C\u001a\u00020BH\u0007¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u0015\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0005\b\u0001\u0010\u001c\u001a\u001e\u0010\u0001\u001a\u00020\u0000*\u00020\u00002\u0006\u0010C\u001a\u00020BH\u0007¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u001d\u0010 \u0001\u001a\u00020\u0000*\u00020H2\u0007\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b \u0001\u0010¡\u0001\"*\u0010¦\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00000¢\u0001j\t\u0012\u0004\u0012\u00020\u0000`£\u0001*\u00020>8F¢\u0006\b\u001a\u0006\b¤\u0001\u0010¥\u0001¨\u0006§\u0001"}, d2 = {"", "", "ch", "", "fromIndex", "V1", "(Ljava/lang/String;CI)I", "str", "W1", "(Ljava/lang/String;Ljava/lang/String;I)I", "X1", "Y1", "other", "", "ignoreCase", "K1", "(Ljava/lang/String;Ljava/lang/String;Z)Z", "oldChar", "newChar", "f2", "(Ljava/lang/String;CCZ)Ljava/lang/String;", "oldValue", "newValue", "g2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;", "j2", "k2", "G2", "(Ljava/lang/String;)Ljava/lang/String;", "I2", "C2", "T1", "", "t1", "([C)Ljava/lang/String;", "startIndex", "endIndex", "u1", "([CII)Ljava/lang/String;", "y2", "(Ljava/lang/String;II)[C", "", "C1", "([B)Ljava/lang/String;", "throwOnInvalidSequence", "D1", "([BIIZ)Ljava/lang/String;", "F1", "(Ljava/lang/String;)[B", "G1", "(Ljava/lang/String;IIZ)[B", "x2", "(Ljava/lang/String;)[C", "destination", "destinationOffset", "z2", "(Ljava/lang/String;[CIII)[C", "", "", "args", "N1", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lkotlin/String$Companion;", "format", "O1", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Ljava/util/Locale;", "locale", "M1", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "P1", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "", "Ljava/util/regex/Pattern;", "regex", "limit", "", "n2", "(Ljava/lang/CharSequence;Ljava/util/regex/Pattern;I)Ljava/util/List;", "t2", "(Ljava/lang/String;I)Ljava/lang/String;", "u2", "(Ljava/lang/String;II)Ljava/lang/String;", "prefix", "q2", "p2", "(Ljava/lang/String;Ljava/lang/String;IZ)Z", "suffix", "I1", "bytes", "offset", "length", "Ljava/nio/charset/Charset;", "charset", "h1", "([BIILjava/nio/charset/Charset;)Ljava/lang/String;", "i1", "([BLjava/nio/charset/Charset;)Ljava/lang/String;", "g1", "([BII)Ljava/lang/String;", "f1", "chars", "j1", "k1", "", "codePoints", "l1", "([III)Ljava/lang/String;", "Ljava/lang/StringBuffer;", "stringBuffer", "d1", "(Ljava/lang/StringBuffer;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "stringBuilder", "e1", "(Ljava/lang/StringBuilder;)Ljava/lang/String;", "index", "o1", "(Ljava/lang/String;I)I", "p1", "beginIndex", "q1", "(Ljava/lang/String;II)I", "r1", "(Ljava/lang/String;Ljava/lang/String;Z)I", "charSequence", "y1", "(Ljava/lang/String;Ljava/lang/CharSequence;)Z", "z1", "(Ljava/lang/String;Ljava/lang/StringBuffer;)Z", "w1", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z", "x1", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Z", "R1", "S1", "(Ljava/lang/CharSequence;)Z", "codePointOffset", "Z1", "thisOffset", "otherOffset", "a2", "(Ljava/lang/CharSequence;ILjava/lang/CharSequence;IIZ)Z", "b2", "(Ljava/lang/String;ILjava/lang/String;IIZ)Z", "D2", "(Ljava/lang/String;Ljava/util/Locale;)Ljava/lang/String;", "U1", "H2", "J2", "v2", "(Ljava/lang/String;Ljava/nio/charset/Charset;)[B", "flags", "E2", "(Ljava/lang/String;I)Ljava/util/regex/Pattern;", "m1", "n1", "A1", "B1", "n", "e2", "(Ljava/lang/CharSequence;I)Ljava/lang/String;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "Q1", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "CASE_INSENSITIVE_ORDER", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/text/StringsKt")
@SourceDebugExtension({"SMAP\nStringsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringsJVM.kt\nkotlin/text/StringsKt__StringsJVMKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,805:1\n1174#2,2:806\n1#3:808\n1726#4,3:809\n*S KotlinDebug\n*F\n+ 1 StringsJVM.kt\nkotlin/text/StringsKt__StringsJVMKt\n*L\n73#1:806,2\n600#1:809,3\n*E\n"})
class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    @NotNull
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String A1(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        if (str.length() <= 0 || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        Intrinsics.n(substring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = substring.toLowerCase();
        Intrinsics.o(lowerCase, "this as java.lang.String).toLowerCase()");
        sb.append(lowerCase);
        String substring2 = str.substring(1);
        Intrinsics.o(substring2, "this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    public static /* synthetic */ char[] A2(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return y2(str, i2, i3);
    }

    @SinceKotlin(version = "1.4")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @NotNull
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @LowPriorityInOverloadResolution
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String B1(@NotNull String str, @NotNull Locale locale) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(locale, "locale");
        if (str.length() <= 0 || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        Intrinsics.n(substring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = substring.toLowerCase(locale);
        Intrinsics.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        sb.append(lowerCase);
        String substring2 = str.substring(1);
        Intrinsics.o(substring2, "this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    static /* synthetic */ char[] B2(String str, char[] cArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = str.length();
        }
        Intrinsics.p(str, "<this>");
        Intrinsics.p(cArr, Annotation.l3);
        str.getChars(i3, i4, cArr, i2);
        return cArr;
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String C1(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "<this>");
        return new String(bArr, Charsets.f29053b);
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String C2(String str) {
        Intrinsics.p(str, "<this>");
        String lowerCase = str.toLowerCase();
        Intrinsics.o(lowerCase, "this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String D1(@NotNull byte[] bArr, int i2, int i3, boolean z) {
        Intrinsics.p(bArr, "<this>");
        AbstractList.s.a(i2, i3, bArr.length);
        if (!z) {
            return new String(bArr, i2, i3 - i2, Charsets.f29053b);
        }
        CharsetDecoder newDecoder = Charsets.f29053b.newDecoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        String charBuffer = newDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bArr, i2, i3 - i2)).toString();
        Intrinsics.o(charBuffer, "decoder.decode(ByteBuffe…- startIndex)).toString()");
        return charBuffer;
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(locale)", imports = {}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String D2(String str, Locale locale) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public static /* synthetic */ String E1(byte[] bArr, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return D1(bArr, i2, i3, z);
    }

    @InlineOnly
    private static final Pattern E2(String str, int i2) {
        Intrinsics.p(str, "<this>");
        Pattern compile = Pattern.compile(str, i2);
        Intrinsics.o(compile, "compile(this, flags)");
        return compile;
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static byte[] F1(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.f29053b);
        Intrinsics.o(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    static /* synthetic */ Pattern F2(String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        Intrinsics.p(str, "<this>");
        Pattern compile = Pattern.compile(str, i2);
        Intrinsics.o(compile, "compile(this, flags)");
        return compile;
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final byte[] G1(@NotNull String str, int i2, int i3, boolean z) {
        Intrinsics.p(str, "<this>");
        AbstractList.s.a(i2, i3, str.length());
        if (!z) {
            String substring = str.substring(i2, i3);
            Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            Charset charset = Charsets.f29053b;
            Intrinsics.n(substring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes = substring.getBytes(charset);
            Intrinsics.o(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        CharsetEncoder newEncoder = Charsets.f29053b.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        ByteBuffer encode = newEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).encode(CharBuffer.wrap(str, i2, i3));
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            int remaining = encode.remaining();
            byte[] array = encode.array();
            Intrinsics.m(array);
            if (remaining == array.length) {
                byte[] array2 = encode.array();
                Intrinsics.o(array2, "{\n        byteBuffer.array()\n    }");
                return array2;
            }
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return bArr;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String G2(String str) {
        Intrinsics.p(str, "<this>");
        String upperCase = str.toUpperCase();
        Intrinsics.o(upperCase, "this as java.lang.String).toUpperCase()");
        return upperCase;
    }

    public static /* synthetic */ byte[] H1(String str, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return G1(str, i2, i3, z);
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(locale)", imports = {}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String H2(String str, Locale locale) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.o(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    public static boolean I1(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "suffix");
        if (!z) {
            return str.endsWith(str2);
        }
        return StringsKt.b2(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String I2(String str) {
        Intrinsics.p(str, "<this>");
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.o(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }

    public static /* synthetic */ boolean J1(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return StringsKt.I1(str, str2, z);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String J2(String str, Locale locale) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.o(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    public static boolean K1(@Nullable String str, @Nullable String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean L1(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return StringsKt.K1(str, str2, z);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final String M1(String str, Locale locale, Object... objArr) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(objArr, "args");
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.o(format, "format(locale, this, *args)");
        return format;
    }

    @InlineOnly
    private static final String N1(String str, Object... objArr) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(objArr, "args");
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.o(format, "format(this, *args)");
        return format;
    }

    @InlineOnly
    private static final String O1(StringCompanionObject stringCompanionObject, String str, Object... objArr) {
        Intrinsics.p(stringCompanionObject, "<this>");
        Intrinsics.p(str, DublinCoreProperties.f27400f);
        Intrinsics.p(objArr, "args");
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.o(format, "format(format, *args)");
        return format;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final String P1(StringCompanionObject stringCompanionObject, Locale locale, String str, Object... objArr) {
        Intrinsics.p(stringCompanionObject, "<this>");
        Intrinsics.p(str, DublinCoreProperties.f27400f);
        Intrinsics.p(objArr, "args");
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.o(format, "format(locale, format, *args)");
        return format;
    }

    @NotNull
    public static final Comparator<String> Q1(@NotNull StringCompanionObject stringCompanionObject) {
        Intrinsics.p(stringCompanionObject, "<this>");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.o(comparator, "CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    @InlineOnly
    private static final String R1(String str) {
        Intrinsics.p(str, "<this>");
        String intern = str.intern();
        Intrinsics.o(intern, "this as java.lang.String).intern()");
        return intern;
    }

    public static final boolean S1(@NotNull CharSequence charSequence) {
        Intrinsics.p(charSequence, "<this>");
        if (charSequence.length() != 0) {
            IntRange f3 = StringsKt__StringsKt.f3(charSequence);
            if (!(f3 instanceof Collection) || !((Collection) f3).isEmpty()) {
                Iterator it2 = f3.iterator();
                while (it2.hasNext()) {
                    if (!CharsKt__CharJVMKt.r(charSequence.charAt(((IntIterator) it2).b()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String T1(String str) {
        Intrinsics.p(str, "<this>");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String U1(String str, Locale locale) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @InlineOnly
    private static final int V1(String str, char c2, int i2) {
        Intrinsics.p(str, "<this>");
        return str.indexOf(c2, i2);
    }

    @InlineOnly
    private static final int W1(String str, String str2, int i2) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "str");
        return str.indexOf(str2, i2);
    }

    @InlineOnly
    private static final int X1(String str, char c2, int i2) {
        Intrinsics.p(str, "<this>");
        return str.lastIndexOf(c2, i2);
    }

    @InlineOnly
    private static final int Y1(String str, String str2, int i2) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "str");
        return str.lastIndexOf(str2, i2);
    }

    @InlineOnly
    private static final int Z1(String str, int i2, int i3) {
        Intrinsics.p(str, "<this>");
        return str.offsetByCodePoints(i2, i3);
    }

    public static final boolean a2(@NotNull CharSequence charSequence, int i2, @NotNull CharSequence charSequence2, int i3, int i4, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(charSequence2, "other");
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            return StringsKt__StringsKt.Y3(charSequence, i2, charSequence2, i3, i4, z);
        }
        return StringsKt.b2((String) charSequence, i2, (String) charSequence2, i3, i4, z);
    }

    public static boolean b2(@NotNull String str, int i2, @NotNull String str2, int i3, int i4, boolean z) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "other");
        return !z ? str.regionMatches(i2, str2, i3, i4) : str.regionMatches(z, i2, str2, i3, i4);
    }

    public static /* synthetic */ boolean c2(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, boolean z, int i5, Object obj) {
        return a2(charSequence, i2, charSequence2, i3, i4, (i5 & 16) != 0 ? false : z);
    }

    @InlineOnly
    private static final String d1(StringBuffer stringBuffer) {
        Intrinsics.p(stringBuffer, "stringBuffer");
        return new String(stringBuffer);
    }

    public static /* synthetic */ boolean d2(String str, int i2, String str2, int i3, int i4, boolean z, int i5, Object obj) {
        return StringsKt.b2(str, i2, str2, i3, i4, (i5 & 16) != 0 ? false : z);
    }

    @InlineOnly
    private static final String e1(StringBuilder sb) {
        Intrinsics.p(sb, "stringBuilder");
        return new String(sb);
    }

    @NotNull
    public static String e2(@NotNull CharSequence charSequence, int i2) {
        Intrinsics.p(charSequence, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i2 + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
        } else if (i2 == 0) {
            return "";
        } else {
            if (i2 == 1) {
                return charSequence.toString();
            }
            int length = charSequence.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb = new StringBuilder(charSequence.length() * i2);
                IntIterator n2 = new IntRange(1, i2).iterator();
                while (n2.hasNext()) {
                    n2.b();
                    sb.append(charSequence);
                }
                String sb2 = sb.toString();
                Intrinsics.o(sb2, "{\n                    va…tring()\n                }");
                return sb2;
            }
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cArr[i3] = charAt;
            }
            return new String(cArr);
        }
    }

    @InlineOnly
    private static final String f1(byte[] bArr) {
        Intrinsics.p(bArr, "bytes");
        return new String(bArr, Charsets.f29053b);
    }

    @NotNull
    public static final String f2(@NotNull String str, char c2, char c3, boolean z) {
        String sb;
        String str2;
        Intrinsics.p(str, "<this>");
        if (!z) {
            sb = str.replace(c2, c3);
            str2 = "this as java.lang.String…replace(oldChar, newChar)";
        } else {
            StringBuilder sb2 = new StringBuilder(str.length());
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (CharsKt__CharKt.J(charAt, c2, z)) {
                    charAt = c3;
                }
                sb2.append(charAt);
            }
            sb = sb2.toString();
            str2 = "StringBuilder(capacity).…builderAction).toString()";
        }
        Intrinsics.o(sb, str2);
        return sb;
    }

    @InlineOnly
    private static final String g1(byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "bytes");
        return new String(bArr, i2, i3, Charsets.f29053b);
    }

    @NotNull
    public static final String g2(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "oldValue");
        Intrinsics.p(str3, "newValue");
        int i2 = 0;
        int l3 = StringsKt__StringsKt.l3(str, str2, 0, z);
        if (l3 < 0) {
            return str;
        }
        int length = str2.length();
        int u = RangesKt.u(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append(str, i2, l3);
                sb.append(str3);
                i2 = l3 + length;
                if (l3 >= str.length() || (l3 = StringsKt__StringsKt.l3(str, str2, l3 + u, z)) <= 0) {
                    sb.append(str, i2, str.length());
                    String sb2 = sb.toString();
                    Intrinsics.o(sb2, "stringBuilder.append(this, i, length).toString()");
                }
                sb.append(str, i2, l3);
                sb.append(str3);
                i2 = l3 + length;
                break;
            } while ((l3 = StringsKt__StringsKt.l3(str, str2, l3 + u, z)) <= 0);
            sb.append(str, i2, str.length());
            String sb22 = sb.toString();
            Intrinsics.o(sb22, "stringBuilder.append(this, i, length).toString()");
            return sb22;
        }
        throw new OutOfMemoryError();
    }

    @InlineOnly
    private static final String h1(byte[] bArr, int i2, int i3, Charset charset) {
        Intrinsics.p(bArr, "bytes");
        Intrinsics.p(charset, "charset");
        return new String(bArr, i2, i3, charset);
    }

    public static /* synthetic */ String h2(String str, char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return f2(str, c2, c3, z);
    }

    @InlineOnly
    private static final String i1(byte[] bArr, Charset charset) {
        Intrinsics.p(bArr, "bytes");
        Intrinsics.p(charset, "charset");
        return new String(bArr, charset);
    }

    public static /* synthetic */ String i2(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return g2(str, str2, str3, z);
    }

    @InlineOnly
    private static final String j1(char[] cArr) {
        Intrinsics.p(cArr, "chars");
        return new String(cArr);
    }

    @NotNull
    public static final String j2(@NotNull String str, char c2, char c3, boolean z) {
        Intrinsics.p(str, "<this>");
        int o3 = StringsKt.o3(str, c2, 0, z, 2, (Object) null);
        return o3 < 0 ? str : StringsKt__StringsKt.G4(str, o3, o3 + 1, String.valueOf(c3)).toString();
    }

    @InlineOnly
    private static final String k1(char[] cArr, int i2, int i3) {
        Intrinsics.p(cArr, "chars");
        return new String(cArr, i2, i3);
    }

    @NotNull
    public static final String k2(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "oldValue");
        Intrinsics.p(str3, "newValue");
        int p3 = StringsKt__StringsKt.p3(str, str2, 0, z, 2, (Object) null);
        return p3 < 0 ? str : StringsKt__StringsKt.G4(str, p3, str2.length() + p3, str3).toString();
    }

    @InlineOnly
    private static final String l1(int[] iArr, int i2, int i3) {
        Intrinsics.p(iArr, "codePoints");
        return new String(iArr, i2, i3);
    }

    public static /* synthetic */ String l2(String str, char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return j2(str, c2, c3, z);
    }

    @NotNull
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String m1(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        Locale locale = Locale.getDefault();
        Intrinsics.o(locale, "getDefault()");
        return n1(str, locale);
    }

    public static /* synthetic */ String m2(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return k2(str, str2, str3, z);
    }

    @SinceKotlin(version = "1.4")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @NotNull
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @LowPriorityInOverloadResolution
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String n1(@NotNull String str, @NotNull Locale locale) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(locale, "locale");
        if (str.length() <= 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if (!Character.isLowerCase(charAt)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char titleCase = Character.toTitleCase(charAt);
        if (titleCase != Character.toUpperCase(charAt)) {
            sb.append(titleCase);
        } else {
            String substring = str.substring(0, 1);
            Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            Intrinsics.n(substring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = substring.toUpperCase(locale);
            Intrinsics.o(upperCase, "this as java.lang.String).toUpperCase(locale)");
            sb.append(upperCase);
        }
        String substring2 = str.substring(1);
        Intrinsics.o(substring2, "this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        String sb2 = sb.toString();
        Intrinsics.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public static final List<String> n2(@NotNull CharSequence charSequence, @NotNull Pattern pattern, int i2) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(pattern, "regex");
        StringsKt__StringsKt.K4(i2);
        if (i2 == 0) {
            i2 = -1;
        }
        String[] split = pattern.split(charSequence, i2);
        Intrinsics.o(split, "regex.split(this, if (limit == 0) -1 else limit)");
        return ArraysKt.t(split);
    }

    @InlineOnly
    private static final int o1(String str, int i2) {
        Intrinsics.p(str, "<this>");
        return str.codePointAt(i2);
    }

    public static /* synthetic */ List o2(CharSequence charSequence, Pattern pattern, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return n2(charSequence, pattern, i2);
    }

    @InlineOnly
    private static final int p1(String str, int i2) {
        Intrinsics.p(str, "<this>");
        return str.codePointBefore(i2);
    }

    public static final boolean p2(@NotNull String str, @NotNull String str2, int i2, boolean z) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "prefix");
        if (!z) {
            return str.startsWith(str2, i2);
        }
        return StringsKt.b2(str, i2, str2, 0, str2.length(), z);
    }

    @InlineOnly
    private static final int q1(String str, int i2, int i3) {
        Intrinsics.p(str, "<this>");
        return str.codePointCount(i2, i3);
    }

    public static final boolean q2(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return StringsKt.b2(str, 0, str2, 0, str2.length(), z);
    }

    public static final int r1(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "other");
        return z ? str.compareToIgnoreCase(str2) : str.compareTo(str2);
    }

    public static /* synthetic */ boolean r2(String str, String str2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return p2(str, str2, i2, z);
    }

    public static /* synthetic */ int s1(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return r1(str, str2, z);
    }

    public static /* synthetic */ boolean s2(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return q2(str, str2, z);
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static String t1(@NotNull char[] cArr) {
        Intrinsics.p(cArr, "<this>");
        return new String(cArr);
    }

    @InlineOnly
    private static final String t2(String str, int i2) {
        Intrinsics.p(str, "<this>");
        String substring = str.substring(i2);
        Intrinsics.o(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static String u1(@NotNull char[] cArr, int i2, int i3) {
        Intrinsics.p(cArr, "<this>");
        AbstractList.s.a(i2, i3, cArr.length);
        return new String(cArr, i2, i3 - i2);
    }

    @InlineOnly
    private static final String u2(String str, int i2, int i3) {
        Intrinsics.p(str, "<this>");
        String substring = str.substring(i2, i3);
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String v1(char[] cArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = cArr.length;
        }
        return StringsKt.u1(cArr, i2, i3);
    }

    @InlineOnly
    private static final byte[] v2(String str, Charset charset) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.o(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @SinceKotlin(version = "1.5")
    public static final boolean w1(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return (!(charSequence instanceof String) || charSequence2 == null) ? StringsKt__StringsKt.V2(charSequence, charSequence2) : ((String) charSequence).contentEquals(charSequence2);
    }

    static /* synthetic */ byte[] w2(String str, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(str, "<this>");
        Intrinsics.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.o(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @SinceKotlin(version = "1.5")
    public static final boolean x1(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z) {
        return z ? StringsKt__StringsKt.U2(charSequence, charSequence2) : w1(charSequence, charSequence2);
    }

    @InlineOnly
    private static final char[] x2(String str) {
        Intrinsics.p(str, "<this>");
        char[] charArray = str.toCharArray();
        Intrinsics.o(charArray, "this as java.lang.String).toCharArray()");
        return charArray;
    }

    @InlineOnly
    private static final boolean y1(String str, CharSequence charSequence) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(charSequence, "charSequence");
        return str.contentEquals(charSequence);
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final char[] y2(@NotNull String str, int i2, int i3) {
        Intrinsics.p(str, "<this>");
        AbstractList.s.a(i2, i3, str.length());
        char[] cArr = new char[(i3 - i2)];
        str.getChars(i2, i3, cArr, 0);
        return cArr;
    }

    @InlineOnly
    private static final boolean z1(String str, StringBuffer stringBuffer) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(stringBuffer, "stringBuilder");
        return str.contentEquals(stringBuffer);
    }

    @InlineOnly
    private static final char[] z2(String str, char[] cArr, int i2, int i3, int i4) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(cArr, Annotation.l3);
        str.getChars(i3, i4, cArr, i2);
        return cArr;
    }
}
