#!/bin/bash
sync

echo timer > /sys/class/leds/led1/trigger
echo 50 > /sys/class/leds/led1/delay_on
echo 50 > /sys/class/leds/led1/delay_off
echo 255 > /sys/class/leds/led1/brightness

# lepton reset (HW rev2.2)
echo "0" > /sys/class/gpio/gpio68/value
sleep 10

reboot
