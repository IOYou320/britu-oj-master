package com.britu.oj.rest.backend;

import com.github.pagehelper.PageInfo;
import com.britu.oj.common.RestResponseEnum;
import com.britu.oj.entity.Competition;
import com.britu.oj.entity.User;
import com.britu.oj.request.CompetitionRequest;
import com.britu.oj.response.RestResponseVO;
import com.britu.oj.service.CompetitionProblemService;
import com.britu.oj.service.CompetitionService;
import com.britu.oj.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author m969130721@163.com
 * @date 19-3-10 下午3:39
 */
@Controller("backendCompetitionController")
@RequestMapping("/backend/competition")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private CompetitionProblemService competitionProblemService;

    /**
     * 跳转到比赛编辑页面
     * @return
     */
    @RequestMapping("/competitionEditPage")
    public String competitionEditPage(HttpServletRequest request,
                                      @RequestParam(required = false) Integer compId){

        //set data
        request.setAttribute("competitionManagerActive",true);
        request.setAttribute("competitionEditActive",true);
        Competition competition = competitionService.getById(compId).getData();
        if (competition == null) {
            competition = new Competition();
        }
        request.setAttribute("competition",competition);;
        return "backend/competition/competition-edit";

    }

    /**
     * 跳转到比赛页面
     * @return
     */
    @RequestMapping("/competitionListPage")
    public String competitionListPage(HttpServletRequest request){

        //set data
        request.setAttribute("competitionManagerActive",true);
        request.setAttribute("competitionActive",true);
        return "backend/competition/competition-list";

    }


    /**
     * 获取比赛到页面
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    @RequestMapping("/list2Page")
    @ResponseBody
    public RestResponseVO<PageInfo> list2Page(@RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "20") Integer pageSize,
                                              @RequestParam(defaultValue = "") String keyword){

        return competitionService.listCompetitionVO2Page(pageSize,pageNum,keyword);
    }

    /**
     * 增加-更新
     * @param competitionRequest
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public RestResponseVO save(CompetitionRequest competitionRequest,
                               @AuthenticationPrincipal UserDetails userDetails){
        User user = (User) userDetails;
        if (user == null) {
            return RestResponseVO.createByErrorEnum(RestResponseEnum.UNAUTHORIZED);
        }

        competitionRequest.setUserId(user.getId());
        Competition competition = new Competition();
        BeanUtil.copyPropertiesIgnoreNull(competitionRequest, competition);
        if (competitionRequest.getId() != null) {
            return competitionService.updateById(competition);
        } else {
            return competitionService.insert(competition);
        }
    }

    /**
     * 删除
     * @param compId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public RestResponseVO delete(Integer compId){
        return competitionService.delById(compId);
    }





}
