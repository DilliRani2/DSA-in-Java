Multi-Threaded Log Analyzer:

This is a simple Java mini-project I built using IntelliJ IDEA.
The program reads multiple .txt log files from a folder and analyzes them using multithreading.
Each thread processes one file and counts how many times the keywords INFO, WARN, and ERROR appear.

The final result is shown on the console and also saved in a file named result.txt.

🚀 Features:

Works with any folder containing .txt log files
Uses multi-threading for faster processing
Counts occurrences of:
INFO
WARN
ERROR
Saves final results to result.txt

Runs smoothly in IntelliJ IDEA

📌 How to Run (IntelliJ IDEA):

Open IntelliJ IDEA
Create a new Java project
Copy the code into your project
Run the program
When asked, enter the folder path that contains your .txt log files

Example:
C:/Users/YourName/Desktop/logs

📁 Sample Folder Structure
logs/├── log1.txt

     ├── log2.txt
     
     ├── log3.txt

📝 Output

You will see:

Thread names processing each file
Final keyword counts
Total execution time
A result.txt file will also be created with the same results.

🎯 Purpose of This Project:

This project helped me understand:
How multithreading works in Java
How to use ExecutorService
How to handle file reading with multiple threads  
How to manage shared data safely using ConcurrentHashMap
