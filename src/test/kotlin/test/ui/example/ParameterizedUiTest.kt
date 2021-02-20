//package test.ui.example
//
//import java.lang.reflect.*
//import java.util.Random
//import kotlin.random.*
//import kotlin.time.*
//
//class ParameterizedUiTest {
//
//}
//
//@ExperimentalTime
//fun main() {


//    val array = Array(20) {
//        val second = Array(10_000_000) { Pair("one", "two") }
//        measureTimedValue {
//            second.asSequence().mapNotNull {
//                it.first.plus("gfd")
//                it.second.plus("gfd")
//                it
//            }.toMap()
//        }.duration
//    }
//    println(array.sumBy { it.inMicroseconds.toInt() } / 20)
//
//    val array1 = Array(1) {
//        measureTimedValue {
//            second.map {
//                Random().nextInt() + Random().nextInt() + Random().nextInt() + Random().nextInt() + Random().nextInt() + Random().nextInt() + Random().nextInt() + Random().nextInt() + Random().nextInt() + Random().nextInt() + Random().nextInt() + Random().nextInt() + Random().nextInt() + Random().nextInt() + Random().nextInt()
//            }
//        }.duration
//    }
//    //596397
//    println(array1[0].inSeconds)
//
//}
//internal fun Iterable<Method>.toCoverMap(
//    bundle: BundleCounter,
//    onlyCovered: Boolean
//): Map<Method, CoverMethod> = bundle.packages.asSequence().let { packages ->
//    val map = measureTimedValue {
//        packages.flatMap { it.classes.asSequence() }.flatMap { c ->
//            c.methods.asSequence().map { m -> Pair(c.fullName, m.sign) to m }
//        }.toMap()
//    }.apply { println("toCoverMap map duration ${duration.inSeconds} ") }.value
//    measureTimedValue {
//        mapNotNull { m ->
//            val covered = measureTimedValue {
//                m.toCovered(map[m.ownerClass to m.signature()])
//            }.apply { println("mapNotNull covered duration ${duration.inSeconds}") }.value
//            measureTimedValue {
//                covered.takeIf { !onlyCovered || it.count.covered > 0 }?.let { m to it }
//            }.apply { println("mapNotNull covered.takeIf duration ${duration.inSeconds}") }.value
//        }.toMap()
//    }.apply { println("toCoverMap mapNotNull duration ${duration.inSeconds}") }.value
//}
//416203 vs 569290
//92058  vs 176180
//96008  vs 178987
//957070 vs 1351580
//1145780 vs 1512246
//498188 vs 653317
//1501033 vs
