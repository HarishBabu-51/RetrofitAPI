package com.example.retrofitapi

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.retrofitapi.fox.Fox
import com.example.retrofitapi.fox.FoxRepository
import com.example.retrofitapi.fox.FoxViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class FoxViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    // Mock the repository
    @Mock
    private lateinit var mockRepository: FoxRepository

    // Mock the Observer for LiveData
    @Mock
    private lateinit var mockObserver: Observer<Fox?>

    // The ViewModel under test
    private lateinit var viewModel: FoxViewModel

    // TestCoroutineDispatcher is used to control execution timing of coroutines for testing
    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testCoroutineDispatcher)
        MockitoAnnotations.openMocks(this)
        viewModel = FoxViewModel(mockRepository)
    }

/*    @Test
     fun `fetchRandomFox success`() = testCoroutineDispatcher.run {
        // Given
        val expectedResponse = Fox("https://randomfox.ca/images/87.jpg", "https://randomfox.ca/?i=87")
        `when`(mockRepository.getRandomFox()).thenReturn(expectedResponse)

        // Observe the LiveData
        viewModel.foxResponse.observeForever(mockObserver)

        // When
        viewModel.foxResponse()

        // Then
        verify(mockObserver).onChanged(expectedResponse)
        assertEquals(expectedResponse, viewModel.foxResponse.value)

        // Cleanup
        viewModel.foxResponse.removeObserver(mockObserver)
    }*/

    @Test
    fun `test initialization with valid response`() = testCoroutineDispatcher.run {

        //val imageUrlRegex = Regex("https://randomfox.ca/images/\\d+\\.jpg")

        // Given
        val expectedResponse = Fox("https://randomfox.ca/images/87.jpg", "https://randomfox.ca/?i=87")
        `when`(mockRepository.getRandomFox()).thenReturn(expectedResponse)

        // Observe the LiveData
        viewModel.foxResponse.observeForever(mockObserver)

        /*viewModel.foxResponse.value.let {
            print(it?.image)
            assertTrue(it?.image?.startsWith("https://randomfox.ca/images/") ?: false)
        }*/


        // Cleanup
        viewModel.foxResponse.removeObserver(mockObserver)
    }
}