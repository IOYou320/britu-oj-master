package com.britu.oj.service;

import com.britu.oj.response.RestResponseVO;
import com.britu.oj.response.TestcaseVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.TreeSet;

/**
 * @author m969130721@163.com
 * @date 19-1-17 下午1:30
 */
public interface FileService {

    RestResponseVO uploadImageByMD(MultipartFile multipartFile, String guid, String username);

    RestResponseVO<String> uploadImage(MultipartFile multipartFile,String username);

    RestResponseVO<byte[]> get(String path);

    void getTestcaseInput(HttpServletResponse response,String problemId, Integer num);

    void getTestcaseOutput(HttpServletResponse response, String problemId, Integer num);

    RestResponseVO<String> deleteTestcase(String problemId);

    RestResponseVO<String> saveTestcase(String problemId,Integer num,String testcaseInput, String testcaseOutput);

    RestResponseVO<TreeSet<TestcaseVO>> listTestcaseVO(String problemId);

    RestResponseVO deleteTestcase(String problemId, Integer num);
}
