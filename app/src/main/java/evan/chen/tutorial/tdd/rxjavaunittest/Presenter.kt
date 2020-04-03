package evan.chen.tutorial.tdd.rxjavaunittest

class Presenter (private val repository: IRepository){

    lateinit var someString: String

    fun getSomeBoolean(){

        repository.getSingleString()
            .subscribe({ data ->
                someString = "$data Plus"
            },
                { throwable ->
                    println(throwable)
                })
    }
}