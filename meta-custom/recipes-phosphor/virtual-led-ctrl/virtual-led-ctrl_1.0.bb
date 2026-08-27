SUMMARY = "Virtual LED Controller"
DESCRIPTION = "A D-Bus server to control virtual LED via GPIO"

LICENSE  = "MIT"
LIC_FILES_CHKSUM = "file://COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "git://github.com/WilsonLi69/virtual-led-ctrl;branch=main;protocol=https \
           file://virtual-led-ctrl.service \
           file://0001-Modify-virtual-led-pin-to-GPIOB7.patch \
           "

SRCREV = "4f25467695630dd7c395020fa19387d89dba031e"

S = "${WORKDIR}/git"

DEPENDS = " \
    sdbusplus \
    boost \
    libgpiod \
"

inherit meson pkgconfig systemd

SYSTEMD_SERVICE:${PN} = "virtual-led-ctrl.service"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/virtual-led-ctrl.service ${D}${systemd_system_unitdir}/
}
