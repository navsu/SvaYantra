package com.memandis.svayantra.repo

import com.memandis.svayantra.remoterepo.svayantra.SvaYantraControllerModel
import com.memandis.svayantra.remoterepo.svayantra.SvaYantraControllerOwner
import com.memandis.svayantra.test.MockSvaYantraLocalRepo
import com.memandis.svayantra.test.MockSvaYantraRemoteRepo
import com.memandis.svayantra.test.UnitTest
import com.memandis.svayantra.usecase.svayantra.RefreshSvaYantraControllersUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RefreshSvaYantraRepoUseCaseTest : UnitTest() {
    private val mockSvaYantraLocalRepo = MockSvaYantraLocalRepo()

    @Before
    fun setUpp() {
        mockSvaYantraLocalRepo.reset()
    }

    @Test
    fun should_fetch_remote_repos_and_add_them_locally() =
        coroutinesTestRule.testDispatcher.runBlockingTest {
            val remoteRepos = listOf(
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

            val svaYantraRemoteRepo = MockSvaYantraRemoteRepo(fetchedRepos = remoteRepos)

            val useCase = RefreshSvaYantraControllersUseCase(
                appCoroutineDispatchers = testAppCoroutineDispatchers,
                svaYantraLocalRepo = mockSvaYantraLocalRepo,
                svaYantraRemoteRepo = svaYantraRemoteRepo
            )

            useCase.run(params = RefreshSvaYantraControllersUseCase.Params(url = "10.0.0.10", cpass = "12345678"))

            mockSvaYantraLocalRepo.updateRepoRenders.assertRenderedOnce()
        }
}
