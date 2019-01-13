import javafx.application.Application.launch
import kotlinx.coroutines.*

fun main() {
    //basic()
    //block()
    //block2()
    //jobWait()
    //laun()
    //scop()

//    runBlocking {
//        launch { doWorld() }
//        println("Hello,")
//    }

    runBlocking {
        repeat(100_000) { // launch a lot of coroutines
                i ->
            run {
                launch {
                    delay(1000L)
                    println("$i")
                }
            }
        }
    }
}

fun basic() {
    GlobalScope.launch {
        delay(1000) //1s
        print("Trafder")
    }

    print("Shudipto ")
    //keep jvm alive
    Thread.sleep(2000) //2s
}

//run blocking
fun block() {
    GlobalScope.launch {
        delay(1000)//1s
        print("Sketchpad")
    }
    print("Android")
    runBlocking {
        delay(2000)//2s
    }
}

fun block2() = runBlocking {
    GlobalScope.launch {
        delay(1000)//1s
        print("Sketchpad")
    }
    print("Android")
    delay(2000)//2s
}

//waiting for job
fun jobWait() = runBlocking {
    val job = GlobalScope.launch {
        delay(1000)
        print("Trafder")
    }

    print("Shudipto ")
    job.join()
}

fun laun() = runBlocking {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
}

fun scop() = runBlocking {
    // this: CoroutineScope
    launch {
        delay(200L)
        println("Task from runBlocking")
    }

    coroutineScope {
        // Creates a new coroutine scope
        launch {
            delay(500L)
            println("Task from nested launch")
        }

        delay(100L)
        println("Task from coroutine scope") // This line will be printed before nested launch
    }

    println("Coroutine scope is over") // This line is not printed until nested launch completes
}

// this is your first suspending function
suspend fun doWorld() {
    delay(1000L)
    println("World!")
}
