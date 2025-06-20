package com.google.firebase.encoders.json;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class JsonDataEncoderBuilder implements EncoderConfig<JsonDataEncoderBuilder> {

    /* renamed from: e  reason: collision with root package name */
    private static final ObjectEncoder<Object> f24336e = new a();

    /* renamed from: f  reason: collision with root package name */
    private static final ValueEncoder<String> f24337f = new b();

    /* renamed from: g  reason: collision with root package name */
    private static final ValueEncoder<Boolean> f24338g = new c();

    /* renamed from: h  reason: collision with root package name */
    private static final TimestampEncoder f24339h = new TimestampEncoder();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, ObjectEncoder<?>> f24340a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Map<Class<?>, ValueEncoder<?>> f24341b = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ObjectEncoder<Object> f24342c = f24336e;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f24343d = false;

    private static final class TimestampEncoder implements ValueEncoder<Date> {

        /* renamed from: a  reason: collision with root package name */
        private static final DateFormat f24345a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f24345a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        private TimestampEncoder() {
        }

        /* renamed from: b */
        public void a(@NonNull Date date, @NonNull ValueEncoderContext valueEncoderContext) throws IOException {
            valueEncoderContext.m(f24345a.format(date));
        }
    }

    public JsonDataEncoderBuilder() {
        a(String.class, f24337f);
        a(Boolean.class, f24338g);
        a(Date.class, f24339h);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void m(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    @NonNull
    public DataEncoder j() {
        return new DataEncoder() {
            public void a(@NonNull Object obj, @NonNull Writer writer) throws IOException {
                JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(writer, JsonDataEncoderBuilder.this.f24340a, JsonDataEncoderBuilder.this.f24341b, JsonDataEncoderBuilder.this.f24342c, JsonDataEncoderBuilder.this.f24343d);
                jsonValueObjectEncoderContext.y(obj, false);
                jsonValueObjectEncoderContext.I();
            }

            public String encode(@NonNull Object obj) {
                StringWriter stringWriter = new StringWriter();
                try {
                    a(obj, stringWriter);
                } catch (IOException unused) {
                }
                return stringWriter.toString();
            }
        };
    }

    @NonNull
    public JsonDataEncoderBuilder k(@NonNull Configurator configurator) {
        configurator.a(this);
        return this;
    }

    @NonNull
    public JsonDataEncoderBuilder l(boolean z) {
        this.f24343d = z;
        return this;
    }

    @NonNull
    /* renamed from: p */
    public <T> JsonDataEncoderBuilder b(@NonNull Class<T> cls, @NonNull ObjectEncoder<? super T> objectEncoder) {
        this.f24340a.put(cls, objectEncoder);
        this.f24341b.remove(cls);
        return this;
    }

    @NonNull
    /* renamed from: q */
    public <T> JsonDataEncoderBuilder a(@NonNull Class<T> cls, @NonNull ValueEncoder<? super T> valueEncoder) {
        this.f24341b.put(cls, valueEncoder);
        this.f24340a.remove(cls);
        return this;
    }

    @NonNull
    public JsonDataEncoderBuilder r(@NonNull ObjectEncoder<Object> objectEncoder) {
        this.f24342c = objectEncoder;
        return this;
    }
}
