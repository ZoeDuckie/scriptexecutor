package com.thundercloud.scriptexecutor.azuretoaws.service

import com.thundercloud.scriptexecutor.azuretoaws.model.AwsExport
import com.thundercloud.scriptexecutor.exception.ScriptServiceException
import com.thundercloud.scriptexecutor.azuretoaws.model.AwsImport
import com.thundercloud.scriptexecutor.azuretoaws.model.AzureExport
import com.thundercloud.scriptexecutor.azuretoaws.model.AzureImport
import org.springframework.stereotype.Service
import java.io.*
import javax.servlet.ServletContextListener

@Service
class AzureToAwsScriptService {

  fun executeExportAzure(request: AzureExport): String {
    val processBuilder = ProcessBuilder()

    processBuilder.command(
      ServletContextListener::class.java.getClassLoader()
        .getResource("azureExport.bat").toString().substring(6),
        request.username, request.password, request.groupName, request.vmName
    )

    return processScript(processBuilder)
  }

  fun executeImportAws(request: AwsImport): String {
    val processBuilder = ProcessBuilder()

    processBuilder.command(
      ServletContextListener::class.java.getClassLoader()
        .getResource("awsImport.bat").toString().substring(6),
        request.fileToUpload, "s3://" + request.s3Bucket,
        "\"" + request.description + "\"", "\"file://" + request.diskContainer + "\""
    )

    return processScript(processBuilder)
  }


  fun executeimportAzure(request: AzureImport): String {
    val processBuilder = ProcessBuilder()

    processBuilder.command(
      ServletContextListener::class.java.getClassLoader()
        .getResource("azureExport.bat").toString().substring(6),
        request.fileToWriteOutTo, request.nameOfVhd, request.accountName, request.accountKey, request.resourceGroup,
        request.vmName, request.os, request.adminUsername
    )

    return processScript(processBuilder)
  }

  fun executeExportAws(request: AwsExport): String {
    val processBuilder = ProcessBuilder()

    processBuilder.command(
      ServletContextListener::class.java.getClassLoader()
        .getResource("awsImport.bat").toString().substring(6),
        request.instanceId, request.targetEnvironment, request.diskImageFormat, "s3://" + request.s3Bucket,
        request.s3Prefix, request.localFileCopyLocation
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