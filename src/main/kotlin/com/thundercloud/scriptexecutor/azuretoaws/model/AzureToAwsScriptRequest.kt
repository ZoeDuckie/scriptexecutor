package com.thundercloud.scriptexecutor.azuretoaws.model

data class AzureToAwsScriptRequest (
  val azure: Azure,
  val aws: Aws
)