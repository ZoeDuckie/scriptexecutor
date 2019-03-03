package com.thundercloud.scriptexecutor.azuretoaws.service

import com.thundercloud.scriptexecutor.azuretoaws.exception.ScriptServiceException
import com.thundercloud.scriptexecutor.azuretoaws.model.Aws
import com.thundercloud.scriptexecutor.azuretoaws.model.Azure
import org.omg.CORBA.portable.OutputStream
import org.springframework.stereotype.Service
import java.io.*
import javax.servlet.ServletContextListener

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
//        processBuilder.command("cmd.exe", "/c", "az login")

        // Run a bat file
        processBuilder.command(
                ServletContextListener::class.java.getClassLoader().getResource("azureExport.bat").toString().substring(6),
                request.Username, request.Password, request.GroupName, request.VmName
        )

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