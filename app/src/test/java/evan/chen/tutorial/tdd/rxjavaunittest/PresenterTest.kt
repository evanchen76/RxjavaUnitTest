package evan.chen.tutorial.tdd.rxjavaunittest

import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Test

import org.junit.Assert.*

class PresenterTest {

    @Test
    fun getDataTest() {
        val repository = mockk<IRepository>()

        //Mock一個repository，回傳Observable
        every { repository.getSingleString()}
            .answers {
                Single.just("Test")
            }

        val presenter = Presenter(repository)
        presenter.getSomeBoolean()

        assertEquals("Test Plus", presenter.someString)
    }

    @Test
    fun testScheduler(){
        val testObserver = TestObserver<String>()

        val schedulerProvider = TrampolineSchedulerProvider()

        Single.just("1")
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.mainThread())
            .subscribe(testObserver)

        testObserver.assertResult("1")
    }
}
