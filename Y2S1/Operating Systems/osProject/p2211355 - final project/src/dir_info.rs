use std::fs;

pub fn dir_info(file_path: &str) {
    let mut file_count = 0;
    let mut dir_count = 0;

    match fs::read_dir(file_path) {
        Ok(entries) => {
            for entry in entries {
                if let Ok(entry) = entry {
                    let path = entry.path();

                    if path.is_file() {
                        file_count += 1;
                    } else if path.is_dir() {
                        dir_count += 1;
                        dir_info(&path.to_string_lossy());
                    }
                }
            }
            println!("Number of files in {}: {}", file_path, file_count);
            println!("Number of directories in {}: {}", file_path, dir_count);
        }
        Err(error) => eprintln!("Error to count files and directories: {}", error),
    }
}
