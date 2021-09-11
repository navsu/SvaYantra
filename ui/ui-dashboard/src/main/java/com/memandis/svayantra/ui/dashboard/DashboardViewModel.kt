package com.memandis.svayantra.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.memandis.svayantra.ui.dashboard.adapter.items.SvaYantraControllerItem
import com.memandis.svayantra.usecase.svayantra.ObserveSvaYantraControllersUseCase
import com.memandis.svayantra.usecase.svayantra.RefreshSvaYantraControllersUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

@OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
class DashboardViewModel(
    private val refreshSvaYantraControllersUseCase: RefreshSvaYantraControllersUseCase,
    private val observeSvaYantraControllersUseCase: ObserveSvaYantraControllersUseCase
) : ViewModel() {

    private val _svayantraControllers = observeSvaYantraControllersUseCase
        .observe()
        .map { reposList ->
            reposList
                .sortedByDescending { it.status }
                .map {
                    SvaYantraControllerItem(
                        controllerId = it.remoteId,
                        name = it.name,
                        password = it.password,
                        status = it.status,
                        url = it.url,
                        ownerAvatarUrl = it.ownerAvatarUrl
                    )
                }
        }
        .asLiveData(viewModelScope.coroutineContext)

    val svayantraControllers: LiveData<List<SvaYantraControllerItem>>
        get() = _svayantraControllers

    private val _intentChannel = MutableStateFlow<DashboardViewIntent>(DashboardViewIntent.None)

    init {
        _intentChannel
            .onEach { viewIntent ->
                when (viewIntent) {
                    DashboardViewIntent.Refresh -> refreshControllers()
                    DashboardViewIntent.None -> Unit
                }
            }
            .launchIn(viewModelScope)

        observeSvaYantraControllersUseCase(Unit)
    }

    suspend fun processIntent(intentDashboard: DashboardViewIntent) =
        _intentChannel.emit(intentDashboard)

    private suspend fun refreshControllers() {
        refreshSvaYantraControllersUseCase(
            RefreshSvaYantraControllersUseCase.Params(
                url = "10.0.0.10", cpass = "12345678")
        )
    }
}
