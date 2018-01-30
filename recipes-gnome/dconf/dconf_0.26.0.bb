SUMMARY = "configuation database system"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

inherit gnomebase gsettings
SRC_URI[archive.md5sum] = "7fc3cb1cf22d904d8744bd12e9c9d3dd"
SRC_URI[archive.sha256sum] = "8683292eb31a3fae31e561f0a4220d8569b0f6d882e9958b68373f9043d658c9"

GNOME_COMPRESS_TYPE = "xz"

DEPENDS = "glib-2.0"

inherit vala

SRC_URI += "file://0001-add-dconf-extra-neoflx-api.patch"

EXTRA_OECONF += "--disable-man --disable-editor"

FILES_${PN} += " \
	${datadir}/dbus-1 \
	${libdir}/gio/modules/*.so \
	${datadir}/bash-completion \
"
FILES_${PN}-dbg += "${libdir}/gio/modules/.debug/libdconfsettings.so"
