package com.thundercloud.scriptexecutor.awstoazure.controller

import com.thundercloud.scriptexecutor.azuretoaws.model.AzureToAwsScriptRequest
import com.thundercloud.scriptexecutor.awstoazure.service.AwsToAzureScriptService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AwsToAzureController(private val service: AwsToAzureScriptService) {

    @PostMapping
    fun scriptExecution(@RequestBody request: AzureToAwsScriptRequest) {
        service.executeAzureToAws()
    }
}