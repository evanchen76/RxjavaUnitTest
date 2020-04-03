package evan.chen.tutorial.tdd.rxjavaunittest

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchedulerProvider :ISchedulerProvider{
    override fun computation() = Schedulers.computation()
    override fun mainThread() = AndroidSchedulers.mainThread()
    override fun io() = Schedulers.io()
}