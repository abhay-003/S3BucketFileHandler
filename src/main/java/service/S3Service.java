package service;

import java.io.File;
import java.io.FileOutputStream;

import s3config.s3configuration;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

public class S3Service {
	private final s3configuration s3configuration;

	public S3Service() {
		this.s3configuration = new s3configuration();
	}

	public void uploadfile(String filepath, String Key) {
		try {
			File file = new File(filepath);
			if (!file.exists() || !file.isFile()) {
				System.out.println("❌ File does not exist: " + filepath);
				return;
			}
			System.out.println("Uploading file... please wait.");
			s3configuration.getS3Client().putObject(
					PutObjectRequest.builder().bucket(s3configuration.getbucketname()).key(Key).build(),
					RequestBody.fromFile(file));
			System.out.println("UPLOAD done SUCCESSFULL");

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public void downloadFile(String key, String destination) {
		try {
			System.out.println("Downloading file... please wait.");
			GetObjectRequest getrequest = GetObjectRequest.builder().bucket(s3configuration.getbucketname()).key(key)
					.build();

			byte[] bytes = s3configuration.getS3Client().getObjectAsBytes(getrequest).asByteArray();

			File file = new File(destination);
			try (FileOutputStream fos = new FileOutputStream(file)) {
				fos.write(bytes);
			}
			System.out.println("DOWNLOAD done SUCCESSFULL");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
