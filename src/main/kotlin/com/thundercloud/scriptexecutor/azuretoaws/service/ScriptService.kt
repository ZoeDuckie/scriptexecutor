package com.thundercloud.scriptexecutor.azuretoaws.service

import com.thundercloud.scriptexecutor.azuretoaws.model.Aws
import com.thundercloud.scriptexecutor.azuretoaws.model.Azure
import org.springframework.stereotype.Service

@Service
class ScriptService {

    fun executeExportAzure(request: Azure): String {
        return "success"
    }

    fun executeImportAws(request: Aws): String {
        return "success"
    }
}