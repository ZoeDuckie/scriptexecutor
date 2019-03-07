package com.thundercloud.scriptexecutor.awstoazure.model

data class AwsExport (
    val instanceId: String,
    val targetEnvironment: String,
    val diskImageFormat: String,
    val s3Bucket: String,
    val s3Prefix: String
)