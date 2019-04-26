call az login -u %1 -p %2

call az vm start --resource-group %3 --name %4
call az vm stop --resource-group %3 --name %4

call az vm deallocate --resource-group %3 --name %4
call az vm generalize --resource-group %3 --name %4
