package com.memandis.svayantra.ui.dashboard

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.memandis.svayantra.remoterepo.svayantra.SvaYantraControllerModel
import com.memandis.svayantra.remoterepo.svayantra.SvaYantraControllerOwner
import com.memandis.svayantra.test.MockSvaYantraLocalRepo
import com.memandis.svayantra.test.MockSvaYantraRemoteRepo
import com.memandis.svayantra.test.UnitTest
import com.memandis.svayantra.test.forceGet
import com.memandis.svayantra.test.observeForTesting
import com.memandis.svayantra.usecase.svayantra.ObserveSvaYantraControllersUseCase
import com.memandis.svayantra.usecase.svayantra.RefreshSvaYantraControllersUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
class DashboardViewModelTest : UnitTest() {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun test_repo_refresh() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val remoteRepo = listOf(
            SvaYantraControllerModel(
                id = 1,
                name = "Sva1",
                password = "12345678",
                url = "10.0.0.10",
                status = 1,
                owner = SvaYantraControllerOwner(avatarUrl = "")
            ),
            SvaYantraControllerModel(
                id = 2,
                name = "Sva2",
                password = "selfless",
                url = "10.0.0.20",
                status = 0,
                owner = SvaYantraControllerOwner(avatarUrl = "")
            )
        )

        val mockSvaYantraRemoteRepo = MockSvaYantraRemoteRepo(fetchedRepos = remoteRepo)
        val mockSvaYantraLocalRepo = MockSvaYantraLocalRepo(
            observedSvaYantraControllers = listOf(
                com.memandis.svayantra.db.svayantra.SvayantraControllerEntity(
                    internalId = null,
                    remoteId = 1,
                    name = "Sva1",
                    password = "12345678",
                    url = "10.0.0.10",
                    status = 1,
                    ownerAvatarUrl = ""
                ),
                com.memandis.svayantra.db.svayantra.SvayantraControllerEntity(
                    internalId = null,
                    remoteId = 2,
                    name = "Sva2",
                    password = "selfless",
                    url = "10.0.0.20",
                    status = 0,
                    ownerAvatarUrl = ""
                )
            )
        )

        val refreshSvaYantraControllersUseCase = RefreshSvaYantraControllersUseCase(
            appCoroutineDispatchers = testAppCoroutineDispatchers,
            svaYantraRemoteRepo = mockSvaYantraRemoteRepo,
            svaYantraLocalRepo = mockSvaYantraLocalRepo
        )

        val observeSvaYantraControllersUseCase = ObserveSvaYantraControllersUseCase(
            appCoroutineDispatchers = testAppCoroutineDispatchers,
            svaYantraLocalRepo = mockSvaYantraLocalRepo
        )

        val vm = DashboardViewModel(
            refreshSvaYantraControllersUseCase = refreshSvaYantraControllersUseCase,
            observeSvaYantraControllersUseCase = observeSvaYantraControllersUseCase
        )

        vm.processIntent(intentDashboard = DashboardViewIntent.Refresh)

        vm.svayantraControllers.observeForTesting {
            val (firstController, secondController) = vm.svayantraControllers.forceGet

            assertEquals(1, firstController.controllerId)
            assertEquals(2, secondController.controllerId)
        }
    }
}
