package com.memandis.svayantra.repo

import app.cash.turbine.test
import com.memandis.svayantra.db.svayantra.SvayantraControllerEntity
import com.memandis.svayantra.test.MockSvaYantraLocalRepo
import com.memandis.svayantra.test.UnitTest
import kotlin.time.ExperimentalTime
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class, ExperimentalTime::class)
class ObserveSvaYantraRepoUseCaseTest : UnitTest() {

    @Test
    fun test_should_return_repos_from_local_repo() =
        coroutinesTestRule.testDispatcher.runBlockingTest {
            val localRepos = listOf(
                SvayantraControllerEntity(
                    internalId = null,
                    remoteId = 1,
                    name = "Sva1",
                    password = "12345678",
                    url = "10.0.0.10",
                    status = 1,
                    ownerAvatarUrl = ""
                ),
                SvayantraControllerEntity(
                    internalId = null,
                    remoteId = 2,
                    name = "Sva2",
                    password = "selfless",
                    url = "10.0.0.20",
                    status = 0,
                    ownerAvatarUrl = ""
                )
            )

            val mockSvaYantraLocalRepo = MockSvaYantraLocalRepo(observedSvaYantraControllers = localRepos)

            val useCase =
                com.memandis.svayantra.usecase.svayantra.ObserveSvaYantraControllersUseCase(
                    appCoroutineDispatchers = testAppCoroutineDispatchers,
                    svaYantraLocalRepo = mockSvaYantraLocalRepo
                )

            useCase(Unit)

            launch {
                useCase.observe().test { assertEquals(localRepos, expectItem()) }
            }
        }
}
