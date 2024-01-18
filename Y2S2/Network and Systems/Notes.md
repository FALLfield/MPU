## Introduction to system administrator

- Essential Duties
  - **User account management**
  - **Hardware management**
    - Capacity planning
    - Inventory
    - Hardware evaluation and purchase
    - Adding and removing hardware Configuration
    - Cabling, wiring, etc
    - Device driver installation
    - System configuration and settings
  - **Perform file system backups, restores**
    - Disk and backup media capacity planning
    - Performance, network and system impact
    - Disaster recovery
      - Onsite / Offsite
      - Periodic testing
      - Multiple copies
  - **Install and configure new software and services**
    - Evaluation of software
    - Downloading and building
    - Installation
    - Maintenance of multiple versions
    - Security
    - Patches and updates
    - User notification, documentation
  - **Keep systems and services operating**
    - System monitoring
      - Hardware and devices functioning and operational
      - Capacity, Security, System logs
    - Troubleshooting
      - Troubleshooting is the process of identifying and resolving problems or
        issues that occur in various systems, machines, devices, or processes.
      - Problem discovery, diagnosis, and resolution
  - **Mantain documentation**
    - Local Documentation
      - Administrative policies and procedures
        - Backup media locations
        - Hardware
          - Location
          - Description, configuration, connections
        - Software
          - Install media (or download location)
          - Installation, build, and configuration details
          - Patches installed
      - Acceptable use policies
  - **Audit security**
    - System logging and audit facilities
    - Unexpected or unauthorized use detection
    - Monitoring of security advisories
  - Help users, performance tuning, and more
- Why we use Linux on Server Operating System
  - Need to use some OS to make ideas concrete
  - Linux is popular, free, and usable on personal machines, but also handles
    large-scale services
- What is GNU

  - GNU is an extensive collection of free software, which can bre used as an
    operating system or can be used in parts with operating systems

- Kernel, GNU, Application and System are 4 different things
- Linux is extremely conigurable and includes thousands of programs. As a
  result, different varieties of Linux havee arisen to sreve different needs and
  tastes.
- What is Operating system?
  - Components
    - Motherboard
    - Processor
  - Typical operating system functions
    - Memory management
    - Managing multitasking
    - Managing multiple users
    - Process management
    - Interprocess communication
    - Device management
    - Error handling and logging

## Chapter2 Booting and System Management Daemons

- BIOS

  - Basic input / ouput system

    - BIOS是计算机系统中的基本输入/输出系统（Basic Input/Output
      System）的缩写。它是存在于计算机主板上的固件，负责在计算机启动时进行硬件初始化和自检，并提供一些基本的低级功能。

    BIOS的主要功能包括以下几个方面：

        1. 硬件初始化：当计算机启动时，BIOS负责初始化和检测主板上的各种硬件设备，包括处理器、内存、硬盘驱动器、显卡等。它会验证硬件设备是否正常工作，并将其准备好供操作系统使用。
        2. 启动顺序：BIOS确定了计算机的启动顺序。在计算机启动时，BIOS会按照预设的顺序检查每个可启动设备，例如硬盘、光盘驱动器、USB设备等，以寻找可引导的操作系统。
        3. CMOS设置：BIOS存储了计算机的基本配置信息，这些信息存储在CMOS（Complementary Metal-Oxide-Semiconductor）芯片中。通过BIOS设置程序，用户可以访问和修改这些配置，例如日期和时间、启动顺序、硬件参数等。

- Boot process
  - Main steps
    - Finding, loading, and running **bootstrapping code**
      - During bootStrapping, the kernel is loaded into memory and begins to
        execute
    - Finding, loading, and running the **OS kernel**
      - Kernel is like a connection between system and hardware
    - Running startup **scripts and system daemons**
    - Maintaining process hygiene and managing system state transitions``
- GRUB: The Grand Unified Boot Loader
  - Stage 1
    - After the BIOS/UEFI POST section, BIOS/UEFI searches the attached disks
      for a boot record, which is loacted in the Master Boot Record
    - The **bootstrap code**, that is GRUB stage1, is very small which is 446
      bytes, it must fit into the first 512-byte sector on the hard drive along
      with the partition table.
  - Stage 1.5
    - The purpose of stage1 is to load stage 1.5
    - The stage 1.5 of GRUB must be located in the space between the boot record
      and the UEFI partition data and the first partition on the driver
  - Stage 2
    - All of the files for GRUB stage 2 are located in the /boot/grub directory
      and its subfiretories
    - Multiple files are used for configuring GRUB's menu, and some of these
      files are stored under the /etc/grub.d/ directory, such as following
      - 00_header
        - Sets the default values for some general GRUB variables such as
          graphics mode, default selection, timeouts, and so on
      - 10_linux
        - Helps to find all the kernels on the root device of the current
          operating system, and automatically creates associated GRUB entries
          for all the kernels it finds
      - 30_os-prober
        - Automatically probes for other operating systems that might be
          installed on the system. Especially useful in dual-boot
          systems(Windows running with Linux, for example)
      - 40_custom
        - Where users can edit and store custom menu entries and directives
