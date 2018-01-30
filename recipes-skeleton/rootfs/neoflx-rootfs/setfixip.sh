#!/bin/sh

# conveyer only. Set fix ip (to production ip) if not already done

theip=$1
thegateway=$2
markfile=/home/root/ipset.done

if [ ! -f /home/root/ipset.done ]; then
    logger -p info -t setip -s "Set fix ip to ${theip}"
    systemctl stop connman.service
    macaddr=`cat /sys/class/net/eth0/address`
    cmac=`echo ${macaddr} | sed 's/://g'`
    dirname=ethernet_${cmac}_cable
    ourdate=`date +%FT%T.000000Z`
    mkdir -p /var/lib/connman/${dirname}
    outfile=/var/lib/connman/${dirname}/settings
#    outfile=./settings
    echo [${dirname}] >${outfile}
    echo Name=Wired >>${outfile}
    echo AutoConnect=true >>${outfile}
    echo Modified=${ourdate} >>${outfile}
    echo IPv4.method=manual >>${outfile}
    echo IPv4.DHCP.LastAddress= >>${outfile}
    echo IPv6.method=off >>${outfile}
    echo IPv6.privacy=disabled >>${outfile}
    echo Domains= >>${outfile}
    echo IPv4.netmask_prefixlen=24 >>${outfile}
    echo IPv4.local_address=${theip} >>${outfile}
    echo IPv4.gateway=${thegateway} >>${outfile}

    # remember that we set fix ip in root home folder to do this only once.
    # Will be wiped by full factory default
    echo "fixipset ${theip}" >${markfile}
    sync
    systemctl start connman.service
else
    logger -p info -t setip -s "${markfile} exist. No special IP setting"
fi 
