package com.google.firebase.remoteconfig.interop.rollouts;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

public final class AutoRolloutAssignmentEncoder implements Configurator {

    /* renamed from: a  reason: collision with root package name */
    public static final int f24971a = 2;

    /* renamed from: b  reason: collision with root package name */
    public static final Configurator f24972b = new AutoRolloutAssignmentEncoder();

    private static final class RolloutAssignmentEncoder implements ObjectEncoder<RolloutAssignment> {

        /* renamed from: a  reason: collision with root package name */
        static final RolloutAssignmentEncoder f24973a = new RolloutAssignmentEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f24974b = FieldDescriptor.d("rolloutId");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f24975c = FieldDescriptor.d("variantId");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f24976d = FieldDescriptor.d("parameterKey");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f24977e = FieldDescriptor.d("parameterValue");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f24978f = FieldDescriptor.d("templateVersion");

        private RolloutAssignmentEncoder() {
        }

        /* renamed from: b */
        public void a(RolloutAssignment rolloutAssignment, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f24974b, rolloutAssignment.f());
            objectEncoderContext.s(f24975c, rolloutAssignment.h());
            objectEncoderContext.s(f24976d, rolloutAssignment.d());
            objectEncoderContext.s(f24977e, rolloutAssignment.e());
            objectEncoderContext.c(f24978f, rolloutAssignment.g());
        }
    }

    private AutoRolloutAssignmentEncoder() {
    }

    public void a(EncoderConfig<?> encoderConfig) {
        RolloutAssignmentEncoder rolloutAssignmentEncoder = RolloutAssignmentEncoder.f24973a;
        encoderConfig.b(RolloutAssignment.class, rolloutAssignmentEncoder);
        encoderConfig.b(AutoValue_RolloutAssignment.class, rolloutAssignmentEncoder);
    }
}
