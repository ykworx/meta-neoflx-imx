SUMMARY = "configuation database system"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

inherit gnomebase gsettings
SRC_URI[archive.md5sum] = "20e062b793a5c0de31c4be312a91422f"
SRC_URI[archive.sha256sum] = "5011982b2b81c531f557d2abed215bb78223b6e75f0c92aaf6b73d3c8aa711d1"
GNOME_COMPRESS_TYPE = "xz"

DEPENDS = "glib-2.0"

inherit vala

EXTRA_OECONF += "--disable-man --disable-editor"

FILES_${PN} += " \
	${datadir}/dbus-1 \
	${libdir}/gio/modules/*.so \
	${datadir}/bash-completion \
"
FILES_${PN}-dbg += "${libdir}/gio/modules/.debug/libdconfsettings.so"
