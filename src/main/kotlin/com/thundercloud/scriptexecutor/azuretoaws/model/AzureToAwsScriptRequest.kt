package com.thundercloud.scriptexecutor.azuretoaws.model

data class AzureToAwsScriptRequest (
  val azure: AzureExport,
  val aws: AwsImport
)