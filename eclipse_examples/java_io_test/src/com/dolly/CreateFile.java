package com.dolly;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* File 클래스를 이용한 파일 생성 */
public class CreateFile {

	public static void main(String[] args) {
		// 1. 파일 생성 경로 및 파일명.확장자
		String fname = "c:/filetest/newFile2.text";
		
		// 2. 파일을 다루는 File 객체 생성
		File f = new File(fname);
		
//		// 3. 생성할 파일의 존재 여부 확인
//		if (!f.exists()) {
//			// 생성할 파일이 없을 시 실행
//			System.out.println("해당 파일을 찾을 수 없습니다: " + fname);
//		}
		
		// 4. 새로운 파일 생성: newFile.txt
		// 없던 파일을 생성해내는 것이므로 예외처리 필수
		try {
			if (!f.exists()) { // 지정한 파일 존재 여부 확인
				// 생성된 파일이 없으면 실행하여 새로운 파일 생성
				f.createNewFile();
				// 생성 파일 존재 여부 확인
				System.out.println("해당 파일이 생성되었습니다: " + fname);
			}
			
			FileWriter fw = new FileWriter(f);
			fw.write("호호호~");
			fw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	} // main() END

} // CreateFile END
