package com.thundercloud.scriptexecutor.azuretoaws.model

data class AzureImport (
  val fileToWriteOutTo: String,
  val nameOfVhd: String,
  val accountName: String,
  val accountKey: String,
  val resourceGroup: String,
  val vmName: String,
  val image: String,
  val os: String,
  val adminUsername: String
)