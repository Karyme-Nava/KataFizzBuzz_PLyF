val unidades = arrayOf("", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve")
val num11a19 = arrayOf("", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve")
val decenas = arrayOf("", "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa")
val centenas = arrayOf("", "cien", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos")
fun num1al99(n: Int): String{
    return when{
        n in 1..9 -> unidades[n]
        n%10==0 -> decenas[n/10]
        n in 11..19 -> num11a19[n-10]
        n in 21..29 -> "veinti${unidades[n%20]}"
        else -> "${decenas[n/10]} y ${unidades[n%10]}"
    }
}

fun num100al999(n: Int): String{
    if(n%100!=0){
        if(n/100==1) return "ciento ${num1al99(n%100)}"
        else return "${centenas[n/100]} ${num1al99(n%100)}"
    } else return centenas[n/100]
}

fun num1000al999999(n: Int): String{
    var num = ""
    if(n/1000 in 2..99) num = "${num1al99(n/1000)} "
    else if(n/1000>=100)num = "${num100al999(n/1000)} "
    num+="mil"
    if(n%1000 in 1..99) num += " ${num1al99(n%1000)}"
    else num += " ${num100al999(n%1000)}"
    return num
}

fun numeroEscrito(n: Int): String{
    var num = when{
        n==0 -> "cero"
        n in 1..99 -> num1al99(n)
        n in 100..999 -> num100al999(n)
        n in 1000..999999 -> num1000al999999(n)
        else -> "un millón"
    }
    return num.replaceFirstChar { it.uppercase() }
}

fun kataFizzBuzz(n: Int): String{
    return when{
        n%5 == 0 && n%3 == 0-> "FizzBuzz!"
        n%5 == 0 -> "Fizz!"
        n%3 == 0 -> "Buzz!"
        else -> numeroEscrito(n)
    }
}

fun main(args: Array<String>) {
    println(kataFizzBuzz(5))
    println(kataFizzBuzz(9))
    println(kataFizzBuzz(15))
    println(kataFizzBuzz(100007))
    println(kataFizzBuzz(56893))
    println(kataFizzBuzz(494))
    println(kataFizzBuzz(299614))
    println(kataFizzBuzz(1261))
    println(kataFizzBuzz(98716))
    println(kataFizzBuzz(1000000))
}