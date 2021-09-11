package com.memandis.svayantra.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.memandis.svayantra.android.core.viewbinding.viewBinding
import com.memandis.svayantra.ui.dashboard.adapter.SvaYantraControllerAdapter
import com.memandis.svayantra.ui.dashboard.adapter.items.SvaYantraControllerItem
import com.memandis.svayantra.ui.dashboard.databinding.FragmentDashboardBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import reactivecircus.flowbinding.swiperefreshlayout.refreshes

@OptIn(ExperimentalCoroutinesApi::class)
class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val dashboardViewModel by viewModel<DashboardViewModel>()
    private val binding by viewBinding(FragmentDashboardBinding::bind)
    private val adapter = SvaYantraControllerAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.controllerList.adapter = adapter

        dashboardViewModel.svayantraControllers.observe(viewLifecycleOwner, Observer {
            displaySvayantraControllers(it)
        })

        binding.controllerListPtr
            .refreshes()
            .map { DashboardViewIntent.Refresh }
            .onEach { dashboardViewModel.processIntent(intentDashboard = it) }
            .launchIn(lifecycleScope)
    }

    private fun displaySvayantraControllers(svayantraControllers: List<SvaYantraControllerItem>) {
        adapter.submitList(svayantraControllers)
        binding.controllerListPtr.isRefreshing = false
    }
}
