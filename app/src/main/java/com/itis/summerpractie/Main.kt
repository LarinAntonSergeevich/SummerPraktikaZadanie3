package com.itis.summerpractie

import android.util.Log

fun main() {

}

fun myNameFun(arg1: String, arg2: Int = 0): String {

    fun calc(arg2: Int): String {
        return "TEST: $arg2"
    }

    "ANDOIRD: ${arg1.length}, ${calc(arg2)}"
    return arg1 + arg2
}

fun whenTest(color: String, isTest: Boolean): String = when {
    isTest && color.length > 10 -> "Green"
    color.length > 5 -> {
        myNameFun("Test")
        "Red"
    }

    color == "yellow" -> "Yellow"
    else -> "BLACK"
}

// win: ctrl+alt+L
// mac: cmd+opt+L
fun listTest() {
    val list = arrayOf(1, 2, 3, 4)
    val list1 = ArrayList<Int>()
    list1.add(1)
    list1.add(1)
    list1.add(1)
    list1.add(1)
    val list11 = arrayListOf(1, 2, 3, 4)
    val list112 = listOf(1, 2, 3, 4)

    list11.addAll(list112)
    list11 + list112

    // java
//        for (int index = 0, index <10, index++) {
//
//        }
    for (element in 10 downTo -40 step 4) {

    }

    list11.forEach {
        Log.e("asd", "Our list: $it")
    }

    val listOFString = listOf(
        Student(name = "Julie Harrison", age = 17),
        Student(name = "Julie TEst Harrison", age = 22),
        Student(name = "Julie Test Harrison", age = 33),
    )
    val newlist: List<String> = listOFString.map {
        it.phone
    }
    listOFString.filter { student ->
        student.age > 20
    }
    try {
        val s1: Student = listOFString.first { it.age > 30 }
    } catch (ex: NoSuchElementException) {

    } catch (ex: RuntimeException) {

    } finally {

    }

    val s1: Student = listOFString.first { it.age > 30 }
    val s2: Student? = listOFString.firstOrNull { it.age > 30 }

    listOFString.find { it.age == 77 }
    val sMax: Student = listOFString.maxBy { it.age }
    listOFString.sortedWith(
        compareBy<Student> {
            it.age
        }.thenByDescending {
            it.name.length
        }
    )
    val map: Map<String, Student> = listOFString.associateBy { it.name }

    list11.toSet().toList().toSet().toList()
    val set = setOf(1, 2, 3, 4, 1)
    set.toList()
}

fun mapTest() {
    val map = HashMap<Int, String>()
    map[0] = "sadas"
    map[1] = "asd"
    val s = map[1]
    map.getOrElse(1) {
        Student(name = "June Carrillo", age = 8669)
    }
    map.getOrDefault(1, Student("Default"))

    map.forEach { key, value ->

    }

    val map2 = mapOf(
        0 to "asdasd",
        1 to "asd",
        3 to "test",
    )

    val map3 = hashMapOf(
        0 to "asdasd",
        1 to "asd",
        3 to "test",
    )

    map2.toList()

    listOf(Month.Apr, Month.May).maxOf {
        it.order
    }

}

enum class Month(val order: Int) {
    Jan(0), Feb(2), March(1), Apr(8), May(10)
}

interface Test {
    fun move()
}

class Student(
    name: String,
    age: Int = 18,
) : User(name, age), Test {

    var phone: String = ""
        set(value) {
            move()
            field = value
        }
        get() {
            return "+7911$name"
        }


    override fun move() {
        TODO("Not yet implemented")
    }

    override val email: String
        get() = "Student"

}

abstract class User(
    val name: String,
    val age: Int,
) {

    abstract val email: String
}

data class Song(
    val name: String,
    val author: Author
)

data class Author(
    val name: String,
    val age: Int
)