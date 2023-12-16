# Instruction of file os


## *Introduction*
- The small project has 4 functions: `dir_size, dir_info, find_files, find_string`.
- You can use the 4 functions to do some basic operations with files like checking bytes and so on.

## *Hot to use*
Open your cmd or powershell and use cd to the file you want.

Ensure the osProject.exe is in the directory.
```rust
./osProject function_name file_path string
//example
./osProject dir_size aaa.txt
//This statement returns aaa.txt's bytes
```

## *Some limitations*

- TUI implementation has some problems, the popular TUI API of Rust is ratatui, it is kind of difficult and I tried a few times find that I can not handle it.
That's why I just use command line
- When you want to do the 4 operations, make sure .exe file is in the father directory. 
