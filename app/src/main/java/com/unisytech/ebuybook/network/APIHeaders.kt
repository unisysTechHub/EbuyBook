package com.unisytech.ebuybook.network

/**
 * Created by ramesh on 18/3/22.
 */

/**
 * Created by ramesh on 8/2/22.
 */
const val jwtToken = "eyJraWQiOiJ0bmZIQjVwUEYzRjFXM1VqSVRESHdvdjNqUndMQzh3OXlUN0hwZFRsTU5zPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIxY2ZiOWE0MS1iOTU0LTQwMWMtOWQ0Yy05NDQzNWZmZDIzOWYiLCJldmVudF9pZCI6ImRlM2IyYjE4LTExY2MtNDc0NC1hMGIzLWI3YzE0Yzg5MmIxMiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXdzLmNvZ25pdG8uc2lnbmluLnVzZXIuYWRtaW4gcGhvbmUgb3BlbmlkIHByb2ZpbGUgZW1haWwiLCJhdXRoX3RpbWUiOjE2NDc1OTQ3NjYsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTEuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0xX0xPTmpRT2Y2aSIsImV4cCI6MTY0NzU5ODM2NiwiaWF0IjoxNjQ3NTk0NzY2LCJ2ZXJzaW9uIjoyLCJqdGkiOiI2MDBlNjRlYy0wYjE0LTQ3NTctODAwOC1iMmY5Zjg5NjgxODQiLCJjbGllbnRfaWQiOiI3azZncHJxNGUzZjlmcHBpOGo5dTJtOGF1ZiIsInVzZXJuYW1lIjoidXNlciJ9.qo_pyXdLuNGvqTpoLXS14rsjEaMMgfuWHOLus2nM2fECCTdTEKin4z6J1jxs_wyQsqo7BhcI0PHlw5I4WEKlWSmpxkkNqwai-vCKdxVnem4V4-2cU4hoEVNwg7G1kILt035RZoyskk4Z6TbLDoMMpv9UW6jbrbLgC2fGdrvuoIVapubj4ynpi2GsNuSAvgDF7AvO_LBOkxEm7izWXYgyjqkM6UWDKHX2BYbV1GNza0A5Y2qxyRyxyLzMt8oPns-WXrXpS3cq8lx_73ylxDEh5NBDuwP-KBZZcTNPiN-WBJbADsc9JknOTP58vTXns_46wnvnC_90Z-P7GM79WSdJTw"
interface BaseHeaders {
    fun baseHeaders(): MutableMap<String,String>{
        var baseHeaders : MutableMap<String,String> = mutableMapOf()
        baseHeaders["Content-Type" ] = "application/json"
       baseHeaders["Authorization"] = jwtToken
        return baseHeaders
    }

}
enum class Endpoint {
    BooksListAPI
}

internal class APIHeadersBuilder {

    fun test() {}
    companion object : BaseHeaders {
        var resourceHeaders: (Endpoint) -> MutableMap<String, String> = { endpoint ->
            when (endpoint) {
                Endpoint.BooksListAPI -> fetchBooksList()
            }
            _resourceHeader.forEach() { entry: Map.Entry<String, String> ->
                println(" Resource headers ${entry.key}  ${entry.value}")
            }
            _resourceHeader

        }

        private var _resourceHeader : MutableMap<String,String> = mutableMapOf()


        private  fun fetchBooksList() {
            addBaseHeaders()
             addAPIKeyHeaders(endpint = Endpoint.BooksListAPI)

        }

        private fun addAPIKeyHeaders(endpint: Endpoint) {

            when (endpint) {
                Endpoint.BooksListAPI -> {

                    _resourceHeader["x-api-key"] ="dyY5rcBrf06XLhhdNRehE3Oj5Bh1G7ysaUNqdBOe"

                }
            }

        }

        private  fun addBaseHeaders() {
            baseHeaders().forEach() { entry: Map.Entry<String, String> ->
                _resourceHeader[entry.key] = entry.value
            }
        }

    }
}
