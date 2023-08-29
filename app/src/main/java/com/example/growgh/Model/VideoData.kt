package com.example.growgh.Model

data class PexelsVideoResponse(
    val videos: List<PexelsVideo>
)

data class PexelsVideo(
    val id: Int,
    val video_files: List<PexelsVideoFile>
)

data class PexelsVideoFile(
    val link: String,
    val quality: String
)
