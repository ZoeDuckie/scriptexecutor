package com.thundercloud.scriptexecutor.azuretoaws.model

data class AzureExport (
  val username: String,
  val password: String,
  val groupName: String,
  val vmName: String
)