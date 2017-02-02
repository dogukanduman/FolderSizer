package com.donovan.foldersizer;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

class FolderTraverse extends SimpleFileVisitor<Path> {
	List<File> fileList;
	Path path;

	FolderTraverse(Path path) {
		this.path = path;
		fileList = new ArrayList<File>();
		try {
			Files.walkFileTree(path, EnumSet.noneOf(FileVisitOption.class), 1, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<File> getFileList() {
		return fileList;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
		if (attr.isDirectory()) {
			try {
				long size = getDirSize(file);

				fileList.add(new File(file.getFileName().toString(), size, "Folder", file));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (attr.isRegularFile()) {
			fileList.add(new File(file.getFileName().toString(), attr.size(), "File", file));
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) {
		System.err.println(exc);
		return FileVisitResult.CONTINUE;
	}

	private long getDirSize(Path dirPath) throws IOException {
		final AtomicLong size = new AtomicLong(0L);

		Files.walkFileTree(dirPath, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				size.addAndGet(attrs.size());
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
				return FileVisitResult.CONTINUE;
			}
		});

		return size.get();
	}
}
