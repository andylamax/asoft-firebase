package serialization

import com.asofttz.firebase.tools.gson
import kotlin.test.Test
import kotlin.test.assertEquals

class ZonedDateTimeTest {

    private val obj = TestObject()

    @Test
    fun convertToJson() {
        println(gson.serializer.toJson(obj))
    }

    @Test
    fun convertFromJson() {
        val json = """{"id":45,"time":"30-06-2019 14:32:54.315"}"""
        val newObj = gson.serializer.fromJson(json, TestObject::class.java)
        assertEquals(45, newObj.id)
        assertEquals(14, newObj.time.hour)
    }
}