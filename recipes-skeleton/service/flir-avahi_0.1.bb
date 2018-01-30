SUMMARY = "NeoFLX10 D-Bus(Session)"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://flir.service"

do_install () {
	install -d ${D}${sysconfdir}/avahi/services
	install -m 0644 ${WORKDIR}/flir.service ${D}${sysconfdir}/avahi/services
}
