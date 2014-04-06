package commandows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File {
	public File(String[] args) throws IOException {
		Path source = null;
		try {
			source = Paths.get(args[0]);
			System.out.println(source.toAbsolutePath());
			System.out.println(Files.exists(source));
			System.out.println(Files.probeContentType(source.toAbsolutePath()));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}