package com.example.mvvmbuttonexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _counter = MutableLiveData<CounterModel>()
    val counter: LiveData<CounterModel> get() = _counter

    init
    {
        zero()
    }

    fun increment() {
        val currentCounter = _counter.value ?: CounterModel(0)
        currentCounter.count += 1
        _counter.value = currentCounter
    }
    fun zero()
    {
        _counter.value = CounterModel(0)
    }
}
