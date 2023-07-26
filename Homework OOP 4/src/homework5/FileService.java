package homework5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileService {
	public static long copyFile(File fileIn, File fileOut) throws IOException {

		try (InputStream is = new FileInputStream(fileIn); OutputStream os = new FileOutputStream(fileOut)) {
			return is.transferTo(os);
		}
	}

	public static long copyFolderWithExtension(File folderIn, File folderOut, String extension) throws IOException {
		File[] files = folderIn.listFiles();
		long fileCopy = 0L;
		for (File file : files) {
			if (file.isFile() && isMatchingExtension(file, extension)) {
				File fileOut = new File(folderOut, file.getName());
				copyFile(file, fileOut);
				fileCopy += 1;
			}
		}
		return fileCopy;
	}

	private static boolean isMatchingExtension(File file, String extension) {
		String fileName = file.getName();
		int index = fileName.lastIndexOf('.');
		if (index > 0) {
			String ext = fileName.substring(index);
			return extension.equals(ext);
		}
		return false;
	}

}
