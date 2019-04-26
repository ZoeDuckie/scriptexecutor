call aws s3 cp %1 %2

call aws ec2 import-image --description %3 --disk-containers %4