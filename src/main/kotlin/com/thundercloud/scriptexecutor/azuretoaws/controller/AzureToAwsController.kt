package com.thundercloud.scriptexecutor.azuretoaws.controller

import com.thundercloud.scriptexecutor.azuretoaws.model.Aws
import com.thundercloud.scriptexecutor.azuretoaws.model.Azure
import com.thundercloud.scriptexecutor.azuretoaws.service.ScriptService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("AzureToAws")
class AzureToAwsController(private val service: ScriptService) {

    @PostMapping("export/azure")
    fun exportAzure(@RequestBody request: Azure): String {
        return service.executeExportAzure(request)
    }

    @PostMapping("import/aws")
    fun importAws(@RequestBody request: Aws): String {
        return service.executeImportAws(request)
    }
}