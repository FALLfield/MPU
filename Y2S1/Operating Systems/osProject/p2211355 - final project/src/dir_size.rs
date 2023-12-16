use std::fs::File;
use std::io::Read;

pub fn dir_size(file_path: &str) {
    fn dir_size_recursive(file: &mut File, total_size: u64) {
        //Set the tail recursive
        let mut buffer = [0u8; 4096]; //Build a buffer to store the txt

        match file.read(&mut buffer) {
            Ok(bytes_read) if bytes_read > 0 => {
                dir_size_recursive(file, total_size + (bytes_read) as u64)
            }
            Ok(_) => println!("The file's bytes are {}", total_size),
            Err(error) => eprintln!("Error reading the file: {}", error),
        }
    }
    let mut file = match File::open(file_path) {
        Ok(file) => file,
        Err(error) => {
            eprintln!(
                "Can not open the file, please check your file format. Error: {}",
                error
            );
            return;
        }
    }; //If the programm can't open the file, print error information
    dir_size_recursive(&mut file, 0) //Do tail recursive function
}
