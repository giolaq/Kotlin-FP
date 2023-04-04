data class Product(
        val id: String,
        val basePrice: Double,
        val tax: Double,
)

fun greaterThan10(products: List<Product>): Map<String, Double> {
    val results = hashMapOf<String, Double>()
    for (product: Product in products) {
        val totalPay = product.basePrice + product.tax
        if (totalPay > 10) {
            results[product.id] = totalPay
        }
    }
    return results
}

fun greaterThan10Functional(products: List<Product>): Map<String, Double> =
        products
                .filter { (it.basePrice + it.tax) > 10 }
                .associate { it.id to (it.basePrice + it.tax) }


fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    // Example of a lambda function with non-local return
    val lambdaResult = numbers.map {
        if (it == 3) return@map "three"
        else it.toString()
    }
    println("Lambda function result: $lambdaResult") // Prints [1, 2, three, 4, 5]

    // Example of an anonymous function with local return
    val anonymousResult = numbers.map(fun(num): String {
        if (num == 3) return "three"
        else return num.toString()
    })
    println("Anonymous function result: $anonymousResult") // Prints [1, 2, three, 4, 5]

}