SUMMARY = "Virtual LED Controller"
DESCRIPTION = "A D-Bus server to control virtual LED via GPIO"

LICENSE  = "MIT"
LIC_FILES_CHKSUM = "file://COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "git://github.com/WilsonLi69/virtual-led-ctrl;branch=main;protocol=https"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit meson pkgconfig
