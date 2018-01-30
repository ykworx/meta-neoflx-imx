FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += " \
	file://0001-neoflx-support-for-MDS-Technology-NeoFLX-boards.patch \
	file://0002-neoflx-support-for-uEnv.txt-on-booting.patch \
    file://uEnv.txt \
	"

S = "${WORKDIR}/git"

UENV_FILENAME ?= "uEnv-${MACHINE}.txt"

deploy_uenv () {
    install ${WORKDIR}/uEnv.txt ${DEPLOYDIR}/${UENV_FILENAME}
}

do_deploy[postfuncs] += "deploy_uenv"

