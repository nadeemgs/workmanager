package com.company.applicationname.app.ui
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.company.applicationname.app.domain.Category
import com.company.applicationname.app.repo.CategoryRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
private val categoryRepository: CategoryRepository
) : ViewModel() {

    var categoryResult: MutableLiveData<List<Category>> = MutableLiveData()
    var categoryError: MutableLiveData<String> = MutableLiveData()
    var categoryLoader: MutableLiveData<Boolean> = MutableLiveData()
    lateinit var disposableObserver: DisposableObserver<List<Category>>

    fun categoryResult(): LiveData<List<Category>> {
        return categoryResult
    }

    fun categoryError(): LiveData<String> {
        return categoryError
    }

    fun categoryLoader(): LiveData<Boolean> {
        return categoryLoader
    }

    fun loadCategorys(limit: Int, offset: Int) {

        disposableObserver = object : DisposableObserver<List<Category>>() {
            override fun onComplete() {

            }

            override fun onNext(categories: List<Category>) {
                categoryResult.postValue(categories)
                categoryLoader.postValue(false)
            }

            override fun onError(e: Throwable) {
                categoryError.postValue(e.message)
                categoryLoader.postValue(false)
            }
        }

        categoryRepository.getCategoreisFromDb(limit, offset)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .debounce(400, TimeUnit.MILLISECONDS)
            .subscribe(disposableObserver)

    }

    fun disposeElements() {
        if (null != disposableObserver && !disposableObserver.isDisposed) disposableObserver.dispose()
    }

}