# Copyright (C) 2017 MDS Technology co, LTD.

include recipes-kernel/linux/linux-imx.inc
include recipes-kernel/linux/linux-dtb.inc
	 
SUMMARY = "MDS Technology 3.14.yy LTS kernel based on linux-fscl"
DESCRIPTION = "Linux kernel that is based on the Linux-fslc 3.14-1.1.x-imx \
branch with optimize support for MDS Technology hardware."

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "3.14-1.1.x-imx"
LOCALVERSION = "-mdstec"
SRCREV = "621fc298bd7242d284b49d40f8fda7f46dc524cc"
 
SRC_URI = "git://github.com/Freescale/linux-fslc.git;branch=${SRCBRANCH} \
           file://defconfig \
           file://imx6q-neoflx10.dts \
           file://imx6q-neoflx10-som-v15.dts \
           file://imx6qdl-solidrun-microsom-ar8035.dtsi \
		   file://imx6qdl-solidrun-microsom.dtsi \
		   file://imx6qdl-solidrun-microsom-v15.dtsi \
           file://imx6qdl-neoflx.dtsi \
           file://imx6qdl-neoflx-som-v15.dtsi \
           file://0001-neoflx-Add-support-for-neoflx-board.patch \
		   "

do_compile_prepend() {
		cp ${WORKDIR}/*.dts* \
		${S}/arch/${ARCH}/boot/dts
}
							 
COMPATIBLE_MACHINE = "(neoflx)"

