package org.gecko.framework.ent.controller;


import org.apache.commons.lang3.StringUtils;
import org.gecko.common.utils.GeckoProperties;
import org.gecko.common.utils.ReflectUtil;
import org.gecko.common.utils.UuidUtil;
import org.gecko.core.annotations.GeckoAuthority;
import org.gecko.core.mybatis.page.Page;
import org.gecko.framework.base.BaseController;
import org.gecko.framework.model.R;
import org.gecko.framework.ent.entity.EntApplication;
import org.gecko.framework.ent.entity.EntEntbasic;
import org.gecko.framework.ent.entity.enums.ApplicationType;
import org.gecko.framework.ent.entity.enums.AuditingStatus;
import org.gecko.framework.ent.entity.enums.EntType;
import org.gecko.framework.ent.service.EntApplicationService;
import org.gecko.framework.ent.service.EntEntbasicService;
import org.gecko.framework.notice.entity.MgNotice;
import org.gecko.framework.system.entity.Account;
import org.gecko.framework.system.service.AccountService;
import org.gecko.framework.utils.GenerateIdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * ENT_ENTBASIC控制器
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-01-08 16:26:47
 *
 */
@Controller
@RequestMapping("/ent/ententbasic")
public class EntEntbasicController extends BaseController<EntEntbasic> {

	@Autowired
	public EntEntbasicService service;
	@Autowired
	public AccountService accountService;
	@Autowired
	public EntApplicationService applicationService;
	/**
	 * index
	 * 打开首页
	 * @param  model    设定文件
	 * @return String   返回类型
	 */
	@RequestMapping("/index")
	public String index(Model model) {
		return "";
	}

