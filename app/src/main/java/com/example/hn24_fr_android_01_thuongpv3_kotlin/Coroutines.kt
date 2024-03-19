package com.example.trainingkotlin.lectures.coroutines

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

fun main() {
    GlobalScope.launch {
        delay(1000L)
//        sayHello()
        print("World ")
        delay(1000L)
    }
    print("Hello ")
    Thread.sleep(2000L)
    print("Kotlin")

//    runBlocking {
//        print("Hello ")
//        delay(1000L)
//    }
//    print("World ")

//    Compare Coroutine vs Thread
//    runBlocking {
//        repeat(20){
//            launch {
//                delay(5000L)
//                print(".")
//            }
//        }
//    }
//    val thread = Thread{
//        for (i in 1..20){
//            Thread.sleep(5000L)
//            print(".")
//        }
//    }
//    thread.start()

//    //suspend function
//    runBlocking {
//        print("kotlin ")
//        delay(2000L)
//        sayHello()
//        print(" world")
//    }

//    //coroutine context
//    runBlocking(Dispatchers.IO+Job()) {  }
//    GlobalScope.launch(newSingleThreadContext("nstc")+
//            CoroutineName("cn")+
//            NonCancellable){}
//    runBlocking<Unit> {
//        println(" my context is: $coroutineContext")
//    }

    //withContext
//    newSingleThreadContext("thr1").use { ctx1 ->
//        println("ctx1 -${Thread.currentThread().name}")
//        newSingleThreadContext("thr2").use { ctx2->
//            println("ctx2 -${Thread.currentThread().name}")
//            runBlocking(ctx1) {
//                println("start ctx1 -${Thread.currentThread().name}")
//                withContext(ctx2){
//                    println("working ctx2 -${Thread.currentThread().name}")
//                }
//                println("back to ctx1 -${Thread.currentThread().name}")
//            }
//        }
//        println("out ctx2 block -${Thread.currentThread().name}")
//    }
//    println("out ctx2 block -${Thread.currentThread().name}")

////some dispatcher and thread
//runBlocking {
//    launch(Dispatchers.Unconfined) {
//        println(" un: work: ${Thread.currentThread().name}")
//    }
//    launch(Dispatchers.Default) {
//        println(" de: work: ${Thread.currentThread().name}")
//    }
//    launch(newSingleThreadContext("nstc")) {
//        println(" nstc: work: ${Thread.currentThread().name}")
//    }
//}

//        // un and main
//    runBlocking {
//        launch(Dispatchers.Unconfined){
//            println(" un: work: ${Thread.currentThread().name}")
//            delay(1000L)
//            println(" un: work: ${Thread.currentThread().name}")
//        }
//    }

//     join
//    runBlocking {
//        val job = GlobalScope.launch {
//            delay(1000L)
//            print("world")
//        }
//        print("hello ")
//        job.join()
//        print(" kotlin")
//    }

    //cancellation
//    runBlocking {
//        val job = launch {
//            repeat(100){i -> println(">> $i")
//            delay(500L)}
//        }
//        delay(2100L)
//        println("waiting")
//        job.cancel()
//        println("quit")
//    }

//    // cancel
//    runBlocking {
//        val st = System.currentTimeMillis()
//        val job = launch(Dispatchers.Default){
//            var  npt = st
//            var i =0
//            while (i<5){
//                if (System.currentTimeMillis()>= npt){
//                    println("job: .. ${ i++}")
//                    npt+=500L
//                }
//                if (i==3){
//                    awaitCancellation()
//                }
//            }
//        }
//        delay(1300L)
//        println("waiting")
//        job.cancel()
//        println("quit")
//    }

//    //use finally
//    runBlocking {
//        val job = launch(){
//            try {
//                repeat(1000){i ->
//                    println("job: .. ${i}")
//                    delay(500L)
//                }
//            }finally {
//                println("finally")
//            }
//        }
//        delay(1300L)
//        println("waiting")
//        job.cancel()
//        println("quit")
//    }

//    // noncancellable
//    runBlocking {
//        val job = launch(){
//            try {
//                repeat(1000){i ->
//                    println("job: .. ${i}")
//                    delay(500L)
//                }
//            }finally {
//                withContext(NonCancellable){
//                    println("finally")
//                    delay(500L)
//                    println("noncancellable")
//                }
//            }
//        }
//        delay(1300L)
//        println("waiting")
//        job.cancel()
//        println("quit")
//    }

    // timeout => withtimeoutornull
//    runBlocking {
//        withTimeout(1300L){
//            repeat(100){i ->
//                print(">> $i")
//                delay(500L)
//            }
//        }
//    }

    //async
//    runBlocking {
//        val time = measureTimeMillis {
//            val one = async { display1() }
//            val two = async { display2() }
//            println( "ans = ${one}")
//            println( "ans = ${two}")
//        }
//        println("completed: $time ms")
//    }

//    // lazy async
//    runBlocking {
//        val time = measureTimeMillis {
//            val one = async(start = CoroutineStart.LAZY) { display1() }
//            val two = async(start = CoroutineStart.LAZY){ display2() }
//            one.start()
//            two.start()
//            println( "ans = ${one.await()+two.await()}")
//        }
//        println("completed: $time ms")
//    }

//    //coroutine scope
//    CoroutineScope(Dispatchers.Default).launch {
//        launch {  }
//        launch {  }
//        async {  }
//
//    }
//    runBlocking {
//        launch {
//            delay(200L)
//            println("code1")
//        }
//        coroutineScope {
//            launch {
//                delay(500L)
//                println("code2")
//            }
//            println("code3")
//        }
//        println("code4")
//    }

//    //cancel coroutine scope
//    runBlocking {
//        val rq = launch {
//            launch {
//                delay(100L)
//                print("job2: child")
//                delay(1000L)
//                println("job2: cancel")
//            }
//        }
//        delay(500L)
//        rq.cancel()
//        delay(1000L)
//        println("something")
//    }

//    // globalscope
//    runBlocking {
//        val rq = launch {
//            GlobalScope.launch {
//                println("job1: start")
//                delay(1000L)
//                println("job1 : end")
//            }
//            launch {
//                delay(100L)
//                print("job2: child")
//                delay(1000L)
//                println("job2: cancel")
//            }
//        }
//        delay(500L)
//        rq.cancel()
//        delay(1000L)
//        println("something")
//    }


//    //exception
//    runBlocking {
//        GlobalScope.launch {
//            println("throwing exception")
//            throw IndexOutOfBoundsException()
//            println("Unreached")
//        }
//    }
//    runBlocking {
//        val deferred= GlobalScope.async {
//            println("throwing exception")
//            throw ArithmeticException()
//            println("Unreached")
//        }
//        deferred.await()
//    }

//    //catch ex
//    runBlocking {
//        GlobalScope.launch {
//            try {
//                println("throwing exception")
//                throw IndexOutOfBoundsException()
//                println("Unreached")
//            }catch (e:IndexOutOfBoundsException){
//                println("Catch launch")
//            }
//
//        }
//        val deferred= GlobalScope.async {
//            println("throwing exception")
//            throw ArithmeticException()
//            println("Unreached")
//        }
//        deferred.await()
//        try {
//            deferred.await()
//        }catch (e: ArithmeticException){
//            println("Catch async")
//        }
//    }

//    // coroutineExceptionHandler
//    runBlocking {
//        val handler= CoroutineExceptionHandler{coroutineContext, throwable ->
//            println("caught ${throwable.suppressed.contentToString()}")
//        }
//        val job = GlobalScope.launch(handler){
//            throw AssertionError()
//        }
//        val deferred = GlobalScope.launch(handler){
//            throw ArithmeticException()
//        }
//        joinAll(job,deferred)
//    }

//    //SupervisionJob
//    runBlocking {
//        val supervisor = SupervisorJob()
//        with(CoroutineScope(coroutineContext+supervisor)){
//            val fc = launch(CoroutineExceptionHandler{_, throwable ->  }){
//                println("fc")
//                throw AssertionError("fc is cancelled")
//            }
//            val sc = launch {
//                fc.join()
//                println("fc:${fc.isCancelled}")
//                try {
//                    delay(1000L)
//                }finally {
//                    println("sc is cancelled")
//                }
//            }
//            fc.join()
//            println("cancel supervision")
//            supervisor.cancel()
//            sc.join()
//        }
//    }

//    //SupervisionScope
//    runBlocking {
//        val handler= CoroutineExceptionHandler{coroutineContext, throwable ->
//            println("caught ${throwable}")
//        }
//        supervisorScope {
//            val first = launch(handler){
//                println("child throws exception")
//                throw AssertionError()
//            }
//            val second = launch {
//                delay(100L)
//                println("completing")
//            }
//        }
//        println("completed")
//    }
}

//suspend fun sayHello(i:Int){
//
////    delay(1000L)
////    print("Hello")
//    println("job: .. ${i}")
//}
//
//suspend fun display1(): Int{
//    delay(1000L)
//    return 1
//}
//suspend fun display2(): Int{
//    delay(1000L)
//    return 2
//}
//
//class MA: CoroutineScope{
//    override val coroutineContext: CoroutineContext
//        get() = Dispatchers.IO
//}