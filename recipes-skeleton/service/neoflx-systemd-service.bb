SUMMARY = "NeoFLX10 D-Bus(Session)"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit systemd

SRC_URI += "file://neoflx-base.service \
			file://neoflx-core.service \
			file://neoflx-ui.service \
			file://neoflx-rtsp.service \
			file://neoflx-modbus.service \
			file://neoflx-modbus-rtu.service \
			file://neoflx-opcua.service"

do_install_append () {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/neoflx-base.service ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/neoflx-core.service ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/neoflx-ui.service ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/neoflx-rtsp.service ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/neoflx-modbus.service ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/neoflx-modbus-rtu.service ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/neoflx-opcua.service ${D}${systemd_unitdir}/system
}

SYSTEMD_SERVICE_${PN} = "neoflx-base.service \
						 neoflx-core.service \
						 neoflx-ui.service \
						 neoflx-rtsp.service \
						 neoflx-modbus.service \
						 neoflx-modbus-rtu.service \
						 neoflx-opcua.service"
