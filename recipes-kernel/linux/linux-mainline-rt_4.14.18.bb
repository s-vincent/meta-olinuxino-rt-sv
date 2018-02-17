SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|sun50i)"

inherit kernel

require recipes-kernel/linux/linux.inc

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/linux-${PV}"
	
SRC_URI[md5sum] = "e4604a84ea2b1f2162f40b7a3080239b"
SRC_URI[sha256sum] = "866a94c1c38d923ae18e74b683d7a8a79b674ebdfe7f40f1a3be9a27d39fe354"

SRC_URI = "https://www.kernel.org/pub/linux/kernel/v4.x/linux-${PV}.tar.xz \
           file://patch-4.14.18-rt15.patch \
           file://defconfig \
          "
