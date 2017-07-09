package com.alastair.jmeter.parser.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.alastair.jmeter.parser.model.ContentRow;

public class FileWriterService {

	public void writeToFile(List<ContentRow> result) throws IOException {
		File outputFile = new File("Summary.log");
		try (FileWriter fileWriter = new FileWriter(outputFile, false)) {
			fileWriter.write("Label, Count, Average\r\n");
			result.stream().map(Object::toString).forEach(t -> {
				try {
					fileWriter.write(t);
					fileWriter.write("\r\n");
				} catch (IOException e) {
					e.printStackTrace();
					throw new IllegalStateException("Could not write to " + outputFile.getAbsolutePath());
				}
			});
		}
	}

}
