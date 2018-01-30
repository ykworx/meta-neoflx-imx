DESCRIPTION = "Paho MQTT - user libraries for the MQTT and MQTT-SN protocols"
DESCRIPTION = "Client implementation of open and standard messaging protocols for Machine-to-Machine (M2M) and Internet of Things (IoT)."
HOMEPAGE = "http://www.eclipse.org/paho/"
SECTION = "console/network"
LICENSE = "EPL-1.0 | EDL-1.0"

LIC_FILES_CHKSUM = " \
        file://edl-v10;md5=3adfcc70f5aeb7a44f3f9b495aa1fbf3 \
        file://epl-v10;md5=659c8e92a40b6df1d9e3dccf5ae45a08 \
"

SRC_URI = "git://github.com/eclipse/paho.mqtt.embedded-c.git"
SRCREV = "1e7c3371142985a282bc1089ce4385297eb53640"

S = "${WORKDIR}/git"

PARALLEL_MAKE = ""

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}${libdir}
    oe_libinstall -C build/output -so libpaho-embed-mqtt3c  ${D}${libdir}
#    install -d ${D}${includedir}
#    install -m 644 src/MQTTAsync.h ${D}${includedir}
#    install -m 644 src/MQTTClient.h ${D}${includedir}
#    install -m 644 src/MQTTClientPersistence.h ${D}${includedir}
}

DEPENDS = "openssl"
RDEPENDS_${PN} = "openssl"
