package com.thundercloud.scriptexecutor.azuretoaws.service

import com.thundercloud.scriptexecutor.azuretoaws.exception.ScriptServiceException
import com.thundercloud.scriptexecutor.azuretoaws.model.Aws
import com.thundercloud.scriptexecutor.azuretoaws.model.Azure
import org.springframework.stereotype.Service
import java.io.*
import javax.servlet.ServletContextListener

@Service
class ScriptService {

    fun executeExportAzure(request: Azure): String {
        val processBuilder = ProcessBuilder()

        // Run a command
        //processBuilder.command("cmd.exe", "/c", "az login")

        // Run a bat file
        processBuilder.command(
                ServletContextListener::class.java.getClassLoader()
                  .getResource("azureExport.bat").toString().substring(6),
                request.username, request.password, request.groupName, request.vmName
        )

        return processScript(processBuilder)
    }

    fun executeImportAws(request: Aws): String {
        val processBuilder = ProcessBuilder()


        // Run a command
        //processBuilder.command("cmd.exe", "/c", "az login")

        // Run a bat file
        processBuilder.command(
          ServletContextListener::class.java.getClassLoader()
            .getResource("awsImport.bat").toString().substring(6),
          request.accessKeyId, request.secretAccessKey, request.region,
          request.cryptogram, request.description, request.diskContainer
        )

        return processScript(processBuilder)
    }

    private fun processScript(processBuilder: ProcessBuilder): String {
        val output = StringBuilder()
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
}