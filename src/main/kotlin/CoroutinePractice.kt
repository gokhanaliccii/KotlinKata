import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(InternalCoroutinesApi::class)
fun main() = runBlocking{
    GlobalScope.launch {
        print("test")
    }

    val intFlow = intFlow()
    intFlow.collect(object : FlowCollector<Int>{
        override suspend fun emit(value: Int) {
            print(value)
        }
    })
}

fun intFlow() : Flow<Int> = flowOf(1)