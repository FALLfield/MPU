use std::fs::File;
use std::io::{self, BufRead};

pub fn find_string(file_path: &str, s: &str) {
    let file = match File::open(file_path) {
        Ok(file) => file,
        Err(error) => {
            eprintln!("Can not open the file! {}", error);
            return;
        }
    };

    let reader = io::BufReader::new(file);
    let mut count = 0;

    for (line_number, line) in reader.lines().enumerate() {
        let line = match line {
            Ok(line) => line,
            Err(error) => {
                eprintln!("Error reading line: {}", error);
                continue;
            }
        };
        if line.contains(s) {
            println!("Line {}: {}", line_number + 1, line);
            count = count + 1;
        }
    }
    if count == 0 {
        println!("There is no {} in this {} ", s, file_path);
    }
}
