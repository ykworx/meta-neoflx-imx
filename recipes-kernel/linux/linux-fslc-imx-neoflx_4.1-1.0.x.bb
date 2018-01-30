# Copyright (C) 2015, 2016 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

include recipes-kernel/linux/linux-imx.inc
include recipes-kernel/linux/linux-dtb.inc

SUMMARY = "MDS Technology 4.1-1.0.x-imx kernel based on linux-fslc"
DESCRIPTION = "Linux kernel that is based on the Linux-fslc 4.1-1.0.x-imx \
branch with optimize support for MDS Technology hardware."

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "4.1-1.0.x-imx"
LOCALVERSION = "-fslc-mdstec"
SRCREV = "2fa70a90615bbe3d56edc24b8950af0b801d7ad7"

SRC_URI = "git://github.com/Freescale/linux-fslc.git;branch=${SRCBRANCH} \
           file://defconfig \
           file://imx6q-neoflx10.dts \
           file://imx6q-neoflx10-som-v15.dts \
           file://imx6qdl-solidrun-microsom-ar8035.dtsi \
		   file://imx6qdl-solidrun-microsom.dtsi \
		   file://imx6qdl-solidrun-microsom-v15.dtsi \
           file://imx6qdl-neoflx.dtsi \
           file://imx6qdl-neoflx-som-v15.dtsi \
           file://0001-neoflx-add-support-for-neoflx-board.patch \
		   "

do_compile_prepend() {
		cp ${WORKDIR}/*.dts* \
		${S}/arch/${ARCH}/boot/dts
}

COMPATIBLE_MACHINE = "(neoflx)"
