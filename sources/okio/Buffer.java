package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.extractor.ts.PsExtractor;
import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.base.Ascii;
import com.itextpdf.tool.xml.html.HTML;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Typography;
import net.lingala.zip4j.util.InternalZipConstants;
import okio.internal._BufferKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002æ\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001d\u0010\u0019J\u000f\u0010\u001e\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001e\u0010\u0019J\u000f\u0010\u001f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0001H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010(J+\u0010+\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u001a2\b\b\u0002\u0010*\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b+\u0010,J'\u0010-\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u00002\b\b\u0002\u0010*\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b-\u0010.J\u001f\u0010/\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u00002\b\b\u0002\u0010*\u001a\u00020\t¢\u0006\u0004\b/\u00100J!\u00101\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u001a2\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b1\u00102J\u0015\u00103\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b3\u00104J\u001d\u00105\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\t¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;J\u0018\u0010=\u001a\u0002092\u0006\u0010<\u001a\u00020\tH\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\tH\u0016¢\u0006\u0004\bE\u00108J\u000f\u0010F\u001a\u00020?H\u0016¢\u0006\u0004\bF\u0010AJ\u000f\u0010G\u001a\u00020BH\u0016¢\u0006\u0004\bG\u0010DJ\u000f\u0010H\u001a\u00020\tH\u0016¢\u0006\u0004\bH\u00108J\u000f\u0010I\u001a\u00020\tH\u0016¢\u0006\u0004\bI\u00108J\u000f\u0010J\u001a\u00020\tH\u0016¢\u0006\u0004\bJ\u00108J\u000f\u0010K\u001a\u00020\u0012H\u0016¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\bM\u0010NJ\u0017\u0010Q\u001a\u00020B2\u0006\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bQ\u0010RJ\u001f\u0010T\u001a\u00020\r2\u0006\u0010S\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\bT\u0010UJ\u0017\u0010W\u001a\u00020\t2\u0006\u0010S\u001a\u00020VH\u0016¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u00020\u0010H\u0016¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b[\u0010\\J\u0017\u0010_\u001a\u00020\u00102\u0006\u0010^\u001a\u00020]H\u0016¢\u0006\u0004\b_\u0010`J\u001f\u0010a\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010^\u001a\u00020]H\u0016¢\u0006\u0004\ba\u0010bJ\u0011\u0010c\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\bc\u0010ZJ\u000f\u0010d\u001a\u00020\u0010H\u0016¢\u0006\u0004\bd\u0010ZJ\u0017\u0010f\u001a\u00020\u00102\u0006\u0010e\u001a\u00020\tH\u0016¢\u0006\u0004\bf\u0010\\J\u000f\u0010g\u001a\u00020BH\u0016¢\u0006\u0004\bg\u0010DJ\u000f\u0010i\u001a\u00020hH\u0016¢\u0006\u0004\bi\u0010jJ\u0017\u0010k\u001a\u00020h2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\bk\u0010lJ\u0017\u0010m\u001a\u00020B2\u0006\u0010S\u001a\u00020hH\u0016¢\u0006\u0004\bm\u0010nJ\u0017\u0010o\u001a\u00020\r2\u0006\u0010S\u001a\u00020hH\u0016¢\u0006\u0004\bo\u0010pJ'\u0010m\u001a\u00020B2\u0006\u0010S\u001a\u00020h2\u0006\u0010*\u001a\u00020B2\u0006\u0010\n\u001a\u00020BH\u0016¢\u0006\u0004\bm\u0010qJ\u0017\u0010m\u001a\u00020B2\u0006\u0010S\u001a\u00020rH\u0016¢\u0006\u0004\bm\u0010sJ\r\u0010t\u001a\u00020\r¢\u0006\u0004\bt\u0010\u0006J\u0017\u0010u\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\bu\u0010\"J\u0017\u0010w\u001a\u00020\u00002\u0006\u0010v\u001a\u00020\u0012H\u0016¢\u0006\u0004\bw\u0010xJ'\u0010y\u001a\u00020\u00002\u0006\u0010v\u001a\u00020\u00122\u0006\u0010*\u001a\u00020B2\u0006\u0010\n\u001a\u00020BH\u0016¢\u0006\u0004\by\u0010zJ\u0017\u0010|\u001a\u00020\u00002\u0006\u0010{\u001a\u00020\u0010H\u0016¢\u0006\u0004\b|\u0010}J*\u0010\u0001\u001a\u00020\u00002\u0006\u0010{\u001a\u00020\u00102\u0006\u0010~\u001a\u00020B2\u0006\u0010\u001a\u00020BH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020BH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\"\u0010\u0001\u001a\u00020\u00002\u0006\u0010{\u001a\u00020\u00102\u0006\u0010^\u001a\u00020]H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J2\u0010\u0001\u001a\u00020\u00002\u0006\u0010{\u001a\u00020\u00102\u0006\u0010~\u001a\u00020B2\u0006\u0010\u001a\u00020B2\u0006\u0010^\u001a\u00020]H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020hH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J+\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020h2\u0006\u0010*\u001a\u00020B2\u0006\u0010\n\u001a\u00020BH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010\u0001\u001a\u00020B2\u0007\u0010\u0001\u001a\u00020rH\u0016¢\u0006\u0005\b\u0001\u0010sJ\u001c\u0010\u0001\u001a\u00020\t2\b\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J$\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020BH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020BH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020BH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020BH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020BH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010 \u0001\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0006\b \u0001\u0010\u0001J\u001c\u0010£\u0001\u001a\u00030¢\u00012\u0007\u0010¡\u0001\u001a\u00020BH\u0000¢\u0006\u0006\b£\u0001\u0010¤\u0001J\"\u0010¥\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0005\b¥\u0001\u0010UJ\"\u0010¦\u0001\u001a\u00020\t2\u0006\u0010S\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u001b\u0010¨\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u000209H\u0016¢\u0006\u0006\b¨\u0001\u0010©\u0001J$\u0010«\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u0002092\u0007\u0010ª\u0001\u001a\u00020\tH\u0016¢\u0006\u0006\b«\u0001\u0010¬\u0001J-\u0010®\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u0002092\u0007\u0010ª\u0001\u001a\u00020\t2\u0007\u0010­\u0001\u001a\u00020\tH\u0016¢\u0006\u0006\b®\u0001\u0010¯\u0001J\u001b\u0010±\u0001\u001a\u00020\t2\u0007\u0010°\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0006\b±\u0001\u0010²\u0001J$\u0010³\u0001\u001a\u00020\t2\u0007\u0010°\u0001\u001a\u00020\u00122\u0007\u0010ª\u0001\u001a\u00020\tH\u0016¢\u0006\u0006\b³\u0001\u0010´\u0001J\u001b\u0010¶\u0001\u001a\u00020\t2\u0007\u0010µ\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0006\b¶\u0001\u0010²\u0001J$\u0010·\u0001\u001a\u00020\t2\u0007\u0010µ\u0001\u001a\u00020\u00122\u0007\u0010ª\u0001\u001a\u00020\tH\u0016¢\u0006\u0006\b·\u0001\u0010´\u0001J#\u0010¸\u0001\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\t2\u0007\u0010°\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0006\b¸\u0001\u0010¹\u0001J4\u0010»\u0001\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\t2\u0007\u0010°\u0001\u001a\u00020\u00122\u0007\u0010º\u0001\u001a\u00020B2\u0006\u0010\n\u001a\u00020BH\u0016¢\u0006\u0006\b»\u0001\u0010¼\u0001J\u0011\u0010½\u0001\u001a\u00020\rH\u0016¢\u0006\u0005\b½\u0001\u0010\u0006J\u0011\u0010¾\u0001\u001a\u00020\u000bH\u0016¢\u0006\u0005\b¾\u0001\u0010 J\u0011\u0010¿\u0001\u001a\u00020\rH\u0016¢\u0006\u0005\b¿\u0001\u0010\u0006J\u0013\u0010Á\u0001\u001a\u00030À\u0001H\u0016¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J\u000f\u0010Ã\u0001\u001a\u00020\u0012¢\u0006\u0005\bÃ\u0001\u0010LJ\u000f\u0010Ä\u0001\u001a\u00020\u0012¢\u0006\u0005\bÄ\u0001\u0010LJ\u000f\u0010Å\u0001\u001a\u00020\u0012¢\u0006\u0005\bÅ\u0001\u0010LJ\u000f\u0010Æ\u0001\u001a\u00020\u0012¢\u0006\u0005\bÆ\u0001\u0010LJ\u0018\u0010Ç\u0001\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0006\bÇ\u0001\u0010È\u0001J\u0018\u0010É\u0001\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0006\bÉ\u0001\u0010È\u0001J\u0018\u0010Ê\u0001\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0006\bÊ\u0001\u0010È\u0001J\u001f\u0010Í\u0001\u001a\u00020\u000b2\n\u0010Ì\u0001\u001a\u0005\u0018\u00010Ë\u0001H\u0002¢\u0006\u0006\bÍ\u0001\u0010Î\u0001J\u0011\u0010Ï\u0001\u001a\u00020BH\u0016¢\u0006\u0005\bÏ\u0001\u0010DJ\u0011\u0010Ð\u0001\u001a\u00020\u0010H\u0016¢\u0006\u0005\bÐ\u0001\u0010ZJ\u000f\u0010Ñ\u0001\u001a\u00020\u0000¢\u0006\u0005\bÑ\u0001\u0010\u0019J\u0011\u0010Ò\u0001\u001a\u00020\u0000H\u0016¢\u0006\u0005\bÒ\u0001\u0010\u0019J\u000f\u0010Ó\u0001\u001a\u00020\u0012¢\u0006\u0005\bÓ\u0001\u0010LJ\u0018\u0010Ô\u0001\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020B¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J\u001f\u0010Ø\u0001\u001a\u00030Ö\u00012\n\b\u0002\u0010×\u0001\u001a\u00030Ö\u0001H\u0007¢\u0006\u0006\bØ\u0001\u0010Ù\u0001J\u001f\u0010Ú\u0001\u001a\u00030Ö\u00012\n\b\u0002\u0010×\u0001\u001a\u00030Ö\u0001H\u0007¢\u0006\u0006\bÚ\u0001\u0010Ù\u0001J\u001a\u0010\u0001\u001a\u0002092\u0007\u0010Û\u0001\u001a\u00020\tH\u0007¢\u0006\u0005\b\u0001\u0010>J\u0011\u0010Ü\u0001\u001a\u00020\tH\u0007¢\u0006\u0005\bÜ\u0001\u00108R\u001c\u0010Þ\u0001\u001a\u0005\u0018\u00010¢\u00018\u0000@\u0000X\u000e¢\u0006\b\n\u0006\b\u0001\u0010Ý\u0001R0\u0010ã\u0001\u001a\u00020\t2\u0007\u0010ß\u0001\u001a\u00020\t8G@@X\u000e¢\u0006\u0016\n\u0006\bà\u0001\u0010Ê\u0001\u001a\u0005\bá\u0001\u00108\"\u0005\bâ\u0001\u0010\"R\u0016\u0010å\u0001\u001a\u00020\u00008VX\u0004¢\u0006\u0007\u001a\u0005\bä\u0001\u0010\u0019¨\u0006ç\u0001"}, d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "<init>", "()V", "Ljava/io/InputStream;", "input", "", "byteCount", "", "forever", "", "k0", "(Ljava/io/InputStream;JZ)V", "", "algorithm", "Lokio/ByteString;", "v", "(Ljava/lang/String;)Lokio/ByteString;", "key", "A", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "g", "()Lokio/Buffer;", "Ljava/io/OutputStream;", "M2", "()Ljava/io/OutputStream;", "x", "w", "o0", "()Z", "I2", "(J)V", "request", "(J)Z", "peek", "()Lokio/BufferedSource;", "z", "()Ljava/io/InputStream;", "out", "offset", "p", "(Ljava/io/OutputStream;JJ)Lokio/Buffer;", "r", "(Lokio/Buffer;JJ)Lokio/Buffer;", "q", "(Lokio/Buffer;J)Lokio/Buffer;", "U2", "(Ljava/io/OutputStream;J)Lokio/Buffer;", "g0", "(Ljava/io/InputStream;)Lokio/Buffer;", "h0", "(Ljava/io/InputStream;J)Lokio/Buffer;", "f", "()J", "", "readByte", "()B", "pos", "y", "(J)B", "", "readShort", "()S", "", "readInt", "()I", "readLong", "j2", "R1", "p2", "H0", "Q2", "A1", "()Lokio/ByteString;", "K", "(J)Lokio/ByteString;", "Lokio/Options;", "options", "S2", "(Lokio/Options;)I", "sink", "w0", "(Lokio/Buffer;J)V", "Lokio/Sink;", "r2", "(Lokio/Sink;)J", "a2", "()Ljava/lang/String;", "B", "(J)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "g1", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "d2", "(JLjava/nio/charset/Charset;)Ljava/lang/String;", "E0", "O1", "limit", "M0", "t1", "", "b0", "()[B", "U1", "(J)[B", "read", "([B)I", "readFully", "([B)V", "([BII)I", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", "d", "skip", "byteString", "c1", "(Lokio/ByteString;)Lokio/Buffer;", "d1", "(Lokio/ByteString;II)Lokio/Buffer;", "string", "W2", "(Ljava/lang/String;)Lokio/Buffer;", "beginIndex", "endIndex", "X2", "(Ljava/lang/String;II)Lokio/Buffer;", "codePoint", "Y2", "(I)Lokio/Buffer;", "P2", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/Buffer;", "J2", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Lokio/Buffer;", "source", "h1", "([B)Lokio/Buffer;", "j1", "([BII)Lokio/Buffer;", "write", "Lokio/Source;", "y1", "(Lokio/Source;)J", "e1", "(Lokio/Source;J)Lokio/Buffer;", "b", "k1", "s", "q2", "w2", "i", "F1", "T1", "e2", "(J)Lokio/Buffer;", "f2", "l1", "D1", "minimumCapacity", "Lokio/Segment;", "Y0", "(I)Lokio/Segment;", "u1", "n2", "(Lokio/Buffer;J)J", "N2", "(B)J", "fromIndex", "u0", "(BJ)J", "toIndex", "y0", "(BJJ)J", "bytes", "l0", "(Lokio/ByteString;)J", "E", "(Lokio/ByteString;J)J", "targetBytes", "z0", "G2", "b1", "(JLokio/ByteString;)Z", "bytesOffset", "S1", "(JLokio/ByteString;II)Z", "flush", "isOpen", "close", "Lokio/Timeout;", "j", "()Lokio/Timeout;", "L", "D0", "G0", "K0", "F", "(Lokio/ByteString;)Lokio/ByteString;", "G", "J", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "h", "e", "R0", "S0", "(I)Lokio/ByteString;", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "r0", "(Lokio/Buffer$UnsafeCursor;)Lokio/Buffer$UnsafeCursor;", "S", "index", "c", "Lokio/Segment;", "head", "<set-?>", "X", "L0", "C0", "size", "m", "buffer", "UnsafeCursor", "okio"}, k = 1, mv = {1, 5, 1})
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    private long X;
    @Nullable
    @JvmField
    public Segment s;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0003R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b+\u0010)¨\u0006-"}, d2 = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "<init>", "()V", "", "d", "()I", "", "offset", "f", "(J)I", "newSize", "e", "(J)J", "minByteCount", "b", "(I)J", "", "close", "Lokio/Buffer;", "s", "Lokio/Buffer;", "buffer", "", "X", "Z", "readWrite", "Lokio/Segment;", "Y", "Lokio/Segment;", "c", "()Lokio/Segment;", "h", "(Lokio/Segment;)V", "segment", "J", "", "X2", "[B", "data", "Y2", "I", "start", "Z2", "end", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class UnsafeCursor implements Closeable {
        @JvmField
        public boolean X;
        @Nullable
        @JvmField
        public byte[] X2;
        @Nullable
        private Segment Y;
        @JvmField
        public int Y2 = -1;
        @JvmField
        public long Z = -1;
        @JvmField
        public int Z2 = -1;
        @Nullable
        @JvmField
        public Buffer s;

        public final long b(int i2) {
            boolean z = false;
            if (i2 > 0) {
                if (i2 <= 8192) {
                    z = true;
                }
                if (z) {
                    Buffer buffer = this.s;
                    if (buffer == null) {
                        throw new IllegalStateException("not attached to a buffer".toString());
                    } else if (this.X) {
                        long L0 = buffer.L0();
                        Segment Y0 = buffer.Y0(i2);
                        int i3 = 8192 - Y0.f31384c;
                        Y0.f31384c = 8192;
                        long j2 = (long) i3;
                        buffer.C0(L0 + j2);
                        h(Y0);
                        this.Z = L0;
                        this.X2 = Y0.f31382a;
                        this.Y2 = 8192 - i3;
                        this.Z2 = 8192;
                        return j2;
                    } else {
                        throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                    }
                } else {
                    throw new IllegalArgumentException(Intrinsics.C("minByteCount > Segment.SIZE: ", Integer.valueOf(i2)).toString());
                }
            } else {
                throw new IllegalArgumentException(Intrinsics.C("minByteCount <= 0: ", Integer.valueOf(i2)).toString());
            }
        }

        @Nullable
        public final Segment c() {
            return this.Y;
        }

        public void close() {
            if (this.s != null) {
                this.s = null;
                h((Segment) null);
                this.Z = -1;
                this.X2 = null;
                this.Y2 = -1;
                this.Z2 = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final int d() {
            long j2 = this.Z;
            Buffer buffer = this.s;
            Intrinsics.m(buffer);
            if (j2 != buffer.L0()) {
                long j3 = this.Z;
                return f(j3 == -1 ? 0 : j3 + ((long) (this.Z2 - this.Y2)));
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        public final long e(long j2) {
            long j3 = j2;
            Buffer buffer = this.s;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else if (this.X) {
                long L0 = buffer.L0();
                int i2 = 1;
                int i3 = (j3 > L0 ? 1 : (j3 == L0 ? 0 : -1));
                if (i3 <= 0) {
                    if (j3 >= 0) {
                        long j4 = L0 - j3;
                        while (true) {
                            if (j4 <= 0) {
                                break;
                            }
                            Segment segment = buffer.s;
                            Intrinsics.m(segment);
                            Segment segment2 = segment.f31388g;
                            Intrinsics.m(segment2);
                            int i4 = segment2.f31384c;
                            long j5 = (long) (i4 - segment2.f31383b);
                            if (j5 > j4) {
                                segment2.f31384c = i4 - ((int) j4);
                                break;
                            }
                            buffer.s = segment2.b();
                            SegmentPool.d(segment2);
                            j4 -= j5;
                        }
                        h((Segment) null);
                        this.Z = j3;
                        this.X2 = null;
                        this.Y2 = -1;
                        this.Z2 = -1;
                    } else {
                        throw new IllegalArgumentException(Intrinsics.C("newSize < 0: ", Long.valueOf(j2)).toString());
                    }
                } else if (i3 > 0) {
                    long j6 = j3 - L0;
                    boolean z = true;
                    while (j6 > 0) {
                        Segment Y0 = buffer.Y0(i2);
                        int min = (int) Math.min(j6, (long) (8192 - Y0.f31384c));
                        Y0.f31384c += min;
                        j6 -= (long) min;
                        if (z) {
                            h(Y0);
                            this.Z = L0;
                            this.X2 = Y0.f31382a;
                            int i5 = Y0.f31384c;
                            this.Y2 = i5 - min;
                            this.Z2 = i5;
                            i2 = 1;
                            z = false;
                        } else {
                            i2 = 1;
                        }
                    }
                }
                buffer.C0(j3);
                return L0;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
        }

        public final int f(long j2) {
            Segment segment;
            Buffer buffer = this.s;
            if (buffer != null) {
                int i2 = (j2 > -1 ? 1 : (j2 == -1 ? 0 : -1));
                if (i2 < 0 || j2 > buffer.L0()) {
                    throw new ArrayIndexOutOfBoundsException("offset=" + j2 + " > size=" + buffer.L0());
                } else if (i2 == 0 || j2 == buffer.L0()) {
                    h((Segment) null);
                    this.Z = j2;
                    this.X2 = null;
                    this.Y2 = -1;
                    this.Z2 = -1;
                    return -1;
                } else {
                    long L0 = buffer.L0();
                    Segment segment2 = buffer.s;
                    long j3 = 0;
                    if (c() != null) {
                        long j4 = this.Z;
                        int i3 = this.Y2;
                        Segment c2 = c();
                        Intrinsics.m(c2);
                        long j5 = j4 - ((long) (i3 - c2.f31383b));
                        if (j5 > j2) {
                            segment = segment2;
                            segment2 = c();
                            L0 = j5;
                        } else {
                            segment = c();
                            j3 = j5;
                        }
                    } else {
                        segment = segment2;
                    }
                    if (L0 - j2 > j2 - j3) {
                        while (true) {
                            Intrinsics.m(segment);
                            int i4 = segment.f31384c;
                            int i5 = segment.f31383b;
                            if (j2 < ((long) (i4 - i5)) + j3) {
                                break;
                            }
                            j3 += (long) (i4 - i5);
                            segment = segment.f31387f;
                        }
                    } else {
                        while (L0 > j2) {
                            Intrinsics.m(segment2);
                            segment2 = segment2.f31388g;
                            Intrinsics.m(segment2);
                            L0 -= (long) (segment2.f31384c - segment2.f31383b);
                        }
                        j3 = L0;
                        segment = segment2;
                    }
                    if (this.X) {
                        Intrinsics.m(segment);
                        if (segment.f31385d) {
                            Segment f2 = segment.f();
                            if (buffer.s == segment) {
                                buffer.s = f2;
                            }
                            segment = segment.c(f2);
                            Segment segment3 = segment.f31388g;
                            Intrinsics.m(segment3);
                            segment3.b();
                        }
                    }
                    h(segment);
                    this.Z = j2;
                    Intrinsics.m(segment);
                    this.X2 = segment.f31382a;
                    int i6 = segment.f31383b + ((int) (j2 - j3));
                    this.Y2 = i6;
                    int i7 = segment.f31384c;
                    this.Z2 = i7;
                    return i7 - i6;
                }
            } else {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
        }

        public final void h(@Nullable Segment segment) {
            this.Y = segment;
        }
    }

    private final ByteString A(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.J(), str));
            Segment segment = this.s;
            if (segment != null) {
                byte[] bArr = segment.f31382a;
                int i2 = segment.f31383b;
                instance.update(bArr, i2, segment.f31384c - i2);
                Segment segment2 = segment.f31387f;
                while (true) {
                    Intrinsics.m(segment2);
                    if (segment2 == segment) {
                        break;
                    }
                    byte[] bArr2 = segment2.f31382a;
                    int i3 = segment2.f31383b;
                    instance.update(bArr2, i3, segment2.f31384c - i3);
                    segment2 = segment2.f31387f;
                }
            }
            byte[] doFinal = instance.doFinal();
            Intrinsics.o(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static /* synthetic */ Buffer V2(Buffer buffer, OutputStream outputStream, long j2, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            j2 = buffer.X;
        }
        return buffer.U2(outputStream, j2);
    }

    public static /* synthetic */ UnsafeCursor c0(Buffer buffer, UnsafeCursor unsafeCursor, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            unsafeCursor = _UtilKt.g();
        }
        return buffer.S(unsafeCursor);
    }

    private final void k0(InputStream inputStream, long j2, boolean z) throws IOException {
        while (true) {
            if (j2 > 0 || z) {
                Segment Y0 = Y0(1);
                int read = inputStream.read(Y0.f31382a, Y0.f31384c, (int) Math.min(j2, (long) (8192 - Y0.f31384c)));
                if (read == -1) {
                    if (Y0.f31383b == Y0.f31384c) {
                        this.s = Y0.b();
                        SegmentPool.d(Y0);
                    }
                    if (!z) {
                        throw new EOFException();
                    }
                    return;
                }
                Y0.f31384c += read;
                long j3 = (long) read;
                this.X += j3;
                j2 -= j3;
            } else {
                return;
            }
        }
    }

    public static /* synthetic */ Buffer s(Buffer buffer, OutputStream outputStream, long j2, long j3, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            j3 = buffer.X - j4;
        }
        return buffer.p(outputStream, j4, j3);
    }

    public static /* synthetic */ UnsafeCursor s0(Buffer buffer, UnsafeCursor unsafeCursor, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            unsafeCursor = _UtilKt.g();
        }
        return buffer.r0(unsafeCursor);
    }

    public static /* synthetic */ Buffer t(Buffer buffer, Buffer buffer2, long j2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        return buffer.q(buffer2, j2);
    }

    public static /* synthetic */ Buffer u(Buffer buffer, Buffer buffer2, long j2, long j3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        return buffer.r(buffer2, j2, j3);
    }

    private final ByteString v(String str) {
        MessageDigest instance = MessageDigest.getInstance(str);
        Segment segment = this.s;
        if (segment != null) {
            byte[] bArr = segment.f31382a;
            int i2 = segment.f31383b;
            instance.update(bArr, i2, segment.f31384c - i2);
            Segment segment2 = segment.f31387f;
            while (true) {
                Intrinsics.m(segment2);
                if (segment2 == segment) {
                    break;
                }
                byte[] bArr2 = segment2.f31382a;
                int i3 = segment2.f31383b;
                instance.update(bArr2, i3, segment2.f31384c - i3);
                segment2 = segment2.f31387f;
            }
        }
        byte[] digest = instance.digest();
        Intrinsics.o(digest, "messageDigest.digest()");
        return new ByteString(digest);
    }

    @NotNull
    public ByteString A1() {
        return K(L0());
    }

    @NotNull
    public String B(long j2) throws EOFException {
        return d2(j2, Charsets.f29053b);
    }

    public final void C0(long j2) {
        this.X = j2;
    }

    @NotNull
    public final ByteString D0() {
        return v("SHA-1");
    }

    @NotNull
    /* renamed from: D1 */
    public Buffer z1(long j2) {
        if (j2 == 0) {
            return writeByte(48);
        }
        long j3 = (j2 >>> 1) | j2;
        long j4 = j3 | (j3 >>> 2);
        long j5 = j4 | (j4 >>> 4);
        long j6 = j5 | (j5 >>> 8);
        long j7 = j6 | (j6 >>> 16);
        long j8 = j7 | (j7 >>> 32);
        long j9 = j8 - ((j8 >>> 1) & 6148914691236517205L);
        long j10 = ((j9 >>> 2) & 3689348814741910323L) + (j9 & 3689348814741910323L);
        long j11 = ((j10 >>> 4) + j10) & 1085102592571150095L;
        long j12 = j11 + (j11 >>> 8);
        long j13 = j12 + (j12 >>> 16);
        int i2 = (int) ((((j13 & 63) + ((j13 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment Y0 = Y0(i2);
        byte[] bArr = Y0.f31382a;
        int i3 = Y0.f31384c;
        for (int i4 = (i3 + i2) - 1; i4 >= i3; i4--) {
            bArr[i4] = _BufferKt.g0()[(int) (15 & j2)];
            j2 >>>= 4;
        }
        Y0.f31384c += i2;
        C0(L0() + ((long) i2));
        return this;
    }

    public long E(@NotNull ByteString byteString, long j2) throws IOException {
        Intrinsics.p(byteString, "bytes");
        if (byteString.m0() > 0) {
            long j3 = 0;
            if (j2 >= 0) {
                Segment segment = this.s;
                if (segment != null) {
                    if (L0() - j2 < j2) {
                        long L0 = L0();
                        while (L0 > j2) {
                            segment = segment.f31388g;
                            Intrinsics.m(segment);
                            L0 -= (long) (segment.f31384c - segment.f31383b);
                        }
                        byte[] J = byteString.J();
                        byte b2 = J[0];
                        int m0 = byteString.m0();
                        long L02 = (L0() - ((long) m0)) + 1;
                        Segment segment2 = segment;
                        long j4 = L0;
                        long j5 = j2;
                        while (j4 < L02) {
                            byte[] bArr = segment2.f31382a;
                            long j6 = j5;
                            int min = (int) Math.min((long) segment2.f31384c, (((long) segment2.f31383b) + L02) - j4);
                            int i2 = (int) ((((long) segment2.f31383b) + j6) - j4);
                            if (i2 < min) {
                                while (true) {
                                    int i3 = i2 + 1;
                                    if (bArr[i2] == b2 && _BufferKt.i0(segment2, i3, J, 1, m0)) {
                                        return ((long) (i2 - segment2.f31383b)) + j4;
                                    }
                                    if (i3 >= min) {
                                        break;
                                    }
                                    i2 = i3;
                                }
                            }
                            j4 += (long) (segment2.f31384c - segment2.f31383b);
                            segment2 = segment2.f31387f;
                            Intrinsics.m(segment2);
                            j5 = j4;
                        }
                    } else {
                        while (true) {
                            long j7 = ((long) (segment.f31384c - segment.f31383b)) + j3;
                            if (j7 > j2) {
                                break;
                            }
                            segment = segment.f31387f;
                            Intrinsics.m(segment);
                            j3 = j7;
                        }
                        byte[] J2 = byteString.J();
                        byte b3 = J2[0];
                        int m02 = byteString.m0();
                        long L03 = (L0() - ((long) m02)) + 1;
                        long j8 = j3;
                        long j9 = j2;
                        while (j8 < L03) {
                            byte[] bArr2 = segment.f31382a;
                            long j10 = L03;
                            int min2 = (int) Math.min((long) segment.f31384c, (((long) segment.f31383b) + L03) - j8);
                            int i4 = (int) ((((long) segment.f31383b) + j9) - j8);
                            if (i4 < min2) {
                                while (true) {
                                    int i5 = i4 + 1;
                                    if (bArr2[i4] == b3 && _BufferKt.i0(segment, i5, J2, 1, m02)) {
                                        return ((long) (i4 - segment.f31383b)) + j8;
                                    }
                                    if (i5 >= min2) {
                                        break;
                                    }
                                    i4 = i5;
                                }
                            }
                            j8 += (long) (segment.f31384c - segment.f31383b);
                            segment = segment.f31387f;
                            Intrinsics.m(segment);
                            j9 = j8;
                            L03 = j10;
                        }
                    }
                }
                return -1;
            }
            throw new IllegalArgumentException(Intrinsics.C("fromIndex < 0: ", Long.valueOf(j2)).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    @Nullable
    public String E0() throws EOFException {
        long N2 = N2((byte) 10);
        if (N2 != -1) {
            return _BufferKt.j0(this, N2);
        }
        if (L0() != 0) {
            return B(L0());
        }
        return null;
    }

    @NotNull
    public final ByteString F(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "key");
        return A(InternalZipConstants.f30712f, byteString);
    }

    @NotNull
    /* renamed from: F1 */
    public Buffer writeInt(int i2) {
        Segment Y0 = Y0(4);
        byte[] bArr = Y0.f31382a;
        int i3 = Y0.f31384c;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        bArr[i3 + 1] = (byte) ((i2 >>> 16) & 255);
        bArr[i3 + 2] = (byte) ((i2 >>> 8) & 255);
        bArr[i3 + 3] = (byte) (i2 & 255);
        Y0.f31384c = i3 + 4;
        C0(L0() + 4);
        return this;
    }

    @NotNull
    public final ByteString G(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "key");
        return A("HmacSHA256", byteString);
    }

    @NotNull
    public final ByteString G0() {
        return v("SHA-256");
    }

    public long G2(@NotNull ByteString byteString, long j2) {
        long j3;
        int i2;
        Intrinsics.p(byteString, "targetBytes");
        long j4 = 0;
        if (j2 >= 0) {
            Segment segment = this.s;
            if (segment == null) {
                return -1;
            }
            if (L0() - j2 < j2) {
                j3 = L0();
                while (j3 > j2) {
                    segment = segment.f31388g;
                    Intrinsics.m(segment);
                    j3 -= (long) (segment.f31384c - segment.f31383b);
                }
                if (byteString.m0() == 2) {
                    byte q = byteString.q(0);
                    byte q2 = byteString.q(1);
                    while (j3 < L0()) {
                        byte[] bArr = segment.f31382a;
                        i2 = (int) ((((long) segment.f31383b) + j2) - j3);
                        int i3 = segment.f31384c;
                        while (i2 < i3) {
                            byte b2 = bArr[i2];
                            if (!(b2 == q || b2 == q2)) {
                                i2++;
                            }
                        }
                        j3 += (long) (segment.f31384c - segment.f31383b);
                        segment = segment.f31387f;
                        Intrinsics.m(segment);
                        j2 = j3;
                    }
                    return -1;
                }
                byte[] J = byteString.J();
                while (j3 < L0()) {
                    byte[] bArr2 = segment.f31382a;
                    int i4 = (int) ((((long) segment.f31383b) + j2) - j3);
                    int i5 = segment.f31384c;
                    while (i2 < i5) {
                        byte b3 = bArr2[i2];
                        int length = J.length;
                        int i6 = 0;
                        while (i6 < length) {
                            byte b4 = J[i6];
                            i6++;
                            if (b3 == b4) {
                            }
                        }
                        i4 = i2 + 1;
                    }
                    j3 += (long) (segment.f31384c - segment.f31383b);
                    segment = segment.f31387f;
                    Intrinsics.m(segment);
                    j2 = j3;
                }
                return -1;
            }
            while (true) {
                long j5 = ((long) (segment.f31384c - segment.f31383b)) + j4;
                if (j5 > j2) {
                    break;
                }
                segment = segment.f31387f;
                Intrinsics.m(segment);
                j4 = j5;
            }
            if (byteString.m0() == 2) {
                byte q3 = byteString.q(0);
                byte q4 = byteString.q(1);
                while (j3 < L0()) {
                    byte[] bArr3 = segment.f31382a;
                    int i7 = (int) ((((long) segment.f31383b) + j2) - j3);
                    int i8 = segment.f31384c;
                    while (i2 < i8) {
                        byte b5 = bArr3[i2];
                        if (!(b5 == q3 || b5 == q4)) {
                            i7 = i2 + 1;
                        }
                    }
                    j4 = j3 + ((long) (segment.f31384c - segment.f31383b));
                    segment = segment.f31387f;
                    Intrinsics.m(segment);
                    j2 = j4;
                }
                return -1;
            }
            byte[] J2 = byteString.J();
            while (j3 < L0()) {
                byte[] bArr4 = segment.f31382a;
                int i9 = (int) ((((long) segment.f31383b) + j2) - j3);
                int i10 = segment.f31384c;
                while (i2 < i10) {
                    byte b6 = bArr4[i2];
                    int length2 = J2.length;
                    int i11 = 0;
                    while (i11 < length2) {
                        byte b7 = J2[i11];
                        i11++;
                        if (b6 == b7) {
                        }
                    }
                    i9 = i2 + 1;
                }
                j4 = j3 + ((long) (segment.f31384c - segment.f31383b));
                segment = segment.f31387f;
                Intrinsics.m(segment);
                j2 = j4;
            }
            return -1;
            return ((long) (i2 - segment.f31383b)) + j3;
        }
        throw new IllegalArgumentException(Intrinsics.C("fromIndex < 0: ", Long.valueOf(j2)).toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009b, code lost:
        if (r2 == false) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009d, code lost:
        r14 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009f, code lost:
        r14 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a0, code lost:
        if (r1 >= r14) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00aa, code lost:
        if (L0() == 0) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ac, code lost:
        if (r2 == false) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ae, code lost:
        r1 = "Expected a digit";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b1, code lost:
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d6, code lost:
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + okio._UtilKt.t(y(0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00dc, code lost:
        throw new java.io.EOFException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00dd, code lost:
        if (r2 == false) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return -r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long H0() throws java.io.EOFException {
        /*
            r17 = this;
            r0 = r17
            long r1 = r17.L0()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00e2
            r1 = 0
            r5 = -7
            r8 = r3
            r6 = r5
            r2 = 0
            r5 = 0
        L_0x0013:
            okio.Segment r10 = r0.s
            kotlin.jvm.internal.Intrinsics.m(r10)
            byte[] r11 = r10.f31382a
            int r12 = r10.f31383b
            int r13 = r10.f31384c
        L_0x001e:
            if (r12 >= r13) goto L_0x007a
            byte r15 = r11[r12]
            r14 = 48
            byte r14 = (byte) r14
            if (r15 < r14) goto L_0x0067
            r3 = 57
            byte r3 = (byte) r3
            if (r15 > r3) goto L_0x0067
            int r14 = r14 - r15
            r3 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r16 < 0) goto L_0x0045
            if (r16 != 0) goto L_0x003e
            long r3 = (long) r14
            int r16 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r16 >= 0) goto L_0x003e
            goto L_0x0045
        L_0x003e:
            r3 = 10
            long r8 = r8 * r3
            long r3 = (long) r14
            long r8 = r8 + r3
            goto L_0x0072
        L_0x0045:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.Buffer r1 = r1.L2(r8)
            okio.Buffer r1 = r1.writeByte(r15)
            if (r2 != 0) goto L_0x0057
            r1.readByte()
        L_0x0057:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.String r3 = "Number too large: "
            java.lang.String r1 = r1.a2()
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.C(r3, r1)
            r2.<init>(r1)
            throw r2
        L_0x0067:
            r3 = 45
            byte r3 = (byte) r3
            if (r15 != r3) goto L_0x0079
            if (r1 != 0) goto L_0x0079
            r2 = 1
            long r6 = r6 - r2
            r2 = 1
        L_0x0072:
            int r12 = r12 + 1
            int r1 = r1 + 1
            r3 = 0
            goto L_0x001e
        L_0x0079:
            r5 = 1
        L_0x007a:
            if (r12 != r13) goto L_0x0086
            okio.Segment r3 = r10.b()
            r0.s = r3
            okio.SegmentPool.d(r10)
            goto L_0x0088
        L_0x0086:
            r10.f31383b = r12
        L_0x0088:
            if (r5 != 0) goto L_0x0092
            okio.Segment r3 = r0.s
            if (r3 != 0) goto L_0x008f
            goto L_0x0092
        L_0x008f:
            r3 = 0
            goto L_0x0013
        L_0x0092:
            long r3 = r17.L0()
            long r5 = (long) r1
            long r3 = r3 - r5
            r0.C0(r3)
            if (r2 == 0) goto L_0x009f
            r14 = 2
            goto L_0x00a0
        L_0x009f:
            r14 = 1
        L_0x00a0:
            if (r1 >= r14) goto L_0x00dd
            long r3 = r17.L0()
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x00d7
            if (r2 == 0) goto L_0x00b1
            java.lang.String r1 = "Expected a digit"
            goto L_0x00b3
        L_0x00b1:
            java.lang.String r1 = "Expected a digit or '-'"
        L_0x00b3:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = " but was 0x"
            r3.append(r1)
            r4 = 0
            byte r1 = r0.y(r4)
            java.lang.String r1 = okio._UtilKt.t(r1)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x00d7:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        L_0x00dd:
            if (r2 == 0) goto L_0x00e0
            goto L_0x00e1
        L_0x00e0:
            long r8 = -r8
        L_0x00e1:
            return r8
        L_0x00e2:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.H0():long");
    }

    public void I2(long j2) throws EOFException {
        if (this.X < j2) {
            throw new EOFException();
        }
    }

    @NotNull
    public final ByteString J(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "key");
        return A("HmacSHA512", byteString);
    }

    @NotNull
    /* renamed from: J2 */
    public Buffer E2(@NotNull String str, int i2, int i3, @NotNull Charset charset) {
        Intrinsics.p(str, TypedValues.Custom.f3952e);
        Intrinsics.p(charset, "charset");
        boolean z = true;
        if (i2 >= 0) {
            if (i3 >= i2) {
                if (i3 > str.length()) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + str.length()).toString());
                } else if (Intrinsics.g(charset, Charsets.f29053b)) {
                    return w1(str, i2, i3);
                } else {
                    String substring = str.substring(i2, i3);
                    Intrinsics.o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring != null) {
                        byte[] bytes = substring.getBytes(charset);
                        Intrinsics.o(bytes, "(this as java.lang.String).getBytes(charset)");
                        return write(bytes, 0, bytes.length);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
            }
        } else {
            throw new IllegalArgumentException(Intrinsics.C("beginIndex < 0: ", Integer.valueOf(i2)).toString());
        }
    }

    @NotNull
    public ByteString K(long j2) throws EOFException {
        if (!(j2 >= 0 && j2 <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.C("byteCount: ", Long.valueOf(j2)).toString());
        } else if (L0() < j2) {
            throw new EOFException();
        } else if (j2 < PlaybackStateCompat.r3) {
            return new ByteString(U1(j2));
        } else {
            ByteString S0 = S0((int) j2);
            skip(j2);
            return S0;
        }
    }

    @NotNull
    public final ByteString K0() {
        return v("SHA-512");
    }

    @NotNull
    public final ByteString L() {
        return v("MD5");
    }

    @JvmName(name = "size")
    public final long L0() {
        return this.X;
    }

    @NotNull
    public String M0(long j2) throws EOFException {
        if (j2 >= 0) {
            long j3 = Long.MAX_VALUE;
            if (j2 != Long.MAX_VALUE) {
                j3 = j2 + 1;
            }
            byte b2 = (byte) 10;
            long y0 = y0(b2, 0, j3);
            if (y0 != -1) {
                return _BufferKt.j0(this, y0);
            }
            if (j3 < L0() && y(j3 - 1) == ((byte) 13) && y(j3) == b2) {
                return _BufferKt.j0(this, j3);
            }
            Buffer buffer = new Buffer();
            r(buffer, 0, Math.min((long) 32, L0()));
            throw new EOFException("\\n not found: limit=" + Math.min(L0(), j2) + " content=" + buffer.A1().w() + Typography.F);
        }
        throw new IllegalArgumentException(Intrinsics.C("limit < 0: ", Long.valueOf(j2)).toString());
    }

    @NotNull
    public OutputStream M2() {
        return new Buffer$outputStream$1(this);
    }

    public long N2(byte b2) {
        return y0(b2, 0, Long.MAX_VALUE);
    }

    @NotNull
    public String O1() throws EOFException {
        return M0(Long.MAX_VALUE);
    }

    @NotNull
    /* renamed from: P2 */
    public Buffer C1(@NotNull String str, @NotNull Charset charset) {
        Intrinsics.p(str, TypedValues.Custom.f3952e);
        Intrinsics.p(charset, "charset");
        return E2(str, 0, str.length(), charset);
    }

    @NotNull
    @JvmOverloads
    public final UnsafeCursor Q() {
        return c0(this, (UnsafeCursor) null, 1, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0084, code lost:
        if (r8 != r9) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0086, code lost:
        r15.s = r6.b();
        okio.SegmentPool.d(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0090, code lost:
        r6.f31383b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0092, code lost:
        if (r1 != false) goto L_0x0098;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0074 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long Q2() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.L0()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00a2
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000d:
            okio.Segment r6 = r15.s
            kotlin.jvm.internal.Intrinsics.m(r6)
            byte[] r7 = r6.f31382a
            int r8 = r6.f31383b
            int r9 = r6.f31384c
        L_0x0018:
            if (r8 >= r9) goto L_0x0084
            byte r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0029
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0029
            int r11 = r10 - r11
            goto L_0x0043
        L_0x0029:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0038
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0038
        L_0x0033:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L_0x0043
        L_0x0038:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0070
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0070
            goto L_0x0033
        L_0x0043:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x0053
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0018
        L_0x0053:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.z1(r4)
            okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r0.a2()
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.C(r2, r0)
            r1.<init>(r0)
            throw r1
        L_0x0070:
            if (r0 == 0) goto L_0x0074
            r1 = 1
            goto L_0x0084
        L_0x0074:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r2 = okio._UtilKt.t(r10)
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.C(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x0084:
            if (r8 != r9) goto L_0x0090
            okio.Segment r7 = r6.b()
            r15.s = r7
            okio.SegmentPool.d(r6)
            goto L_0x0092
        L_0x0090:
            r6.f31383b = r8
        L_0x0092:
            if (r1 != 0) goto L_0x0098
            okio.Segment r6 = r15.s
            if (r6 != 0) goto L_0x000d
        L_0x0098:
            long r1 = r15.L0()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.C0(r1)
            return r4
        L_0x00a2:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.Q2():long");
    }

    @NotNull
    public final ByteString R0() {
        if (L0() <= 2147483647L) {
            return S0((int) L0());
        }
        throw new IllegalStateException(Intrinsics.C("size > Int.MAX_VALUE: ", Long.valueOf(L0())).toString());
    }

    public int R1() throws EOFException {
        return _UtilKt.n(readInt());
    }

    @NotNull
    @JvmOverloads
    public final UnsafeCursor S(@NotNull UnsafeCursor unsafeCursor) {
        Intrinsics.p(unsafeCursor, "unsafeCursor");
        return _BufferKt.s(this, unsafeCursor);
    }

    @NotNull
    public final ByteString S0(int i2) {
        if (i2 == 0) {
            return ByteString.Y2;
        }
        _UtilKt.e(L0(), 0, (long) i2);
        Segment segment = this.s;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Intrinsics.m(segment);
            int i6 = segment.f31384c;
            int i7 = segment.f31383b;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                segment = segment.f31387f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i5][];
        int[] iArr = new int[(i5 * 2)];
        Segment segment2 = this.s;
        int i8 = 0;
        while (i3 < i2) {
            Intrinsics.m(segment2);
            bArr[i8] = segment2.f31382a;
            i3 += segment2.f31384c - segment2.f31383b;
            iArr[i8] = Math.min(i3, i2);
            iArr[i8 + i5] = segment2.f31383b;
            segment2.f31385d = true;
            i8++;
            segment2 = segment2.f31387f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    public boolean S1(long j2, @NotNull ByteString byteString, int i2, int i3) {
        Intrinsics.p(byteString, "bytes");
        if (j2 < 0 || i2 < 0 || i3 < 0 || L0() - j2 < ((long) i3) || byteString.m0() - i2 < i3) {
            return false;
        }
        if (i3 > 0) {
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                if (y(((long) i4) + j2) != byteString.q(i4 + i2)) {
                    return false;
                }
                if (i5 >= i3) {
                    break;
                }
                i4 = i5;
            }
        }
        return true;
    }

    public int S2(@NotNull Options options) {
        Intrinsics.p(options, "options");
        int m0 = _BufferKt.m0(this, options, false, 2, (Object) null);
        if (m0 == -1) {
            return -1;
        }
        skip((long) options.g()[m0].m0());
        return m0;
    }

    @NotNull
    /* renamed from: T1 */
    public Buffer n0(int i2) {
        return writeInt(_UtilKt.n(i2));
    }

    @NotNull
    @JvmOverloads
    public final Buffer T2(@NotNull OutputStream outputStream) throws IOException {
        Intrinsics.p(outputStream, "out");
        return V2(this, outputStream, 0, 2, (Object) null);
    }

    @NotNull
    public byte[] U1(long j2) throws EOFException {
        if (!(j2 >= 0 && j2 <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.C("byteCount: ", Long.valueOf(j2)).toString());
        } else if (L0() >= j2) {
            byte[] bArr = new byte[((int) j2)];
            readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    @NotNull
    @JvmOverloads
    public final Buffer U2(@NotNull OutputStream outputStream, long j2) throws IOException {
        Intrinsics.p(outputStream, "out");
        _UtilKt.e(this.X, 0, j2);
        Segment segment = this.s;
        while (j2 > 0) {
            Intrinsics.m(segment);
            int min = (int) Math.min(j2, (long) (segment.f31384c - segment.f31383b));
            outputStream.write(segment.f31382a, segment.f31383b, min);
            int i2 = segment.f31383b + min;
            segment.f31383b = i2;
            long j3 = (long) min;
            this.X -= j3;
            j2 -= j3;
            if (i2 == segment.f31384c) {
                Segment b2 = segment.b();
                this.s = b2;
                SegmentPool.d(segment);
                segment = b2;
            }
        }
        return this;
    }

    @NotNull
    /* renamed from: W2 */
    public Buffer W0(@NotNull String str) {
        Intrinsics.p(str, TypedValues.Custom.f3952e);
        return w1(str, 0, str.length());
    }

    @NotNull
    /* renamed from: X2 */
    public Buffer w1(@NotNull String str, int i2, int i3) {
        long L0;
        long j2;
        char charAt;
        Intrinsics.p(str, TypedValues.Custom.f3952e);
        if (i2 >= 0) {
            if (i3 >= i2) {
                if (i3 <= str.length()) {
                    while (i2 < i3) {
                        char charAt2 = str.charAt(i2);
                        if (charAt2 < 128) {
                            Segment Y0 = Y0(1);
                            byte[] bArr = Y0.f31382a;
                            int i4 = Y0.f31384c - i2;
                            int min = Math.min(i3, 8192 - i4);
                            int i5 = i2 + 1;
                            bArr[i2 + i4] = (byte) charAt2;
                            while (true) {
                                i2 = i5;
                                if (i2 >= min || (charAt = str.charAt(i2)) >= 128) {
                                    int i6 = Y0.f31384c;
                                    int i7 = (i4 + i2) - i6;
                                    Y0.f31384c = i6 + i7;
                                    C0(L0() + ((long) i7));
                                } else {
                                    i5 = i2 + 1;
                                    bArr[i2 + i4] = (byte) charAt;
                                }
                            }
                            int i62 = Y0.f31384c;
                            int i72 = (i4 + i2) - i62;
                            Y0.f31384c = i62 + i72;
                            C0(L0() + ((long) i72));
                        } else {
                            if (charAt2 < 2048) {
                                Segment Y02 = Y0(2);
                                byte[] bArr2 = Y02.f31382a;
                                int i8 = Y02.f31384c;
                                bArr2[i8] = (byte) ((charAt2 >> 6) | PsExtractor.x);
                                bArr2[i8 + 1] = (byte) ((charAt2 & '?') | 128);
                                Y02.f31384c = i8 + 2;
                                L0 = L0();
                                j2 = 2;
                            } else if (charAt2 < 55296 || charAt2 > 57343) {
                                Segment Y03 = Y0(3);
                                byte[] bArr3 = Y03.f31382a;
                                int i9 = Y03.f31384c;
                                bArr3[i9] = (byte) ((charAt2 >> 12) | 224);
                                bArr3[i9 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr3[i9 + 2] = (byte) ((charAt2 & '?') | 128);
                                Y03.f31384c = i9 + 3;
                                L0 = L0();
                                j2 = 3;
                            } else {
                                int i10 = i2 + 1;
                                char charAt3 = i10 < i3 ? str.charAt(i10) : 0;
                                if (charAt2 > 56319 || 56320 > charAt3 || charAt3 > 57343) {
                                    writeByte(63);
                                    i2 = i10;
                                } else {
                                    int i11 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 0;
                                    Segment Y04 = Y0(4);
                                    byte[] bArr4 = Y04.f31382a;
                                    int i12 = Y04.f31384c;
                                    bArr4[i12] = (byte) ((i11 >> 18) | PsExtractor.A);
                                    bArr4[i12 + 1] = (byte) (((i11 >> 12) & 63) | 128);
                                    bArr4[i12 + 2] = (byte) (((i11 >> 6) & 63) | 128);
                                    bArr4[i12 + 3] = (byte) ((i11 & 63) | 128);
                                    Y04.f31384c = i12 + 4;
                                    C0(L0() + 4);
                                    i2 += 2;
                                }
                            }
                            C0(L0 + j2);
                            i2++;
                        }
                    }
                    return this;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
        }
        throw new IllegalArgumentException(Intrinsics.C("beginIndex < 0: ", Integer.valueOf(i2)).toString());
    }

    @NotNull
    public final Segment Y0(int i2) {
        boolean z = true;
        if (i2 < 1 || i2 > 8192) {
            z = false;
        }
        if (z) {
            Segment segment = this.s;
            if (segment == null) {
                Segment e2 = SegmentPool.e();
                this.s = e2;
                e2.f31388g = e2;
                e2.f31387f = e2;
                return e2;
            }
            Intrinsics.m(segment);
            Segment segment2 = segment.f31388g;
            Intrinsics.m(segment2);
            return (segment2.f31384c + i2 > 8192 || !segment2.f31386e) ? segment2.c(SegmentPool.e()) : segment2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @NotNull
    /* renamed from: Y2 */
    public Buffer U(int i2) {
        long L0;
        long j2;
        if (i2 < 128) {
            writeByte(i2);
        } else {
            if (i2 < 2048) {
                Segment Y0 = Y0(2);
                byte[] bArr = Y0.f31382a;
                int i3 = Y0.f31384c;
                bArr[i3] = (byte) ((i2 >> 6) | PsExtractor.x);
                bArr[i3 + 1] = (byte) ((i2 & 63) | 128);
                Y0.f31384c = i3 + 2;
                L0 = L0();
                j2 = 2;
            } else if (55296 <= i2 && i2 <= 57343) {
                writeByte(63);
            } else if (i2 < 65536) {
                Segment Y02 = Y0(3);
                byte[] bArr2 = Y02.f31382a;
                int i4 = Y02.f31384c;
                bArr2[i4] = (byte) ((i2 >> 12) | 224);
                bArr2[i4 + 1] = (byte) (((i2 >> 6) & 63) | 128);
                bArr2[i4 + 2] = (byte) ((i2 & 63) | 128);
                Y02.f31384c = i4 + 3;
                L0 = L0();
                j2 = 3;
            } else if (i2 <= 1114111) {
                Segment Y03 = Y0(4);
                byte[] bArr3 = Y03.f31382a;
                int i5 = Y03.f31384c;
                bArr3[i5] = (byte) ((i2 >> 18) | PsExtractor.A);
                bArr3[i5 + 1] = (byte) (((i2 >> 12) & 63) | 128);
                bArr3[i5 + 2] = (byte) (((i2 >> 6) & 63) | 128);
                bArr3[i5 + 3] = (byte) ((i2 & 63) | 128);
                Y03.f31384c = i5 + 4;
                L0 = L0();
                j2 = 4;
            } else {
                throw new IllegalArgumentException(Intrinsics.C("Unexpected code point: 0x", _UtilKt.u(i2)));
            }
            C0(L0 + j2);
        }
        return this;
    }

    @NotNull
    public String a2() {
        return d2(this.X, Charsets.f29053b);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    public final byte b(long j2) {
        return y(j2);
    }

    @NotNull
    public byte[] b0() {
        return U1(L0());
    }

    public boolean b1(long j2, @NotNull ByteString byteString) {
        Intrinsics.p(byteString, "bytes");
        return S1(j2, byteString, 0, byteString.m0());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    public final long c() {
        return this.X;
    }

    @NotNull
    /* renamed from: c1 */
    public Buffer g2(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "byteString");
        byteString.K0(this, 0, byteString.m0());
        return this;
    }

    public void close() {
    }

    public final void d() {
        skip(L0());
    }

    @NotNull
    /* renamed from: d1 */
    public Buffer V(@NotNull ByteString byteString, int i2, int i3) {
        Intrinsics.p(byteString, "byteString");
        byteString.K0(this, i2, i3);
        return this;
    }

    @NotNull
    public String d2(long j2, @NotNull Charset charset) throws EOFException {
        Intrinsics.p(charset, "charset");
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (!(i2 >= 0 && j2 <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.C("byteCount: ", Long.valueOf(j2)).toString());
        } else if (this.X < j2) {
            throw new EOFException();
        } else if (i2 == 0) {
            return "";
        } else {
            Segment segment = this.s;
            Intrinsics.m(segment);
            int i3 = segment.f31383b;
            if (((long) i3) + j2 > ((long) segment.f31384c)) {
                return new String(U1(j2), charset);
            }
            int i4 = (int) j2;
            String str = new String(segment.f31382a, i3, i4, charset);
            int i5 = segment.f31383b + i4;
            segment.f31383b = i5;
            this.X -= j2;
            if (i5 == segment.f31384c) {
                this.s = segment.b();
                SegmentPool.d(segment);
            }
            return str;
        }
    }

    @NotNull
    /* renamed from: e */
    public Buffer clone() {
        return h();
    }

    @NotNull
    /* renamed from: e1 */
    public Buffer H1(@NotNull Source source, long j2) throws IOException {
        Intrinsics.p(source, "source");
        while (j2 > 0) {
            long n2 = source.n2(this, j2);
            if (n2 != -1) {
                j2 -= n2;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    @NotNull
    /* renamed from: e2 */
    public Buffer writeLong(long j2) {
        Segment Y0 = Y0(8);
        byte[] bArr = Y0.f31382a;
        int i2 = Y0.f31384c;
        bArr[i2] = (byte) ((int) ((j2 >>> 56) & 255));
        bArr[i2 + 1] = (byte) ((int) ((j2 >>> 48) & 255));
        bArr[i2 + 2] = (byte) ((int) ((j2 >>> 40) & 255));
        bArr[i2 + 3] = (byte) ((int) ((j2 >>> 32) & 255));
        bArr[i2 + 4] = (byte) ((int) ((j2 >>> 24) & 255));
        bArr[i2 + 5] = (byte) ((int) ((j2 >>> 16) & 255));
        bArr[i2 + 6] = (byte) ((int) ((j2 >>> 8) & 255));
        bArr[i2 + 7] = (byte) ((int) (j2 & 255));
        Y0.f31384c = i2 + 8;
        C0(L0() + 8);
        return this;
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 1
            if (r0 != r1) goto L_0x0009
            goto L_0x008a
        L_0x0009:
            boolean r3 = r1 instanceof okio.Buffer
            r4 = 0
            if (r3 != 0) goto L_0x0011
        L_0x000e:
            r2 = 0
            goto L_0x008a
        L_0x0011:
            long r5 = r18.L0()
            okio.Buffer r1 = (okio.Buffer) r1
            long r7 = r1.L0()
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0020
            goto L_0x000e
        L_0x0020:
            long r5 = r18.L0()
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x002b
            goto L_0x008a
        L_0x002b:
            okio.Segment r3 = r0.s
            kotlin.jvm.internal.Intrinsics.m(r3)
            okio.Segment r1 = r1.s
            kotlin.jvm.internal.Intrinsics.m(r1)
            int r5 = r3.f31383b
            int r6 = r1.f31383b
            r9 = r7
        L_0x003a:
            long r11 = r18.L0()
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x008a
            int r11 = r3.f31384c
            int r11 = r11 - r5
            int r12 = r1.f31384c
            int r12 = r12 - r6
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = (long) r11
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0072
            r13 = r7
        L_0x0052:
            r15 = 1
            long r13 = r13 + r15
            byte[] r15 = r3.f31382a
            int r16 = r5 + 1
            byte r5 = r15[r5]
            byte[] r15 = r1.f31382a
            int r17 = r6 + 1
            byte r6 = r15[r6]
            if (r5 == r6) goto L_0x0064
            goto L_0x000e
        L_0x0064:
            int r5 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r5 < 0) goto L_0x006d
            r5 = r16
            r6 = r17
            goto L_0x0072
        L_0x006d:
            r5 = r16
            r6 = r17
            goto L_0x0052
        L_0x0072:
            int r13 = r3.f31384c
            if (r5 != r13) goto L_0x007d
            okio.Segment r3 = r3.f31387f
            kotlin.jvm.internal.Intrinsics.m(r3)
            int r5 = r3.f31383b
        L_0x007d:
            int r13 = r1.f31384c
            if (r6 != r13) goto L_0x0088
            okio.Segment r1 = r1.f31387f
            kotlin.jvm.internal.Intrinsics.m(r1)
            int r6 = r1.f31383b
        L_0x0088:
            long r9 = r9 + r11
            goto L_0x003a
        L_0x008a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.equals(java.lang.Object):boolean");
    }

    public final long f() {
        long L0 = L0();
        if (L0 == 0) {
            return 0;
        }
        Segment segment = this.s;
        Intrinsics.m(segment);
        Segment segment2 = segment.f31388g;
        Intrinsics.m(segment2);
        int i2 = segment2.f31384c;
        if (i2 < 8192 && segment2.f31386e) {
            L0 -= (long) (i2 - segment2.f31383b);
        }
        return L0;
    }

    @NotNull
    /* renamed from: f2 */
    public Buffer Y(long j2) {
        return writeLong(_UtilKt.o(j2));
    }

    public void flush() {
    }

    @NotNull
    public Buffer g() {
        return this;
    }

    @NotNull
    public final Buffer g0(@NotNull InputStream inputStream) throws IOException {
        Intrinsics.p(inputStream, HTML.Tag.q0);
        k0(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    @NotNull
    public String g1(@NotNull Charset charset) {
        Intrinsics.p(charset, "charset");
        return d2(this.X, charset);
    }

    @NotNull
    public final Buffer h() {
        Buffer buffer = new Buffer();
        if (L0() != 0) {
            Segment segment = this.s;
            Intrinsics.m(segment);
            Segment d2 = segment.d();
            buffer.s = d2;
            d2.f31388g = d2;
            d2.f31387f = d2;
            for (Segment segment2 = segment.f31387f; segment2 != segment; segment2 = segment2.f31387f) {
                Segment segment3 = d2.f31388g;
                Intrinsics.m(segment3);
                Intrinsics.m(segment2);
                segment3.c(segment2.d());
            }
            buffer.C0(L0());
        }
        return buffer;
    }

    @NotNull
    public final Buffer h0(@NotNull InputStream inputStream, long j2) throws IOException {
        Intrinsics.p(inputStream, HTML.Tag.q0);
        if (j2 >= 0) {
            k0(inputStream, j2, false);
            return this;
        }
        throw new IllegalArgumentException(Intrinsics.C("byteCount < 0: ", Long.valueOf(j2)).toString());
    }

    @NotNull
    /* renamed from: h1 */
    public Buffer write(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    public int hashCode() {
        Segment segment = this.s;
        if (segment == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = segment.f31384c;
            for (int i4 = segment.f31383b; i4 < i3; i4++) {
                i2 = (i2 * 31) + segment.f31382a[i4];
            }
            segment = segment.f31387f;
            Intrinsics.m(segment);
        } while (segment != this.s);
        return i2;
    }

    @NotNull
    @JvmOverloads
    public final Buffer i(@NotNull OutputStream outputStream) throws IOException {
        Intrinsics.p(outputStream, "out");
        return s(this, outputStream, 0, 0, 6, (Object) null);
    }

    public boolean isOpen() {
        return true;
    }

    @NotNull
    public Timeout j() {
        return Timeout.f31400e;
    }

    @NotNull
    /* renamed from: j1 */
    public Buffer write(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "source");
        long j2 = (long) i3;
        _UtilKt.e((long) bArr.length, (long) i2, j2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            Segment Y0 = Y0(1);
            int min = Math.min(i4 - i2, 8192 - Y0.f31384c);
            int i5 = i2 + min;
            ArraysKt.v0(bArr, Y0.f31382a, Y0.f31384c, i2, i5);
            Y0.f31384c += min;
            i2 = i5;
        }
        C0(L0() + j2);
        return this;
    }

    public short j2() throws EOFException {
        return _UtilKt.p(readShort());
    }

    @NotNull
    /* renamed from: k1 */
    public Buffer writeByte(int i2) {
        Segment Y0 = Y0(1);
        byte[] bArr = Y0.f31382a;
        int i3 = Y0.f31384c;
        Y0.f31384c = i3 + 1;
        bArr[i3] = (byte) i2;
        C0(L0() + 1);
        return this;
    }

    public long l0(@NotNull ByteString byteString) throws IOException {
        Intrinsics.p(byteString, "bytes");
        return E(byteString, 0);
    }

    @NotNull
    /* renamed from: l1 */
    public Buffer L2(long j2) {
        boolean z;
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 == 0) {
            return writeByte(48);
        }
        int i3 = 1;
        if (i2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                return W0("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j2 >= 100000000) {
            i3 = j2 < MediaPeriodQueue.o ? j2 < 10000000000L ? j2 < C.f9093k ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= 10000) {
            i3 = j2 < 1000000 ? j2 < SilenceSkippingAudioProcessor.A ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i3 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i3 = 2;
        }
        if (z) {
            i3++;
        }
        Segment Y0 = Y0(i3);
        byte[] bArr = Y0.f31382a;
        int i4 = Y0.f31384c + i3;
        while (j2 != 0) {
            long j3 = (long) 10;
            i4--;
            bArr[i4] = _BufferKt.g0()[(int) (j2 % j3)];
            j2 /= j3;
        }
        if (z) {
            bArr[i4 - 1] = (byte) 45;
        }
        Y0.f31384c += i3;
        C0(L0() + ((long) i3));
        return this;
    }

    @NotNull
    public Buffer m() {
        return this;
    }

    @NotNull
    @JvmOverloads
    public final Buffer n(@NotNull OutputStream outputStream, long j2) throws IOException {
        Intrinsics.p(outputStream, "out");
        return s(this, outputStream, j2, 0, 4, (Object) null);
    }

    public long n2(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(Intrinsics.C("byteCount < 0: ", Long.valueOf(j2)).toString());
        } else if (L0() == 0) {
            return -1;
        } else {
            if (j2 > L0()) {
                j2 = L0();
            }
            buffer.u1(this, j2);
            return j2;
        }
    }

    public boolean o0() {
        return this.X == 0;
    }

    @NotNull
    @JvmOverloads
    public final Buffer p(@NotNull OutputStream outputStream, long j2, long j3) throws IOException {
        Intrinsics.p(outputStream, "out");
        _UtilKt.e(this.X, j2, j3);
        if (j3 == 0) {
            return this;
        }
        Segment segment = this.s;
        while (true) {
            Intrinsics.m(segment);
            int i2 = segment.f31384c;
            int i3 = segment.f31383b;
            if (j2 < ((long) (i2 - i3))) {
                break;
            }
            j2 -= (long) (i2 - i3);
            segment = segment.f31387f;
        }
        while (j3 > 0) {
            Intrinsics.m(segment);
            int i4 = (int) (((long) segment.f31383b) + j2);
            int min = (int) Math.min((long) (segment.f31384c - i4), j3);
            outputStream.write(segment.f31382a, i4, min);
            j3 -= (long) min;
            segment = segment.f31387f;
            j2 = 0;
        }
        return this;
    }

    public long p2() throws EOFException {
        return _UtilKt.o(readLong());
    }

    @NotNull
    public BufferedSource peek() {
        return Okio.e(new PeekSource(this));
    }

    @NotNull
    public final Buffer q(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "out");
        return r(buffer, j2, this.X - j2);
    }

    @NotNull
    @JvmOverloads
    public final UnsafeCursor q0() {
        return s0(this, (UnsafeCursor) null, 1, (Object) null);
    }

    @NotNull
    /* renamed from: q2 */
    public Buffer writeShort(int i2) {
        Segment Y0 = Y0(2);
        byte[] bArr = Y0.f31382a;
        int i3 = Y0.f31384c;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i3 + 1] = (byte) (i2 & 255);
        Y0.f31384c = i3 + 2;
        C0(L0() + 2);
        return this;
    }

    @NotNull
    public final Buffer r(@NotNull Buffer buffer, long j2, long j3) {
        Intrinsics.p(buffer, "out");
        _UtilKt.e(L0(), j2, j3);
        if (j3 != 0) {
            buffer.C0(buffer.L0() + j3);
            Segment segment = this.s;
            while (true) {
                Intrinsics.m(segment);
                int i2 = segment.f31384c;
                int i3 = segment.f31383b;
                if (j2 < ((long) (i2 - i3))) {
                    break;
                }
                j2 -= (long) (i2 - i3);
                segment = segment.f31387f;
            }
            while (j3 > 0) {
                Intrinsics.m(segment);
                Segment d2 = segment.d();
                int i4 = d2.f31383b + ((int) j2);
                d2.f31383b = i4;
                d2.f31384c = Math.min(i4 + ((int) j3), d2.f31384c);
                Segment segment2 = buffer.s;
                if (segment2 == null) {
                    d2.f31388g = d2;
                    d2.f31387f = d2;
                    buffer.s = d2;
                } else {
                    Intrinsics.m(segment2);
                    Segment segment3 = segment2.f31388g;
                    Intrinsics.m(segment3);
                    segment3.c(d2);
                }
                j3 -= (long) (d2.f31384c - d2.f31383b);
                segment = segment.f31387f;
                j2 = 0;
            }
        }
        return this;
    }

    @NotNull
    @JvmOverloads
    public final UnsafeCursor r0(@NotNull UnsafeCursor unsafeCursor) {
        Intrinsics.p(unsafeCursor, "unsafeCursor");
        return _BufferKt.F(this, unsafeCursor);
    }

    public long r2(@NotNull Sink sink) throws IOException {
        Intrinsics.p(sink, "sink");
        long L0 = L0();
        if (L0 > 0) {
            sink.u1(this, L0);
        }
        return L0;
    }

    public int read(@NotNull ByteBuffer byteBuffer) throws IOException {
        Intrinsics.p(byteBuffer, "sink");
        Segment segment = this.s;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.f31384c - segment.f31383b);
        byteBuffer.put(segment.f31382a, segment.f31383b, min);
        int i2 = segment.f31383b + min;
        segment.f31383b = i2;
        this.X -= (long) min;
        if (i2 == segment.f31384c) {
            this.s = segment.b();
            SegmentPool.d(segment);
        }
        return min;
    }

    public byte readByte() throws EOFException {
        if (L0() != 0) {
            Segment segment = this.s;
            Intrinsics.m(segment);
            int i2 = segment.f31383b;
            int i3 = segment.f31384c;
            int i4 = i2 + 1;
            byte b2 = segment.f31382a[i2];
            C0(L0() - 1);
            if (i4 == i3) {
                this.s = segment.b();
                SegmentPool.d(segment);
            } else {
                segment.f31383b = i4;
            }
            return b2;
        }
        throw new EOFException();
    }

    public void readFully(@NotNull byte[] bArr) throws EOFException {
        Intrinsics.p(bArr, "sink");
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = read(bArr, i2, bArr.length - i2);
            if (read != -1) {
                i2 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public int readInt() throws EOFException {
        if (L0() >= 4) {
            Segment segment = this.s;
            Intrinsics.m(segment);
            int i2 = segment.f31383b;
            int i3 = segment.f31384c;
            if (((long) (i3 - i2)) < 4) {
                return ((readByte() & 255) << Ascii.B) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.f31382a;
            byte b2 = ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2] & 255) << Ascii.B);
            int i4 = i2 + 3;
            int i5 = i2 + 4;
            byte b3 = (bArr[i4] & 255) | b2 | ((bArr[i2 + 2] & 255) << 8);
            C0(L0() - 4);
            if (i5 == i3) {
                this.s = segment.b();
                SegmentPool.d(segment);
            } else {
                segment.f31383b = i5;
            }
            return b3;
        }
        throw new EOFException();
    }

    public long readLong() throws EOFException {
        if (L0() >= 8) {
            Segment segment = this.s;
            Intrinsics.m(segment);
            int i2 = segment.f31383b;
            int i3 = segment.f31384c;
            if (((long) (i3 - i2)) < 8) {
                return ((((long) readInt()) & InternalZipConstants.f30717k) << 32) | (InternalZipConstants.f30717k & ((long) readInt()));
            }
            byte[] bArr = segment.f31382a;
            long j2 = ((((long) bArr[i2 + 3]) & 255) << 32) | ((((long) bArr[i2]) & 255) << 56) | ((((long) bArr[i2 + 1]) & 255) << 48) | ((((long) bArr[i2 + 2]) & 255) << 40);
            int i4 = i2 + 7;
            int i5 = i2 + 8;
            long j3 = j2 | ((((long) bArr[i2 + 4]) & 255) << 24) | ((((long) bArr[i2 + 5]) & 255) << 16) | ((((long) bArr[i2 + 6]) & 255) << 8) | (((long) bArr[i4]) & 255);
            C0(L0() - 8);
            if (i5 == i3) {
                this.s = segment.b();
                SegmentPool.d(segment);
            } else {
                segment.f31383b = i5;
            }
            return j3;
        }
        throw new EOFException();
    }

    public short readShort() throws EOFException {
        if (L0() >= 2) {
            Segment segment = this.s;
            Intrinsics.m(segment);
            int i2 = segment.f31383b;
            int i3 = segment.f31384c;
            if (i3 - i2 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.f31382a;
            int i4 = i2 + 1;
            int i5 = i2 + 2;
            byte b2 = (bArr[i4] & 255) | ((bArr[i2] & 255) << 8);
            C0(L0() - 2);
            if (i5 == i3) {
                this.s = segment.b();
                SegmentPool.d(segment);
            } else {
                segment.f31383b = i5;
            }
            return (short) b2;
        }
        throw new EOFException();
    }

    public boolean request(long j2) {
        return this.X >= j2;
    }

    public void skip(long j2) throws EOFException {
        while (j2 > 0) {
            Segment segment = this.s;
            if (segment != null) {
                int min = (int) Math.min(j2, (long) (segment.f31384c - segment.f31383b));
                long j3 = (long) min;
                C0(L0() - j3);
                j2 -= j3;
                int i2 = segment.f31383b + min;
                segment.f31383b = i2;
                if (i2 == segment.f31384c) {
                    this.s = segment.b();
                    SegmentPool.d(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public int t1() throws EOFException {
        byte b2;
        int i2;
        byte b3;
        if (L0() != 0) {
            byte y = y(0);
            int i3 = 1;
            if ((y & 128) == 0) {
                b3 = y & Byte.MAX_VALUE;
                i2 = 1;
                b2 = 0;
            } else if ((y & 224) == 192) {
                b3 = y & Ascii.I;
                i2 = 2;
                b2 = 128;
            } else if ((y & 240) == 224) {
                b3 = y & 15;
                i2 = 3;
                b2 = 2048;
            } else if ((y & 248) == 240) {
                b3 = y & 7;
                i2 = 4;
                b2 = 65536;
            } else {
                skip(1);
                return Utf8.f31406c;
            }
            long j2 = (long) i2;
            if (L0() >= j2) {
                if (1 < i2) {
                    while (true) {
                        int i4 = i3 + 1;
                        long j3 = (long) i3;
                        byte y2 = y(j3);
                        if ((y2 & 192) == 128) {
                            b3 = (b3 << 6) | (y2 & Utf8.f31404a);
                            if (i4 >= i2) {
                                break;
                            }
                            i3 = i4;
                        } else {
                            skip(j3);
                            return Utf8.f31406c;
                        }
                    }
                }
                skip(j2);
                if (b3 > 1114111) {
                    return Utf8.f31406c;
                }
                return ((55296 > b3 || b3 > 57343) && b3 >= b2) ? b3 : Utf8.f31406c;
            }
            throw new EOFException("size < " + i2 + ": " + L0() + " (to read code point prefixed 0x" + _UtilKt.t(y) + ASCIIPropertyListParser.f18650h);
        }
        throw new EOFException();
    }

    @NotNull
    public String toString() {
        return R0().toString();
    }

    public long u0(byte b2, long j2) {
        return y0(b2, j2, Long.MAX_VALUE);
    }

    public void u1(@NotNull Buffer buffer, long j2) {
        Segment segment;
        Intrinsics.p(buffer, "source");
        if (buffer != this) {
            _UtilKt.e(buffer.L0(), 0, j2);
            while (j2 > 0) {
                Segment segment2 = buffer.s;
                Intrinsics.m(segment2);
                int i2 = segment2.f31384c;
                Segment segment3 = buffer.s;
                Intrinsics.m(segment3);
                if (j2 < ((long) (i2 - segment3.f31383b))) {
                    Segment segment4 = this.s;
                    if (segment4 != null) {
                        Intrinsics.m(segment4);
                        segment = segment4.f31388g;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.f31386e) {
                        if ((((long) segment.f31384c) + j2) - ((long) (segment.f31385d ? 0 : segment.f31383b)) <= PlaybackStateCompat.s3) {
                            Segment segment5 = buffer.s;
                            Intrinsics.m(segment5);
                            segment5.g(segment, (int) j2);
                            buffer.C0(buffer.L0() - j2);
                            C0(L0() + j2);
                            return;
                        }
                    }
                    Segment segment6 = buffer.s;
                    Intrinsics.m(segment6);
                    buffer.s = segment6.e((int) j2);
                }
                Segment segment7 = buffer.s;
                Intrinsics.m(segment7);
                long j3 = (long) (segment7.f31384c - segment7.f31383b);
                buffer.s = segment7.b();
                Segment segment8 = this.s;
                if (segment8 == null) {
                    this.s = segment7;
                    segment7.f31388g = segment7;
                    segment7.f31387f = segment7;
                } else {
                    Intrinsics.m(segment8);
                    Segment segment9 = segment8.f31388g;
                    Intrinsics.m(segment9);
                    segment9.c(segment7).a();
                }
                buffer.C0(buffer.L0() - j3);
                C0(L0() + j3);
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    @NotNull
    /* renamed from: w */
    public Buffer M() {
        return this;
    }

    public void w0(@NotNull Buffer buffer, long j2) throws EOFException {
        Intrinsics.p(buffer, "sink");
        if (L0() >= j2) {
            buffer.u1(this, j2);
        } else {
            buffer.u1(this, L0());
            throw new EOFException();
        }
    }

    @NotNull
    /* renamed from: w2 */
    public Buffer O0(int i2) {
        return writeShort(_UtilKt.p((short) i2));
    }

    public int write(@NotNull ByteBuffer byteBuffer) throws IOException {
        Intrinsics.p(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        int i2 = remaining;
        while (i2 > 0) {
            Segment Y0 = Y0(1);
            int min = Math.min(i2, 8192 - Y0.f31384c);
            byteBuffer.get(Y0.f31382a, Y0.f31384c, min);
            i2 -= min;
            Y0.f31384c += min;
        }
        this.X += (long) remaining;
        return remaining;
    }

    @NotNull
    /* renamed from: x */
    public Buffer F0() {
        return this;
    }

    @JvmName(name = "getByte")
    public final byte y(long j2) {
        _UtilKt.e(L0(), j2, 1);
        Segment segment = this.s;
        if (segment == null) {
            Intrinsics.m((Object) null);
            throw null;
        } else if (L0() - j2 < j2) {
            long L0 = L0();
            while (L0 > j2) {
                segment = segment.f31388g;
                Intrinsics.m(segment);
                L0 -= (long) (segment.f31384c - segment.f31383b);
            }
            Intrinsics.m(segment);
            return segment.f31382a[(int) ((((long) segment.f31383b) + j2) - L0)];
        } else {
            long j3 = 0;
            while (true) {
                long j4 = ((long) (segment.f31384c - segment.f31383b)) + j3;
                if (j4 > j2) {
                    Intrinsics.m(segment);
                    return segment.f31382a[(int) ((((long) segment.f31383b) + j2) - j3)];
                }
                segment = segment.f31387f;
                Intrinsics.m(segment);
                j3 = j4;
            }
        }
    }

    public long y0(byte b2, long j2, long j3) {
        Segment segment;
        long j4;
        int i2;
        byte b3 = b2;
        long j5 = j2;
        long j6 = j3;
        boolean z = false;
        long j7 = 0;
        if (0 <= j5 && j5 <= j6) {
            z = true;
        }
        if (z) {
            if (j6 > L0()) {
                j6 = L0();
            }
            long j8 = j6;
            if (j5 == j8 || (segment = this.s) == null) {
                return -1;
            }
            if (L0() - j5 < j5) {
                j4 = L0();
                while (j4 > j5) {
                    segment = segment.f31388g;
                    Intrinsics.m(segment);
                    j4 -= (long) (segment.f31384c - segment.f31383b);
                }
                while (j4 < j8) {
                    byte[] bArr = segment.f31382a;
                    int min = (int) Math.min((long) segment.f31384c, (((long) segment.f31383b) + j8) - j4);
                    i2 = (int) ((((long) segment.f31383b) + j5) - j4);
                    while (i2 < min) {
                        if (bArr[i2] != b3) {
                            i2++;
                        }
                    }
                    j4 += (long) (segment.f31384c - segment.f31383b);
                    segment = segment.f31387f;
                    Intrinsics.m(segment);
                    j5 = j4;
                }
                return -1;
            }
            while (true) {
                long j9 = ((long) (segment.f31384c - segment.f31383b)) + j7;
                if (j9 > j5) {
                    break;
                }
                segment = segment.f31387f;
                Intrinsics.m(segment);
                j7 = j9;
            }
            while (j4 < j8) {
                byte[] bArr2 = segment.f31382a;
                int min2 = (int) Math.min((long) segment.f31384c, (((long) segment.f31383b) + j8) - j4);
                int i3 = (int) ((((long) segment.f31383b) + j5) - j4);
                while (i2 < min2) {
                    if (bArr2[i2] != b3) {
                        i3 = i2 + 1;
                    }
                }
                j7 = j4 + ((long) (segment.f31384c - segment.f31383b));
                segment = segment.f31387f;
                Intrinsics.m(segment);
                j5 = j7;
            }
            return -1;
            return ((long) (i2 - segment.f31383b)) + j4;
        }
        throw new IllegalArgumentException(("size=" + L0() + " fromIndex=" + j5 + " toIndex=" + j6).toString());
    }

    public long y1(@NotNull Source source) throws IOException {
        Intrinsics.p(source, "source");
        long j2 = 0;
        while (true) {
            long n2 = source.n2(this, PlaybackStateCompat.s3);
            if (n2 == -1) {
                return j2;
            }
            j2 += n2;
        }
    }

    @NotNull
    public InputStream z() {
        return new Buffer$inputStream$1(this);
    }

    public long z0(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "targetBytes");
        return G2(byteString, 0);
    }

    public int read(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "sink");
        return read(bArr, 0, bArr.length);
    }

    public int read(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "sink");
        _UtilKt.e((long) bArr.length, (long) i2, (long) i3);
        Segment segment = this.s;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i3, segment.f31384c - segment.f31383b);
        byte[] bArr2 = segment.f31382a;
        int i4 = segment.f31383b;
        ArraysKt.v0(bArr2, bArr, i2, i4, i4 + min);
        segment.f31383b += min;
        C0(L0() - ((long) min));
        if (segment.f31383b == segment.f31384c) {
            this.s = segment.b();
            SegmentPool.d(segment);
        }
        return min;
    }
}
