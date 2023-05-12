package com.example.android3lesson6dz.data.repositories.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android3lesson6dz.data.remote.apisevices.NewsApiService
import com.example.android3lesson6dz.models.news.ArticlesItem
import okio.IOException
import retrofit2.HttpException

private const val NEWS_STARTING_PAGE_INDEX = 1

class NewsPagingSource(
    private val newsApiService: NewsApiService
) : PagingSource<Int, ArticlesItem>() {

    override fun getRefreshKey(state: PagingState<Int, ArticlesItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPosition = state.closestPageToPosition(anchorPosition)
            anchorPosition?.prevKey?.plus(1) ?: anchorPosition?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticlesItem> {
        val position = params.key ?: NEWS_STARTING_PAGE_INDEX
        val pageSize: Int = params.loadSize.coerceAtMost(1000)

        return try {
            val response = newsApiService.fetchNews(position)
            val next = response.totalResults
            val nextPageNumber = if (next > pageSize) position + 1
            else null
            LoadResult.Page(
                data = response.articles,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}