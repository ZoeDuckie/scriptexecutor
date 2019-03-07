package com.thundercloud.scriptexecutor.azuretoaws.model

data class AwsImport (
  val fileToUpload: String,
  val s3Bucket: String,
  val description: String,
  val diskContainer: String
)