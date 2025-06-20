package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a-\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\b\u001a-\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\b\u001a3\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\b\f\u0010\r\u001a3\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\r\u001a\u001f\u0010\u0010\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001aF\u0010\u0016\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001aj\u0010\u001a\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00122\"\u0010\u0019\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aX\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00042(\u0010\u001d\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001aE\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040 H\u0007¢\u0006\u0004\b!\u0010\"\u001a+\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004H\u0007¢\u0006\u0004\b#\u0010$\u001a+\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004H\u0007¢\u0006\u0004\b%\u0010$\u001aP\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00042#\u0010'\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040 ¢\u0006\u0002\b&H\u0007¢\u0006\u0004\b(\u0010\"\u001a-\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010*\u001a\u00020)H\u0007¢\u0006\u0004\b+\u0010,\u001aU\u00101\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u000421\u00100\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0017\u001a\u0001\u00106\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u00102\u001a\u00028\u00012H\b\u0001\u00105\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(4\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u001403H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001a-\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u000b\u001a\u00028\u0000H\u0007¢\u0006\u0004\b8\u00109\u001aC\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u000b\u001a\u00028\u00002\u0014\b\u0002\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020:0 H\u0007¢\u0006\u0004\b<\u0010=\u001a-\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010/\u001a\u00028\u0000H\u0007¢\u0006\u0004\b>\u00109\u001a3\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\b@\u0010\r\u001a-\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010/\u001a\u00028\u0000H\u0007¢\u0006\u0004\bA\u00109\u001a3\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\bB\u0010\r\u001al\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\"\u0004\b\u0000\u0010C\"\u0004\b\u0001\u0010D\"\u0004\b\u0002\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042(\u0010E\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u001403H\u0007ø\u0001\u0000¢\u0006\u0004\bF\u0010G\u001a\u0001\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00030\u0004\"\u0004\b\u0000\u0010C\"\u0004\b\u0001\u0010D\"\u0004\b\u0002\u0010H\"\u0004\b\u0003\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00020\u00042.\u0010E\u001a*\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140JH\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001a \u0001\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00040\u0004\"\u0004\b\u0000\u0010C\"\u0004\b\u0001\u0010D\"\u0004\b\u0002\u0010H\"\u0004\b\u0003\u0010M\"\u0004\b\u0004\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00020\u00042\f\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00030\u000424\u0010E\u001a0\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140OH\u0007ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001aº\u0001\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00050\u0004\"\u0004\b\u0000\u0010C\"\u0004\b\u0001\u0010D\"\u0004\b\u0002\u0010H\"\u0004\b\u0003\u0010M\"\u0004\b\u0004\u0010R\"\u0004\b\u0005\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00020\u00042\f\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00030\u00042\f\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00040\u00042:\u0010E\u001a6\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140TH\u0007ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001a-\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010X\u001a\u00020WH\u0007¢\u0006\u0004\bY\u0010Z\u001a-\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010X\u001a\u00020WH\u0007¢\u0006\u0004\b[\u0010Z\u001ag\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u000427\u0010E\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\\\u0010\u001f\u001ap\u0010]\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042F\u00105\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(4\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u001403H\u0007ø\u0001\u0000¢\u0006\u0004\b]\u0010^\u001a%\u0010_\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\b_\u0010$\u001a-\u0010a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010`\u001a\u00020)H\u0007¢\u0006\u0004\ba\u0010,\u001a%\u0010b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\bb\u0010$\u001a-\u0010c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010`\u001a\u00020)H\u0007¢\u0006\u0004\bc\u0010,\u001a%\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\bd\u0010$\u0002\u0004\n\u0002\b\u0019¨\u0006e"}, d2 = {"", "p", "()Ljava/lang/Void;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/coroutines/CoroutineContext;", "context", "q", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/flow/Flow;", "y", "J", "fallback", "r", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "s", "", "G", "(Lkotlinx/coroutines/flow/Flow;)V", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "onEach", "H", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)V", "", "onError", "I", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "R", "mapper", "l", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function1;", "g", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "o", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "m", "Lkotlin/ExtensionFunctionType;", "transformer", "f", "", "count", "D", "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/ParameterName;", "name", "value", "action", "n", "initial", "Lkotlin/Function3;", "accumulator", "operation", "B", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "t", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "", "predicate", "u", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "E", "other", "F", "h", "i", "T1", "T2", "transform", "b", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "T3", "other2", "Lkotlin/Function4;", "c", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "T4", "other3", "Lkotlin/Function5;", "d", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "T5", "other4", "Lkotlin/Function6;", "e", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "", "timeMillis", "k", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "j", "K", "C", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "w", "bufferSize", "x", "z", "A", "a", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__MigrationKt {
    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    public static final <T> Flow<T> A(@NotNull Flow<? extends T> flow, int i2) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(expression = "scan(initial, operation)", imports = {}))
    public static final <T, R> Flow<R> B(@NotNull Flow<? extends T> flow, R r, @NotNull @BuilderInference Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @ReplaceWith(expression = "runningReduce(operation)", imports = {}))
    public static final <T> Flow<T> C(@NotNull Flow<? extends T> flow, @NotNull Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3) {
        return FlowKt.z1(flow, function3);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(expression = "drop(count)", imports = {}))
    public static final <T> Flow<T> D(@NotNull Flow<? extends T> flow, int i2) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(expression = "onStart { emit(value) }", imports = {}))
    public static final <T> Flow<T> E(@NotNull Flow<? extends T> flow, T t) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onStart { emitAll(other) }", imports = {}))
    public static final <T> Flow<T> F(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void G(@NotNull Flow<? extends T> flow) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void H(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void I(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function22) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    public static final <T> Flow<T> J(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(expression = "this.flatMapLatest(transform)", imports = {}))
    public static final <T, R> Flow<R> K(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.b2(flow, new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(function2, (Continuation) null));
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    public static final <T> Flow<T> a(@NotNull Flow<? extends T> flow) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "this.combine(other, transform)", imports = {}))
    public static final <T1, T2, R> Flow<R> b(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt.D(flow, flow2, function3);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, transform)", imports = {}))
    public static final <T1, T2, T3, R> Flow<R> c(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        return FlowKt.E(flow, flow2, flow3, function4);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final <T1, T2, T3, T4, R> Flow<R> d(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        return FlowKt.F(flow, flow2, flow3, flow4, function5);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final <T1, T2, T3, T4, T5, R> Flow<R> e(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Flow<? extends T5> flow5, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        return FlowKt.G(flow, flow2, flow3, flow4, flow5, function6);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(expression = "let(transformer)", imports = {}))
    public static final <T, R> Flow<R> f(@NotNull Flow<? extends T> flow, @NotNull Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> function1) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    public static final <T, R> Flow<R> g(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, ? extends Flow<? extends R>> function1) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emit(value) }", imports = {}))
    public static final <T> Flow<T> h(@NotNull Flow<? extends T> flow, T t) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onCompletion { if (it == null) emitAll(other) }", imports = {}))
    public static final <T> Flow<T> i(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onEach { delay(timeMillis) }", imports = {}))
    public static final <T> Flow<T> j(@NotNull Flow<? extends T> flow, long j2) {
        return FlowKt.e1(flow, new FlowKt__MigrationKt$delayEach$1(j2, (Continuation<? super FlowKt__MigrationKt$delayEach$1>) null));
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onStart { delay(timeMillis) }", imports = {}))
    public static final <T> Flow<T> k(@NotNull Flow<? extends T> flow, long j2) {
        return FlowKt.l1(flow, new FlowKt__MigrationKt$delayFlow$1(j2, (Continuation<? super FlowKt__MigrationKt$delayFlow$1>) null));
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    public static final <T, R> Flow<R> l(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    public static final <T> Flow<T> m(@NotNull Flow<? extends Flow<? extends T>> flow) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(expression = "collect(action)", imports = {}))
    public static final <T> void n(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    public static final <T> Flow<T> o(@NotNull Flow<? extends Flow<? extends T>> flow) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public static final Void p() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> Flow<T> q(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final <T> Flow<T> r(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final <T> Flow<T> s(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emit(fallback) }", imports = {}))
    public static final <T> Flow<T> t(@NotNull Flow<? extends T> flow, T t) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    public static final <T> Flow<T> u(@NotNull Flow<? extends T> flow, T t, @NotNull Function1<? super Throwable, Boolean> function1) {
        return FlowKt.u(flow, new FlowKt__MigrationKt$onErrorReturn$2(function1, t, (Continuation<? super FlowKt__MigrationKt$onErrorReturn$2>) null));
    }

    public static /* synthetic */ Flow v(Flow flow, Object obj, Function1 function1, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            function1 = FlowKt__MigrationKt$onErrorReturn$1.X;
        }
        return FlowKt.j1(flow, obj, function1);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, 0)", imports = {}))
    public static final <T> Flow<T> w(@NotNull Flow<? extends T> flow) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    public static final <T> Flow<T> x(@NotNull Flow<? extends T> flow, int i2) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> Flow<T> y(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    public static final <T> Flow<T> z(@NotNull Flow<? extends T> flow) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }
}