	/**
	 * 企业的页面展示

	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/entListView")
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_ENT_ENT_ENTBASIC_QUERY"})
	public ModelAndView entListView(){
		ModelAndView mad = new ModelAndView("/views/ent/ententbasic/ententbasic.jsp");
		return mad;
	}

	/**
	 * 待审核企业的页面展示

	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/entAuditListView")
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_ENT_ENT_ENTBASIC_QUERY"})
	public ModelAndView entAuditListView(){
		ModelAndView mad = new ModelAndView("/views/ent/ententbasic/entauditbasic.jsp");

		return mad;
	}

	/**
	 * 数据列表
	 * @param page 分页设置

	 * @return R返回类型
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_ENT_ENT_ENTBASIC_QUERY"})
	public List<EntEntbasic> list(Page<EntEntbasic> page, HttpServletRequest request)throws IOException, ParseException {
        EntEntbasic param = new EntEntbasic();
		String creditcode = request.getParameter("creditcode");
		String entname = request.getParameter("entname");
		if(null!=entname && !"".equals(entname)){
			entname = new String(entname.getBytes("iso-8859-1"), "utf-8");
		}
		if(!("".equals(creditcode))){
			param.setCreditcode(creditcode);
		}
		if(!("".equals(entname))){
			param.setEntname(entname);
		}
		page = service.likeByPage(param, page);
		List<EntEntbasic> entBasics = page.getRows();
		List<EntEntbasic> entBasicShows = new ArrayList<EntEntbasic>();
		for (Iterator iterator = entBasics.iterator(); iterator.hasNext();) {
			EntEntbasic entEntbasic = (EntEntbasic) iterator.next();
			/**所属行政区划的查询**/
			entEntbasic.setTemp1("");
			AuditingStatus status = entEntbasic.getStatus();
			if(null!=status){
				entEntbasic.setTemp2(status.getValue());
			}
			entBasicShows.add(entEntbasic);
		}
		return entBasicShows;
	}
	/**
	 * 修改企业状态/审核企业状态
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/editStatus")
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_ENT_ENT_ENTBASIC_QUERY"})
	public ModelAndView editStatus(HttpServletRequest request,HttpSession session){
		//String path = request.getRequestURI();
		Account acct = (Account) session.getAttribute(GeckoProperties.SESSION_KEY);
		ModelAndView mad = new ModelAndView("/views/ent/ententbasic/ententbasic.jsp");
		String status = request.getParameter("entStatus");
		String entId = request.getParameter("editEntId");
		if(!org.springframework.util.StringUtils.isEmpty(status)){
			EntEntbasic entBasic = service.get(entId);
			entBasic.setAuditor(acct.getId());
			entBasic.setLastupdatetime(GenerateIdUtils.getCurrentSqlDate());
			if("ON".equals(status)){
				entBasic.setStatus(AuditingStatus.ON);
			}else if("UN".equals(status)){
				entBasic.setStatus(AuditingStatus.UN);
			}
			service.update(entBasic);
			/**如果审核通过，分配账号**/
			if("ON".equals(status)){
				if(entBasic!=null){
					Account account = new Account();
					account.setId(get32UUID());
					account.setRealName(entBasic.getEntname());
					account.setPrincipal(entId);
					account.setCredential("123456");
					accountService.save(account);
				}
			}
		}
		
		return mad;
	}
	
	/**
	 * 企业审核数据列表
	 * @param page 分页设置

	 * @return R返回类型
	 */
	@RequestMapping(value = "/auditlist", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_ENT_ENT_ENTBASIC_QUERY"})
	public List<EntEntbasic> auditlist(Page<EntEntbasic> page, HttpServletRequest request)throws IOException, ParseException {
		EntEntbasic param = new EntEntbasic();
		String creditcode = request.getParameter("creditcode");
		String entname = request.getParameter("entname");
		String status = request.getParameter("status");
		if(!("".equals(creditcode))){
			param.setCreditcode(creditcode);
		}
		if(!("".equals(entname))){
			param.setEntname(entname);
		}

		//待审核的企业
		param.setStatus(AuditingStatus.NE);
		List<EntEntbasic> entBasics = service.likeByPage(param, page).getRows();
		List<EntEntbasic> entBasicShows = new ArrayList<EntEntbasic>();
		for (Iterator iterator = entBasics.iterator(); iterator.hasNext();) {
			EntEntbasic entEntbasic = (EntEntbasic) iterator.next();
			AuditingStatus status1 = entEntbasic.getStatus();
			if(null!=status1){
				entEntbasic.setTemp2(status1.getValue());
			}
			entBasicShows.add(entEntbasic);
		}
		return entBasicShows;

	}

	/**
	 *
	 * @param @param id 唯一ID
	 * @param id 唯一ID
	 * @return R  返回类型
	 */
	@RequestMapping(value = "/get/{id}", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_ENT_ENT_ENTBASIC_VIEW"})
	public R get(@PathVariable String id) {
		EntEntbasic ententbasic = service.get(id);
		return R.ok().put(ententbasic);
	}

    @RequestMapping("/edit")
    @ResponseBody
    @GeckoAuthority(codes = {"GECKO_ENT_ENT_ENTBASIC_EDIT"})
    public R updateField(@RequestParam("name") String name, @RequestParam("value") String value, @RequestParam("pk") String pk) {
        R r = R.error();
        if (service.updateField(name, value, pk) > 0) {
            r = R.ok();
        }
        return r;
    }

	/**
	 * 根据ID列表批量删除对象
	 * @param ids 唯一ID列表
	 * @return R 返回类型
	 */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_ENT_ENT_ENTBASIC_DELETE"})
	public R delete(@RequestBody String[] ids) {
		service.batchDelete(ids);
		return R.ok();
	}

	/**
     * save 保存对象
     * @param entity
     * @return R返回类型
     */
	@RequestMapping(value = "/save", method = RequestMethod.PUT)
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_ENT_ENT_ENTBASIC_NEW", "GECKO_ENT_ENT_ENTBASIC_EDIT"})
	public R save(@RequestBody EntEntbasic entity) {
        R r = new R();
		if(null != entity.getId() && StringUtils.isNoneBlank(String.valueOf(entity.getId()))) {
			service.update(entity);
            r = R.ok();
		} else {
            if (org.springframework.util.StringUtils.isEmpty(entity.getId())) {
                entity.setId(UuidUtil.get32UUID());
                ReflectUtil.fillsProperty(entity);
            }
			r.put(service.save(entity));
		}
		return r;
	}
	/**
	 *	企业信息查看
	 */
	@RequestMapping(value = "/entInfoView")
	public ModelAndView entInfoView(HttpServletRequest request) {
		String entId = request.getParameter("entId");
		
		EntEntbasic entBasic = service.get(entId);
		
		ModelAndView mad = new ModelAndView("/views/ent/ententbasic/entInfoView.jsp");
		
		mad.addObject("entBasic", entBasic);
		
		return mad;
	}
	
	/**
	 * export  导出数据
	 * @param ids 唯一ID列表
	 * @return R返回类型
	 */
	@RequestMapping(value = "/export/{ids}", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_ENT_ENT_ENTBASIC_EXPORT"})
	public R export(@PathVariable String[] ids) {
		return R.ok();
	}
}