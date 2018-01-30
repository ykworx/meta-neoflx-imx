SUMMARY = "v4l2 loopback kernel module"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit module

SRCBRANCH ?= "v0.9.1"
LOCALVERSION ?= "-0.9.1"

SRC_URI = "git://github.com/umlaeute/v4l2loopback.git;protocol=git \
           file://0001-add-yocto-build.patch \
           "
SRCREV = "56cc11d175b6cfdf33ed03ccd8368cb837d3992c"

S = "${WORKDIR}/git"

do_install_append() {
	install -d {$D}${sysconfdir}/modprobe.d
	install -d {$D}${sysconfdir}/modubles-load.d
	echo "options v4l2loopback video_nr=1" > ${D}${sysconfdir}/modprobe.d/v4l2loopback.conf
	echo "v4l2loopback" > ${D}${sysconfdir}/modules-load.d/v4l2loopback.conf
}
