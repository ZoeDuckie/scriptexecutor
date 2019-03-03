REM Pass in parameters for later use. Up to 9 with this method.
%1 REM Username
%2 REM Password
%3 REM GroupName
%4 REM VmName

REM login

call az login -u %1 -p %2

REM start/stop vm

call az vm start --resource-group %3 --name %4
call az vm stop --resource-group %3 --name %4

REM deallocate/generalize vm

call az vm deallocate --resource-group %3 --name %4
call az vm generalize --resource-group %3 --name %4

REM vm status check

REM az vm get-instance-view --name %4 --resource-group %3 --query instanceView.statuses[1] --output table