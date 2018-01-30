DESCRIPTION = "A console-only image that includes gstreamer packages and \
Freescale's multimedia packages (VPU and GPU) when available for the specific \
machine."

IMAGE_FEATURES += "\
    ${@base_contains('DISTRO_FEATURES', 'x11', 'x11-base', '', d)} \
"

LICENSE = "MIT"

require neoflx-image-base.bb
inherit populate_sdk_qt5

PREFEREREED_VERSION_v4l2loopback-mod = "0.9.1"
PREFEREREED_VERSION_libmodbus = "3.1.4"

#PACKAGECONFIG_append_pn-qtbase = " accessibility gles2 openssl"
CORE_IMAGE_EXTRA_INSTALL += "\
	kernel-module-uvcvideo \
	v4l2loopback-mod \
	bash bash-completion \
	openssl openssh-sftp-server openssh-sftp \
	connman connman-client \
	fbset i2c-tools v4l-utils imx-lib \
	e2fsprogs-resize2fs tzdata \
	libmodbus dconf \
	paho-mqtt-embedded-c json-c \
	packagegroup-fsl-gstreamer1.0-full \
	gstreamer1.0-rtsp-server \
	packagegroup-fsl-tools-gpu \
	packagegroup-qt5-base \
	packagegroup-qt5-fonts \
	packagegroup-qt5-graphics \
	qtquickcontrols-qmlplugins \
	neoflx-systemd-service flir-avahi neoflx-rootfs \
	${@base_contains('DISTRO_FEATURES', 'directfb', 'packagegroup-core-directfb', '', d)} \
	${@base_contains('DISTRO_FEATURES', 'x11', '', \
			base_contains('DISTRO_FEATURES', 'wayland', \
				'weston weston-init weston-examples \
				gtk+3-demo clutter-1.0-examples', '', d), d)} \
"
CORE_IMAGE_EXTRA_INSTALL_remove_mx6sl = "clutter-1.0-examples"
