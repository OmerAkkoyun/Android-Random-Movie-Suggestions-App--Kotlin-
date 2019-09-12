package com.omer_akkoyun.neizlesem
import com.google.gson.annotations.SerializedName


data class DataModelClass(
    @SerializedName("data")
    var `data`: Data? = null,
    @SerializedName("@meta")
    var meta: Meta? = null,
    @SerializedName("status")
    var status: String? = null,
    @SerializedName("status_message")
    var statusMessage: String? = null
) {
    data class Data(
        @SerializedName("movie")
        var movie: Movie? = null
    ) {
        data class Movie(
            @SerializedName("background_image")
            var backgroundİmage: String? = null,
            @SerializedName("background_image_original")
            var backgroundİmageOriginal: String? = null,
            @SerializedName("date_uploaded")
            var dateUploaded: String? = null,
            @SerializedName("date_uploaded_unix")
            var dateUploadedUnix: Int? = null,
            @SerializedName("description_full")
            var descriptionFull: String? = null,
            @SerializedName("description_intro")
            var descriptionİntro: String? = null,
            @SerializedName("download_count")
            var downloadCount: Int? = null,
            @SerializedName("genres")
            var genres: List<String?>? = null,
            @SerializedName("id")
            var id: Int? = null,
            @SerializedName("imdb_code")
            var imdbCode: String? = null,
            @SerializedName("language")
            var language: String? = null,
            @SerializedName("large_cover_image")
            var largeCoverİmage: String? = null,
            @SerializedName("like_count")
            var likeCount: Int? = null,
            @SerializedName("medium_cover_image")
            var mediumCoverİmage: String? = null,
            @SerializedName("mpa_rating")
            var mpaRating: String? = null,
            @SerializedName("rating")
            var rating: Double? = null,
            @SerializedName("runtime")
            var runtime: Int? = null,
            @SerializedName("slug")
            var slug: String? = null,
            @SerializedName("small_cover_image")
            var smallCoverİmage: String? = null,
            @SerializedName("title")
            var title: String? = null,
            @SerializedName("title_english")
            var titleEnglish: String? = null,
            @SerializedName("title_long")
            var titleLong: String? = null,
            @SerializedName("torrents")
            var torrents: List<Torrent?>? = null,
            @SerializedName("url")
            var url: String? = null,
            @SerializedName("year")
            var year: Int? = null,
            @SerializedName("yt_trailer_code")
            var ytTrailerCode: String? = null
        ) {
            data class Torrent(
                @SerializedName("date_uploaded")
                var dateUploaded: String? = null,
                @SerializedName("date_uploaded_unix")
                var dateUploadedUnix: Int? = null,
                @SerializedName("hash")
                var hash: String? = null,
                @SerializedName("peers")
                var peers: Int? = null,
                @SerializedName("quality")
                var quality: String? = null,
                @SerializedName("seeds")
                var seeds: Int? = null,
                @SerializedName("size")
                var size: String? = null,
                @SerializedName("size_bytes")
                var sizeBytes: Int? = null,
                @SerializedName("type")
                var type: String? = null,
                @SerializedName("url")
                var url: String? = null
            )
        }
    }

    data class Meta(
        @SerializedName("api_version")
        var apiVersion: Int? = null,
        @SerializedName("execution_time")
        var executionTime: String? = null,
        @SerializedName("server_time")
        var serverTime: Int? = null,
        @SerializedName("server_timezone")
        var serverTimezone: String? = null
    )
}