package com.thundercloud.scriptexecutor.azuretoaws.controller

import com.thundercloud.scriptexecutor.azuretoaws.model.AwsExport
import com.thundercloud.scriptexecutor.azuretoaws.model.AwsImport
import com.thundercloud.scriptexecutor.azuretoaws.model.AzureExport
import com.thundercloud.scriptexecutor.azuretoaws.model.AzureImport
import com.thundercloud.scriptexecutor.azuretoaws.service.AzureToAwsScriptService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("AzureToAws")
class ConversionController(private val service: AzureToAwsScriptService) {

    @PostMapping("export/azure")
    fun exportAzure(@RequestBody request: AzureExport): String {
        return service.executeExportAzure(request)
    }

    @PostMapping("import/aws")
    fun importAws(@RequestBody request: AwsImport): String {
        return service.executeImportAws(request)
    }

    @PostMapping("export/aws")
    fun exportAws(@RequestBody request: AwsExport): String {
        return service.executeExportAws(request)
    }

    @PostMapping("import/azure")
    fun importAzure(@RequestBody request: AzureImport): String {
        return service.executeimportAzure(request)
    }
}