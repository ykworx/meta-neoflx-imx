SUMMARY = "NeoFLX10 RootFS Skeleton"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://environment \
		   file://init.sh \
		   file://restart.sh \
		   file://setfixip.sh \
		   file://turnoff.sh \
		   file://user"

do_install () {
	install -d ${D}/NeoFLX
	install -d ${D}/NeoFLX/usr
	install -d ${D}/NeoFLX/usr/bin
	install -d ${D}/NeoFLX/system
	install -d ${D}/NeoFLX/system/factory.d
	install -d ${D}/NeoFLX/images
	install -d ${D}/FLIR
	install -d ${D}/home/root/.config/dconf
	ln -sf ../../NeoFLX/images ${D}/FLIR/images

	install -m 0755 ${WORKDIR}/init.sh ${D}/NeoFLX/system
	install -m 0755 ${WORKDIR}/restart.sh ${D}/NeoFLX/system
	install -m 0755 ${WORKDIR}/setfixip.sh ${D}/NeoFLX/system
	install -m 0755 ${WORKDIR}/turnoff.sh ${D}/NeoFLX/system
	install -m 0644 ${WORKDIR}/environment ${D}/NeoFLX/system
	install -m 0644 ${WORKDIR}/user ${D}/home/root/.config/dconf
	install -m 0644 ${WORKDIR}/user ${D}/NeoFLX/system/factory.d
}

FILES_${PN} += "/NeoFLX"
FILES_${PN} += "/FLIR"
FILES_${PN} += "/home"
