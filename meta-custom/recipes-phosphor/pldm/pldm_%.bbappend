FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://host_eid \
    file://sensor_pdr.json \
"
EXTRA_OEMESON += "-Dtransport-implementation=af-mctp"

do_install:append() {
    install -m 0644 ${UNPACKDIR}/host_eid ${D}${datadir}/pldm/
    install -m 0644 ${UNPACKDIR}/sensor_pdr.json ${D}${datadir}/pldm/pdr/
}
