#! /bin/sh

# hostname
if [ ! -f /home/root/hostname.done ]; then
macaddr=`cat /sys/class/net/eth0/address`
cmac=`echo ${macaddr} | sed 's/://g' | cut -b 6-`
echo neoflx-${cmac} > /etc/hostname
echo neoflx-${cmac} > /home/root/hostname.done
fi

# Lepton Reset (hw rev2.2)
echo "68" > /sys/class/gpio/export
echo "out" > /sys/class/gpio/gpio68/direction
echo "1" > /sys/class/gpio/gpio68/value

# Lepton VSync (hw rev2.2)
echo "67" > /sys/class/gpio/export

# RS485 CTS
echo "46" > /sys/class/gpio/export
echo "out" > /sys/class/gpio/gpio46/direction

# Test Point 1 (hw rev2.2)
echo "91" > /sys/class/gpio/export
echo "out" > /sys/class/gpio/gpio91/direction

# Test Point 2 (hw rev2.2)
echo "60" > /sys/class/gpio/export
echo "out" > /sys/class/gpio/gpio60/direction

/usr/sbin/fbset -fb /dev/fb1 -xres 640 -yres 480 -depth 32
/NeoFLX/usr/bin/poweron
