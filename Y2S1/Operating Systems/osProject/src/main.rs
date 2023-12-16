mod dir_info;
mod dir_size;
mod find_files;
mod find_string;

use clap::{App, Arg};

fn main() {
    let matches = App::new("Command Line Tool")
        .arg(
            Arg::with_name("query")
                .required(true)
                .index(1)
                .possible_values(&["dir_size", "dir_info", "find_files", "find_string"])
                .help("Command to execute"),
        )
        .arg(
            Arg::with_name("file_path")
                .required(true)
                .index(2)
                .help("Path to the file"),
        )
        .arg(
            Arg::with_name("string")
                .required(false)
                .index(3)
                .help("String to search"),
        )
        .get_matches();

    let query = matches.value_of("query").unwrap();
    let file_path = matches.value_of("file_path").unwrap();
    let s = matches
        .value_of("string")
        .unwrap_or("SJnjandfiaufiafbaehyifbiwi*&&^R^&^1bnn1b");

    //println!("The command is {}", query);
    //println!("The file path is {}", file_path);

    match query.as_ref() {
        "dir_size" => dir_size::dir_size(file_path),
        "dir_info" => dir_info::dir_info(file_path),
        "find_files" => find_files::find_files(file_path, s),
        "find_string" => find_string::find_string(file_path, s),
        _ => println!("Invalid command!"),
    } //Match different queries

    //let contents = fs::read_to_string(file_path).expect("Should have been able to read the file");

    //println!("The content is \n{contents}");
}
