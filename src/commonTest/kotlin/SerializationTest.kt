import kotlinx.serialization.json.Json
import tz.co.asoft.auth.User
import kotlin.test.Test

class SerializationTest {
    val json = Json.stringify(User.serializer(), User.fake)

    @Test
    fun should_serialize() {
        println(json)
    }
}