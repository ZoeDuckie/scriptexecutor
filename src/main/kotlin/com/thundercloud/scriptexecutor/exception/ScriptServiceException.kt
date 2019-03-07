package com.thundercloud.scriptexecutor.exception

import java.lang.RuntimeException

data class ScriptServiceException (
    private val msg: String
): RuntimeException()