package com.thundercloud.scriptexecutor.awstoazure.controller

import com.thundercloud.scriptexecutor.awstoazure.model.AwsExport
import com.thundercloud.scriptexecutor.awstoazure.model.AzureImport
import com.thundercloud.scriptexecutor.awstoazure.service.AwsToAzureScriptService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("AwsToAzure")
class AwsToAzureController(private val service: AwsToAzureScriptService) {

  @PostMapping("import/azure")
  fun importAzure(@RequestBody request: AzureImport): String {
    return service.executeImportAzure(request)
  }

  @PostMapping("export/aws")
  fun exportAws(@RequestBody request: AwsExport): String {
    return service.executeExportAws(request)
  }
}