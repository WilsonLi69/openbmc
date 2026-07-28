FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://aspeed-ast2500-custom-board.dts \
            file://0001-Add-custom-board-dtb-into-compile-list.patch \
            "

do_configure:append() {
    install -m 0644 \
        ${UNPACKDIR}/aspeed-ast2500-custom-board.dts \
        ${S}/arch/arm/boot/dts/aspeed/
}
