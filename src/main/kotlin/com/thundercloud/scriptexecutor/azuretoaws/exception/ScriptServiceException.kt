package com.thundercloud.scriptexecutor.azuretoaws.exception

import java.lang.RuntimeException

data class ScriptServiceException (
    private val msg: String
): RuntimeException()