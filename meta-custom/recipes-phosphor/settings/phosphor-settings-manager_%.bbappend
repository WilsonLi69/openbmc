FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://boot_progress.override.yml"

do_configure:prepend() {
    cp ${UNPACKDIR}/boot_progress.override.yml ${S}/
}
