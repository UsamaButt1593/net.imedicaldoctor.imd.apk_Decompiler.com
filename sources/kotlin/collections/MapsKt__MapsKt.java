package kotlin.collections;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.BuilderInference;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010&\n\u0002\b\t\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b<\u001a%\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001aQ\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\b\u0010\t\u001a(\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\b¢\u0006\u0004\b\u0001\u0010\u0004\u001a(\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\b¢\u0006\u0004\b\u000b\u0010\u0004\u001aQ\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\f\u0010\t\u001a8\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\b¢\u0006\u0004\b\u000f\u0010\u0010\u001aa\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0011\u0010\u0012\u001a8\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0014\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\b¢\u0006\u0004\b\u0015\u0010\u0016\u001aa\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0014\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0017\u0010\u0018\u001a_\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012%\b\u0001\u0010\u001c\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001ag\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010 \u001a\u00020\u001f2%\b\u0001\u0010\u001c\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b!\u0010\"\u001a.\u0010$\u001a\u00020#\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\b¢\u0006\u0004\b$\u0010%\u001aA\u0010&\u001a\u00020#\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\b&\u0010%\u001a:\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0002H\b¢\u0006\u0004\b'\u0010(\u001aA\u0010+\u001a\u00028\u0001\"\u0014\b\u0000\u0010\u0011*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002*\u00028\u0001\"\u0004\b\u0001\u0010\u0015*\u00028\u00002\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010)H\bø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a;\u0010/\u001a\u00020#\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b-\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010.\u001a\u00028\u0000H\n¢\u0006\u0004\b/\u00100\u001a=\u00101\u001a\u0004\u0018\u00018\u0001\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b-\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010.\u001a\u00028\u0000H\n¢\u0006\u0004\b1\u00102\u001a<\u00104\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\u0006\u0010.\u001a\u00028\u00002\u0006\u00103\u001a\u00028\u0001H\n¢\u0006\u0004\b4\u00105\u001a3\u00106\u001a\u00020#\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b-*\u000e\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0002\b\u00030\u00022\u0006\u0010.\u001a\u00028\u0000H\b¢\u0006\u0004\b6\u00100\u001a9\u00107\u001a\u00020#\"\u0004\b\u0000\u0010\u0000\"\t\b\u0001\u0010\u0001¢\u0006\u0002\b-*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u00103\u001a\u00028\u0001H\b¢\u0006\u0004\b7\u00100\u001a=\u00108\u001a\u0004\u0018\u00018\u0001\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b-\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\u0006\u0010.\u001a\u00028\u0000H\b¢\u0006\u0004\b8\u00102\u001a,\u0010:\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109H\n¢\u0006\u0004\b:\u0010;\u001a,\u0010<\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109H\n¢\u0006\u0004\b<\u0010;\u001a8\u0010=\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109H\b¢\u0006\u0004\b=\u0010>\u001aE\u0010?\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010.\u001a\u00028\u00002\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010)H\bø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001aE\u0010A\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010.\u001a\u00028\u00002\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010)H\bø\u0001\u0000¢\u0006\u0004\bA\u0010@\u001a3\u0010\u0000\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010.\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0000\u00102\u001aE\u0010B\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\u0006\u0010.\u001a\u00028\u00002\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010)H\bø\u0001\u0000¢\u0006\u0004\bB\u0010@\u001a@\u0010D\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001090C\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\n¢\u0006\u0004\bD\u0010E\u001a>\u0010H\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010G0F\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH\n¢\u0006\u0004\bH\u0010E\u001ay\u0010K\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0015\"\u0018\b\u0003\u0010\u0011*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00020\n*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010I\u001a\u00028\u00032\u001e\u0010J\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109\u0012\u0004\u0012\u00028\u00020\u0019H\bø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001ay\u0010M\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0015\"\u0018\b\u0003\u0010\u0011*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0002\u0012\u0006\b\u0000\u0012\u00028\u00010\n*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010I\u001a\u00028\u00032\u001e\u0010J\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109\u0012\u0004\u0012\u00028\u00020\u0019H\bø\u0001\u0000¢\u0006\u0004\bM\u0010L\u001aI\u0010N\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u001a\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005¢\u0006\u0004\bN\u0010O\u001aG\u0010Q\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060P¢\u0006\u0004\bQ\u0010R\u001aG\u0010T\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060S¢\u0006\u0004\bT\u0010U\u001ac\u0010V\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0015*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010J\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109\u0012\u0004\u0012\u00028\u00020\u0019H\bø\u0001\u0000¢\u0006\u0004\bV\u0010W\u001ac\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0015*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010J\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109\u0012\u0004\u0012\u00028\u00020\u0019H\bø\u0001\u0000¢\u0006\u0004\bX\u0010W\u001aQ\u0010Z\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020#0\u0019H\bø\u0001\u0000¢\u0006\u0004\bZ\u0010W\u001aQ\u0010[\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020#0\u0019H\bø\u0001\u0000¢\u0006\u0004\b[\u0010W\u001as\u0010\\\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u0011*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010I\u001a\u00028\u00022\u001e\u0010Y\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109\u0012\u0004\u0012\u00020#0\u0019H\bø\u0001\u0000¢\u0006\u0004\b\\\u0010L\u001a]\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010Y\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109\u0012\u0004\u0012\u00020#0\u0019H\bø\u0001\u0000¢\u0006\u0004\b]\u0010W\u001as\u0010^\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u0011*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010I\u001a\u00028\u00022\u001e\u0010Y\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109\u0012\u0004\u0012\u00020#0\u0019H\bø\u0001\u0000¢\u0006\u0004\b^\u0010L\u001a]\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010Y\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109\u0012\u0004\u0012\u00020#0\u0019H\bø\u0001\u0000¢\u0006\u0004\b_\u0010W\u001a;\u0010`\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060P¢\u0006\u0004\b`\u0010a\u001aQ\u0010b\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u0011*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060P2\u0006\u0010I\u001a\u00028\u0002¢\u0006\u0004\bb\u0010c\u001a=\u0010d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005¢\u0006\u0004\bd\u0010\t\u001aS\u0010e\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u0011*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u00052\u0006\u0010I\u001a\u00028\u0002¢\u0006\u0004\be\u0010f\u001a;\u0010g\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060S¢\u0006\u0004\bg\u0010h\u001aQ\u0010i\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u0011*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060S2\u0006\u0010I\u001a\u00028\u0002¢\u0006\u0004\bi\u0010j\u001a9\u0010k\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\bk\u0010(\u001a9\u0010l\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\bl\u0010(\u001aO\u0010m\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\u0011*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010I\u001a\u00028\u0002H\u0007¢\u0006\u0004\bm\u0010n\u001aN\u0010p\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0002¢\u0006\u0004\bp\u0010q\u001aT\u0010r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060PH\u0002¢\u0006\u0004\br\u0010s\u001aV\u0010t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005H\u0002¢\u0006\u0004\bt\u0010u\u001aT\u0010v\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060SH\u0002¢\u0006\u0004\bv\u0010w\u001aP\u0010y\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0014\u0010x\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0002¢\u0006\u0004\by\u0010n\u001aD\u0010z\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\n¢\u0006\u0004\bz\u0010{\u001aJ\u0010|\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060PH\n¢\u0006\u0004\b|\u0010R\u001aL\u0010}\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u001a\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005H\n¢\u0006\u0004\b}\u0010O\u001aJ\u0010~\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060SH\n¢\u0006\u0004\b~\u0010U\u001aE\u0010\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u0012\u0010x\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\n¢\u0006\u0005\b\u0010\u0001\u001aE\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010.\u001a\u00028\u0000H\u0002¢\u0006\u0006\b\u0001\u0010\u0001\u001aK\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000PH\u0002¢\u0006\u0005\b\u0001\u0010s\u001aN\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u000f\u0010\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H\u0002¢\u0006\u0006\b\u0001\u0010\u0001\u001aK\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000SH\u0002¢\u0006\u0005\b\u0001\u0010w\u001a7\u0010\u0001\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\u0006\u0010.\u001a\u00028\u0000H\n¢\u0006\u0006\b\u0001\u0010\u0001\u001a=\u0010\u0001\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000PH\n¢\u0006\u0005\b\u0001\u0010R\u001a@\u0010\u0001\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\u000f\u0010\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H\n¢\u0006\u0006\b\u0001\u0010\u0001\u001a=\u0010\u0001\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000SH\n¢\u0006\u0005\b\u0001\u0010U\u001a9\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0000¢\u0006\u0005\b\u0001\u0010(\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0001"}, d2 = {"K", "V", "", "z", "()Ljava/util/Map;", "", "Lkotlin/Pair;", "pairs", "W", "([Lkotlin/Pair;)Ljava/util/Map;", "", "i0", "j0", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "L", "()Ljava/util/HashMap;", "M", "([Lkotlin/Pair;)Ljava/util/HashMap;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "R", "()Ljava/util/LinkedHashMap;", "S", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "t", "(Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "", "capacity", "s", "(ILkotlin/jvm/functions/Function1;)Ljava/util/Map;", "", "O", "(Ljava/util/Map;)Z", "P", "l0", "(Ljava/util/Map;)Ljava/util/Map;", "Lkotlin/Function0;", "defaultValue", "N", "(Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/internal/OnlyInputTypes;", "key", "w", "(Ljava/util/Map;Ljava/lang/Object;)Z", "G", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "value", "A0", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "x", "y", "z0", "", "u", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "v", "K0", "(Ljava/util/Map$Entry;)Lkotlin/Pair;", "H", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "I", "J", "", "Q", "(Ljava/util/Map;)Ljava/util/Iterator;", "", "", "h0", "destination", "transform", "Y", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "U", "y0", "(Ljava/util/Map;[Lkotlin/Pair;)V", "", "w0", "(Ljava/util/Map;Ljava/lang/Iterable;)V", "Lkotlin/sequences/Sequence;", "x0", "(Ljava/util/Map;Lkotlin/sequences/Sequence;)V", "X", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "T", "predicate", "B", "F", "E", "A", "D", "C", "B0", "(Ljava/lang/Iterable;)Ljava/util/Map;", "C0", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "H0", "I0", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "F0", "(Lkotlin/sequences/Sequence;)Ljava/util/Map;", "G0", "(Lkotlin/sequences/Sequence;Ljava/util/Map;)Ljava/util/Map;", "D0", "J0", "E0", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "pair", "o0", "(Ljava/util/Map;Lkotlin/Pair;)Ljava/util/Map;", "m0", "(Ljava/util/Map;Ljava/lang/Iterable;)Ljava/util/Map;", "q0", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", "p0", "(Ljava/util/Map;Lkotlin/sequences/Sequence;)Ljava/util/Map;", "map", "n0", "t0", "(Ljava/util/Map;Lkotlin/Pair;)V", "r0", "v0", "u0", "s0", "(Ljava/util/Map;Ljava/util/Map;)V", "a0", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "Z", "c0", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "b0", "e0", "(Ljava/util/Map;Ljava/lang/Object;)V", "d0", "g0", "(Ljava/util/Map;[Ljava/lang/Object;)V", "f0", "k0", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/MapsKt")
@SourceDebugExtension({"SMAP\nMaps.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,804:1\n403#1:814\n414#1:819\n511#1,6:824\n536#1,6:830\n1#2:805\n1238#3,4:806\n1238#3,4:810\n1238#3,4:815\n1238#3,4:820\n*S KotlinDebug\n*F\n+ 1 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n453#1:814\n468#1:819\n526#1:824,6\n551#1:830,6\n403#1:806,4\n414#1:810,4\n453#1:815,4\n468#1:820,4\n*E\n"})
class MapsKt__MapsKt extends MapsKt__MapsJVMKt {
    @NotNull
    public static final <K, V> Map<K, V> A(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (function1.f(next).booleanValue()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        return linkedHashMap;
    }

    @InlineOnly
    private static final <K, V> void A0(Map<K, V> map, K k2, V v) {
        Intrinsics.p(map, "<this>");
        map.put(k2, v);
    }

    @NotNull
    public static final <K, V> Map<K, V> B(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super K, Boolean> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (function1.f(next.getKey()).booleanValue()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public static <K, V> Map<K, V> B0(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return k0(C0(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return MapsKt.z();
        }
        if (size != 1) {
            return C0(iterable, new LinkedHashMap(MapsKt.j(collection.size())));
        }
        return MapsKt__MapsJVMKt.k((Pair) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
    }

    @NotNull
    public static final <K, V> Map<K, V> C(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (!function1.f(next).booleanValue()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M C0(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable, @NotNull M m2) {
        Intrinsics.p(iterable, "<this>");
        Intrinsics.p(m2, Annotation.l3);
        w0(m2, iterable);
        return m2;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M D(@NotNull Map<? extends K, ? extends V> map, @NotNull M m2, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(m2, Annotation.l3);
        Intrinsics.p(function1, "predicate");
        for (Map.Entry next : map.entrySet()) {
            if (!function1.f(next).booleanValue()) {
                m2.put(next.getKey(), next.getValue());
            }
        }
        return m2;
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static <K, V> Map<K, V> D0(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.p(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? MapsKt.J0(map) : MapsKt__MapsJVMKt.o(map);
        }
        return MapsKt.z();
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M E(@NotNull Map<? extends K, ? extends V> map, @NotNull M m2, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(m2, Annotation.l3);
        Intrinsics.p(function1, "predicate");
        for (Map.Entry next : map.entrySet()) {
            if (function1.f(next).booleanValue()) {
                m2.put(next.getKey(), next.getValue());
            }
        }
        return m2;
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <K, V, M extends Map<? super K, ? super V>> M E0(@NotNull Map<? extends K, ? extends V> map, @NotNull M m2) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(m2, Annotation.l3);
        m2.putAll(map);
        return m2;
    }

    @NotNull
    public static final <K, V> Map<K, V> F(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super V, Boolean> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (function1.f(next.getValue()).booleanValue()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> F0(@NotNull Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        Intrinsics.p(sequence, "<this>");
        return k0(G0(sequence, new LinkedHashMap()));
    }

    @InlineOnly
    private static final <K, V> V G(Map<? extends K, ? extends V> map, K k2) {
        Intrinsics.p(map, "<this>");
        return map.get(k2);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M G0(@NotNull Sequence<? extends Pair<? extends K, ? extends V>> sequence, @NotNull M m2) {
        Intrinsics.p(sequence, "<this>");
        Intrinsics.p(m2, Annotation.l3);
        x0(m2, sequence);
        return m2;
    }

    @InlineOnly
    private static final <K, V> V H(Map<K, ? extends V> map, K k2, Function0<? extends V> function0) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function0, "defaultValue");
        V v = map.get(k2);
        return v == null ? function0.o() : v;
    }

    @NotNull
    public static final <K, V> Map<K, V> H0(@NotNull Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.p(pairArr, "<this>");
        int length = pairArr.length;
        if (length != 0) {
            return length != 1 ? I0(pairArr, new LinkedHashMap(MapsKt.j(pairArr.length))) : MapsKt__MapsJVMKt.k(pairArr[0]);
        }
        return MapsKt.z();
    }

    public static final <K, V> V I(@NotNull Map<K, ? extends V> map, K k2, @NotNull Function0<? extends V> function0) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function0, "defaultValue");
        V v = map.get(k2);
        return (v != null || map.containsKey(k2)) ? v : function0.o();
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M I0(@NotNull Pair<? extends K, ? extends V>[] pairArr, @NotNull M m2) {
        Intrinsics.p(pairArr, "<this>");
        Intrinsics.p(m2, Annotation.l3);
        y0(m2, pairArr);
        return m2;
    }

    public static final <K, V> V J(@NotNull Map<K, V> map, K k2, @NotNull Function0<? extends V> function0) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function0, "defaultValue");
        V v = map.get(k2);
        if (v != null) {
            return v;
        }
        V o = function0.o();
        map.put(k2, o);
        return o;
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static <K, V> Map<K, V> J0(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.p(map, "<this>");
        return new LinkedHashMap(map);
    }

    @SinceKotlin(version = "1.1")
    public static final <K, V> V K(@NotNull Map<K, ? extends V> map, K k2) {
        Intrinsics.p(map, "<this>");
        return MapsKt__MapWithDefaultKt.a(map, k2);
    }

    @InlineOnly
    private static final <K, V> Pair<K, V> K0(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.p(entry, "<this>");
        return new Pair<>(entry.getKey(), entry.getValue());
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> HashMap<K, V> L() {
        return new HashMap<>();
    }

    @NotNull
    public static final <K, V> HashMap<K, V> M(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.p(pairArr, "pairs");
        HashMap<K, V> hashMap = new HashMap<>(MapsKt.j(pairArr.length));
        y0(hashMap, pairArr);
        return hashMap;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [R, java.util.Map, M] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.internal.InlineOnly
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <M extends java.util.Map<?, ?> & R, R> R N(M r1, kotlin.jvm.functions.Function0<? extends R> r2) {
        /*
            java.lang.String r0 = "defaultValue"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L_0x000f
            java.lang.Object r1 = r2.o()
        L_0x000f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.MapsKt__MapsKt.N(java.util.Map, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    @InlineOnly
    private static final <K, V> boolean O(Map<? extends K, ? extends V> map) {
        Intrinsics.p(map, "<this>");
        return !map.isEmpty();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <K, V> boolean P(Map<? extends K, ? extends V> map) {
        return map == null || map.isEmpty();
    }

    @InlineOnly
    private static final <K, V> Iterator<Map.Entry<K, V>> Q(Map<? extends K, ? extends V> map) {
        Intrinsics.p(map, "<this>");
        return map.entrySet().iterator();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> LinkedHashMap<K, V> R() {
        return new LinkedHashMap<>();
    }

    @NotNull
    public static final <K, V> LinkedHashMap<K, V> S(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.p(pairArr, "pairs");
        return (LinkedHashMap) I0(pairArr, new LinkedHashMap(MapsKt.j(pairArr.length)));
    }

    @NotNull
    public static final <K, V, R> Map<R, V> T(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.j(map.size()));
        for (T next : map.entrySet()) {
            linkedHashMap.put(function1.f(next), ((Map.Entry) next).getValue());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V, R, M extends Map<? super R, ? super V>> M U(@NotNull Map<? extends K, ? extends V> map, @NotNull M m2, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(m2, Annotation.l3);
        Intrinsics.p(function1, "transform");
        for (T next : map.entrySet()) {
            m2.put(function1.f(next), ((Map.Entry) next).getValue());
        }
        return m2;
    }

    @InlineOnly
    private static final <K, V> Map<K, V> V() {
        return MapsKt.z();
    }

    @NotNull
    public static <K, V> Map<K, V> W(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.p(pairArr, "pairs");
        return pairArr.length > 0 ? I0(pairArr, new LinkedHashMap(MapsKt.j(pairArr.length))) : MapsKt.z();
    }

    @NotNull
    public static final <K, V, R> Map<K, R> X(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.j(map.size()));
        for (T next : map.entrySet()) {
            linkedHashMap.put(((Map.Entry) next).getKey(), function1.f(next));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V, R, M extends Map<? super K, ? super R>> M Y(@NotNull Map<? extends K, ? extends V> map, @NotNull M m2, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(m2, Annotation.l3);
        Intrinsics.p(function1, "transform");
        for (T next : map.entrySet()) {
            m2.put(((Map.Entry) next).getKey(), function1.f(next));
        }
        return m2;
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> Z(@NotNull Map<? extends K, ? extends V> map, @NotNull Iterable<? extends K> iterable) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(iterable, UserMetadata.f23742i);
        Map<? extends K, ? extends V> J0 = MapsKt.J0(map);
        CollectionsKt__MutableCollectionsKt.E0(J0.keySet(), iterable);
        return k0(J0);
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> a0(@NotNull Map<? extends K, ? extends V> map, K k2) {
        Intrinsics.p(map, "<this>");
        Map<? extends K, ? extends V> J0 = MapsKt.J0(map);
        J0.remove(k2);
        return k0(J0);
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> b0(@NotNull Map<? extends K, ? extends V> map, @NotNull Sequence<? extends K> sequence) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(sequence, UserMetadata.f23742i);
        Map<? extends K, ? extends V> J0 = MapsKt.J0(map);
        CollectionsKt__MutableCollectionsKt.G0(J0.keySet(), sequence);
        return k0(J0);
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> c0(@NotNull Map<? extends K, ? extends V> map, @NotNull K[] kArr) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(kArr, UserMetadata.f23742i);
        Map<? extends K, ? extends V> J0 = MapsKt.J0(map);
        CollectionsKt__MutableCollectionsKt.H0(J0.keySet(), kArr);
        return k0(J0);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void d0(Map<K, V> map, Iterable<? extends K> iterable) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(iterable, UserMetadata.f23742i);
        CollectionsKt__MutableCollectionsKt.E0(map.keySet(), iterable);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void e0(Map<K, V> map, K k2) {
        Intrinsics.p(map, "<this>");
        map.remove(k2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void f0(Map<K, V> map, Sequence<? extends K> sequence) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(sequence, UserMetadata.f23742i);
        CollectionsKt__MutableCollectionsKt.G0(map.keySet(), sequence);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void g0(Map<K, V> map, K[] kArr) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(kArr, UserMetadata.f23742i);
        CollectionsKt__MutableCollectionsKt.H0(map.keySet(), kArr);
    }

    @InlineOnly
    @JvmName(name = "mutableIterator")
    private static final <K, V> Iterator<Map.Entry<K, V>> h0(Map<K, V> map) {
        Intrinsics.p(map, "<this>");
        return map.entrySet().iterator();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> Map<K, V> i0() {
        return new LinkedHashMap();
    }

    @NotNull
    public static final <K, V> Map<K, V> j0(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.p(pairArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.j(pairArr.length));
        y0(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> k0(@NotNull Map<K, ? extends V> map) {
        Intrinsics.p(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : MapsKt__MapsJVMKt.o(map);
        }
        return MapsKt.z();
    }

    @InlineOnly
    private static final <K, V> Map<K, V> l0(Map<K, ? extends V> map) {
        return map == null ? MapsKt.z() : map;
    }

    @NotNull
    public static final <K, V> Map<K, V> m0(@NotNull Map<? extends K, ? extends V> map, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(iterable, "pairs");
        if (map.isEmpty()) {
            return MapsKt.B0(iterable);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        w0(linkedHashMap, iterable);
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> n0(@NotNull Map<? extends K, ? extends V> map, @NotNull Map<? extends K, ? extends V> map2) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(map2, HTML.Tag.t0);
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> o0(@NotNull Map<? extends K, ? extends V> map, @NotNull Pair<? extends K, ? extends V> pair) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(pair, "pair");
        if (map.isEmpty()) {
            return MapsKt__MapsJVMKt.k(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.e(), pair.f());
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> p0(@NotNull Map<? extends K, ? extends V> map, @NotNull Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(sequence, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        x0(linkedHashMap, sequence);
        return k0(linkedHashMap);
    }

    @NotNull
    public static final <K, V> Map<K, V> q0(@NotNull Map<? extends K, ? extends V> map, @NotNull Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(pairArr, "pairs");
        if (map.isEmpty()) {
            return H0(pairArr);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        y0(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    @InlineOnly
    private static final <K, V> void r0(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(iterable, "pairs");
        w0(map, iterable);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final <K, V> Map<K, V> s(int i2, @BuilderInference Function1<? super Map<K, V>, Unit> function1) {
        Intrinsics.p(function1, "builderAction");
        Map h2 = MapsKt.h(i2);
        function1.f(h2);
        return MapsKt.d(h2);
    }

    @InlineOnly
    private static final <K, V> void s0(Map<? super K, ? super V> map, Map<K, ? extends V> map2) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(map2, HTML.Tag.t0);
        map.putAll(map2);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final <K, V> Map<K, V> t(@BuilderInference Function1<? super Map<K, V>, Unit> function1) {
        Intrinsics.p(function1, "builderAction");
        Map g2 = MapsKt__MapsJVMKt.g();
        function1.f(g2);
        return MapsKt.d(g2);
    }

    @InlineOnly
    private static final <K, V> void t0(Map<? super K, ? super V> map, Pair<? extends K, ? extends V> pair) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(pair, "pair");
        map.put(pair.e(), pair.f());
    }

    @InlineOnly
    private static final <K, V> K u(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.p(entry, "<this>");
        return entry.getKey();
    }

    @InlineOnly
    private static final <K, V> void u0(Map<? super K, ? super V> map, Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(sequence, "pairs");
        x0(map, sequence);
    }

    @InlineOnly
    private static final <K, V> V v(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.p(entry, "<this>");
        return entry.getValue();
    }

    @InlineOnly
    private static final <K, V> void v0(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(pairArr, "pairs");
        y0(map, pairArr);
    }

    @InlineOnly
    private static final <K, V> boolean w(Map<? extends K, ? extends V> map, K k2) {
        Intrinsics.p(map, "<this>");
        return map.containsKey(k2);
    }

    public static final <K, V> void w0(@NotNull Map<? super K, ? super V> map, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(iterable, "pairs");
        for (Pair pair : iterable) {
            map.put(pair.a(), pair.b());
        }
    }

    @InlineOnly
    private static final <K> boolean x(Map<? extends K, ?> map, K k2) {
        Intrinsics.p(map, "<this>");
        return map.containsKey(k2);
    }

    public static final <K, V> void x0(@NotNull Map<? super K, ? super V> map, @NotNull Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(sequence, "pairs");
        for (Pair pair : sequence) {
            map.put(pair.a(), pair.b());
        }
    }

    @InlineOnly
    private static final <K, V> boolean y(Map<K, ? extends V> map, V v) {
        Intrinsics.p(map, "<this>");
        return map.containsValue(v);
    }

    public static final <K, V> void y0(@NotNull Map<? super K, ? super V> map, @NotNull Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put(pair.a(), pair.b());
        }
    }

    @NotNull
    public static <K, V> Map<K, V> z() {
        EmptyMap emptyMap = EmptyMap.s;
        Intrinsics.n(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    @InlineOnly
    private static final <K, V> V z0(Map<? extends K, V> map, K k2) {
        Intrinsics.p(map, "<this>");
        return TypeIntrinsics.k(map).remove(k2);
    }
}
