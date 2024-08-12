package ladd.marshall.androidmvvmexample.model.models

data class Response(
    val status: String,
    val data: List<Employee>,
    val message: String
)

