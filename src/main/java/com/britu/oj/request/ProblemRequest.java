package com.britu.oj.request;

import com.britu.oj.response.TestcaseVO;
import lombok.Data;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 19-5-8 下午5:45
 */
@Data
public class ProblemRequest {

    private String id;

    private String name;

    private String content;

    private String htmlContent;

    private String inputDesc;

    private String outputDesc;

    private String testcaseInput;

    private String testcaseOutput;

    private Integer level;

    private Long time;

    private Long memory;

    private Integer flag;

    private String tags;

    private List<TestcaseVO> testcaseList;

    private boolean settingUpdated = false;


}
