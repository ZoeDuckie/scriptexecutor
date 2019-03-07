package com.thundercloud.scriptexecutor.azuretoaws.model

data class Aws (
  val accessKeyId: String,
  val secretAccessKey: String,
  val region: String,
  val cryptogram: String,
  val description: String,
  val diskContainer: String
)