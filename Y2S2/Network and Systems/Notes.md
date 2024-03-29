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
  - Load the Linux kernel
    - The kernels are located in the `boot` directory, along with an initial RAM
      disk image and symbol maps
    - After the selected kernel is loaded into meomry by GRUB and begins
      executing, it must first extract irself from the compressed version of the
      file before it can preform any useful work

- Linux Startup
  - **System management daemons**
    - Spontaneous processes
      - Once the kernel has been loaded and has completed its initialization
        process, it creates a complement of "Spontaneous" processes in user
        space
      - They are not configurable, and they don't require administrative
        attention
    - The `init` process
      - `init` has multiple functions, but it's overarching goal is to make sure
        **the system runs the right complement of services and daemons at any
        given time.**
      - Many Modes to serve this goal
        - Single-user mode
        - Multi-user mode
        - Server mode
      - `init` takes care of many different startup chores
        - Setting the name of computer
        - Setting the time zone
        - CHecking disks with `fsck`
        - Mounting file-systems
        - Removing old files from the `/temp` directory
        - Configuring network interface
        - Configuring packet filters
        - Starting other daemons and network services
    - `Systemd`
      - `systemd` is not a single daemon but a collection of programs, daemons,
        libraries, technologies, and kernel components
      - The things, or objects that systemd manages are called **units**, and
        they form the buidlign blocks of systemd
      - These objects can include services or daemons, devices, file system
        entities such as mount points, and so on.
  - Units
    - **Units are named as their configuration files**
      - The configuration files are normally stored under:
        `/etc/systemd/system/`
      - The _standard unit_ configuration files are stored under the
        `/lib/systemd/system`
      -

## Chapter 3 Basic Linux Environment

- CLI vs. GUI2

  - The linux CLI is a nonrestrictive interface it places no limits on how you
    use it
  - A graphcial user interface (GUI) is by definition a very restrictive
    interface

- CLI

  - The linux CLI is a nonrestrictive interface it places no limits on how you use it
  - CLI terminology
    - Command Prompt:
      - The command prompt is a string of characters with cursor which may be flashing and waiting - prompting - you to enter a command
    - Command line:
      - The line on the terminal that contains the commadn prompts and any commadn you enter
    - Command line interface
      - Any text user interface to the linux operating system that allows the user to type commands and see the results as textual output
    - Command
      - Command are what you type on the command line in order to tell linux what you want it to do for you.

- Terminal

  - Refer to terminal emulator software that performs interaction with a mainframe or Unix host
  - Console
  - Virtual Console
  - Session
    - Session is the term that can apply to different things, and yet it retains essentially the same meaning.
  - Shell
    - A shell is the command interpreter for the operating system.
    - Types:
      - Bash, csh, ksh, tcsh, zsh

- Important Linux Commands
  - PWD
    - PWD means present working directory
  - ## Directory Path Notation Styles
  - More commands
    - dmesg
      - Displays the messages generated by Linux during the initial boot process.
    - date
      - Display today's date
    - cal
      - Display a calender for the current month
    - info
      - learn all of the individual programs that comprise the GNU utilities with the info command

## Chapter 4 Managing Users and Groups

- Linux/Unix was designed from the ground up to be a multi-user operating system. And this brings us to the topic of managing users in Linux

- Some regulations

  - Under Linux, every file and program must be owned by a user
  - Each user ahs a unique identifier called a _User ID_
  - Each user must belongs to at least one _group_ - a collection of users
  - User may belong to multiple groups
  - Group also have unique identifiers, called _group IDs_
  - Accessiblility of a file or program is based on its UIDs and GIDs
  - Each user's rights can be defined in one of two ways: as those of a normal user or a _superuser_

- Where User information is kept

  - The `/etc/passwd/` file stores the user's login, encrypted password entry, UID, default GID, name, home directory, and login shell
  - It contains Username Field and Password Field
  - It also contains User ID Field and Group ID Field
  - It also contains GECOS(General Electric Comprehensive Operating System) and Directory
  - Shell stores user's default shell
  - `/etc/shadow` File
    - The file is the encrypted password file that stores the encrypted password information for user accounts
  - `/etc/group` File
    - THe file contains a list of groups, with one group per line. Each group entry in the file has four standard files, each colon-delimited, as in the passwd and shadow files.

- User management Tools
  - Some of the most popular command-line tools
    - `useradd`: allows you to add a single user to the system
    - `userdel`: removes existing user
    - `usermod`: allows you to modify an existing user in the system
    - `groupadd`: the group-related commands are similar to the user commands; they work on groups listed in the `/etc/group` file
    - `groupadd`: the group-related commands are similar to the user commands; they work on groups listed in the /etc/group file
    - `groupdel`: delete the existing file
    - `groupmod`: allows you to modify the parameters of an existing group

## Chapter 5 process control

- Process: a process represents a running program (instantiation of program)
  - From the kernel's perspective, a process is
    - An address space
    - Set of data structures
      - The process's address space map, Current status, Execution priority, Resources used, Signal mask, The owner, The files and network ports has opened.
  - To create a new process, an existing process copies itself with the fork system call

## File system

- The file system cna be thought of as comprising five main components

  - Data Storage: A structured place to store and retrieve data; this is the primary function of any file system.
  - A namespace: a way to name things and organize them in the hierarchy
  - An API: a set of system calls for navigating and manipulating file system objects
  - Security models: schemes for protecting, hiding, and sharing things
  - AN implementation: software to tie the logical model to the hardware.

- Disk partitions

  - Drive are be divided into one or more partitions that are teated independently
  - Normally has root partition, swap, user, boot
  - **LVM** lets you combine partitions and drives to present an aggregate volume as a regular block device(just like a disk or partition)

- Some commands related to files
  - `hdparm` will do simple performance tests
  -
