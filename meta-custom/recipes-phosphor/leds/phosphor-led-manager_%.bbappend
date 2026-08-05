# SUMMARY = "Phosphor LED Group Management Configuration for custom board"
# PR = "r1"
# LICENSE = "Apache-2.0"
# LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
#
# inherit native
#
# PROVIDES += "virtual/phosphor-led-manager-config-native"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://led-group-config.json"

# PACKAGECONFIG:append = " use-lamp-test"
# S = "${WORKDIR}/sources"
# UNPACKDIR = "${S}"

do_install:append() {
    # SRC=${S}
    # DEST=${D}${datadir}/phosphor-led-manager
    # install -D ${SRC}/led.yaml ${DEST}/led.yaml
    install -m 0644 ${UNPACKDIR}/led-group-config.json ${D}${datadir}/phosphor-led-manager/
}
