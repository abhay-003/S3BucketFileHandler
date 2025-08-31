package aws.S3FileUpload;

import java.util.Scanner;

import service.S3Service;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		S3Service service = new S3Service();
		while(true){
			System.out.println("Choose an operation.....");
			System.out.println("1. Upload file to s3.");
			System.out.println("2. Download file from s3.");
			System.out.println("3. exit");
			System.out.println("> ");
			String choice = scanner.nextLine();
			
			switch (choice) {
			case "1":
				System.out.println("enter file path to upload.");
				String uploadpath = scanner.nextLine();
				System.out.println("enter object key(file name in s3).");
				String uploadkey = scanner.nextLine();
				service.uploadfile(uploadpath, uploadkey);
				break;
				
			case "2": 
				System.out.println("enter destination where to download a file.");
				String downloadpath = scanner.nextLine();
				System.out.println("enter objest key to download(file name in s3).");
				String downloadkey = scanner.nextLine();
				service.downloadFile(downloadpath, downloadkey);
				break;
				
			case "3": 
				System.out.println("bye:::");
				scanner.close();
				return;

			default:
				System.out.println("Invalid option. Try again.");
				break;
			}

		}
	}
}
