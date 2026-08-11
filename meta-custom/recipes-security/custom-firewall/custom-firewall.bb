SUMMARY = "Custom iptables firewall rules"
LICENSE = "CLOSED"

inherit systemd

SRC_URI = " \
    file://firewall.sh \
    file://custom-firewall.service \
"

RDEPENDS:${PN} = "iptables"

SYSTEMD_SERVICE:${PN} = "custom-firewall.service"

FIREWALL_WHITELIST_IP ?= "192.168.1.100"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${UNPACKDIR}/firewall.sh ${D}${bindir}/

    sed -i -e "s/@@WHITELIST_IP@@/${FIREWALL_WHITELIST_IP}/g" ${D}${bindir}/firewall.sh

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/custom-firewall.service ${D}${systemd_system_unitdir}/
}
