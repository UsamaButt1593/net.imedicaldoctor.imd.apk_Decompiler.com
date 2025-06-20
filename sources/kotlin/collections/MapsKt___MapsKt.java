package kotlin.collections;

import com.itextpdf.text.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a]\u0010\b\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\b\b\u0002\u0010\u0003*\u00020\u0002*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042 \u0010\u0007\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a_\u0010\n\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\b\b\u0002\u0010\u0003*\u00020\u0002*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042 \u0010\u0007\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\t\u001a=\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f0\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\r\u0010\u000e\u001ac\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042$\u0010\u0007\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000f0\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001ac\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042$\u0010\u0007\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00120\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0011\u001aw\u0010\u0017\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003\"\u0010\b\u0003\u0010\u0015*\n\u0012\u0006\b\u0000\u0012\u00028\u00020\u0014*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0016\u001a\u00028\u00032$\u0010\u0007\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000f0\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001aw\u0010\u0019\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003\"\u0010\b\u0003\u0010\u0015*\n\u0012\u0006\b\u0000\u0012\u00028\u00020\u0014*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0016\u001a\u00028\u00032$\u0010\u0007\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00120\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0018\u001a]\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0011\u001ac\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\b\b\u0002\u0010\u0003*\u00020\u0002*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042 \u0010\u0007\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0011\u001aw\u0010\u001c\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\b\b\u0002\u0010\u0003*\u00020\u0002\"\u0010\b\u0003\u0010\u0015*\n\u0012\u0006\b\u0000\u0012\u00028\u00020\u0014*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0016\u001a\u00028\u00032 \u0010\u0007\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0018\u001aq\u0010\u001d\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003\"\u0010\b\u0003\u0010\u0015*\n\u0012\u0006\b\u0000\u0012\u00028\u00020\u0014*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0016\u001a\u00028\u00032\u001e\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0018\u001aQ\u0010 \u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010\u001f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020\u001e0\u0005H\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a+\u0010\"\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\"\u0010#\u001aQ\u0010$\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010\u001f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020\u001e0\u0005H\bø\u0001\u0000¢\u0006\u0004\b$\u0010!\u001a.\u0010&\u001a\u00020%\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\b¢\u0006\u0004\b&\u0010'\u001aQ\u0010(\u001a\u00020%\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010\u001f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020\u001e0\u0005H\bø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001aQ\u0010,\u001a\u00020*\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010+\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020*0\u0005H\bø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001am\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020.*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b0\u00101\u001ao\u00102\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020.*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b2\u00101\u001aQ\u00104\u001a\u000203\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u0002030\u0005H\bø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aQ\u00107\u001a\u000206\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u0002060\u0005H\bø\u0001\u0000¢\u0006\u0004\b7\u00108\u001aa\u00109\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020.*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001aS\u0010;\u001a\u0004\u0018\u000103\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u0002030\u0005H\bø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001aS\u0010=\u001a\u0004\u0018\u000106\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u0002060\u0005H\bø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001ac\u0010?\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020.*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b?\u0010:\u001as\u0010C\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001a\u0010B\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00020@j\n\u0012\u0006\b\u0000\u0012\u00028\u0002`A2\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001au\u0010E\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001a\u0010B\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00020@j\n\u0012\u0006\b\u0000\u0012\u00028\u0002`A2\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\bE\u0010D\u001an\u0010F\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000422\u0010B\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060@j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006`AH\b¢\u0006\u0004\bF\u0010G\u001ap\u0010H\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000422\u0010B\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060@j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006`AH\b¢\u0006\u0004\bH\u0010G\u001am\u0010I\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020.*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\bI\u00101\u001ao\u0010J\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020.*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\bJ\u00101\u001aQ\u0010K\u001a\u000203\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u0002030\u0005H\bø\u0001\u0000¢\u0006\u0004\bK\u00105\u001aQ\u0010L\u001a\u000206\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u0002060\u0005H\bø\u0001\u0000¢\u0006\u0004\bL\u00108\u001aa\u0010M\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020.*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\bM\u0010:\u001aS\u0010N\u001a\u0004\u0018\u000103\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u0002030\u0005H\bø\u0001\u0000¢\u0006\u0004\bN\u0010<\u001aS\u0010O\u001a\u0004\u0018\u000106\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u0002060\u0005H\bø\u0001\u0000¢\u0006\u0004\bO\u0010>\u001ac\u0010P\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020.*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\bP\u0010:\u001as\u0010Q\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001a\u0010B\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00020@j\n\u0012\u0006\b\u0000\u0012\u00028\u0002`A2\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\bQ\u0010D\u001au\u0010R\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001a\u0010B\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00020@j\n\u0012\u0006\b\u0000\u0012\u00028\u0002`A2\u001e\u0010/\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\bR\u0010D\u001an\u0010S\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000422\u0010B\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060@j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006`AH\b¢\u0006\u0004\bS\u0010G\u001ap\u0010T\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000422\u0010B\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060@j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006`AH\b¢\u0006\u0004\bT\u0010G\u001a+\u0010U\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\bU\u0010#\u001aQ\u0010V\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010\u001f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020\u001e0\u0005H\bø\u0001\u0000¢\u0006\u0004\bV\u0010!\u001a[\u0010X\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0016\b\u0002\u0010W*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004*\u00028\u00022\u001e\u0010+\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020*0\u0005H\bø\u0001\u0000¢\u0006\u0004\bX\u0010Y\u001ap\u0010^\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0016\b\u0002\u0010W*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004*\u00028\u000223\u0010+\u001a/\u0012\u0013\u0012\u00110%¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(]\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00020*0ZH\bø\u0001\u0000¢\u0006\u0004\b^\u0010_\u001a@\u0010`\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u000f\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\b¢\u0006\u0004\b`\u0010a\u001a=\u0010b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0012\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\bb\u0010c\u0002\u0007\n\u0005\b20\u0001¨\u0006d"}, d2 = {"K", "V", "", "R", "", "Lkotlin/Function1;", "", "transform", "W0", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "X0", "", "Lkotlin/Pair;", "J1", "(Ljava/util/Map;)Ljava/util/List;", "", "Y0", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "Lkotlin/sequences/Sequence;", "Z0", "", "C", "destination", "b1", "(Ljava/util/Map;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "a1", "d1", "e1", "f1", "g1", "", "predicate", "P0", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Z", "Q0", "(Ljava/util/Map;)Z", "R0", "", "U0", "(Ljava/util/Map;)I", "V0", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)I", "", "action", "c1", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "", "selector", "i1", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map$Entry;", "h1", "", "j1", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)D", "", "k1", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)F", "l1", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "n1", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "o1", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "m1", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "p1", "(Ljava/util/Map;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "q1", "s1", "(Ljava/util/Map;Ljava/util/Comparator;)Ljava/util/Map$Entry;", "r1", "u1", "t1", "v1", "w1", "x1", "z1", "A1", "y1", "B1", "C1", "E1", "D1", "F1", "G1", "M", "H1", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "I1", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "S0", "(Ljava/util/Map;)Ljava/lang/Iterable;", "T0", "(Ljava/util/Map;)Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/MapsKt")
@SourceDebugExtension({"SMAP\n_Maps.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,594:1\n96#1,5:595\n111#1,5:600\n152#1,3:605\n143#1:608\n215#1:609\n216#1:611\n144#1:612\n215#1:613\n216#1:615\n1#2:610\n1#2:614\n1940#3,14:616\n1963#3,14:630\n2310#3,14:644\n2333#3,14:658\n1864#3,3:672\n*S KotlinDebug\n*F\n+ 1 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n76#1:595,5\n89#1:600,5\n125#1:605,3\n135#1:608\n135#1:609\n135#1:611\n135#1:612\n143#1:613\n143#1:615\n135#1:610\n230#1:616,14\n241#1:630,14\n390#1:644,14\n401#1:658,14\n574#1:672,3\n*E\n"})
class MapsKt___MapsKt extends MapsKt___MapsJvmKt {
    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V> Float A1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float floatValue = function1.f(it2.next()).floatValue();
        while (it2.hasNext()) {
            floatValue = Math.min(floatValue, function1.f(it2.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V, R> R B1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(comparator, "comparator");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (it2.hasNext()) {
            R f2 = function1.f(it2.next());
            while (it2.hasNext()) {
                R f3 = function1.f(it2.next());
                if (comparator.compare(f2, f3) > 0) {
                    f2 = f3;
                }
            }
            return f2;
        }
        throw new NoSuchElementException();
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V, R> R C1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(comparator, "comparator");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R f2 = function1.f(it2.next());
        while (it2.hasNext()) {
            R f3 = function1.f(it2.next());
            if (comparator.compare(f2, f3) > 0) {
                f2 = f3;
            }
        }
        return f2;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V> Map.Entry<K, V> D1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.k4(map.entrySet(), comparator);
    }

    @SinceKotlin(version = "1.7")
    @InlineOnly
    @JvmName(name = "minWithOrThrow")
    private static final <K, V> Map.Entry<K, V> E1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.l4(map.entrySet(), comparator);
    }

    public static final <K, V> boolean F1(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.p(map, "<this>");
        return map.isEmpty();
    }

    public static final <K, V> boolean G1(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        for (Map.Entry<? extends K, ? extends V> f2 : map.entrySet()) {
            if (function1.f(f2).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <K, V, M extends Map<? extends K, ? extends V>> M H1(@NotNull M m2, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Unit> function1) {
        Intrinsics.p(m2, "<this>");
        Intrinsics.p(function1, "action");
        for (Map.Entry f2 : m2.entrySet()) {
            function1.f(f2);
        }
        return m2;
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    public static final <K, V, M extends Map<? extends K, ? extends V>> M I1(@NotNull M m2, @NotNull Function2<? super Integer, ? super Map.Entry<? extends K, ? extends V>, Unit> function2) {
        Intrinsics.p(m2, "<this>");
        Intrinsics.p(function2, "action");
        int i2 = 0;
        for (Object next : m2.entrySet()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.W();
            }
            function2.d0(Integer.valueOf(i2), next);
            i2 = i3;
        }
        return m2;
    }

    @NotNull
    public static final <K, V> List<Pair<K, V>> J1(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.p(map, "<this>");
        if (map.size() == 0) {
            return CollectionsKt.E();
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return CollectionsKt.E();
        }
        Map.Entry next = it2.next();
        if (!it2.hasNext()) {
            return CollectionsKt.k(new Pair(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new Pair(next.getKey(), next.getValue()));
        do {
            Map.Entry next2 = it2.next();
            arrayList.add(new Pair(next2.getKey(), next2.getValue()));
        } while (it2.hasNext());
        return arrayList;
    }

    public static final <K, V> boolean P0(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        for (Map.Entry<? extends K, ? extends V> f2 : map.entrySet()) {
            if (!function1.f(f2).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V> boolean Q0(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.p(map, "<this>");
        return !map.isEmpty();
    }

    public static final <K, V> boolean R0(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "predicate");
        if (map.isEmpty()) {
            return false;
        }
        for (Map.Entry<? extends K, ? extends V> f2 : map.entrySet()) {
            if (function1.f(f2).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @InlineOnly
    private static final <K, V> Iterable<Map.Entry<K, V>> S0(Map<? extends K, ? extends V> map) {
        Intrinsics.p(map, "<this>");
        return map.entrySet();
    }

    @NotNull
    public static final <K, V> Sequence<Map.Entry<K, V>> T0(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.p(map, "<this>");
        return CollectionsKt.x1(map.entrySet());
    }

    @InlineOnly
    private static final <K, V> int U0(Map<? extends K, ? extends V> map) {
        Intrinsics.p(map, "<this>");
        return map.size();
    }

    public static final <K, V> int V0(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "predicate");
        int i2 = 0;
        if (map.isEmpty()) {
            return 0;
        }
        for (Map.Entry<? extends K, ? extends V> f2 : map.entrySet()) {
            if (function1.f(f2).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <K, V, R> R W0(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        R r;
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                r = null;
                break;
            }
            r = function1.f(it2.next());
            if (r != null) {
                break;
            }
        }
        if (r != null) {
            return r;
        }
        throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <K, V, R> R X0(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "transform");
        for (Map.Entry<? extends K, ? extends V> f2 : map.entrySet()) {
            R f3 = function1.f(f2);
            if (f3 != null) {
                return f3;
            }
        }
        return null;
    }

    @NotNull
    public static final <K, V, R> List<R> Y0(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<? extends K, ? extends V> f2 : map.entrySet()) {
            CollectionsKt.n0(arrayList, (Iterable) function1.f(f2));
        }
        return arrayList;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @NotNull
    @JvmName(name = "flatMapSequence")
    public static final <K, V, R> List<R> Z0(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<? extends K, ? extends V> f2 : map.entrySet()) {
            CollectionsKt.o0(arrayList, (Sequence) function1.f(f2));
        }
        return arrayList;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @NotNull
    @JvmName(name = "flatMapSequenceTo")
    public static final <K, V, R, C extends Collection<? super R>> C a1(@NotNull Map<? extends K, ? extends V> map, @NotNull C c2, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(c2, Annotation.l3);
        Intrinsics.p(function1, "transform");
        for (Map.Entry<? extends K, ? extends V> f2 : map.entrySet()) {
            CollectionsKt.o0(c2, (Sequence) function1.f(f2));
        }
        return c2;
    }

    @NotNull
    public static final <K, V, R, C extends Collection<? super R>> C b1(@NotNull Map<? extends K, ? extends V> map, @NotNull C c2, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(c2, Annotation.l3);
        Intrinsics.p(function1, "transform");
        for (Map.Entry<? extends K, ? extends V> f2 : map.entrySet()) {
            CollectionsKt.n0(c2, (Iterable) function1.f(f2));
        }
        return c2;
    }

    @HidesMembers
    public static final <K, V> void c1(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Unit> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "action");
        for (Map.Entry<? extends K, ? extends V> f2 : map.entrySet()) {
            function1.f(f2);
        }
    }

    @NotNull
    public static final <K, V, R> List<R> d1(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "transform");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<? extends K, ? extends V> f2 : map.entrySet()) {
            arrayList.add(function1.f(f2));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, R> List<R> e1(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<? extends K, ? extends V> f2 : map.entrySet()) {
            Object f3 = function1.f(f2);
            if (f3 != null) {
                arrayList.add(f3);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, R, C extends Collection<? super R>> C f1(@NotNull Map<? extends K, ? extends V> map, @NotNull C c2, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(c2, Annotation.l3);
        Intrinsics.p(function1, "transform");
        for (Map.Entry<? extends K, ? extends V> f2 : map.entrySet()) {
            Object f3 = function1.f(f2);
            if (f3 != null) {
                c2.add(f3);
            }
        }
        return c2;
    }

    @NotNull
    public static final <K, V, R, C extends Collection<? super R>> C g1(@NotNull Map<? extends K, ? extends V> map, @NotNull C c2, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(c2, Annotation.l3);
        Intrinsics.p(function1, "transform");
        for (Map.Entry<? extends K, ? extends V> f2 : map.entrySet()) {
            c2.add(function1.f(f2));
        }
        return c2;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> h1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        T t;
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            t = null;
        } else {
            T next = it2.next();
            if (!it2.hasNext()) {
                t = next;
            } else {
                Comparable comparable = (Comparable) function1.f(next);
                do {
                    T next2 = it2.next();
                    Comparable comparable2 = (Comparable) function1.f(next2);
                    if (comparable.compareTo(comparable2) < 0) {
                        next = next2;
                        comparable = comparable2;
                    }
                } while (it2.hasNext());
            }
            t = next;
        }
        return (Map.Entry) t;
    }

    @SinceKotlin(version = "1.7")
    @InlineOnly
    @JvmName(name = "maxByOrThrow")
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> i1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (it2.hasNext()) {
            T next = it2.next();
            if (it2.hasNext()) {
                Comparable comparable = (Comparable) function1.f(next);
                do {
                    T next2 = it2.next();
                    Comparable comparable2 = (Comparable) function1.f(next2);
                    if (comparable.compareTo(comparable2) < 0) {
                        next = next2;
                        comparable = comparable2;
                    }
                } while (it2.hasNext());
            }
            return (Map.Entry) next;
        }
        throw new NoSuchElementException();
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V> double j1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (it2.hasNext()) {
            double doubleValue = function1.f(it2.next()).doubleValue();
            while (it2.hasNext()) {
                doubleValue = Math.max(doubleValue, function1.f(it2.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V> float k1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (it2.hasNext()) {
            float floatValue = function1.f(it2.next()).floatValue();
            while (it2.hasNext()) {
                floatValue = Math.max(floatValue, function1.f(it2.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> R l1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (it2.hasNext()) {
            R r = (Comparable) function1.f(it2.next());
            while (it2.hasNext()) {
                R r2 = (Comparable) function1.f(it2.next());
                if (r.compareTo(r2) < 0) {
                    r = r2;
                }
            }
            return r;
        }
        throw new NoSuchElementException();
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> R m1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R r = (Comparable) function1.f(it2.next());
        while (it2.hasNext()) {
            R r2 = (Comparable) function1.f(it2.next());
            if (r.compareTo(r2) < 0) {
                r = r2;
            }
        }
        return r;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V> Double n1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double doubleValue = function1.f(it2.next()).doubleValue();
        while (it2.hasNext()) {
            doubleValue = Math.max(doubleValue, function1.f(it2.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V> Float o1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float floatValue = function1.f(it2.next()).floatValue();
        while (it2.hasNext()) {
            floatValue = Math.max(floatValue, function1.f(it2.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V, R> R p1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(comparator, "comparator");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (it2.hasNext()) {
            R f2 = function1.f(it2.next());
            while (it2.hasNext()) {
                R f3 = function1.f(it2.next());
                if (comparator.compare(f2, f3) < 0) {
                    f2 = f3;
                }
            }
            return f2;
        }
        throw new NoSuchElementException();
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V, R> R q1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(comparator, "comparator");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R f2 = function1.f(it2.next());
        while (it2.hasNext()) {
            R f3 = function1.f(it2.next());
            if (comparator.compare(f2, f3) < 0) {
                f2 = f3;
            }
        }
        return f2;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V> Map.Entry<K, V> r1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.S3(map.entrySet(), comparator);
    }

    @SinceKotlin(version = "1.7")
    @InlineOnly
    @JvmName(name = "maxWithOrThrow")
    private static final <K, V> Map.Entry<K, V> s1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.T3(map.entrySet(), comparator);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> t1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        T t;
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            t = null;
        } else {
            T next = it2.next();
            if (!it2.hasNext()) {
                t = next;
            } else {
                Comparable comparable = (Comparable) function1.f(next);
                do {
                    T next2 = it2.next();
                    Comparable comparable2 = (Comparable) function1.f(next2);
                    if (comparable.compareTo(comparable2) > 0) {
                        next = next2;
                        comparable = comparable2;
                    }
                } while (it2.hasNext());
            }
            t = next;
        }
        return (Map.Entry) t;
    }

    @SinceKotlin(version = "1.7")
    @InlineOnly
    @JvmName(name = "minByOrThrow")
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> u1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (it2.hasNext()) {
            T next = it2.next();
            if (it2.hasNext()) {
                Comparable comparable = (Comparable) function1.f(next);
                do {
                    T next2 = it2.next();
                    Comparable comparable2 = (Comparable) function1.f(next2);
                    if (comparable.compareTo(comparable2) > 0) {
                        next = next2;
                        comparable = comparable2;
                    }
                } while (it2.hasNext());
            }
            return (Map.Entry) next;
        }
        throw new NoSuchElementException();
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V> double v1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (it2.hasNext()) {
            double doubleValue = function1.f(it2.next()).doubleValue();
            while (it2.hasNext()) {
                doubleValue = Math.min(doubleValue, function1.f(it2.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V> float w1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (it2.hasNext()) {
            float floatValue = function1.f(it2.next()).floatValue();
            while (it2.hasNext()) {
                floatValue = Math.min(floatValue, function1.f(it2.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> R x1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (it2.hasNext()) {
            R r = (Comparable) function1.f(it2.next());
            while (it2.hasNext()) {
                R r2 = (Comparable) function1.f(it2.next());
                if (r.compareTo(r2) > 0) {
                    r = r2;
                }
            }
            return r;
        }
        throw new NoSuchElementException();
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> R y1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R r = (Comparable) function1.f(it2.next());
        while (it2.hasNext()) {
            R r2 = (Comparable) function1.f(it2.next());
            if (r.compareTo(r2) > 0) {
                r = r2;
            }
        }
        return r;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V> Double z1(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double doubleValue = function1.f(it2.next()).doubleValue();
        while (it2.hasNext()) {
            doubleValue = Math.min(doubleValue, function1.f(it2.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }
}
