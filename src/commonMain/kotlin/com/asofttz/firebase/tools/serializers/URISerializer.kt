package com.asofttz.firebase.tools.serializers

import kotlinx.serialization.*
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializer(forClass = Any::class)
object URISerializer : KSerializer<Any> {
    override val descriptor: SerialDescriptor
        get() = SerialClassDescImpl("Any")

    override fun deserialize(decoder: Decoder): Any {
        return decoder.decodeString()
    }

    override fun serialize(encoder: Encoder, obj: Any) {
        return encoder.encodeString(obj.toString())
    }
}