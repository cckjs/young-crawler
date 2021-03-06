package com.young.crawler.spider.fetcher.support

import com.young.crawler.entity.HttpResult
import com.young.crawler.exception.FetchException
import com.young.crawler.spider.fetcher.Fetcher

/**
 * Created by young.yang on 2016/8/28.
 */
class HttpClientFetcher extends Fetcher {
  @throws[FetchException]
  override def fetchPage(url: String): HttpResult = {
    try {
      val result = HttpWatch.get(url)
      if (result.status == FETCH_SUCCESS) {
        result
      } else {
        throw new FetchException("fetch error code is -" + result.status)
      }
    } catch {
      case e => throw new FetchException("fetch error message", e)
    }
  }
}
