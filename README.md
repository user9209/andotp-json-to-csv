# Json to CSV converter for andOTP-plaintext-backup

Converts plaintext backup of 2FA-App [andOTP](https://f-droid.org/de/packages/org.shadowice.flocke.andotp/) to a CSV file to allow you to create a paper backup!

### Run:

````
java -jar TotpJsonConverter-all.jar <json-file-andOtp-plaintext> [<csv-filename> [<csv-separator> [c]]] 
````

### Parameters:

- \<json-file-andOtp-plaintext\> = Input file: plaintext backup file andOTP. 
- \<csv-filename\> = Output file: csv file: Default: "<json-file-andOtp-plaintext>.csv" OR "c" = console-only
- \<csv-separator\> = csv separator: Default: "\t"
- c   = add console output additional to file output

### Dependencies:

- com.google.code.gson  
 License [Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0.txt)