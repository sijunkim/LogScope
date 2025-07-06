package com.logscope.logscope.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LogscopeBackendApplication

fun main(args: Array<String>) {
	runApplication<LogscopeBackendApplication>(*args)
}
