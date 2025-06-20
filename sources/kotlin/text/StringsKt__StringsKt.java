package kotlin.text;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.pdf.PdfBoolean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.WasExperimental;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0019\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u001e\u001a+\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\b\u001a\u00020\u0007*\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0006\u001a+\u0010\u000b\u001a\u00020\u0007*\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\t\u001a+\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0006\u001a+\u0010\r\u001a\u00020\u0007*\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\t\u001a\u001d\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\n\u0010\u000f\u001a\u00020\u000e\"\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001d\u0010\u0012\u001a\u00020\u0007*\u00020\u00072\n\u0010\u000f\u001a\u00020\u000e\"\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\n\u0010\u000f\u001a\u00020\u000e\"\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0011\u001a\u001d\u0010\u0015\u001a\u00020\u0007*\u00020\u00072\n\u0010\u000f\u001a\u00020\u000e\"\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0013\u001a\u001d\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\n\u0010\u000f\u001a\u00020\u000e\"\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0011\u001a\u001d\u0010\u0017\u001a\u00020\u0007*\u00020\u00072\n\u0010\u000f\u001a\u00020\u000e\"\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0013\u001a\u0011\u0010\u0018\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0014\u0010\u001a\u001a\u00020\u0007*\u00020\u0007H\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0011\u0010\u001c\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u0019\u001a\u0014\u0010\u001d\u001a\u00020\u0007*\u00020\u0007H\b¢\u0006\u0004\b\u001d\u0010\u001b\u001a\u0011\u0010\u001e\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u001e\u0010\u0019\u001a\u0014\u0010\u001f\u001a\u00020\u0007*\u00020\u0007H\b¢\u0006\u0004\b\u001f\u0010\u001b\u001a#\u0010#\u001a\u00020\u0000*\u00020\u00002\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$\u001a#\u0010%\u001a\u00020\u0007*\u00020\u00072\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b%\u0010&\u001a#\u0010'\u001a\u00020\u0000*\u00020\u00002\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b'\u0010$\u001a#\u0010(\u001a\u00020\u0007*\u00020\u00072\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b(\u0010&\u001a'\u0010)\u001a\u00020\u0003*\u0004\u0018\u00010\u0000H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\b)\u0010*\u001a\u0014\u0010+\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b+\u0010*\u001a\u0014\u0010,\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b,\u0010*\u001a\u0014\u0010-\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b-\u0010*\u001a'\u0010.\u001a\u00020\u0003*\u0004\u0018\u00010\u0000H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\b.\u0010*\u001a\u0014\u00100\u001a\u00020/*\u00020\u0000H\u0002¢\u0006\u0004\b0\u00101\u001a\u0016\u00102\u001a\u00020\u0007*\u0004\u0018\u00010\u0007H\b¢\u0006\u0004\b2\u0010\u001b\u001a9\u00107\u001a\u00028\u0001\"\f\b\u0000\u00103*\u00020\u0000*\u00028\u0001\"\u0004\b\u0001\u00104*\u00028\u00002\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u000105H\bø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a9\u00109\u001a\u00028\u0001\"\f\b\u0000\u00103*\u00020\u0000*\u00028\u0001\"\u0004\b\u0001\u00104*\u00028\u00002\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u000105H\bø\u0001\u0000¢\u0006\u0004\b9\u00108\u001a\u0019\u0010;\u001a\u00020\u0003*\u00020\u00002\u0006\u0010:\u001a\u00020 ¢\u0006\u0004\b;\u0010<\u001a\u0019\u0010?\u001a\u00020\u0007*\u00020\u00072\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010@\u001a\u0019\u0010A\u001a\u00020\u0000*\u00020\u00002\u0006\u0010>\u001a\u00020=¢\u0006\u0004\bA\u0010B\u001a$\u0010E\u001a\u00020\u0000*\u00020\u00072\u0006\u0010C\u001a\u00020 2\u0006\u0010D\u001a\u00020 H\b¢\u0006\u0004\bE\u0010F\u001a&\u0010I\u001a\u00020\u0007*\u00020\u00002\u0006\u0010G\u001a\u00020 2\b\b\u0002\u0010H\u001a\u00020 H\b¢\u0006\u0004\bI\u0010J\u001a\u0019\u0010K\u001a\u00020\u0007*\u00020\u00002\u0006\u0010>\u001a\u00020=¢\u0006\u0004\bK\u0010L\u001a#\u0010O\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\bO\u0010P\u001a#\u0010Q\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u00072\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\bQ\u0010R\u001a#\u0010S\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\bS\u0010P\u001a#\u0010T\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u00072\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\bT\u0010R\u001a#\u0010U\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\bU\u0010P\u001a#\u0010V\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u00072\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\bV\u0010R\u001a#\u0010W\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\bW\u0010P\u001a#\u0010X\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u00072\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\bX\u0010R\u001a)\u0010Z\u001a\u00020\u0000*\u00020\u00002\u0006\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020 2\u0006\u0010Y\u001a\u00020\u0000¢\u0006\u0004\bZ\u0010[\u001a,\u0010\\\u001a\u00020\u0007*\u00020\u00072\u0006\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020 2\u0006\u0010Y\u001a\u00020\u0000H\b¢\u0006\u0004\b\\\u0010]\u001a!\u0010^\u001a\u00020\u0000*\u00020\u00002\u0006\u0010>\u001a\u00020=2\u0006\u0010Y\u001a\u00020\u0000¢\u0006\u0004\b^\u0010_\u001a$\u0010`\u001a\u00020\u0007*\u00020\u00072\u0006\u0010>\u001a\u00020=2\u0006\u0010Y\u001a\u00020\u0000H\b¢\u0006\u0004\b`\u0010a\u001a!\u0010b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020 ¢\u0006\u0004\bb\u0010c\u001a$\u0010d\u001a\u00020\u0007*\u00020\u00072\u0006\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020 H\b¢\u0006\u0004\bd\u0010e\u001a\u0019\u0010f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010>\u001a\u00020=¢\u0006\u0004\bf\u0010B\u001a\u001c\u0010g\u001a\u00020\u0007*\u00020\u00072\u0006\u0010>\u001a\u00020=H\b¢\u0006\u0004\bg\u0010@\u001a\u0019\u0010i\u001a\u00020\u0000*\u00020\u00002\u0006\u0010h\u001a\u00020\u0000¢\u0006\u0004\bi\u0010j\u001a\u0019\u0010k\u001a\u00020\u0007*\u00020\u00072\u0006\u0010h\u001a\u00020\u0000¢\u0006\u0004\bk\u0010l\u001a\u0019\u0010n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010m\u001a\u00020\u0000¢\u0006\u0004\bn\u0010j\u001a\u0019\u0010o\u001a\u00020\u0007*\u00020\u00072\u0006\u0010m\u001a\u00020\u0000¢\u0006\u0004\bo\u0010l\u001a!\u0010p\u001a\u00020\u0000*\u00020\u00002\u0006\u0010h\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u0000¢\u0006\u0004\bp\u0010q\u001a!\u0010r\u001a\u00020\u0007*\u00020\u00072\u0006\u0010h\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u0000¢\u0006\u0004\br\u0010s\u001a\u0019\u0010t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010M\u001a\u00020\u0000¢\u0006\u0004\bt\u0010j\u001a\u0019\u0010u\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u0000¢\u0006\u0004\bu\u0010l\u001a+\u0010v\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u00022\u0006\u0010Y\u001a\u00020\u00072\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\bv\u0010w\u001a+\u0010x\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u00072\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\bx\u0010y\u001a+\u0010z\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u00022\u0006\u0010Y\u001a\u00020\u00072\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\bz\u0010w\u001a+\u0010{\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u00072\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\b{\u0010y\u001a+\u0010|\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u00072\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\b|\u0010y\u001a+\u0010}\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u00022\u0006\u0010Y\u001a\u00020\u00072\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\b}\u0010w\u001a+\u0010~\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u00022\u0006\u0010Y\u001a\u00020\u00072\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\b~\u0010w\u001a+\u0010\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u00072\b\b\u0002\u0010N\u001a\u00020\u0007¢\u0006\u0004\b\u0010y\u001a)\u0010\u0001\u001a\u00020\u0007*\u00020\u00002\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010Y\u001a\u00020\u0007H\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a<\u0010\u0001\u001a\u00020\u0007*\u00020\u00002\b\u0010\u0001\u001a\u00030\u00012\u0016\b\b\u0010\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020\u00000\u0001H\bø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001\u001a)\u0010\u0001\u001a\u00020\u0007*\u00020\u00002\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010Y\u001a\u00020\u0007H\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a.\u0010\u0001\u001a\u00020\u0007*\u00020\u00072\u0013\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\bø\u0001\u0000¢\u0006\u0005\b\u0001\u0010\t\u001a.\u0010\u0001\u001a\u00020\u0007*\u00020\u00072\u0013\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001H\bø\u0001\u0000¢\u0006\u0005\b\u0001\u0010\t\u001a!\u0010\u0001\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001H\f¢\u0006\u0006\b\u0001\u0010\u0001\u001aB\u0010\u0001\u001a\u00020\u0003*\u00020\u00002\u0007\u0010\u0001\u001a\u00020 2\u0007\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0007\u0010\u0001\u001a\u00020\u0003H\u0000¢\u0006\u0006\b\u0001\u0010\u0001\u001a(\u0010\u0001\u001a\u00020\u0003*\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u00022\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b\u0001\u0010\u0001\u001a(\u0010\u0001\u001a\u00020\u0003*\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u00022\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b\u0001\u0010\u0001\u001a'\u0010\u0001\u001a\u00020\u0003*\u00020\u00002\u0006\u0010h\u001a\u00020\u00002\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b\u0001\u0010\u0001\u001a/\u0010\u0001\u001a\u00020\u0003*\u00020\u00002\u0006\u0010h\u001a\u00020\u00002\u0006\u0010G\u001a\u00020 2\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b\u0001\u0010\u0001\u001a'\u0010\u0001\u001a\u00020\u0003*\u00020\u00002\u0006\u0010m\u001a\u00020\u00002\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b\u0001\u0010\u0001\u001a(\u0010\u0001\u001a\u00020\u0007*\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u00002\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b\u0001\u0010\u0001\u001a(\u0010\u0001\u001a\u00020\u0007*\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u00002\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b\u0001\u0010\u0001\u001a1\u0010\u0001\u001a\u00020 *\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010G\u001a\u00020 2\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b\u0001\u0010 \u0001\u001a1\u0010¡\u0001\u001a\u00020 *\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010G\u001a\u00020 2\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b¡\u0001\u0010 \u0001\u001aC\u0010£\u0001\u001a\u00020 *\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u00002\u0006\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020 2\u0007\u0010\u0001\u001a\u00020\u00032\t\b\u0002\u0010¢\u0001\u001a\u00020\u0003H\u0002¢\u0006\u0006\b£\u0001\u0010¤\u0001\u001aO\u0010¨\u0001\u001a\u0011\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0007\u0018\u00010§\u0001*\u00020\u00002\u000e\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¥\u00012\u0006\u0010G\u001a\u00020 2\u0007\u0010\u0001\u001a\u00020\u00032\u0007\u0010¢\u0001\u001a\u00020\u0003H\u0002¢\u0006\u0006\b¨\u0001\u0010©\u0001\u001aH\u0010ª\u0001\u001a\u0011\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0007\u0018\u00010§\u0001*\u00020\u00002\u000e\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¥\u00012\b\b\u0002\u0010G\u001a\u00020 2\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\bª\u0001\u0010«\u0001\u001aH\u0010¬\u0001\u001a\u0011\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0007\u0018\u00010§\u0001*\u00020\u00002\u000e\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¥\u00012\b\b\u0002\u0010G\u001a\u00020 2\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b¬\u0001\u0010«\u0001\u001a9\u0010­\u0001\u001a\u00020 *\u00020\u00002\u000e\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¥\u00012\b\b\u0002\u0010G\u001a\u00020 2\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b­\u0001\u0010®\u0001\u001a9\u0010¯\u0001\u001a\u00020 *\u00020\u00002\u000e\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¥\u00012\b\b\u0002\u0010G\u001a\u00020 2\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b¯\u0001\u0010®\u0001\u001a2\u0010°\u0001\u001a\u00020 *\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u00022\b\b\u0002\u0010G\u001a\u00020 2\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b°\u0001\u0010±\u0001\u001a2\u0010³\u0001\u001a\u00020 *\u00020\u00002\u0007\u0010²\u0001\u001a\u00020\u00072\b\b\u0002\u0010G\u001a\u00020 2\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b³\u0001\u0010´\u0001\u001a2\u0010µ\u0001\u001a\u00020 *\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u00022\b\b\u0002\u0010G\u001a\u00020 2\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\bµ\u0001\u0010±\u0001\u001a2\u0010¶\u0001\u001a\u00020 *\u00020\u00002\u0007\u0010²\u0001\u001a\u00020\u00072\b\b\u0002\u0010G\u001a\u00020 2\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b¶\u0001\u0010´\u0001\u001a+\u0010·\u0001\u001a\u00020\u0003*\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u00002\t\b\u0002\u0010\u0001\u001a\u00020\u0003H\u0002¢\u0006\u0006\b·\u0001\u0010\u0001\u001a+\u0010¸\u0001\u001a\u00020\u0003*\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u00022\t\b\u0002\u0010\u0001\u001a\u00020\u0003H\u0002¢\u0006\u0006\b¸\u0001\u0010\u0001\u001a!\u0010¹\u0001\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001H\n¢\u0006\u0006\b¹\u0001\u0010\u0001\u001aF\u0010½\u0001\u001a\t\u0012\u0004\u0012\u00020=0¼\u0001*\u00020\u00002\u0007\u0010º\u0001\u001a\u00020\u000e2\b\b\u0002\u0010G\u001a\u00020 2\t\b\u0002\u0010\u0001\u001a\u00020\u00032\t\b\u0002\u0010»\u0001\u001a\u00020 H\u0002¢\u0006\u0006\b½\u0001\u0010¾\u0001\u001aO\u0010À\u0001\u001a\t\u0012\u0004\u0012\u00020=0¼\u0001*\u00020\u00002\u0010\u0010º\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00070¿\u00012\b\b\u0002\u0010G\u001a\u00020 2\t\b\u0002\u0010\u0001\u001a\u00020\u00032\t\b\u0002\u0010»\u0001\u001a\u00020 H\u0002¢\u0006\u0006\bÀ\u0001\u0010Á\u0001\u001a\u001c\u0010Ã\u0001\u001a\u00030Â\u00012\u0007\u0010»\u0001\u001a\u00020 H\u0000¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001\u001aG\u0010Å\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¼\u0001*\u00020\u00002\u0014\u0010º\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00070¿\u0001\"\u00020\u00072\t\b\u0002\u0010\u0001\u001a\u00020\u00032\t\b\u0002\u0010»\u0001\u001a\u00020 ¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001\u001aG\u0010È\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070Ç\u0001*\u00020\u00002\u0014\u0010º\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00070¿\u0001\"\u00020\u00072\t\b\u0002\u0010\u0001\u001a\u00020\u00032\t\b\u0002\u0010»\u0001\u001a\u00020 ¢\u0006\u0006\bÈ\u0001\u0010É\u0001\u001a>\u0010Ê\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¼\u0001*\u00020\u00002\u000b\u0010º\u0001\u001a\u00020\u000e\"\u00020\u00022\t\b\u0002\u0010\u0001\u001a\u00020\u00032\t\b\u0002\u0010»\u0001\u001a\u00020 ¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001\u001a>\u0010Ì\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070Ç\u0001*\u00020\u00002\u000b\u0010º\u0001\u001a\u00020\u000e\"\u00020\u00022\t\b\u0002\u0010\u0001\u001a\u00020\u00032\t\b\u0002\u0010»\u0001\u001a\u00020 ¢\u0006\u0006\bÌ\u0001\u0010Í\u0001\u001a7\u0010Î\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070Ç\u0001*\u00020\u00002\u0006\u0010M\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00032\u0007\u0010»\u0001\u001a\u00020 H\u0002¢\u0006\u0006\bÎ\u0001\u0010Ï\u0001\u001a3\u0010Ð\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070Ç\u0001*\u00020\u00002\b\u0010\u0001\u001a\u00030\u00012\t\b\u0002\u0010»\u0001\u001a\u00020 H\b¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001\u001a3\u0010Ò\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¼\u0001*\u00020\u00002\b\u0010\u0001\u001a\u00030\u00012\t\b\u0002\u0010»\u0001\u001a\u00020 H\b¢\u0006\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u001b\u0010Ô\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¼\u0001*\u00020\u0000¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001\u001a\u001b\u0010Ö\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070Ç\u0001*\u00020\u0000¢\u0006\u0006\bÖ\u0001\u0010×\u0001\u001a#\u0010Ø\u0001\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\t\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0006\bØ\u0001\u0010Ù\u0001\u001a#\u0010Ú\u0001\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\t\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0006\bÚ\u0001\u0010Ù\u0001\u001a\u0016\u0010Û\u0001\u001a\u00020\u0003*\u00020\u0007H\u0007¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001\u001a\u0018\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0003*\u00020\u0007H\u0007¢\u0006\u0006\bÝ\u0001\u0010Þ\u0001\"\u0018\u0010á\u0001\u001a\u00020=*\u00020\u00008F¢\u0006\b\u001a\u0006\bß\u0001\u0010à\u0001\"\u0018\u0010ä\u0001\u001a\u00020 *\u00020\u00008F¢\u0006\b\u001a\u0006\bâ\u0001\u0010ã\u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006å\u0001"}, d2 = {"", "Lkotlin/Function1;", "", "", "predicate", "D5", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/CharSequence;", "", "G5", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "P5", "S5", "J5", "M5", "", "chars", "E5", "(Ljava/lang/CharSequence;[C)Ljava/lang/CharSequence;", "H5", "(Ljava/lang/String;[C)Ljava/lang/String;", "Q5", "T5", "K5", "N5", "C5", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "F5", "(Ljava/lang/String;)Ljava/lang/String;", "O5", "R5", "I5", "L5", "", "length", "padChar", "Q3", "(Ljava/lang/CharSequence;IC)Ljava/lang/CharSequence;", "R3", "(Ljava/lang/String;IC)Ljava/lang/String;", "M3", "N3", "y3", "(Ljava/lang/CharSequence;)Z", "u3", "w3", "v3", "x3", "Lkotlin/collections/CharIterator;", "z3", "(Ljava/lang/CharSequence;)Lkotlin/collections/CharIterator;", "L3", "C", "R", "Lkotlin/Function0;", "defaultValue", "j3", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "i3", "index", "h3", "(Ljava/lang/CharSequence;I)Z", "Lkotlin/ranges/IntRange;", "range", "i5", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)Ljava/lang/String;", "e5", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)Ljava/lang/CharSequence;", "start", "end", "f5", "(Ljava/lang/String;II)Ljava/lang/CharSequence;", "startIndex", "endIndex", "g5", "(Ljava/lang/CharSequence;II)Ljava/lang/String;", "h5", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)Ljava/lang/String;", "delimiter", "missingDelimiterValue", "s5", "(Ljava/lang/String;CLjava/lang/String;)Ljava/lang/String;", "t5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "k5", "l5", "w5", "x5", "o5", "p5", "replacement", "G4", "(Ljava/lang/CharSequence;IILjava/lang/CharSequence;)Ljava/lang/CharSequence;", "I4", "(Ljava/lang/String;IILjava/lang/CharSequence;)Ljava/lang/String;", "H4", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "J4", "(Ljava/lang/String;Lkotlin/ranges/IntRange;Ljava/lang/CharSequence;)Ljava/lang/String;", "b4", "(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;", "d4", "(Ljava/lang/String;II)Ljava/lang/String;", "c4", "e4", "prefix", "Z3", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "a4", "(Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;", "suffix", "f4", "g4", "i4", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "k4", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "h4", "j4", "v4", "(Ljava/lang/String;CLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "w4", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "n4", "o4", "s4", "r4", "z4", "A4", "Lkotlin/text/Regex;", "regex", "l4", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/text/MatchResult;", "transform", "m4", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "D4", "E4", "F4", "K3", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;)Z", "thisOffset", "other", "otherOffset", "ignoreCase", "Y3", "(Ljava/lang/CharSequence;ILjava/lang/CharSequence;IIZ)Z", "char", "Y4", "(Ljava/lang/CharSequence;CZ)Z", "W2", "a5", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Z", "Z4", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IZ)Z", "X2", "L2", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Ljava/lang/String;", "N2", "r3", "(Ljava/lang/CharSequence;[CIZ)I", "F3", "last", "m3", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZZ)I", "", "strings", "Lkotlin/Pair;", "b3", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZZ)Lkotlin/Pair;", "a3", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZ)Lkotlin/Pair;", "d3", "q3", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZ)I", "E3", "k3", "(Ljava/lang/CharSequence;CIZ)I", "string", "l3", "(Ljava/lang/CharSequence;Ljava/lang/String;IZ)I", "A3", "B3", "Q2", "P2", "R2", "delimiters", "limit", "Lkotlin/sequences/Sequence;", "U3", "(Ljava/lang/CharSequence;[CIZI)Lkotlin/sequences/Sequence;", "", "V3", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "", "K4", "(I)V", "U4", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "", "N4", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "T4", "(Ljava/lang/CharSequence;[CZI)Lkotlin/sequences/Sequence;", "M4", "(Ljava/lang/CharSequence;[CZI)Ljava/util/List;", "O4", "(Ljava/lang/CharSequence;Ljava/lang/String;ZI)Ljava/util/List;", "L4", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;I)Ljava/util/List;", "S4", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;I)Lkotlin/sequences/Sequence;", "I3", "(Ljava/lang/CharSequence;)Lkotlin/sequences/Sequence;", "J3", "(Ljava/lang/CharSequence;)Ljava/util/List;", "U2", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z", "V2", "A5", "(Ljava/lang/String;)Z", "B5", "(Ljava/lang/String;)Ljava/lang/Boolean;", "f3", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "indices", "g3", "(Ljava/lang/CharSequence;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/text/StringsKt")
@SourceDebugExtension({"SMAP\nStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1486:1\n79#1,22:1487\n113#1,5:1509\n130#1,5:1514\n79#1,22:1519\n107#1:1541\n79#1,22:1542\n113#1,5:1564\n124#1:1569\n113#1,5:1570\n130#1,5:1575\n141#1:1580\n130#1,5:1581\n79#1,22:1586\n113#1,5:1608\n130#1,5:1613\n12554#2,2:1618\n12554#2,2:1620\n288#3,2:1622\n288#3,2:1624\n1549#3:1627\n1620#3,3:1628\n1549#3:1631\n1620#3,3:1632\n1#4:1626\n*S KotlinDebug\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n107#1:1487,22\n124#1:1509,5\n141#1:1514,5\n146#1:1519,22\n151#1:1541\n151#1:1542,22\n156#1:1564,5\n161#1:1569\n161#1:1570,5\n166#1:1575,5\n171#1:1580\n171#1:1581,5\n176#1:1586,22\n187#1:1608,5\n198#1:1613,5\n940#1:1618,2\n964#1:1620,2\n1003#1:1622,2\n1009#1:1624,2\n1309#1:1627\n1309#1:1628,3\n1334#1:1631\n1334#1:1632,3\n*E\n"})
class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static final int A3(@NotNull CharSequence charSequence, char c2, int i2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c2, i2);
        }
        return F3(charSequence, new char[]{c2}, i2, z);
    }

    @NotNull
    public static final String A4(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, TtmlNode.b0);
        Intrinsics.p(str3, "replacement");
        Intrinsics.p(str4, "missingDelimiterValue");
        int D3 = StringsKt.D3(str, str2, 0, false, 6, (Object) null);
        return D3 == -1 ? str4 : G4(str, 0, D3, str3).toString();
    }

    @SinceKotlin(version = "1.5")
    public static final boolean A5(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        if (Intrinsics.g(str, PdfBoolean.l3)) {
            return true;
        }
        if (Intrinsics.g(str, "false")) {
            return false;
        }
        throw new IllegalArgumentException("The string doesn't represent a boolean value: " + str);
    }

    public static final int B3(@NotNull CharSequence charSequence, @NotNull String str, int i2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(str, TypedValues.Custom.f3952e);
        return (z || !(charSequence instanceof String)) ? m3(charSequence, str, i2, 0, z, true) : ((String) charSequence).lastIndexOf(str, i2);
    }

    public static /* synthetic */ String B4(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return z4(str, c2, str2, str3);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static final Boolean B5(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        if (Intrinsics.g(str, PdfBoolean.l3)) {
            return Boolean.TRUE;
        }
        if (Intrinsics.g(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static /* synthetic */ int C3(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = StringsKt.g3(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return A3(charSequence, c2, i2, z);
    }

    public static /* synthetic */ String C4(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return A4(str, str2, str3, str4);
    }

    @NotNull
    public static CharSequence C5(@NotNull CharSequence charSequence) {
        Intrinsics.p(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean r = CharsKt__CharJVMKt.r(charSequence.charAt(!z ? i2 : length));
            if (!z) {
                if (!r) {
                    z = true;
                } else {
                    i2++;
                }
            } else if (!r) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static /* synthetic */ int D3(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = StringsKt.g3(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return B3(charSequence, str, i2, z);
    }

    @InlineOnly
    private static final String D4(CharSequence charSequence, Regex regex, String str) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(regex, "regex");
        Intrinsics.p(str, "replacement");
        return regex.o(charSequence, str);
    }

    @NotNull
    public static final CharSequence D5(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(function1, "predicate");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean booleanValue = function1.f(Character.valueOf(charSequence.charAt(!z ? i2 : length))).booleanValue();
            if (!z) {
                if (!booleanValue) {
                    z = true;
                } else {
                    i2++;
                }
            } else if (!booleanValue) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static final int E3(@NotNull CharSequence charSequence, @NotNull Collection<String> collection, int i2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(collection, "strings");
        Pair<Integer, String> b3 = b3(charSequence, collection, i2, z, true);
        if (b3 != null) {
            return b3.e().intValue();
        }
        return -1;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "replaceFirstCharWithChar")
    private static final String E4(String str, Function1<? super Character, Character> function1) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(function1, "transform");
        if (str.length() <= 0) {
            return str;
        }
        char charValue = function1.f(Character.valueOf(str.charAt(0))).charValue();
        String substring = str.substring(1);
        Intrinsics.o(substring, "this as java.lang.String).substring(startIndex)");
        return charValue + substring;
    }

    @NotNull
    public static final CharSequence E5(@NotNull CharSequence charSequence, @NotNull char... cArr) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(cArr, "chars");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean n8 = ArraysKt.n8(cArr, charSequence.charAt(!z ? i2 : length));
            if (!z) {
                if (!n8) {
                    z = true;
                } else {
                    i2++;
                }
            } else if (!n8) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static final int F3(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int B = RangesKt.B(i2, StringsKt.g3(charSequence)); -1 < B; B--) {
                char charAt = charSequence.charAt(B);
                for (char J : cArr) {
                    if (CharsKt__CharKt.J(J, charAt, z)) {
                        return B;
                    }
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(ArraysKt.Ws(cArr), i2);
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "replaceFirstCharWithCharSequence")
    private static final String F4(String str, Function1<? super Character, ? extends CharSequence> function1) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(function1, "transform");
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(function1.f(Character.valueOf(str.charAt(0))));
        String substring = str.substring(1);
        Intrinsics.o(substring, "this as java.lang.String).substring(startIndex)");
        sb.append(substring);
        return sb.toString();
    }

    @InlineOnly
    private static final String F5(String str) {
        Intrinsics.p(str, "<this>");
        return StringsKt.C5(str).toString();
    }

    public static /* synthetic */ int G3(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = StringsKt.g3(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return E3(charSequence, collection, i2, z);
    }

    @NotNull
    public static final CharSequence G4(@NotNull CharSequence charSequence, int i2, int i3, @NotNull CharSequence charSequence2) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(charSequence2, "replacement");
        if (i3 >= i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i2);
            Intrinsics.o(sb, "this.append(value, startIndex, endIndex)");
            sb.append(charSequence2);
            sb.append(charSequence, i3, charSequence.length());
            Intrinsics.o(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i3 + ") is less than start index (" + i2 + ").");
    }

    @NotNull
    public static final String G5(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(function1, "predicate");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean booleanValue = function1.f(Character.valueOf(str.charAt(!z ? i2 : length))).booleanValue();
            if (!z) {
                if (!booleanValue) {
                    z = true;
                } else {
                    i2++;
                }
            } else if (!booleanValue) {
                break;
            } else {
                length--;
            }
        }
        return str.subSequence(i2, length + 1).toString();
    }

    public static /* synthetic */ int H3(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = StringsKt.g3(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return F3(charSequence, cArr, i2, z);
    }

    @NotNull
    public static final CharSequence H4(@NotNull CharSequence charSequence, @NotNull IntRange intRange, @NotNull CharSequence charSequence2) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(intRange, "range");
        Intrinsics.p(charSequence2, "replacement");
        return G4(charSequence, intRange.c().intValue(), intRange.h().intValue() + 1, charSequence2);
    }

    @NotNull
    public static final String H5(@NotNull String str, @NotNull char... cArr) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(cArr, "chars");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean n8 = ArraysKt.n8(cArr, str.charAt(!z ? i2 : length));
            if (!z) {
                if (!n8) {
                    z = true;
                } else {
                    i2++;
                }
            } else if (!n8) {
                break;
            } else {
                length--;
            }
        }
        return str.subSequence(i2, length + 1).toString();
    }

    @NotNull
    public static final Sequence<String> I3(@NotNull CharSequence charSequence) {
        Intrinsics.p(charSequence, "<this>");
        return X4(charSequence, new String[]{"\r\n", StringUtils.LF, StringUtils.CR}, false, 0, 6, (Object) null);
    }

    @InlineOnly
    private static final String I4(String str, int i2, int i3, CharSequence charSequence) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(charSequence, "replacement");
        return G4(str, i2, i3, charSequence).toString();
    }

    @NotNull
    public static final CharSequence I5(@NotNull CharSequence charSequence) {
        Intrinsics.p(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (!CharsKt__CharJVMKt.r(charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return "";
    }

    @NotNull
    public static final List<String> J3(@NotNull CharSequence charSequence) {
        Intrinsics.p(charSequence, "<this>");
        return SequencesKt.c3(I3(charSequence));
    }

    @InlineOnly
    private static final String J4(String str, IntRange intRange, CharSequence charSequence) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(intRange, "range");
        Intrinsics.p(charSequence, "replacement");
        return H4(str, intRange, charSequence).toString();
    }

    @NotNull
    public static final CharSequence J5(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(function1, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i2 = length - 1;
            if (!function1.f(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                return charSequence.subSequence(0, length + 1);
            }
            if (i2 < 0) {
                return "";
            }
            length = i2;
        }
    }

    @InlineOnly
    private static final boolean K3(CharSequence charSequence, Regex regex) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(regex, "regex");
        return regex.k(charSequence);
    }

    public static final void K4(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2).toString());
        }
    }

    @NotNull
    public static final CharSequence K5(@NotNull CharSequence charSequence, @NotNull char... cArr) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(cArr, "chars");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (!ArraysKt.n8(cArr, charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return "";
    }

    @NotNull
    public static final String L2(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(charSequence2, "other");
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i2 = 0;
        while (i2 < min && CharsKt__CharKt.J(charSequence.charAt(i2), charSequence2.charAt(i2), z)) {
            i2++;
        }
        int i3 = i2 - 1;
        if (h3(charSequence, i3) || h3(charSequence2, i3)) {
            i2--;
        }
        return charSequence.subSequence(0, i2).toString();
    }

    @InlineOnly
    private static final String L3(String str) {
        return str == null ? "" : str;
    }

    @InlineOnly
    private static final List<String> L4(CharSequence charSequence, Regex regex, int i2) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(regex, "regex");
        return regex.p(charSequence, i2);
    }

    @InlineOnly
    private static final String L5(String str) {
        Intrinsics.p(str, "<this>");
        return I5(str).toString();
    }

    public static /* synthetic */ String M2(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return L2(charSequence, charSequence2, z);
    }

    @NotNull
    public static final CharSequence M3(@NotNull CharSequence charSequence, int i2, char c2) {
        Intrinsics.p(charSequence, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
        } else if (i2 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i2);
            sb.append(charSequence);
            IntIterator n2 = new IntRange(1, i2 - charSequence.length()).iterator();
            while (n2.hasNext()) {
                n2.b();
                sb.append(c2);
            }
            return sb;
        }
    }

    @NotNull
    public static final List<String> M4(@NotNull CharSequence charSequence, @NotNull char[] cArr, boolean z, int i2) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(cArr, "delimiters");
        if (cArr.length == 1) {
            return O4(charSequence, String.valueOf(cArr[0]), z, i2);
        }
        Iterable<IntRange> N = SequencesKt.N(W3(charSequence, cArr, 0, z, i2, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.Y(N, 10));
        for (IntRange h5 : N) {
            arrayList.add(h5(charSequence, h5));
        }
        return arrayList;
    }

    @NotNull
    public static final String M5(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Object obj;
        Intrinsics.p(str, "<this>");
        Intrinsics.p(function1, "predicate");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (!function1.f(Character.valueOf(str.charAt(length))).booleanValue()) {
                    obj = str.subSequence(0, length + 1);
                    break;
                } else if (i2 < 0) {
                    break;
                } else {
                    length = i2;
                }
            }
            return obj.toString();
        }
        obj = "";
        return obj.toString();
    }

    @NotNull
    public static final String N2(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(charSequence2, "other");
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int min = Math.min(length, length2);
        int i2 = 0;
        while (i2 < min && CharsKt__CharKt.J(charSequence.charAt((length - i2) - 1), charSequence2.charAt((length2 - i2) - 1), z)) {
            i2++;
        }
        if (h3(charSequence, (length - i2) - 1) || h3(charSequence2, (length2 - i2) - 1)) {
            i2--;
        }
        return charSequence.subSequence(length - i2, length).toString();
    }

    @NotNull
    public static final String N3(@NotNull String str, int i2, char c2) {
        Intrinsics.p(str, "<this>");
        return M3(str, i2, c2).toString();
    }

    @NotNull
    public static final List<String> N4(@NotNull CharSequence charSequence, @NotNull String[] strArr, boolean z, int i2) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return O4(charSequence, str, z, i2);
            }
        }
        Iterable<IntRange> N = SequencesKt.N(X3(charSequence, strArr, 0, z, i2, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.Y(N, 10));
        for (IntRange h5 : N) {
            arrayList.add(h5(charSequence, h5));
        }
        return arrayList;
    }

    @NotNull
    public static final String N5(@NotNull String str, @NotNull char... cArr) {
        Object obj;
        Intrinsics.p(str, "<this>");
        Intrinsics.p(cArr, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (!ArraysKt.n8(cArr, str.charAt(length))) {
                    obj = str.subSequence(0, length + 1);
                    break;
                } else if (i2 < 0) {
                    break;
                } else {
                    length = i2;
                }
            }
            return obj.toString();
        }
        obj = "";
        return obj.toString();
    }

    public static /* synthetic */ String O2(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return N2(charSequence, charSequence2, z);
    }

    public static /* synthetic */ CharSequence O3(CharSequence charSequence, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return M3(charSequence, i2, c2);
    }

    private static final List<String> O4(CharSequence charSequence, String str, boolean z, int i2) {
        K4(i2);
        int i3 = 0;
        int l3 = l3(charSequence, str, 0, z);
        if (l3 == -1 || i2 == 1) {
            return CollectionsKt.k(charSequence.toString());
        }
        boolean z2 = i2 > 0;
        int i4 = 10;
        if (z2) {
            i4 = RangesKt.B(i2, 10);
        }
        ArrayList arrayList = new ArrayList(i4);
        do {
            arrayList.add(charSequence.subSequence(i3, l3).toString());
            i3 = str.length() + l3;
            if ((z2 && arrayList.size() == i2 - 1) || (l3 = l3(charSequence, str, i3, z)) == -1) {
                arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
            }
            arrayList.add(charSequence.subSequence(i3, l3).toString());
            i3 = str.length() + l3;
            break;
        } while ((l3 = l3(charSequence, str, i3, z)) == -1);
        arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
        return arrayList;
    }

    @NotNull
    public static final CharSequence O5(@NotNull CharSequence charSequence) {
        Intrinsics.p(charSequence, "<this>");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!CharsKt__CharJVMKt.r(charSequence.charAt(i2))) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }

    public static final boolean P2(@NotNull CharSequence charSequence, char c2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        return StringsKt.o3(charSequence, c2, 0, z, 2, (Object) null) >= 0;
    }

    public static /* synthetic */ String P3(String str, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return N3(str, i2, c2);
    }

    static /* synthetic */ List P4(CharSequence charSequence, Regex regex, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(regex, "regex");
        return regex.p(charSequence, i2);
    }

    @NotNull
    public static final CharSequence P5(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(function1, "predicate");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!function1.f(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x001e A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean Q2(@org.jetbrains.annotations.NotNull java.lang.CharSequence r11, @org.jetbrains.annotations.NotNull java.lang.CharSequence r12, boolean r13) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r11, r0)
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.p(r12, r0)
            boolean r0 = r12 instanceof java.lang.String
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0020
            r4 = r12
            java.lang.String r4 = (java.lang.String) r4
            r7 = 2
            r8 = 0
            r5 = 0
            r3 = r11
            r6 = r13
            int r11 = p3(r3, r4, r5, r6, r7, r8)
            if (r11 < 0) goto L_0x0033
        L_0x001e:
            r1 = 1
            goto L_0x0033
        L_0x0020:
            int r6 = r11.length()
            r9 = 16
            r10 = 0
            r5 = 0
            r8 = 0
            r3 = r11
            r4 = r12
            r7 = r13
            int r11 = n3(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r11 < 0) goto L_0x0033
            goto L_0x001e
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsKt.Q2(java.lang.CharSequence, java.lang.CharSequence, boolean):boolean");
    }

    @NotNull
    public static final CharSequence Q3(@NotNull CharSequence charSequence, int i2, char c2) {
        Intrinsics.p(charSequence, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
        } else if (i2 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i2);
            IntIterator n2 = new IntRange(1, i2 - charSequence.length()).iterator();
            while (n2.hasNext()) {
                n2.b();
                sb.append(c2);
            }
            sb.append(charSequence);
            return sb;
        }
    }

    public static /* synthetic */ List Q4(CharSequence charSequence, char[] cArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return M4(charSequence, cArr, z, i2);
    }

    @NotNull
    public static final CharSequence Q5(@NotNull CharSequence charSequence, @NotNull char... cArr) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(cArr, "chars");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!ArraysKt.n8(cArr, charSequence.charAt(i2))) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }

    @InlineOnly
    private static final boolean R2(CharSequence charSequence, Regex regex) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(regex, "regex");
        return regex.b(charSequence);
    }

    @NotNull
    public static String R3(@NotNull String str, int i2, char c2) {
        Intrinsics.p(str, "<this>");
        return Q3(str, i2, c2).toString();
    }

    public static /* synthetic */ List R4(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return N4(charSequence, strArr, z, i2);
    }

    @InlineOnly
    private static final String R5(String str) {
        Intrinsics.p(str, "<this>");
        return O5(str).toString();
    }

    public static /* synthetic */ boolean S2(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return P2(charSequence, c2, z);
    }

    public static /* synthetic */ CharSequence S3(CharSequence charSequence, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return Q3(charSequence, i2, c2);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final Sequence<String> S4(CharSequence charSequence, Regex regex, int i2) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(regex, "regex");
        return regex.r(charSequence, i2);
    }

    @NotNull
    public static final String S5(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Object obj;
        Intrinsics.p(str, "<this>");
        Intrinsics.p(function1, "predicate");
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                obj = "";
                break;
            } else if (!function1.f(Character.valueOf(str.charAt(i2))).booleanValue()) {
                obj = str.subSequence(i2, str.length());
                break;
            } else {
                i2++;
            }
        }
        return obj.toString();
    }

    public static /* synthetic */ boolean T2(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return Q2(charSequence, charSequence2, z);
    }

    public static /* synthetic */ String T3(String str, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return StringsKt.R3(str, i2, c2);
    }

    @NotNull
    public static final Sequence<String> T4(@NotNull CharSequence charSequence, @NotNull char[] cArr, boolean z, int i2) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(cArr, "delimiters");
        return SequencesKt.k1(W3(charSequence, cArr, 0, z, i2, 2, (Object) null), new StringsKt__StringsKt$splitToSequence$2(charSequence));
    }

    @NotNull
    public static final String T5(@NotNull String str, @NotNull char... cArr) {
        Object obj;
        Intrinsics.p(str, "<this>");
        Intrinsics.p(cArr, "chars");
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                obj = "";
                break;
            } else if (!ArraysKt.n8(cArr, str.charAt(i2))) {
                obj = str.subSequence(i2, str.length());
                break;
            } else {
                i2++;
            }
        }
        return obj.toString();
    }

    public static final boolean U2(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt.K1((String) charSequence, (String) charSequence2, true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!CharsKt__CharKt.J(charSequence.charAt(i2), charSequence2.charAt(i2), true)) {
                return false;
            }
        }
        return true;
    }

    private static final Sequence<IntRange> U3(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3) {
        K4(i3);
        return new DelimitedRangesSequence(charSequence, i2, i3, new StringsKt__StringsKt$rangesDelimitedBy$1(cArr, z));
    }

    @NotNull
    public static final Sequence<String> U4(@NotNull CharSequence charSequence, @NotNull String[] strArr, boolean z, int i2) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(strArr, "delimiters");
        return SequencesKt.k1(X3(charSequence, strArr, 0, z, i2, 2, (Object) null), new StringsKt__StringsKt$splitToSequence$1(charSequence));
    }

    public static final boolean V2(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return Intrinsics.g(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    private static final Sequence<IntRange> V3(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3) {
        K4(i3);
        return new DelimitedRangesSequence(charSequence, i2, i3, new StringsKt__StringsKt$rangesDelimitedBy$2(ArraysKt.t(strArr), z));
    }

    static /* synthetic */ Sequence V4(CharSequence charSequence, Regex regex, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(regex, "regex");
        return regex.r(charSequence, i2);
    }

    public static final boolean W2(@NotNull CharSequence charSequence, char c2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        return charSequence.length() > 0 && CharsKt__CharKt.J(charSequence.charAt(StringsKt.g3(charSequence)), c2, z);
    }

    static /* synthetic */ Sequence W3(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return U3(charSequence, cArr, i2, z, i3);
    }

    public static /* synthetic */ Sequence W4(CharSequence charSequence, char[] cArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return T4(charSequence, cArr, z, i2);
    }

    public static final boolean X2(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(charSequence2, "suffix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt.J1((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return Y3(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    static /* synthetic */ Sequence X3(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return V3(charSequence, strArr, i2, z, i3);
    }

    public static /* synthetic */ Sequence X4(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return U4(charSequence, strArr, z, i2);
    }

    public static /* synthetic */ boolean Y2(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return W2(charSequence, c2, z);
    }

    public static final boolean Y3(@NotNull CharSequence charSequence, int i2, @NotNull CharSequence charSequence2, int i3, int i4, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(charSequence2, "other");
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!CharsKt__CharKt.J(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean Y4(@NotNull CharSequence charSequence, char c2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        return charSequence.length() > 0 && CharsKt__CharKt.J(charSequence.charAt(0), c2, z);
    }

    public static /* synthetic */ boolean Z2(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return X2(charSequence, charSequence2, z);
    }

    @NotNull
    public static final CharSequence Z3(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(charSequence2, "prefix");
        return d5(charSequence, charSequence2, false, 2, (Object) null) ? charSequence.subSequence(charSequence2.length(), charSequence.length()) : charSequence.subSequence(0, charSequence.length());
    }

    public static final boolean Z4(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(charSequence2, "prefix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.r2((String) charSequence, (String) charSequence2, i2, false, 4, (Object) null);
        }
        return Y3(charSequence, i2, charSequence2, 0, charSequence2.length(), z);
    }

    @Nullable
    public static final Pair<Integer, String> a3(@NotNull CharSequence charSequence, @NotNull Collection<String> collection, int i2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(collection, "strings");
        return b3(charSequence, collection, i2, z, false);
    }

    @NotNull
    public static String a4(@NotNull String str, @NotNull CharSequence charSequence) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(charSequence, "prefix");
        if (!d5(str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        Intrinsics.o(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static final boolean a5(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(charSequence2, "prefix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt.s2((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return Y3(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    /* access modifiers changed from: private */
    public static final Pair<Integer, String> b3(CharSequence charSequence, Collection<String> collection, int i2, boolean z, boolean z2) {
        int i3;
        T t;
        String str;
        T t2;
        if (z || collection.size() != 1) {
            IntProgression intRange = !z2 ? new IntRange(RangesKt.u(i2, 0), charSequence.length()) : RangesKt.k0(RangesKt.B(i2, StringsKt.g3(charSequence)), 0);
            if (charSequence instanceof String) {
                i3 = intRange.j();
                int k2 = intRange.k();
                int m2 = intRange.m();
                if ((m2 > 0 && i3 <= k2) || (m2 < 0 && k2 <= i3)) {
                    while (true) {
                        Iterator<T> it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                t2 = null;
                                break;
                            }
                            t2 = it2.next();
                            String str2 = (String) t2;
                            if (StringsKt.b2(str2, 0, (String) charSequence, i3, str2.length(), z)) {
                                break;
                            }
                        }
                        str = (String) t2;
                        if (str == null) {
                            if (i3 == k2) {
                                break;
                            }
                            i3 += m2;
                        } else {
                            break;
                        }
                    }
                }
                return null;
            }
            int j2 = intRange.j();
            int k3 = intRange.k();
            int m3 = intRange.m();
            if ((m3 > 0 && j2 <= k3) || (m3 < 0 && k3 <= j2)) {
                while (true) {
                    Iterator<T> it3 = collection.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            t = null;
                            break;
                        }
                        t = it3.next();
                        String str3 = (String) t;
                        if (Y3(str3, 0, charSequence, i3, str3.length(), z)) {
                            break;
                        }
                    }
                    str = (String) t;
                    if (str == null) {
                        if (i3 == k3) {
                            break;
                        }
                        j2 = i3 + m3;
                    } else {
                        break;
                    }
                }
            }
            return null;
            return TuplesKt.a(Integer.valueOf(i3), str);
        }
        String str4 = (String) CollectionsKt.c5(collection);
        CharSequence charSequence2 = charSequence;
        String str5 = str4;
        int i4 = i2;
        int p3 = !z2 ? p3(charSequence2, str5, i4, false, 4, (Object) null) : StringsKt.D3(charSequence2, str5, i4, false, 4, (Object) null);
        if (p3 < 0) {
            return null;
        }
        return TuplesKt.a(Integer.valueOf(p3), str4);
    }

    @NotNull
    public static final CharSequence b4(@NotNull CharSequence charSequence, int i2, int i3) {
        Intrinsics.p(charSequence, "<this>");
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("End index (" + i3 + ") is less than start index (" + i2 + ").");
        } else if (i3 == i2) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(charSequence.length() - (i3 - i2));
            sb.append(charSequence, 0, i2);
            Intrinsics.o(sb, "this.append(value, startIndex, endIndex)");
            sb.append(charSequence, i3, charSequence.length());
            Intrinsics.o(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
    }

    public static /* synthetic */ boolean b5(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return Y4(charSequence, c2, z);
    }

    public static /* synthetic */ Pair c3(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return a3(charSequence, collection, i2, z);
    }

    @NotNull
    public static final CharSequence c4(@NotNull CharSequence charSequence, @NotNull IntRange intRange) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(intRange, "range");
        return b4(charSequence, intRange.c().intValue(), intRange.h().intValue() + 1);
    }

    public static /* synthetic */ boolean c5(CharSequence charSequence, CharSequence charSequence2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return Z4(charSequence, charSequence2, i2, z);
    }

    @Nullable
    public static final Pair<Integer, String> d3(@NotNull CharSequence charSequence, @NotNull Collection<String> collection, int i2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(collection, "strings");
        return b3(charSequence, collection, i2, z, true);
    }

    @InlineOnly
    private static final String d4(String str, int i2, int i3) {
        Intrinsics.p(str, "<this>");
        return b4(str, i2, i3).toString();
    }

    public static /* synthetic */ boolean d5(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return a5(charSequence, charSequence2, z);
    }

    public static /* synthetic */ Pair e3(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = StringsKt.g3(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return d3(charSequence, collection, i2, z);
    }

    @InlineOnly
    private static final String e4(String str, IntRange intRange) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(intRange, "range");
        return c4(str, intRange).toString();
    }

    @NotNull
    public static final CharSequence e5(@NotNull CharSequence charSequence, @NotNull IntRange intRange) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(intRange, "range");
        return charSequence.subSequence(intRange.c().intValue(), intRange.h().intValue() + 1);
    }

    @NotNull
    public static final IntRange f3(@NotNull CharSequence charSequence) {
        Intrinsics.p(charSequence, "<this>");
        return new IntRange(0, charSequence.length() - 1);
    }

    @NotNull
    public static final CharSequence f4(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(charSequence2, "suffix");
        return Z2(charSequence, charSequence2, false, 2, (Object) null) ? charSequence.subSequence(0, charSequence.length() - charSequence2.length()) : charSequence.subSequence(0, charSequence.length());
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    @InlineOnly
    private static final CharSequence f5(String str, int i2, int i3) {
        Intrinsics.p(str, "<this>");
        return str.subSequence(i2, i3);
    }

    public static int g3(@NotNull CharSequence charSequence) {
        Intrinsics.p(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    @NotNull
    public static final String g4(@NotNull String str, @NotNull CharSequence charSequence) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(charSequence, "suffix");
        if (!Z2(str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - charSequence.length());
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @InlineOnly
    private static final String g5(CharSequence charSequence, int i2, int i3) {
        Intrinsics.p(charSequence, "<this>");
        return charSequence.subSequence(i2, i3).toString();
    }

    public static final boolean h3(@NotNull CharSequence charSequence, int i2) {
        Intrinsics.p(charSequence, "<this>");
        return new IntRange(0, charSequence.length() + -2).q(i2) && Character.isHighSurrogate(charSequence.charAt(i2)) && Character.isLowSurrogate(charSequence.charAt(i2 + 1));
    }

    @NotNull
    public static final CharSequence h4(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(charSequence2, TtmlNode.b0);
        return i4(charSequence, charSequence2, charSequence2);
    }

    @NotNull
    public static final String h5(@NotNull CharSequence charSequence, @NotNull IntRange intRange) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(intRange, "range");
        return charSequence.subSequence(intRange.c().intValue(), intRange.h().intValue() + 1).toString();
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [R, C, java.lang.CharSequence] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.internal.InlineOnly
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <C extends java.lang.CharSequence & R, R> R i3(C r1, kotlin.jvm.functions.Function0<? extends R> r2) {
        /*
            java.lang.String r0 = "defaultValue"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.S1(r1)
            if (r0 == 0) goto L_0x000f
            java.lang.Object r1 = r2.o()
        L_0x000f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsKt.i3(java.lang.CharSequence, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    @NotNull
    public static final CharSequence i4(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(charSequence2, "prefix");
        Intrinsics.p(charSequence3, "suffix");
        return (charSequence.length() < charSequence2.length() + charSequence3.length() || !d5(charSequence, charSequence2, false, 2, (Object) null) || !Z2(charSequence, charSequence3, false, 2, (Object) null)) ? charSequence.subSequence(0, charSequence.length()) : charSequence.subSequence(charSequence2.length(), charSequence.length() - charSequence3.length());
    }

    @NotNull
    public static final String i5(@NotNull String str, @NotNull IntRange intRange) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(intRange, "range");
        String substring = str.substring(intRange.c().intValue(), intRange.h().intValue() + 1);
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [R, C, java.lang.CharSequence] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.internal.InlineOnly
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <C extends java.lang.CharSequence & R, R> R j3(C r1, kotlin.jvm.functions.Function0<? extends R> r2) {
        /*
            java.lang.String r0 = "defaultValue"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            int r0 = r1.length()
            if (r0 != 0) goto L_0x000f
            java.lang.Object r1 = r2.o()
        L_0x000f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsKt.j3(java.lang.CharSequence, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    @NotNull
    public static final String j4(@NotNull String str, @NotNull CharSequence charSequence) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(charSequence, TtmlNode.b0);
        return k4(str, charSequence, charSequence);
    }

    static /* synthetic */ String j5(CharSequence charSequence, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = charSequence.length();
        }
        Intrinsics.p(charSequence, "<this>");
        return charSequence.subSequence(i2, i3).toString();
    }

    public static final int k3(@NotNull CharSequence charSequence, char c2, int i2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c2, i2);
        }
        return r3(charSequence, new char[]{c2}, i2, z);
    }

    @NotNull
    public static final String k4(@NotNull String str, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(charSequence, "prefix");
        Intrinsics.p(charSequence2, "suffix");
        if (str.length() < charSequence.length() + charSequence2.length() || !d5(str, charSequence, false, 2, (Object) null) || !Z2(str, charSequence2, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final String k5(@NotNull String str, char c2, @NotNull String str2) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "missingDelimiterValue");
        int o3 = StringsKt.o3(str, c2, 0, false, 6, (Object) null);
        if (o3 == -1) {
            return str2;
        }
        String substring = str.substring(o3 + 1, str.length());
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final int l3(@NotNull CharSequence charSequence, @NotNull String str, int i2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(str, TypedValues.Custom.f3952e);
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i2);
        }
        return n3(charSequence, str, i2, charSequence.length(), z, false, 16, (Object) null);
    }

    @InlineOnly
    private static final String l4(CharSequence charSequence, Regex regex, String str) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(regex, "regex");
        Intrinsics.p(str, "replacement");
        return regex.m(charSequence, str);
    }

    @NotNull
    public static final String l5(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, TtmlNode.b0);
        Intrinsics.p(str3, "missingDelimiterValue");
        int p3 = p3(str, str2, 0, false, 6, (Object) null);
        if (p3 == -1) {
            return str3;
        }
        String substring = str.substring(p3 + str2.length(), str.length());
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    private static final int m3(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2) {
        IntProgression intRange = !z2 ? new IntRange(RangesKt.u(i2, 0), RangesKt.B(i3, charSequence.length())) : RangesKt.k0(RangesKt.B(i2, StringsKt.g3(charSequence)), RangesKt.u(i3, 0));
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int j2 = intRange.j();
            int k2 = intRange.k();
            int m2 = intRange.m();
            if ((m2 <= 0 || j2 > k2) && (m2 >= 0 || k2 > j2)) {
                return -1;
            }
            while (true) {
                if (Y3(charSequence2, 0, charSequence, j2, charSequence2.length(), z)) {
                    return j2;
                }
                if (j2 == k2) {
                    return -1;
                }
                j2 += m2;
            }
        } else {
            int j3 = intRange.j();
            int k3 = intRange.k();
            int m3 = intRange.m();
            if ((m3 <= 0 || j3 > k3) && (m3 >= 0 || k3 > j3)) {
                return -1;
            }
            while (true) {
                if (StringsKt.b2((String) charSequence2, 0, (String) charSequence, j3, charSequence2.length(), z)) {
                    return j3;
                }
                if (j3 == k3) {
                    return -1;
                }
                j3 += m3;
            }
        }
    }

    @InlineOnly
    private static final String m4(CharSequence charSequence, Regex regex, Function1<? super MatchResult, ? extends CharSequence> function1) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(regex, "regex");
        Intrinsics.p(function1, "transform");
        return regex.n(charSequence, function1);
    }

    public static /* synthetic */ String m5(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return k5(str, c2, str2);
    }

    static /* synthetic */ int n3(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2, int i4, Object obj) {
        return m3(charSequence, charSequence2, i2, i3, z, (i4 & 16) != 0 ? false : z2);
    }

    @NotNull
    public static final String n4(@NotNull String str, char c2, @NotNull String str2, @NotNull String str3) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "replacement");
        Intrinsics.p(str3, "missingDelimiterValue");
        int o3 = StringsKt.o3(str, c2, 0, false, 6, (Object) null);
        return o3 == -1 ? str3 : G4(str, o3 + 1, str.length(), str2).toString();
    }

    public static /* synthetic */ String n5(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return l5(str, str2, str3);
    }

    public static /* synthetic */ int o3(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return k3(charSequence, c2, i2, z);
    }

    @NotNull
    public static final String o4(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, TtmlNode.b0);
        Intrinsics.p(str3, "replacement");
        Intrinsics.p(str4, "missingDelimiterValue");
        int p3 = p3(str, str2, 0, false, 6, (Object) null);
        return p3 == -1 ? str4 : G4(str, p3 + str2.length(), str.length(), str3).toString();
    }

    @NotNull
    public static String o5(@NotNull String str, char c2, @NotNull String str2) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "missingDelimiterValue");
        int C3 = C3(str, c2, 0, false, 6, (Object) null);
        if (C3 == -1) {
            return str2;
        }
        String substring = str.substring(C3 + 1, str.length());
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ int p3(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return l3(charSequence, str, i2, z);
    }

    public static /* synthetic */ String p4(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return n4(str, c2, str2, str3);
    }

    @NotNull
    public static final String p5(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, TtmlNode.b0);
        Intrinsics.p(str3, "missingDelimiterValue");
        int D3 = StringsKt.D3(str, str2, 0, false, 6, (Object) null);
        if (D3 == -1) {
            return str3;
        }
        String substring = str.substring(D3 + str2.length(), str.length());
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final int q3(@NotNull CharSequence charSequence, @NotNull Collection<String> collection, int i2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(collection, "strings");
        Pair<Integer, String> b3 = b3(charSequence, collection, i2, z, false);
        if (b3 != null) {
            return b3.e().intValue();
        }
        return -1;
    }

    public static /* synthetic */ String q4(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return o4(str, str2, str3, str4);
    }

    public static /* synthetic */ String q5(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return StringsKt.o5(str, c2, str2);
    }

    public static final int r3(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i2, boolean z) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            IntIterator n2 = new IntRange(RangesKt.u(i2, 0), StringsKt.g3(charSequence)).iterator();
            while (n2.hasNext()) {
                int b2 = n2.b();
                char charAt = charSequence.charAt(b2);
                int length = cArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        if (CharsKt__CharKt.J(cArr[i3], charAt, z)) {
                            return b2;
                        }
                        i3++;
                    }
                }
            }
            return -1;
        }
        return ((String) charSequence).indexOf(ArraysKt.Ws(cArr), i2);
    }

    @NotNull
    public static final String r4(@NotNull String str, char c2, @NotNull String str2, @NotNull String str3) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "replacement");
        Intrinsics.p(str3, "missingDelimiterValue");
        int C3 = C3(str, c2, 0, false, 6, (Object) null);
        return C3 == -1 ? str3 : G4(str, C3 + 1, str.length(), str2).toString();
    }

    public static /* synthetic */ String r5(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return p5(str, str2, str3);
    }

    public static /* synthetic */ int s3(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return q3(charSequence, collection, i2, z);
    }

    @NotNull
    public static final String s4(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, TtmlNode.b0);
        Intrinsics.p(str3, "replacement");
        Intrinsics.p(str4, "missingDelimiterValue");
        int D3 = StringsKt.D3(str, str2, 0, false, 6, (Object) null);
        return D3 == -1 ? str4 : G4(str, D3 + str2.length(), str.length(), str3).toString();
    }

    @NotNull
    public static final String s5(@NotNull String str, char c2, @NotNull String str2) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "missingDelimiterValue");
        int o3 = StringsKt.o3(str, c2, 0, false, 6, (Object) null);
        if (o3 == -1) {
            return str2;
        }
        String substring = str.substring(0, o3);
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ int t3(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return r3(charSequence, cArr, i2, z);
    }

    public static /* synthetic */ String t4(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return r4(str, c2, str2, str3);
    }

    @NotNull
    public static final String t5(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, TtmlNode.b0);
        Intrinsics.p(str3, "missingDelimiterValue");
        int p3 = p3(str, str2, 0, false, 6, (Object) null);
        if (p3 == -1) {
            return str3;
        }
        String substring = str.substring(0, p3);
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @InlineOnly
    private static final boolean u3(CharSequence charSequence) {
        Intrinsics.p(charSequence, "<this>");
        return charSequence.length() == 0;
    }

    public static /* synthetic */ String u4(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return s4(str, str2, str3, str4);
    }

    public static /* synthetic */ String u5(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return s5(str, c2, str2);
    }

    @InlineOnly
    private static final boolean v3(CharSequence charSequence) {
        Intrinsics.p(charSequence, "<this>");
        return !StringsKt__StringsJVMKt.S1(charSequence);
    }

    @NotNull
    public static final String v4(@NotNull String str, char c2, @NotNull String str2, @NotNull String str3) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "replacement");
        Intrinsics.p(str3, "missingDelimiterValue");
        int o3 = StringsKt.o3(str, c2, 0, false, 6, (Object) null);
        return o3 == -1 ? str3 : G4(str, 0, o3, str2).toString();
    }

    public static /* synthetic */ String v5(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return t5(str, str2, str3);
    }

    @InlineOnly
    private static final boolean w3(CharSequence charSequence) {
        Intrinsics.p(charSequence, "<this>");
        return charSequence.length() > 0;
    }

    @NotNull
    public static final String w4(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, TtmlNode.b0);
        Intrinsics.p(str3, "replacement");
        Intrinsics.p(str4, "missingDelimiterValue");
        int p3 = p3(str, str2, 0, false, 6, (Object) null);
        return p3 == -1 ? str4 : G4(str, 0, p3, str3).toString();
    }

    @NotNull
    public static final String w5(@NotNull String str, char c2, @NotNull String str2) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "missingDelimiterValue");
        int C3 = C3(str, c2, 0, false, 6, (Object) null);
        if (C3 == -1) {
            return str2;
        }
        String substring = str.substring(0, C3);
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @InlineOnly
    private static final boolean x3(CharSequence charSequence) {
        return charSequence == null || StringsKt__StringsJVMKt.S1(charSequence);
    }

    public static /* synthetic */ String x4(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return v4(str, c2, str2, str3);
    }

    @NotNull
    public static final String x5(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, TtmlNode.b0);
        Intrinsics.p(str3, "missingDelimiterValue");
        int D3 = StringsKt.D3(str, str2, 0, false, 6, (Object) null);
        if (D3 == -1) {
            return str3;
        }
        String substring = str.substring(0, D3);
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @InlineOnly
    private static final boolean y3(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static /* synthetic */ String y4(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return w4(str, str2, str3, str4);
    }

    public static /* synthetic */ String y5(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return w5(str, c2, str2);
    }

    @NotNull
    public static final CharIterator z3(@NotNull CharSequence charSequence) {
        Intrinsics.p(charSequence, "<this>");
        return new StringsKt__StringsKt$iterator$1(charSequence);
    }

    @NotNull
    public static final String z4(@NotNull String str, char c2, @NotNull String str2, @NotNull String str3) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(str2, "replacement");
        Intrinsics.p(str3, "missingDelimiterValue");
        int C3 = C3(str, c2, 0, false, 6, (Object) null);
        return C3 == -1 ? str3 : G4(str, 0, C3, str2).toString();
    }

    public static /* synthetic */ String z5(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return x5(str, str2, str3);
    }
}
