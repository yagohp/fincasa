package com.home.fincasa.history.data

class HistoryDataSource {
    //private var retrofitClient = ApiUtils.getRetrofitInstance(BuildConfig.BASE_URL)
    //private val endpoint = this.retrofitClient.create(MediasRequests::class.java)
    //
    // private var result: DataResult? = null
    /*private var cb = object : ResponseCallback<List<Media>> {
        override fun onFailure(call: Call<List<Media>>, t: Throwable) {
            result?.onFailure(Result.Error(Exception(t)))
        }

        override fun onResponseSuccess(call: Call<List<Media>>, response: List<Media>) {
            result?.onSuccess(Result.Success(response))
        }

        override fun onResponseFailure(call: Call<List<Media>>, response: ErrorResponse) {
            result?.onFailure(Result.Error(Exception(response.message)))
        }
    }

    private var mediaResponseCB = object : ResponseCallback<Media> {
        override fun onFailure(call: Call<Media>, t: Throwable) {
            result?.onFailure(Result.Error(Exception(t)))
        }

        override fun onResponseSuccess(call: Call<Media>, response: Media) {
            result?.onSuccess(Result.Success(response))
        }

        override fun onResponseFailure(call: Call<Media>, response: ErrorResponse) {
            result?.onFailure(Result.Error(Exception(response.message)))
        }
    }

    private var messageResponseCB = object : ResponseCallback<MessageResponse> {
        override fun onFailure(call: Call<MessageResponse>, t: Throwable) {
            result?.onFailure(Result.Error(Exception(t)))
        }

        override fun onResponseSuccess(call: Call<MessageResponse>, response: MessageResponse) {
            result?.onSuccess(Result.Success(response))
        }

        override fun onResponseFailure(call: Call<MessageResponse>, response: ErrorResponse) {
            result?.onFailure(Result.Error(Exception(response.message)))
        }

    }*/

    /*fun getHistory(limit: Int, page: Int, category: Int, result: DataResult) {
        try {
            this.result = result;
            //TODO: move to singleton
            val callback = endpoint.getMedias(limit, page, category)
            callback.enqueue(this.cb)
        } catch (e: Throwable) {
            result.onFailure(Result.Error(Exception(IOException("Error logging in", e))))
        }
    }

    /**
     * Creates a new Media
     *
     * @param media The media to be created
     * @param result The callback for the result of the request
     *
     * @author Murilo Horacio Pereira da Cruz
     */
    fun postMedia(media: Media, result: DataResult) {
        try {
            this.result = result
            val callback = endpoint.postMedia(media)
            callback.enqueue(this.mediaResponseCB)
        } catch (e: Throwable) {
            result.onFailure(Result.Error(Exception(IOException("Error posting media", e))))
        }
    }

    /**
     * Deletes a Media
     *
     * @param media The media to be deleted
     * @param result The callback for the result of the request
     *
     * @author Murilo Horacio Pereira da Cruz
     */
    fun deleteMedia(media: Media, result: DataResult) {
        try {
            this.result = result
            val callback = endpoint.deleteMedia(media.id!!)
            callback.enqueue(this.messageResponseCB)
        } catch (e: Throwable) {
            result.onFailure(Result.Error(Exception(IOException("Error deleting media", e))))
        }
    }
    */
}