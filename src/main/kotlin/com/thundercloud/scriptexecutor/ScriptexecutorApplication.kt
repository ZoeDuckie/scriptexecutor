package com.thundercloud.scriptexecutor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ScriptexecutorApplication

fun main(args: Array<String>) {
	runApplication<ScriptexecutorApplication>(*args)
}

