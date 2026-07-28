FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://aspeed-ast2500-custom-board.dts \
            "

do_configure:append() {
    install -m 0644 \
        ${UNPACKDIR}/aspeed-ast2500-custom-board.dts \
        ${S}/arch/arm/boot/dts/aspeed/
}
