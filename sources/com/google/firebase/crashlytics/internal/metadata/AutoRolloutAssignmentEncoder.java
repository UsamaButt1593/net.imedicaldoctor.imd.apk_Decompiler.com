package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

public final class AutoRolloutAssignmentEncoder implements Configurator {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23695a = 2;

    /* renamed from: b  reason: collision with root package name */
    public static final Configurator f23696b = new AutoRolloutAssignmentEncoder();

    private static final class RolloutAssignmentEncoder implements ObjectEncoder<RolloutAssignment> {

        /* renamed from: a  reason: collision with root package name */
        static final RolloutAssignmentEncoder f23697a = new RolloutAssignmentEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23698b = FieldDescriptor.d("rolloutId");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23699c = FieldDescriptor.d("parameterKey");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23700d = FieldDescriptor.d("parameterValue");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f23701e = FieldDescriptor.d("variantId");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f23702f = FieldDescriptor.d("templateVersion");

        private RolloutAssignmentEncoder() {
        }

        /* renamed from: b */
        public void a(RolloutAssignment rolloutAssignment, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23698b, rolloutAssignment.e());
            objectEncoderContext.s(f23699c, rolloutAssignment.c());
            objectEncoderContext.s(f23700d, rolloutAssignment.d());
            objectEncoderContext.s(f23701e, rolloutAssignment.g());
            objectEncoderContext.c(f23702f, rolloutAssignment.f());
        }
    }

    private AutoRolloutAssignmentEncoder() {
    }

    public void a(EncoderConfig<?> encoderConfig) {
        RolloutAssignmentEncoder rolloutAssignmentEncoder = RolloutAssignmentEncoder.f23697a;
        encoderConfig.b(RolloutAssignment.class, rolloutAssignmentEncoder);
        encoderConfig.b(AutoValue_RolloutAssignment.class, rolloutAssignmentEncoder);
    }
}
