package com.memandis.svayantra.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memandis.svayantra.usecase.svayantra.AddControllerUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
class HomeViewModel(
    private val addControllerUseCase: AddControllerUseCase
) : ViewModel() {

    private val _intentChannel = MutableStateFlow<HomeViewIntent>(HomeViewIntent.None)

    private val _uiEvents: MutableLiveData<HomeUIEvent> = MutableLiveData()
    val uiEvents: LiveData<HomeUIEvent>
        get() = _uiEvents

    init {
        _intentChannel
            .onEach { viewIntent ->
                when (viewIntent) {
                    is HomeViewIntent.AddSvaYantraController -> addSvaYantraControl(svaYantraControl = viewIntent)
                    HomeViewIntent.None -> Unit
                }
            }
            .launchIn(viewModelScope)
    }

    suspend fun processIntent(intentHome: HomeViewIntent) = _intentChannel.emit(intentHome)

    private suspend fun addSvaYantraControl(svaYantraControl: HomeViewIntent.AddSvaYantraController) {
        if (svaYantraControl.controllerUrl.isBlank()) {
            return
        }

        addControllerUseCase(
            AddControllerUseCase.Params(
                controllerName = svaYantraControl.controllerName,
                controllerPassword = svaYantraControl.controllerPassword,
                controllerStatus = svaYantraControl.controllerStatus,
                controllerUrl = svaYantraControl.controllerUrl
            )
        )

        _uiEvents.value = HomeUIEvent.ControllerAdded
    }
}
