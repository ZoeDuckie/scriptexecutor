REM Import Azure

call az storage blob upload -c vhds -f %1 -n %2 --account-name %3 --account-key ${STORAGE_KEY}

call az vm create -g %4 -n %5 --image %6 -os-type %7 --admin-username %8 --generate-ssh-keys