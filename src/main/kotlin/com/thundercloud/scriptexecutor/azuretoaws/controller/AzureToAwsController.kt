package com.thundercloud.scriptexecutor.azuretoaws.controller

import com.thundercloud.scriptexecutor.azuretoaws.model.AwsImport
import com.thundercloud.scriptexecutor.azuretoaws.model.AzureExport
import com.thundercloud.scriptexecutor.azuretoaws.service.AzureToAwsScriptService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("AzureToAws")
class AzureToAwsController(private val service: AzureToAwsScriptService) {

    @PostMapping("export/azure")
    fun exportAzure(@RequestBody request: AzureExport): String {
        return service.executeExportAzure(request)
    }

    @PostMapping("import/aws")
    fun importAws(@RequestBody request: AwsImport): String {
        return service.executeImportAws(request)
    }
}