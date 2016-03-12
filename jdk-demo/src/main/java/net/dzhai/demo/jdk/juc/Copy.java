package net.dzhai.demo.jdk.juc;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.util.FileCopyUtils;

import com.google.common.io.Files;

public class Copy {

	public static void main(String[] args) throws Exception {
		File s = new File("D:\\毕业设计\\聊天 bs2015JSP\\ChatRoom");
		File d = new File("D:\\毕业设计\\聊天 bs2015JSP\\ChatRoom2");
		FileUtils.copyDirectoryToDirectory(s, d);

	}
}
