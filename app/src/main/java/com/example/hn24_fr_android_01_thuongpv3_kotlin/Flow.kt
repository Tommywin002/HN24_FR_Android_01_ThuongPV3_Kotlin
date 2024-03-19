package com.example.trainingkotlin.lectures.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis


fun main() {
    //flow
    runBlocking {
        launch {
            println(Thread.currentThread().name)
            for (k in 1..3) {
                delay(900L)
                println("not blocked $k")
            }
        }
        val time = measureTimeMillis { foo1().collect { value -> println(value) } }
        println("$time s")
    }
//
//    //cancelation
//    runBlocking {
//        withTimeoutOrNull(5000L) {
//            foo2().collect { value -> println(value) }
//        }
//        println("done")
//    }
//
//    //create flow
//    runBlocking {
//        val data = flowOf(1,"abc", 3.4, "def")
//        data.collect { println(it) }
//        listOf(1,"abc", 3.4, "def").asFlow().collect { println(it) }
//    }

//    //take()
//    runBlocking {
//        numbers().take(3).collect { println(it) }
//    }

//    //transform()
//    runBlocking {
//        (1..9).asFlow().transform { value ->
//            if (value % 2 == 0) {
//                emit(value * value)
//                emit(value * value * value)
//            }
//        }.collect { value -> println(value) }
//    }

//    //map()
//    runBlocking {
//        (1..3).asFlow().map { it*it }.collect { println(it) }
//    }

//    //filter()
//    runBlocking {
//        (1..5).asFlow().filter {
//            println("filter $it")
//            it % 2 == 0
//        }.collect { println("collect $it") }
//    }

//    //onEach()
//    runBlocking {
//        val nums = (1..3).asFlow().onEach { delay(1000L) }
//        val startTime = System.currentTimeMillis()
//        nums.collect { value -> println("$value at ${System.currentTimeMillis()-startTime} ms") }
//    }

//    //reduce()
//    runBlocking {
//        val sum = listOf("a", "b", "c", "d").asFlow().reduce { a, b ->
//            println("before $a")
//            println("after $b")
//            a+b
//        }
//        println("rs: $sum")
//        val sumInt = (1..4).asFlow().reduce { a, b ->
//            println("before $a")
//            println("after $b")
//            a+b
//        }
//        println("rs: $sumInt")
//    }

//    //fold()
//    runBlocking {
//        val sumInt = (1..4).asFlow().fold(initial = 10) { a, b ->
//            println("before $a")
//            println("after $b")
//            a+b
//        }
//        println("rs: $sumInt")
//        val sum = listOf("a", "b", "c", "d").asFlow().fold(initial = "xyz") { a, b ->
//            println("before $a")
//            println("after $b")
//            a + b
//        }
//        println("rs: $sum")
//    }

//    //first()
//    runBlocking {
//        val f1: Int = (1..9).asFlow().first()
//        println(f1)
//        val f2: Int = (1..9).asFlow().first { it %10==0 }
//        println(f2)
//    }

//    //single(),singleOrNull()
//    runBlocking {
//        val a = listOf(10).asFlow().single()
//        //listOf(1,2).asFlow().single()
//        //listOf<Int>().asFlow().single()
//        println(a)
//
//        val b = listOf(10).asFlow().singleOrNull()
//        //listOf(1,2).asFlow().singleOrNull()
//        val c = listOf<Int>().asFlow().singleOrNull()
//        println(b)
//        println(c)
//    }

//    //zip()
//    runBlocking {
//        val nums=(1..3).asFlow()
//        val str = flowOf("a","b","c")
//        nums.zip(str){ a, b -> "$a - $b"}.collect { println(it) }
//    }

//    //combine()
//    runBlocking {
//        val nums = (1..3).asFlow().onEach { delay(300) }
//        val str = flowOf("a", "b", "c").onEach { delay(400) }
//        val startTime = System.currentTimeMillis()
//        nums.combine(str) { a, b -> "$a - $b" }.collect { value ->
//            println("$value at ${System.currentTimeMillis() - startTime} ms")
//        }
//    }

//    //flatMapConcat
//    runBlocking {
//        val startTime = System.currentTimeMillis()
//        (1..3).asFlow().onEach { delay(100) }.flatMapConcat { rqFlow(it) }.collect { value ->
//            println("$value at ${System.currentTimeMillis() - startTime} ms")
//        }
//    }

//    //flatMapMerge
//    runBlocking {
//        val startTime = System.currentTimeMillis()
//        (1..3).asFlow().onEach { delay(100) }.flatMapMerge { rqFlow(it) }.collect { value ->
//            println("$value at ${System.currentTimeMillis() - startTime} ms")
//        }
//    }

//    //flatMapLastest
//    runBlocking {
//        val startTime = System.currentTimeMillis()
//        (1..3).asFlow().onEach { delay(100) }.flatMapLatest { rqFlow(it) }.collect { value ->
//            println("$value at ${System.currentTimeMillis() - startTime} ms")
//        }
//        (1..3).asFlow().onEach { delay(100) }.flatMapLatest { rqFlow2(it) }.collect { value ->
//            println("$value at ${System.currentTimeMillis() - startTime} ms")
//        }
//    }

//    //flowContext
//    runBlocking { foo3().collect { value -> log("Collected $value") } }

//    //flowOn
//    runBlocking {
//        foo4().collect { value -> log("Collected $value") }
//    }

//    //flow exception
//    runBlocking {
//        foo5().catch { cause -> emit("Caught $cause") }
//        .collect { value -> println("value = $value") }
//        foo6().onEach { i -> println("3/$i =${3/i}") }
//            .catch { cause -> println("Caught $cause") }.collect()
//    }

//    //launchln
//    runBlocking {
//        events().onEach { event -> println("Ev: $event") }.launchIn(this)
//        println("Done")
//    }

//    //onCompletion
//    runBlocking {
//        foo7().onCompletion { println("Done") }.collect { value -> println(value) }
//        foo8().onCompletion { cause -> if (cause!=null) println("Flow completed") }
//            .catch { cause -> println("Caught") }.collect { value -> println(value) }
//    }

}

fun foo1(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(1000L)
        emit(i)
    }
}

fun numbers(): Flow<Int> = flow {
    try {
        emit(1)
        emit(2)
        println("this line not execute")
        emit(3)
    } catch (e: CancellationException) {
        println("ex")
    } finally {
        println("close")
    }
}

fun foo2(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(2000L)
        println("Emitting $i")
        emit(i)
    }
}

fun rqFlow(i: Int): Flow<String> = flow {
    emit("$i : F")
    delay(500)
    emit("$i : S")
}
fun rqFlow2(i: Int): Flow<String> = flow {
    emit("$i : F")
    emit("$i : S")
}

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun foo3(): Flow<Int> = flow {
    log("Started")
    for (i in 1..3) {
        emit(i)
    }
}

fun foo4(): Flow<Int> = flow {
    for (i in 1..3) {
        Thread.sleep(100)
        log("Emitting $i")
        emit(i)
    }
}.flowOn(Dispatchers.Default)

fun foo5(): Flow<String> = flow {
    for (i in 3 downTo -3) {
        println("3/$i =${3/i}")
        emit(i.toString())
    }
}

fun foo6(): Flow<Int> = flow {
    for (i in 3 downTo -3) {
        emit(i)
    }
}

fun events(): Flow<Int> = (1..3).asFlow().onEach { delay(100) }

fun foo7(): Flow<Int> = (1..3).asFlow()

fun foo8(): Flow<Int> = flow {
    emit(1)
    throw  RuntimeException()
}