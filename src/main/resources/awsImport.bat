REM login

REM call aws configure
call aws configure

REM image import	<newInstanceName>	<containerPath>

aws ec2 import-image --description= %5 --disk-containers= %6