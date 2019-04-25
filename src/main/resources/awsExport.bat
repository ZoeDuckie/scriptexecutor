REM export AWS

call aws cp %4 %6

call aws ec2 create-instance-export-task --instance-id %1 --target-environment %2 --export-to-s3-task DiskImageFormat=%3,S3Bucket=%4,S3Prefix=%5
