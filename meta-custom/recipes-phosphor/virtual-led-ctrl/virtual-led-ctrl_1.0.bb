SUMMARY = "Virtual LED Controller"
DESCRIPTION = "A D-Bus server to control virtual LED via GPIO"

LICENSE  = "MIT"
LIC_FILES_CHKSUM = "file://COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
    git://github.com/WilsonLi69/virtual-led-ctrl;branch=main;protocol=https \
    file://virtual-led-ctrl.service \
"

SRCREV = "9911905452e1f0d3164d42552b2c1b91db0c3b04"

S = "${WORKDIR}/git"

DEPENDS = " \
    sdbusplus \
    phosphor-dbus-interfaces \
    libgpiod \
"

inherit meson pkgconfig systemd

SYSTEMD_SERVICE:${PN} = "virtual-led-ctrl.service"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/virtual-led-ctrl.service ${D}${systemd_system_unitdir}/
}
