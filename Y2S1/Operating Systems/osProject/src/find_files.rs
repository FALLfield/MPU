use std::fs;

pub fn find_files(file_path: &str, pattern: &str) {
    let mut count = 0;
    if let Ok(entries) = fs::read_dir(file_path) {
        //Read the file and return an Iterator trait
        for entry in entries.flatten() {
            //Use flatten to flatten the nested interators
            let path = entry.path();
            if path.is_file()//Judge if the path is a file or not
                && path
                    .file_name()//Get the name
                    .unwrap()//Option<&OsStr> to &OsStr
                    .to_str()//Turn the &OsStr to Option<&str>
                    .unwrap()//Turn into &str
                    .contains(pattern)
            //Judge
            {
                println!("The file's location is {} ", path.display());
                count = count + 1;
            }
            if path.is_dir() {
                find_files(&path.to_string_lossy(), pattern); //Recursively allocate
            }
        }
    }
    if count == 0 {
        println!("There is no {} in this file path: {}", pattern, file_path);
    }
}
