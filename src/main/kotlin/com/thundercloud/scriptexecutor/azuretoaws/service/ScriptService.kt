package com.thundercloud.scriptexecutor.azuretoaws.service

import com.thundercloud.scriptexecutor.azuretoaws.exception.ScriptServiceException
import com.thundercloud.scriptexecutor.azuretoaws.model.Aws
import com.thundercloud.scriptexecutor.azuretoaws.model.Azure
import org.springframework.stereotype.Service
import java.io.IOException
import java.io.InputStreamReader
import java.io.BufferedReader

@Service
class ScriptService {

    fun executeExportAzure(request: Azure): String {
        val processBuilder = ProcessBuilder()
        val output = StringBuilder()

        // -- Linux --

        // Run a shell command
        //processBuilder.command("bash", "-c", "ls /home/user/")

        // Run a shell script
        //processBuilder.command("path/to/hello.sh");

        // -- Windows --

        // Run a command
        processBuilder.command("cmd.exe", "/c", "dir C:\\Users\\Sean")

        // Run a bat file
        //processBuilder.command("C:\\Users\\Sean\\hello.bat");

        try {
            val process = processBuilder.start()

            val reader = BufferedReader(InputStreamReader(process.inputStream))

            var line = reader.readLine()
            while (line != null) {
                line = reader.readLine()

                output.append(line + "\n")
            }

            val exitVal = process.waitFor()
            if (exitVal == 0) {
                println("Success!")
                println(output)
            } else {
                throw ScriptServiceException("Exit value was not 0. Unknown error.")
            }

        } catch (e: IOException) {
            throw ScriptServiceException("BAD!")
        } catch (e: InterruptedException) {
            throw ScriptServiceException("SAD!")
        }
        return output.toString()
    }

    fun executeImportAws(request: Aws): String {
        return "success"
    }
}